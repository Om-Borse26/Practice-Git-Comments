public class Binary_Search{

    public static int lower_bound(int nums[], int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length; 
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] >= target){ 
                ans = mid;
                high = mid - 1; 
            }
            else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    public static int upper_bound(int nums[], int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length; 
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] > target){ 
                ans = mid;
                high = mid - 1; 
            }
            else {
                low = mid + 1;
            }
        }
        
        return ans;
    }

    public static void floor_ceiling(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int floor = -1;
        int ceiling = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                floor = nums[mid];
                ceiling = nums[mid];
                break;
            }
            else if(nums[mid] > target){
                ceiling = nums[mid];
                high = mid-1;
            }
            else if(nums[mid] < target){
                low = mid +1;
                floor= nums[mid];
            }
        }
        
        System.out.println(floor);
        System.out.println(ceiling);
        
    }

    public static int search(int[] nums, int target, boolean firstIndex){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;

        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] < target){
                start = mid+1;
            }
            else if(nums[mid] > target){
                end = mid-1;
            }
            else{
                ans = mid;
                if(firstIndex){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        
        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = search(nums,target,true);
        ans[1] = search(nums,target,false);
        return ans;
    }

    public static int CountOccurance(int[] nums,int target){
        
        int ans[] = searchRange(nums, target);
        return ans[1] - ans[0]  + 1;
    }

    public static int searchInRotated(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check which half is sorted
            if (nums[low] <= nums[mid]) {
                // Left half is sorted
                if (nums[low] <= target && target < nums[mid]) {
                    // Target is in the sorted left half
                    high = mid - 1;
                } else {
                    // Target is in the right half
                    low = mid + 1;
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    // Target is in the sorted right half
                    low = mid + 1;
                } else {
                    // Target is in the left half
                    high = mid - 1;
                }
            }
        }
        
        
        return -1; // Target not found
    }

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
        
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        
        return nums[low];
    }
    
    public static int checkRotation(int nums[]){
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low] <= nums[high]){
                if(nums[low] < ans){
                    index = low;
                    ans = nums[low];
                }
                break;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low]<ans){
                    index = low;
                    ans = nums[low];
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(nums[mid]<ans){
                    index = mid;
                    ans = nums[mid];
                }
                else{
                    high = mid-1;
                }
            }
        }
        return index;
    }

    public  int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        else if(nums[0] != nums[1]){
            return nums[0];
        }
        else if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }

        while(low<=high){
            int mid = (low+high)/2;

            if((nums[mid] != nums[mid -1]) && (nums[mid] != nums[mid+1])){
                return nums[mid];
            }
            else if((mid%2 == 0 && nums[mid] == nums[mid+1]) || (mid%2 == 1 && nums[mid] == nums[mid-1])){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]>nums[mid-1]){
                return mid;
            }
            else if (nums[low] < nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,7,0,1,2};
        // System.out.println(findMin(nums));
        System.out.println(checkRotation(nums));
    }
}