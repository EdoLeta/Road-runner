package UI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class cayote{

    //    private static ArrayList<Character> read = new ArrayList<Character>();
    public ArrayList<ArrayList<Character>> Reader1(String filepath) throws FileNotFoundException {
//        Array Lines will have all the lines as items
        ArrayList<String> Lines = new ArrayList<String>();
        BufferedReader objReader = null;
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader(filepath));

            while ((strCurrentLine = objReader.readLine()) != null) {
                Lines.add(strCurrentLine);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String [] two = Lines.get(0).split(" ");

//        This is the number of row
        int row = Integer.parseInt(two[0]);
//        This is the number of columns
        int column = Integer.parseInt(two[1]);

        ArrayList<ArrayList<Character>> Environment = new ArrayList<ArrayList<Character>>();

        int p = 1;
        while (p < Lines.size()){
            char[] S = Lines.get(p).toCharArray();
            ArrayList<Character> toappend = new ArrayList<Character>();
            int n = 0 ;
            while (n < S.length){
                toappend.add(S[n]);
                n+=1;
            }
            Environment.add(toappend);
            p+=1;

        }
        System.out.println(Environment);
        return Environment;
    }

    public static void main(String[] args) throws FileNotFoundException {

    }
}