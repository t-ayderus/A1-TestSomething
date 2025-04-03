package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MazeTest {
    private Maze maze;

    @BeforeEach
    public void setUp() {
        this.maze = new Maze();
        this.maze.setMaze("src/test/java/ca/mcmaster/se2aa4/mazerunner/dummy.maz.txt");
    }

    // Test to check the maze is set up correctly
    @Test
    public void testGetIndex() {
        this.setUp();
        assertEquals(Path.WALL, maze.getIndex(0, 0));
        assertEquals(Path.PASS, maze.getIndex(1, 0));
        assertEquals(Path.WALL, maze.getIndex(2, 0));
    }

    // Test to check the maze entrance is set up correctly
    @Test
    public void testEntrance(){
        this.setUp();
        assertEquals(1, maze.getEntrance()[0]);
        assertEquals(0, maze.getEntrance()[1]);
    }

    // Test to check the maze exit is set up correctly
    @Test
    public void testExit(){
        this.setUp();
        assertEquals(1, maze.getExit()[0]);
        assertEquals(7, maze.getExit()[1]);
    }
}