/*
 * File: Compasss.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A class that models a Compass
 */
package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//Class to model a Compass
public class Compass{

    private final Logger logger = LogManager.getLogger();
    private Direction D = Direction.E;
    private final int pos[] = new int[2];
    private int startPos[] = new int[2];

    public Compass(int[] startPostion)
    {
        pos[0] = startPostion[0];
        pos[1] = startPostion[1];
    }
    
    public Direction getDirection()
    {
        return this.D;
    }

    public int [] getPosition()
    {
        return this.pos;
    }

    //Move Forward
    public int [] fwd(Maze maze)
    {
        try {
            if(this.getDirection() == Direction.N){ 
                    if(maze.getIndex(pos[0]-1, pos[1])  == (Path.PASS) )
                        pos[0]--;
                    else
                        logger.info("WALL");

            }else if(this.getDirection() == Direction.E){           
                    if(maze.getIndex(pos[0], pos[1]+1)== (Path.PASS) )
                        pos[1]++;
                    else
                        logger.info("WALL");

          }else if(this.getDirection() == Direction.S){ 
                    if(maze.getIndex(pos[0]+1, pos[1]) == Path.PASS)
                        pos[0]++;
                    else
                        logger.info("WALL");

         }else if(this.getDirection() == Direction.W){ 
                    if(maze.getIndex(pos[0], pos[1]-1) == Path.PASS) 
                      pos[1]--;
                    else
                      logger.info("WALL");
          }else
                logger.error("Path Error");
        
        } catch (Exception e) {
            logger.error("Error: Path Out of Bounds");
        }
        return pos;
       
    }


    //Set Compass to a speceficed postiion
    public int [] setPosition(int [] newPos, Direction D){
        pos[0] = newPos [0];
        pos[1] = newPos [1];
        this.D = D;
        return pos;
    }

    //Change Direction Left
    public void left()
    {
        if(this.D == Direction.N)
                this.D=  Direction.W;

        else if(this.D == Direction.E)
                this.D= Direction.N;

         else if(this.D== Direction.S)
                this.D= Direction.E;

         else if(this.D==Direction.W)
                this.D= Direction.S;
    }

    //Change Direction Right
     public void right()
    {
        if(this.D == Direction.N)
                this.D=  Direction.E;

        else if(this.D == Direction.E)
                this.D= Direction.S;

         else if(this.D== Direction.S)
                this.D= Direction.W;

         else if(this.D==Direction.W)
                this.D= Direction.N;
    }

}