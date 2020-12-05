public class q03 {
    public static void main(String[] args) {
        String s="we are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        StringBuffer s2=new StringBuffer(s);
        int countSpace=0;
        int len=s2.length();
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)==' '){
                countSpace++;
            }
        }
        s2.setLength(countSpace*3+len-2);
        for(int i=s2.length()-1,j=len-1;j>=0;){
            if(s2.charAt(j)!=' '){
                s2.setCharAt(i,s2.charAt(j));
                j--;
                i--;
            }
            else{
                s2.setCharAt(i--,'0');
                s2.setCharAt(i--,'2');
                s2.setCharAt(i--,'%');
                j--;
            }
        }

        return s2.toString();
    }
}
