/*
An increasing subarray of an integer array is any consecutive sequence of array integers whose values strictly increase.
Write Python function count long subarrays (A) which accepts Python Tuple A = (a0, a1, . . . , an−1) of n > 0 positive
integers, and returns the number of longest increasing subarrays of A, i.e., the number of increasing subarrays with
length at least as large as every other increasing subarray. For example, if A = (1,3,4,2,7,5,6,9,8),
your program should return 2 since the maximum length of any increasing subarray of A is three
and there are two increasing subarrays with that length: specifically, subarrays (1,3,4) and (5,6,9)
 */
fun consecutiveSubarray(nums: IntArray): Int {
    check(nums.size > 2)
    var i = 1
    val subArrays: MutableList<List<Int>> = mutableListOf()
    var maxSubarrayLen = 0

    while (i < nums.size) {
        if (nums[i] > nums[i - 1]) {
            val subarray = mutableListOf<Int>()
            subarray.add(nums[i - 1])
            while (i < nums.size && nums[i] > nums[i - 1]) {
                subarray.add(nums[i])
                i += 1
            }
            if (subarray.size > maxSubarrayLen) {
                maxSubarrayLen = subarray.size
            }
            subArrays.add(subarray)
        } else {
            i += 1
        }
    }

    var count = 0
    for (arr in subArrays) {
        if (arr.size == maxSubarrayLen) {
            count += 1
        }
    }

    return count
}
