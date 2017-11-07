// https://leetcode.com/problems/two-sum/description/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // While we haven't found the target
        for(int i = 0; i<nums.length; i++)
        {
            // Keep looking for it
            for(int j = i+1; j<nums.length; j++)
            {
                // If greater/equal to target
                if(nums[i] + nums[j] >= target)
                {
                    // Check if equal and end
                    if(nums[i] + nums[j] == target)
                    {
                        return new int[] {i,j};
                    }
                    // Otherwise go to the next i
                    else
                    {
                        break;
                    }
                }
            }
        }
        
        return null;
    }
}