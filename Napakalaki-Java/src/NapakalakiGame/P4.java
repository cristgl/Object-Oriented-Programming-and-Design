/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Cristina
 */
public class P4 {
    public static void main(String[] args) {
        Prize p;
        p = new Prize(3,5);
        p.getLevels();
        p.getTreasures();
        System.out.println(p.toString());
        
        PrizeWithMessage pm;
        pm = new PrizeWithMessage(3,5,"Mensaje de prize");
        pm.getLevels();
        pm.getTreasures();
        System.out.println(pm.toString());
       
        
        Player p1 = new Player("Jugador 1");
        System.out.println(p1.getCombatLevel());
        Cultist c = new Cultist("Card",2);
        p1 = new CultistPlayer(p1,c);
        System.out.println("El nivel de combate del jugador 1 es ");
        System.out.println(p1.getCombatLevel());
        
        Player p2 = new Player("Jugador 2");
        Cultist c2 = new Cultist("Card2",3);
        p2 = new CultistPlayer(p2,c2);
        System.out.println("El nivel de combate de los dos jugadores es ");
        System.out.println(p2.getCombatLevel());
    }
}
