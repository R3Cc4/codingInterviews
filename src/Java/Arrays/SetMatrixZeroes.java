package Java.Arrays;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by Vamsi on 7/24/2016.
 */
public class SetMatrixZeroes {



    public static void main(String[] args){

        ArrayList<Integer> row1 = new ArrayList();
        ArrayList<Integer> row2 = new ArrayList();

        row1.add(0);
        row1.add(1);
        row2.add(1);
        row2.add(1);

        ArrayList<ArrayList<Integer>> list = new ArrayList();
        list.add(row1);
        list.add(row2);

        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(list);
        list.stream().forEach(x->x.stream().forEach(System.out::println));

    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int rowSize=a.size();
        int colSize=a.get(0).size();
        int[] rowList = IntStream.range(0,a.get(0).size()).map(x->x=1).toArray();
        int[] colList = IntStream.range(0,a.size()).map(x->x=1).toArray();
        for(int i = 0;i<a.size();i++){
            for(int j = 0; j<a.get(0).size();j++){
                if(a.get(i).get(j)==0){
                    rowList[j]=0;
                    colList[i]=0;
                }
            }
        }
        putMatrixZeroes(a,rowList,colList);
    }
    public void putMatrixZeroes(ArrayList<ArrayList<Integer>>a,int[] rowList,int[] colList){
        int rowSize = a.size();
        int colSize = a.get(0).size();
        for(int i = 0;i<rowSize;i++){
            for(int j = 0;j<colSize;j++){
                if(rowList[j]==0 || colList[i]==0){
                    a.get(i).set(j,0);
                }
            }
        }
    }
}
