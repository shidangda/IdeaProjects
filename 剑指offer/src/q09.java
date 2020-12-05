import java.util.*;

public class q09 {

}

/*
 * 两个队列实现栈的入栈和出栈操作
 */

class Stack{
    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    public  Stack(){
        queue1=new LinkedList<>();
        queue1=new LinkedList<>();
    }

    public void push(int value){
        if(!queue1.isEmpty()){
            queue1.offer(value);
        }
        else queue2.offer(value);
    }

    public int pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            queue1.poll();
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            queue2.poll();
        } else return -1;
        return -1;
    }
}
