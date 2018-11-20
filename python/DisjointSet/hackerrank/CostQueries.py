'''
https://www.hackerrank.com/challenges/maximum-cost-queries/problem?h_r=next-challenge&h_v=zen
'''


class Edge:
    def __init__(self, p, q, w):
        self.p, self.q, self.w = p, q, w

    def __str__(self):
        return "%d, %d, %d" % (self.p, self.q, self.w)


class Graph:

    def __init__(self, e):
        self.edges = [None] * e


if __name__ == '__main__':
    pass
