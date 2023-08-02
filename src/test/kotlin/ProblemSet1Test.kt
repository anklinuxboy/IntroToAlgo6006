import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProblemSet1Test {
    @Test
    fun doublyLinkedListTest() {
        val l = listOf(1, 2, 3, 4, 5, 6)
        val dll = DoublyLinkedList()
        dll.build(l)

        assertEquals(1, dll.head?.item)
        assertEquals(6, dll.tail?.item)

        dll.insertFirst(10)
        assertEquals(10, dll.head?.item)
        assertEquals(6, dll.tail?.item)

        dll.insertLast(8)
        assertEquals(10, dll.head?.item)
        assertEquals(8, dll.tail?.item)

        val node = dll.deleteFirst()
        assertEquals(10, node?.item)
        assertEquals(1, dll.head?.item)

        val lastNode = dll.deleteLast()
        assertEquals(8, lastNode?.item)
        assertEquals(6, dll.tail?.item)

        val removeNode1 = dll.head?.next
        val removeNode2 = dll.head?.next?.next
        val removedList = dll.remove(removeNode1!!, removeNode2!!)
        assertEquals(2, removedList.head?.item)
        assertEquals(3, removedList.tail?.item)
        assertEquals(4, dll.head?.next?.item)

        dll.splice(dll.tail?.prev!!, removedList)
        assertEquals(3, dll.tail?.prev?.item)
        assertEquals(2, dll.tail?.prev?.prev?.item)
        assertEquals(6, dll.tail?.item)
    }
}
