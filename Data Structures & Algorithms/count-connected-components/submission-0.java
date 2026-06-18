class Solution {
    public int countComponents(int n, int[][] edges) {


        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        int count = 0;

        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(visited.contains(i) == false){
                count++;
                dfs(adjList, i, visited);
            }
        }

        return count;
    }


    private void dfs(List<List<Integer>> adjList, int i, Set<Integer> visited){

        if(visited.contains(i) == false){
            List<Integer> list =  adjList.get(i);
            visited.add(i);
            for(Integer neigh : list){
                dfs(adjList, neigh, visited);
            }
        }
    }
}
