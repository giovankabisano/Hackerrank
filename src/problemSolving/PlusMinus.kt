package problemSolving

import kotlin.collections.*
import kotlin.io.*

// Complete the problemSolving.plusMinus function below.
fun plusMinus(arr: Array<Int>): Unit {
    var minus = 0.0
    var zero = 0.0
    var positive = 0.0

    arr.forEach {
        when {
            it < 0 -> {
                minus++
            }
            it > 0 -> {
                positive++
            }
            it == 0 -> {
                zero++
            }
        }
    }
    println(positive / arr.size)
    println(minus / arr.size)
    println(zero / arr.size)
}

fun main(args: Array<String>) {
    val arr = arrayOf(-4, 3, -9, 0, 4, 1)
    plusMinus(arr)
}
