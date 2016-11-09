
package NapakalakiGame;


public enum TreasureKind {
    ARMOR, ONEHAND, BOTHHANDS, HELMET, SHOES;
    public String toString(){
        String out = null;
        switch(this){
                case ARMOR:
                    out="Armadura";
                    break;
                case ONEHAND:
                    out="Una Mano";
                    break;
                case BOTHHANDS:
                    out="Ambas Manos";
                    break;
                case HELMET:
                    out="Casco";
                    break;
                case SHOES:
                    out="Calzado";
                    break;   
                }
        return out;
    }
}
