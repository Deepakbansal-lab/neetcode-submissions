class Solution {
    public void islandsAndTreasure(int[][] grid) {


        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int d = 1;


        while(q.isEmpty() == false){

            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] curr = q.poll();
                visited[curr[0]][curr[1]] = true;

                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 2147483647 && visited[r][c] == false){
                        grid[r][c] = d;
                        q.offer(new int[]{r,c});
                    }
                }
            }
            d++;
        }
        
    }
}
