//Solution1: T: O(1) S: O(1)
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s1 = Math.abs((A-C) * (B-D)) + Math.abs((E-G) * (F-H));
        int s2 = 0;
        
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
    
        if( (right < left) || (top < bottom)) s2 = 0;
        // can not be writen like
        // if( (right - left  < 0) || (top -  bottom < 0)) s2 = 0; 
        // becuase when right & left is very big, it may overflow

        else s2 = (right - left) * (top - bottom);
        return s1-s2;
    }
}