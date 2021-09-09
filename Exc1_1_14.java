public class Exc1_1_14{

  public static void main(String[] args){
    int input = Integer.parseInt(args[0]);
    System.out.println(lgHighestInteger(input));
  }

  public static int lgHighestInteger(int x){
    int result = 0;

    //tester om 2^result < x og prøver til 2^result er ligmed (eller størst)
    while(x > powerPositive(2, result) ){
      result++;
    }
    //hvis 2^result > x er result for høj. result = result -1
    if(x < powerPositive(2, result)){
      result--;
    }

    return result;
  }



  public static int powerPositive(int base, int eksponent){
    int result = base;

    for(int i = 1; i < eksponent; i++){
      result*=base;
    }

    if(eksponent==0){
      result=1;
    }

    return result;
  }


}
