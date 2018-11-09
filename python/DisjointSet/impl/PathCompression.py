class PathCompression:
    def __init__(self, n):
        self.data = [int(x) for x in range(0, n)]
        self.weight = [1] * n
        self.components = n

    # path compression
    def find(self, p):
        while p != self.data[p]:
            self.data[p] = self.data[self.data[p]]
            p = self.data[p]
        return p

    def connected(self, p, q):
        return self.find(p) == self.find(q)

    def union(self, p, q):
        rootP = self.find(p)
        rootQ = self.find(q)
        if rootP == rootQ:
            return
        elif self.weight[rootP] < self.weight[rootQ]:
            self.data[rootP] = rootQ
            self.weight[rootQ] += self.weight[rootP]
        else:
            self.data[rootQ] = rootP
            self.weight[rootP] += self.weight[rootQ]
        self.components -= 1


def test_1():
    pathc = PathCompression(9)
    pathc.union(0, 1)
    pathc.union(1, 2)
    pathc.union(2, 3)
    pathc.union(4, 8)
    pathc.union(5, 4)
    pathc.union(5, 6)
    pathc.union(5, 7)
    pathc.union(0, 5)


if __name__ == '__main__':
    test_1()
