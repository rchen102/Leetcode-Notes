class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        dic = {}
        for s in strs:   
            val = "".join(sorted(list(s)))
            if val in dic:
                (dic[val]).append(s)
            else:
                dic[val] = [s,]
        return dic.values()
                