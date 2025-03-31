/*
Para calcular el valor del nodo compruebo la distancia a los nodos caminables y por cada nodo que haya entre el rango
minimo y maximo de la torre le sumo 2 puntos mientras que por cada uno que haya mas cerca del rango minimo le sumo 3 al
valor del nodo
*/

package net.agsh.towerdefense.strats;

import net.agsh.towerdefense.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TowerPlacer {

    //Calcula el valor para una casilla(node) dada.
    public static float getNodeValue(MapNode node, Map map) {
        float radioMaximoTorre = Game.getInstance().getParam(Config.Parameter.TOWER_RANGE_MAX);

        float maxRange =  Game.getInstance().getParam(Config.Parameter.TOWER_RANGE_MAX);
        float minRange = Game.getInstance().getParam(Config.Parameter.TOWER_RANGE_MIN);
        int nodePoints = 0;
        float distancia, radio;
        for (MapNode n : map.getWalkableNodes()) {
            distancia = node.getPosition().distance(n.getPosition());
            if (distancia < radioMaximoTorre) {
                radio = Math.abs(distancia);
                if((radio<maxRange && radio>minRange) || radio>maxRange){
                    nodePoints+=2;
                    maxRange = radio;
                } else {
                    nodePoints+=3;
                    minRange = radio;
                }
            }
        }
        return  nodePoints;
    }

    //Dadas dos posiciones y los radios de dos objetos devuelve si existe colision entre los mismos.
    public static boolean collide(Point2D entity1Position, float entity1Radius,
                                  Point2D entity2Position, float entity2Radius) {
        float distance = entity1Position.distance(entity2Position);
        float combinedRadius = entity1Radius + entity2Radius;

        return distance < combinedRadius;
    }

    public static ArrayList<Tower> placeTowers(ArrayList<Tower> towers, Map map) {
       // This is just a (bad) example to show you how to use the entities in the game.
       // Replace ALL of this with your own code.

        ArrayList<Tower> placedTowers = new ArrayList<>();
        ArrayList<MapNode> nodes = map.getNodesList();
        MapNode bestNode=null;

        // Ordeno los nodos caminables según su valor.
        setNodeValues(map.getNodesList(), map);
        Collections.sort(nodes, (node1, node2) -> Float.compare(node2.getValue(2), node1.getValue(2)));
        Collections.sort(towers, Comparator.comparingDouble(Tower::getRadius));

        for (Tower tower : towers) {
            // Encuentro la mejor posición disponible para la torreta empezando a buscar por los mejores nodos.
          if(nodes!=null) {
              nodes = findBestNode(nodes, placedTowers, tower, map);
              bestNode = nodes.remove(0);
              if (bestNode != null) {
                  // Coloco la torreta en la mejor posición y la agrego a la lista de torretas colocadas.
                  tower.setPosition(bestNode.getPosition());
                  placedTowers.add(tower);
                  bestNode = null;
              }
          }
        }
        return placedTowers;
    }

    protected static boolean NoOutofBounds(Point2D position, float radius, Point2D mapSize) {
        return !(position.x > mapSize.x - radius) && !(position.y > mapSize.y - radius) && !(position.x < radius) &&  !(position.y < radius);
    }

    private static ArrayList<MapNode> findBestNode(ArrayList<MapNode> nodes, ArrayList<Tower> placedTowers, Tower tower, Map map) {
        while(nodes!=null && !nodes.isEmpty()) {
            Point2D nodePosition = nodes.get(0).getPosition();
            // Verifico si la posición está dentro de los límites del mapa y no colisiona con torres u obstáculos.
            if (NoOutofBounds(nodePosition, tower.getRadius(), map.getSize()) &&
                    !collidesWithTowers(nodePosition, tower.getRadius(), placedTowers) &&
                    !collidesWithObstaclesAndWalkables(nodePosition, tower.getRadius(), map.getObstacles(),map.getWalkableNodes())) {
                return nodes; // Devuelve el array de candidatos con los que ya se han eliminado con el mejor nodo como primero
            }
            nodes.remove(0);
        }
        return null; // No se encontró ningún nodo adecuado por lo que retorno null.
    }

    protected static boolean collidesWithTowers(Point2D position, float radius, ArrayList<Tower> towers) {
        for (Tower tower : towers) {
            if (collide(position, radius, tower.getPosition(), tower.getRadius())) {
                return true; // Hay una colisión con al menos una torreta existente.
            }
        }
        return false; //No hay colisión con ninguna torreta existente.
    }

    protected static boolean collidesWithObstaclesAndWalkables(Point2D position, float radius, ArrayList<Obstacle> obstacles, ArrayList<MapNode> walkablenodes) {
        Game game = Game.getInstance();
        for (Obstacle obstacle : obstacles) {
            if (collide(position, radius, obstacle.getPosition(), obstacle.getRadius())) {
                return true; // Hay una colisión con al menos un obstáculo existente.
            }
        }
        for(MapNode celda : walkablenodes){
            if(collide(position,radius, celda.getPosition(),game.getParam(Config.Parameter.ENEMY_RADIUS_MAX))) {
                return true; // Hay una colisión con al menos un nodo caminable existente.
            }
        }
            return false; //No hay colisión con ningun obstaculo existente.
    }

    //Recorro todos los nodos asignandole a cada uno su valor.
    public static void setNodeValues(ArrayList<MapNode> nodes, Map map) {
        for (MapNode currentNode : nodes) {
            float nodeValue = getNodeValue(currentNode, map);
            currentNode.setValue(2, nodeValue);
        }
    }
}