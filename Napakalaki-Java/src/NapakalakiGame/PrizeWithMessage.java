/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author Cristina
 */
public class PrizeWithMessage extends Prize {
    private final String mensaje;
   
    public PrizeWithMessage(int treasures, int levels, String msg){
        super(treasures,levels);
        mensaje=msg;
    }
    
    @Override
    public int getLevels(){
        Random rdm;
        rdm= new Random();
        return (super.getLevels()+(rdm.nextInt(2)+2));
    }
    
    public String toString(){
        return super.toString() + ", mensaje = "+ mensaje;
    }
}
