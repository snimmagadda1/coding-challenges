/*
time complexity : O(n)
space complexity: O(n)
*/

package main

import "fmt"

func twoSum(nums []int, target int) []int {

	var toReturn []int

	numberMap := make(map[int]int) // Key = number, value = number

	for idx, val := range nums {
		numberMap[val] = idx
	}

	fmt.Println("the numberMap is: ", numberMap)

	for idx, value := range nums {

		// Compliment
		compliment := target - value

		// If map has theh compliment and compliment is not the same number as value
		if foundValue, ok := numberMap[compliment]; ok && numberMap[compliment] != idx {
			toReturn = append(toReturn, idx, foundValue)
			return toReturn
		}
	}

	return toReturn
}

func main() {
	// testInput := []int{2, 7, 11, 15}
	testInput := []int{3, 2, 4}
	testTarget := 6

	fmt.Println(twoSum(testInput, testTarget))
}
