class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int result = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false && grid[i][j] == 1){
                    int count = dfs(grid, visited, i, j);
                    result = Math.max(result,  count);
                }
            }
        }
        return result;
    }


    private int dfs(int[][] grid, boolean[][] visited, int i, int j){

        int[][] dirs =  {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && visited[i][j] == false && grid[i][j] == 1){
            int count = 0;
            visited[i][j] = true;
            for(int[] dir : dirs){
                count += dfs(grid, visited, i + dir[0], j + dir[1]); 
            }
            return count + 1;
        }
        return 0;
    }
}
