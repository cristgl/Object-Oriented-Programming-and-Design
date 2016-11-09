#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame

module TreasureKind
     ARMOR=:armor
     HELMET=:helmet
     ONEHAND=:onehand
     BOTHHANDS=:bothhands
     SHOES=:shoes
     
  def to_s
    out = case
    when self == ARMOR then "Armadura \n"
    when self == HELMET then "Casco \n"
    when self == ONEHAND then "Arma de una mano \n"
    when self == BOTHHANDS then "Arma de dos manos \n"
    when self == SHOES then "Zapatos \n"
    end
  
    out
  end

end
end