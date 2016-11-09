/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Laura
 */
public class CardDealer {
    private static CardDealer instance = null;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultists;
    // Compo el constructor es privado no se puede crear ningun objeto
    // nuevo
    private CardDealer() { 
        unusedMonsters= new ArrayList();
        usedMonsters= new ArrayList();
        unusedTreasures =new ArrayList();
        usedTreasures= new ArrayList();
        unusedCultists=new ArrayList();
    }
    public static CardDealer getInstance() {
        if(instance==null){
            instance= new CardDealer();
        }
        return instance;
    }
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Si mi amo!",4,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigacion",3,TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha Cthulhu",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco Minero",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR",1,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",4,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrocomicón",1,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón",5,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos",3,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrognomicón",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycón",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("¡Tentáculo de pega",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos",1,TreasureKind.SHOES));

        this.shuffleTreasures();

    }
    private void initMonsterCardDeck(){
        BadConsequence badcons;
        Prize prize;

        // 3 BYAKHEES DE BONANZA
        badcons = new SpecificBadConsequence("Pierdes tu armadura "
                + "visible y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza",8,badcons,prize));
        
        // CHIBITHULHU
        badcons = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",
        0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList(0));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu",2,badcons,prize));
        
        // EL SOPOR DE DUNWICH
        badcons=new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible",0,
                new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList(0));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich",2,badcons,prize));
        
        // ÁNGELES DE LA NOCHE IBICENCA
        badcons=new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo."
                + "Descarta 1 mano visible y 1 mano oculta.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize= new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca",14,badcons,prize));
        
        // EL GORRÓN EN EL UMBRAL
        badcons=new NumericBadConsequence("Pierdes todos tus tesoros visibles",0,BadConsequence.MAXTREASURES,0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral",10,badcons,prize));
        
        // H.P. MUNCHCRAFT
        badcons=new SpecificBadConsequence("Pierdes la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(0));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft",6,badcons,prize));
        
        // BICHGOOTH
        badcons=new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(0));
        prize=new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth",2,badcons,prize));
        
        // EL REY DE LA ROSA
        badcons=new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
        prize=new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de la rosa",13,badcons,prize));
        
        // LA QUE REDACTA EN LAS TINIEBLAS
        badcons=new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles",2,0,0);
        prize= new Prize (1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas",2,badcons,prize));
        
        // LOS HONDOS
        badcons=new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto");
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos",8,badcons,prize));
        
        // SEMILLAS CTHULHU
        badcons=new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        prize= new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu",4,badcons,prize));
        
        // DAMEARGO
        badcons=new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(0));
        prize=new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo",1,badcons,prize));
        
        // POLLIPÓLIPO VOLANTE
        badcons=new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles.",3,0,0);
        prize= new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante",3,badcons,prize));
        
        // YSKHTIHYSSG-GOTH
        badcons=new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto");
        prize=new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth",12,badcons,prize));
        
        // FAMILIA FELIZ
        badcons=new DeathBadConsequence("La familia te atrapa. Estás muerto");
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz",1,badcons,prize));
        
        // ROBOGGOTH
        badcons = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList(0));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 5, badcons, prize));
        
        //EL ESPIA
        badcons = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible.",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList(0));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Espía", 5, badcons, prize));
        
        // EL LENGUAS
        badcons = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badcons, prize));
        
        // BICEFALO
        badcons = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",
                  3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)),new ArrayList(0));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badcons, prize));
        
        badcons = new SpecificBadConsequence("Pierdes 1 mano visible",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(0));
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable",10,badcons,prize,-2));
        
        badcons = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja",0,5,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos oculares",6,badcons,prize,2));
        
        badcons = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres");
        prize= new Prize(2,5);
        unusedMonsters.add(new Monster("El gran Cthulhu",20,badcons,prize,4));
        
        badcons = new NumericBadConsequence("Tu gobierno te recorta 2 niveles",2,0,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Politico",8,badcons,prize,-2));
             
        this.shuffleMonsters();

    }
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }   
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    public Treasure nextTreasure(){     //DEBO BORRAR EL MAZO DE USED POR QUE LE 
        if(unusedTreasures.isEmpty()){  //DOY LA VUELTA????
            int n_monsters=usedTreasures.size();
            for(int i=0;i<n_monsters;i++)
                unusedTreasures.add(usedTreasures.remove(0));
            usedTreasures=new ArrayList(0);
        }
        return unusedTreasures.remove(0);
    }
    public Monster nextMonster(){
        if(unusedMonsters.isEmpty()){  //DOY LA VUELTA????
            int n_monsters=usedMonsters.size();
            for(int i=0;i<n_monsters;i++)
                unusedMonsters.add(usedMonsters.remove(0));
            this.shuffleMonsters();
        }
        
        Monster m=unusedMonsters.remove(0);
        return m;
    }

    private void initCultistsCardDeck(){
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",1));
        shuffleCultists();
    }
    
    public Cultist nextCultist(){
        Cultist c = unusedCultists.remove(0);
        return c;
    }
    
    public void giveTreasureBack(Treasure t){//HE VACIADO EL MAZO??
        usedTreasures.add(t);
    }
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    public void initCards(){
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
        this.initCultistsCardDeck();
    }
}

