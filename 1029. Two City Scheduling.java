class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(t,o)->{
            int profit1 = t[1] - t[0];
            int profit2 = o[1] - o[0];

            if(profit1>profit2) return -1;
            else if(profit1 < profit2) return +1;
            else return 0;
        });

        int n = costs.length/2;
        int cost = 0;
        
        for(int i=0;i<n;i++) cost += costs[i][0];
        for(int i = n; i< costs.length; i++) cost += costs[i][1];


        return cost;
    }
}
