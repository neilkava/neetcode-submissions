class Solution 
{
    int distinctWays = 0;

    public int climbStairs(int n)
    {
        calculate(n, 0);
        return distinctWays;
    }

    public void calculate(int n, int currentStepValue)
    {
        if (currentStepValue < n) {
            calculate(n, currentStepValue + 1);
            calculate(n, currentStepValue + 2);
            return;
        }

        if (currentStepValue > n) {
            return;
        }

        if (currentStepValue == n) {
            distinctWays++;
            return;
        }

    }
}
