package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringParserTest{
    private StringParser stringParser;

    @BeforeEach
    public void setUp(){
        this.stringParser = new StringParser();
    }

    //Test to check the input is validated and white space is removed
    @Test 
    public void testValidateString(){
        this.setUp();
        assertEquals("F1R2L3", stringParser.validateString("F1 R2 L3"));
        assertEquals("F1R2L3", stringParser.validateString(" F1R2L3 "));

         IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        stringParser.validateString("F!R2L3@");
        });
        assertEquals("Path Input Incorrect", exception.getMessage()); // Example assertion

    }

    //Test to check the input is converted to canonical form
    @Test 
    public void testToCannonicalForm(){
        this.setUp();
        assertEquals("FRRLLL", stringParser.toCannonicalForm("1F2R3L") );
    }

    //Test to check the input is converted to factored form
    @Test 
    public void testToFactorizedForm(){
        this.setUp();
        assertEquals("F 2R 3L ",stringParser.toFactorizedForm("FRRLLL") );
    }

}