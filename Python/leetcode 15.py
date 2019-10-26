class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        for i in range(len(nums)-2):
            if i == 0 or (i > 0 and nums[i] != nums[i-1]):
                self.twoSum(res, i, nums)
        return res    
    
    def twoSum(self, res, idx, nums):
        target = -nums[idx]
        lo, hi = idx + 1, len(nums) - 1
        while (lo < hi):
            if nums[lo] + nums[hi] == target:
                res.append((nums[idx], nums[lo], nums[hi]))
                while (lo < hi) and (nums[lo] == nums[lo+1]):
                    lo += 1
                while (lo < hi) and (nums[hi] == nums[hi-1]):
                    hi -= 1
                lo += 1
                hi -= 1
            elif nums[lo] + nums[hi] < target:
                lo += 1
            else:
                hi -= 1
    


    
        
        