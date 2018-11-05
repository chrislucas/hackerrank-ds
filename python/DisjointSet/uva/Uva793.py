'''
https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=734
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
    cases = int(input().strip())
    input()
    for i in range(cases):
        s, f = 0, 0
        enters = int(input().strip())
        path_c = PathCompression(enters + 1)
        while True:
            try:
                c, p, q = list(input().strip().split(" "))
            except Exception:
                break
            if c == 'c':
                path_c.union(int(p), int(q))
            else:
                if path_c.connected(int(p), int(q)):
                    s += 1
                else:
                    f += 1
        print("%d,%d" % (s, f))
        if i < cases-1:
            print()
        cases -= 1

if __name__ == '__main__':
    run()
