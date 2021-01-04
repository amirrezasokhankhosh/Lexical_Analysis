import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    static File code;
    static Scanner scanner;
    static Tokens tokens = new Tokens();

    static ArrayList<String> lines = new ArrayList<String>();  // Lines of the given code
    // place for other arraylists like identifiers , keywords , etc. (check Tokens.java)

    public static void main(String[] args) {
        getLines(); // first we will get lines of the given code.

        // Then we will delete every white spaces inside the code and give anything else to a function -> isToken
        for(int i = 0 ; i < lines.size() ; i++) {
            StringTokenizer st = new StringTokenizer(lines.get(i));
            while(st.hasMoreTokens()){
                String token = st.nextToken();
                boolean answer = isToken(token);
                if(!answer){
                    // this is when we get a error on lexical analysis.
                    System.out.println("An Error occured while checking line " + (i + 1) + " and token " + (token));
                    return;
                }
            }
        }
    }


    // A function for reading the the given code and writing the lines on a global static ArrayList
    public static void getLines(){
        
        try{
            code = new File("./Code.txt");
            scanner = new Scanner(code);
            while(scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("Something went wrong.");
        }
    }

    // to connect the tokens to their types or finding an error on lexical check for each string.
    public static boolean isToken(String string){
        /* SEPEHR */

        // Check if a given string is token or not consider that the given string doesn't have any white spaces but it may have multiple tokens
        // Example : this is a possible string for this function "(String[]" that contains {"(" , "String" , "[" , "]"}
        // Find these tokens and save them in a static arraylist
        // If the string is not token at all return false and the program will stop there.



        return false; // Just for Compiling correctly.
    }
}