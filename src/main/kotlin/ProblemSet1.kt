/*
In Lecture 2, we described a singly linked list. In this problem, you will implement a doubly
linked list, supporting some additional constant-time operations. Each node x of a doubly linked
list maintains an x.prev pointer to the node preceeding it in the sequence, in addition to an
x.next pointer to the node following it in the sequence. A doubly linked list L maintains a pointer
to L.tail, the last node in the sequence, in addition to L.head, the first node in the sequence.
For this problem, doubly linked lists should not maintain their length.
(a) [8 points] Given a doubly linked list as described above, describe algorithms to implement the following sequence
operations, each in O(1) time. insert first(x) insert last(x) delete first() delete last()
(b) [5 points] Given two nodes x1 and x2 from a doubly linked list L, where x1 occurs
before x2, describe a constant-time algorithm to remove all nodes from x1 to x2 inclusive from L, and return them as a
new doubly linked list.
(c) [6 points] Given node x from a doubly linked list L1 and second doubly linked list L2,
describe a constant-time algorithm to splice list L2 into list L1 after node x. After the
splice operation, L1 should contain all items previously in either list, and L2 should
be empty.
(d) [25 points] Implement the operations above in the Doubly Linked List Seq
class in the provided code template; do not modify the Doubly Linked List Node
class. You can download the code template including some test cases from the website.
 */

class DoublyLinkedListNode(
    val item: Int,
    var prev: DoublyLinkedListNode? = null,
    var next: DoublyLinkedListNode? = null,
)

class DoublyLinkedList(var head: DoublyLinkedListNode? = null, var tail: DoublyLinkedListNode? = null) {

    fun build(l: List<Int>) {
        for (n in l) {
            insertLast(n)
        }
    }

    fun insertLast(n: Int) {
        // first node
        if (head == null && tail == null) {
            val node = DoublyLinkedListNode(n)
            head = node
            tail = node
        } else {
            // node exists; add to tail
            val node = DoublyLinkedListNode(n)
            node.prev = tail
            tail?.next = node
            tail = node
        }
    }

    fun insertFirst(n: Int) {
        // first node
        if (head == null && tail == null) {
            val node = DoublyLinkedListNode(n)
            head = node
            tail = node
        } else {
            // node exists; add to front
            val node = DoublyLinkedListNode(n)
            node.next = head
            head?.prev = node
            head = node
        }
    }

    fun deleteFirst(): DoublyLinkedListNode? {
        if (head == null && tail == null) {
            return null // empty list
        } else {
            val tmp = head
            head = head?.next
            head?.prev = null
            tmp?.prev = null
            tmp?.next = null
            return tmp
        }
    }

    fun deleteLast(): DoublyLinkedListNode? {
        if (head == null && tail == null) {
            return null // empty list
        } else {
            val tmp = tail
            tail = tail?.prev
            tail?.next = null
            tmp?.prev = null
            tmp?.next = null
            return tmp
        }
    }

    fun remove(n1: DoublyLinkedListNode, n2: DoublyLinkedListNode): DoublyLinkedList {
        val l2 = DoublyLinkedList()
        val tmp1 = n1.prev
        n1.prev = null
        val tmp2 = n2.next
        n2.next = null
        tmp1?.next = tmp2
        tmp2?.prev = tmp1

        l2.head = n1
        l2.tail = n2
        return l2
    }

    fun splice(n: DoublyLinkedListNode, l: DoublyLinkedList) {
        val tmp = n.next
        n.next = l.head
        l.head?.prev = n

        tmp?.prev = l.tail
        l.tail?.next = tmp
    }
}
