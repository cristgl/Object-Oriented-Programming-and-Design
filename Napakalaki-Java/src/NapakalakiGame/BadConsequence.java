
package NapakalakiGame;

import java.util.ArrayList;

public abstract class BadConsequence {
    static final int MAXTREASURES=10;
    protected String text;
    protected int levels;
 
    public BadConsequence(String text_i,int lvl){
        text = text_i;
        levels = lvl;
    }  
    public String getText(){
        return text;
    }
    public int getLevels(){
        return levels;
    }
    public abstract boolean isEmpty();
    abstract void substractVisibleTreasure(Treasure t);
    abstract void substractHiddenTreasure(Treasure t);
    abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    public String toString(){
        String out;
        out =  "Text = " + text + ", Levels = " + Integer.toString(levels);
        return out;
    }



//    public boolean isEmpty(){
//        boolean empty=false;
//       if(nVisibleTreasures==-1 && nHiddenTreasures==-1)
//           empty = specificHiddenTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
//       else
//               if(nVisibleTreasures==0 && nHiddenTreasures==0)
//                   empty=true;
//       return empty;
//          
//    }
    
//    void substractVisibleTreasure(Treasure t){
//        if(nVisibleTreasures==-1)
//            specificVisibleTreasures.remove(t.getType());    
//        else
//            if(nVisibleTreasures!=0)
//                nVisibleTreasures--;
//    }
    
//    void substractHiddenTreasure(Treasure t){
//        if(nHiddenTreasures==-1)
//            specificHiddenTreasures.remove(t.getType());    
//        else
//            if(nHiddenTreasures!=0)
//                nHiddenTreasures--;
//    }
    
//    BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
//       BadConsequence out;
//       if(!death){
//           if(nVisibleTreasures!=-1 && nHiddenTreasures!=-1){
//               int nuevoNV,nuevoNH;
//               nuevoNV=nVisibleTreasures>v.size()?v.size():nVisibleTreasures;
//               nuevoNH=nHiddenTreasures>h.size()?h.size():nHiddenTreasures;
//               out= new BadConsequence(text,levels,nuevoNV,nuevoNH);
//           }
//           else{
//               ArrayList<TreasureKind> nuevoSV= new ArrayList(0);
//               ArrayList<TreasureKind> copiaVT= new ArrayList(0);
//               ArrayList<TreasureKind> copiaHT = new ArrayList(0);
//               int index=0;
//               for(Treasure treasure:v){
//                    copiaVT.add(treasure.getType());
//               }
//               for(Treasure treasure:h){
//                    copiaHT.add(treasure.getType());
//               }
//               for(TreasureKind tipo:specificVisibleTreasures){
//                   if((index=copiaVT.indexOf(tipo))!=-1){
//                       nuevoSV.add(tipo);
//                       copiaVT.remove(index);
//                   }
//               }
//               ArrayList<TreasureKind> nuevoSH= new ArrayList(0);
//                for(TreasureKind tipo:specificHiddenTreasures){
//                   if((index=copiaHT.indexOf(tipo))!=-1){
//                       nuevoSH.add(tipo);
//                       copiaHT.remove(index);
//                   }
//                }
//               out=new BadConsequence(text,levels,nuevoSV,nuevoSH);
//           }  
//       }
//       else{
//           out= new BadConsequence(text,levels,v.size(),h.size());
//       }
//       return out;
//    }
    
 
//    public String toString(){
//        String out;
//        out =  "Text = " + text;
//        if(death)
//            out += ", death = " + Boolean.toString(death);
//        else{
//            if(specificHiddenTreasures!=null){
//                 out += ", Hidden Treasures = ";
//                for (TreasureKind specificHT : specificHiddenTreasures) {
//                    out += ", " + specificHT.toString();
//                }
//            }
//            if(specificVisibleTreasures!=null){
//                out += ", Visible Treasures = ";
//                for (TreasureKind specificVT : specificVisibleTreasures) {
//                out += ", " + specificVT.toString();
//                }
//            }
//            if(nVisibleTreasures>=0)
//                out += ", number of Visible Treasures = " + Integer.toString(nVisibleTreasures);
//            if(nHiddenTreasures>=0)
//                out += ", number of Hidden Treasures = " + Integer.toString(nHiddenTreasures);
//            if(levels>=0)
//                out += ", Levels = " + Integer.toString(levels);
//        }
//        return out;
//    }
    
}
