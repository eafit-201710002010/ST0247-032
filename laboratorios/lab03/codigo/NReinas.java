
/**
 * Write a description of class nReinas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NReinas
{
    private static boolean puedoPonerReina(int r, int c, int[] tablero){
        for(int i = 0; i < r; ++i){
            if(tablero[i] == c || (i - r) == (tablero[i] - c) || (i - r) == (c - tablero[i])){
                return false;
            }
        }
        return true;
    }
    
    public static boolean nReinas(int n){
        int [] tablero = new int[n];
        if(nReinas(0,n,tablero)){
            //imprimirTablero(tablero);
            return true;
        }
        return false;
    }
    
    private static boolean nReinas(int r, int n, int[] tablero){
        if(r == n){
            return true;
        }
        for(int c = 0; c < n; ++c){
            if(puedoPonerReina(r,c,tablero)){
                tablero[r] = c;
                if(nReinas(r+1, n, tablero)){
                    return true;
                }
            }
        }
        return false;
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
    
    public static long tomarTiempo(int n){   
        long startTime = System.currentTimeMillis();
        nReinas(n);
        long estimatedTime = System.currentTimeMillis() - startTime;
        return estimatedTime;
        }
    public static void tiempos(){
        for(int i=4; i <=32;i++){
            System.out.println(tomarTiempo(i));
        }
    }
}
