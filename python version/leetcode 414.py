class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max1 = max2 = max3 = None
        for n in nums:
            if n == max1 or n == max2 or n == max3: continue
            if max1 == None or n > max1:
                max1, max2, max3 = n, max1, max2
            elif max2 == None or n > max2:
                max2, max3 = n, max2
            elif max3 == None or n > max3:
                max3 = n
        return max3 if max3 != None else max1