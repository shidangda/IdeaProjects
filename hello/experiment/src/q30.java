import java.util.LinkedList;

public class q30 {
    public static void main(String[] args) {
        MinStack stack=new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}

class MinStack {
    LinkedList<Integer> stack1;  //数据栈
    LinkedList<Integer> stack2;  //辅助栈

    /** initialize your data structure here. */
    public MinStack() {
        this.stack1=new LinkedList<>();
        this.stack2=new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty() || stack2.peek()>=x) stack2.push(x);
    }

    public void pop() {
        if(stack1.isEmpty()) return;
        if(stack1.peek()==stack2.peek()){
            stack1.pop();
            stack2.pop();
        }
        else{
            stack1.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}

