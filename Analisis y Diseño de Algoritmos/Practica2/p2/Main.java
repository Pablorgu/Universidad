import net.agsh.towerdefense.*;
import org.w3c.dom.NodeList;

import java.lang.reflect.Array;
import java.util.ArrayList;

//MEMORIA.
//La idea de esta Práctica es usar 4 tipos diferentes de ordenación para ordenar una lista de MapNodes que representan los cuadrados de un juego del estilo Tower Defense para aprovecharnos de
// estos algoritmos y tratar de ganar salvando así La Universidad de la sabiduría.
//
//        Los 4 algoritmos de ordenación que hemos usado son NoSort consistente en buscar las x casillas más rentables sin ningun tipo de orden, el segundo es InsertionSort, es decir ordenación
//        por inserción, el tercero es MergeSort, es decir ordenación por mezcla y finalmente QuickSort u ordenación rápida.
//
//        He ejecutado el código unas cuantas veces para comprobar los resultados que se obtienen y poder ver cual es el algoritmo que mas nos rentaría usar. Las siguientes tablas muestran el tamaño
//        del mapa, y el tiempo que se tarda en calcular las casillas mas eficientes con cada algoritmo.
//
//        ## Datos
//
//        ### Prueba 1
//
//        | Tamaño del Mapa (n) | NoSort | InsertionSort | MergeSort | QuickSort |
//        | --- | --- | --- | --- | --- |
//        | 496 | 0.0445 | 0.4782 | 0.0937 | 0.0358 |
//        | 946 | 0.0803 | 1.5974 | 0.1858 | 0.0877 |
//        | 1540 | 0.1331 | 3.9449 | 0.3295 | 0.1684 |
//        | 2278 | 0.1890 | 8.5897 | 0.5068 | 0.3311 |
//        | 3160 | 0.2797 | 17.1356 | 0.7491 | 0.5714 |
//
//        ### Prueba 2
//
//        | Tamaño del Mapa (n) | NoSort | InsertionSort | MergeSort | QuickSort |
//        | --- | --- | --- | --- | --- |
//        | 496 | 0.0452 | 0.4859 | 0.0913 | 0.0369 |
//        | 946 | 0.0788 | 1.5314 | 0.1853 | 0.0861 |
//        | 1540 | 0.1292 | 3.9565 | 0.3313 | 0.1669 |
//        | 2278 | 0.1899 | 8.4454 | 0.5336 | 0.3338 |
//        | 3160 | 0.2769 | 16.4754 | 0.7645 | 0.5698 |
//
//        ### Prueba 3
//
//        | Tamaño del Mapa (n) | NoSort | InsertionSort | MergeSort | QuickSort |
//        | --- | --- | --- | --- | --- |
//        | 496 | 0.0453 | 0.5076 | 0.0877 | 0.0367 |
//        | 946 | 0.0829 | 1.5576 | 0.1746 | 0.0853 |
//        | 1540 | 0.1288 | 3.8949 | 0.3188 | 0.1709 |
//        | 2278 | 0.1898 | 8.5556 | 0.5079 | 0.3291 |
//        | 3160 | 0.2658 | 16.9000 | 0.7358 | 0.5605 |
//
//        ## Análisis de los resultados
//
//        Como puedo apreciar en las tablas, surgen unos resultados inesperados ya que en principio el algoritmo más eficiente debería de ser el MergeSort o el QuickSort pero sin embargo el que
//        saca mejores tiempos es el NoSort, esto de primeras puede dar a entender que nos deberíamos de quedar si o si con el NoSort pero en caso de que el mapa creciese y tuviésemos un n más grande
//        seguramente el QuickSort llegaría un momento en el que se quedaría más o menos estable debido a su O(nlog(n)) y sin embargo como el otro tiene complejidad O(k*n) llegará un punto en el que
//        lo superará.
//
//        En resumen si el mapa se va quedar de este tamaño y con el mismo numero de torretas eligiría usar en NoSort, sin embargo en caso de que alguno de estos dos parámetros creciese según avancen
//        los niveles optaría por el QuickSort que va a ser mucho mas consistente y no va a subir tanto de complejidad.

public class Main {
    public static void main(String[] args) {
        // initialize game and map
        Game g = Game.getInstance();
        g.init(0);
        Config config = new Config();

        System.out.print("n\tNoSort\tInsertionSort\tMergeSort\tQuickSort\n");

        for(float scale = 0.5f ; scale < 1.5 ; scale += 0.2f) {
            Map map = new Map(new Point2D(config.get(Config.Parameter.MAP_SIZE_X) * scale,
                    config.get(Config.Parameter.MAP_SIZE_Y) * scale),
                    config.get(Config.Parameter.MAP_GRID_SPACE));
            map.init();

            // assign values to nodes and print map
            boolean printMap = false;
            MapNode center = map.getNodes()[map.getNodes().length / 2][map.getNodes()[0].length / 2];
            for (int i = 0; i < map.getNodes().length; i++) {
                for (int j = 0; j < map.getNodes()[i].length; j++) {
                    if (map.getNodes()[i][j].isWalkable()) {
                        if(printMap) {
                            System.out.print("   ");
                        }
                    } else {
                        float distanceToCenter = center.getPosition().distance(map.getNodes()[i][j].getPosition());
                        map.getNodes()[i][j].setValue(0, distanceToCenter);
                        if(printMap) {
                            System.out.printf("%2.0f ", distanceToCenter / 10f);
                        }
                    }
                }
                if(printMap) {
                    System.out.println();
                }
            }

            // select best nodes for towers
            Point2D size = g.getMap().getSize();
            float separation = map.getSeparation();
            int numberOfTowers = (int) (g.getParam(Config.Parameter.TOWER_DENSITY) * size.x * size.y / (separation * separation));
            ArrayList<MapNode> best = selectBestNodes(map.getNodesList(), numberOfTowers);
        }
    }

    private static ArrayList<MapNode> deepCopy(ArrayList<MapNode> nodes) {
        ArrayList<MapNode> copy = new ArrayList<>();
        for(MapNode node : nodes) {
            copy.add(new MapNode(node.getPosition(), node.isWalkable(), node.getValues()));
        }
        return copy;
    }

    private static boolean NodeListEquals(ArrayList<MapNode> a, ArrayList<MapNode> b, int valueIndex) {
        if(a.size() != b.size()) {
            return false;
        }
        for(int i=0; i<a.size(); i++) {
            if(a.get(i).getValue(valueIndex) != b.get(i).getValue(valueIndex)) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<MapNode>  selectBestNodes(ArrayList<MapNode> nodesList, int count) {
        int n = nodesList.size();
        long maxTime = 1000;

        System.out.print(n+"\t");

        // ========================== No sort ==========================
        int iterations = 0;
        Chronometer c = new Chronometer();
        ArrayList<MapNode> bestNoSort;
        do {
            c.pause();
            ArrayList<MapNode> nodesListCopy = deepCopy(nodesList);
            c.resume();
            bestNoSort = selectBestNodesNoSort(nodesListCopy, count);
            iterations++;
        } while(c.getElapsedTime() < maxTime);
        float timePerIteration = (float) c.getElapsedTime() / iterations;
        System.out.printf("%.4f\t", timePerIteration);

        // ========================== Insertion sort ==========================
        iterations = 0;
        c = new Chronometer();
        ArrayList<MapNode> bestInsertionSort;
        do {
            c.pause();
            ArrayList<MapNode> nodesListCopy = deepCopy(nodesList);
            c.resume();
            bestInsertionSort = selectBestNodesInsertionSort(nodesListCopy, count);
            iterations++;
        } while(c.getElapsedTime() < maxTime);
        timePerIteration = (float) c.getElapsedTime() / iterations;
        System.out.printf("%.4f\t", timePerIteration);

        if(!NodeListEquals(bestNoSort, bestInsertionSort, 0)) {
            System.out.println("ERROR");
        }

        // ========================== Merge sort ==========================
        iterations = 0;
        c = new Chronometer();
        ArrayList<MapNode> bestMergeSort;
        do {
            c.pause();
            ArrayList<MapNode> nodesListCopy = deepCopy(nodesList);
            c.resume();
            bestMergeSort = selectBestNodesMergeSort(nodesListCopy, count);
            iterations++;
        } while(c.getElapsedTime() < maxTime);
        timePerIteration = (float) c.getElapsedTime() / iterations;
        System.out.printf("%.4f\t", timePerIteration);

        if(!NodeListEquals(bestNoSort, bestMergeSort, 0)) {
            System.out.println("ERROR");
        }

        // ========================== Quick sort ==========================
        iterations = 0;
        c = new Chronometer();
        ArrayList<MapNode> bestQuickSort;
        do {
            c.pause();
            ArrayList<MapNode> nodesListCopy = deepCopy(nodesList);
            c.resume();
            bestQuickSort = selectBestNodesQuickSort(nodesListCopy, count);
            iterations++;
        } while(c.getElapsedTime() < maxTime);
        timePerIteration = (float) c.getElapsedTime() / iterations;
        System.out.printf("%.4f\t", timePerIteration);

        if(!NodeListEquals(bestNoSort, bestQuickSort, 0)) {
            System.out.println("ERROR");
        }

        System.out.println();

        return bestNoSort;
    }

    private static ArrayList<MapNode> selectBestNodesNoSort(ArrayList<MapNode> nodesList, int count) {
        // TODO: Return "count" nodes with the lowest value in the index 0 WITHOUT ORDERING the list. Given a node
        // in the list, the value of the node is accessed with node.getValue(0). For example, the following snippet
        // prints all the values of the nodes:
        //
        // for(MapNode node : nodesList) {
        //     System.out.println(node.getValue(0));
        // }
        //
        // Replace all the code in this method with your own code.
        ArrayList<MapNode> aux = new ArrayList<>(nodesList);
        ArrayList<MapNode> counts = new ArrayList<>();
        MapNode min = aux.get(0);
        while(counts.size()<count) {
            for (MapNode node : aux) {
                if (min.getValue(0) > node.getValue(0)) {
                    min = node;
                }
            }
            counts.add(min);
            aux.remove(min);
            min=aux.get(0);
        }
        return counts;
    }

    private static ArrayList<MapNode> selectBestNodesInsertionSort(ArrayList<MapNode> nodesList, int count) {
        ArrayList<MapNode> counts = new ArrayList<>();
        for(int i = 0; i < nodesList.size(); i++){
            MapNode nodoActual = nodesList.get(i);
            int pos = -1;
            for(int j = i; j>=0; j--){
                if(nodoActual.getValue(0) < nodesList.get(j).getValue(0)){
                    pos = j;
                }
            }
            if(pos != -1){
                nodesList.remove(nodoActual);
                nodesList.add(pos,nodoActual);
            }
        }
        for(int i = 0; i < count; i++){
            counts.add(nodesList.get(i));
        }
        return counts;
    }

    private static float getValue(ArrayList<MapNode> list, int index){
        return list.get(index).getValue(0);
    }

    private static void mezclar(ArrayList<MapNode> a, int inf, int medio, int sup){

        int i = inf;
        int j = medio+1;

        ArrayList<MapNode> b = new ArrayList<>();
        int k = 0;

        while(i <= medio && j <= sup) {
            if (getValue(a,i) <= getValue(a,j)) {
                b.add(k, a.get(i));
                i++;
            } else {
                b.add(k, a.get(j));
                j++;
            }
            k++;
        }
        while(i <= medio){
            b.add(k, a.get(i));
            i++;
            k++;
        }
        while(j <= sup){
            b.add(k, a.get(j));
            j++;
            k++;
        }
        k = 0;
        for(int f = inf; f <= sup; f++){
            a.set(f, b.get(k));
            k++;
        }
    }

    private static void ordenar(ArrayList<MapNode> a, int inf, int sup){
        if(inf < sup){
            ordenar(a,inf,(inf+sup)/2);
            ordenar(a,(inf+sup)/2+1,sup);
            mezclar(a, inf, (inf+sup)/2, sup);
        }
    }
    private static ArrayList<MapNode> selectBestNodesMergeSort(ArrayList<MapNode> nodesList, int count) {
        ordenar(nodesList,0, nodesList.size()-1);
        ArrayList<MapNode> counts = new ArrayList<>();

        for(int i = 0; i < count; i++){
            counts.add(nodesList.get(i));
        }
        return counts;
    }

    private static void intercambia(ArrayList<MapNode> a, int i , int j){
        MapNode aux = a.get(i);
        a.set(i,a.get(j));
        a.set(j, aux);
    }
    private static int partir(ArrayList<MapNode> a, int inf, int sup){
        float pivote = a.get(inf).getValue(0);
        int i = inf+1;
        int j = sup;

        do{
            while (i <= j && a.get(i).getValue(0) <= pivote){i++;}
            while (i <= j && a.get(j).getValue(0) > pivote){j--;}
            if(i<j){intercambia(a,i,j);}
        }while (i <= j);
        intercambia(a,inf,j);
        return j;
    }
    public static void ordenarQuick(ArrayList<MapNode> a, int inf, int sup){
        if(inf < sup){
            int p = partir(a, inf, sup);
            ordenarQuick(a, inf, p-1);
            ordenarQuick(a, p+1, sup);
        }
    }
    private static ArrayList<MapNode> selectBestNodesQuickSort(ArrayList<MapNode> nodesList, int count) {
        ArrayList<MapNode> counts = new ArrayList<>();
        ordenarQuick(nodesList,0, nodesList.size()-1);

        for(int i = 0; i < count; i++){
            counts.add(nodesList.get(i));
        }
        return counts;
    }
}