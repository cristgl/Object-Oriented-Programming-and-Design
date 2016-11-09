/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;


public class Prize {
    
    private int treasures;
    private int level;
    
    public Prize(int treasures_i, int level_i){
        if(treasures_i>2)
            treasures = 2;
        else
            treasures = treasures_i;
        level = level_i;
    }
    
    public  int getTreasures(){
        return treasures;
    }
    
    public int getLevels(){
        return level;
    }
    public String toString(){
        return " Treasures= "+Integer.toString(treasures) + ", levels up = "+Integer.toString(level);
    }
}
