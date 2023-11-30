/*
Sustituir este comentario por una explicación de la formula o procedimiento empleado para determinar el valor de una
torreta.
*/

package net.agsh.towerdefense.strats;

import net.agsh.towerdefense.Tower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TowerBuyer {

    private static final float WEIGHT_RANGE = 0.1f;
    private static final float WEIGHT_DAMAGE = 30.0f;
    private static final float WEIGHT_COOLDOWN = 0.1f;
    private static final float WEIGHT_DISPERSION = 0.1f;

    public static ArrayList<Integer> buyTowers(ArrayList<Tower> towers, float money) {
        // This is just a (bad) example. Replace ALL of this with your own code.
        // The ArrayList<Integer> returned is a list of the indices of the towers you want to buy.
        // For example, if you want to buy the first and third towers, return [0, 2].
        // The selected towers must be affordable, and the total cost must be less than or equal to money.
        // The indices should be given in the order that the towers are given in the original ArrayList<Tower> towers.

        // Creo un ArrayList<Integer> que guarda los indices de torretas que quiero comprar.
        ArrayList<Integer> selected = new ArrayList<>();
        int numTowers = towers.size();

        // Manejo el caso base donde no hay torretas
        if (numTowers == 0) {
            return new ArrayList<>();
        }

        //Miro los valores maximos de cada atributo de torretas para luego poder relativizarlos con respecto a estos
        float maxrange=0;
        float maxdamage=0;
        float maxcooldown= 0;
        float maxdispersion= 0;
        for(Tower t: towers){
            if(t.getRange()>maxrange)maxrange=t.getRange();
            if(t.getDamage()>maxdamage)maxdamage=t.getDamage();
            if(t.getCooldown()>maxcooldown)maxcooldown=t.getCooldown();
            if(t.getDispersion()>maxdispersion)maxdispersion=t.getDispersion();
        }

        float[][] dp = new float[numTowers + 1][(int) (money + 1)];

        // Lleno la tabla de manera iterativa
        for (int i = 0; i <= numTowers; i++) {
            for(int j = 0; j <= money ; j++){
                if(i==0 || j==0) {
                    dp[i][j]=0;
                }else if(i>0 && j<(int)Math.ceil(towers.get(i-1).getCost())){
                    dp[i][j]=dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],Valuetower(towers.get(i-1), maxrange,maxdamage,maxcooldown,maxdispersion)+dp[i-1][j-(int)Math.ceil(towers.get(i-1).getCost())]);
                }
            }
        }

        // Recupero la solución óptima
        int i = numTowers;
        int j = (int) money;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selected.add(i-1);
                j -= towers.get(i - 1).getCost();
            }
            i--;
        }

//        Collections.reverse(selected);
        return selected;
    }
    public static float Valuetower(Tower tower, float maxrange, float maxdamage, float maxcooldown, float maxdispersion) {

        float rangeScore = tower.getRange()/maxrange * WEIGHT_RANGE;
        float damageScore = tower.getDamage()/maxdamage * WEIGHT_DAMAGE;
        float cooldownScore = (1 - (tower.getCooldown()/maxcooldown)) * WEIGHT_COOLDOWN; // Invierto el cooldown para que menor tiempo sea mejor
        float dispersionScore = (1 - (tower.getDispersion()/maxdispersion)) * WEIGHT_DISPERSION; // Invierto la dispersión para que menor dispersión sea mejor

        // Sumo los puntajes ponderados
        return rangeScore + damageScore + cooldownScore + dispersionScore;
    }
}