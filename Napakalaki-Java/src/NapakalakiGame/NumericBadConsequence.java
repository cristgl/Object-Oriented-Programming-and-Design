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
public class NumericBadConsequence extends BadConsequence {
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    public NumericBadConsequence(String text_i, int levels_i, int nVisible, int nHidden){
        super(text_i, levels_i);
        nVisibleTreasures=nVisible;
        nHiddenTreasures=nHidden;
    }
    
    @Override
    public boolean isEmpty(){
       return (nVisibleTreasures==0 && nHiddenTreasures==0);
    }
    
    @Override
    void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures!=0)
            nVisibleTreasures--;
    }
    @Override
    void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures!=0)
            nHiddenTreasures--;
    }
    @Override
    BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
       int nuevoNV,nuevoNH;
       nuevoNV=nVisibleTreasures>v.size()?v.size():nVisibleTreasures;
       nuevoNH=nHiddenTreasures>h.size()?h.size():nHiddenTreasures; 
       return new NumericBadConsequence(text,levels,nuevoNV,nuevoNH);
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    public int getNHiddenTreasure(){
        return nHiddenTreasures;
    }
    @Override
    public String toString(){
        String out;
        out =  super.toString();
        if(nVisibleTreasures>=0)
            out += ", number of Visible Treasures = " + Integer.toString(nVisibleTreasures);
        if(nHiddenTreasures>=0)
            out += ", number of Hidden Treasures = " + Integer.toString(nHiddenTreasures);
        return out;
    }
}
