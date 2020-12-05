import static java.lang.Math.*;
public class q14 {
    public static void main(String[] args) {
        System.out.println(new q14().cuttingRope(6));
    }
    public int cuttingRope(int n) {
        if(n<2) return 0;

        int[] maxN=new int[n+1];
        maxN[1]=1;
        maxN[2]=1;

        for(int i=3;i<n+1;i++){
            maxN[i]=max(1*maxN[i-1],1*(i-1));
            for(int j=1;j<=i-1;j++){
                if(maxN[i]<max(j*maxN[i-j],j*(i-j))){
                    maxN[i]=max(j*maxN[i-j],j*(i-j));
                }
            }
        }

        return maxN[n];
    }
}
