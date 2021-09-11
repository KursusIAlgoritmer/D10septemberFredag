import java.util.Arrays;
import java.util.Scanner;

public class BasicProgramming1{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int t = s.nextInt();

        int[] A = new int[N];

        for(int i=0; i < N ; i++){
            A[i] = s.nextInt();
        }
        s.close();

        switch (t) {
            case 1:
                System.out.println("7");
                break;
            case 2:
                if(A[0] > A[1])System.out.println("Bigger");
                else if(A[0] == A[1])System.out.println("Equal");
                else System.out.println("Smaller");
                break;
            case 3:
                int B[] = {A[0], A[1], A[2]};
                Arrays.sort(B);
                System.out.println(B[1]);
                break;
            case 4:
                int sum=0;
                for(int i : A) sum += i;
                System.out.println(sum);
                break;
            case 5:
                int sum2=0;
                for(int i : A) if(i%2==0)sum2 += i;
                System.out.println(sum2);
                break;
            case 6:
                char[] word = new char[N]; 
                for (int i = 0; i < A.length; i++) {
                    word[i]= (char) (97 + A[i]%26);
                }
                System.out.println(new String(word));
                break;
            case 7:
                int i = 0;
                boolean[] visited = new boolean[N];
                while(true){
                    i = A[i];
                    if(i >= N){
                        System.out.println("Out");
                        break;
                    }
                    if(i == N-1){
                        System.out.println("Done");
                        break;
                    }
                    if(visited[i]){
                        System.out.println("Cyclic");
                        break;
                    }
                    visited[i] = true;

                }    
                break;
        }


    }


    
}