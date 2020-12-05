import java.lang.ref.SoftReference;
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val=x;}
}

class Node{
    int val;
    Node next;
    Node(int x){val=x;}
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val=x;}
}

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Integer> dic=new HashMap<>();
        for (int i = 0; i < 20; i++) {
            dic.put(i,i);
        }


    }





//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        l1 = reverse(l1);
//        l2 = reverse(l2);
//
//        int c = 0;
//        ListNode dummy = new ListNode(0);
//        ListNode p1 = l1, p2 = l2, p3 = dummy;
//        while (p1.next != null && p2.next != null) {
//            int tmp = p1.val + p2.val + c;
//            if (tmp < 10) {
//                ListNode node = new ListNode(tmp);
//                p3.next = node;
//            } else {
//                c = tmp % 10;
//                ListNode node = new ListNode(tmp / 10);
//                p3.next = node;
//            }
//            p3 = p3.next;
//        }
//        if (p2.next != null) {
//            p1 = p2;
//            p2 = null;
//        }
//        while (p1.next != null) {
//            int tmp = p1.val + c;
//            ListNode node;
//            if (tmp < 10) {
//                node = new ListNode(tmp);
//            } else {
//                c = tmp % 10;
//                node = new ListNode(tmp / 10);
//            }
//            p3.next = node;
//            p3 = p3.next;
//        }
//        reverse(dummy.next);
//        return dummy.next;
//    }
//
//    public ListNode reverse(ListNode l1) {
//        ListNode preP = null, curP = l1, postP = l1;
//        while (curP.next != null) {
//            postP = curP.next;
//            curP.next = preP;
//            preP = curP;
//            curP = postP;
//        }
//        return curP;
//    }
}




























//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        while (in.hasNextInt()){
//            int N=in.nextInt();
//            TreeSet<Integer> nums=new TreeSet<>();
//            for(int i=0;i<N;i++){
//                int tmp=in.nextInt();
//                if(!nums.contains(tmp)){
//                    nums.add(tmp);
//                }
//            }
//            for(int e : nums){
//                System.out.println(e);
//            }
//        }
//    }




//
//class pos{
//    int x;
//    int y;
//    pos(int x,int y){ this.x=x;this.y=y;}
//}

//class Shape{
//    double area;
//
//    public double getArea() {
//        return area;
//    }
//}
//
//class Circle extends Shape{
//    double r;
//
//    public Circle(double r){
//        this.r=r;
//    }
//
//    public double getR() {
//        return r;
//    }
//    public void setR(double r) {
//        this.r = r;
//    }
//
//    @Override
//    public double getArea() {
//        return Math.PI*r*r;
//    }
//}
//
//class Square extends Shape{
//    double width;
//    double length;
//
//    public Square
//}

//class MyThread extends Thread{
//    @Override
//    public void run() {
//        for(int i=0;i<10;i++){
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//
//
//public class Main {
//    public static void main(String[] args) {
//        MyThread mt=new MyThread();
//
//        mt.start();
//    }


//    public static void main(String[] args) {
//        List<Integer> list=new LinkedList<>();
//
//        for(int i=0;i<100;i++){
//            list.add(i);
//        }
//
//        for(int j=list.size()-1;j>=0;j--){
//            if(list.get(j)%2==0){
//                list.remove(list.get(j));
//            }
//        }
//
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
//    }





//    public static void main(String[] args) {
//        int[] height={2,0,2};
//        System.out.println(new Main().trap(height));
//
////        ArrayList<Integer> arr=new ArrayList<>(5);
////        arr.add(3);
//    }
//
//    public Node door(Node head){
//        if(head==null) return null;
//
//        Node p=head,preP=head,res=null;
//        HashSet<Node> dic=new HashSet<>();
//        dic.add(p);
//        while (p.next!=null){
//            p=p.next;
//            if(dic.contains(p)) {
//                res=p;
//                break;
//            }
//        }
//        return res;
//    }
//
//
//
//


//    public int trap(int[] height) {
//        int len=height.length;
//        int left=0,right=len-1;
//        int leftMax=0,rightMax=len-1;
//        int vol=0;
//        while(left<=len-1){
//            left++;
//            while(left<=len-1 && height[left]<height[leftMax]) left++;
//            if(left>len-1) break;
//            int i=leftMax+1;
//            while(i<left){
//                vol+=height[leftMax]-height[i];
//                i++;
//            }
//            leftMax=left;
//        }
//        while(right>=leftMax){
//            right--;
//            while(right>=leftMax && height[right]<height[rightMax]) right--;
//            if(right<leftMax) break;
//            int j=rightMax-1;
//            while(j>right){
//                vol+=height[rightMax]-height[j];
//                j--;
//            }
//            rightMax=right;
//        }
//        return vol;
//    }








//    private static List<Object> list = new ArrayList<>();
//    public static void main(String[] args) {
//        testSoftReference();
//    }

//    private static void testSoftReference() {
//        byte[] buff = null;
//
//        for (int i = 0; i < 10; i++) {
//            buff = new byte[1024 * 1024*2];
//            SoftReference<byte[]> sr = new SoftReference<>(buff);
//            list.add(sr);
//        }
//
//        System.gc(); //主动通知垃圾回收
//
//        for(int i=0; i < list.size(); i++){
//            Object obj = ((SoftReference) list.get(i)).get();
//            System.out.println(obj);
//        }
//
//        System.out.println("buff: " + buff.toString());
//    }



//    private static void testSoftReference() {
//        for (int i = 0; i < 10; i++) {
//            byte[] buff = new byte[1024 * 1024*2];
//            SoftReference<byte[]> sr = new SoftReference<>(buff);
//            list.add(sr);
//        }
//
//        System.gc(); //主动通知垃圾回收
//
//        for(int i=0; i < list.size(); i++){
//            Object obj = ((SoftReference) list.get(i)).get();
//            System.out.println(obj);
//        }
//
//    }









//
//    public static void main(String[] args) {
//        testStrongReference();
//    }
//    private static void testStrongReference() {
//        // 当 new byte为 1M 时，程序运行正常
//        byte[] buff = new byte[1024 * 1024 * 2];
//
//    }





//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        while (in.hasNext()){
//            int a=in.nextInt();
//            int b=in.nextInt();
//            int k=in.nextInt();
//            int v=in.nextInt();
//            int volumn=0;
//            int leastBoxes=0;
//            PriorityQueue<Integer> boxes=new PriorityQueue<>();
//            for(int i=0;i<b;i++){
//                boxes.add(1);
//                volumn+=2*v;
//            }
//            if(volumn<a){
//                leastBoxes=(int)Math.ceil((a-volumn)/v)+b;
//            }
//            else{
//                int i=0;
//                while (volumn>a && boxes.size()>1){
//                    int box1=boxes.remove();
//                    int box2=boxes.remove();
//                    if(box1+box1<=k-1){
//                        volumn=volumn-v;
//                        boxes.add(box1+box2);
//                    }
//                    else {
//                        boxes.add(box1);
//                        boxes.add(box2);
//                        break;
//                    }
//                }
//                leastBoxes=boxes.size();
//            }
//            System.out.println(leastBoxes);
//        }
//    }




















//    public static void main(String[] args) {
//        String[] s1={"1101","1010","1111","1110"};
//        String[] s2={"ABCD","EFGH","IJKL","MNPQ"};
//
//        System.out.println(new Main().rotatePassword(s1,s2));
//    }
//
//
//
//
//
//
//
//
//    public String rotatePassword (String[] s1, String[] s2) {
//        int N=s1.length;
//        StringBuilder res=new StringBuilder();
//
//        for(int k=0;k<=3;k++){
//            if(k!=0) s1=rotateS1(s1);
//            for(int i=0;i<N;i++){
//                for(int j=0;j<N;j++){
//                    if(s1[i].charAt(j)=='0'){
//                        res.append(s2[i].charAt(j));
//                    }
//                }
//            }
//        }
//
//        return res.toString();
//    }
//
//    public String[] rotateS1(String[] s1){
//        String[] res=new String[s1.length];
//        for(int i=0;i<s1[0].length();i++){
//            StringBuilder row=new StringBuilder();
//            for(int j=0;j<s1.length;j++){
//                row.append(s1[j].charAt(i));
//            }
//            res[i]=row.reverse().toString();
//        }
//        return res;
//    }




















//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        pos[] X=new pos[4];
//        for(int i=0;i<4;i++){
//            X[i]=new pos(in.nextInt(),in.nextInt());
//        }
//        System.out.println(isTuSiBiXin(X));
//    }
//
//    public static boolean isTuSiBiXin(pos[] X){
//
//    }


















//    //华为面试题：寻找1到100000000之间的素数
//    //方法二 采用一个boolean数组的筛选法求
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        int n=in.nextInt();
//        ArrayList<Integer> suShu=new ArrayList<>();
//        boolean[] flag=new boolean[n+1];
//        for(int i=2;i<n+1;i++) flag[i]=true;
//        for(int i=2;i<=n;i++){  //当然，这里只需要求筛选到i<=Math.sqrt(n)即可，此时的flag数组中为true的元素对应的下标即素数，然后重新搜索一遍flag数组
//            if(flag[i]==true){
//                suShu.add(i);
//                for(int j=i+i;j<=n;j+=i){
//                    flag[j]=false;
//                }
//            }
//        }
//
//        for(int i=1;i<suShu.size();i++){
//            if(suShu.get(i)-suShu.get(i-1)==2){
//                System.out.println(suShu.get(i-1)+" "+suShu.get(i));
//            }
//        }
//    }
//


    //华为面试题：寻找1到100000000之间的素数
    //方法一 根据素数定义常规判断
//    static ArrayList<Integer> suShu=new ArrayList<>();
//
//    public static void main(String[] args){
//        Scanner in=new Scanner(System.in);
//
//        int n=in.nextInt();
//
//        for(int i=2;i<=n;i++){
//            if(isSuShu(i)){
//                suShu.add(i);
//            }
//        }
//        for(int i=1;i<suShu.size();i++){
//            if(suShu.get(i)-suShu.get(i-1)==2){
//                System.out.println(suShu.get(i-1)+" "+suShu.get(i));
//            }
//        }
//    }
//
//
//
//    public static boolean isSuShu(int n){
//        if(n<=1) return false;
//        for(int i=0;i<suShu.size() && suShu.get(i)<n;i++){
//            if(n%suShu.get(i)==0) return false;
//        }
//        return true;
//    }















    //55题 14分钟
//    boolean res=true;
//    public boolean isBalanced(TreeNode root){
//        if(root==null) return true;
//
//        height(root);
//        return res;
//    }
//
//    public int height(TreeNode root){
//        if(root==null) return 0;
//
//        int lHeight=height(root.left);
//        int rHeight=height(root.right);
//        if(Math.abs(lHeight-rHeight)>1){
//            res=false;
//        }
//        return lHeight>rHeight ? lHeight+1 : rHeight+1;
//    }















    //32题 23分钟
//    public List<List<Integer>> levelOrder(TreeNode root){
//        if(root==null) return new LinkedList<>();
//        List<List<Integer>> res=new LinkedList<>();
//        LinkedList<Integer> level=new LinkedList<>();
//        LinkedList<TreeNode> queue=new LinkedList<>();
//
//        queue.offer(root);
//        int len=0,h=0;
//        while(!queue.isEmpty()){
//            h++;
//            len=queue.size();
//            level=new LinkedList<>();
//            for(int i=0;i<len;i++){
//                TreeNode t=queue.poll();
//                if(h%2==1) level.addLast(t.val);
//                else level.addFirst(t.val);
//                if(t.left!=null) queue.add(t.left);
//                if(t.right!=null) queue.add(t.right);
//            }
//            res.add(level);
//        }
//        return res;
//    }









    //26题 17分钟
//    public boolean isSubstructure(TreeNode A,TreeNode B){
//        if(A==null || B==null) return false;
//        if(isEqual(A,B)) {
//            return true;
//        }
//        if(isSubstructure(A.left,B)){
//            return true;
//        }
//        if(isSubstructure(A.right,B)){
//            return true;
//        }
//        return false;
//    }
//
//    public boolean isEqual(TreeNode A,TreeNode B){
//        if(B==null) return true;
//        if(A==null) return false;
//
//        if(A.val!=B.val) return false;
//        if(isEqual(A.left,B.left) && isEqual(A.right,B.right)) return true;
//        else return false;
//    }













    //26题 20分钟
//    HashMap<Integer,Integer> dic=new HashMap<>();
//
//    public TreeNode buildTree(int[] preorder,int[] inorder){
//        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0) return null;
//        for(int i=0;i<inorder.length;i++){
//            dic.put(inorder[i],i);
//        }
//
//        buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
//    }
//
//    public TreeNode buildTree(int[] preorder,int[] inorder,int pLeft,int pRight,int iLeft,int iRight){
//        if(pLeft>pRight) return null;
//
//        TreeNode root=new TreeNode(preorder[pLeft]);
//        int rootPos=dic.get(preorder[pLeft]);
//        root.left=buildTree(preorder,inorder,pLeft+1,pLeft+rootPos-iLeft,iLeft,rootPos-1);
//        root.right=buildTree(preorder,inorder,pLeft+rootPos-iLeft+1,pRight,rootPos+1,iRight);
//    }












    //34题 9分钟
//    LinkedList<Integer> path=new LinkedList<>();
//    List<List<Integer>> paths=new LinkedList<>();
//
//    public static void main(String[] args) {
//
//    }
//
//    public List<List<Integer>> pathSum(TreeNode root,int sum){
//        if(root==null) return new LinkedList<>();
//
//        traverse(root,sum,0);
//        return paths;
//    }
//
//    public void traverse(TreeNode root,int sum,int state){
//        if(root==null) return;
//
//        path.add(root.val);
//        state+=root.val;
//        if(root.left==null && root.right==null && state==sum){
//            paths.add(new LinkedList<>(path));  //这里必须创建一个新的path!
//        }
//        if(root.left!=null) traverse(root.left,sum,state);
//        if(root.right!=null) traverse(root.right,sum,state);
//        path.removeLast();
//    }























//    public static void main(String[] args) {
//         Scanner in=new Scanner(System.in);
//
//         String s=in.next();
//         String t=new String(s);
//
//         for(int j=0,i=0;j<t.length();){
//             i++;
//             int k=0;
//             for(;i<s.length();){
//                 if(s.charAt(i)==t.charAt(k)){
//                     k=(k+1)%(j+1);
//                     i++;
//                 }
//                 else {
//                     j=i;
//                     break;
//                 }
//             }
//             if(i==s.length() && k==0){
//                 System.out.println(s.substring(0,j+1));
//                 break;
//             }
//             else if(i==s.length() && k!=0){
//                 System.out.println(t);
//                 break;
//             }
//         }
//    }





























//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        int n=in.nextInt();
//        int y=in.nextInt();
//        TreeMap<Integer,Integer> dic=new TreeMap<>();
//        for(int i=0;i<n;i++){
//            int X=in.nextInt();
//            int HP=in.nextInt();
//            dic.put(X,HP);
//        }
//        ArrayList<Integer> arr=new ArrayList<>();
//        for(Integer e : dic.keySet()){
//        }
//
//    }




//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
//        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((x,y)->y-x);
//
//        for(int i=0;i<4;i++){
//            int tmp=in.nextInt();
//            minHeap.add(tmp);
//            maxHeap.add(tmp);
//        }
//        while (minHeap.peek()<maxHeap.peek()){
//            int max=maxHeap.poll();
//            max-=2;
//            maxHeap.add(max);
//            minHeap.add(max);
//            int min=minHeap.poll();
//            min+=1;
//            minHeap.add(min);
//            maxHeap.add(min);
//        }
//        System.out.println(minHeap.peek()*4);
//    }

















//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int m=in.nextInt();
//        int x=in.nextInt();
//
//        PriorityQueue<Integer> heap=new PriorityQueue<>();
//        for(int i=0;i<n;i++){
//            heap.add(in.nextInt());
//        }
//        for(int j=0;j<m;j++){
//            int min=heap.poll();
//            heap.add(min+x);
//        }
//        System.out.println(heap.peek());
//    }














//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        String[] input=in.nextLine().split(", ");
//        int[] nums=new int[input.length];
//        for(int i=0;i<input.length;i++){
//            nums[i]=Integer.parseInt(input[i]);
//        }
//        Arrays.sort(nums);
//        int n=nums.length;
//        if(n%2==0){
//            System.out.println((nums[n/2]+nums[n/2-1])/2);
//        }
//        else System.out.println(nums[n/2]);
//    }


























//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        HashMap<String,Integer> dic=new HashMap<>();
//        while (in.hasNext()){
//            String word=in.next();
//            int n=word.length();
//            if(word.charAt(n-1)=='\'') break;
//            if((word.charAt(n-1)<'a' || word.charAt(n-1) > 'z') && (word.charAt(n-1)<'A' || word.charAt(n-1)>'Z')){
//                if((word=word.substring(0,n-1))!=""){
//                    dic.put(word,dic.getOrDefault(word,0)+1);
//                }
//            }
//            else dic.put(word,dic.getOrDefault(word,0)+1);
//        }
//
//        ArrayList<String> wordsSorted=new ArrayList<>();
//        for(String e : dic.keySet()){
//            wordsSorted.add(e);
//        }
//        wordsSorted.sort((x,y)->dic.get(y)-dic.get(x));
//        System.out.println(wordsSorted.get(1));
//    }






























//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int T=in.nextInt();
//        for(int i=0;i<T;i++){
//            String s1=in.next();
//            String s2=in.next();
//            String s3=in.next();
//            int K=in.nextInt();
//            System.out.println(isExist(s1,s2,s3,K));
//        }
//
//    }
//
//    public static int isExist(String s1,String s2,String s3,int K){
//        int n=0;
//        for(int i=0,j=0,k=0;k<s3.length();){
//            int suffix1=commonSuffix(s1,s3,i,k);
//            int suffix2=commonSuffix(s2,s3,j,k);
//            if(suffix1==0 && suffix2==0) {
//                return 0;
//            }
//            else if(suffix1>suffix2){
//                i+=suffix1;
//                k+=suffix1;
//                n++;
//            }
//            else {
//                j+=suffix2;
//                k+=suffix2;
//                n++;
//            }
//        }
//        return n<=K ? 1 : 0;
//    }
//
//    public static int commonSuffix(String A,String B,int i,int k){
//        if(i>=A.length() || k>=B.length()) return 0;
//        int len=0;
//        for(;i<A.length() && k<B.length();){
//            if(A.charAt(i)==B.charAt(k)){
//                i++;
//                k++;
//                len++;
//            }
//            else break;
//        }
//        return len;
//    }
//
//

/*
3
ac bb abbc 3
acb bb abcbb 4
acb bb abc 2

* */












//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        int N=in.nextInt();
//        int M=in.nextInt();
//        int[] cards=new int[N];
//        for(int i=0;i<N;i++){
//            cards[i]=in.nextInt();
//        }
//
//        for(int j=0;j<M;j++){
//            cards=xiPai(cards);
//        }
//
//        for(int i=0;i<N;i++){
//            System.out.print(cards[i]+" ");
//        }
//    }
//
//    public static int[] xiPai(int[] cards){
//        int N=cards.length;
//        int[] res=new int[N];
//
//        for(int i=0,j=N/2,k=0;k<N;k++){
//            if(k%2==0){
//                res[k]=cards[j++];
//            }
//            else {
//                res[k]=cards[i++];
//            }
//        }
//        return res;
//    }
//



















//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        String s=in.next();
//        int count=0;
//        for(int i=0;i<s.length()-1;i++){
//            for(int j=i+1;j<s.length();j++){
//                if(isHuiWen(s,i,j)){
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }
//
//    public static boolean isHuiWen(String s,int i,int j){
//        while (i<j){
//            if(s.charAt(i)!=s.charAt(j)) return false;
//            i++;
//            j--;
//        }
//        return true;
//    }



































//    static long sum=0;
//    static long count=0;
//    static int[][] visited;
//    static int[][] visited2;
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        int n=in.nextInt();
//        int m=in.nextInt();
//        int[][] matrix=new int[n][m];
//        int[][] changedMatrix=new int[n][m];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                matrix[i][j]=in.nextInt();
//                changedMatrix[i][j]=matrix[i][j];
//            }
//        }
//        visited=new int[n][m];
//        visited2=new int[n][m];
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(matrix[i][j]==-1 && visited[i][j]==0) {
//                    dfs(matrix, i, j);
//                    int right=(int)(sum/count);
//                    dfsChange(changedMatrix,i,j,right);
//                    sum=0;
//                    count=0;
//                }
//            }
//        }
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(changedMatrix[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void dfs(int[][] matrix,int i,int j){
//        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length) return;
//        if(visited[i][j]==1 || matrix[i][j]!=-1) return;
//
//        visited[i][j]=1;
//        surround(matrix,i,j);
//        dfs(matrix,i,j-1);
//        dfs(matrix,i+1,j);
//        dfs(matrix,i,j+1);
//        dfs(matrix,i-1,j);
//    }
//
//    public static long surround(int[][] matrix,int i,int j){
//        if(i>=0 && i<matrix.length && j-1>=0 && j-1<matrix[0].length && matrix[i][j-1]!=-1) {sum+=matrix[i][j-1]; count++;}
//        if(i+1>=0 && i+1<matrix.length && j>=0 && j<matrix[0].length && matrix[i+1][j]!=-1) {sum+=matrix[i+1][j]; count++;}
//        if(i>=0 && i<matrix.length && j+1>=0 && j+1<matrix[0].length && matrix[i][j+1]!=-1) {sum+=matrix[i][j+1]; count++;}
//        if(i-1>=0 && i-1<matrix.length && j>=0 && j<matrix[0].length && matrix[i-1][j]!=-1) {sum+=matrix[i-1][j]; count++;}
//        return sum;
//    }
//
//    public static void dfsChange(int[][] changedMatrix,int i,int j,int right){
//        if(i<0 || i>=changedMatrix.length || j<0 || j>=changedMatrix[0].length || visited2[i][j]==1) return;
//        if(changedMatrix[i][j]!=-1) return;
//
//        changedMatrix[i][j]=right;
//        visited2[i][j]=1;
//        dfsChange(changedMatrix,i,j-1,right);
//        dfsChange(changedMatrix,i+1,j,right);
//        dfsChange(changedMatrix,i,j+1,right);
//        dfsChange(changedMatrix,i-1,j,right);
//    }
//
//    /*
//3 4
//0 8 8 0
//0 8 0 -1
//0 -1 -1 0
//
//    * */
//
//










//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        int n=in.nextInt();
//        int m=in.nextInt();
//        String s=in.next();
//        String[] words=new String[m];
//        for(int i=0;i<m;i++){
//            words[i]=in.next();
//        }
//
//        int count=0;
//        for(int i=0;i<m;i++){
//            if(words[i].length()>s.length()) continue;
//            int j=0,k=0;
//            for(;j<n;j++){
//                if(k<words[i].length() && s.charAt(j)==words[i].charAt(k)){
//                    k++;
//                }
//                else if(k==words[i].length()){
//                    count++;
//                    k=0;
//                }
//                else {
//                    k=0;
//                }
//            }
//            if(k==words[i].length()) count++;
//        }
//        System.out.println(count);
//    }



















//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        int n=in.nextInt();
//        int[] f=new int[n+1];
//        if(n==0) System.out.println(0);
//        if(n==1) System.out.println(1);
//        if(n==2) System.out.println(2);
//        f[0]=0;
//        f[1]=1;
//        f[2]=2;
//        for(int i=3;i<=n;i++){
//            f[i]=f[i-1]+f[i-2];
//        }
//        System.out.println(f[n]);
//    }
//
//
//
//}


/*华为9.9笔试第三题：求树的最大异或路径。其中路径可以从任意一节点开始。*/
//    static LinkedList<node> path=new LinkedList<>();
//    static int maxGrade=0;
//    static int curGrade=0;
//
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        int N=in.nextInt();
//        node[] nodeArr=new node[N+1];  //节点序号从1开始
//        for(int i=0;i<=N;i++){
//            nodeArr[i]=new node();
//        }
//        for(int i=1;i<=N;i++){
//            int id=in.nextInt();
//            nodeArr[id].weight=in.nextInt();
//            int l=in.nextInt();
//            int r=in.nextInt();
//            nodeArr[id].left= l!=-1 ? nodeArr[l] : null;
//            nodeArr[id].right= r!=-1 ? nodeArr[r] : null;
//        }
//
//        for(int i=1;i<N+1;i++){
//            curGrade=0;
//            path=new LinkedList<>();
//            traverse(nodeArr[i]);
//        }
//        System.out.println(maxGrade);
//    }
//
//    public static void traverse(node root){
//        if(root==null) return;
//        path.add(root);
//        curGrade^=root.weight;
//        if(maxGrade<curGrade) maxGrade=curGrade;
//
//        traverse(root.left);
//        traverse(root.right);
//        curGrade^=path.getLast().weight;
//        path.removeLast();
//    }
//
//}
//
//class node{
//    int weight;
//    node left;
//    node right;
//}


/*华为9.9笔试第二题：求矩阵matrix中，从某个点i,j出开始的水流的最大长度*/
//    static LinkedList<Integer> path=new LinkedList<>();
//    static int maxLength=0;
//
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int m=in.nextInt();
//        int[][] matrix=new int[n][m];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                matrix[i][j]=in.nextInt();
//            }
//        }
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                maxStream(matrix,i,j);
//            }
//        }
//
//        System.out.println(maxLength);
//    }
//
//    public static void maxStream(int[][] matrix,int i,int j){
//        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length) return;
//        if(path.size()==0 || path.getLast()>matrix[i][j]) {
//            path.add(matrix[i][j]);
//            if(maxLength<path.size()) maxLength=path.size();
//        }
//        else return;
//
//        maxStream(matrix,i,j+1);
//        maxStream(matrix,i+1,j);
//        maxStream(matrix,i,j-1);
//        maxStream(matrix,i-1,j);
//        path.removeLast();  //由于水从高往低流，故不需要设置visited[n][m]数组，标记以访问的位置
//    }

/*华为9.9笔试第一题：求完美序列对perfectLook、perfectValue在序列look、value中首次出现的位置*/
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int K = in.nextInt();
//        int[] perfectLook = new int[K];
//        int[] perfectValue = new int[K];
//        for (int i = 0; i < K; i++) {
//            perfectLook[i] = in.nextInt();
//        }
//        for (int i = 0; i < K; i++) {
//            perfectValue[i] = in.nextInt();
//        }
//        int N = in.nextInt();
//        int[] look = new int[N];
//        int[] value = new int[N];
//        for (int i = 0; i < N; i++) {
//            look[i] = in.nextInt();
//        }
//        for (int i = 0; i < N; i++) {
//            value[i] = in.nextInt();
//        }
//
//        for (int i = 0; i <= N - K; i++) {
//            int j = 0;
//            int k = i;
//            for (; j < K && k < N; j++, k++) {
//                if (look[k] != perfectLook[j] || value[k] != perfectValue[j]) {
//                    break;
//                }
//            }
//            if (j == K) {
//                System.out.println(i + 1);  //输出完美序列perfectLook在look中的位置（从1开始）
//                break;
//            }
//        }
//
//    }
//}




//    /*腾讯9.6笔试第4小题，求数组中的山谷序列的最大长度。对于数组A中的连续子序列B，当存在i,满足B[0]>B[1]>
//    B[2]>...>B[i]<B[i-1]<B[i]<...<B[B.length-1]时，则称B为A的山谷序列。
//    方法一 思路是采用动态规划，状态用两个数组来表示，down[i]表示以nums[i]结尾的连续下降子数组的最大长度，up[i]
//    表示以i开头的连续上升的子数组的最大长度。然后总的山谷序列的最大长度就为down[i]+up[i]-1的最大值。状态转移方程为
//    down[i]= nums[i-1]>nums[i] ? down[i-1]+1 : 1; up[i]= nums[i]<nums[i+1] ? nums[i+1]+1 : 1;
//    */
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        int N=in.nextInt();
//        int[] nums=new int[N];
//        for(int i=0;i<N;i++){
//            nums[i]=in.nextInt();
//        }
//
//        int[] down=new int[N];
//        int[] up=new int[N];
//        int longestMountain=0;
//
//        down[0]=1;
//        up[N-1]=1;
//        for(int i=1;i<N;i++){
//            if(nums[i-1]>nums[i]){
//                down[i]=down[i-1]+1;
//            }
//            else{
//                down[i]=1;
//            }
//        }
//        for(int j=N-2;j>=0;j--){
//            if(nums[j]<nums[j+1]){
//                up[j]=up[j+1]+1;
//            }
//            else{
//                up[j]=1;
//            }
//        }
//        for(int i=0;i<N;i++){
//            int tmp=down[i]+up[i]-1;
//            if(longestMountain<tmp){
//                longestMountain=tmp;
//            }
//        }
//        System.out.println(longestMountain);
//    }

    /*
10
6 5 4 3 1 4 5 5 3 1
    * */

//    /*腾讯9.6笔试第二题 会议通知，计算n个人，m个小组里面，下标为0的人收到消息后，知道这条消息的总人数*/
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        while (in.hasNext()){
//            int n=in.nextInt();
//            int m=in.nextInt();
//            int[] s=new int[n];
//            for(int i=0;i<n;i++) s[i]=-1;
//            for(int i=0;i<m;i++){
//                int len=in.nextInt();
//                int first=in.nextInt();
//                for(int j=1;j<len;j++){
//                    int second=in.nextInt();
//                    union(s,first,second);
//                }
//            }
//            System.out.println(-s[find(s,0)]);
//        }
//    }
//
//    public static void union(int[] s,int a,int b){
//        int x=find(s,a);
//        int y=find(s,b);
//        if(s[x]<=s[y]){
//            s[x]+=s[y];
//            s[y]=x;
//        }
//        else{
//            s[y]+=s[x];
//            s[x]=y;
//        }
//    }
//
//    public static int find(int[] s,int x){
//        if(s[x]<0) return x;
//        else return s[x]=find(s,s[x]);
//    }
//




    /*方法一 将问题转化为求图的连通分量的问题，先求出图的邻接矩阵或邻接表，然后用深度优先遍历来求解
    采用邻接表的时间复杂度为O(|v|+|E|)，比较适合稀疏图。而使用邻接矩阵的时间复杂度为O(|v|^2)。本题最好用邻接表*/
//    static int[] visited;  //访问数组设置为静态变量，以便main函数使用
//    static int count=0;  //由于需要在各个递归子程序间被使用，故设置为静态变量
//
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        while (in.hasNext()){
//            int n=in.nextInt();
//            int m=in.nextInt();
//            HashSet<Integer>[] AdjList=new HashSet[n];  //邻接表用HashSet数组表示
//            for(int i=0;i<n;i++){
//                AdjList[i]=new HashSet<>();
//            }
//            for(int i=0;i<m;i++){
//                int len=in.nextInt();
//                int v=in.nextInt();
//                for(int j=1;j<len;j++){
//                    int w=in.nextInt();
//                    AdjList[v].add(w);
//                    AdjList[w].add(v);
//                }
//            }
//
//            visited=new int[n];
//            count=0;
//            new Main().dfs(AdjList,0);
//            System.out.println(count);
//        }
//
//    }
//
//    public void dfs(HashSet<Integer>[] AdjList,int v){
//        if(visited[v]==1) return;
//
//        visited[v]=1;
//        count++;
//        if(AdjList[v].size()==0) return;  //如果没有边相连
//        for(Integer w : AdjList[v]){
//            dfs(AdjList,w);
//        }
//    }



      //采用邻接矩阵表示的图的遍历
//    static int[] visited;  //访问数组设置为静态变量，以便main函数使用
//    static int count=0;  //由于需要在各个递归子程序间被使用，故设置为静态变量
//
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        while (in.hasNext()){
//            int n=in.nextInt();
//            int m=in.nextInt();
//            int[][] matrix=new int[n][n];
//            for(int i=0;i<m;i++){
//                int len=in.nextInt();
//                int v=in.nextInt();
//                for(int j=1;j<len;j++){
//                    int w=in.nextInt();
//                    matrix[v][w]=1;
//                    matrix[w][v]=1;
//                }
//            }
//
//            visited=new int[n];
//            count=0;
//            new Main().dfs(matrix,0);
//            System.out.println(count);
//        }
//
//    }
//
//    public void dfs(int[][] matrix,int v){
//        if(visited[v]==1) return;
//
//        visited[v]=1;
//        count++;
//        for(int w=0;w<matrix.length;w++){
//            if(matrix[v][w]==1){
//                dfs(matrix,w);
//            }
//        }
//    }
    /*
    测试用例：

100 4
2 1 2
5 10 13 11 12 14
2 0 1
2 99 2
200 2
1 5
5 1 2 3 4 5
1 0

*/

















//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        String word=in.next();
//        int m=in.nextInt();
//        int n=in.nextInt();
//
//        char[][] matrix=new char[m][n];
//        for(int i=0;i<m;i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = in.next().charAt(0);
//            }
//        }
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(matrix[i][j]==word.charAt(0) && new Main().find(matrix,word,i,j,0,new int[m][n])){
//                    System.out.println(true);
//                    return;
//                }
//            }
//        }
//
//        System.out.println(false);
//    }
//
//    boolean find(char[][] matrix,String word,int i,int j,int k,int[][] visited){
//        if(k==word.length()) return true;
//        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length) return false;
//        if(matrix[i][j]!=word.charAt(k) || visited[i][j]==1) return false;
//
//        visited[i][j]=1;
//        k++;
//        return find(matrix,word,i,j+1,k,visited) || find(matrix,word,i+1,j,k,visited) || find(matrix,word,i,j-1,k,visited) || find(matrix,word,i-1,j,k,visited);
//    }
//



/*
A B C S D
E F G E H
X Y X E H
A C D S E
*
*
*
*
*
* */




//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        while (in.hasNext()){
//            String s=in.next();
//            if(s.length()<8 || s.length()>120) {
//                System.out.println(1);
//                continue;
//            }
//
//            int[] count=new int[4];
//            int i=0;
//            for(i=0;i<s.length();i++){
//                if(s.charAt(i)>='0' && s.charAt(i)<='9') count[0]++;
//                else if(s.charAt(i)>='A' && s.charAt(i)<='Z') count[2]++;
//                else if(s.charAt(i)>='a' && s.charAt(i)<='z') count[3]++;
//                else count[1]++;
//            }
//            for(i=0;i<4;i++){
//                if(count[i]==0) {
//                    System.out.println(2);
//                    break;
//                }
//            }
//            if(i==4) System.out.println(0);
//        }
//    }


//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int m=in.nextInt();
//        System.out.println(8);
//    }
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//
//        int T=in.nextInt();
//        for(int i=0;i<T;i++){
//            int n=in.nextInt();
//            if(n==1 || n==2) System.out.println(n);
//            else if(n==3 || n==4) System.out.println(n-1);
//            else System.out.println(n-1);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int a[]=new int[n];
//        int sum=0;
//        for(int i=0;i<n;i++){
//            a[i]=in.nextInt();
//            sum+=a[i];
//        }
//        int m=in.nextInt();
//        if(sum<=m) {
//            System.out.println(sum);
//            return;
//        }
//
//        Arrays.sort(a);
//
//        if(sum-a[n-1]<m && sum>m) {
//            System.out.println(sum);
//        }
//        else if(sum-a[n-2]-a[n-1]<m && sum-a[n-1]>=m){
//            System.out.println(m-1+a[n-1]);
//        }
//    }





//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int N=in.nextInt();
//        int K=in.nextInt();
//        String s=in.nextLine();
//
//        Map<String,Integer> dic=new HashMap<>();
//        ArrayList<String> arr=new ArrayList<>();
//        for(int i=0;i<N;i++){
//            s=in.nextLine();
//            if(dic.containsKey(s)) dic.put(s,dic.get(s)+1);
//            else dic.put(s,1);
//        }
//
//        for(String e : dic.keySet()){
//            arr.add(e);
//        }
//
//        arr.sort((x,y)->{
//            if(dic.get(x)>dic.get(y)) return -1;
//            else if(dic.get(x)<dic.get(y)) return 1;
//            else {
//                return x.compareTo(y);
//            }
//        });
//        for(int i=0;i<K;i++){
//            System.out.println(arr.get(i)+" "+dic.get(arr.get(i)));
//        }
//
//        arr.sort((x,y)->{
//            if(dic.get(x)>dic.get(y)) return -1;
//            else if(dic.get(x)<dic.get(y)) return 1;
//            else {
//                return -(x.compareTo(y));
//            }
//        });
//        int len=arr.size();
//        for(int i=0;i<K;i++){
//            System.out.println(arr.get(len-i-1)+" "+dic.get(arr.get(len-i-1)));
//        }
//
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n=in.nextInt();
//        int[] a=new int[n];
//        for(int i=0;i<n;i++){
//            a[i]=in.nextInt();
//        }
//        int m=in.nextInt();
//        int[] b=new int[m];
//        for(int j=0;j<m;j++){
//            b[j]=in.nextInt();
//        }
//
//        for(int i=0,j=0;i<n && j<m;){
//            if(a[i]==b[j]){
//                System.out.print(a[i]+" ");
//                i++;
//                j++;
//            }
//            else if(a[i]<b[j]){
//                j++;
//            }
//            else i++;
//        }
//
//    }



















//}




