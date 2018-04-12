
/**
 * Clase en la cual se implementan los metodos del Taller de Clase #9
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller9 {

    public static int levenshtein(String a, String b) {
        int cont = 0;
        int[][] lev = new int[a.length()+1][b.length()+1];
        for(int i = 0; i < a.length()+1; ++i){
            lev[i][0] = i;
        }
        for(int j = 0; j < b.length()+1; ++j){
            lev[0][j] = j;
        }
        for(int i = 1; i <= a.length(); ++i){
            for(int j = 1; j <= b.length(); ++j){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    lev[i][j] = lev[i-1][j-1];
                }
                else{
                    lev[i][j] = Math.min(Math.min(lev[i-1][j]+1, lev[i][j-1]+1), lev[i-1][j-1]+1);
                }
            }
        }
        System.out.println(lev[a.length()][b.length()]);
        return lev[a.length()][b.length()];
    }

}
