class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        aList = list(s)
        stack = []
        for pa in s:
            if pa == '(':
                stack.append(')')
            elif pa == '[':
                stack.append(']')
            elif pa == '{':
                stack.append('}')
            else:
                if len(stack) == 0 or stack.pop() != pa:
                    return False
        return stack == []
                
        