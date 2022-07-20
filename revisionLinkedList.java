public class revisionLinkedList{
    public static class ListNode{
        int val = 0;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
        ListNode(){
            this.val = null;
        }
    }
    public static ListNode midNode(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode s=head, f=head;
        while(f.next!=null && f.next.next!=null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null, curr=head, frwd = head.next;
        while(curr != null){
            frwd = curr.next;
            curr.next = pre;
            pre = curr;
            curr = frwd;
        }
        return pre;
    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode mid = midNode(head);
        ListNode head2 = mid.next;
        ListNode revHead = reverse(head2);
        boolean res = true;
        ListNode p1=head, p2=revHead;
        while(p2 != null){
            if(p1.val != p2.val){
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;  
        }
        reverse(revHead);
        return res;
    }
    public static void fold(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode mid = midNode(head);
        ListNode head2 = reverse(mid.next);
        mid.next = null;
        ListNode p1 = head, p2 = head2, frwd1, frwd2;
        while(p2 != null){
            frwd1 = p1.next;
            frwd2 = p2.next;
            p1.next = p2;
            p2.next = frwd1;
            p1 = frwd1;
            p2 = frwd2;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p1=l1, p2 = l2, p = head;
        while(p1!=null && p2!=null){
            ListNode node = new ListNode(0);
            p.next = node;
            p = node;
            if(p1.val < p2.val){
                node.val = p1.val;
                p1 = p1.next;
            }else{
                node.val = p2.val;
                p2 = p2.next;
            }
        }
        while(p1!=null){
            ListNode node = new ListNode(p1.val);
            p.next = node;
            p = node;
            p1=p1.next;
        }
         while(p2!=null){
            ListNode node = new ListNode(p2.val);
            p.next = node;
            p = node;
            p2 = p2.next;
        }
        return head.next;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode s = head, f = head;
        while(n-->0){
            f = f.next;
            // if(f == null && n>0)
            //     System.out.println("Invalid n");
        }
        if(f == null){
            ListNode deleteNode = head;
            head = head.next;
            deleteNode.next = null;
            return head;
        }
        while(f.next!=null){
            f = f.next;
            s = s.next;
        }
        //Deletion
        ListNode nodeDelete = s.next;
        s.next = s.next.next;
        nodeDelete.next = null; 

        return head;
    }
    public static void main(String args[]){

    }
}