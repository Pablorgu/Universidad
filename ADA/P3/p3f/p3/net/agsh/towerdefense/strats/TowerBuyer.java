/*
Sustituir este comentario por una explicación de la formula o procedimiento empleado para determinar el valor de una
torreta.
*/

package net.agsh.towerdefense.strats;

import net.agsh.towerdefense.Tower;

import java.util.ArrayList;

public class TowerBuyer {
    private static final float WEIGHT_RANGE = 0.3f;
    private static final float WEIGHT_DAMAGE = 0.4f;
    private static final float WEIGHT_COOLDOWN = 0.1f;
    private static final float WEIGHT_DISPERSION = 0.1f;
    private static final float WEIGHT_COST = 0.1f;
    public static ArrayList<Integer> buyTowers(ArrayList<Tower> towers, float money) {
        // This is just a (bad) example. Replace ALL of this with your own code.
        // The ArrayList<Integer> returned is a list of the indices of the towers you want to buy.
        // For example, if you want to buy the first and third towers, return [0, 2].
        // The selected towers must be affordable, and the total cost must be less than or equal to money.
        // The indices should be given in the order that the towers are given in the original ArrayList<Tower> towers.

        // Create an ArrayList<Integer> to store the indices of the towers you want to buy.
        ArrayList<Integer> selected = new ArrayList<>();
//        ArrayList<Float> values = Evaluatetowers(towers);


        int numTowers = towers.size();

        // Manejar el caso base donde no hay torretas
        if (numTowers == 0) {
            return new ArrayList<>();
        }

        float[][] dp = new float[numTowers + 1][(int) (money + 1)];

        // Llenar la tabla de manera iterativa
        for (int i = 1; i <= numTowers; i++) {
            Tower currentTower = towers.get(i - 1);

            for (int j = 0; j <= money; j++) {
                // No comprar la torreta actual
                dp[i][j] = dp[i - 1][j];

                // Intentar comprar la torreta actual si es asequible
                if (j >= currentTower.getCost()) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][(int) (j - currentTower.getCost())] + Valuetower(currentTower));
                }
            }
        }

        // Recuperar la solución óptima
        int i = numTowers;
        int j = (int) money;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selected.add(i - 1);
                j -= towers.get(i - 1).getCost();
            }
            i--;
        }

        return selected;
        // Loop through the towers.
//        for (int i = 0; i < towers.size(); i++) {
//            // If the tower is affordable, buy it.
//            if(money >= towers.get(i).getCost()) {
//                // Subtract the cost of the tower from money.
//                money -= towers.get(i).getCost();
//                // Add the index of the tower to selected.
//                selected.add(i);
//            }
//        }


    }

//    public static ArrayList<Float> Evaluatetowers(ArrayList<Tower> towers){
//        ArrayList<Float> res = new ArrayList<>();
//        for(int i= 0; i<towers.size(); i++) {
//           res.set(i, Valuetower(towers.get(i)));
//        }
//        return res;
//    }
    public static float Valuetower(Tower tower) {
        float rangeScore = tower.getRange() * WEIGHT_RANGE;
        float damageScore = tower.getDamage() * WEIGHT_DAMAGE;
        float cooldownScore = (1 / tower.getCooldown()) * WEIGHT_COOLDOWN; // Invertir el cooldown para que menor tiempo sea mejor
        float dispersionScore = (1 / tower.getDispersion()) * WEIGHT_DISPERSION; // Invertir la dispersión para que menor dispersión sea mejor
        float costScore = (1 / tower.getCost()) * WEIGHT_COST; // Invertir el costo para que menor costo sea mejor

        // Sumar los puntajes ponderados
        return rangeScore + damageScore + cooldownScore + dispersionScore + costScore;
    }
}
