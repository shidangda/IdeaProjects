package unionFind;

public class UnionFind {
    int[] s;  //并查集数组，下标0~N-1表示N个元素，s[i]表示元素i的父节点，如果i为根节点，则s[i]为负数，且绝对值大小表示以i为根节点的树的元素个数

    public static void union(int[] s,int a,int b){  //按秩合并的union方法，这里的秩为树的元素个数，将元素少的树并到元素多的树上。
        int x=find(s,a);
        int y=find(s,b);
        if(s[x]<=s[y]){
            s[x]+=s[y];
            s[y]=x;
        }
        else{
            s[y]+=s[x];
            s[x]=y;
        }
    }

    public static int find(int[] s,int x){  //采用路径压缩的查找算法
        if(s[x]<0) return x;
        else return s[x]=find(s,s[x]);
    }

}
