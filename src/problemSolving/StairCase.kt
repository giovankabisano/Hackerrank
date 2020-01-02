package problemSolving

import kotlin.io.*

/**
 * to avoid loop inside loop, i use recursive function to print space and #
 */
fun staircase(n: Int): Unit {
    for(x in 1..n){
        val space = n - x
        val tag = x
        printSpace(space, 0)
        printTag(tag, 0)
        println("")
    }
}

fun printSpace(loop: Int, visitedTimes: Int){
    if(visitedTimes < loop){
        print(" ")
        val visits = visitedTimes + 1
        printSpace(loop, visits)
    }
}

fun printTag(loop: Int, visitedTimes: Int){
    if(visitedTimes < loop){
        print("#")
        val visits = visitedTimes + 1
        printTag(loop, visits)
    }
}

fun main(args: Array<String>) {
    staircase(6)
}
