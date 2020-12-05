import java.util.Arrays;

public class q05 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] nums1={1,2,3,0,0,0};
        int m=3;
        int[] nums2={2,5,6};
        int n=3;
        int[] res=merge(nums1,nums2,m,n);
        System.out.println(Arrays.toString(res));  //注意Arrays，java集合等都在java.util包里面，面试手写代码时，注意导入包
    }

    public static int[] merge(int[] nums1,int[] nums2,int m,int n){  //在面试写代码的时候，需要自己写相应的函数名和输入参数及返回类型，然后用主函数调用。
        if(nums1==null || nums2==null) return null;  //等函数写完之后再来考虑输入输出的问题，这样简介清晰。
        int p1=m-1,p2=n-1,p3=m+n-1;
        while(p3>=0){
            if(p2>=0&&nums2[p2]>nums1[p1]){  //在使用数组的时候，一定要注意指针是否越界，这里必须考虑p2可能等于-1，即nums2已经全部复制到s1上的情况
                nums1[p3--]=nums2[p2--];
            }
            else {
                nums1[p3--]=nums1[p1--];
            }
        }
        return nums1;
    }
}
