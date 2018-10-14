class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        i, j, cout = len(a)-1, len(b)-1, 0
        res = []
        while i >= 0 or j >= 0:
            if i >= 0: cout += int(a[i])
            if j >= 0: cout += int(b[j])
            i -= 1
            j -= 1
            res.append(cout%2)
            cout = cout // 2
            
        if cout != 0 : res.append(cout)
        return "".join(list(map(str,res[::-1]))) 