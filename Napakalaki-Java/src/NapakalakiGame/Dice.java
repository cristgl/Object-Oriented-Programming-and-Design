/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author Laura
 */
public class Dice {
    private static Dice instance= null;
    private static Random rdm;
    private Dice(){
    }
    public static Dice getInstance(){
        if(instance==null){
            instance = new Dice();
            rdm= new Random();
        }
        return instance;
    }
   public int nextNumber(){
       return (1+rdm.nextInt(6));
    }
}
