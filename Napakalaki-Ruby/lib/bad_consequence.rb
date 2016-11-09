#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
class BadConsequence
  def initialize(aText, someLevels)
    @@MAXTREASURES=10
    @text=aText
    @levels=someLevels
  end

  attr_reader :MAXTREASURES, :text
  
  def getLevels
     @levels
  end
  #Metodos abstractos
  def substractVisibleTreasure(t)
  end
  
  def substractHiddenTreasure(t)  
  end
  
  def isEmpty
  end
  
  def adjustToFitTreasureLists(v,h)
  end
  
  def to_s
  end

  
#  def substractVisibleTreasure(t)
#    if(@nVisibleTreasures==-1)
#      @specificVisibleTreasures.delete(t.getType)
#    else
#      if(@nVisibleTreasures>0)
#        @nVisibleTreasures=@nVisibleTreasures-1
#      end
#    end
#    
#  end
  
#  def substractHiddenTreasure(t)
#    if(@nHiddenTreasures==-1)
#      @specificHiddenTreasures.delete(t.getType)
#    else
#      if(@nHiddenTreasures>0)
#        @nHiddenTreasures = @nHiddenTreasures - 1
#      end
#    end
#  
#  end
   
  
#  def adjustToFitTreasureLists(v,h)
#    if(!@death)
#      if(@nHiddenTreasures!=-1 && @nVisibleTreasures!=-1)
#          a_quitarV = @nVisibleTreasures>v.size() ? v.size() : @nVisibleTreasures
#          a_quitarH = @nHiddenTreasures>h.size() ? h.size() : @nHiddenTreasures
#          out=BadConsequence.newLevelNumberOfTreasures(@text,0,a_quitarV,a_quitarH)
#      else
#        listaV=Array.new(0)
#        listaH=Array.new(0)
#        ajustadoV = Array.new(0)
#        ajustadoH = Array.new(0)
#        
#        v.each do |tesoro|
#          listaV << tesoro.getType
#        end
#        h.each do |tesoro|
#          listaH << tesoro.getType
#        end
#        
#        @specificVisibleTreasures.each do |t|
#          if((indice=listaV.index(t))!=nil)
#            ajustadoV << t
#            listaV.delete_at(indice)
#          end
#        end
#        
#        @specificHiddenTreasures.each do |t|
#          if((indice = listaH.index(t))!=nil)
#            ajustadoH << t
#            listaH.delete_at(indice)
#          end
#        end
#        out=BadConsequence.newLevelSpecificTreasures(@text,0,ajustadoV,ajustadoH)
#      end
#    else
#      out=BadConsequence.newLevelNumberOfTreasures(@text,0,v.size,h.size)
#    end
#    out
#  end
  
#  def self.newLevelNumberOfTreasures (aText, someLevels,someVisibleTreasures, someHiddenTreasures)
#    new(aText, someLevels,someVisibleTreasures, someHiddenTreasures,Array.new,Array.new,false)
#  end
#  
#  def self.newLevelSpecificTreasures (aText, someLevels,someSpecificVisibleTreasures, someSpecificHiddenTreasures)
#    new(aText, someLevels,-1,-1,someSpecificVisibleTreasures, someSpecificHiddenTreasures,false)
#  end
#  
#  def self.newDeath (aText)
#     new(aText, 0,-1,-1,Array.new,Array.new,true)
#  end
# 

#    def to_s
#      out = @text
#      if @death
#        out = out + ", Estas muerto."
#      else
#        out = out + ", pierdes #{@levels} niveles"
#        if(@nVisibleTreasures >= 0 && @nHiddenTreasures>=0 )
#        out =out + ", pierdes #{@nVisibleTreasures} tesoros visibles y #{@nHiddenTreasures} tesoros ocultos"
#        else
#        out= out + ", pierdes estos tesoros visibles:\n"
#        @specificVisibleTreasures.each do |treasure|
#          out = out + treasure.to_s + " "
#        end
#        out= out + "Y estos tesoros ocultos:\n"
#        @specificHiddenTreasures.each do |treasure|
#          out= out + treasure.to_s + " "
#        end
#        end
#    end
#    out     
#  end
end
end