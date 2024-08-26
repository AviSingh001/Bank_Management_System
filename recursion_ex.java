public class recursion_ex{

    static String printTable2(int num,int val){
      if(val==0){
        return "";
      }
       String str= printTable2(num, val-1);
       String exp=num+" * "+val+" = "+(num*val);
       str=str+exp+"\n";
       return str;
    }
    // static void printTable(int num,int val){
    //     if(val==0){
    //              return;
    //     }
     
    //     printTable(num, val+1);
    //     System.out.println(num+" * "+val+" = "+(num*val));
    // }
    public static void main(String[] args) {
       // printTable(5,1);
        System.out.println(printTable2(5, 10));
    }
}
