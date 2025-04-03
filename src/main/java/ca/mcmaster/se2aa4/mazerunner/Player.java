/*
 * File: Player.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A class that models a Player, moving through a maze
 */
package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Player{


    private final Logger logger = LogManager.getLogger();
    private Maze maze;
    private int pos[] = new int[2];
    private Compass compass;

    public Player (Maze currentMaze, int [] entrancePosition)
    {
        this.maze =  currentMaze;
        this.pos[0] = entrancePosition[0];
        this.pos[1] = entrancePosition[1];
        compass =  new Compass(pos);
    }


    public void moveRunner(String strPath)
    {
        //Assumes start is left side, facing East
        if(this.followPath(strPath, maze.getExit() ) ){
            System.out.println("correct path");
        //Switch start to right side, facing West    
        }else{

            int [] newStart = maze.getExit();
            compass.setPosition(newStart, Direction.W);
            this.pos[0] = newStart[0];
            this.pos[1] = newStart[1];
            if(this.followPath(strPath, maze.getEntrance() ))
                System.out.println("correct path");
            else
                System.out.println("incorrect path");
        }
    }

    //Takes in Cannocial Path and moves through maze
    public Boolean followPath(String strPath,  int [] exitPosition )
    {

        for( int i = 0; i<strPath.length(); i++)
        {
            if(strPath.charAt(i) == 'F')
                this.pos = compass.fwd(maze);

            else if(strPath.charAt(i) == 'R'){   
                compass.right();
                logger.info("New Direction " + compass.getDirection());

            }else if(strPath.charAt(i) == 'L'){
                compass.left();
                logger.info("New Direction " + compass.getDirection());
        
            }else
                logger.error("Incorrect Input");

            logger.info("Fwd: Row " + this.pos[0] + " Col " + this.pos[1]);

        }

        logger.info("Exit is at " + exitPosition[0] + ", " + exitPosition[1]);

        if(this.pos[0] ==exitPosition[0] && this.pos[1] == exitPosition[1] )
            return true;
        else  
            return false;

    }




}