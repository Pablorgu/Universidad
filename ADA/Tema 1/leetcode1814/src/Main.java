import javax.management.InstanceNotFoundException;
import java.nio.channels.FileChannel;
import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n:arr) {
            int ocurrences;
            if(!map.containsKey(n)){
                ocurrences=1;
            }else {
                ocurrences=map.get(n)+1;
            }
            map.put(n,ocurrences);
        }
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer,Integer> me:map.entrySet()){
            set.add(me.getValue());
        }
        if(map.size()==set.size()){
            return true;
        }else{
            return false;
        }
    }
}