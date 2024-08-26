public class String_Recursive {
//     static String reverse(String str){
// //base case
//   if(str.length()==0){
//     return "";
//   }
//   // small problem
//   String result =reverse(str.substring(1));
//  char firstChar= str.charAt(0);
//  return result+firstChar;
//     }
//     public static void main(String[] args) {
//         System.out.println(reverse("satyam"));
//     }

// static String searchAndReplace(String str,char src,char replace){
//     //base case
//       if(str.length()==0){
//         return "";
//       }
//       // small problem
//       String result =searchAndReplace(str.substring(1),src,replace);
//      char firstChar= str.charAt(0);
//      if(firstChar==src){
//      return replace+result;
//      }
//      else{
//         return firstChar+result;
//      }
//         }
//         public static void main(String[] args) {
//             System.out.println(searchAndReplace("satyam",'a','p'));
//         }
// static String searchAndRemove(String str,char src){
//     //base case
//       if(str.length()==0){
//         return "";
//       }
//       // small problem
//       String result =searchAndRemove(str.substring(1),src);
//      char firstChar= str.charAt(0);
//      if(firstChar==src){
//      return result;
//      }
//      else{
//         return firstChar+result;
//      }
//         }
//         public static void main(String[] args) {
//             System.out.println(searchAndRemove("satyam",'m'));
//         }

static String replacehiWithHello(String str){
 if(str.length()<=1){
    return str;
 }

if(str.charAt(0)=='h'&&str.charAt(1)=='i'){
   String result= replacehiWithHello(str.substring(2));
    return "Hello"+result;
}else{
   String result= replacehiWithHello(str.substring(1));
   return str.charAt(0) +result;
}
}

public static void main(String[] args) {
    String str="hi amit hi rajveer";
    System.out.println(replacehiWithHello(str));
}
}
