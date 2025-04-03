package ca.mcmaster.se2aa4.mazerunner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RightHandTest{
    private Maze maze;
    private RightHand rightHand;
    private Player player;
    private Observer observer;

    @BeforeEach
    public void setUp(){
        this.maze = new Maze();
        this.maze.setMaze("src/test/java/ca/mcmaster/se2aa4/mazerunner/dummy.maz.txt");
        //this.maze.setMaze("./examples/straight.maz.txt");
        this.observer = new PathObservor();
        this.rightHand = new RightHand(this.maze);
        this.rightHand.addObserver(this.observer);
    }
    //Test to check the Right Hand Algorithm is working properly
    @Test
    public void testFindPath(){
        this.setUp();
        assertEquals("FFFFFFF", rightHand.findPath());
        System.setOut(originalOut);
    }

}