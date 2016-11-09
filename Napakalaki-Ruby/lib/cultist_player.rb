# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  class CultistPlayer < Player
    @@totalCultistPlayers=0
    def initialize(player,c)
      copyPlayer(player)#CONSTRUCTOR DE COPIA
      @myCultistCard=c
      @@totalCultistPlayers=@@totalCultistPlayers+1
    end
    def self.getTotalCultistPlayers
      @@totalCultistPlayers
    enddef canYouGiveMeATreasure
      (getVisibleTreasures).size()>0
    end
    protected
    def getCombatLevel
      com=super
      (com+(com*0.2)+(@@totalCultistPlayers*@myCultistCard.getGainedLevels)).round
    end
    def getOponentLevel(m)
      m.getCombatLevelAgainstCultistPlayer
    end
    def shouldConvert
      false
    end
    def giveMeATreasure
      (getVisibleTreasures).delete_at(rand((getVisibleTreasures).size))
    end
    def canYouGiveMeATreasure
      (getVisibleTreasures).size()>0
    end
  end
end
