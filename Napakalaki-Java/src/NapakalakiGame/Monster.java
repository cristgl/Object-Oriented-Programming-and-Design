/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;


public class Monster {
    private String name;
    private int combatLevel;
    private Prize price;
    private BadConsequence bad_c;
    int levelChangeAgainstCultistPlayer;
    
    public Monster(String name_i,int level, BadConsequence bc, Prize price_i){
        name=name_i;
        combatLevel=level;
        price=price_i;
        bad_c=bc;
        levelChangeAgainstCultistPlayer=0;
    }
    
    public Monster(String name_i, int level, BadConsequence bc, Prize price_i, int lvChangeAgainstCultistPlayer){
        name = name_i;
        combatLevel=level;
        price = price_i;
        bad_c=bc;
        levelChangeAgainstCultistPlayer=lvChangeAgainstCultistPlayer;
    }            
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return getCombatLevel()+levelChangeAgainstCultistPlayer;
    }
    
    public BadConsequence getBadConsequence(){
        return bad_c;
    }
    
    public int getLevelsGained(){
        return price.getLevels();
    }
    
    public int getTreasuresGained(){
            return price.getTreasures();
    }
    
  
    
    public String toString(){
        return "Name =" + name +", Level = " + Integer.toString(combatLevel)
                + ", Prize = " + price.toString() +", Bad Consequence = " + bad_c.toString();
    }
    
    
}
