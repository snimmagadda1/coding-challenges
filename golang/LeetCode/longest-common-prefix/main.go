/*
time complexity : O(log(n))
space complexity: O(n)
*/

package main

import (
	"fmt"
	"strings"
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

	var sb strings.Builder

	// FIXME: elegant way to do this in go w/out copy
	if len(str1) < len(str2) {
		r2 := []rune(str2)
		for i, r := range str1 {
			if r2[i] == r {
				sb.WriteRune(r)
			} else {
				break
			}
		}
	} else {
		r2 := []rune(str1)
		for i, r := range str2 {
			if r2[i] == r {
				sb.WriteRune(r)
			} else {
				break
			}
		}
	}
	return sb.String()
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
	t2 := []string{"", "flow"}
	fmt.Println("test1 ", longestCommonPrefix(t1))
	fmt.Println("test2 ", longestCommonPrefix(t2))
}
