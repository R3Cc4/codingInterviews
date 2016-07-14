package july.dealertrack.asgs;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Vamsi on 7/9/2016.
 */

/**
 * Is Input order Important??
 */


public class KeyCounts {
private Map<String,Integer> keyMap;
    public KeyCounts(Map<String, Integer> map){
        this.keyMap=map;
    }
    public void add(String line){
        // check if the key is already there. If the key is already there update the value count otherwise add the key to
        //map.
        String[] keyValueArray = line.split(":");
        if(keyMap.containsKey(keyValueArray[0])){
          Integer value =  keyMap.get(keyValueArray[0]);
            value+=Integer.parseInt(keyValueArray[1]);
            keyMap.put(keyValueArray[0],value);
        }else{
            keyMap.put(keyValueArray[0],Integer.parseInt(keyValueArray[1]));
        }
    }
    public void readMap(){
        keyMap.forEach((k,v)->System.out.println(k+" : "+v.toString()));
    }
public static void main(String [] args) throws IOException {
    KeyCounts keyCounts = new KeyCounts(new HashMap<String,Integer>());
    Stream<String> lines = Files.lines(Paths.get("H:\\Java Learning\\coding Interviews\\src\\july\\dealertrack\\asgs","keys.txt"));
    lines.forEach(keyCounts::add);
    keyCounts.readMap();

}


}
