import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProblemSet0Test {

    @Test
    fun consecutiveSubarrayTest() {
        val arrayOne = intArrayOf(1,3,4,2,7,5,6,9,8)
        assertEquals(2, consecutiveSubarray(arrayOne))

        val arrayTwo = intArrayOf(2, 2, 4, 1, 4)
        assertEquals(2, consecutiveSubarray(arrayTwo))

        val arrayThree = intArrayOf(7, 8, 5, 7, 7, 3, 2, 8)
        assertEquals(3, consecutiveSubarray(arrayThree))

        val arrayFour = intArrayOf(7, 7, 9, 1, 2, 11, 9, 6, 2, 8, 9)
        assertEquals(2, consecutiveSubarray(arrayFour))

        val arrayFive = intArrayOf(4, 18, 10, 8, 13, 16, 18, 1, 9, 6, 11, 13, 12, 5, 7, 17, 13, 3)
        assertEquals(1, consecutiveSubarray(arrayFive))

        val arraySix = intArrayOf(11, 16, 10, 19, 20, 18, 3, 19, 2, 1, 8, 17, 7, 13, 1, 11, 1, 18, 19, 9, 7, 19, 24, 2, 12)
        assertEquals(4, consecutiveSubarray(arraySix))
    }
}
