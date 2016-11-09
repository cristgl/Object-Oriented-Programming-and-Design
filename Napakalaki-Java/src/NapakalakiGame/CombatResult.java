/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Laura
 */
public enum CombatResult {
    WINGAME, WIN, LOSE, LOSEANDCONVERT;
    public String toString(){
        String out=null;
        switch(this){
            case WIN:
                out= "¡Ganaste!";
                break;
            case LOSE:
                out= "¡Oh! Perdiste...";
                break;
            case LOSEANDCONVERT:
                out= "Perdiste y te convertiste.";
            case WINGAME:
                out= "Eres el vencedor :D";
                break;
        }
        return out;
    }
}
