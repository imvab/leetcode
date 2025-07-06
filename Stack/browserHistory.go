package stack

type BrowserHistory struct {
	index   int
	history []string
}

func Constructor(homepage string) BrowserHistory {
	history := BrowserHistory{}
	history.history = append(history.history, homepage)
	history.index = 0
	return history
}

func (this *BrowserHistory) Visit(url string) {
	this.history = this.history[:this.index+1]
	this.index++
	this.history = append(this.history, url)
}

func (this *BrowserHistory) Back(steps int) string {
	for range steps {
		if this.index > 0 {
			this.index--
		}
	}
	return this.history[this.index]
}

func (this *BrowserHistory) Forward(steps int) string {
	for range steps {
		if this.index < len(this.history)-1 {
			this.index++
		}
	}
	return this.history[this.index]
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * obj := Constructor(homepage);
 * obj.Visit(url);
 * param_2 := obj.Back(steps);
 * param_3 := obj.Forward(steps);
 */
