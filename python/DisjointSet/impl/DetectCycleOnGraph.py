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
        # self.edges[d].append(Edge(d, s))


class Subset:
    def __init__(self, parent, rank):
        self.parent, self.rank = parent, rank


def find(subsets, p):
    while subsets[p].parent != p:
        p = subsets[p].parent
    return subsets[p].parent


def union(subsets, p, q):
    root_p = find(subsets, p)
    root_q = find(subsets, q)
    if root_q == root_p:
        return
    elif subsets[root_p].rank < subsets[root_q].rank:
        subsets[root_p].parent = root_q
        subsets[root_q].rank += subsets[root_p].rank
    else:
        subsets[root_q].parent = root_p
        subsets[root_p].rank += subsets[root_q].rank


def detect_cycle(g):
    v, e = g.v, g.e
    subsets = [None] * v
    for i in range(0, v):
        subsets[i] = Subset(i, 1)
    for i in range(0, e):
        for edge in g.edges[i]:
            root_p = find(subsets, edge.src)
            root_q = find(subsets, edge.dst)
            if root_p == root_q:
                return True
            union(subsets, root_p, root_q)
    return False


def run():
    g = Graph(3, 3)
    g.add_edge(0, 1)
    g.add_edge(1, 2)
    g.add_edge(0, 2)
    return detect_cycle(g)


if __name__ == '__main__':
    print(run())
