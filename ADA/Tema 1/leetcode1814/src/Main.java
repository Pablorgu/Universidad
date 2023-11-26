import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Main {
    public int maxCoins(int[] piles) {
        int coinsperperson=piles.length/3;
        int res = 0;
        int contador=0;
        Arrays.sort(piles);
        for(int i = (piles.length-1); i>=0; i--){
            if((contador%2)==1 && (contador/2)<coinsperperson){
                res+=piles[i];
                ++contador;
            }
        }
        return res;
    }
}