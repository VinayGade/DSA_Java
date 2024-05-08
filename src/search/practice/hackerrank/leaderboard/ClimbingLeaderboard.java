package search.practice.hackerrank.leaderboard;

import java.util.*;

public class ClimbingLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        HashSet<Integer> uniqueRanks = new LinkedHashSet<Integer>(ranked);
        List<Integer> results = new ArrayList<Integer>(player.size());
        List<Integer> ranksArray = new ArrayList<Integer>(uniqueRanks);

        for(int i = 0; i < player.size(); i++) {
            int currentScore = player.get(i);
            if(i > 0 && player.get(i - 1) == currentScore) {
                results.add(results.get(i - 1));
            } else {
                int previousResult = ranksArray.size() - 1;
                if(i > 0) {
                    previousResult = results.get(i - 1) - 1;
                }
                //int currentRank = insertionIndex(ranksArray, currentScore, previousResult) + 1;
                int currentRank = Collections.binarySearch(ranksArray, currentScore, Collections.reverseOrder());
                if(currentRank < 0) {
                    currentRank *= -1;
                } else {
                    currentRank++;
                }
                results.add(currentRank);
            }
        }
        return results;
    }

    private static int insertionIndex(List<Integer> orderedList, int numberToInsert, int previousRight) {
        //System.out.println("Looking for: " + numberToInsert);
        if(numberToInsert > orderedList.get(0)) {
            //System.out.println("Bigger than first number");
            return 0;
        } else if(numberToInsert < orderedList.get(orderedList.size() - 1)) {
            //System.out.println("Smaller than last number");
            return orderedList.size();
        }

        int leftIndex = 0;
        int rightIndex = previousRight;
        int mid = rightIndex / 2;
        while(leftIndex < rightIndex) {
            //System.out.println("Left: " + leftIndex);
            //System.out.println("Mid: " + mid);
            //System.out.println("Right: " + rightIndex);
            if(numberToInsert > orderedList.get(mid)) {
                rightIndex = mid - 1;
            } else if (numberToInsert == orderedList.get(mid)) {
                break;
            } else {
                leftIndex = mid + 1;
            }

            mid = (rightIndex + leftIndex) / 2;
        }
        if(numberToInsert < orderedList.get(mid)) {
            return mid + 1;
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        List<Integer> player = Arrays.asList(5, 25, 50, 120);
        List<Integer> ranks = climbingLeaderboard(ranked, player);
        for(int r: ranks){
            System.out.println(r);
        }
    }
}
