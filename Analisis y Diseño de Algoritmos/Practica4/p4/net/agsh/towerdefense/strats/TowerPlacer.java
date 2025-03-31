/*
Para calcular el valor de cada casilla, contamos el número de casillas caminables que están dentro del rango max que puede tener
tanto una torreta como el radio maximo de un enemigo.
*/

package net.agsh.towerdefense.strats;

import net.agsh.towerdefense.*;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TowerPlacer {

    //Calcula el valor para una casilla(node) dada.

        public static float getNodeValue(MapNode nodo, ArrayList<MapNode> nodosCaminables) {
            float radioMaxEnemigos = Game.getInstance().getParam(Config.Parameter.ENEMY_RADIUS_MAX);
            float rangoMaxTorretas = Game.getInstance().getParam(Config.Parameter.TOWER_RANGE_MAX);
            int NodePoints = 0;
            float maxDistancia = rangoMaxTorretas;
            float minDistancia = radioMaxEnemigos + 60;


            for (MapNode nodoCaminable : nodosCaminables) {
                if (nodo.getPosition().distance(nodoCaminable.getPosition()) < rangoMaxTorretas && radioMaxEnemigos < nodo.getPosition().distance(nodoCaminable.getPosition())) {
                    float distancia = Math.abs((nodo.getPosition().distance(nodoCaminable.getPosition())) - radioMaxEnemigos);
                    if ((distancia > maxDistancia) || (distancia > minDistancia && distancia < maxDistancia)) {
                        maxDistancia = distancia;
                        ++NodePoints;
                    } else {
                        minDistancia = distancia;
                        NodePoints += 8;
                    }
                }
            }

            return NodePoints;
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

        // Ordeno los nodos caminables según su valor.
        setNodeValues(map.getNodesList(), map);
        Collections.sort(nodes, (node1, node2) -> Float.compare(node2.getValue(2), node1.getValue(2)));

        for (Tower tower : towers) {
            // Encuentro la mejor posición disponible para la torreta empezando a buscar por los mejores nodos.
             nodes = findBestNode(nodes, placedTowers, tower, map);
             MapNode bestNode = nodes.remove(0);
            if (bestNode != null) {
                // Coloco la torreta en la mejor posición y la agrego a la lista de torretas colocadas.
                tower.setPosition(bestNode.getPosition());
                placedTowers.add(tower);
                bestNode=null;
            }
        }

        return placedTowers;
    }

    protected static boolean NoOutofBounds(Point2D position, float radius, Point2D mapSize) {
        return !(position.x > mapSize.x - radius) && !(position.y > mapSize.y - radius) && !(position.x < radius) &&  !(position.y < radius);
    }

    private static ArrayList<MapNode> findBestNode(ArrayList<MapNode> nodes, ArrayList<Tower> placedTowers, Tower tower, Map map) {
        while(!nodes.isEmpty()) {
            MapNode node = nodes.get(0);
            Point2D nodePosition = node.getPosition();
            // Verifico si la posición está dentro de los límites del mapa y no colisiona con torres u obstáculos.
            if (NoOutofBounds(nodePosition, tower.getRadius(), map.getSize()) &&
                    !collidesWithTowers(nodePosition, tower.getRadius(), placedTowers) &&
                    !collidesWithObstacles(nodePosition, tower.getRadius(), map.getObstacles(),map.getWalkableNodes())) {
                return nodes;
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

    protected static boolean collidesWithObstacles(Point2D position, float radius, ArrayList<Obstacle> obstacles, ArrayList<MapNode> walkablenodes) {
        Game game = Game.getInstance();
        for (Obstacle obstacle : obstacles) {
            if (collide(position, radius, obstacle.getPosition(), obstacle.getRadius())) {
                return true; // Hay una colisión con al menos un obstáculo existente.
            }
        }
        for(MapNode celda : walkablenodes){
            if(collide(position,radius, celda.getPosition(),game.getParam(Config.Parameter.ENEMY_RADIUS_MAX))) {
                return true; // Hay una colisión con al menos un obstáculo existente.
            }
        }
        return false; //No hay colisión con ningun obstaculo existente.
    }

    //Recorro todos los nodos asignandole a cada uno su valor.
    public static void setNodeValues(ArrayList<MapNode> nodes, Map map) {
        for (MapNode currentNode : nodes) {
            float nodeValue = getNodeValue(currentNode, map.getWalkableNodes());
            currentNode.setValue(2, nodeValue);
        }
    }
}