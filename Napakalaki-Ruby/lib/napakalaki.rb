# To change this license header, choose License Headers in Project Properties.

# To change this template file, choose Tools | Templates

# and open the template in the editor.
module NapakalakiGame

require_relative 'card_dealer'
require_relative 'player'
require_relative 'bad_consequence'
require_relative 'dice'
require_relative 'monster'
require_relative 'prize'
require_relative 'treasure'
require_relative 'treasure_kind'
require_relative 'cultist_player'
require_relative 'cultist'

class Napakalaki
@@instance = nil

def self.instance
 if(@@instance==nil)
      @@instance= new
 end
   @@instance
end

 
  def initialize()
    @currentPlayer=nil
    @currentMonster=nil
    @dealer=CardDealer.instance
    @players=Array.new(0)
    @currentPlayerIndex=nil
  end
  
 private_class_method :new  

  private

  def initPlayers(names)
    names.each do |jugador|
      @players << Player.new(jugador);
    end
  end

  def nextPlayer()
    if(@currentPlayer==nil)
      @currentPlayerIndex = rand(@players.size)
    else
      @currentPlayerIndex=((@currentPlayerIndex+1)%(@players.size))
      #el jugador en la posicion +1 modulo el tamaño el array al actual
    end
    @currentPlayer=@players.at(@currentPlayerIndex)
    @currentPlayer
  end

  def nextTurnIsAllowed()
    if(@currentPlayer==nil)
      out = true
    else
      out=@currentPlayer.validState
    end
    out
  end
  
  def setEnemies()
    if (@players.size >2)
    @players.each do |jugador|
      while (enemy=@players.get(rand(@players.size)))== jugador do
      end
      jugador.setEnemy(enemy)
    end 
    else
      if(@players.size==2)
        (@players.at(0)).setEnemy(@players.at(1))
        (@players.at(1)).setEnemy(@players.at(0))
      end
    end 
  end 

  public

  def developCombat
    m=@currentMonster
    c=@currentPlayer.combat(m)
    if(c==CombatResult::LOSEANDCONVERT)
      cul=@dealer.nextCultist
      @players[@currentPlayerIndex] = CultistPlayer.new(@currentPlayer,cul)
      @players.each do |p|
        if (p.getEnemy==@currentPlayer)
          p.setEnemy(@players[@currentPlayerIndex])
        end
      end
      @currentPlayer = @players.at(@currentPlayerIndex)
    end
    @dealer.giveMonsterBack(m)
    c
  end

  def discardVisibleTreasure(treasures)
    treasures.each do |treasure|
       @currentPlayer.discardVisibleTreasure(treasure)
       @dealer.giveTreasureBack(treasure)
    end
  end

  def discardHiddenTreasure(treasures)
    treasures.each do |treasure|
       @currentPlayer.discardHiddenTreasure(treasure)
       @dealer.giveTreasureBack(treasure)
    end
  end

  def makeTreasuresVisible(treasures)
          treasures.each do |t|
            @currentPlayer.makeTreasureVisible(t)
          end
  end
  
  def initGame(players)
     initPlayers(players)
     setEnemies
     @dealer.initCards
     self.nextTurn
  end
 
  def getCurrentPlayer()
    @currentPlayer
  end

  def getCurrentMonster()
    @currentMonster
  end

  def nextTurn()
    stateOK=nextTurnIsAllowed
    if(stateOK)
      @currentMonster=@dealer.nextMonster
      @currentPlayer=nextPlayer
      dead=@currentPlayer.isDead
      if(dead)
        @currentPlayer.initTreasures
      end
    end
    stateOK
  end
  
  def endOfGame(result)
    result==CombatResult::WINGAME
  end

end
end