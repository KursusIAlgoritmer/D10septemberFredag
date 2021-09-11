public class Test{

 public static void main(String[] args) {
    String value = "A";

    int charValue = value.charAt(0);
    String next = String.valueOf( (char) (charValue + 1));
    
    System.out.println(next);
 }

}