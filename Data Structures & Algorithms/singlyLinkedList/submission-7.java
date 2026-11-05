class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        this.next = null;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {
    ListNode head;
    ListNode tail;

    public LinkedList() {
        
    }

    public int get(int index) {
        ListNode temp = head;
        if (index < 0) {
            return -1;
        }

        for (int i = 0; i < index; i++) {
            if (temp == null) {
                return -1;
            }
            temp = temp.next;
        }

        if (temp == null) {
            return -1;
        }

        return temp.val;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);
        if (tail == null) {
            tail = newNode;
            head = tail;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public boolean remove(int index) {
        if (index < 0 || head == null) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = head;
            }
            return true;
        }

        ListNode prev = null;
        ListNode curr = head;

        for (int i = 0; i < index; i++) {
            if (curr == null) {
                return false;
            }

            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return false;
        }

        prev.next = curr.next;
        if (prev.next == null) {
            tail = prev;
        }
        
        return true;
    }

    public ArrayList<Integer> getValues() {
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();

        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        return arr;
    }

    public boolean insertAt(int index, int val) {
        if (index < 0) {
            return false;
        }

        ListNode newNode = new ListNode(val);

        if (index == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                newNode.next = head;
                head = newNode;
            }
            return true;
        }

        ListNode curr = head;
        for (int i = 1; i < index; i++) {
            if (curr == null) {
                return false;
            }
            curr = curr.next;
        }
        if (curr == null) {
            return false;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
        return true;
    }

}
