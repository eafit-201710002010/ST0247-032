import java.util.ArrayList;
/**
 * Write a description of class AgenteViajero here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AgenteViajero
{
    public static int[] agenteViajero(Graph g, int inicio){
        boolean[] visited = new boolean[g.size()];
        int[] res = new int[g.size()];
        ArrayList<Integer> successors = new ArrayList<Integer>();
        int actual = inicio;
        int costo = 0;
        for(int i = 0; i < g.size(); ++i){
            int minimo = Integer.MAX_VALUE;
            int cerca = 0;
            successors = g.getSuccessors(actual);
            visited[actual] = true;
            if(i==g.size()-1){
                visited[inicio] = false;
            }
            for(Integer sucesor : successors){
                if(!visited[sucesor] && sucesor != actual && (g.getWeight(actual, sucesor) < minimo)){
                    minimo = g.getWeight(actual,sucesor);
                    cerca = sucesor;
                }
            }
            actual = cerca;
            res[i] = actual;
            costo += minimo;
        }
        return res;
    }
}
