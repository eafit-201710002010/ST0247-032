import java.util.*;
import java.io.*;
//import javafx.util.Pair;
/**
 * Write a description of class ejercicioEnLinea here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ejercicioEnLinea
{
 public static void ejercicio2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio en linea");
        int n = sc.nextInt(); //Numero de escenarios
        for (int i = 0; i < n; i++) {
            int mundox= sc.nextInt();// Coordenada x del tamaño del mundo
            int mundoy= sc.nextInt();// Coordenada y del tamañano del mundo
            ArrayList<Pair> coord = new ArrayList<Pair>();
            coord.add(Pair.makePair(sc.nextInt(),sc.nextInt())); // Coordenada inicial de KAROLINA
            int dr = sc.nextInt(); // Numero de desechos radioactivos
            for (int j = 0; j < dr; j++){ 
                int drx=sc.nextInt();
                int dry= sc.nextInt();
                if(drx <= mundox && dry <= mundoy)
                    coord.add(Pair.makePair(drx,dry)); // Coordenadas desechos radioactivos
                    else 
                    System.out.println("Fuera de rango"); 
                    
            }
            
            Digraph g = new DigraphAL(coord.size());
            for (int k = 0; k < coord.size(); k++) {
                for (int l = 0; l < coord.size(); l++) {
                    if(k != l) {
                        g.addArc(k,l,(Math.abs((int)coord.get(k).first - (int)coord.get(l).first)) + Math.abs((int)coord.get(k).second - (int)coord.get(l).second));
                    }
                }
            }
            int result= heldKarp(g);
           System.out.println("The shortest path has length: " + result);
        }
    }
    public static int heldKarp(Digraph g) {
    Map<Pair<Integer, Set<Integer>>, Integer> costs = new HashMap<>();
    //Todos los sub-conjuntos que contiene el grafo
    List<Set<Integer>> allSets = generateCombination(g.size() - 1);
    for (Set<Integer> set : allSets) {
      for (int i = 1; i < g.size(); i++) {
        if (set.contains(i)) {
          continue;
        }

        Pair<Integer, Set<Integer>> pareja = new Pair<>(i, set);
        int minCost = Integer.MAX_VALUE;
        int minPrev = 0;
        Set<Integer> temp = new HashSet<>(set); //Set temporal para evitar daños a los sets

        for (int prev : set) {
          temp.remove(prev);
          Pair<Integer, Set<Integer>> prevDist = new Pair<>(prev, temp);

          int cost = g.getWeight(prev, i) + costs.get(prevDist); //Analiza la distancia hasta el vertice y la distancia pasando por los que faltan en el conjunto
          if (cost < minCost) {
            minCost = cost;
            minPrev = prev;
          }

          temp.add(prev);
        }

        //Si el set es vacio
        if (set.size() == 0) {
          minCost = g.getWeight(0, i);
        }

        //Añade la pareja con el costo (valor para llegar pasando por el conjunto)
        costs.put(pareja, minCost);
      }
    }

    //Analizamos la ruta mas corta
    Set<Integer> vertices = new HashSet<>();
    for (int i = 1; i < g.size(); i++) {
      vertices.add(i);
    }
    int result = Integer.MAX_VALUE;
    int prev = -1;
    Set<Integer> temp = new HashSet<>(vertices);
    for (int v : vertices) {
      temp.remove(v);
      Pair<Integer, Set<Integer>> prevDist = new Pair<>(v, temp);

      int cost = g.getWeight(v, 0) + costs.get(prevDist);
      if (cost < result) {
        result = cost;
        prev = v;
      }

      temp.add(v);

    }

    return result; //Retornamos el menor costo (Suma de pesos de la ruta)
  }

  //Metodos y clases Auxiliares

  private static List<Set<Integer>> generateCombination(int n) {
    int input[] = new int[n];
    for (int i = 0; i < input.length; i++) {
      input[i] = i + 1;
    }
    List<Set<Integer>> allSets = new ArrayList<>();
    int result[] = new int[input.length];
    generateCombination(input, 0, 0, allSets, result);
    Collections.sort(allSets, new SetSizeComparator());
    return allSets;
  }

  private static void generateCombination(int input[], int start, int pos, List<Set<Integer>> allSets, int result[]) {
    if (pos == input.length) {
      return;
    }
    Set<Integer> set = createSet(result, pos);
    allSets.add(set);
    for (int i = start; i < input.length; i++) {
      result[pos] = input[i];
      generateCombination(input, i + 1, pos + 1, allSets, result);
    }
  }

  private static Set<Integer> createSet(int input[], int pos) {
    if (pos == 0) {
      return new HashSet<>();
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < pos; i++) {
      set.add(input[i]);
    }
    return set;
  }

  private static class SetSizeComparator implements Comparator<Set<Integer>> {
    @Override
    public int compare(Set<Integer> o1, Set<Integer> o2) {
      return o1.size() - o2.size();
    }
  }
}
