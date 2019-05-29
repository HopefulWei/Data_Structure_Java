class linkedListSort {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;}
        ListNode fakeHead =new ListNode(0);
        fakeHead.next=head;
        ListNode next = head.next;
        head.next=null;
        head=next;
        while(head!=null){
            next = head.next;
            head.next = null;
            insertion(fakeHead,head);
            head = next;
        }
        return fakeHead.next;
    }
    public void insertion(ListNode Iterat, ListNode now){
        ListNode pre=Iterat;
        ListNode cur=Iterat.next;
        while(cur!=null&&cur.val<now.val){
            pre=cur;
            cur=cur.next;
        }
        if(cur==null){
            pre.next=now;
        }else{
            pre.next=now;
            now.next=cur;
        }
    }
}