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
// TIME LIMIT EXCEEDED
//men forbedring 17 cases... 

//6:...

//7: Vejforkortning

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Tildes{
    static int[] sizes;
    static int[] guests;

    public static void main(String[] args) {
        try {
            int N = readInt();
            int q = readInt();

            sizes   = new int[N];
            guests  = new int[N]; 

            for(int i = 0; i < N; i++){
                sizes[i]=1; guests[i]=i;
            }

            for(int i=0 ; i <q ; i++){
                int input = System.in.read();
                if(input == 116){
                    union(readInt(),readInt());
                }
                else if(input == 115)
                    System.out.println(size(readInt()));
            }
        } catch (Exception e) {
            System.out.println(e);;
            //TODO: handle exception
        }
 
    

    }

    private static int readInt() throws IOException {
        int ret = 0;
        boolean dig = false;
        for (int c = 0; (c = System.in.read()) != -1; ) {
            if (c >= '0' && c <= '9') {
                dig = true;
                ret = ret * 10 + c - '0';
            } else if (dig) break;
        }
        return ret;
    }


    public static int size(int i){
        return sizes[find(i)];
    }

    public static int find(int i){
        i--;
        int originalIndex = i;
        while(i !=  guests[i]) i = guests[i];
        guests[originalIndex] = i;
        return i;
    
    //7: Vejforkortning
    }


    public static void union(int i, int j){
        int idI = find(i);
        int idJ = find(j);
        if(idI == idJ) return;
        if(sizes[idI] < sizes[idJ]) { guests[idI] = idJ ; sizes[idJ] += sizes[idI]; }
        else                        { guests[idJ] = idI ; sizes[idI] += sizes[idJ]; }

    }
}
