public class re {

//     static boolean isFound(int arr[],int index,int src){
//         //base case
//         if(index==arr.length){
//             return false;
//         }
//         if(arr[index]==src){
//             return true;
//         }
//     //small problem + Recursive call
//    return isFound(arr, index+1, src);
//     }
static int[] findAllHelper(int arr[],int index,int src,int count){
//Base case
if(index==arr.length){
    int result[]=new int[count];
    return result;
}
//count all occurence
//index move from 0 to end
if(arr[index]==src){
    count++;
}
//small problem
int result[]=findAllHelper(arr, index+1, src,count);
if(arr[index]==src){
result[count-1]=index;
}
return result;
}

static int[] findAll(int arr[],int index,int src){
 return findAllHelper(arr, index, src, 0);
}
    public static void main(String[] args) {
        int arr[]={10,20,50,100,50,90,50,200};
        int src=50;
        int index=0;
        int result[]=findAll(arr, index, src);
        for(int r:result){
            System.out.println(r);
        }
      // System.out.println(isFound(arr, index,src)?"Found":"Not Found");
    }
}
