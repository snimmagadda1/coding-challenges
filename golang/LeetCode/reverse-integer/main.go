/*
time complexity : O(log(n))
space complexity: O(1)
*/

package main

import "fmt"

const (
	MinUint uint32 = 0 // binary: all zeroes

	// Perform a bitwise NOT to change every bit from 0 to 1
	MaxUint = ^MinUint // binary: all ones

	// Shift the binary number to the right (i.e. divide by two)
	// to change the high bit to 0
	MaxInt = int(MaxUint >> 1) // binary: all ones except high bit

	// Perform another bitwise NOT to change the high bit to 1 and
	// all other bits to 0
	MinInt = ^MaxInt // binary: all zeroes except high bit
)

func reverse(x int) int {

	reverse := int64(0)
	negative := false

	if x < 0 {
		negative = true
		x = x * -1
	}

	for x > 0 {
		last := int64(x % 10)
		x = x / 10
		temp := int64(0)
		temp = reverse*10 + last
		reverse = temp
	}

	if negative {
		reverse = reverse * -1
	}

	fmt.Println("The max int is %d", MaxInt)
	fmt.Println("The min int is %d", MinInt)

	if reverse > int64(MaxInt) || reverse < int64(MinInt) {
		return 0
	}

	return int(reverse)

}

func main() {

	fmt.Println("Hello")
	fmt.Println(reverse(1534236469))
}
