package dailycodingproblem_13;
import java.util.ArrayList;
/**[Hard]This problem was asked by Amazon.
 * Given an integer k and a string s, find the length of the longest substring that 
 * contains at most k distinct characters.
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct 
 * characters is "bcb".
 */
public class DailyCodingProblem_13 {
    public static void main(String[] args) {
        String str="sdasfasdcdcdddchudsjfjksskkskk|aaaabaaaaacccccc";
        int k=3;
        int maxLen=0;
        int start=0;
        int maxStart=0;
        int finalI=0,finalVal=0;
        Character finalC;
        /*To prevent losing the previous repeated characters when truncating the 
        string ("aabbbbccc"→"aabbbb" and "ccc"), record the number of repetitions of
        the last repeated character in these 3 variables. ("aabbbbccc" → "aabbbb" 
        and "bbbbccc")*/
        ArrayList<Character> c=new ArrayList<>();
        //This array records the types of characters that are present at index start to i in the string.
        Character n;
        int i,j;
        for(i=1;i<str.length();i++){
            n=str.charAt(i);
            for(j=0;j<c.size();j++){
                if(c.get(j).equals(n)){
                    if(finalI==j){
                        finalVal++;
                    }else{
                        finalI=j;
                        finalVal=1;
                    }
                    break;
                }
            }
            if(j==c.size()){
                if(c.size()<k){
                    c.add(n);
                }else{
                    if(maxLen<i-start){
                        maxLen=i-start;
                        maxStart=start;
                    }
                    start=i-finalVal;
                    finalC=c.get(finalI);
                    c.clear();
                    c.add(finalC);
                    c.add(n);
                    finalI=1;
                    finalVal=1;
                }
            }
        }
        if(maxLen<i-start){
            maxLen=i-start;
            maxStart=start;
        }
        System.out.println(str.substring(maxStart, maxStart+maxLen));
    }
}
