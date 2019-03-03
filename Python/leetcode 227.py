class Solution:
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == None or len(s) == 0: return 0
        stack = []
        num, sign = 0, '+'
        for i in range(len(s)):
            if s[i].isdigit(): num = num * 10 + int(s[i])
            if ((not s[i].isdigit()) and s[i] != ' ') or i == len(s)-1:
                if sign == '+': stack.append(num)
                if sign == '-': stack.append(-num)
                if sign == '*': stack.append(stack.pop() * num)
                if sign == '/': stack.append(int(stack.pop() / num))
                sign = s[i]
                num = 0
        Sum = 0
        for num in stack:
            Sum += num
        return Sum
        