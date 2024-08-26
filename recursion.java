

public class recursion {

    // static void armStrong(int num,int sum,int cpy){
    //    //Base Case
    //    if(num==0){
    //     if(sum==cpy){
    //         System.out.println("Amstrong Number");
    //     }else{
    //         System.out.println("Not a Armstrong Number");
    //     }
    //     return;  //exit from the current function call
    //    }
    //    //logic
    //    int digit=num%10;
    //   int cube= digit*digit*digit;
    //   sum+=cube;
    //    //small Problem
    //     armStrong(num/10,sum,cpy);
    // }
    static int countDigit(int num){
        //one time code(Base Case)
        if(num==0){
            return 0;
        }

        //Function call(Recursion)
      int count=  countDigit( num/10);
         return  count +1;
         //N time code
    }
     static void armStrong(int num,int sum,int cpy,int digitCount){
       //Base Case
       if(num==0){
        if(sum==cpy){
            System.out.println("Amstrong Number");
        }else{
            System.out.println("Not a Armstrong Number");
        }
        return;  //exit from the current function call
       }
       //logic
       int digit=num%10;
      int cube= (int)Math.pow(digit, digitCount);
      sum+=cube;
       //small Problem
        armStrong(num/10,sum,cpy,digitCount);
    }

    public static void main(String[] args) {
        int num=100;
        int cpy=num;
        int digitCount=countDigit(num);
         armStrong(num,0,cpy,digitCount);
    }
}
