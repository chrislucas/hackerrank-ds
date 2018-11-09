'''
https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1549
DONE
'''


class WQU:

    def __init__(self, n):
        self.data = [int(x) for x in range(0, n)]
        self.weight = [1] * n
        self.components = n
        self.max_size = 1

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
            if self.weight[rootQ] > self.max_size:
                self.max_size = self.weight[rootQ]
        else:
            self.data[rootQ] = rootP
            self.weight[rootP] += self.weight[rootQ]
            if self.weight[rootP] > self.max_size:
                self.max_size = self.weight[rootP]
        self.components -= 1


def run():
    cases = int(input().strip())
    for i in range(0, cases):
        peoples, pairs = list(map(int, input().strip().split(" ")))
        wqu = WQU(peoples + 1)
        for i in range(0, pairs):
            p, q = list(map(int, input().strip().split(" ")))
            wqu.union(p, q)
        print(wqu.max_size)


if __name__ == '__main__':
    run()
