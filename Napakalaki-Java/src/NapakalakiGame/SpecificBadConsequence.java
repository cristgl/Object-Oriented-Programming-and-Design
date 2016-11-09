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
public class SpecificBadConsequence extends BadConsequence {
    private ArrayList <TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList <TreasureKind> specificVisibleTreasures = new ArrayList();
    public SpecificBadConsequence(String text_i, int lvl,  ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(text_i,lvl);
        specificVisibleTreasures=tVisible;
        specificHiddenTreasures=tHidden;
    }
    public boolean isEmpty(){
       return (specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty());
    }
    void substractVisibleTreasure(Treasure t){
       specificVisibleTreasures.remove(t.getType());
    }
    void substractHiddenTreasure(Treasure t){
       specificHiddenTreasures.remove(t.getType());
    }
    SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        SpecificBadConsequence out;
        ArrayList<TreasureKind> nuevoSV= new ArrayList(0);
        ArrayList<TreasureKind> copiaVT= new ArrayList(0);
        ArrayList<TreasureKind> copiaHT = new ArrayList(0); 
        ArrayList<TreasureKind> nuevoSH= new ArrayList(0);
        int index=0;
        for(Treasure treasure:v){
          copiaVT.add(treasure.getType());
        }
        for(Treasure treasure:h){
            copiaHT.add(treasure.getType());
        }
        for(TreasureKind tipo:specificVisibleTreasures){
            if((index=copiaVT.indexOf(tipo))!=-1){
                nuevoSV.add(tipo);
                copiaVT.remove(index);
            }
        }       
        for(TreasureKind tipo:specificHiddenTreasures){
            if((index=copiaHT.indexOf(tipo))!=-1){
                nuevoSH.add(tipo);
                copiaHT.remove(index);
            }
        }
        out=new SpecificBadConsequence(text,levels,nuevoSV,nuevoSH);
        System.out.println("ASDFASFDAFSSF ES EL BC DE SPECIFIC");
        System.out.println(out.toString());
        return out;
    }
    
    public ArrayList <TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    public ArrayList <TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    public String toString(){
        String out;
        out =  super.toString();
        if(specificHiddenTreasures.size()>0){
            out += ", Hidden Treasures = ";
            for (TreasureKind specificHT : specificHiddenTreasures) {
                out += ", " + specificHT.toString();
            }
        }
        if(specificVisibleTreasures!=null){
            out += ", Visible Treasures = ";
            for (TreasureKind specificVT : specificVisibleTreasures) {
                out += ", " + specificVT.toString();
            }
        }
        return out;
    }
}
