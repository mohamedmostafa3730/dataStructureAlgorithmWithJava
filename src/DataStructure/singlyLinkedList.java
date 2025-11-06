
public class singlyLinkedList {
    public static void main(String[] args) {
        LinkedList<String> li = new LinkedList<String>();
        li.insertLast("Ahmed");
        li.insertLast("mostafa");
        li.insertLast("mohamed");
        li.printAll();
        System.out.println("=================");
        li.insertAfter("mostafa", "Ali");
        li.printAll();
        System.out.println("=================");
        li.insertBefore("mostafa", "same");
        li.printAll();
    }

    public static class linkedListNode<TVale> {
        public TVale data;
        public linkedListNode<TVale> next;

        public linkedListNode(TVale data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class linkedListIterator<TVale> {
        private linkedListNode<TVale> currentNode;

        public linkedListIterator() {
            this.currentNode = null;
        }

        public linkedListIterator(linkedListNode<TVale> node) {
            this.currentNode = node;
        }

        public TVale data() {
            return this.currentNode.data;
        }

        public linkedListIterator<TVale> next() {
            this.currentNode = this.currentNode.next;
            return this;
        }

        public linkedListNode<TVale> current() {
            return this.currentNode;
        }

    }

    public static class LinkedList<TVale> {
        public linkedListNode<TVale> head;
        public linkedListNode<TVale> tail;

        public linkedListIterator<TVale> Begin() {
            linkedListIterator<TVale> itr = new linkedListIterator<>(this.head);
            return itr;

        }

        public LinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertLast(TVale data) {
            linkedListNode<TVale> newNode = new linkedListNode<>(data);
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                this.tail = newNode;
            }
        }

        public void insertAfter(linkedListNode<TVale> node, TVale data) {
            linkedListNode<TVale> newNode = new linkedListNode<>(data);
            newNode.next = node.next;
            node.next = newNode;
            if (this.tail == null) {
                this.tail = newNode;
            }
        }

        public void insertAfter(TVale AfterData, TVale data) {

            linkedListNode<TVale> newNode = new linkedListNode<>(data);
            newNode.next = this.find(AfterData).next;
            this.find(AfterData).next = newNode;
            if (this.tail == null) {
                this.tail = newNode;
            }
        }

        public void printAll() {
            for (linkedListIterator<TVale> itr = this.Begin(); itr.currentNode != null; itr.next()) {
                System.out.print(itr.data() + " -> ");
            }
            System.out.println("\n");
        }

        public linkedListNode<TVale> find(TVale data) {
            for (linkedListIterator<TVale> itr = this.Begin(); itr.currentNode != null; itr.next()) {
                if (data == itr.data()) {
                    return itr.currentNode;
                }
            }
            return null;
        }

        public void insertBefore(TVale BeforeData, TVale data) {
            linkedListNode<TVale> newNode = new linkedListNode<>(data);
            newNode.next = this.find(BeforeData);
            linkedListNode<TVale> parent = findParent(this.find(BeforeData));
            if (parent.next == null) {
                this.head = newNode;
            } else {
                parent.next = newNode;
            }
        }

        public void insertBefore(linkedListNode<TVale> node, TVale data) {
            linkedListNode<TVale> newNode = new linkedListNode<>(data);
            newNode.next = node;
            linkedListNode<TVale> parent = findParent(node);
            if (parent.next == null) {
                this.head = newNode;
            } else {
                parent.next = newNode;
            }
        }

        public linkedListNode<TVale> findParent(linkedListNode<TVale> node) {
            for (linkedListIterator<TVale> itr = this.Begin(); itr.current() != null; itr.next()) {
                if (itr.current().next == node) {
                    return itr.current();
                }
            }
            return null;
        }

    }

}
