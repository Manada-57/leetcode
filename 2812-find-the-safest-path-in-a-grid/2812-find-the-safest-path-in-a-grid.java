class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        if(grid.get(0).get(0)==1||grid.get(n-1).get(n-1)==1)return 0;
        int[][] dist=new int[n][n];
        for(int[] row:dist)Arrays.fill(row,Integer.MAX_VALUE);
        Queue<int[]> q=new LinkedList<>();
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid.get(r).get(c)==1){
                    dist[r][c]=0;
                    q.offer(new int[]{r,c});
                }
            }
        }
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            for(int[] d:dirs){
                int nr=curr[0]+d[0],nc=curr[1]+d[1];
                if(nr>=0&&nr<n&&nc>=0&&nc<n&&dist[nr][nc]==Integer.MAX_VALUE){
                    dist[nr][nc]=dist[curr[0]][curr[1]]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.offer(new int[]{dist[0][0],0,0});
        boolean[][] visited=new boolean[n][n];
        visited[0][0]=true;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int safe=curr[0],r=curr[1],c=curr[2];
            if(r==n-1&&c==n-1)return safe;
            for(int[] d:dirs){
                int nr=r+d[0],nc=c+d[1];
                if(nr>=0&&nr<n&&nc>=0&&nc<n&&!visited[nr][nc]){
                    visited[nr][nc]=true;
                    pq.offer(new int[]{Math.min(safe,dist[nr][nc]),nr,nc});
                }
            }
        }
        return 0;
    }
}
