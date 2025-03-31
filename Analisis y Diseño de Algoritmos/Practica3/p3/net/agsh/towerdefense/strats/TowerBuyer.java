/*
Sustituir este comentario por una explicación de la formula o procedimiento empleado para determinar el valor de una
torreta.
*/

package net.agsh.towerdefense.strats;

import net.agsh.towerdefense.Tower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
    En esta practica se utiliza una estrategia basada en programación dinámica para elegir con un presupuesto limitado en cada ronda la combinación de torretas mas óptima la cual
consiga que se nos escape el menor numero de goblins posibles dando lugar al score mas bajo. Para poder hacer la TSR(Tabla de subproblemas resueltos) necesitaba crear una funcion
que me evaluase las torretas objetivamente en función a sus atributos lo que ha dado lugar a la función “Valuetower” que en funcion de estos multiplicandolos por una ponderación asigna un valor objetivo que indica la calidad de esa torreta. Dos problemas que he encontrado a la hora de realizar
la practica ha sido encontrar las ponderaciones correctas, aunque finalmente he concluido que el atributo mas importante es el daño, y en segundo lugar las limitaciones
que supone que solo haya 18 torretas ya que esto hace que no varíe mucho la puntuación al cambiar las ponderaciones puesto que la diferencia entre una solución óptima
y una no óptima al elegir 14 torretas de 18 no es lo mismo que al elegir 14 de 200, lo que me ha complicado llegar a la conclusión de que atributos son mas prioritarios,
incluso he podido apreciar que hay rondas en las que se eligen las 18 torretas y aun así entran goblins concluyendo en que es imposible conseguir una puntuación perfecta.
 */
public class TowerBuyer {

    private static final float WEIGHT_RANGE = 7.88f;
    private static final float WEIGHT_DAMAGE = 63.738f;
    private static final float WEIGHT_COOLDOWN = 0.35f;
    private static final float WEIGHT_DISPERSION = 22.03f;

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
        float[][] dp = new float[numTowers + 1][(int) (money + 1)];

        // Lleno la tabla de manera iterativa
        for (int i = 0; i <= numTowers; i++) {
            for(int j = 0; j <= money ; j++){
                if(i==0 || j==0) {
                    dp[i][j]=0;
                }else if(i>0 && j<(int)Math.ceil(towers.get(i-1).getCost())){
                    dp[i][j]=dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],Valuetower(towers.get(i-1))+dp[i-1][j-(int)Math.ceil(towers.get(i-1).getCost())]);
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

        Collections.reverse(selected);
        return selected;
    }
    public static float Valuetower(Tower tower) {

        float rangeScore = tower.getRange()*WEIGHT_RANGE;
        float damageScore = tower.getDamage()* WEIGHT_DAMAGE;
        float cooldownScore = tower.getCooldown()* WEIGHT_COOLDOWN;
        float dispersionScore = tower.getDispersion()* WEIGHT_DISPERSION;

        // Sumo los puntajes ponderados
        return  damageScore -rangeScore+ cooldownScore -dispersionScore;
    }
}