'''
https://www.hackerrank.com/challenges/sparse-arrays/problem
'''

# !/bin/python3

import math
import os
import random
import re
import sys


# Complete the matchingStrings function below.
def matchingStrings(strings, queries):
    return ""


def _open_file():
    return open(os.environ['OUTPUT_PATH'], 'w')


def solver():
    strings_count = int(input())
    strings = []
    for _ in range(strings_count):
        strings_item = input()
        strings.append(strings_item)

    queries_count = int(input())

    queries = []

    for _ in range(queries_count):
        queries_item = input()
        queries.append(queries_item)

    res = matchingStrings(strings, queries)
    return res


def _write_in_file(fptr, res):
    fptr.write('\n'.join(map(str, res)))
    fptr.write('\n')
    fptr.close()
    return


if __name__ == '__main__':
    solver()
