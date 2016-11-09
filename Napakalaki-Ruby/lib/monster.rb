#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame

require_relative 'prize.rb'
require_relative 'bad_consequence.rb'

class Monster
  def initialize(name,level,bc,prz,ic)
      @levelChangeAgainstCultistPlayer=ic
      @name=name
      @combatLevel=level
      @badcons=bc
      @prize=prz 
  end
  
  
  def getName
    @name
  end
  
  def getCombatLevel
    @combatLevel
  end
  
  def getCombatLevelAgainstCultistPlayer
    @combatLevel+@levelChangeAgainstCultistPlayer
  end
  
  def getBadConsequence
    @badcons
  end
  
  def getLevelsGained()
    @prize.getLevels
  end
       
  def getTreasuresGained() 
    @prize.getTreasures
  end
  
  def to_s
      "#{@name}, nivel = #{@combatLevel}, mal rollo = \n #{@badcons.to_s}\n buen rollo = #{@prize.to_s}"
  end
  
  end
end