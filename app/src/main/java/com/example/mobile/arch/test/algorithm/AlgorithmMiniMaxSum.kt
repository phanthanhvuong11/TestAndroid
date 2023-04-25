package com.example.mobile.arch.test.algorithm

class AlgorithmMiniMaxSum {
    /**
     * B1: Enter the elements of list
     * B2: Sum the elements in the list
     * B3: Find the max value in that list
     * B4: Find the min value in that list
     * B5: minimum = sum  - max, maximum = sum - min
     * B6: Println output
     **/

    fun main(args: List<Int>) {
        if (args.isEmpty()) {
            println("List Empty")
        } else {
            val sum = args.sum()
            val minimum = sum - findMax(args)
            val maximum = sum - findMin(args)
            println("Simple output:$minimum $maximum")
        }
    }

    // Can use max() of collection List
    private fun findMax(numbers: List<Int>): Int {
        var max = numbers[0]
        for (i in 1 until numbers.size) {
            if (numbers[i] > max) {
                max = numbers[i]
            }
        }
        return max
    }

    //Can use min() of collection List
    private fun findMin(numbers: List<Int>): Int {
        var min = numbers[0]
        for (i in 1 until numbers.size) {
            if (numbers[i] < min) {
                min = numbers[i]
            }
        }

        return min
    }
}