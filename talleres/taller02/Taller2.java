import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #2
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller2 {
    static int cont = 0;
    
    public static ArrayList<String> combinations(String s) {
        ArrayList<String> lista = new ArrayList<String>();
        combinations("",s,lista);
        return lista;
    }

    // recomendacion
    private static void combinations(String pre, String pos, ArrayList<String> list) {
        if(pos.length() == 0){
            list.add(pre);
        }
        else{
            combinations(pre + pos.charAt(0), pos.substring(1), list);
            combinations(pre, pos.substring(1), list);
        }
    }

    public static ArrayList<String> permutations(String s) {
        ArrayList<String> lista = new ArrayList<String>();
        permutations("",s,lista);
        return lista;
    }

    // recomendacion
    private static void permutations(String pre, String pos, ArrayList<String> list) {
        if(pos.length() == 0){
            list.add(pre);
        }
        else{
            for(int i = 0; i<pos.length(); ++i){
                permutations(pre + pos.charAt(i), pos.substring(0,i) + pos.substring(i+1, pos.length()), list);
            }
        }
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

    public static boolean esValido(int[] tablero) {
        for(int i=0; i<tablero.length; ++i){
            for(int j=i+1; j<tablero.length; ++j){
                if(tablero[i] == tablero[j] || Math.abs(tablero[i] - tablero[j]) == Math.abs(i-j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static int queens(int n) {
        int[] tablero = new int[n];
        String nums = "";
        cont = 0;
        for(int i = 0; i < n; ++i){
            nums += i;
        }
        queensAux("", nums, tablero);
        return cont;
    }
   
    public static void queensAux(String pre, String pos, int[] tablero){
        if(pos.length() == 0){
            for(int i = 0; i < pre.length(); ++i){
                tablero[i] = Character.getNumericValue(pre.charAt(i));
            }
            if(esValido(tablero) == true){
                ++cont;
            }
        }
        else{
            for(int j = 0; j < pos.length(); ++j){
                    queensAux(pre + pos.charAt(j), pos.substring(0,j) + pos.substring(j+1, pos.length()), tablero);
            }
        }
    }
}