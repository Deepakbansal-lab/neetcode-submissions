class Solution {
    public int orangesRotting(int[][] grid) {


        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int m = grid.length;
        int n = grid[0].length;
        int time = 0;

        int fresh = 0;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        while(fresh > 0 && q.isEmpty() == false){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] rotten = q.poll();

                for(int[] dir : dirs){
                    int ii = rotten[0] + dir[0];
                    int jj = rotten[1] + dir[1];
                    if(ii >= 0 && jj >= 0 && ii < m && jj < n && grid[ii][jj] == 1 && visited[ii][jj] == false){
                        visited[ii][jj] = true;
                        grid[ii][jj] = 2;
                        q.offer(new int[]{ii,jj});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
