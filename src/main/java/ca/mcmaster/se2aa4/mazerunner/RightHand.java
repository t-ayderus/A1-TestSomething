/*
 * File: RightHand.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A class that uses the right hand rule to solve a maze
 */
package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RightHand extends Algorithm{

    enum Move{
        F,
        R,
        L,
        FR,
        FL,
        NONE
    }

    private final Logger logger = LogManager.getLogger();
    private Compass compass;
    private Maze maze;
    private int  pos[] = new int[2];

    public RightHand(Maze currentMaze, int [] entrancePosition)
    {
        this.maze =  currentMaze;
        this.pos[0] = entrancePosition[0];
        this.pos[1] = entrancePosition[1];
        compass = new Compass(pos);
    }

    public String findPath(){
        StringBuilder path = new StringBuilder();

        do{
            path.append( rightHandRule().name() );

        }while(!( maze.getExit()[0] == pos[0]  && maze.getExit()[1]==pos[1] ) );

        logger.info(pos[0] + "," + pos[1]);
        
        String strPath = path.toString();

        return strPath;
    }


    //Follow Right Hand Rule in North Direction
    public Move exploreNorth()
    {
        Move move = Move.NONE;
        try {
            if(maze.getIndex(pos[0]-1, pos[1]) ==Path.WALL )
                    {       
                            //If to the Right is a Wall
                            if(maze.getIndex(pos[0], pos[1] +1)  == Path.WALL)
                            {
                                compass.left();
                                move = Move.L;
                            }
                            else{
                                compass.right();
                                move = Move.R;
                            }

                    }else if(maze.getIndex(pos[0]-1, pos[1]+1) == Path.WALL)
                    {
                            this.pos = compass.fwd(maze);
                            move = Move.F;
                    }else{
                            this.pos = compass.fwd(maze);
                            compass.right();
                            move = Move.FR;
                        }
            
        } catch (Exception e) {
            logger.error("Error: Path Out of Bounds North Exploration");
        }

        return move;
    }
    
    //Follow Right Hand Rule in East Direction
    public Move exploreEast()
    {
        Move move = Move.NONE;
        try {
            //Check In front
                    if(maze.getIndex(pos[0], pos[1]+1) == Path.WALL)
                    {  
                            //If to the Right is a Wall
                            if(maze.getIndex(pos[0]+1, pos[1] +1 )== Path.WALL){
                                compass.left();
                                move = Move.L;
                            }else{
                                compass.right();
                                move = Move.R;
                            }
                    //Check to the right
                    }else if(maze.getIndex(pos[0]+1, pos[1] +1 )== Path.WALL)
                    {
                            this.pos = compass.fwd(maze);
                            move = Move.F;
                    }else{
                            this.pos = compass.fwd(maze);
                            compass.right();
                            move = Move.FR;
                        }
            
        } catch (Exception e) {
            logger.error("Path Error: South Exploration");
        }

        return move;
    }

    //Follow Right Hand Rule in South Direction 
    public Move exploreSouth(){
        Move move = Move.NONE;

        try {
            if(maze.getIndex(pos[0]+1, pos[1]) == Path.WALL)
                {  
                        //If to the Right is a Wall
                        if(maze.getIndex(pos[0], pos[1]-1) == Path.WALL){
                            compass.left();
                            move = Move.L;
                        }else{
                        compass.right();
                        move = Move.R;
                        }

                }else if(maze.getIndex(pos[0]+1, pos[1]-1) == Path.WALL)
                {
                        this.pos = compass.fwd(maze);
                        move = Move.F;
                }else{
                        this.pos = compass.fwd(maze);
                        compass.right();
                        move = Move.FR;
                    }
        } catch (Exception e) {
            logger.error("Path Error: South Exploration");
        }

        return move;
    }
    
    //Follow Right Hand Rule in West Direction 
    public Move exploreWest(){
        Move move = Move.NONE;
        try {
            if(maze.getIndex(pos[0], pos[1]-1) == Path.WALL)
                {  
                        if(maze.getIndex(pos[0]-1, pos[1]) == Path.WALL)
                        {
                            compass.left();
                            move = Move.L;
                        }else{
                            compass.right();
                            move = Move.R;
                        }
                }else if(maze.getIndex(pos[0]-1, pos[1]-1) == Path.WALL)
                {
                        this.pos = compass.fwd(maze);
                        move = Move.F;
                }else{
                        this.pos = compass.fwd(maze);
                        compass.right();
                        move = Move.FR;
                    }
            
        } catch (Exception e) {
            logger.error("Path Error: West Exploration");
        }

        return move;
    }
    
    //Implements RightHandRule
    public Move rightHandRule()
    {
        Move move= Move.NONE;
        try{

            if(compass.getDirection() == Direction.N)
                    move = exploreNorth();

            else if(compass.getDirection() == Direction.E)        
                  move = exploreEast();

            else if(compass.getDirection() == Direction.S) 
                    move = exploreSouth();

            else if(compass.getDirection() == Direction.W) 
                   move = exploreWest();

            else
                logger.error("Direction Error");        
        }
        catch(Exception e){
                logger.error("Error: Path Out of Bounds");
            }
        
        logger.info(move);
            return move;
        }

        
    
}

