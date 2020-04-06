class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 0) return 0;
        
        int max = 0, profit = 0;
        int min = prices[0];
        boolean isMin = false;
        boolean isMax = false;

        for (int i : prices) {
            if(i <= min && !isMin){
                min = i; isMax = false; continue;
            } else {
                isMin = true;
            }

            if(i > max){
                max = i;
                if(prices[prices.length-1] == i) isMax = true;
            } else {
                isMax = true; profit += max - min; isMin = false; min = i; max = 0;
            }
        }

        if(isMax && isMin)
            profit += max - min;

        return !isMin || isMax ? profit : max - min;
    }
}