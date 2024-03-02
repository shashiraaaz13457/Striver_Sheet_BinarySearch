public class Search_Insert_Position {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        int[] ans = searchRange(nums,target);
        System.out.println(ans);

    }
    static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end - start)/2 ;
            if(target > nums[mid]){
                start = mid + 1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                int left = findLeftIndex(nums,target,start,end);
                int right = findRightIndex(nums,target,start,end);
                return new int[]{left,right};
            }
        }return new int[]{-1,-1};
    }

    static int findLeftIndex(int[] nums, int target,int start,int end) {
//        int start = 0;
//        int end = nums.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                end = mid ;
            }else{
                start = mid + 1;
            }
        }  return start;
    }
    static int findRightIndex(int[] nums, int target,int start,int end) {
//        int start = 0;
//        int end = nums.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                start = mid ;
            }else {
                end = mid - 1;
            }
        }  return start;
    }
}
