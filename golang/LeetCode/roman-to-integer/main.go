/*
time complexity : O(n)
space complexity: O(n)
*/

package main

import "fmt"

var numerals = [13]string{"I", "V", "X", "L", "C", "D", "M", "IV", "IX", "XL", "XC", "CD", "CM"}
var values = [13]int{1, 5, 10, 50, 100, 500, 1000, 4, 9, 40, 90, 400, 900}
var stepTwos = [6]string{"IV", "IX", "XL", "XC", "CD", "CM"}
var numeralMap = make(map[string]int)

func romanToInt(s string) int {
	var sum int = 0
	stringRunes := []rune(s)

	for i, v := range numerals {
		numeralMap[v] = values[i]
	}

	for i := 0; i < len(stringRunes); i++ {
		// make sure don't go out of boundss
		if i+2 <= len(s) {
			doubleDigit := s[i : i+2]
			// If one of special cases
			if val, ok := numeralMap[doubleDigit]; ok {
				sum += val
				i++
				continue
			}
		}
		sum += numeralMap[string(stringRunes[i])]
	}

	return sum
}

func main() {
	fmt.Println(romanToInt("MCMXCIV"))
}
