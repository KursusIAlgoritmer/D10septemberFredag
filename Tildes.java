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


public class Tildes{
    static int[] sizes;
    static int[] guests;

    public static void main(String[] args) {

      try{
      Kattio io = new Kattio(System.in, System.out);

        int N = io.getInt();
        int q = io.getInt();

        guests = new int[N];
        sizes  = new int[N];

        //create guest's array
        for(int i=0; i < N ; i++){
            guests[i] = i;
            sizes[i] = 1;
        }

        //read all queries
        for(int i=0; i < q; i++){
            char op = io.getWord().charAt(0);

            if(op == 't')//s.next()split[0].equals("t"))
                union(io.getInt(),io.getInt());//Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            if(op == 's')//split[0].equals("s"))
                io.println(size(io.getInt()));//size(Integer.parseInt(split[1])));

        }
        io.close();
      }catch(Exception e){}
    }


    public static int size(int i){
        return sizes[find(i)];
    }

    public static int find(int i){
        i--;
        int originalIndex = i;
        while(i !=  guests[i]) {
            //guests[i] = guests[guests[i]];
            i = guests[i];
        }
        while(originalIndex != guests[originalIndex]){
              int oldParent = guests[originalIndex];
              guests[originalIndex] = i;
              originalIndex = oldParent;
        }
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
