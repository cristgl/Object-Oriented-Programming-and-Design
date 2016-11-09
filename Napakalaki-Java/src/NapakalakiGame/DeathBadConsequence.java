/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class DeathBadConsequence extends NumericBadConsequence {
    public DeathBadConsequence(String text_i){
        super(text_i,Player.MAXLEVEL,MAXTREASURES,MAXTREASURES);
    }
    BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
       return new NumericBadConsequence(text,levels,v.size(),h.size());
    }    
    public String toString(){
        return super.toString();
    }   
}
