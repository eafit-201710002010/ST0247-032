import java.util.*;
import javafx.util.Pair;
/**
 * Write a description of class Taller11 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HeldKarp
{
    public static int heldKarp(Digraph g){
        Map<Pair<Integer, Set<Integer>>, Integer> costos = new HashMap<>();
        List<Set<Integer>> combinaciones = generarCombinaciones(g.size()-1);
        for(Set<Integer> combinacion : combinaciones){
            for(int i = 1; i < g.size(); ++i){
                if(!combinacion.contains(i)){
                    Pair<Integer, Set<Integer>> pair = new Pair<>(i,combinacion);
                    int costoMin = Integer.MAX_VALUE;
                    int min = 0;
                    Set<Integer> temp = new HashSet<>(combinacion);
                    for(int prev : combinacion){
                        temp.remove(prev);
                        Pair<Integer, Set<Integer>> d = new Pair<>(prev,temp);
                        int costo = g.getWeight(prev,i) + costos.get(d);
                        if(costo < costoMin){
                            costoMin = costo;
                            min = prev;
                        }
                        temp.add(prev);
                    }
                    if(combinacion.size() == 0){
                        costoMin = g.getWeight(0, i);
                    }
                    costos.put(pair,costoMin);
                }
            }
        }
        
        Set<Integer> vertices = new HashSet<>();
        for(int i = 1; i < g.size(); ++i){
            vertices.add(i);
        }
        int res = Integer.MAX_VALUE;
        int anterior = -1;
        Set<Integer> temp = new HashSet<>(vertices);
        for(int vertice : vertices){
            temp.remove(vertice);
            Pair<Integer, Set<Integer>> d = new Pair<>(vertice, temp);
            int costo = g.getWeight(vertice, 0) + costos.get(d);
            if(costo < res){
                res = costo;
                anterior = vertice;
            }
            temp.add(vertice);
        }
        return res;
    }
    
    private static List<Set<Integer>> generarCombinaciones(int n){
        int entrada[] = new int[n];
        for(int i = 0; i < entrada.length; ++i){
            entrada[i] = i+1;
        }
        List<Set<Integer>> combinaciones = new ArrayList<>();
        int res[] = new int[entrada.length];
        generarCombinaciones(entrada, 0, 0, combinaciones, res);
        Collections.sort(combinaciones, new SetSizeComparator());
        return combinaciones;
    }
    
    private static void generarCombinaciones(int entrada[], int inicio, int pos, List<Set<Integer>> combinaciones, int[] res){
        if(pos == entrada.length){
            return;
        }
        Set<Integer> set = crearSet(res, pos);
        combinaciones.add(set);
        for(int i = inicio; i < entrada.length; ++i){
            res[pos] = entrada[i];
            generarCombinaciones(entrada, i+1, pos+1, combinaciones, res);
        }
    }
    
    private static Set<Integer> crearSet(int[] entrada, int pos){
        if(pos == 0){
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < pos; ++i){
            set.add(entrada[i]);
        }
        return set;
    }
    
    public static void main(String [] args){
        DigraphAL g =new DigraphAL(4);
        g.addArc(0,1,7);
        g.addArc(0,2,15);
        g.addArc(0,3,6);
        g.addArc(1,0,2);
        g.addArc(1,2,7);
        g.addArc(1,3,3);
        g.addArc(2,1,6);
        g.addArc(2,0,9);
        g.addArc(2,3,12);
        g.addArc(3,0,10);
        g.addArc(3,1,4);
        g.addArc(3,2,8);
        
        System.out.println(heldKarp(g));
    
    }
    
    private static class SetSizeComparator implements Comparator <Set<Integer>>{
        @Override
        public int compare(Set<Integer> o1, Set<Integer> o2){
            return o1.size() - o2.size();
        }
    }
}
