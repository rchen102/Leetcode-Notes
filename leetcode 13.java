class Solution {
    public int romanToInt(String s) {
        int[] res = new int[s.length()];
        int sum = 0;
    
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I':
                    res[i] = 1;
                    break;
                case 'V':
                    res[i] = 5;
                    break;
                case 'X':
                    res[i] = 10;
                    break;
                case 'L':
                    res[i] = 50;
                    break;
                case 'C':
                    res[i] = 100;
                    break;
                case 'D':
                    res[i] = 500;
                    break;
                case 'M':
                    res[i] = 1000;
                    break;
                default:
                    continue;
            }
            if(i > 0) {
                if(res[i] > res[i-1]) {
                    sum -= res[i-1] * 2;
                    sum += res[i];
                }     
                else
                    sum += res[i];
            }
            else
                sum += res[i];
        }
        return sum;   
    }
}