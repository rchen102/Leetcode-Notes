class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        aSet = set()
        for i in range(len(nums)):
            if i > k: aSet.discard(nums[i-k-1])
            if nums[i] not in aSet: aSet.add(nums[i])
            else: return True
        return False