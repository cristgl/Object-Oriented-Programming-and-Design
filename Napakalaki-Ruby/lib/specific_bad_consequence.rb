# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
class SpecificBadConsequence < BadConsequence
  def initialize(text,levels,someSpecificVisibleTreasures,someSpecificHiddenTreasures)
    super(text,levels)
    @specificVisibleTreasures=someSpecificVisibleTreasures
    @specificHiddenTreasures=someSpecificHiddenTreasures
  end
  
  def isEmpty
     (@specificHiddenTreasures.size == 0 && @specificVisibleTreasures.size == 0)
  end
  
  def substractVisibleTreasure(t)
      @specificVisibleTreasures.delete(t.getType)
  end
    
  def substractHiddenTreasure(t)
      @specificHiddenTreasures.delete(t.getType)
  end
  
  def getSpecificVisibleTreasures
    @specificVisibleTreasures
  end
  
  def getSpecificHiddenTreasures
    @specificHiddenTreasures
  end
  
  def adjustToFitTreasureLists(v,h)
    listaV=Array.new(0)
    listaH=Array.new(0)
    ajustadoV = Array.new(0)
    ajustadoH = Array.new(0)
        
    v.each do |tesoro|
      listaV << tesoro.getType
    end
    h.each do |tesoro|
      listaH << tesoro.getType
    end
        
    @specificVisibleTreasures.each do |t|
       if((indice=listaV.index(t))!=nil)
         ajustadoV << t
         listaV.delete_at(indice)
       end
    end
        
    @specificHiddenTreasures.each do |t|
      if((indice = listaH.index(t))!=nil)
        ajustadoH << t
        listaH.delete_at(indice)
      end
    end
    SpecificBadConsequence.new(@text,0,ajustadoV,ajustadoH)
  end
  
  def to_s
    out = @text+ ", pierdes #{@levels} niveles, pierdes estos tesoros visibles:\n"
    
    @specificVisibleTreasures.each do |treasure|
      out = out + treasure.to_s + " "
    end
    out= out + " y estos tesoros ocultos:\n"
    @specificHiddenTreasures.each do |treasure|
      out= out + treasure.to_s + " "
    end
    
    out     
  end
  
end
end