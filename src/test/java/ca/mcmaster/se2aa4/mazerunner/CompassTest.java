package ca.mcmaster.se2aa4.mazerunner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompassTest{

    private Compass compass;
    private Maze maze;

    @BeforeEach
    public void setUp(){
        this.maze = new Maze();
        this.maze.setMaze("src/test/java/ca/mcmaster/se2aa4/mazerunner/dummy.maz.txt");
        this.compass = new Compass(maze.getEntrance());
    }

    //Test to check the Compas turns right
    @Test 
    public void testLeft(){
        this.setUp();
        compass.left();
        assertEquals(Direction.N, compass.getDirection());
        compass.left();
        assertEquals(Direction.W, compass.getDirection());
        compass.left();
        assertEquals(Direction.S, compass.getDirection());
        compass.left();
        assertEquals(Direction.E, compass.getDirection());
    }
    
    //Test to check the Compas turns right
     @Test 
    public void testRight(){
        this.setUp();
        //Starts at East
        compass.right();
        assertEquals(Direction.S, compass.getDirection());
        compass.right();
        assertEquals(Direction.W, compass.getDirection());
        compass.right();
        assertEquals(Direction.N, compass.getDirection());
        compass.right();
        assertEquals(Direction.E, compass.getDirection());
    }

    //Test Direction is returned properly
    @Test 
    public void testGetDirection(){
        this.setUp();
        assertEquals(Direction.E, compass.getDirection());
    }

    //Test to check the Compass position is returned properly
    @Test
    public void testForward(){
        this.setUp();
        compass.fwd(maze);
        assertEquals(1, compass.getPosition()[0]);
        assertEquals(1, compass.getPosition()[1]);

    }
    }
    