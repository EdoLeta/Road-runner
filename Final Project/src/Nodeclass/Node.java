
//Creating the Node class
package Nodeclass;

import UI.main;

import java.util.*;
import static UI.main.*;

public class Node {
//    static int no_rows =0;
//    static int no_cols =0;

    int g;
    int h;
    int f;
    int row;
    int column;
   public boolean isBlock;
    Node parent;

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static void main(String[] args) {
        int[][] mapp={{1,2,0,9}, {0,0,0,0}, {6,7,4,5},{0,8,0,0}};

        System.out.println(main.no_rows);
        System.out.println(main.no_cols);
        no_rows =mapp.length;
        no_cols =mapp[0].length;

        Node[][] graph=new Node[no_rows][no_cols];
        Node startNode=null;
        Node goalNode=null;

        //System.out.println(no_cols+" "+no_rows);
        for(int i = 0; i< no_rows; i++){
            for(int j = 0; j< no_cols; j++){
                //System.out.println("here");
                graph[i][j]=new Node(i,j);
                if(mapp[i][j]==1){
                    graph[i][j].isBlock=true;
                }
                if(mapp[i][j]==7){
                    startNode=graph[i][j];
                    System.out.println("I am start");
                }
                if(mapp[i][j]==9){
                    goalNode=graph[i][j];
                    System.out.println("I am goal");
                }

            }
        }
        System.out.println(dFS(startNode,goalNode,graph));
    }
    public ArrayList<Node> getNeighbours(Node[][]graph){//will return viable neighbours
        ArrayList<Node> neighbours=new ArrayList<>();
if(true){
        for(int i=row-1;i<=row+1;i++){
            if(i>=0 && i< no_rows) {
                for (int j = column - 1; j <= column + 1; j++) {
                    if (j >= 0 && j < no_cols){

                        if(i!=row && j!=column){
                            if(!graph[i][j].isBlock){
                                neighbours.add(graph[i][j]);
                            }
                        }
                    }
                }
            }
        }
}
else{
    for(int i=row-1;i<=row+1;i++){
        if(i>=0 && i< no_rows) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (j >= 0 && j < no_cols){

                    if(i!=row && j!=column){
                        if((i!=row && j==column)||(i==row && j!=column)){
                        if(!graph[i][j].isBlock){

                            neighbours.add(graph[i][j]);
                        }
                    }
                    }
                }
            }
        }
    }
}

        return neighbours;
    }
    public static boolean dFS(Node startNode, Node goalNode,Node[][]graph){
        Stack<Node> openNodes=new Stack<Node>();
        HashSet<Node>  closedNodes=new HashSet<>();

        openNodes.add(startNode);

        while(!openNodes.isEmpty()){
            Node current=openNodes.pop();

            if(current==goalNode){
                return true;
            }
            closedNodes.add(current);
            for(Node neigh:current.getNeighbours(graph)){
                if(!closedNodes.contains(neigh)){
                    openNodes.push(neigh);
                    closedNodes.add(neigh);
                }

            }
        }
        return false;
    }

    public void setNodeData(Node currentNode, int cost) {
        int gCost = currentNode.getG() + cost;
        setParent(currentNode);
        setG(gCost);
        calculateFinalCost();
    }

    public boolean checkBetterPath(Node currentNode, int cost) {
        int gCost = currentNode.getG() + cost;
        if (gCost < getG()) {
            setNodeData(currentNode, cost);
            return true;
        }
        return false;
    }


    public void calculateHeuristic(Node target) {
        this.h = Math.abs(target.getRow() - getRow()) + Math.abs(target.getCol() - getCol());
    }

    private void calculateFinalCost() {
        int finalCost = getG() + getH();
        setF(finalCost);
    }


    @Override
    public boolean equals(Object arg0) {
        Node other = (Node) arg0;
        return this.getRow() == other.getRow() && this.getCol() == other.getCol();
    }

    //printing string to string methods in reference of an object
    @Override
    public String toString() {
        return "row=" + row + ", col=" + column + "";
    }

    public int getH() {
        return h;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return column;
    }
}

