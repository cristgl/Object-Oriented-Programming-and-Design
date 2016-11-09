/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Cristina
 */
public class Player {
//    private static Player instance1=null, instance2=null, instance3=null;
    static final int MAXLEVEL=10;
    private String name;
    private int level;
    private boolean dead=true;
    private boolean canISteal=true;
    private ArrayList <Treasure> visibleTreasures;
    private ArrayList <Treasure> hiddenTreasures;
    private BadConsequence pendingBadConsequence;
    private Player enemy;

    Player(String nombre){
        name=nombre;
        dead=true;
        visibleTreasures= new ArrayList();
        hiddenTreasures= new ArrayList();
        level=1;
    }
    
    public Player(Player pl){
        name = pl.name;
        level = pl.level;
        dead = pl.dead;
        canISteal = pl.canISteal;
        visibleTreasures = pl.visibleTreasures;
        hiddenTreasures = pl.hiddenTreasures;
        pendingBadConsequence = pl.pendingBadConsequence;
        enemy = pl.enemy;
    }
    
    protected Player getEnemy(){
        return enemy;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        Dice dice;
        dice = Dice.getInstance();
        
        return dice.nextNumber()==1;
    }
    
    public String getName(){
        return name;
    }
    private void bringToLife(){
        dead=false;
    }
    protected int getCombatLevel(){
        int suma=0;
        for(Treasure t:visibleTreasures)
            suma=suma+t.getBonus();
       
        return level+suma;
    }
    private void incrementLevels(int l){
        if(level+l<=MAXLEVEL)
           level=level+l;
        else
            level=MAXLEVEL;
    }
    private void decrementLevels(int l){
        if(level-l>=1)
            level=level-l;
        else
            level=1;
           
    }
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence=b;
    }
    private void applyPrize(Monster m){
         int nLevels,nTreasures;
         nLevels=m.getLevelsGained();
         this.incrementLevels(nLevels);
         nTreasures=m.getTreasuresGained();
         if(nTreasures>0){
             CardDealer dealer;
             dealer = CardDealer.getInstance();
             for(int i=0; i<nTreasures; i++){
                 Treasure treasure;
                 treasure=dealer.nextTreasure();
                 hiddenTreasures.add(treasure);
             }
         }
  }
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence, pendingBad;
        int nLevels;
        badConsequence = m.getBadConsequence();
        nLevels = badConsequence.getLevels();
        this.decrementLevels(nLevels); 
        pendingBad=badConsequence.adjustToFitTreasureLists(visibleTreasures,hiddenTreasures);
        this.setPendingBadConsequence(pendingBad);
    } 
    private boolean canMakeTreasureVisible(Treasure t){
        boolean can=false;
        int like_this =howManyVisibleTreasures(t.getType());
        
        if(t.getType()==TreasureKind.BOTHHANDS)
            can= (like_this<1 && howManyVisibleTreasures(TreasureKind.ONEHAND)<1);
        else if(t.getType()==TreasureKind.ONEHAND)
            can=(like_this<2 && howManyVisibleTreasures(TreasureKind.BOTHHANDS)<1);
        else
            can=like_this<1;

        return can;
    }  
    private int howManyVisibleTreasures(TreasureKind tKind){
        int cont=0;
        for(Treasure t:visibleTreasures)
            if (t.getType()==tKind)
                cont++;
       
       return cont;
                
    }
    private void dieIfNoTreasures(){
        if(visibleTreasures.size()==0 && hiddenTreasures.size()==0){
            dead=true;
            level=1;
        }
    }
    public boolean isDead(){
        return dead;
    }
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    public void setVisibleTreasures(ArrayList<Treasure> trs){
        visibleTreasures = trs;
    }
    public CombatResult combat(Monster m){
        int myLevel, monsterLevel;
        CombatResult result;
        myLevel=this.getCombatLevel();
        monsterLevel=this.getOponentLevel(m);
        if(myLevel>monsterLevel){
            this.applyPrize(m);
            if(level>=MAXLEVEL)
                result=CombatResult.WINGAME;
            else
                result=CombatResult.WIN;
        }
        else{
            result=CombatResult.LOSE;
            this.applyBadConsequence(m);
            if(this.shouldConvert())
                result=CombatResult.LOSEANDCONVERT;
        }
        return result;
    }
    public void makeTreasureVisible(Treasure t){
        boolean canI;
        canI=this.canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);
        if(pendingBadConsequence!=null && (!pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        this.dieIfNoTreasures();
    }
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if(pendingBadConsequence!=null && (!pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        this.dieIfNoTreasures();
    }
    public boolean validState(){
        boolean valido=false;
        if(pendingBadConsequence!=null){
           valido=hiddenTreasures.size()<=4 && pendingBadConsequence.isEmpty();
        }
        else{
            valido=hiddenTreasures.size()<=4;
        }
       return valido;
    }
    public void initTreasures(){
        CardDealer dealer;
        Dice dice;
        Treasure treasure;
        int number;
        dealer = CardDealer.getInstance();
        dice = Dice.getInstance();
        this.bringToLife();
        treasure=dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        number=dice.nextNumber();
        if(number>1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if(number==6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }

     }
    public int getLevels(){
        return level;
    }
    public Treasure stealTreasure(){
         boolean canI;
         Treasure treasure=null;
         boolean canYou;
         canI=this.canISteal();
         
         if(canI){
             canYou=enemy.canYouGiveMeATreasure();
             if(canYou){
                 treasure = enemy.giveMeATreasure();
                 hiddenTreasures.add(treasure);
                 this.haveStolen();
             }
         }
         return treasure;
     }
    public void setEnemy(Player enemy2){
        enemy=enemy2;        
    }
    protected Treasure giveMeATreasure(){
        Random rdm=new Random();
        return hiddenTreasures.remove(rdm.nextInt(hiddenTreasures.size()));
    }
    public boolean canISteal(){
       return canISteal && enemy.canYouGiveMeATreasure();
    }
    protected boolean canYouGiveMeATreasure(){
        return (hiddenTreasures.size()>0);
    }
    private void haveStolen(){
        canISteal=false;
    }
    public void discardAllTreasures(){
        int tama=visibleTreasures.size();
         for(int i=0;i<tama;i++)
             this.discardVisibleTreasure(visibleTreasures.get(0));
        tama=hiddenTreasures.size();
         for(int i=0;i<tama;i++)
             this.discardHiddenTreasure(hiddenTreasures.get(0));
     }
    public String toString(){
        return name + " level " + Integer.toString(level);
    }
}
//  A INCLUIR BAJO EL CONSTRUCTOR
//CLASE CON SOLO TRES INSTANCIAS SI TIENEN QUE CREARSE TODAS AL TIEMPO
//              SI NO VER RUBY
//   public static Player getInstance(int i, String name){
//        Player out=null; 
//        String n1=null,n2=null,n3=null;
//        if(i==1){
//            if(instance1==null){
//                instance1=new Player(name);
//                instance2=new Player(null);
//                instance3=new Player(null);
//            }
//            if(instance1.name==null){
//                instance1.name=name;
//            }
//            out=instance1;
//        }else{
//            if(i==2){
//                if(instance1==null){
//                    instance1=new Player(null);
//                    instance2=new Player(name);
//                    instance3=new Player(null);
//                }
//                if(instance2.name==null){
//                    instance2.name=name;
//                }
//                out=instance2;
//            }else
//                if(i==3){
//                    if(instance3==null){
//                        instance1=new Player(null);
//                        instance2=new Player(null);
//                        instance3=new Player(name);
//                    
//                    }
//                    if(instance3.name==null){
//                        instance3.name=name;
//                    }
//                    out=instance3;
//                }
//        }
//        
//        
//        return out;
//    }