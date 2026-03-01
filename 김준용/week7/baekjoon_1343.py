board = input() + 'A'

board_filling = ''
x_len=0
for letter in board:
    if letter == 'X':
        x_len += 1 
    else:
        if x_len > 0:
            quad = x_len // 4
            x_len -= quad * 4
            duo = x_len // 2
            x_len -= duo * 2
            if x_len != 0:
                print(-1)
                break
            board_filling += 'AAAA' * quad + 'BB' * duo
        if letter == '.':
            board_filling += '.'
if x_len == 0:
    print(board_filling)