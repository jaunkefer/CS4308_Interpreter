/*
    CS4308 Interpreter -- Parser

    Authors:
        Joshua Unkefer
        Eric Bell
        Farid Khan
 */
package cs4308_interpreter;

import java.util.ArrayList;

public class ParserClass 
{    
    boolean new_line = false;
    boolean variable_declaration = false;
    boolean left_paranthesis = false;
    boolean left_curly_brace = false;
    boolean left_brace = false;
    boolean operator = false;
    
    public void syntax(ArrayList<String> x)
    {
        for(int i = 0; i < x.size(); i++)
        {
            if(new_line == false)
            {
                if(x.get(i).contains("NEW LINE"))
                    new_line = true;
                
                else
                    System.out.println("Hmmm... Something is wrong.");
            }
            
            else if(new_line == true)
            {
                if(x.get(i).contains("VARIABLE") && variable_declaration == false)
                    variable_declaration = true;
                
                else if(x.get(i).contains("EQUALS") && variable_declaration == true)
                {
                    
                }
            }
        }
    }
}
