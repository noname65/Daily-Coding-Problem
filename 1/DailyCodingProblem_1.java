package dailycodingproblem_1;
/**[Easy]
 * Good morning! Here's your coding interview problem for today.
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 */
public class DailyCodingProblem_1 {
    public static void main(String[] args) {
        int[] array = new int[]{10, 15, 3, 7};
        int k=17;
        System.out.println("The result is: "+function(array,k));
    }
    public static boolean function(int[] array,int k){
        //Let each number in the array be added to the other numbers once and judge
        for (int i = 0; i<array.length-1; i++) {
            for (int j = i+1; j<array.length; j++) {
                if(array[i] + array[j] == k){
                    return true;
                }
            }
        }
        return false;
    }
}
