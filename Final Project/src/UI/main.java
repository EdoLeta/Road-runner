package UI;

import Nodeclass.Node;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;


public class main extends Application {
    // Used this variable when setting an action for enabling the 8 directions
    int count = 0;
    // sed this variable when enabling the action for 8 directions
    boolean enable;
    ImageView game = null;
    public static int no_rows=0;
    public static int no_cols=0;

    public static ArrayList<int[]> mappy;

    // Create a label where you can project the scores
    Label score = new Label("point: " + 0);
    Label score1 = new Label("point: " + 0);

    final FileChooser fileChooser = new FileChooser();
    static HashMap<Integer, Image> get_road_map;

    // Create a function that reads the file that contains the map of the road runner
    public static ArrayList<int[]> getfile(String filename) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader(filename));

        String line;

        // This will store the rest of the lines apart from the first line
        ArrayList<int[]> eachline = new ArrayList<>();

        // This will get the lines with space and separate them using the space
        String[] getline = file.readLine().split(" ");

        // convert the contents of the file from strings to integers
        int[] integers = Arrays.stream(getline).mapToInt(Integer::parseInt).toArray();
        no_cols=integers[1];
        System.out.println(no_cols);
        no_rows=integers[0];
        System.out.println(no_rows);


        // create two arrays containing the row and the columns using the first line in the file
        int[][] size = new int[integers[0]][integers[1]];

        // This will print the first line in the content file that contains the size of the arrays to create
        System.out.println(Arrays.toString(size));

        // split the contents line by line
        while ((line = file.readLine()) != null) {
            // This will get the contents line by line and split them
            String[] hold_content = line.split("");
            // Convert the strings into integers
            int[] new_arr = Arrays.stream(hold_content).mapToInt(Integer::parseInt).toArray();

            // Add the converted string into the array list created above.
            eachline.add(new_arr);
            System.out.println(Arrays.toString(new_arr));
        }
        // close the file once you open
        file.close();


        return eachline;
    }

    public static HashMap<Integer, Image> road_map() throws IOException {

        Image boulder = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\boulder.jpg"));
        Image coyote = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\coyote.jpg"));
        Image explosive = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\explosive.jpg"));
        Image goal = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\goal.jpg"));
        Image gold = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\gold.jpg"));
        Image pothole = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\pothole.jpg"));
        Image road = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\road.jpg"));
        Image road_runner = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\road_runner.jpg"));
        Image start = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\start.jpg"));
        Image tarred = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\tarred.jpg"));

        // Create the map
        get_road_map = new HashMap<>();


        get_road_map.put(0, road);
        get_road_map.put(1, boulder);
        get_road_map.put(2, pothole);
        get_road_map.put(3, explosive);
        get_road_map.put(4, coyote);
        get_road_map.put(5, tarred);
        get_road_map.put(6, gold);
        get_road_map.put(7, road_runner);
        get_road_map.put(8, start);
        get_road_map.put(9, goal);

        return get_road_map;
    }


    public static HashMap<Integer, Image> road_map_alt() throws IOException {
        //read images files and create their image objects
        Image boulder = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\boulder.jpg"));
        Image coyote_alt = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\coyote_alt.jpg"));
        Image explosive_alt = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\explosive_alt.jpg"));
        Image gold_alt = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\gold_alt.jpg"));
        Image pothole_alt = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\pothole_alt.jpg"));
        Image road_alt = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\road_alt.jpg"));
        Image tarred_alt = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\tarred_alt.jpg"));
        Image start = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\start.jpg"));
        Image goal = new Image(new FileInputStream("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\Image Files\\goal.jpg"));

        //create a hashMap to map the images to their key
        HashMap<Integer, Image> roadmap_alt = new HashMap<>();


//        The images in the hashMap above should now be assigned keys.
        roadmap_alt.put(0, road_alt);
        roadmap_alt.put(1, boulder);
        roadmap_alt.put(2, pothole_alt);
        roadmap_alt.put(3, explosive_alt);
        roadmap_alt.put(4, coyote_alt);
        roadmap_alt.put(5, tarred_alt);
        roadmap_alt.put(6, gold_alt);
        roadmap_alt.put(8, start);
        roadmap_alt.put(9, goal);

        return roadmap_alt;
    }

    // create a function that will keep track of the position of the images
    // Create the function for the x position
    public static int x(ImageView runner) {
        return GridPane.getRowIndex(runner);
    }

    // Create the function for the y position
    public static int y(ImageView runner) {
        return GridPane.getColumnIndex(runner);
    }

    // Create an array list to keep track of the map
    ArrayList<int[]> maps = new ArrayList<>();
    // Call the function that reads the file that contains the map

    // Call out the function that maps the images to the keys
    HashMap<Integer, Image> image;
    // Call the function that maps the alternative images to the original position
    HashMap<Integer, Image> image_alt;

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create the title of the grid
        primaryStage.setTitle("Game");
        // Call the function that reads the file that contains the map
        mappy = getfile("C:\\Users\\ALU_Student\\IdeaProjects\\pp-ii-the-road-runner-mary-edosa-caesar\\Final Project\\src\\sample_test_input_1.txt");
        // Call out the function that maps the images to the keys
        Node[][] graph=new Node[no_rows][no_cols];
        Node startNode=null;
        Node goalNode=null;

        //System.out.println(no_cols+" "+no_rows);
        for(int i=0;i<no_rows;i++){
            for(int j=0;j<no_cols;j++){
                //System.out.println("here");
                graph[i][j]=new Node(i,j);
                if(mappy.get(i)[j]==1){
                    graph[i][j].isBlock=true;
                }
                if(mappy.get(i)[j]==7){
                    startNode=graph[i][j];
                    System.out.println("I am start");
                }
                if(mappy.get(i)[j]==9){
                    goalNode=graph[i][j];
                    System.out.println("I am goal");
                }

            }
        }
//        System.out.println(dFS(startNode,goalNode,graph));
        image = road_map();
        // Call the function that maps the alternative images to the original position
        image_alt = road_map_alt();

        // Create a grid pane
        GridPane grid = new GridPane();
        // space out the grid horizontally
        grid.setHgap(15);
        // Space out the grid vertically
        grid.setVgap(15);
        // Align the grid at the center
        grid.setAlignment(Pos.CENTER);


//        ImageView boulder = new ImageView(image.get(1));

        for (int i = 0; i < mappy.size(); i++) {
            for (int k = 0; k < mappy.get(i).length; k++) {
                if (mappy.get(i)[k] == 8) {
                    game = new ImageView(image.get(7));
                    game.setFitWidth(30);
                    game.setFitHeight(30);
                    maps.add(new int[]{i, k});
                    grid.add(game, k, i);
                } else {
                    ImageView road = new ImageView(image.get(mappy.get(i)[k]));
                    road.setFitWidth(30);
                    road.setFitHeight(30);
                    grid.add(road, k, i);
                }
            }
        }


        // Create a button that will redo the move made by coyote once pressed
        Button redo = new Button("Redo");
        // Create a button that will allow the coyote to move in 8 different directions
        Button direction = new Button("8 dir");
        // Create a button that will enable the player to reset the game to the initial state
        Button reset = new Button("Reset");
        // Create a button that will undo the moves made by coyote when pressed
        Button undo = new Button("Undo");
        // Create a new button that will load another file
        Button load = new Button("Load");

        // Create a new button that will change weights
        Button newWeight = new Button("Change Weight");
        newWeight.setOnAction(event -> newWeightUI());

        // Create a start button
        Button AStar = new Button("A*");

        // Create Dijkstra
        Button Dijkstra = new Button("Dijkstra");

        // Create DFS
        Button dFS = new Button("DFS");


        HBox scorebox = new HBox();
        scorebox.setAlignment(Pos.BOTTOM_CENTER);
        scorebox.getChildren().add(score);
//        score.setAlignment(Pos.TOP_CENTER);

        // Create a hbox that will hold the buttons created
        HBox get_btn = new HBox(1);
        // Align the created hbox at the bottom
        get_btn.setAlignment(Pos.BOTTOM_CENTER);

        //Create a hbox that will hold the grid created
        VBox hbox = new VBox(25);
        // Align the hbox at the bottom of the grid
        hbox.setAlignment(Pos.CENTER);
        // Add the buttons to the hbox
        hbox.getChildren().addAll(grid, get_btn, scorebox);

        //create a scene and add it to the stage
        Scene scene = new Scene(hbox, 800, 800);

        // Create an action set that will enable the player to use the directions as they wish
        direction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // if count is divisible by 2 then enable the action
                if (count % 2 == 0) {
                    enable = true;
                    direction.setText("Disable 8 dir");
                }
                // Else if count is not divisible by 2 disable the action
                else {
                    enable = false;
                    direction.setText("Enable 8 dir");
                }
                count += 1;
            }
        });

        ImageView finalGame = game;

        AStar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                try {
//                    astarPath(new Nodeclass.Node(3, 1), new Node(0, 3), grid);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
            }
        });
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                get_btn.getChildren().removeAll();

                ImageView game1 = finalGame;
                System.out.println(game1.getX() + " " + game1.getY());
                trial.reset(mappy, game1, grid, maps, image);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        });


        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getChildren().clear();
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    try {
                        mappy = getfile(String.valueOf(file));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                grid.getChildren().clear();
                trial.reset(mappy, game, grid, maps, image);
                for (int i = 0; i < mappy.size(); i++) {
                    for (int k = 0; k < mappy.get(i).length; k++) {
                        if (mappy.get(i)[k] == 8) {
                            game = new ImageView(image.get(7));
                            game.setFitWidth(30);
                            game.setFitHeight(30);
                            maps.add(new int[]{i, k});
                            grid.add(game, k, i);
                            trial.xposition = i;
                            trial.yposition = k;
                        } else {
                            ImageView road = new ImageView(image.get(mappy.get(i)[k]));
                            road.setFitWidth(30);
                            road.setFitHeight(30);
                            grid.add(road, k, i);
                        }
                    }
                }
            }
        });
        ImageView run1 = game;
        redo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                trial.redo(run1, grid, image, mappy);
            }
        });
        undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                trial.undo(run1, grid, image, mappy, image_alt);
            }
        });


           scene.setOnKeyPressed(event -> {
            ImageView run = game;
//            System.out.println(trial.xposition + " " + trial.yposition);
            if (event.getCode() == KeyCode.UP) {
                trial.north(run, grid, maps, image_alt, mappy);
            }
            if (event.getCode() == KeyCode.DOWN) {
                trial.south(run, grid, maps, image_alt, mappy);
            }
            if (event.getCode() == KeyCode.RIGHT) {
                trial.east(run, grid, maps, image_alt, mappy);
            }
            if (event.getCode() == KeyCode.LEFT) {
                trial.west(run, grid, maps, image_alt, mappy);
            }

            if (enable) {
                if (event.getCode() == KeyCode.W) {
                    trial.northeast(run, grid, maps, image_alt, mappy);
                }
                if (event.getCode() == KeyCode.Q) {
                    trial.northwest(run, grid, maps, image_alt, mappy);
                }
                if (event.getCode() == KeyCode.A) {
                    trial.southwest(run, grid, maps, image_alt, mappy);
                }
                if (event.getCode() == KeyCode.S) {
                    trial.southeast(run, grid, maps, image_alt, mappy);
                }
            }
            score.setText("Energy: " + trial.get_score());
        });

        get_btn.getChildren().addAll(redo, reset, undo, direction, load, newWeight, AStar);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

//
//    public ArrayList<String> astarPath(Nodeclass.Node start, Nodeclass.Node end, GridPane gridUsed) throws FileNotFoundException {
////        gridUsed.getChildren().clear();
//        int rows = 4;
//        int columns = 4;
//
//        // int[][]blocks = new int[][]{{14,14}};
//        ArrayList<String> path = new ArrayList<>();
//        AStar astar = new AStar(rows, columns, start, end);
//
//        // A Star movement in 8 directions
//        if (enable) {
//            astar.allowed8Directions = true;
//        }
//
//        // astar.setBlocks(blocks);
//
//        List<Nodeclass.Node> findPath = astar.findPath();
//        int StartedRow = start.getRow();
//
//        ImageView run = game;
//        int StartedCol = start.getCol();
//        for (Nodeclass.Node node : findPath) {
//
//            int movedRow = node.getRow();
//            int movedCol = node.getCol();
//
//            int rowDifference = StartedRow - movedRow;
//            int colDifference = StartedCol - movedCol;
//
//            if (rowDifference == 1 && colDifference == 0) {
//                trial.north(run, gridUsed, maps, image_alt, mappy);
//            } else if (rowDifference == 0 && colDifference == 1) {
//                trial.west(run, gridUsed, maps, image_alt, mappy);
//                System.out.println("left");
//            } else if (rowDifference == -1 && colDifference == 0) {
//                trial.south(run, gridUsed, maps, image_alt, mappy);
//            } else if (rowDifference == 0 && colDifference == -1) {
//                trial.east(run, gridUsed, maps, image_alt, mappy);
//            } else if (rowDifference == 1 && colDifference == 1) {
//                trial.northwest(run, gridUsed, maps, image_alt, mappy);
//            } else if (rowDifference == 1 && colDifference == -1) {
//                trial.northeast(run, gridUsed, maps, image_alt, mappy);
//            } else if (rowDifference == -1 && colDifference == 1) {
//                trial.southwest(run, gridUsed, maps, image_alt, mappy);
//            } else if (rowDifference == -1 && colDifference == -1) {
//                trial.southeast(run, gridUsed, maps, image_alt, mappy);
//            }
//
//            StartedRow = movedRow;
//            StartedCol = movedCol;
//        }
//
//        return path;
//    }


    void newWeightUI() {
        Dialog dialog = new Dialog();
        DialogPane dialogPane = dialog.getDialogPane();
// dialog.show();
        GridPane ctrlGrid = new GridPane();
        ctrlGrid.setAlignment(Pos.CENTER);
        dialogPane.setContent(ctrlGrid);
// //dialog.show();
// dialog.setHeight(400);
// dialog.setWidth(400);
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField ordinaryRoad = new TextField();
        ordinaryRoad.setPromptText("Ordinary Road weight");
        TextField pothole = new TextField();
        pothole.setPromptText("Pothole weight");
        TextField explosive = new TextField();
        explosive.setPromptText("Explosive weight");
        TextField coyote = new TextField();
        coyote.setPromptText("Coyote weight");
        TextField tarredRoad = new TextField();
        tarredRoad.setPromptText("Tarred Road weight");
        TextField goldRoad = new TextField();
        goldRoad.setPromptText("Gold Road weight");
        ctrlGrid.setVgap(10);
        ctrlGrid.add(new Label("Ordinary Road:"), 0, 0);
        ctrlGrid.add(ordinaryRoad, 1, 0);
        ctrlGrid.add(new Label("Pothole:"), 0, 1);
        ctrlGrid.add(pothole, 1, 1);
        ctrlGrid.add(new Label("Explosive:"), 0, 2);
        ctrlGrid.add(explosive, 1, 2);
        ctrlGrid.add(new Label("Coyote:"), 0, 5);
        ctrlGrid.add(coyote, 1, 5);
        ctrlGrid.add(new Label("Tarred Road:"), 0, 3);
        ctrlGrid.add(tarredRoad, 1, 3);
        ctrlGrid.add(new Label("Gold Road:"), 0, 4);
        ctrlGrid.add(goldRoad, 1, 4);
        dialog.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                try {
                    return getValues(ordinaryRoad, pothole, explosive, coyote, tarredRoad, goldRoad);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        });

        Optional<Map<String, Integer>> optionalResult = dialog.showAndWait();
    }

    public Map<String, Integer> getValues(TextField ordinaryRoad, TextField pothole, TextField explosive, TextField coyote, TextField tarredRoad, TextField goldRoad) throws Exception {
// newWeightUI();
        Map<String, Integer> newValues = new HashMap<>();
        if (!ordinaryRoad.getText().equals("")) {
            int val = Integer.parseInt(ordinaryRoad.getText());
            newValues.put("0", val);
        }
        if (!pothole.getText().equals("")) {
            int val = Integer.parseInt(pothole.getText());
            newValues.put("2", val);
        }
        if (!explosive.getText().equals("")) {
            int val = Integer.parseInt(explosive.getText());
            newValues.put("3", val);
        }
        if (!coyote.getText().equals("")) {
            int val = Integer.parseInt(coyote.getText());
            newValues.put("4", val);
        }
        if (!tarredRoad.getText().equals("")) {
            int val = Integer.parseInt(tarredRoad.getText());
            newValues.put("5", val);
        }
        if (!goldRoad.getText().equals("")) {
            int val = Integer.parseInt(goldRoad.getText());
            newValues.put("6", val);
        }
// System.out.println(newValues);
        trial.updateGridMap( newValues);
        boolean weightsChanged = true;
        return newValues;

// System.out.println(ordinaryRoad.getText() + " " + pothole.getText() + " ");

    }
}