import java.util.*;

public class Main {

    public static void main (String [ ] args) {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Insert K (length of the segment): ");
        Integer K = scanner.nextInt();
        System.out.print("Insert M (Maximum value of the elements of the array): ");
        Integer M = scanner.nextInt();

        System.out.println("Insert elements of the array until an input -1: ");
        ArrayList<Integer> A = new ArrayList<Integer>();
        Integer inputValue = scanner.nextInt();
        while(inputValue!=-1) {
            A.add(inputValue);
            inputValue= scanner.nextInt();
        }

        Solution obtainLeaders = new Solution();

        System.out.println("Leaders Array:" + obtainLeaders.solution(K,M,A));
    }
}
