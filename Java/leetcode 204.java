class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // 注意 i 优化，只需要遍历到 sqrt(n)
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // 注意 j 优化从 i * i 开始
                for (int j = i * i; j < n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) res++;
        }
        return res;
    }
}

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // j 未优化，遍历所有 i 的倍数
                for (int j = 2 * i; j < n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) res++;
        }
        return res;
    }
}


// 优化的暴力解法
class Solution {
    public int countPrimes(int n) {
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) counter++;
        }
        return counter;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}