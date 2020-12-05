package kmp;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String s="abacdeaba";
        System.out.println(Arrays.toString(new KMP().getNext(s)));
        System.out.println(new KMP().kmp(s,"bacdeabc"));
    }


    public int kmp(String S,String T){
        if(T==null || S==null || T.length()==0 || S.length()==0) return -1;

        int[] next=getNext(T);
        int i=0,j=0;
        for(;i<S.length() && j<T.length();){
            if(j==-1 || S.charAt(i)==T.charAt(j)){
                i++;
                j++;
            }
            else j=next[j];
        }
        return j==T.length() ? i-T.length() : -1;
    }

    public int[] getNext(String T){
        if(T==null || T.length()==0) return new int[0];
        if(T.length()==1) return new int[]{-1};
        if(T.length()==2) return new int[]{-1,0};

        int[] next=new int[T.length()];
        next[0]=-1;
        next[1]=0;
        for(int j=2;j<T.length();j++){
            int k=next[j-1];
            while (k>=0 && T.charAt(j)!=T.charAt(k)){  //寻找第j个元素之前的最大的公共前后缀0,1,...,k-1 和j-k,j-k+1,...,j-1，
                k=next[k];  //且满足它们的后面的元素，T.charAt(j)==T.charAt(k)
            }
            next[j]=k+1;
        }
        return next;
    }
}








//    public int kmp(String S,String T){
//        if(T.length()==0) return 0;
//        if(S.length()==0) return -1;
//
//        int[] next=getNext(T);
//        int i=0,j=0;
//        for(;i<=S.length()-T.length();){
//            if(j<T.length() && S.charAt(i)==T.charAt(j)){
//                i++;
//                j++;
//            }
//            else if(j==T.length()){
//                break;
//            }
//            else {
//                j=next[j];
//                if(j==-1){  //说明前一个j为0，且S.charAt(i)!=T.charAt(0)
//                    i++;
//                    j=0;
//                }
//            }
//        }
//        if(j==T.length()) return i-T.length();
//        else return -1;
//
//    }
//
//    public int[] getNext(String T){
//        int[] next=new int[T.length()];
//
//        next[0]=-1;
//        next[1]=0;
//        for(int i=2;i<next.length;i++){
//            int k=next[i-1];
//            if(T.charAt(i)==T.charAt(k)){
//                next[i]=k+1;
//            }
//            else {
//                while (k>=0 && T.charAt(i)!=T.charAt(k)){
//                    k=next[k];
//                }
//                if(k<0 || T.charAt(i)==T.charAt(k)){
//                    next[i]=k+1;
//                }
//            }
//        }
//        return next;
//    }
//}
