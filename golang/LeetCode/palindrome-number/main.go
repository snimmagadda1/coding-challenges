package main

import (
	"fmt"
)

func isPalindrome(x int) bool {
	var reverse int = 0
	original := x

	// Negative case not palindrome
	if x < 0 {
		return false
	}

	for x > 0 {
		temp := x % 10
		x = x / 10
		reverse = reverse*10 + temp
	}

	if reverse == original {
		return true
	}

	return false
}

func main() {
	fmt.Println(isPalindrome(123))
	fmt.Println(isPalindrome(12121))
}
