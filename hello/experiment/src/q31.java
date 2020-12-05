import java.util.LinkedList;

public class q31 {

    public static void main(String[] args) {
        int[] pushed={1,2,3,4,5};
        int[] popped={4,5,3,2,1};

        System.out.println(new q31().validateStackSequences(pushed,popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null && popped==null) return true;

        int i=0,j=0;
        LinkedList<Integer> stack=new LinkedList<>();
        while(i<pushed.length || j<popped.length){
            if(stack.isEmpty() && i<pushed.length){
                stack.push(pushed[i++]);
            }
            if(!stack.isEmpty() && !stack.peek().equals(popped[j])){
                if(i<pushed.length) stack.push(pushed[i++]);
                else return false;
            }
            if(!stack.isEmpty() && stack.peek().equals(popped[j])){
                stack.pop();
                j++;
            }
        }
        return true;
    }

}
