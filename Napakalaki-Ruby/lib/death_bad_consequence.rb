#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'player'
module NapakalakiGame
class DeathBadConsequence < NumericBadConsequence
  def initialize(text)
    super(text,10,0,0)
  end
 
  def adjustToFitTreasureLists(v,h)
     NumericBadConsequence.new(@text,0,v.size,h.size)
  end
  
  def to_s
    out = @text
    if @death
      out = out + ", estas muerto."
    end
    out     
  end
  
end
end