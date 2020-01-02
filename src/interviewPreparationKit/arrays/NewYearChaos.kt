package interviewPreparationKit.arrays

fun minimumBribes(q: Array<Int>): Unit {
    val n: Int = q.size
    var count = 0

    /**
     * We start checking from the end of the array because "bribes" always comes from the back to the front.
     */
    for (i in n - 1 downTo 0) {
        /**
         * Info: The value of the array must be the same with it index.
         * It means the first array must have value 1 (q[0] == 1), etc
         *
         * We check the value of current index, if it doesn't fulfil the requirement, it means that the number is bribes or being bribed.
         */
        if (q[i] != i + 1) {
            /**
             * Check wether the current value of loop bribes 1 number
             * Then we re arrange the number by putting every value to the correct index
             *
             * ie: [2,1,3,4,5]
             * 1. Create temporary value to hold 1
             * 2. Move 1 to [0]
             * 3. Assign [1] with temp
             */
            if (i - 1 >= 0 && q[i - 1] == i + 1) {
                count++
                val temp: Int = q[i]
                q[i] = q[i - 1]
                q[i - 1] = temp
            }
            /**
             * Check wether the current value of loop bribes 2 number
             * Then we re arrange the number by putting every value to the correct index
             *
             * ie: [2,1,5,3,4]
             * 1. Move 3 to [2]
             * 2. Move 4 to [3]
             * 3. Move 5 to [4]
             */
            else if (i - 2 >= 0 && q[i - 2] == i + 1) {
                count += 2
                q[i - 2] = q[i - 1]
                q[i - 1] = q[i]
                q[i] = i + 1
            }
            /**
             * The bribes is more than 2, so it's too chaotic
             */
            else {
                println("Too chaotic")
                return
            }
        }
    }

    println(count)
    return
}

fun main() {
    val q = arrayOf<Int>(2,1, 5, 3, 4)
    minimumBribes(q)
}
