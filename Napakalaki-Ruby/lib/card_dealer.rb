#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame

require_relative 'treasure'
require_relative 'treasure_kind'
require_relative 'cultist'
require_relative 'bad_consequence'
require_relative 'numeric_bad_consequence'
require_relative 'specific_bad_consequence'
require_relative 'death_bad_consequence'
class CardDealer
  def initialize
    @unusedMonsters=Array.new(0)
    @usedMonsters=Array.new(0)
    @unusedTreasures=Array.new(0)
    @usedTreasures=Array.new(0)
    @unusedCultists=Array.new(0)
  end
  
  @@instance=nil
  
  def self.instance
    if(@@instance==nil)
      @@instance = new
    end
    @@instance
  end
 
  
  private_class_method :new 
 
  private 
  def initTreasureCardDeck()
        @unusedTreasures << Treasure.new("¡Si mi amo!", 4, TreasureKind::HELMET)
        @unusedTreasures << Treasure.new("Botas de investigacion", 3, TreasureKind::SHOES)
        @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3, TreasureKind::HELMET)
        @unusedTreasures << Treasure.new("A prueba de babas", 2, TreasureKind::ARMOR)
        @unusedTreasures << Treasure.new("Botas de lluvia acida", 1, TreasureKind::BOTHHANDS)
        @unusedTreasures << Treasure.new("Casco minero",  2, TreasureKind::HELMET)
        @unusedTreasures << Treasure.new("Ametralladora Thompson", 4,TreasureKind::BOTHHANDS)
        @unusedTreasures << Treasure.new("Camiseta de la UGR", 1, TreasureKind::ARMOR)
        @unusedTreasures << Treasure.new("Clavo de rail ferroviario", 3, TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("Cuchillo de sushi arcano",  2, TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("Fez alopolo", 3, TreasureKind::HELMET)
        @unusedTreasures << Treasure.new("Hacha prehistorica", 2, TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4,TreasureKind::ARMOR)
        @unusedTreasures << Treasure.new("Gaita", 4, TreasureKind::BOTHHANDS)
        @unusedTreasures << Treasure.new("Insecticida", 2, TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("Escopeta de 3 cañones", 4, TreasureKind::BOTHHANDS)
        @unusedTreasures << Treasure.new("Garabato mistico", 2, TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("La rebeca metalica",  2, TreasureKind::ARMOR)
        @unusedTreasures << Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHANDS)
        @unusedTreasures << Treasure.new("Necro-comicon",  1, TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("Necronomicon",5,TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("Linterna a 2 manos",  3, TreasureKind::BOTHHANDS)
        @unusedTreasures << Treasure.new("Necro-gnomicon", 2, TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("Necrotelecom", 2, TreasureKind::HELMET) 
        @unusedTreasures << Treasure.new("Mazo de los antiguos", 3, TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("Necro-playboycon", 3, TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("Porra preternatural", 2, TreasureKind::ONEHAND)
        @unusedTreasures << Treasure.new("Shogulador",  1,  TreasureKind::BOTHHANDS)
        @unusedTreasures << Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND) 
        @unusedTreasures << Treasure.new("Tentaculo de pega", 2, TreasureKind::HELMET)
        @unusedTreasures << Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOES)
        shuffleTreasures
  end
  
  def initMonsterCardDeck()
    premio = Prize.new(2,1)
    malrollo = SpecificBadConsequence.new("Pierdes tu armadura visible y otra oculta.",0,[TreasureKind::ARMOR], [TreasureKind::ARMOR])
   @unusedMonsters << Monster.new('3 Byakhees de bonanza',8,malrollo,premio,0)
  
    premio = Prize.new(1,1)
    malrollo = SpecificBadConsequence.new("Embobados con el lindo primigenio te descartas de tu casco visible.",0,[TreasureKind::HELMET],Array.new)
    @unusedMonsters << Monster.new("Chibithulhu",2,malrollo,premio,0)

    premio = Prize.new(1,1)
    malrollo = SpecificBadConsequence.new("El primordial bostezo contagioso. Pierdes el calzado visible.",0,[TreasureKind::SHOES],Array.new)
    @unusedMonsters << Monster.new("El sopor de Dunwich",2,malrollo,premio,0)

    premio = Prize.new(4,1) 
    malrollo = SpecificBadConsequence.new("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1  mano visible y 1 mano oculta",0,[TreasureKind::ONEHAND],  [TreasureKind::ONEHAND])
   @unusedMonsters<< Monster.new("Ángeles de la noche ibicenca", 14, malrollo,premio,0)

    premio = Prize.new(3,1)
    malrollo = NumericBadConsequence.new("Pierdes todos tus tesoros visibles.",0,5,0)
    @unusedMonsters << Monster.new("El gorrón en el umbral",10,malrollo,premio,0)

    premio = Prize.new(2,1)
    malrollo = SpecificBadConsequence.new("Pierdes la armadura visible.",0,[TreasureKind::ARMOR],Array.new(0))
    @unusedMonsters << Monster.new("H.P. Munchcraft",6,malrollo,premio,0)

    premio = Prize.new(1,1)
    malrollo = SpecificBadConsequence.new("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,[TreasureKind::ARMOR],Array.new(0)) 
    @unusedMonsters << Monster.new("Bichgooth",2,malrollo,premio,0)

    premio = Prize.new(4,2) 
    malrollo = NumericBadConsequence.new('Pierdes 5 niveles y 3 tesoros visibles',5 , 3, 0)
    @unusedMonsters << Monster.new('El rey de rosa',13,malrollo,premio,0)

    premio = Prize.new(1,1)
    malrollo = NumericBadConsequence.new("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)
    @unusedMonsters << Monster.new("La que redacta en las tinieblas",2,malrollo,premio,0)

    premio= Prize.new(2, 1)
    malrollo = DeathBadConsequence.new("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.")
    @unusedMonsters << Monster.new("Los hondos",8,malrollo,premio,0)

    premio= Prize.new(2, 1)
    malrollo = NumericBadConsequence.new("Pierdes 2 niveles y 2 tesoros ocultos.",2,0,2)
    @unusedMonsters << Monster.new("Semillas Cthulhu", 4, malrollo,premio,0)

    premio= Prize.new(2, 1)
    malrollo = SpecificBadConsequence.new("Te intentas escaquear. Pierdes una mano visible.",0,[TreasureKind::ONEHAND],Array.new(0))
    @unusedMonsters << Monster.new("Dameargo", 1, malrollo,premio,0)

    premio= Prize.new(1, 1)
    malrollo = NumericBadConsequence.new("Da mucho asquito.Pierdes 3 niveles.",3,0,0)
    @unusedMonsters << Monster.new("Pollipólipo volante", 3, malrollo,premio,0)

    premio= Prize.new(3, 1)
    malrollo = DeathBadConsequence.new("No le hace gracia que pronuncien mal su nombre. Estás muerto.")
    @unusedMonsters << Monster.new("Yskhtihyssg Goth", 12, malrollo,premio,0)

    premio= Prize.new(4, 1)
    malrollo = DeathBadConsequence.new("La familia te atrapa. Estás muerto.")
    @unusedMonsters << Monster.new("Familia feliz", 1, malrollo,premio,0)

    premio= Prize.new(1, 1)
    malrollo = SpecificBadConsequence.new("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2,[TreasureKind::BOTHHANDS],Array.new(0))
    @unusedMonsters << Monster.new("Roboggoth", 5, malrollo,premio,0)

    premio= Prize.new(1, 1)
    malrollo = SpecificBadConsequence.new("Te asusta en la noche.Pierdes un casco visible.", 0,[TreasureKind::HELMET],Array.new(0))
    @unusedMonsters << Monster.new("El espia", 5, malrollo,premio,0)

    premio= Prize.new(1, 1)
    malrollo = NumericBadConsequence.new("Menudo susto te llevas.Pierdes 2 niveles y 5 tesoros visibles.", 2,5,0)
    @unusedMonsters << Monster.new("El Lenguas", 20, malrollo,premio,0)

    premio= Prize.new(1, 1)
    malrollo = SpecificBadConsequence.new("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, [TreasureKind::ONEHAND,TreasureKind::ONEHAND,TreasureKind::BOTHHANDS], Array.new(0))
    @unusedMonsters << Monster.new("Bicefalo", 20, malrollo,premio,0)
    
     premio= Prize.new(3, 1)
    malrollo = SpecificBadConsequence.new("Pierdes 1 mano visible", 0, [TreasureKind::ONEHAND], Array.new(0))
    @unusedMonsters << Monster.new("El mal indecible impronunciable",10,malrollo,premio,-2)
    
    premio= Prize.new(2, 1)
    malrollo = NumericBadConsequence.new("Pierdes tus tesoros visibles. Jajaja", 0, 10,0)
    @unusedMonsters << Monster.new("Testigos oculares", 6, malrollo,premio,2)
    
    premio= Prize.new(2,5)
    malrollo = DeathBadConsequence.new("Hoy no es tu dia de suerte. Mueres")
    @unusedMonsters << Monster.new("El gran cthulhu", 20, malrollo,premio,4)
    
    premio= Prize.new(1, 1)
    malrollo = NumericBadConsequence.new("Tu gobierno te recorta 2 niveles.", 2,0,0)
    @unusedMonsters << Monster.new("Serpiente político", 8, malrollo,premio,-2)
    
    premio= Prize.new(1, 1)
    malrollo = SpecificBadConsequence.new("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 0,[TreasureKind::HELMET,TreasureKind::ARMOR] , [TreasureKind::ONEHAND,TreasureKind::ONEHAND,TreasureKind::BOTHHANDS])
    @unusedMonsters << Monster.new("Felpuggoth",2, malrollo,premio,5)
    
    premio= Prize.new(4,2)
    malrollo = NumericBadConsequence.new("Pierdes 2 niveles.", 2,0,0)
    @unusedMonsters << Monster.new("Shoggoth", 16, malrollo,premio,-4)
    
    premio= Prize.new(1, 1)
    malrollo = NumericBadConsequence.new("Pintalabios negro. Pierdes 2 niveles.",2,0,0)
    @unusedMonsters << Monster.new("Lolitagooth", 20, malrollo,premio,3)
    
    shuffleMonsters
  end
  def initCultistCardDeck
    @unusedCultists<< Cultist.new("Sectario",1)
    @unusedCultists<< Cultist.new("Sectario",2)
    @unusedCultists<< Cultist.new("Sectario",1)
    @unusedCultists<< Cultist.new("Sectario",2)
    @unusedCultists<< Cultist.new("Sectario",1)
    @unusedCultists<< Cultist.new("Sectario",1)
    shuffleCultists
  end
  def shuffleTreasures()
    @unusedTreasures.shuffle!
  end
  
  def shuffleMonsters()
    @unusedMonsters.shuffle!
  end
  
  def shuffleCultists
    @unusedCultists.shuffle!
  end
  public
  def nextTreasure()
    if(@unusedTreasures.size==0)
      @unusedTreasures=@usedTreasures
      @usedTreasures=Array.new
      shuffleTreasures
    end
      @unusedTreasures.shift
  end
  
  def nextMonster()
    if(@unusedMonsters.size==0)
      @unusedMonsters=@usedMonsters
      @usedMonsters=Array.new
      shuffleMonsters
    end
      @unusedMonsters.shift
  end
  def nextCultist
    @unusedCultists.shift
  end
  
  def giveTreasureBack(treasure)
    @usedTreasures << treasure
  end
  
  def giveMonsterBack(monster)
    @usedMonsters << monster
  end
  
  def initCards()
    initTreasureCardDeck
    initMonsterCardDeck
    initCultistCardDeck
  end
 end
end

