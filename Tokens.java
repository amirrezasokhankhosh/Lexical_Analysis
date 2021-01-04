import java.util.regex.Pattern;

class Tokens{
    public static boolean isKeyword(String string){
        String[] keywords = {
            "abstract", "continue",     "for",          "new",          "switch",
            "assert",   "default",      "if",           "package",      "synchronized",
            "boolean",  "do",           "goto",         "private",      "this",
            "break",    "double",       "implements",   "protected",    "throw",
            "byte",     "else",         "import",       "public",       "throws",
            "case",     "enum",         "instanceof",   "return",       "transient",
            "catch",    "extends",      "int",          "short",        "try",
            "char",     "final",        "interface",    "static",       "void",
            "class",    "finally",      "long",         "strictfp",     "volatile",
            "const",    "float",        "native",       "super",        "while"};
        for(int i = 0; i < keywords.length ; i++){
            if(keywords[i] == string){
                return true;
            }
        }

        return false;
    }

    public static boolean isIdentifier(String string){
        Pattern pattern = Pattern.compile("^([a-zA-Z_$][a-zA-Z\\d_$]*)$"); // anything starts without numbers
        return pattern.matcher(string).matches();
    }

    public static boolean isOperator(String string){
        String[] operators = {"." , "++" , "--" , "~" , "!" , "*" , "/" , "%" , "+" , "-" , ">>" , "<<" , ">>>" , ">" , "<" , "<=" , ">=" , "==" , "!=" , "&" , "^" , "|" , "&&" , "||" , "=" , "+=" , "-=" , "*=" , "/=" , "%=" , "&=" , "^=" , "|=" , "<<=" , ">>=" , ">>>="};
        for (int i = 0 ; i < operators.length ; i++){
            if(operators[i] == string){
                return true;
            }
        }
        return false;
    }

    public static boolean isSeperator(String string){
        String[] seperators = {";" , "{" , "}" , "[" , "]" , "(" , ")"};
        for (int i = 0 ; i < seperators.length ; i++){
            if(seperators[i] == string){
                return true;
            }
        }
        return false;
    }

    public static boolean isLiteral(String string){
        String[] literals = {"true" , "false" , "null"}; // Literal values
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?"); // Numbers are Literal too.
        for (int i = 0 ; i < literals.length ; i++){
            if(literals[i] == string){
                return true;
            }
        }
        if(string.charAt(0) == '"' && string.charAt(string.length()-1) == '"'){  // Strings that are declared inside code are literals.
            return true;
        }
        return pattern.matcher(string).matches();
    }
}