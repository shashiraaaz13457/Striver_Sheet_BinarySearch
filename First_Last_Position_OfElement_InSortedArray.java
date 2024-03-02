import java.util.Arrays;

public class First_Last_Position_OfElement_InSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,7,7,8,8,10};
        int target = 7;
//        System.out.println(searchRange(nums,target));
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    static int[] searchRange(int[] nums,int target){
        int[] ans = {-1,-1};

        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target > nums[mid]){
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            }
            else{
                int First = SearchInLeft(nums,target,start,end);
                int Last = SearchInRight(nums,target,start,end);
                return new int[]{First,Last};
            }

        }
        return ans;
    }
    static int SearchInLeft(int[] nums,int target,int start,int end) {

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    static int SearchInRight(int[] nums,int target,int start,int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                start = mid+1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

}
