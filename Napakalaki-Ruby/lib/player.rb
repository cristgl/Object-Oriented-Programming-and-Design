# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame

require_relative 'card_dealer'
require_relative 'dice'
require_relative 'combat_result'

class Player
 
  def initialize(n)
    @pendingBadConsequence=nil
    @enemy=nil
    @hiddenTreasures = Array.new(0)
    @visibleTreasures = Array.new(0)
    @@MAXLEVEL =10
    @level=1
    @name=n
    @dead = true
    @canISteal = true
  end  

  attr_reader :MAXLEVEL
  
  private
  def bringToLife
    @dead=false
  end
  def incrementLevels(i)
    if(@level=@level+i)>@@MAXLEVEL then
      @level=@@MAXLEVEL
    end
    @level
  end
  def decrementLevels(i)
    if (@level=@level-i)<1 then
      @level=1
    end
    @level
  end
  def setPendingBadConsequence(bcons)
    @pendingBadConsequence=bcons
  end
  def applyPrize(mons)
    nLevels=mons.getLevelsGained
    incrementLevels(nLevels)
    nTreasures=mons.getTreasuresGained
    if(nTreasures>0)
      dealer=CardDealer.instance
      for i in 1..nTreasures
        treasure=dealer.nextTreasure
        @hiddenTreasures << treasure
      end
    end
  end
  def canMakeTreasureVisible(tr)
    like_this=howManyVisibleTreasures(tr.getType)
    
    if(tr.getType == TreasureKind::BOTHHANDS)
      can=(like_this<1 && howManyVisibleTreasures(TreasureKind::ONEHAND)<1)
    else if(tr.getType == TreasureKind::ONEHAND)
           can=(like_this<2 && howManyVisibleTreasures(TreasureKind::BOTHHANDS)<1)
         else
          can=like_this<1;
         end
    end
    can
  end
  def howManyVisibleTreasures(tKind)
    num=0
    @visibleTreasures.each do|t|
      if (tKind == t.getType) 
        num=num+1
      end
    end
    num
  end
  def dieIfNoTreasures
    if (@visibleTreasures.size()==0 && @hiddenTreasures.size()==0) then
      @dead=true
      @level=1
    end
  end 
  def haveStolen
    @canISteal=false
  end
  
  public
  def copyPlayer(p)
    @pendingBadConsequence=p.pendingBadConsequence
    @enemy=p.getEnemy
    @hiddenTreasures = p.getHiddenTreasures
    @visibleTreasures = p.getVisibleTreasures
    @level=p.getLevels
    @name=p.getName
    @dead = p.isDead
    @canISteal = p.canISteal
  end
  def giveMeATreasure
    #Lo borramos de la baraja además de devolverlo
    @hiddenTreasures.delete_at(rand(@hiddenTreasures.size))
  end
 
  def getName
    @name
  end
  def isDead
    @dead
  end
  def getHiddenTreasures
    @hiddenTreasures
  end
  def getVisibleTreasures
    @visibleTreasures
  end
  def combat(mons)
    myLevel=self.getCombatLevel
    monsterLevel=getOponentLevel(mons)
    if(myLevel>=monsterLevel)
      applyPrize(mons)
      if(@level>=@@MAXLEVEL)
        combR = CombatResult::WINGAME
      else
        combR = CombatResult::WIN
      end
    else
        applyBadConsequence(mons)
        combR = CombatResult::LOSE
        combR=CombatResult::LOSEANDCONVERT if (shouldConvert)
    end
    combR
  end
  def applyBadConsequence(m)
    badconsequence=m.getBadConsequence
    nLevels=badconsequence.getLevels
    decrementLevels(nLevels)
    pendingBad=badconsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
    setPendingBadConsequence(pendingBad)
  end
  def makeTreasureVisible(tr)
    canI=canMakeTreasureVisible(tr)
    if(canI)
      @visibleTreasures << tr
      @hiddenTreasures.delete(tr)
    end
  end
  def discardVisibleTreasure(tr)
     @visibleTreasures.delete(tr)
     if((@pendingBadConsequence!=nil) && (!@pendingBadConsequence.isEmpty))
       @pendingBadConsequence.substractVisibleTreasure(tr)
     end
     dieIfNoTreasures
  end
  def discardHiddenTreasure(tr)
     @hiddenTreasures.delete(tr)
     if((@pendingBadConsequence!=nil) && (!@pendingBadConsequence.isEmpty))
       @pendingBadConsequence.substractHiddenTreasure(tr)
     end
     dieIfNoTreasures
  end
  def validState
    if(@pendingBadConsequence==nil)
      out=@hiddenTreasures.size<=4
    else
      out=(@hiddenTreasures.size<=4 && @pendingBadConsequence.isEmpty)
    end
    out
  end
  def initTreasures
    dealer=CardDealer.instance
    dice=Dice.instance
    bringToLife
    treasure=dealer.nextTreasure
    @hiddenTreasures << treasure
    number=dice.nextNumber
    if(number>1)
      treasure=dealer.nextTreasure
      @hiddenTreasures << treasure
    end
    if(number==6)
      treasure=dealer.nextTreasure
      @hiddenTreasures << treasure
    end
  end
  def getLevels
    @level
  end
  def stealTreasure
    canI=self.canISteal
    treasure=nil
    if(canI)
      canYou=@enemy.canYouGiveMeATreasure
      if(canYou)
        treasure=@enemy.giveMeATreasure
        @hiddenTreasures << treasure
        haveStolen
      end
    end
    treasure
  end
  def setEnemy(enemy)
    @enemy= enemy
  end
  def canISteal
    (@canISteal && @enemy.canYouGiveMeATreasure)
  end
  def discardAllTreasures
    for i in 1..@visibleTreasures.size
      self.discardVisibleTreasure(@visibleTreasures.first)
    end
    for j in 1..@hiddenTreasures.size
      self.discardHiddenTreasure(@hiddenTreasures.first)
    end
  end
  def to_s
      "#{@name}, nivel = #{@level}, mal rollo = \n #{@badcons.to_s}\n buen rollo = #{@prize.to_s}"
  end 
  def canISteal
    @canISteal
  end
  def getEnemy
    @enemy
  end
  protected
  def canYouGiveMeATreasure
    @hiddenTreasures.size()>0
  end
  def getOponentLevel(m)
    m.getCombatLevel
  end
  def shouldConvert
    dice=Dice.instance
    dice.nextNumber==1
  end
  def getCombatLevel
    suma=0
     @visibleTreasures.each do |t|
      suma=suma+t.getBonus
    end
    suma + @level
  end
  
  def pendingBadConsequence
    @pendingBadConsequence
  end

end

end