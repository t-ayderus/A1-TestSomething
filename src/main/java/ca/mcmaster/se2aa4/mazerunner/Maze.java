/*
 * File: Maze.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A class that models a maze
 */
package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Iterator;

public class Maze{

    private final MazeParser mazeParser = new MazeParser();
    private ArrayList<ArrayList<Path>> maze = new ArrayList<>();
    private int[] entrance;
    private int[] exit;

    //Set the Maze
    public void setMaze(String filePath)
    {
        this.maze = mazeParser.parse(filePath);
        this.entrance = mazeParser.getEntrance(maze);
        this.exit = mazeParser.getExit(maze);
    }

    //Return Entrance Indices
    public int [] getEntrance()
    {
        return this.entrance;
    }

    //Return Exit Indices
     public int [] getExit()
    {
        return this.exit;
    }

    //Return Specefied Index in Array List
    public Path getIndex(int row, int col)
    {
        return this.maze.get(row).get(col);
    }

    //A method to Print The Maze
    public void printMaze( )
    {
        Iterator<ArrayList<Path>>  listIterator= this.maze.iterator();

        while(listIterator.hasNext())
        {
            ArrayList<Path> row = (ArrayList<Path>) listIterator.next();

            for(Path col: row)
            {
                System.out.print( col +" ");
            }
            System.out.print(System.lineSeparator());
        } 

    }
}