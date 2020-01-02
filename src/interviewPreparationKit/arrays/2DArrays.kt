package interviewPreparationKit.arrays

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var result = -1000
    /** Row */
    for (x in 0..arr.size - 3) {
        /** Column */
        for (y in 0..arr.size - 3) {
            val sum = arr[x][y] + arr[x][y + 1] + arr[x][y + 2] +
                    arr[x + 1][y + 1] +
                    arr[x + 2][y] + arr[x + 2][y + 1] + arr[x + 2][y + 2]
            if (sum > result){
                result = sum
            }
        }
    }
    return result
}

fun main() {
    val arr = Array(9) {
        arrayOf(it * 1, it * 2, it * 3, it * 4, it * 5, it * 6, it * 7, it * 8, it * 9)
    }
    val result = hourglassSum(arr)
    println(result)
}
