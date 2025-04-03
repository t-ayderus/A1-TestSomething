/*
 * File: Main.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A program that returns or verifies the path of a maze
 */

package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main{

private static final Logger logger = LogManager.getLogger();
private static final Maze maze = new Maze();
private static final StringParser strParser = new StringParser();

    public static void main(String[] args) {

        Options options = new Options();
        options.addOption("i", true, "Input Maze" );
        options.addOption("p",true,"User Input Potential Path");

        CommandLineParser parser = new GnuParser();
        CommandLine cmd;
            
       logger.info("** Starting Maze Runner");
       try {

            cmd = parser.parse(options, args);
        
            maze.setMaze(args[1]);
            logger.info("**** Reading the maze from file " + args[1]);

            if(cmd.hasOption("p") && cmd.hasOption("i") )
            {
                Player player = new Player( maze, maze.getEntrance());
                String path = strParser.validateString(args[3]);
                path = strParser.toCannonicalForm(path);
                player.moveRunner( path);
            }
            else if(cmd.hasOption("-i"))
            {
                Algorithm solver = new RightHand(maze, maze.getEntrance());        
                System.out.println( strParser.toFactorizedForm(solver.findPath()) );

            }
            else{
                logger.error("Incorrect Input");
            }
            
        } catch(Exception e) {
           logger.error("/!\\ An error has occured /!\\");
        }  
       
    }
}