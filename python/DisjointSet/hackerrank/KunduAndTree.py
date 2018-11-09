'''
https://www.hackerrank.com/challenges/kundu-and-tree/problem
'''


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


def run():
    nodes = int(input())
    path_c = PathCompression(nodes)
    for _ in range(0, nodes):
        u, v, c = list(map(int, input().split(" ")))
        if c == 'b':
            path_c.union(int(u), int(v))


if __name__ == '__main__':
    run()
