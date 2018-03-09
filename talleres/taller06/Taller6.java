import java.util.ArrayList;
/**
 * Clase en la cual se implementan los metodos del Taller de Clase #6
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller6 {

    public static int[] cambioGreedy(int n, int[] denominaciones) {
        int resp[] = new int[denominaciones.length];
        int mod =n;
        int sum=0;
        for(int i=0; i < denominaciones.length;++i){
             if(mod!=0){
                resp[i]= mod/denominaciones[i];
                sum+=(resp[i]*denominaciones[i]);
                mod= mod%denominaciones[i];
            }
        }
        if(sum != n){
             return null;
          }
        return resp;
    }

    public static int recorrido(Digraph g) {
        ArrayList<Integer> successors = new ArrayList<Integer>();
        boolean[] recorrido = new boolean[g.size()];
        int actual = 0;
        int costo = 0;   
            for(int i=0; i<g.size();i++){
            int minimo = 400000000; 
            int cerca=0;
            successors = g.getSuccessors(actual);
            recorrido[actual]=true;
             if(i==g.size()-1){
                recorrido[0]=false;
            }
            for(int sucesor : successors){   
                if(!recorrido[sucesor] && sucesor!= actual && (g.getWeight(actual, sucesor)<minimo)){
                    minimo = g.getWeight(actual, sucesor);
                    cerca = sucesor;
                }
            } 
            actual = cerca;
            costo += minimo;
        }
        return costo;
    }
}
