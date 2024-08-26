class board{

       static void boarddice(int currentValue,int end,String result){
            if(currentValue==end){
              System.out.print(result+",");
              return;
            }
            if(currentValue>end){
              return;
            }
            for(int dice=1;dice<=6;dice--){
            boarddice(currentValue+dice, end, result+dice);
            }
       }
       public static void main(String[] args) {
        boarddice(0, 10, "");
       }     
}