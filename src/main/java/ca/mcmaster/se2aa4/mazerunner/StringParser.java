
/*
 * File: StringParser.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A class that performs various operations on string to prepare for output or processing
 */
package ca.mcmaster.se2aa4.mazerunner;

public class StringParser{


    //Convert toCannoncialForm 
    public String toCannonicalForm(String str)
    {
        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i<str.length(); i++)
        {        
            StringBuilder numStr = new StringBuilder();

            if(str.charAt(i)== 'F' || str.charAt(i)== 'R' || str.charAt(i)== 'L')
                newStr.append( str.charAt(i) );
            else if(Character.isDigit(str.charAt(i)) ){

                while(Character.isDigit(str.charAt(i))){
                    numStr.append(str.charAt(i));
                    i++;
                }
                String factor= numStr.toString();
                for(int r = 0; r< Integer.valueOf(factor); r++)
                    newStr.append(str.charAt(i));
                
            }
        }

        return newStr.toString();
    }

    //Delete WhiteSpace and Ensure proper input
    public String validateString(String str) throws IllegalArgumentException
    {
        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i<str.length(); i++)
        {        

            if(str.charAt(i)== 'F' || str.charAt(i)== 'R' || str.charAt(i)== 'L' || Character.isDigit(str.charAt(i)) )
                newStr.append( str.charAt(i) );   
            else if(!Character.isWhitespace(str.charAt(i))) 
            {
                throw new IllegalArgumentException("Path Input Incorrect");
            }        
        }

        return newStr.toString();

    }


    //Convert to Factored Form
    public String toFactorizedForm(String str)
    {
        StringBuilder newStr = new StringBuilder();
        Boolean factor = false;
        for(int i = 0; i<str.length(); i++)
        {        
            int nums = 1;
            if(i < str.length() - 1 ){
                while( str.charAt(i) == str.charAt(i+1) ){
                    factor = true;
                    nums++;
                    i++;
                    if(i == str.length() - 1 )
                        break;
                }
            }
            if(factor){
                    newStr.append(nums);
                    newStr.append(str.charAt(i)+" ");
            }else
                newStr.append(str.charAt(i)+ " ");
            factor = false;
            nums = 1;
        }

        return newStr.toString();

    }

}


