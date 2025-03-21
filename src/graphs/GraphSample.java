package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphSample {


    private static void creatreGraph(HashMap<Integer, ArrayList<Integer>> matrix){

        matrix.put(0, new ArrayList<>());
        matrix.put(1, new ArrayList<>());
        matrix.put(2, new ArrayList<>());


        matrix.get(0).add(1);
        matrix.get(0).add(2);
        matrix.get(0).add(3);

        matrix.get(1).add(4);
        matrix.get(1).add(2);

        matrix.get(2).add(0);
        matrix.get(2).add(1);

    }

//    private void displayGraph(){
//
//    }
//
    public static void main(String[] args) {

        HashMap<Integer, ArrayList<Integer>> matrix = new HashMap<>();

        creatreGraph(matrix);
       // displayGraph(matrix);
        System.out.println(matrix);


    }
}
