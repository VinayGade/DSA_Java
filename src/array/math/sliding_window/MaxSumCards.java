package array.math.sliding_window;

/*
LeetCode 1423: Maximum Points You Can Obtain from Cards

There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
    Output: 12

    Input: cardPoints = [9,7,7,9,7,7,9], k = 7
    Output: 55

    Input: cardPoints = [2,2,2], k = 2
    Output: 4

    Input: cardPoints = [10, 2, 3, 4, 5, 6, 1], k = 3
    Output: 17
*
* */

public class MaxSumCards {

    static int maxScore(int[] cardPoints, int k){

        int total = 0;
        for(int x: cardPoints)
            total += x;

        int n = cardPoints.length;

        if(n == k)
            return total;

        int windowSize = n - k;
        //int[] window = new int[windowSize];

        int maxSum = 0;

        // find window whose sum is minimum
        //int left = 0;
        int window = 0;
        //int minSum = Integer.MAX_VALUE;

        for(int i=0; i<windowSize-1; i++){
            window += cardPoints[i];
        }

        /*
        cardPoints = [10, 2, 3, 4, 5, 6, 1], k = 3

        maxSum = Max (maxSum, totalSum - windowSum(n-k))
               = Max (12, 31 - 14)
               =17
        *
        * */

        for(int j=windowSize-1; j<n; j++){
            window += cardPoints[j];
            maxSum = Math.max(maxSum, (total - window));
            window -= cardPoints[j-(windowSize-1)];
        }

        return maxSum;
    }

    static int maxScore(int n, int[] cardPoints, int k) {

        //int n = cardPoints.length;
        int totalPoints = 0;

        // Sum of the last 'k' cards
        for (int i = n - k; i < n; i++) {
            totalPoints += cardPoints[i];
        }

        int maxPoints = totalPoints;
        int currentSum = totalPoints;

        // Slide the window from the end to the start
        for (int i = 0; i < k; i++) {
            currentSum = currentSum - cardPoints[n - k + i] + cardPoints[i];
            maxPoints = Math.max(maxPoints, currentSum);
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
    }

    static int maxScore(int[] cardPoints, int n, int k) {

        //int n = cardPoints.length;
        int windowLength = n - k;

        int minSum = Integer.MAX_VALUE;

        int left=0;
        int total=0;
        int currentSum = 0;

        for(int i=0; i<n; i++){
            total += cardPoints[i];
            currentSum += cardPoints[i];

            if((i-left+1) == windowLength){
                minSum = Math.min(minSum, currentSum);
                currentSum = currentSum - cardPoints[left];
                left++;
            }
        }

        int maxScore = total - ((minSum == Integer.MAX_VALUE) ? 0 : minSum);
        return maxScore;

        // 2 pointers leftSum, rightSum
        /*
        int n = cardPoints.length;

        int i = 0;
        int j = n - 1;

        int count = 0;

        int leftSum = 0;
        int rightSum = 0;

        int maxScore = 0;

        while(count <= k && i<n && j>=0){
            leftSum += cardPoints[i];
            i++;
            rightSum += cardPoints[j];
            j--;
            if(leftSum > rightSum){
                maxScore += leftSum;
                count++;
            }else{
                maxScore += rightSum;
                count++;
            }
        }
        return maxScore;*/
    }
}
