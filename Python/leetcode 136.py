class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dic = {}
        for num in nums:
            if num in dic: dic.pop(num)
            else: dic[num] = 1
        lis = list(dic.keys())
        return lis[0]
        