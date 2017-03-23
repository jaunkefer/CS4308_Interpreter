/* 
    CS4308 Interpreter -- Main
    
    Authors
    Joshua Unkefer
    Eric Bell
    Farid Khan

    A change was made...
*/

package cs4308_interpreter;

import java.util.ArrayList;

public class CS4308_Interpreter 
{
    public static void main(String[] args) 
    {
        //Create a new object of type ScannerClass
        ScannerClass r = new ScannerClass();
        
        //Creates an ArrayList of strings to hold individual lines of the file
        ArrayList<String> fileContents = r.lexicalAnalyzer("lua_interpreter_file.lua");
        
        //Loop prints line by line the contents of the file
        //NOTE: This loop is not necessary for the final build, but demonstrates
        //that our scanner is reading and our program is adding Tokens to the
        //file
        for(int i = 0; i < fileContents.size(); i++)
            System.out.print(fileContents.get(i));
    }    
}
