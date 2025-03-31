/*
Sustituir este comentario por una explicaciÃ³n de la formula o procedimiento empleado para determinar el valor de una
torreta.
*/

package net.agsh.towerdefense.strats;

import net.agsh.towerdefense.Tower;

import java.util.ArrayList;
import java.util.Collections;

/*Para calcular el valor de cada torreta asigno una ponderacion a cada atributo de la torreta y al sumarlo
 me sale una puntuacion que el algoritmo de backtracking usará para clasificarlas
 */
public class TowerBuyer {
    private static final int LIMIT = 20000;
    private static int num_combinations = 0;
    private static final float WEIGHT_RANGE = 888f;
    private static final float WEIGHT_DAMAGE = 9585.6f;
    private static final float WEIGHT_COOLDOWN = 59.2f;

    private static final float WEIGHT_DISPERSION = 4016.32f;

    public static ArrayList<Integer> buyTowers(ArrayList<Tower> towers, float money) {
//  Inicia el proceso de compra de torres. Llama a seleccionDeTorretas para explorar combinaciones y selecciona la mejor
//  opción basándose en el valor de las torres.
        ArrayList<Integer> selected = new ArrayList<>();

        ArrayList<Tower> towersPresel = new ArrayList<>();

        seleccionDeTorretas(towers, towersPresel, money,selected,false);
        num_combinations = 0;

        return selected;
    }

    public static float Valuetower(Tower tower) {
//  Calcula el valor de una torre ponderando sus atributos.
        float rangeScore = tower.getRange()*WEIGHT_RANGE;
        float damageScore = tower.getDamage()* WEIGHT_DAMAGE;
        float cooldownScore = tower.getCooldown()* WEIGHT_COOLDOWN;
        float dispersionScore = tower.getDispersion()* WEIGHT_DISPERSION;

        // Sumo los puntajes ponderados
        return  damageScore-rangeScore+dispersionScore-cooldownScore;
    }

    private static ArrayList<Integer> IndexOfTowers(ArrayList<Tower> towers, ArrayList<Tower> towersPresel) {
//      Devuelve los índices de torres seleccionadas previamente.
        ArrayList<Integer> res = new ArrayList<>();
        for(Tower t:towersPresel) {
            for(int i =0; i<towers.size(); i++) {
                if(t.getId()== towers.get(i).getId()){
                    res.add(i);
                }
            }
        }
        return res;
    }
    private static float CosteTotal(ArrayList<Tower> towersPresel) {
//      Calcula el costo total de un conjunto de torres.
        float costeTotal = 0;
        for(Tower t: towersPresel) {
            costeTotal+=t.getCost();
        }
        return costeTotal;
    }
    private static void seleccionDeTorretas(ArrayList<Tower> towers, ArrayList<Tower> towersPresel, float money, ArrayList<Integer> selected, boolean finished) {
//      Explora combinaciones de torres posibles, considerando el presupuesto disponible. Selecciona la combinación
//      óptima en términos de valor de torres ponderado.
        if(finished) {
            float bestValue=0, currentValue = 0;
            for(Tower t:towersPresel) {
                currentValue+=Valuetower(t);
            }
            for(int i : selected) {
                bestValue+=Valuetower(towers.get(i));
            }
            if(bestValue<currentValue) {
                selected.clear();
                selected.addAll(IndexOfTowers(towers, towersPresel));
            }
            num_combinations++;
        }else{
            ArrayList<Integer> aux = IndexOfTowers(towers, towersPresel);
            for(int i = 0; i<towers.size() && num_combinations < LIMIT;i++){
                float piledCost = towers.get(i).getCost()+CosteTotal(towersPresel);
                if(piledCost<=money && towersPresel.size()<towers.size()){
                    if(!aux.contains(i)){
                        towersPresel.add(towers.get(i));
                        seleccionDeTorretas(towers, towersPresel, money, selected, false);
                        towersPresel.remove(towersPresel.size()-1);
                    }
                }else{
                    seleccionDeTorretas(towers, towersPresel, money, selected, true);
                }
            }
        }
    }
}