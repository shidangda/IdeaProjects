package other;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val=x;}
}

public class Algorithm {

    public static ListNode reverseList(ListNode head){
        //正确性判断
        if(head==null || head.next==null){
            return head;
        }

        ListNode pre=null;  //三个指针pre、cur、nextTemp解决链表反转问题
        ListNode cur=head;
        ListNode nextTemp;
        while(cur!=null){
            nextTemp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextTemp;
        }
        return pre;
    }
}
