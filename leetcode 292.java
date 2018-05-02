//because 4 is a death number, if 4*i < n < 4*(i+1), then you can leave the death number to second player
class Solution {
    public boolean canWinNim(int n) {
    	return n % 4 != 0;
    }
}