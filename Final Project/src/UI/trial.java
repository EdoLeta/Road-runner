package UI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class trial
{
    // Write the fields that you need to define the movement of coyote
    // A field for the x position
    static int xposition;
    // A field for the y position
    static int yposition;

    // Create a variable to keep track of count
    static int count = 0;

    static int count2 = 0;

    // Create a stack
    static Stack<int []> undoStack = new Stack<>();

    // Create a stack
    static Stack<int []> redoStack = new Stack<>();

    // Create a variable to check for the current image
    static int runner_check;
    // Create a variable to check the score
    static int score = 20;
    static int energy;

    static List<Integer> hold = new LinkedList<Integer>();


    // Create a function that changes the position of coyote to the north
    public static void north(ImageView image, GridPane grid, ArrayList<int[]> new_grid, HashMap<Integer,Image> road_map_alt, ArrayList<int[]> road_map)
    {


        // Call the function for the x position
        int xposition1 = main.x(image);
        // Call the function for the y position
        int yposition1 = main.y(image);

        xposition = main.x(image);
        // Call the function for the y position
        yposition = main.y(image);


        if (xposition > 0 && prevent_backwards(String.valueOf(xposition - 1) + (yposition))
                && !getBoulder(xposition - 1, yposition, road_map) && !getStart(xposition-1, yposition, road_map))
        {
            alternative(grid,image,road_map,road_map_alt,xposition,yposition);
            xposition = xposition - 1;

            hold.add(yposition);
            grid.add(image, yposition, xposition);
//            System.out.println(xposition + " " + yposition);

            prevent_back.put(String.valueOf(xposition) + (yposition),true);
//            System.out.println(prevent_back);

//            ImageView goal = new ImageView(road_map_alt.get(9));
            image = new ImageView(road_map_alt.get(9));
            int x = (int) image.getX();
            int y = (int) image.getY();

            runner_check = road_map.get(xposition)[yposition];
//            System.out.println(runner_check);

            // Push the position the runner is
            undoStack.push(new int[]{xposition, yposition});


            // When coyote makes one move, a file is created and his movements are traced
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DirectionforInput1_timestamp", true)));
                if (count == 0)
                {
                    out.println("Start : " + xposition1 + " " + yposition1);
                    out.println("Goal : " + x + " " + y);
                    count++;
                }
                out.println("North");
                out.close();
            } catch (IOException e) {}
        }
        else {return;}
//        get_score();
    }
    // Space complexity O(n)
    // Time complexity O(1)
    // Auxiliary space O(1)

    // Create a function that changes the position of coyote to the south
    public static void south(ImageView image, GridPane grid, ArrayList<int[]> new_grid, HashMap<Integer,Image> road_map_alt, ArrayList<int[]> road_map)
    {
        xposition = main.x(image);
        // Call the function for the y position
        yposition = main.y(image);

        if (xposition < road_map.size() - 1 && prevent_backwards(String.valueOf(xposition + 1) + (yposition))
                && !getBoulder(xposition + 1, yposition, road_map)&& !getStart(xposition+1, yposition, road_map))
        {
            alternative(grid,image,road_map,road_map_alt,xposition,yposition);
            xposition = xposition + 1;

            hold.add(yposition);
            grid.add(image, yposition, xposition);
//            System.out.println(xposition + " " + yposition);

            prevent_back.put(String.valueOf(xposition) + (yposition),true);
//            System.out.println(prevent_back);

            runner_check = road_map.get(xposition)[yposition];
//            System.out.println(runner_check);

            // Push the position of the runner
            undoStack.push(new int[]{xposition, yposition});

            // When coyote makes one move, a file is created and his movements are traced
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DirectionforInput1_timestamp", true)));
                out.println("South");
                out.close();
            } catch (IOException e) {}
        }
        else {return;}
//        get_score();
    }

    // Create a function that changes the position of coyote to the east
    public static void east(ImageView image, GridPane grid, ArrayList<int[]> new_grid, HashMap<Integer,Image> road_map_alt, ArrayList<int[]> road_map)
    {
        xposition = main.x(image);
        // Call the function for the y position
        yposition = main.y(image);

        if (yposition < road_map.get(1).length - 1 && prevent_backwards(String.valueOf(xposition) + (yposition + 1))
                &&!getBoulder(xposition, yposition + 1, road_map)&& !getStart(xposition, yposition+1, road_map))
        {
            alternative(grid,image,road_map,road_map_alt,xposition,yposition);
            yposition = yposition + 1;

            hold.add(yposition);
            grid.add(image, yposition, xposition);
//            System.out.println(xposition + " " + yposition);

            prevent_back.put(String.valueOf(xposition) + (yposition),true);
//            System.out.println(prevent_back);

            runner_check = road_map.get(xposition)[yposition];
//            System.out.println(runner_check);

            // Push the position of the runner
            undoStack.push(new int[]{xposition, yposition});

            // When coyote makes one move, a file is created and his movements are traced
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DirectionforInput1_timestamp", true)));
                out.println("East");
                out.close();
            } catch (IOException e) {}
        }
        else {return;}
//        get_score();
    }

    // Create a function that changes the position of coyote to the west
    public static void west(ImageView image, GridPane grid, ArrayList<int[]> new_grid, HashMap<Integer,Image> road_map_alt, ArrayList<int[]> road_map)
    {
        // For the north function, i will need to increase the position of the x coordinates
        // If the image is at position greater than 0 of x then reduce the position of the x
        // Call the function that returns the position of the image we are going to give it as a parameter
        // Call the function for the x position
        xposition = main.x(image);
        // Call the function for the y position
        yposition = main.y(image);

        if (yposition > 0 && prevent_backwards(String.valueOf(xposition) + (yposition - 1))
                &&!getBoulder(xposition, yposition - 1, road_map)&& !getStart(xposition, yposition-1, road_map))
        {
            alternative(grid,image,road_map,road_map_alt,xposition,yposition);
            yposition = yposition - 1;

            hold.add(yposition);
            grid.add(image, yposition, xposition);
//            System.out.println(xposition + " " + yposition);

            prevent_back.put(String.valueOf(xposition) + (yposition),true);
//            System.out.println(prevent_back);

            runner_check = road_map.get(xposition)[yposition];
//            System.out.println(runner_check);

            // Push the position of the runner
            undoStack.push(new int[]{xposition, yposition});

            // When coyote makes one move, a file is created and his movements are traced
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DirectionforInput1_timestamp", true)));
                out.println("West");
                out.close();
            } catch (IOException e) {}
        }
        else {return;}
//        get_score();
    }

    // Create a function that changes the position of coyote to the northeast
    public static void northeast(ImageView image, GridPane grid, ArrayList<int[]> new_grid, HashMap<Integer,Image> road_map_alt, ArrayList<int[]> road_map){
        // Call the function for the x position
        xposition = main.x(image);
        // Call the function for the y position
        yposition = main.y(image);

        if(xposition > 0 && yposition < road_map.get(1).length - 1 && prevent_backwards(String.valueOf(xposition - 1) + (yposition + 1))
                &&!getBoulder(xposition - 1, yposition + 1, road_map) && !getStart(xposition-1,yposition+1,road_map)){
            alternative(grid,image,road_map,road_map_alt,xposition,yposition);
            yposition += 1;
            xposition -= 1;
            grid.add(image, yposition, xposition);

            prevent_back.put(String.valueOf(xposition) + (yposition),true);

            runner_check = road_map.get(xposition)[yposition];

            // Push the position of the runner
            undoStack.push(new int[]{xposition, yposition});

            // When coyote makes one move, a file is created and his movements are traced
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DirectionforInput1_timestamp", true)));
                out.println("NorthEast");
                out.close();
            } catch (IOException e) {}
        }
        else{return;}
//        get_score();
    }

    // Create a function that changes the position of coyote to the northwest
    public static void northwest(ImageView image, GridPane grid, ArrayList<int[]> new_grid, HashMap<Integer,Image> road_map_alt, ArrayList<int[]> road_map){
        // Call the function for the x position
        xposition = main.x(image);
        // Call the function for the y position
        yposition = main.y(image);

        if(xposition > 0 && yposition > 0 && prevent_backwards(String.valueOf(xposition - 1) + (yposition - 1))
                && !getBoulder(xposition - 1, yposition - 1, road_map)&& !getStart(xposition-1,yposition-1,road_map)){
            alternative(grid,image,road_map,road_map_alt,xposition,yposition);
            yposition -= 1;
            xposition -= 1;
            grid.add(image, yposition, xposition);
//            System.out.println(xposition + " " + yposition);

            prevent_back.put(String.valueOf(xposition) + (yposition),true);
//            System.out.println(prevent_back);

            runner_check = road_map.get(xposition)[yposition];
//            System.out.println(runner_check);

            // Push the position of the runner
            undoStack.push(new int[]{xposition, yposition});

            // When coyote makes one move, a file is created and his movements are traced
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DirectionforInput1_timestamp", true)));
                out.println("NorthWest");
                out.close();
            } catch (IOException e) {}
        }
        else{return;}
//        get_score();
    }

    // Create a function that changes the position of coyote to the southeast
    public static void southeast(ImageView image, GridPane grid, ArrayList<int[]> new_grid, HashMap<Integer,Image> road_map_alt, ArrayList<int[]> road_map){
        // Call the function for the x position
        xposition = main.x(image);
        // Call the function for the y position
        yposition = main.y(image);

        if(xposition < road_map.size() - 1 && yposition < road_map.size() - 1 && prevent_backwards(String.valueOf(xposition + 1) + (yposition + 1))
                &&!getBoulder(xposition + 1, yposition + 1, road_map) && !getStart(xposition+1,yposition+1,road_map)){
            alternative(grid,image,road_map,road_map_alt,xposition,yposition);
            yposition += 1;
            xposition += 1;
            grid.add(image, yposition, xposition);
//            System.out.println(xposition + " " + yposition);

            prevent_back.put(String.valueOf(xposition) + (yposition),true);
//            System.out.println(prevent_back);

            runner_check = road_map.get(xposition)[yposition];
//            System.out.println(runner_check);

            // Push the position of the runner
            undoStack.push(new int[]{xposition, yposition});


            // When coyote makes one move, a file is created and his movements are traced
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DirectionforInput1_timestamp", true)));
                out.println("SouthEast");
                out.close();
            } catch (IOException e) {}
        }
        else{return;}
//        get_score();
    }
    // Create a function that changes the position of coyote to the southwest
    public static void southwest(ImageView image, GridPane grid, ArrayList<int[]> new_grid, HashMap<Integer,Image> road_map_alt, ArrayList<int[]> road_map){
        // Call the function for the x position
        xposition = main.x(image);
        // Call the function for the y position
        yposition = main.y(image);

        if(xposition < road_map.size() - 1 && yposition > 0 && prevent_backwards(String.valueOf(xposition + 1) + (yposition - 1))
                &&!getBoulder(xposition + 1, yposition - 1, road_map)&& !getStart(xposition+1,yposition-1,road_map)){
            alternative(grid,image,road_map,road_map_alt,xposition,yposition);
            yposition -= 1;
            xposition += 1;
            grid.add(image, yposition, xposition);
//            System.out.println(xposition + " " + yposition);

            prevent_back.put(String.valueOf(xposition) + (yposition),true);
//            System.out.println(prevent_back);

            runner_check = road_map.get(xposition)[yposition];
//            System.out.println(runner_check);

            // Push the position of the runner
            undoStack.push(new int[]{xposition, yposition});

            // When coyote makes one move, a file is created and his movements are traced
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("DirectionforInput1_timestamp", true)));
                out.println("SouthWest");
                out.close();
            } catch (IOException e) {}
        }
        else{return;}
//        get_score();
    }

    // Create a function that will change the original image with the alternative
    public static void alternative(GridPane grid, ImageView run, ArrayList<int[]> map_alt, HashMap<Integer, Image> road_map_alt, int x, int y)
    {
        Integer image = map_alt.get(x)[y];
        ImageView alt = new ImageView(road_map_alt.get(image));
        alt.setFitWidth(30);
        alt.setFitHeight(30);
        grid.getChildren().remove(run);
        grid.add(alt, y, x);
    }

    // Create a hash map that will store the keys of the position of the road runner
    static HashMap<String, Boolean> prevent_back = new HashMap<>();
    // Create a function that will prevent coyote to go back
    public static boolean prevent_backwards(String string_search)
    {
        boolean check = prevent_back.containsKey(string_search);
        return !check;
    }

    public static void reset(ArrayList<int[]> road_map, ImageView image, GridPane grid, ArrayList<int[]> new_grid, HashMap<Integer,Image> road)
    {

        grid.getChildren().clear();

        for (int i = 0; i < road_map.size(); i++)
        {
            for (int k = 0; k < road_map.get(i).length; k++)
            {
                if (i== image.getX() && k == image.getY())
                {
                    image = new ImageView(road.get(7));
                    image.setFitWidth(30);

                    image.setFitHeight(30);
                    new_grid.add(new int[]{k,i});
                    grid.add(image, k, i);
                }
                else
                {
                    ImageView roads =  new ImageView(road.get(road_map.get(i)[k]));
                    roads.setFitWidth(30);
                    roads.setFitHeight(30);
                    grid.add(roads, k, i);
                }
            }
        }
    }

    static HashMap<Integer, Integer> scoreMap;
    // Create a function that keeps track of the score
    public static HashMap<Integer, Integer> score_map()
    {
        // Create a hash map that stores the scores and the energy levels
        scoreMap = new HashMap<>();
        scoreMap.put(0, -1);
        scoreMap.put(1, 0);
        scoreMap.put(2, -2);
        scoreMap.put(3, -4);
        scoreMap.put(4, -8);
        scoreMap.put(5, +1);
        scoreMap.put(6, +5);

        return scoreMap;
    }

    // Create a function that gets the scores
    public static int get_score(){
        score_map();

        if (score > 0)
        {
            if (scoreMap.containsKey(runner_check)){
                energy = scoreMap.get(runner_check);
                score = energy + score;

                System.out.println(score);
            }
        }
        return score;
    }

    // Create a function that can undo the previous step
    public static void undo(ImageView image, GridPane grid, HashMap<Integer,Image> road, ArrayList<int[]> road_map, HashMap<Integer,Image> road_alt)
    {
        xposition = main.x(image);
        yposition = main.y(image);

        count++;
        if (count < 5 && !undoStack.isEmpty()){
            int i = xposition;
            int j = yposition;

            // Position after pressing the undo button
            int [] poppedposition = undoStack.pop();
            System.out.println(Arrays.toString(poppedposition));

            int x = poppedposition[0];
            int y = poppedposition[1];

            ImageView view = new ImageView(road.get(road_map.get(j)[i]));
//            view.setPreserveRatio(true);
            view.setFitWidth(30);
            view.setFitHeight(30);
            grid.add(view,i,j);

            road_map.get(y)[x] = road_map.get(j)[i];

            ImageView view1 = new ImageView(road.get(road_map.get(y)[x]));
//            view1.setPreserveRatio(true);
            view1.setFitWidth(30);
            view1.setFitHeight(30);
            grid.add(view1, y, x);

            road_map.get(j)[i] = road_map.get(j)[i];

            // Push the position the runner is
            redoStack.push(new int[]{xposition, yposition});
            xposition = x;
            yposition = y;

        }
    }

    // Create a function that can redo
    public static void redo(ImageView image, GridPane grid, HashMap<Integer,Image> road, ArrayList<int[]> road_map){
        ++count2;
        if (count2 < 4 && !redoStack.isEmpty()){
            int i = xposition;
            int j = yposition;

            int[] poppedPos = redoStack.pop();

            int x = poppedPos[0];
            int y = poppedPos[1];

//            int current = road_map.get(j)[i];
            ImageView view = new ImageView(road.get(road_map.get(j)[i]));
            view.setFitWidth(30);
            view.setFitHeight(30);
            grid.add(view,i,j);


            road_map.get(y)[x] = road_map.get(j)[i];
            ImageView view1 = new ImageView(road.get(road_map.get(y)[x]));
            view1.setFitWidth(30);
            view1.setFitHeight(30);
            grid.add(view1,x,y);
            road_map.get(j)[i] = road_map.get(j)[i];
            xposition = x;
            yposition = y;
        }
    }

    // Create a function that checks for boulder
    public static Boolean getBoulder(int x, int y, ArrayList<int[]> mappy){
        if (mappy.get(x)[y] == 1){
            return true;
        }
        return false;
    }

    // Create a function that checks for the start
    public static Boolean getStart(int x, int y, ArrayList<int []>mappy){
        if (mappy.get(x)[y] == 8){return true;}
        return false;
    }

    public static void updateGridMap(Map<String, Integer> newValues) {
        score_map();
        System.out.println(newValues.toString());
        System.out.println(scoreMap.toString());
        for (String i: newValues.keySet()) {
            scoreMap.put(Integer.valueOf(i), newValues.get(i));
//            Image tmp = get_road_map.get(Integer.parseInt(i));
//            get_road_map.put(newValues.get(i), tmp);
//            get_road_map.remove(Integer.parseInt(i));
        }
        System.out.println(scoreMap);
    }
}