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


def add_mod(a, b, m):
    return (a % m + b % m) % m


def minus_mod(a, b, m):
    return (a % m - b % m) % m


def multiply_mod(a, b, m):
    return (a % m * b % m) % m

'''
Sacada genial
https://gist.github.com/AhmetCanSolak/59c8df5e7dd8bb22925ccb354280b596
https://math.stackexchange.com/questions/838792/counting-triplets-with-red-edges-in-each-pair?newreg=60eee35f0b3844de852bda39f6dfec8
'''
def solver1(counter, nodes):
    c, result = 1000000007, 0
    # nCr(nodes, 3)
    total_triplets_comb = nodes * (nodes - 1) * (nodes - 2) / 6
    for count in counter:
        comb2, comb_n = 0, 0
        # nCr(count, 3)
        if count > 2:
            comb_n += count * (count - 1) * (count - 2) / 6
        comb2 = count * (count - 1) / 2
        result += comb_n + comb2 * (nodes - count)
    return int(minus_mod(total_triplets_comb, result, c))


def solver2(counter):
    mod = 1000000007
    nodes = len(counter)
    res = 0
    for i in range(0, nodes):
        for j in range(i+1, nodes):
            for k in range(j+1, nodes):
                # (res + ((c[i] * c[j] * c[k]) % mod)) % mod
                res = add_mod(res, multiply_mod(multiply_mod(counter[i], counter[j], mod), counter[k], mod), mod)
    return res


def run():
    nodes = int(input())
    path_c = PathCompression(nodes + 1)
    for i in range(1, nodes):
        u, v, c = list(input().split(" "))
        if c == 'b':
            path_c.union(int(u), int(v))

    counter = []
    for i in range(1, nodes + 1):
        if path_c.data[i] == i:
            counter.append(path_c.weight[i])

    #print(solver1(counter, nodes))
    print(solver2(counter))


if __name__ == '__main__':
    run()
