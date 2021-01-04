import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static File code;
    static Scanner scanner;
    static ArrayList<String> lines = new ArrayList<String>();  // Lines of the given code
    static Tokens tokens = new Tokens();

    public static void main(String[] args) {
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

    public static boolean isToken(String string){
        return true; // Just for Compiling correctly.
    }
}