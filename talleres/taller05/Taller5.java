import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #5
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller5 {

    public static boolean mColoring(Digraph g, int m) {
        int []colors = new int[m];
        for(int i=0; i<m; ++i){
            colors[i] = 0;
        }
        if(!mColoring(g, 0, colors, m)){
            return false;
        }
        return true;
    }

    // recomendacion
    private static boolean isSafe(Digraph g, int v, int[] colors, int c) {
        ArrayList<Integer> sucesores = g.getSuccessors(v);
        for(Integer vecino : sucesores){
            if(vecino == 1 && c == colors[vecino]){
                return false;
            }
        }
        return true;
    }

    // recomendacion
    private static boolean mColoring(Digraph g, int v, int[] colors, int m) {
        if(v==m){
            return true;
        }
        for(int i = 0; i<m; ++i){
            if(isSafe(g,i,colors,m)){
                colors[v] = i;
                if(mColoring(g,v+1, colors, m)){
                    return true;
                }
                colors[v] = 0;
            }
        }
        return false;
    }

}
