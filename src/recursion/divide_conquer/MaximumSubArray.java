package recursion.divide_conquer;

class Pair{

    int low;
    int high;
    int element;

    int leftSum;

    int rightSum;

    public Pair(int low, int high, int element) {
        this.low = low;
        this.high = high;
        this.element = element;
    }

    public Pair(int low, int high, int leftSum, int rightSum) {
        this.low = low;
        this.high = high;
        this.leftSum = leftSum;
        this.rightSum = rightSum;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getLeftSum() {
        return leftSum;
    }

    public int getRightSum() {
        return rightSum;
    }
}

public class MaximumSubArray {

    public Pair find_Max_SubArray(int[] A, int low, int high){

        if(high == low)
            return new Pair(low, high, A[low]);

        else{
            int mid = (low + high) / 2;

            Pair leftPair = find_Max_SubArray(A, low, mid);

            Pair rightPair = find_Max_SubArray(A, mid+1, high);

            Pair crossPair = find_Max_Crossing_SubArray(A, low, mid, high);

            int leftSum = crossPair.getLeftSum();

            int rightSum = crossPair.getRightSum();

            int crossSum = leftSum + rightSum;

            if(leftSum >= rightSum && leftSum >= crossSum)
                return new Pair(leftPair.getLow(), leftPair.getHigh(), leftSum);

            else if(rightSum  >= leftSum && rightSum >= crossSum)
                return new Pair(rightPair.getLow(), rightPair.getHigh(), rightSum);

            else return new Pair(crossPair.getLow(), crossPair.getHigh(), crossSum);
        }
    }

    public Pair find_Max_Crossing_SubArray(int[] A, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int maxLeft = -1;
        int sum = 0;

        for(int i = mid; i>= low; i--){
            sum += A[i];
            if(sum > leftSum){
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = -1;
        for(int j = mid+1; j <= high; j++){
            sum += A[j];
            if(sum > rightSum){
                rightSum = sum;
                maxRight = j;
            }
        }

        return new Pair(maxLeft, maxRight, leftSum, rightSum);
    }

    public static void main(String[] args) {
        int[] stockPrices = {100, 113, 110, 85, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};

        MaximumSubArray subArraySum = new MaximumSubArray();

        Pair pair = subArraySum.find_Max_SubArray(stockPrices, 0, stockPrices.length-1);

        int stockBuyPrice = stockPrices[pair.getLow()];
        int stockSellPrice = stockPrices[pair.getHigh()];
        int maxProfit = pair.getElement();

        System.out.println("Best Time to buy stock at price ="+stockBuyPrice);
        System.out.println("Best Time to sell stock at price ="+stockSellPrice);
        System.out.println("Maximum Profit ="+maxProfit);
    }
}
