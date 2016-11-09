# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
class NumericBadConsequence < BadConsequence
  def initialize(text,levels,someVisibleTreasures,someHiddenTreasures)
    super(text,levels)    
    @nVisibleTreasures=someVisibleTreasures
    @nHiddenTreasures=someHiddenTreasures    
  end
  
  def isEmpty
    (@nHiddenTreasures==0 && @nVisibleTreasures==0)
  end
  
  def substractVisibleTreasure(t)
    if(@nVisibleTreasures>0)
      @nVisibleTreasures=@nVisibleTreasures - 1
    end
  end
  
  def substractHiddenTreasure(t)
    if(@nHiddenTreasures>0)
      @nHiddenTreasures = @nHiddenTreasures - 1
    end 
  end
  
  def getNVisibleTreasures
    @nVisibleTreasures
  end
  
  def getNHiddenTreasures
    @nHiddenTreasures
  end
  
  def adjustToFitTreasureLists(v,h)
    a_quitarV = @nVisibleTreasures>v.size() ? v.size() : @nVisibleTreasures
    a_quitarH = @nHiddenTreasures>h.size() ? h.size() : @nHiddenTreasures
    NumericBadConsequence.new(@text,0,a_quitarV,a_quitarH)
  end
  
  def to_s
    out = @text
    out = out + ", pierdes #{@levels} niveles"
    if(@nVisibleTreasures >= 0 && @nHiddenTreasures>=0 )
      out =out + ", pierdes #{@nVisibleTreasures} tesoros visibles y #{@nHiddenTreasures} tesoros ocultos"
    end
    out     
  end
  
end
end

