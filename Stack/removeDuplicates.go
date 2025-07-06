package stack

type SPair struct {
	key   string
	count int
}

func removeDuplicates(s string, k int) string {
	var stack []SPair

	for _, c := range s {
		if len(stack) > 0 {
			if stack[len(stack)-1].key == string(c) {
				stack[len(stack)-1].count++

				if stack[len(stack)-1].count == k {
					stack = stack[:len(stack)-1]
				}
			} else {
				stack = append(stack, SPair{key: string(c), count: 1})
			}
		} else {
			stack = append(stack, SPair{key: string(c), count: 1})
		}
	}

	res := ""
	for _, e := range stack {
		for range e.count {
			res = res + e.key
		}
	}
	return res
}
