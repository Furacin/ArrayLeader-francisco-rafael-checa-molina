import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public Set<Integer> solution(int K, int M, ArrayList<Integer> A) {

        // Array with the number position of the given array in order to get all the possible
        // combinations
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i=0; i<A.size(); i++) {
            positions.add(i);
        }

        // All the combinations for given array positions
        ArrayList<ArrayList<Integer>> combinations = getSubsets(positions,K);

        // Set with the leaders
        Set<Integer> leaders = new HashSet<>();

        // Once we already calculated the combinations in the array, we can get the leaders
        for (int i=0; i<combinations.size(); i++) {
            ArrayList<Integer> increasedElemOfA = new ArrayList<Integer>(A);
            for (int j=0; j<K; j++) {
                int position = combinations.get(i).get(j);
                int value = A.get(position);
                increasedElemOfA.set(position,++value);
            }
            Integer leader = calculateLeader(increasedElemOfA,M);
            if (leader!=0) {
                leaders.add(leader);
            }
        }

        return leaders;
    }

    private void getSubsets(List<Integer> positionsArray, int k, int i, ArrayList<Integer> permutation, ArrayList<ArrayList<Integer>> res) {
        if (permutation.size() == k) {
            //store a new permutation
            res.add(new ArrayList<Integer>(permutation));
            return;
        } else {
            //crating the permutation
            if (i == positionsArray.size()) {
                return;
            }
            Integer newValue = positionsArray.get(i);
            permutation.add(newValue);

            getSubsets(positionsArray, k, i+1, permutation, res);
            permutation.remove(newValue);

            getSubsets(positionsArray, k, i+1, permutation, res);
        }
    }

    private ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> positionsArray, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        getSubsets(positionsArray, k, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private Integer calculateLeader(ArrayList<Integer> A, Integer M ) {

        Pair<Integer,Long> leader = new Pair<Integer, Long>(0,new Long(0));

        for (int i=1; i<=M+1; i++) {
            int number = i;
            long count = A.stream().filter(n -> n==number).count();
            if (count>leader.getValue() && count>A.size()/2) {
                leader = new Pair<Integer, Long>(i,count);
            }
        }

        return leader.getKey();
    }

}
