class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }
        
        double[] results = new double[queries.size()];
        
        // Helper function to perform DFS
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String src = query.get(0);
            String dst = query.get(1);
            Set<String> visited = new HashSet<>();
            results[i] = dfs(graph, src, dst, visited);
        }
        
        return results;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String src, String dst, Set<String> visited) {
        if (!graph.containsKey(src) || !graph.containsKey(dst)) {
            return -1.0;
        }
        if (src.equals(dst)) {
            return 1.0;
        }
        
        visited.add(src);
        
        Map<String, Double> neighbors = graph.get(src);
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            String nextNode = neighbor.getKey();
            if (visited.contains(nextNode)) {
                continue;
            }
            double result = dfs(graph, nextNode, dst, visited);
            if (result != -1.0) {
                return result * neighbor.getValue();
            }
        }
        
        return -1.0;
    }
}
