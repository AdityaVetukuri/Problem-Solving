
class ListNode1 {
      int val;
    ListNode1 next;
    ListNode1() {}
        ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
 }
public class RemoveZeroSumLinkedList {
    public  static ListNode1 removeZeroSumSublists(ListNode1 head) {
        ListNode1 anchor = head;
        ListNode1 pilot  = head.next;
        ListNode1 prev = new ListNode1(0);
        int possibleZero = -1;

        while(anchor.next!=null)
        {
            possibleZero = anchor.val;
            ListNode1 current = pilot;
            while(current!=null)
            {
                possibleZero = possibleZero + current.val;
                if(possibleZero == 0)
                {


                    prev.next = current;
                    head = current;
                    break;
                }
                current = current.next;
            }
            prev = anchor;

            anchor = anchor.next;
            pilot = anchor.next;
            possibleZero = -1;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
         head.next = new ListNode1(-1);
//         head.next.next = new ListNode1(-3);
//         head.next.next.next = new ListNode1(3);
//         head.next.next.next.next = new ListNode1(4);
         removeZeroSumSublists(head);
    }
}