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
 * @author Laura
 */
public class Napakalaki {
    private static Napakalaki instance = null;
    private CardDealer dealer;
    private Player currentPlayer;
    private int currentPlayerIndex;  //hay que modificar metodos
    private ArrayList<Player> players;
    private Monster currentMonster;
    
    private Napakalaki(){
        players = new ArrayList(0);
        currentPlayer=null;
        currentPlayerIndex=-1;
        currentMonster=null;
        dealer= CardDealer.getInstance();

    }
    public static Napakalaki getInstance(){
        if(instance==null){
        instance = new Napakalaki();
        }

        return instance;
     
    }
    private void initPlayers(ArrayList<String> names){
        for (String nm: names) {
             players.add(new Player(nm));
        }
    }
    private Player nextPlayer(){
        if(currentPlayer == null){
            Random rdm = new Random();
            currentPlayerIndex = rdm.nextInt(players.size() - 1);
        }else{
            currentPlayerIndex = (currentPlayerIndex+1)%players.size();
        }
        currentPlayer= players.get(currentPlayerIndex);

        return currentPlayer;
    }

    private boolean nextTurnAllowed(){

        boolean out;
        if(currentPlayer==null)
            out=true;
        else
            out=currentPlayer.validState();
        return out;
    }
    private void setEnenmies(){
 
        Random rdm = new Random();
        int indice;
        if(players.size()>2){
            for (Player jug : players){
                while((indice=rdm.nextInt(players.size() - 1))== players.indexOf(jug)){}
                    jug.setEnemy(players.get(indice));
            }
        }
        else{
            if(players.size()==2){
                (players.get(0)).setEnemy(players.get(1));
                (players.get(1)).setEnemy(players.get(0));
            }
        }

    }
    public CombatResult developCombat(){
        Monster m=currentMonster;
        CombatResult out;
        Cultist carta;
        CultistPlayer cp;
        out=currentPlayer.combat(m);
        if(out == CombatResult.LOSEANDCONVERT){
            carta=dealer.nextCultist();
            cp=new CultistPlayer(currentPlayer,carta);
            for(Player p: players)
                if(p.getEnemy()==currentPlayer)
                    p.setEnemy(cp);
            players.set(players.indexOf(currentPlayer),cp);
            currentPlayer=cp;
        }
        dealer.giveMonsterBack(m);
        return out;
    }
    
    public void discardVisibleTreasures( ArrayList<Treasure> treasures){
        for(Treasure treasure:treasures){
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(Treasure treasure:treasures){
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure treasure:treasures){
            currentPlayer.makeTreasureVisible(treasure);
        }
    
    }
    public void initGame(ArrayList<String> players){
        this.initPlayers(players);
        this.setEnenmies();
        dealer.initCards();
        this.nextTurn();   
    }
    public Player getCurrentPlayer(){

        return currentPlayer;
    }
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    public boolean nextTurn(){
       boolean stateOK = this.nextTurnAllowed();
       boolean dead;
       if(stateOK){
           currentMonster=dealer.nextMonster();
           currentPlayer=this.nextPlayer();
           dead= currentPlayer.isDead();
           if(dead){
               currentPlayer.initTreasures();
           }
       }
       return stateOK;
    }
    public boolean endOfGame(CombatResult result){
        return result==CombatResult.WINGAME;
    }
}