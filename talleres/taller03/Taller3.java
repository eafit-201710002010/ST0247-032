import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #3
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller3 {
    static int cont;
    private static boolean puedoPonerReina(int r, int c, int[] tablero) {
        for (int i = 0; i < r; i++) {
            if (tablero[i] == c || (i - r) == (tablero[i] - c) ||(i - r) == (c - tablero[i])) 
            {
                return false;
            }
        }
        return true;
    }
    
    public static int nReinas(int n) {
        int[] tablero = new int[n];
        cont = 0;
        return nReinas(0,n,tablero);
    }
    
    private static int nReinas(int r, int n, int[] tablero){
        for (int c = 0; c < n; c++) {
            if (puedoPonerReina(r, c, tablero)) {
                tablero[r] = c;
                if (r == n - 1) {
                    imprimirTablero(tablero);
                    ++cont;
                } else {
                    nReinas(r + 1, n, tablero);
                }
            }
        }
        return cont;
    }
    
    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    public static ArrayList<Integer> camino(Digraph g, int inicio, int fin) {
          boolean[] visitados = new boolean[g.size()];
          ArrayList<Integer> list = new ArrayList<Integer>();
          dfs(g, inicio, fin, visitados, list);
          return list;
    }

    private static boolean dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {        
        if (nodo == objetivo){ 
            return true;
        }
        else{
            ArrayList<Integer> s = g.getSuccessors(nodo);
            for(int i=0; i<s.size(); ++i){
                if(visitados[s.get(i)] == false){
                    visitados[s.get(i)] = true;
                    list.add(nodo);
                    dfs(g,s.get(i),objetivo,visitados,list);
                }
            }       
        }
        return false;
    }
}
