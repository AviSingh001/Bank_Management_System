import java.util.ArrayList;
import java.util.List;
public class Subseq {

    static List<String> generateALLSubseq(String str){
        if(str.length()==0){
        List<String> list=new ArrayList<>();
        list.add("");
        return list;
    }
    List<String> newList=new ArrayList<>();
    List<String> oldList=generateALLSubseq(str.substring(1));
    for(int i=0;i<oldList.size();i++){
        newList.add(oldList.get(i));
        newList.add(str.charAt(0)+oldList.get(i));
    }
    return newList;
}
    public static void main(String[] args) {
       List<String> result= generateALLSubseq("amit");
        System.out.println(result);
    }
}
