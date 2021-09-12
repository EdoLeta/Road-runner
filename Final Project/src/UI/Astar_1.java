//package UI;
//
//import java.io.FileWriter;
//import java.util.*;
//
//public class Astar_1<aStarNode> {
//
//    public ArrayList<String> astarPath(Nodeclass.Node start, Nodeclass.Node end) {
//        String message= "Start: " + start.getRow() + "," + start.getCol() + "\n";
//        message += "End: " +  end.getRow() + "," + end.getCol() + "\n";
//        int rows = file.rowSize;
//        int columns = file.columnSize;
////        int[][]blocks = new int[][]{{14,14}};
//        ArrayList<String> path = new ArrayList<>();
//        AStar astar = new AStar(rows, columns, start, end);
//        if(checkAllDirection){
//            astar.allowed8Directions = true;
//        }
////        astar.setBlocks(blocks);
//        List<Nodeclass.Node> findpath = astar.findPath();
//
//        int StartedRow = start.getRow();
//        int StartedCol = start.getCol();
//        for (Nodeclass.Node node: findpath){
//            int movedRow = node.getRow();
//            int movedCol = node.getCol();
//
//            int rowDifference = StartedRow - movedRow;
//            int colDifference = StartedCol - movedCol;
//
//            if (rowDifference == 1 && colDifference == 0){
//                path.add("North");
//                message += "North\n";
//                moveUp();
//            }
//            else if (rowDifference == 0 && colDifference == 1){
//                path.add("West");
//                message += "West\n";
//                moveLeft();
//            }
//            else if (rowDifference == -1 && colDifference == 0){
//                path.add("South");
//                message += "South\n";
//                moveDown();
//            }
//            else if (rowDifference == 0 && colDifference == -1){
//                path.add("East");
//                message += "East\n";
//                moveRight();
//            }
//            else if (rowDifference == 1 && colDifference == 1){
//                path.add("NorthWest");
//                message += "NorthWest\n";
//                moveNW();
//            }
//            else if (rowDifference == 1 && colDifference == -1){
//                path.add("NorthEast");
//                message += "NorthEast\n";
//                moveNE();
//            }
//            else if (rowDifference == -1 && colDifference == 1){
//                path.add("SouthWest");
//                message += "SouthWest\n";
//                moveSW();
//            }
//            else if (rowDifference == -1 && colDifference == -1){
//                path.add("SouthEast");
//                message += "SouthEast\n";
//                moveSE();
//            }
//
//            StartedRow = movedRow;
//            StartedCol = movedCol;
//        }
//        try{
//            FileWriter file = new FileWriter("C:\\Users\\ALU Student 100\\IdeaProjects\\Road_runner_Kevin&Alliance\\src\\Test Inputs\\AStarFile");
//            file.write(message);
//            file.close();
//
//        }catch (Exception e){
//            System.out.println("File not found");
//        }
//        return path;
//    }
//
//
//
//    public class PathFindingAstar {
//        private Set<aStarNode> ClosedSet;
//        private aStarNode[][] grid;
//        private aStarNode startNode;
//        private aStarNode targetNode;
//        private PriorityQueue<aStarNode> openPQ;
//        private ArrayList<aStarNode> depthFirstSearchArr;
//        // Constructor for the path finder
//        public <worldObjects> PathFindingAstar(worldObjects[][] grid, int x, int y) {
//// Initialize the grid
//            this.grid = new aStarNode[grid.length][grid[0].length];
//            int[] startingPosition = new int[2];
//            int[] targetPosition = new int[2];
//            startingPosition[0] = x;
//            startingPosition[1] = y;
//// Initialize the star node layout
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[0].length; j++) {
//                    if (grid[i][j].getId() == 9) {
//                        targetPosition[0] = i;
//                        targetPosition[1] = j;
//                    }
//                    aStarNode newNode = new aStarNode(i, j, grid[i][j].getVisited());
//                    this.grid[i][j] = newNode;
//                }
//            }
//// Initialize the starting node and the ending node
//            this.startNode = this.grid[startingPosition[0]][startingPosition[1]];
//            this.targetNode = this.grid[targetPosition[0]][targetPosition[1]];
//// Initialize the open set and closed set for the eight and four path finder respectively
//            openPQ = new PriorityQueue<aStarNode>();
//            ClosedSet = new HashSet<aStarNode>();
//            depthFirstSearchArr = new ArrayList<aStarNode>();
//        }
//
//    }}
//
