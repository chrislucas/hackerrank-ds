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
        root_p = self.find(p)
        root_q = self.find(q)
        if root_p == root_q:
            return
        elif self.weight[root_p] < self.weight[root_q]:
            self.data[root_p] = root_q
            self.weight[root_q] += self.weight[root_p]
        else:
            self.data[root_q] = root_p
            self.weight[root_p] += self.weight[root_q]
        self.components -= 1


class Edge:
    def __init__(self, src, dst):
        self.src, self.dst = src, dst


class Graph:
    # lista de arestas do grafo
    def __init__(self, v, e):
        self.edges = [[] * v for i in range(0, e)]
        self.v, self.e = v, e

    def add_edge(self, s, d):
        self.edges[s].append(Edge(s, d))


def detect_cycle(g):
    v, e = g.v, g.e
    path_c = PathCompression(v)
    for i in range(0, e):
        for edge in g.edges[i]:
            root_p = path_c.find(edge.src)
            root_q = path_c.find(edge.dst)
            if root_p == root_q:
                return True
            path_c.union(root_p, root_q)
    return False


def run():
    g = Graph(3, 3)
    g.add_edge(0, 1)
    g.add_edge(1, 2)
    g.add_edge(0, 2)
    return detect_cycle(g)


if __name__ == '__main__':
    print(run())
