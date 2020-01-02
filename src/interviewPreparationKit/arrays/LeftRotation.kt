package interviewPreparationKit.arrays

fun main() {
    val d = 13

    val a = arrayOf(1, 2, 3, 4, 5)

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    /**
     * It possible that the rotation (d) is more than the length of our array.
     * ie: array length is 5, but rotation is 12. We can decrease the rotation like this 12 - 5 - 5 = 2
     * So rather than we rotate so many times, we can simplify that by lowering the rotation times.
     *
     * This loop have function to reduce rotation times by subtracting d value with array size
     */
    var rotation = d
    while (rotation > 0 && rotation > a.size - 1) {
        rotation -= a.size
    }

    /**
     * When the rotation is 0, so there is nothing that we need to do.
     * Just return the original array.
     */
    if (rotation == 0){
        return a
    }

    /**
     * Store data as many as rotation value from the first index.
     * ie:
     * array : 1,2,3,4,5
     * rotation : 3
     *
     * We store 1, 2 & 3 to the temp variable
     */
    val temp = mutableListOf<Int>()
    for (x in 0 until rotation) {
        temp.add(a[x])
    }
    /**
     * Access every index of the array a
     */
    for (indexInArrayA in a.indices) {
        /**
         * Rotate arrays to the left EXCEPT the x (rotation) value from the last
         * ie:
         * array : 1,2,3,4,5 (size 5)
         * rotation : 3
         *
         * We only rotate 2 index at the front (5 - 3)
         * Then we will assign 3 index at the back with temporary variable
         */
        if (indexInArrayA < a.size - rotation) {
            a[indexInArrayA] = a[indexInArrayA + rotation]
        }
        /** assign 3 index at the back with temporary variable */
        else {
            a[indexInArrayA] = temp[indexInArrayA - a.size + rotation]
        }
    }

    return a
}