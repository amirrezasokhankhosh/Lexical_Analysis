import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static File code;
    static Scanner scanner;

    static ArrayList<String> lines = new ArrayList<String>();  // Lines of the given code
    static Map<String, String> result = new java.util.HashMap<String, String>();

    public static void main(String[] args) {
        getLines(); // first we will get lines of the given code.

        // Then we will delete every white spaces inside the code and give anything else to a function -> isToken
        for (int i = 0; i < lines.size(); i++) {
            StringTokenizer st = new StringTokenizer(lines.get(i));
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                boolean answer = isToken(token);
                if (!answer) {
                    // this is when we get a error on lexical analysis.
                    System.out.println("An Error occured while checking line " + (i + 1) + " and token " + (token));
                    return;
                }
            }
        }

        for (String s: result.keySet()) {
            String value = result.get(s);
            System.out.println(s + " -- " + value);
        }

    }
    // A function for reading the the given code and writing the lines on a global static ArrayList
    public static void getLines () {

        try {
            code = new File("C:\\Users\\Sepehr Shahsavar\\IdeaProjects\\CompilerPrj\\src\\com\\company\\Code.txt");
            scanner = new Scanner(code);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
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

        //abnormal:
        boolean flag = true;
        ArrayList<String> list = checkComplexString(string);
        if (list.size() > 0) {
            for (String s :
                    list) {
                if(s.length() == 0)
                    continue;
                flag = checkTokenType(s);
                if (!flag)
                    return false;
            }
        }
        //normal :
        if(checkTokenType(string))
            return true;

        return flag;// Just for Compiling correctly.
    }

    public static boolean checkTokenType(String string){
        if (Token.isIdentifier(string)) {
            result.put(string , "Identifier");
            return true;
        }else if (Token.isKeyword(string)) {
            result.put(string , "Keyword");
            return true;
        }else if (Token.isLiteral(string)) {
            result.put(string , "Literal");
            return true;
        }else if (Token.isOperator(string)) {
            result.put(string , "Operator");
            return true;
        }else if (Token.isSeparator(string)) {
            result.put(string , "Separator");
            return true;
        }
        return  false;
    }

    private static ArrayList<String> checkComplexString(String string){
        ArrayList<String> list = new ArrayList<String>();
        char[] chars = string.toCharArray();
        String identifier = "";
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if(isSeparator(chars[i])){
                identifier = fixSubString(string ,start,i );
                start = i + 1;
                list.add(identifier);
                list.add(Character.toString(chars[i]));
            }
        }

        return list;
    }

    private static boolean isSeparator(char c){
        char[] separator = {'.' , '{' , '(','[' , ']' ,')', '}' , ';'};
        for (char s : separator) {
            if(c == s)
                return true;
        }
        return false;
    }

    private static String  fixSubString(String string , int startIndex , int endIndex){
        return string.substring(startIndex , endIndex);
    }

}
