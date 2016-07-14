package july.dealertrack.asgs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Vamsi on 7/9/2016.
 */
public class FrequentArtists {


    public static void main(String[]args) throws IOException {


        FileInputStream fileInputStream=null;
        System.out.println("Please Enter the Input File location : ");
        Scanner consoleInput = new Scanner(System.in);
        String inputFileLocation = consoleInput.nextLine();
        File file = new File(inputFileLocation);

        byte[] bFile = new byte[(int) file.length()];

        try {
            //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            String inputText = new String(bFile);
            /*for (int i = 0; i < bFile.length; i++) {
                System.out.print((char)bFile[i]);
            }*/

           // System.out.println(letssee);

           String[] lines = inputText.split("\n");
           //System.out.println(lines.length);
            Map<String, Integer> wordlist = oneItemSet(lines);
            /*System.out.println( wordlist.values().toArray().length);
            wordlist.forEach((k, v) -> System.out.println("Key =" + k + " : " + "Value =" + v));
*/
            Map<String,Integer> wordlist2 = twoItemList(lines, wordlist);
            List<String> finalOutput = new ArrayList<String>();
            //wordlist2.forEach((k, v) -> System.out.println( k ));
            Path parentDirectory = Paths.get(inputFileLocation).getParent();

            FileWriter writer = new FileWriter(parentDirectory+"/output.csv");
            wordlist2.forEach((k, v) -> {System.out.println(k);try{writer.append(k);writer.append('\n');}catch(Exception e){e.printStackTrace();}});
            writer.flush();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Map<String,Integer> oneItemSet(String[] lines){
        Map<String,Integer> wordList = new HashMap<String,Integer>();
        for(String line:lines){
            String[] words = line.split(",");
            for(String word:words){
              if(wordList.containsKey(word)){
                  Integer value = wordList.get(word);
                  wordList.put(word,++value);
              }else{
                  wordList.put(word,1);
              }
            }
        }
        Map<String,Integer> wrdlist = new HashMap<String,Integer>();
        wordList.forEach((k,v)->{if(v>50){wrdlist.put(k,v);}});
        return wrdlist;
    }

    public static Map<String,Integer> twoItemList(String[] lines,Map<String,Integer> oneItemList){
        List<String> twoItemList= new ArrayList<String>();
        Map<String,Integer> output = new HashMap<String,Integer>();
        //form new list with two items.
       Object[] listItems= oneItemList.keySet().stream().toArray();
        for(int i=0;i<listItems.length-1;i++){
            for(int j=i+1;j<listItems.length;j++){
                String key = listItems[i].toString()+","+listItems[j].toString();
                twoItemList.add(key);
            }
        }
        //System.out.println(twoItemList.size());
        //twoItemList.stream().forEach(System.out::println);

        for(String line:lines){

            for(String item:twoItemList) {
                String[] items = item.split(",");
                if (line.contains(items[0])&&line.contains(items[1])){
                    if(output.containsKey(item)){
                         output.put(item,output.get(item)+1);

                    }else{
                        output.put(item,1);
                    }
                }

            }

        }
        Map<String,Integer> wrdlist = new HashMap<String,Integer>();
        output.forEach((k,v)->{if(v>50){wrdlist.put(k,v);}});
        return wrdlist;
    }

}
