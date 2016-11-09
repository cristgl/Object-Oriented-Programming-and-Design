#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame

module CombatResult
    WINGAME=:wingame
    WIN=:win
    LOSE=:lose
    LOSEANDCONVERT=:loseandconvert
    
   def to_s
    out = case
      when self == WINGAME then "Eres el vencedor :D\n"
      when self == WIN then "¡Ganaste! \n"
      when self == LOSE then "¡Oh! Perdiste... \n"
      when self == LOSEANDCONVERT then "Has perdido, y ahora eres sectario.\n" 
      end
  
    out
  end
end
end