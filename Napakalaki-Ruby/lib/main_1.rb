##encoding: utf-8
## To change this license header, choose License Headers in Project Properties.
## To change this template file, choose Tools | Templates
## and open the template in the editor.
#module NapakalakiGame
#
#
#  require_relative 'prize.rb'
#  require_relative 'bad_consequence.rb'
#  require_relative 'monster.rb'
#  require_relative 'treasure_kind.rb'
#  require_relative 'player.rb'
#  require_relative 'mood.rb'
#  #require_relative 'card_dealer.rb'
#  
#monsters= Array.new()
#
#premio = Prize.new(2,1)
#malrollo = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta.",0,[TreasureKind::ARMOR], [TreasureKind::ARMOR])
#monsters << Monster.new('3 Byakhees de bonanza',8,malrollo,premio)
#  
#premio = Prize.new(1,1)
#malrollo = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible.",0,[TreasureKind::HELMET],[])
#monsters << Monster.new("Chibithulhu",2,malrollo,premio)
#  
#premio = Prize.new(1,1)
#malrollo = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible.",0,[TreasureKind::SHOES],[])
#monsters << Monster.new("El sopor de Dunwich",2,malrollo,premio)
#  
#premio = Prize.new(4,1) 
#malrollo = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1  mano visible y 1 mano oculta",0,[TreasureKind::ONEHAND],  [TreasureKind::ONEHAND])
#monsters<< Monster.new("Ángeles de la noche ibicenca", 14, malrollo,premio)
#  
#premio = Prize.new(3,1)
#malrollo = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles.",0,5,0)
#monsters << Monster.new("El gorrón en el umbral",10,malrollo,premio)
#
#premio = Prize.new(2,1)
#malrollo = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible.",0,[TreasureKind::ARMOR],[])
#monsters << Monster.new("H.P. Munchcraft",6,malrollo,premio)
#  
#premio = Prize.new(1,1)
#malrollo = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,[TreasureKind::ARMOR],[]) 
#monsters << Monster.new("Bichgooth",2,malrollo,premio)
#  
#premio = Prize.new(4,2) 
#malrollo = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 tesoros visibles',5 , 3, 0)
#monsters << Monster.new('El rey de rosa',13,malrollo,premio)
#  
#premio = Prize.new(1,1)
#malrollo = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)
#monsters << Monster.new("La que redacta en las tinieblas",2,malrollo,premio)
#
#premio= Prize.new(2, 1)
#malrollo = BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.")
#monsters << Monster.new("Los hondos",8,malrollo,premio)
#
#premio= Prize.new(2, 1)
#malrollo = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos.",2,0,2)
#monsters << Monster.new("Semillas Cthulhu", 4, malrollo,premio)
#
#premio= Prize.new(2, 1)
#malrollo = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible.",0,[TreasureKind::ONEHAND],[])
#monsters << Monster.new("Dameargo", 1, malrollo,premio)
#
#premio= Prize.new(1, 1)
#malrollo = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito.Pierdes 3 niveles.",3,0,0)
#monsters << Monster.new("Pollipólipo volante", 3, malrollo,premio)
#
#premio= Prize.new(3, 1)
#malrollo = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estás muerto.")
#monsters << Monster.new("Yskhtihyssg Goth", 12, malrollo,premio)
#
#premio= Prize.new(4, 1)
#malrollo = BadConsequence.newDeath("La familia te atrapa. Estás muerto.")
#monsters << Monster.new("Familia feliz", 1, malrollo,premio)
#
#premio= Prize.new(1, 1)
#malrollo = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2,[TreasureKind::BOTHHANDS],[])
#monsters << Monster.new("Roboggoth", 5, malrollo,premio)
#
#premio= Prize.new(1, 1)
#malrollo = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche.Pierdes un casco visible.", 0,[TreasureKind::HELMET],[])
#monsters << Monster.new("El espia", 5, malrollo,premio)
#
#premio= Prize.new(1, 1)
#malrollo = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas.Pierdes 2 niveles y 5 tesoros visibles.", 2,5,0)
#monsters << Monster.new("El Lenguas", 20, malrollo,premio)
#
#premio= Prize.new(1, 1)
#malrollo = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, [TreasureKind::ONEHAND,TreasureKind::ONEHAND,TreasureKind::BOTHHANDS], [])
#monsters << Monster.new("Bicefalo", 20, malrollo,premio)
#
#monsters.each do |cont|
#    if cont.getCombatLevel>10
#      puts cont.to_s
#    end
#  end
#  
#monsters.each do |cont|
#  if cont.getBadConsequence.getLevels>0
#    puts cont.to_s
#  end
#end
#
#monsters.each do |cont|
#  if cont.getLevelsGained>1
#    puts cont.to_s
#  end
#end
#
#monsters.each do |cont|
#  if (cont.getBadConsequence.getSpecificHiddenTreasures.size > 0 || cont.getBadConsequence.getSpecificVisibleTreasures.size > 0)
#    puts cont.to_s
#  end
#end
#
##player1 = Player.new("jugador1")
##player2 = Player.new("jugador2")
##
##player1.addFriend(Monster.new("Bicefalo", 20, malrollo,premio))
##player2.addFriend(Monster.new("El espia", 5, malrollo,premio))
##m= Mood.new;
##e = Mood.new;
##player1.addMood(m)
##player2.addMood(e)
##
##puts player1.getCombatLevel
##puts player2.getCombatLevel
#end