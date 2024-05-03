class LinkedList {
    Node head;

    public LinkedList() {
        head = new Node("****"); // Initialize all linked lists with the value **** in the first node to indicate that the linked list has no names (empty linked list)
    }

    public void add(String name) {
        Node newNode = new Node(name);
        newNode.next = head.next;
        head.next = newNode;
    }

    public boolean contains(String name) {
        Node current = head.next;
        while (current != null) {
            if (current.data.equals(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(String name) {
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(name)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        int count = 0;
        Node current = head.next;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public int indexOf(String name) {
        int index = 0;
        Node current = head.next;
        while (current != null) {
            if (current.data.equals(name)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1; // Return -1 if the element is not found
    }

}
