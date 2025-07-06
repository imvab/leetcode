package stack

type StockSpanPair struct {
	key  int
	span int
}

type StockSpanner struct {
	stack []StockSpanPair
}

func NewStockSpanner() StockSpanner {
	return StockSpanner{}
}

func (this *StockSpanner) Next(price int) int {
	if len(this.stack) > 0 {
		span := 1
		for len(this.stack) > 0 && this.stack[len(this.stack)-1].key <= price {
			span = span + this.stack[len(this.stack)-1].span
			this.stack = this.stack[:len(this.stack)-1]
		}
		this.stack = append(this.stack, StockSpanPair{key: price, span: span})
	} else {
		this.stack = append(this.stack, StockSpanPair{key: price, span: 1})
	}

	return this.stack[len(this.stack)-1].span
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Next(price);
 */
