# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame

class Treasure
  def initialize(n,bons,tK)
    @name=n
    @bonus=bons
    @tKind=tK
  end
  
  def getName
    @name
  end
  def getBonus
    @bonus
  end
  def getType
    @tKind
  end
  
  def to_s
      "#{@name}, bonus = #{@bonus}, tipo = \n #{@tKind.to_s}\n}"
  end
end
end
