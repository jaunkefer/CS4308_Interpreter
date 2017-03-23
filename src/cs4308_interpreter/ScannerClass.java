/*
    CS4308 Interpreter -- Scanner

    Authors:
        Joshua Unkefer
        Eric Bell
        Farid Khan
 */
package cs4308_interpreter;

import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

public class ScannerClass 
{
    //Global variables
    private Scanner x;    
    
    public void openFile(String fileName)
    //Precondition: Pass a String.
    //Postcondition: Trys to open a file. If successful, stores the contents 
    //inside the global scanner variable 'x'. Counts the number of lines in the 
    //file and stores that to the gobal int variable 'numberOfLines'. If 
    //unsuccessful, an exception is caught and the program ends with an error 
    //message.
    {
        try
        {
            x = new Scanner(new File(fileName));
            LineNumberReader lines = new LineNumberReader(new FileReader(fileName));
            lines.skip(Long.MAX_VALUE);
            lines.close();
        }
        
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void closeFile()
    //Precondition: None.
    //Postcondition: Closes the file.
    {
        x.close();
    }
   
    public ArrayList<String> readFile(String fileName)
    //Precondition: Pass a String.
    //Postcondition: Calls openFile and passes the fileName. Creates an 
    //ArrayList of strings copied from the passed file.
    {
        openFile(fileName);
        
        ArrayList<String> fileContents = new ArrayList();
        while(x.hasNext())
            fileContents.add(x.nextLine());
        
        closeFile();
        return fileContents;
    }
    
    public String hashMap(char a)
    //Precondition: Pass a char.
    //Postcondition: A reference for hashing chars to Strings. These Strings 
    //will be used as tokens and returned.
    {
        String token;
        
        HashMap<Character, String> convert;
        convert = new HashMap<>();
        
        //Variables -- Upper case
        convert.put('A', "VARIABLE");
        convert.put('B', "VARIABLE");
        convert.put('C', "VARIABLE");
        convert.put('D', "VARIABLE");
        convert.put('E', "VARIABLE");
        convert.put('F', "VARIABLE");
        convert.put('G', "VARIABLE");
        convert.put('H', "VARIABLE");
        convert.put('I', "VARIABLE");
        convert.put('J', "VARIABLE");
        convert.put('K', "VARIABLE");
        convert.put('L', "VARIABLE");
        convert.put('M', "VARIABLE");
        convert.put('N', "VARIABLE");
        convert.put('O', "VARIABLE");
        convert.put('P', "VARIABLE");
        convert.put('Q', "VARIABLE");
        convert.put('R', "VARIABLE");
        convert.put('S', "VARIABLE");
        convert.put('T', "VARIABLE");
        convert.put('U', "VARIABLE");
        convert.put('V', "VARIABLE");
        convert.put('W', "VARIABLE");
        convert.put('X', "VARIABLE");
        convert.put('Y', "VARIABLE");
        convert.put('Z', "VARIABLE");
        
        //Variables -- Lower case
        convert.put('a', "VARIABLE");
        convert.put('b', "VARIABLE");
        convert.put('c', "VARIABLE");
        convert.put('d', "VARIABLE");
        convert.put('e', "VARIABLE");
        convert.put('f', "VARIABLE");
        convert.put('g', "VARIABLE");
        convert.put('h', "VARIABLE");
        convert.put('i', "VARIABLE");
        convert.put('j', "VARIABLE");
        convert.put('k', "VARIABLE");
        convert.put('l', "VARIABLE");
        convert.put('m', "VARIABLE");
        convert.put('n', "VARIABLE");
        convert.put('o', "VARIABLE");
        convert.put('p', "VARIABLE");
        convert.put('q', "VARIABLE");
        convert.put('r', "VARIABLE");
        convert.put('s', "VARIABLE");
        convert.put('t', "VARIABLE");
        convert.put('u', "VARIABLE");
        convert.put('v', "VARIABLE");
        convert.put('w', "VARIABLE");
        convert.put('x', "VARIABLE");
        convert.put('y', "VARIABLE");
        convert.put('z', "VARIABLE");
        
        //Symbols
        convert.put('(', "LEFT_PARANTHESIS");
        convert.put(')', "RIGHT_PARANTHESIS");
        convert.put('{', "LEFT_CURLY_BRACE");
        convert.put('}', "RIGHT_CURLY_BRACE");
        convert.put('[', "LEFT_BRACE");
        convert.put(']', "RIGHT_BRACE");
        convert.put(';', "SEMI_COLON");
        convert.put(':', "COLON");
        convert.put('.', "PERIOD");
        convert.put(',', "COMMA");
        convert.put('!', "EXCLAMATION");
        
        //Operators
        convert.put('+', "PLUS");
        convert.put('-', "MINUS");
        convert.put('*', "MULTIPLY");
        convert.put('/', "DIVIDE");
        convert.put('=', "EQUALS");
        
        //Integers
        convert.put('0', "INTEGER");
        convert.put('1', "INTEGER");
        convert.put('2', "INTEGER");
        convert.put('3', "INTEGER");
        convert.put('4', "INTEGER");
        convert.put('5', "INTEGER");
        convert.put('6', "INTEGER");
        convert.put('7', "INTEGER");
        convert.put('8', "INTEGER");
        convert.put('9', "INTEGER");
        
        //Blank space
        convert.put(' ', "NULL");
        
        token = convert.get(a);
        return token;
    }
    
    public ArrayList<String> lexicalAnalyzer(String fileName)
    //Precondition: Pass a String.
    //Postcondition: Reads the file and attaches appropriate tokens using the
    //hashMap before storing the value and token back into an ArrayList of 
    //Strings.
    {
        ArrayList<String> fileContents = readFile(fileName);
        ArrayList<String> analyzedContents = new ArrayList<>();
        
        Stack<String> items = new Stack<>();
        char [] topStack;
        String hash;
        
        try
        {
            for(int i = 0; i < fileContents.size(); i++)
            {
                items.push(fileContents.get(i));
                topStack = new char[items.peek().toCharArray().length];
                topStack = items.peek().toCharArray();
                
                for(int j = 0; j < topStack.length; j++)
                {
                    if(j == 0)
                        analyzedContents.add("\n--NEW LINE--\n");
                    
                    hash = hashMap(topStack[j]);
                    
                    //OPERATOR case
                    if(hash.equals("PLUS") || hash.equals("MINUS") 
                            || hash.equals("DIVIDE") || hash.equals("MULTIPLY") 
                            || hash.equals("EQUALS"))
                        analyzedContents.add(hash + "\n");
                    
                    //NULL case
                    else if(hash.equals("NULL")){}
                    
                    /*
                    //INTEGER case
                    else if(hash.equals("INTEGER"))
                    {
                        char temp = topStack[j];
                        int k = j;
                        j++;
                        while(hash.equals("INTEGER"))
                        {
                            temp =
                        }
                        
                    }
                    */
                    //VARIABLE and INTEGER case
                    else
                        analyzedContents.add(hash + " " + topStack[j] + "\n");                    
                }
            }
            
            while(!items.empty())
                items.pop();
            
            return analyzedContents;
        }
        
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        return analyzedContents;
    }
}
