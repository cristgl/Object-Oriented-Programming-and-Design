/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Cristina
 */
public class CultistPlayer extends Player{
    private static int totalCultistPlayers=0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        totalCultistPlayers = totalCultistPlayers + 1;
        myCultistCard = c;
    }
    
    @Override
    protected int getCombatLevel(){
        int out;
        out=(super.getCombatLevel() + 20*super.getCombatLevel()/100 + 
                myCultistCard.getGainedLevels()*totalCultistPlayers);
        return (int) out;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    protected Treasure giveMeATreasure(){
        int indice_tesoro;
        Random rdm=new Random();
        Treasure tesoro;
        indice_tesoro = rdm.nextInt((super.getVisibleTreasures()).size());
        ArrayList<Treasure> tesoros;
        tesoros = super.getVisibleTreasures();
        tesoro = tesoros.get(indice_tesoro);
        tesoros.remove(indice_tesoro);
        super.setVisibleTreasures(tesoros);
        return tesoro;
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        return (super.getVisibleTreasures().size()>0); 
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
}
