package ca.mcmaster.se2aa4.mazerunner;



import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TestPlayer{
    private Maze maze;
    private Player player;

    @BeforeEach
    public void setUp(){
        this.maze = new Maze();
        this.maze.setMaze("src/test/java/ca/mcmaster/se2aa4/mazerunner/dummy.maz.txt");
        this.player = new Player(this.maze, maze.getEntrance());
    }
    //Test to check the Right Hand Algorithm is working properly
    @Test
    public boolean testFollowPath(){
        this.setUp();
        assertEquals(true, player.followPath("FFFFFFF"));
    }

}
