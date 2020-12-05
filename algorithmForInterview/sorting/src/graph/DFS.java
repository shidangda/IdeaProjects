package graph;

public class DFS {
    //当图采用邻接矩阵存储时的DFS算法   -->应用 如力扣547题的朋友圈问题
    boolean[] visited;

    public void dfsTraverse(int[][] M){
        visited=new boolean[M.length];
        for(int v=0;v<M.length;v++){
            if(!visited[v])
                dfs(M,v);
        }
    }

    public void dfs(int[][] M,int v){
        visited[v]=true;
        for(int w=0;w<M.length;w++){
            if(M[v][w]==1&&!visited[w]){
                dfs(M,w);
            }
        }
    }
}
