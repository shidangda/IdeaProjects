import java.util.Arrays;
import java.util.*;

public class Experiment {
    public static void main(String[] args) {
        int[][] res=new Experiment().findContinuousSequence(9);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int[][] findContinuousSequence(int target){
        if(target<=2) return new int[0][0];

        ArrayList<int[]> resList=new ArrayList<>();
        int i=1,j=i+1,k=i;
        int sum=(i+j)*(j-i+1)/2;
        while(i<=target/2){
            if(sum==target) {
                int r=0;
                int[] tmp=new int[j-i+1];
                for(k=i;k<=j;k++){
                    tmp[r++]=k;
                }
                resList.add(tmp);
                i++;
            }
            if(sum<target) j++;
            if(sum>target) i++;
            sum=(i+j)*(j-i+1)/2;
        }
        int[][] res=new int[resList.size()][];
        for(i=0;i<resList.size();i++){
            res[i]=new int[resList.get(i).length];
            for(j=0;j<resList.get(i).length;j++){
                res[i][j]=resList.get(i)[j];
            }
        }
        return res;
    }








//    public static void main(String[] args) {
//        int[] nums={4,1,4,6};
//        System.out.println(Arrays.toString(new Experiment().singleNumbers(nums)));
//        ArrayList<int[]> res=new ArrayList<>();
//    }


//    public int[] singleNumbers(int[] nums) {
//        if(nums==null) return new int[0];
//        if(nums.length==2) return nums;
//
//        Map<Integer,Integer> dic=new HashMap<>();
//        int[] res=new int[2];
//        for(int i=0;i<nums.length;i++){
//            if(!dic.containsKey(nums[i])) dic.put(nums[i],1);
//            else dic.put(nums[i],2);
//        }
//        for(int i=0,j=0;i<nums.length;i++){
//            if(dic.get(nums[i])==1) res[j++]=nums[i];
//        }
//        return res;
//    }



//    public int reversePairs(int[] nums) {
//        if(nums==null || nums.length==0 || nums.length==1) return 0;
//
//        int n=nums.length;
//        int count=0;
//        int[] dp=new int[n];
//        Map<Integer,Integer> dic=new HashMap<>();
//        dp[0]=0;
//        dic.put(nums[0],0);
//        int max=nums[0];
//        for(int i=1;i<nums.length;i++){
//            if(nums[i]>=max) {
//                dp[i]=0;
//                max=nums[i];
//            }
//            else if(nums[i]<max){
//                int bigger=nums[i];
//                int j=-1;
//                for(;bigger<=max;bigger++){
//                    j=dic.getOrDefault(bigger,-1);
//                    if(j!=-1) break;
//                }
//                for(int k=i-1;k>=j;k--){
//                    if(nums[k]>nums[i]) dp[i]++;
//                }
//                dp[i]=dp[i]+dp[j];
//            }
//            dic.put(nums[i],i);
//        }
//        for(int i=1;i<dp.length;i++) count+=dp[i];
//        return count;
//    }










//    public static void main(String[] args) {
//        int[] nums={3,30,34,5,9};
//        System.out.println(new Experiment().minNumber(nums));
//    }
//
//
//    public String minNumber(int[] nums) {
//        if(nums==null || nums.length==0) return null;
//        StringBuilder sb=new StringBuilder();
//        quickSort(nums,0,nums.length-1);
//        for(int e : nums){
//            sb.append(e);
//        }
//
//        return sb.toString();
//    }
//
//    void quickSort(int[] nums,int low,int high){
//        if(low>=high) return;
//        int p=partition(nums,low,high);
//        quickSort(nums,low,p-1);
//        quickSort(nums,p+1,high);
//    }
//
//    int partition(int[] nums,int low,int high){
//        int pivot=nums[low];
//        int i=low,j=high;
//        i++;
//        while(i<=j){
//            while(i<=j&&compareTo(nums[i],pivot)<=0) i++;
//            while(i<=j&&compareTo(nums[j],pivot)>0) j--;
//            if(i<=j){
//                int tmp=nums[i];
//                nums[i]=nums[j];
//                nums[j]=tmp;
//                i++;
//                j--;
//            }
//        }
//        nums[low]=nums[j];
//        nums[j]=pivot;
//        return j;
//    }
//
//    int compareTo(int num1,int num2){
//        StringBuilder s1=new StringBuilder(""+num1);  //StringBuilder构造方法的整数为预计的容量
//        StringBuilder s2=new StringBuilder(""+num2);
//
//        int i=0,j=0,k=0;
//        int max=Math.max(s1.length(),s2.length());
//        while(k<max){
//            if(i==s1.length()) i=0;
//            if(j==s2.length()) j=0;
//            if(s1.charAt(i)<s2.charAt(j)) return -1;
//            if(s1.charAt(i)>s2.charAt(j)) return 1;
//            if(s1.charAt(i)==s2.charAt(j)){
//                i++;
//                j++;
//                k++;
//            }
//        }
//
//        return 0;
//    }








//    public static void main(String[] args) {
//        int[] arr={3,2,1};
//        System.out.println(Arrays.toString(new Experiment().getLeastNumbers(arr,2)));
//    }
//
//    public int[] getLeastNumbers(int[] arr,int k){
//        if(arr==null || arr.length==0 || k==0) return new int[0];
//
//        return quickSearch(arr,0,arr.length-1,k);
//    }
//
//    public int[] quickSearch(int[] arr,int low,int high,int k){
//        int j=partition(arr,low,high);
//        if(j==k-1) return Arrays.copyOf(arr,j+1);
//        if(j>k-1) return quickSearch(arr,low,j-1,k);
//        else return quickSearch(arr,j+1,high,k);
//    }
//
//    public int partition(int[] arr,int low,int high){
//        int i=low,j=high;
//        int pivot=arr[low];
//        i++;
//        while(i<=j){
//            while(i<=j&&arr[i]<=pivot) i++;
//            while(i<=j&&arr[j]>pivot) j--;
//            if(i>j) break;
//            int tmp=arr[i];
//            arr[i]=arr[j];
//            arr[j]=tmp;
//        }
//        arr[low]=arr[j];
//        arr[j]=pivot;
//        return j;
//    }










//    public static void main(String[] args) {
//        String x="ABCBDAB";
//        String y="BDCABA";
//
//        System.out.println("最大公共子序列："+ new Experiment().memoLCS(x,y));
//    }
//
//          /*备忘录方法求解动态规划问题程序实例*/
//    public String memoLCS(String x,String y) {  //备忘录方法求动态规划问题
//        int m=x.length(),n=y.length();
//        int[][] c=new int[m+1][n+1];
//        int[][] b=new int[m+1][n+1];
//        StringBuilder res=new StringBuilder();
//
//        for(int i=0;i<=m;i++){
//            for(int j=0;j<=n;j++){
//                c[i][j]=-1;
//            }
//        }
//
//        System.out.println(LCS(m,n,x,y,c,b));  //先计算最优值，并用c[i][j]记录子问题最优值，b[i][j]记录子问题间的递推关系
//        LCS(m,n,x,y,b,res);  //利用b[][]构造最优解
//        return res.toString();
//    }
//
//    public int LCS(int i,int j,String x,String y,int[][] c,int[][] b){
//        //返回Xi和Xj的最大公共子序列长度,c[i][j]记录Xi和Xj最大公共子序列长度，b[i][j]记录c[i][j]与c[i-1][j-1]和c[i-1][j],c[i][j-1]的递推关系
//        if(c[i][j]!=-1) return c[i][j];
//        if(i==0 || j==0){
//            return 0;
//        }
//
//        if(x.charAt(i-1)==y.charAt(j-1)){  //x是从0开始的,故比较的是第i-1个字符，y同理
//            c[i][j]=LCS(i-1,j-1,x,y,c,b)+1;
//            b[i][j]=1;
//        }
//        else {
//            c[i-1][j]=LCS(i-1,j,x,y,c,b);
//            c[i][j-1]=LCS(i,j-1,x,y,c,b);
//            if(c[i-1][j]>=c[i][j-1]){
//                c[i][j]=c[i-1][j];
//                b[i][j]=2;
//            }
//            else {
//                c[i][j]=c[i][j-1];
//                b[i][j]=3;
//            }
//        }
//
//        return c[i][j];
//    }
//
//    public void LCS(int i,int j,String x,String y,int[][] b,StringBuilder res){
//        if(i==0||j==0){
//            return;
//        }
//        if(b[i][j]==1){
//            LCS(i-1,j-1,x,y,b,res);
//            res.append(x.charAt(i-1));
//        }
//        else if(b[i][j]==2){
//            LCS(i-1,j,x,y,b,res);
//        }
//        else
//            LCS(i,j-1,x,y,b,res);
//    }










//    public static void main(String[] args) {
//        int[] nums={1,2,3,4};
//        new Experiment().exchange(nums);
//        System.out.println(Arrays.toString(nums));
//
//    }
//
//    public int[] exchange(int[] nums) {
//        int i=0,j=nums.length-1;
//        int t;
//        while(i<j){
//            while(nums[i]%2==1&&i<j) i++;
//            while(nums[j]%2==0&&i<j) j--;
//            t=nums[i];
//            nums[i]=nums[j];
//            nums[j]=t;
//        }
//        return  nums;












          /*字节跳动一面编程题*/
//    public static void main(String[] args) {
//        //Scanner in = new Scanner(System.in);
//        //int a = in.nextInt();
//        //System.out.println(a);
//        int[] nums1={1,2,3,0,0,0};
//        int m=3;
//        int[] nums2={2,5,6};
//        int n=3;
//        int[] res=merge(nums1,nums2,m,n);
//        System.out.println(Arrays.toString(res));
//    }
//
//    public static int[] merge(int[] nums1,int[] nums2,int m,int n){
//        if(nums1==null || nums2==null) return null;
//        int p1=m-1,p2=n-1,p3=m+n-1;
//        while(p3>=0){
//            if(p2>=0&&nums2[p2]>nums1[p1]){
//                nums1[p3--]=nums2[p2--];
//            }
//            else {
//                nums1[p3--]=nums1[p1--];
//            }
//        }
//        return nums1;
//    }
}
