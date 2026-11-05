class Solution 
{
    int[] cache;
    public int climbStairs(int n)
    {
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return calculate(n, 0);
    }

    public int calculate(int n, int currentStepValue)
    {
        if (currentStepValue >= n) {
            return currentStepValue == n ? 1 : 0;
        }
        
        if (cache[currentStepValue] != -1) {
            return cache[currentStepValue];
        }

        return cache[currentStepValue] = calculate(n, currentStepValue + 1) + calculate(n, currentStepValue + 2);
    }
}
