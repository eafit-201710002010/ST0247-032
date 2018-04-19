
/**
 * Write a description of class Taller10 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taller10
{
    public static int lcs(String x, String y){
        int[][] tabla = new int[x.length()+1][y.length()+1];
        for(int i = 0; i <= x.length(); ++i){
            tabla[i][0] = 0;
        }
        for(int j = 0; j <= y.length(); ++j){
            tabla[0][j] = 0;
        }
        for(int i = 1; i <= x.length(); ++i){
            for(int j = 1; j <= y.length(); ++j){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    tabla[i][j] = tabla[i-1][j-1]+1;
                }
                else{
                    tabla[i][j] = Math.max(tabla[i-1][j], tabla[i][j-1]);
                }
            }
        }
        return tabla[x.length()][y.length()];
    }
    
    public static String lcsdyn(String x, String y){
        int[][] tabla = new int[x.length()+1][y.length()+1];
        String m = "";
        for(int i = 0; i <= x.length(); ++i){
            for(int j = 0; j <= y.length(); ++j){
                if(i == 0 | j == 0){
                    tabla[i][j] = 0;
                }
                else if(x.charAt(i-1) == y.charAt(j-1)){
                    m += x.charAt(i-1);
                    tabla[i][j] = tabla[i-1][j-1] +1;
                }
                else{
                    tabla[i][j] = Math.max(tabla[i-1][j], tabla[i][j-1]);
                }
            }
        }
        return m;
    }
}
