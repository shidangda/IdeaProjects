public class p119TwoSumForString {
    public static void main(String[] args) {
        String s1="123456789";
        String s2="11";
        System.out.println(new p119TwoSumForString().twoSum(s1,s2));
    }

    public String twoSum(String s1,String s2){
        StringBuilder sB1=new StringBuilder(s1).reverse();
        StringBuilder sB2=new StringBuilder(s2).reverse();
        StringBuilder sB3=new StringBuilder();
        int p1=0,p2=0;
        int sum=0,x=0,y=0,carry=0;
        while(p1<sB1.length() || p2<sB2.length()){
            x=p1<sB1.length() ? sB1.charAt(p1)-'0' : 0;
            y=p2<sB2.length() ? sB2.charAt(p2)-'0' : 0;
            sum=x+y+carry;
            carry=sum/10;
            sB3.append(sum%10);
            if(p1<sB1.length()) p1++;
            if(p2<sB2.length()) p2++;
        }
        if(carry==1) sB3.append(carry);

        return  sB3.reverse().toString();
    }
}
