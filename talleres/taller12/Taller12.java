import java.util.Arrays;
/**
 * Write a description of class NReinas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taller12
{
    public static int nAtaques(int[] tablero){
        int cont = 0;
        int dist = 0;
        for(int i = 0; i < tablero.length; ++i){
            for(int j = i+1; j < tablero.length; ++j){
                if(tablero[i] == tablero[j]){
                    ++cont;
                }
                dist = j-i;
                if((tablero[i] == tablero[j] - dist) || tablero[i] == tablero[j] + dist){
                    cont++;
                }
            }
        }
        return cont;
    }
    
    public static int[] nReinas(int n){
        int max = 10000;
        int[] tablero = new int[n];
        int min = Integer.MAX_VALUE;
        int c = 0;
        for(int pos : tablero){
            tablero[pos] = 0;
        }
        while(nAtaques(tablero) != 0 && c < max){
            tablero = cambios(tablero);
            ++c;
        }
        return tablero;
    }
    
    public static int[] cambios(int[] tablero){
        int min = Integer.MAX_VALUE;
        int[] mejor = tablero.clone();
        int[] temp = tablero.clone();
        int ataques = nAtaques(tablero);
        for(int c = 0; c < temp.length; ++c){
            for(int f = 0; f < temp.length; ++f){
                temp[c] = f;
                ataques = nAtaques(temp);
                if(ataques < min){
                    min = ataques;
                    mejor[c] = f;
                } 
            } 
            temp = tablero.clone();
        }
        return mejor;
    }
    
    public static void main(String[] args){
        int[] res = nReinas(4);
        System.out.println(Arrays.toString(res));
    }
}

