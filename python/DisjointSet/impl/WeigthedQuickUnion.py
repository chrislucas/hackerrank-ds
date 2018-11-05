class WQU:

    def __init__(self, n):
        self.data = [int(x) for x in range(0, n)]
        self.weight = [1] * n
        self.components = n

    def find(self, p):
        while p != self.data[p]:
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
        return


wqu = WQU(5)

if __name__ == '__main__':
    pass
