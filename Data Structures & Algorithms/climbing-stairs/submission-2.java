class Solution 
{
    public int climbStairs(int n)
    {
        return calculate(n, 0);
    }

    public int calculate(int n, int currentStepValue)
    {
        if (currentStepValue >= n) {
            return currentStepValue == n ? 1 : 0;
        }
        return calculate(n, currentStepValue + 1) + calculate(n, currentStepValue + 2);
    }
}
