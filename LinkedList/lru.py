class Node:
    def __init__(self, key, val):
        self.nxt = self.prev = None
        self.val = val
        self.key = key

class LRUCache:
    def __init__(self, capacity: int):
        self.size = capacity
        self.d = {}
        self.head = self.tail = Node(0, 0)
        self.head.nxt, self.tail.prev = self.tail, self.head

    def add(self, node):
        a, b = self.tail.prev, self.tail
        node.nxt = b
        node.prev = a
        a.nxt = b.prev = node

    def remove(self, node):
        p, n = node.prev, node.nxt
        p.nxt = n
        n.prev = p   

    def get(self, key: int) -> int:
        if (key in self.d):
            self.remove(self.d[key])
            self.add(self.d[key])
            return self.d[key].val
        return -1
        

    def put(self, key: int, value: int) -> None:
        if key in self.d:
            self.remove(self.d[key])
        self.d[key] = Node(key, value)

        self.add(self.d[key])

        if (len(self.d) > self.size):
            node = self.head.nxt
            self.remove(node)
            del self.d[node.key]
        
