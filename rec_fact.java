public class rec_fact {
    static int fact(int num){
        if(num==1){
            return num;
        }
        int result= fact(num-1);
        return result*num;
    }
    // static void fact(int num,int result){
    //      if(num==1){
    //         System.out.println(result);
    //         return;
    //      }
        
    //     fact(num-1,num*result);
    // }
    public static void main(String[] args) {
      int r= fact(5);
      System.out.println(r);
    }
}
