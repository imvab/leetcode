package stack

type Pair struct {
	value int
	min   int
}

func find132pattern(nums []int) bool {
	var stack []Pair
	currMin := nums[0]

	for i := 1; i < len(nums); i++ {
		for len(stack) > 0 && nums[i] >= stack[len(stack)-1].value {
			stack = stack[:len(stack)-1]
		}

		if len(stack) > 0 && nums[i] > stack[len(stack)-1].min {
			return true
		}
		stack = append(stack, Pair{value: nums[i], min: currMin})
		currMin = min(nums[i], currMin)
	}
	return false
}
