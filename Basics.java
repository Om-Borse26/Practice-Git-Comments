import java.util.Arrays;

public class Basics {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long windowSum = 0; 
        int maxFreq = 1;
        
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            
            // Calculate operations needed to make all elements in window equal to nums[right]
            // Formula: target * windowSize - currentSum
            long target = nums[right];
            int windowSize = right - left + 1;
            long operationsNeeded = target * windowSize - windowSum;
            
            // If operations exceed k, shrink window from left
            while (operationsNeeded > k) {
                windowSum -= nums[left];
                left++;
                windowSize = right - left + 1;
                operationsNeeded = target * windowSize - windowSum;
            }
            
            // Update maximum frequency
            maxFreq = Math.max(maxFreq, windowSize);
        }
        
        return maxFreq;
    }

    public static void main(String[] args) {
        // Test case 1: [1,2,4], k=5
        int[] nums1 = {1,2,4};
        int k1 = 5;
        System.out.println("Test 1: [1,2,4], k=5 -> " + maxFrequency(nums1, k1) + " (Expected: 3)");
        
        // Test case 2: [1,4,8,13], k=5
        int[] nums2 = {1,4,8,13};
        int k2 = 5;
        System.out.println("Test 2: [1,4,8,13], k=5 -> " + maxFrequency(nums2, k2) + " (Expected: 2)");
        
        // Test case 3: [3,9,6], k=2
        int[] nums3 = {3,9,6};
        int k3 = 2;
        System.out.println("Test 3: [3,9,6], k=2 -> " + maxFrequency(nums3, k3) + " (Expected: 1)");
        
        // Test case 4: Single element
        int[] nums4 = {1};
        int k4 = 0;
        System.out.println("Test 4: [1], k=0 -> " + maxFrequency(nums4, k4) + " (Expected: 1)");
        
        // Test case 5: All same elements
        int[] nums5 = {5,5,5,5};
        int k5 = 0;
        System.out.println("Test 5: [5,5,5,5], k=0 -> " + maxFrequency(nums5, k5) + " (Expected: 4)");
    }
}