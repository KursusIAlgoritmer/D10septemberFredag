//1: Prøvede først med "quick-find" og et gennemløb af arrayet for hver gang size skulle beregnes
// TIME LIMIT EXCEEDED

//2: Forsøgte med "quick-find" og et "size-array" - så jeg undgik et gennemløb ...
// WRONG ANSWER

//2.1: Fejl rettede til newSize = size[i-1] + size[]
// TIME LIMIT EXCEEDED

//3: forsøger med "weighted quick union"....
// TIME LIMIT EXCEEDED

//4:Dropper "split" af string's
// TIME LIMIT EXCEEDED

//5: https://stackoverflow.com/questions/7049011/whats-the-fastest-way-to-read-from-system-in-in-java
import java.util.Scanner;


public class Tildes{
    static int[] sizes;
    static int[] guests;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt(); int q = s.nextInt();

        guests = new int[N]; sizes  = new int[N];

        //create guest's array
        for(int i=0; i < N ; i++){
            guests[i] = i; sizes[i] = 1;
        }

        //skifter til næste linje efter de to input tal N og q
        s.nextLine();

        //read all queries
        for(int i=0; i < q; i++){
            char op = s.next().charAt(0);

            if(op == 't') union(s.nextInt(),s.nextInt());
            else if(op == 's') System.out.println(size(s.nextInt()));

        }
        s.close();
    }

    public static int size(int i){
        return sizes[find(i)];
    }

    public static int find(int i){
        i--;
        while(i !=  guests[i]) i = guests[i];
        return i;
    }

    public static void union(int i, int j){
        int idI = find(i);
        int idJ = find(j);
        if(idI == idJ) return;
        if(sizes[idI] < sizes[idJ]) { guests[idI] = idJ ; sizes[idJ] += sizes[idI]; }
        else                        { guests[idJ] = idI ; sizes[idI] += sizes[idJ]; }

    }
}
