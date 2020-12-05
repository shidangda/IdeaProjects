import java.util.List;
import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(){next=null;}
    ListNode(int x){ val=x;next=null;}
}


public class test {
    public static void main(String[] args) {
//        ListNode head=new ListNode();
//        head.next=null;
//
//        for(int i=0;i<10;i++){
//            ListNode p=new ListNode(i);
//            p.next=head.next;
//            head.next=p;
//        }
//        ListNode p=head.next;
//        while (p!=null){
//            System.out.print(p.val+" ");
//            p=p.next;
//        }
//
//        head.next=reverseList(head.next);
//        p=head.next;
//        while (p!=null){
//            System.out.print(p.val+" ");
//            p=p.next;
//        }
        Scanner in=new Scanner(System.in);
        System.out.println("请输入你的名字：");
        String name=in.nextLine();

        System.out.println(name+"是个大笨蛋！");
    }

    public static ListNode reverseList(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode pre=null,cur=head,nextTemp;
        while (cur!=null){
            nextTemp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextTemp;
        }
        return pre;
    }

    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        ListNode head;

        if(l1.val<l2.val){
            head=l1;
            head.next=mergeTwoLists(l1.next,l2.next);
        }
        else{
            head=l2;
            head.next=mergeTwoLists(l1,l2.next);
        }

        return head;
    }

    public static ListNode FindFirstCommonNode(ListNode head1,ListNode head2){
        int count1=0;
        int count2=0;
        ListNode p1=head1;
        ListNode p2=head2;

        while(p1!=null){
            count1++;
            p1=p1.next;
        }
        while (p2!=null){
            count2++;
            p2=p2.next;
        }

        p1=head1;
        p2=head2;
        int sub=count1-count2;
        if(sub>0){
            for(int i=0;i<sub;i++) p1=p1.next;
        }
        else {
            for(int i=0;i<Math.abs(sub);i++) p2=p2.next;
        }

        while (p1!=null&&p2!=null&&p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }

        if(p1==p2) return p1;
        else return null;
    }


}
