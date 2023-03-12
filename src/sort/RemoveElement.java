package sort;

public class RemoveElement {

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 3, 4, 5, 5, 6 ,7, 8, 9, 9};
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int key = 3;
        arr = new RemoveElement().removeElement(arr, 3);

        System.out.println("\nafter removing duplicates");
        for(int x: arr)
            System.out.print(" "+x);

        //System.out.println(" k ="+expectedArr.length);
    }

    public int[] removeElement(int[] nums, int val) {

        int n = nums.length;

        int start = 0;
        int end = n-1;

        while(start <= end){

            if(nums[end] == val)
                end--;

            else{
                if(nums[start] == val){
                    //swap sums[start]  <--> nums[end]

                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;

                    start++;
                    end--;
                }else
                    start++;
            }
        }
        return nums;
    }
}
