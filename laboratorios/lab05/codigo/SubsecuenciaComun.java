
/**
 * Write a description of class SubsecuenciaComun here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SubsecuenciaComun
{
    //Ejercicio 1.3
    public static int lcs(String a, String b){
        int[][] tabla = new int[a.length()+1][b.length()+1];
        for(int i = 0; i <= a.length(); ++i){
            tabla[i][0] = 0;
        }
        for(int j = 0; j <= b.length(); ++j){
            tabla[0][j] = 0;
        }
        for(int i = 1; i <= a.length(); ++i){
            for(int j = 1; j <= b.length(); ++j){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    tabla[i][j] = tabla[i-1][j-1]+1;
                }
                else{
                    tabla[i][j] = Math.max(tabla[i-1][j], tabla[i][j-1]);
                }
            }
        }
        return tabla[a.length()][b.length()];
    }
    
    //Ejercicio 1.4 OPCIONAL
    public static String lcsdyn(String a, String b){
        int[][] tabla = new int[a.length()+1][b.length()+1];
        String res = "";
        for(int i = 0; i <= a.length(); ++i){
            for(int j = 0; j <= b.length(); ++j){
                if(i == 0 | j == 0){
                    tabla[i][j] = 0;
                }
                else if(a.charAt(i-1) == b.charAt(j-1)){
                    res += a.charAt(i-1);
                    tabla[i][j] = tabla[i-1][j-1] +1;
                }
                else{
                    tabla[i][j] = Math.max(tabla[i-1][j], tabla[i][j-1]);
                }
            }
        }
        return res;
    }
}
