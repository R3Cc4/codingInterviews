import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//1-2,2-3,3-4,4-5,5-6,6-10,7-8

class myCode
{
    Map<String, List<String>> segmentmap = new HashMap<String, List<String>>();
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //System.out.println(input);

        String[] linesegs = input.split(",");
      /*  for(String lineseg:linesegs){
            System.out.println(lineseg);
        }*/

        myCode my = new myCode();
       String[] sortedSegs= my.sortSegments(linesegs);

       String finalOutput = my.lineSegment(sortedSegs);

        System.out.println(finalOutput);


}
    public   String[] sortSegments(String[] linesegs) {

        String[] sortedSegs = new String[linesegs.length];
        int[] startingpoints = new int[linesegs.length];
        int i =0;
        for (String seg : linesegs) {
            List<String> values = new ArrayList<String>();
            String[] splitvalue = seg.split("-");
            startingpoints[i]= Integer.parseInt(splitvalue[0]);
            i++;
            Set es = segmentmap.entrySet();

            if (es.contains(splitvalue[0])) {
                List<String> value = segmentmap.get(splitvalue[0]);
                value.add(splitvalue[1]);
                segmentmap.put(splitvalue[0], value);
            } else {

                List<String> value = new ArrayList<String>();
                value.add(splitvalue[1]);
                segmentmap.put(splitvalue[0], value);

            }

        }



        Arrays.sort(startingpoints);

        for(int j = 0;j<startingpoints.length;j++){

            String value = segmentmap.get(startingpoints[j]).toString();
            //segmentmap.get(startingpoints[j]).remove(0);
            sortedSegs[j]= startingpoints[j]+"-"+value;


        }

        for(String val:sortedSegs){
            System.out.println(val);
        }

        return sortedSegs;
    }
    public String lineSegment(String[] linesegments){
        String finalOutput = "";
       Map<String,String> finalMap = new HashMap<String ,String>();
        for(String segs:linesegments){
            String[] splitvalue = segs.split("-");
            if(!finalMap.containsKey(splitvalue[0])){
                finalMap.put(splitvalue[1],splitvalue[0]);
            }else{



            }



       }




return finalOutput;
    }

}