import sys

initial_arr = []
goal_arr = [['1', '2', '3'], ['4','5','6'], ['7', '8','0']]

# sys.stdin = open('input.txt', 'r')
input_sys = sys.stdin.readline
print_sys = sys.stdout.write

for i in range(3):
    initial_arr.append(list(input_sys().split()))

def list_to_str(board):
    return ''.join(''.join(row) for row in board)

def str_to_list(state):
    return [list(state[i:i+3]) for i in range(0, 9, 3)]

def find_location(rows, element_to_find):
    for ic, cols in enumerate(rows):
        for ir, element in enumerate(cols):
            if element == element_to_find:
                return ic, ir

goal_str = list_to_str(goal_arr)
goal_positions = {}
for number in '123456780':
    goal_positions[number] = find_location(goal_arr, number)

def swap_state(rows, col_ts, row_ts, col_te, row_te):
    rows[col_ts][row_ts], rows[col_te][row_te] = rows[col_te][row_te], rows[col_ts][row_ts]
    return rows

def heuristic(rows):
    distance = 0

    for number in '123456780':
        col_curr, row_curr = find_location(rows, number)
        col_goal, row_goal = goal_positions[number]
        distance += abs(col_curr - col_goal) + abs(row_curr - row_goal)

    return distance

import heapq

class PriorityQueue:
    def __init__(self):
        self.elements = []
    def empty(self) -> bool:
        return not self.elements
    def put(self, item, priority):
        heapq.heappush(self.elements, (priority, item))
    def get(self):
        return heapq.heappop(self.elements)[1]


dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]


def in_range(dy, dx) -> bool:
    return 0 <= dy < 3 and 0 <= dx < 3


def a_star_search(initial_board, goal_arr):

    initial_str = list_to_str(initial_arr)
    if initial_str == goal_str:
        return 0

    pq = PriorityQueue()
    pq.put(list_to_str(initial_board), heuristic(initial_board))
    initial_h = heuristic(initial_board)
    pq.put(initial_str, 0 + initial_h)
    g_scores = {initial_str: 0}

    while not pq.empty():
        current_str = pq.get()
        current = str_to_list(current_str)

        col_current, row_current = find_location(current, '0')
        if current_str == goal_str:
            return g_scores[current_str]

        for i in range(4):
            col_next = col_current + dy[i]
            row_next = row_current + dx[i]

            if in_range(col_next, row_next):
                target_next = swap_state(current, col_current, row_current, col_next, row_next)
                target_next_str = list_to_str(target_next)
                new_cost_g = g_scores[current_str] + 1
                if target_next_str not in g_scores or new_cost_g < g_scores[target_next_str]:
                    g_scores[target_next_str] = new_cost_g
                    next_h = heuristic(target_next)
                    priority = new_cost_g + next_h
                    pq.put(target_next_str, priority)
                swap_state(current, col_next, row_next, col_current, row_current)
    return -1

result = a_star_search(initial_arr, goal_arr)
print(result)


