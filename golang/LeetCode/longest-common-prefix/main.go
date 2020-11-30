/*
time complexity : O(log(n))
space complexity: O(n)
*/

package main

import (
	"fmt"
	"math"
)

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

func longestCommonPrefix(strs []string) string {
	prefixes := make([]string, len(strs))
	if len(strs) == 0 {
		return ""
	}
	prefixes[0] = strs[0]

	// iterate over and compare each to first, saving the shortest
	for i := 1; i < len(strs); i++ {
		match := lcp(strs[i], strs[i-1])
		prefixes[i] = match
	}

	return shortestString(prefixes)
}

func lcp(str1, str2 string) string {

	sb := ""

	length := math.Min(float64(len(str1)), float64(len(str2)))

	for i := 0; i < int(length); i++ {
		if str1[i] == str2[i] {
			sb += string(str1[i])
		} else {
			break
		}
	}
	return sb
}

func shortestString(strs []string) string {
	min := int(MaxInt)
	minInd := 0
	for i, s := range strs {
		if len(s) < min {
			min = len(s)
			minInd = i
		}
	}

	return strs[minInd]
}

func main() {
	t1 := []string{"flower", "flow", "flight"}
	t2 := []string{"cir", "car"}
	fmt.Println("test1 ", longestCommonPrefix(t1))
	fmt.Println("test2 ", longestCommonPrefix(t2))
}
