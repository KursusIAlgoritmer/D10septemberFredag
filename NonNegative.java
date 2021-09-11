import java.util.Scanner;

public class NonNegative{

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            while(s.hasNext()){
                long t1 = s.nextLong();
                long t2 = s.nextLong();
                long result = t1 - t2;
                if(result < 0 ) result *=-1;
                System.out.println(result);


            }
            s.close();
        }
    
}