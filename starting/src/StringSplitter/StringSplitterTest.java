package StringSplitter;

public class StringSplitterTest {
    public static void main(String[] args) {
        printArgs(StringSplitter.splitString4("hihibyehihi","hi"));
    }
    
    public static void printArgs(String[] args) {
        for(String s : args)
            System.out.println(s);
    }
}