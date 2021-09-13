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

//5:
import java.util.Scanner;


public class Tildes{
    static int[] sizes;
    static int[] guests;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int q = s.nextInt();

        guests = new int[N];
        sizes  = new int[N];

        //create guest's array
        for(int i=0; i < N ; i++){
            guests[i] = i;
            sizes[i] = 1;
        }

        //skifter til næste linje efter de to input tal N og q
        s.nextLine();

        //read all queries
        for(int i=0; i < q; i++){
            //input = s.nextLine();
            char op = s.next().charAt(0);
            //int s1 = s.nextInt();
            //int s2 = s.nextInt();
            //String[] split = input.split(" ");

            if(op == 't')//s.next()split[0].equals("t"))
                union(s.nextInt(),s.nextInt());//Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            if(op == 's')//split[0].equals("s"))
                System.out.println(size(s.nextInt()));//size(Integer.parseInt(split[1])));

        }
        s.close();
    }

    public static int size(int i){
        /*int id = find(i);
        int s = 0;
        for(int k : guests) if(id==k)s=s+1;
        return s;
        */
        return sizes[find(i)];
    }


    public static int find(int i){
        //return guests[i-1];
        i--;

        while(i !=  guests[i]) i = guests[i];

        return i;
    }

    public static void union(int i, int j){
        /*int idI     = find(i);
        int idJ     = find(j);
        int newSize   = sizes[i-1] + sizes[j-1];

        if(idJ != idI){
            for(int k=0; k < guests.length; k++){
                if(guests[k]==idJ || guests[k]==idI){
                    guests[k]= idI;
                    sizes[k] = newSize;
                }

            }
        }*/
        int idI = find(i);
        int idJ = find(j);
        if(idI == idJ) return;
        if(sizes[idI] < sizes[idJ]) { guests[idI] = idJ ; sizes[idJ] += sizes[idI]; }
        else                        { guests[idJ] = idI ; sizes[idI] += sizes[idJ]; }

    }


}
