def init_board(nx,ny):
    board = [[0 for i in range(ny)]for j in range(nx)]
KEY = { 'ESC': 27, 'SPACE': 32, 'LEFT': 37, 'UP': 38, 'RIGHT': 39, 'DOWN': 40 }
DIR     = { 'UP': 0, 'RIGHT': 1, 'DOWN': 2, 'LEFT': 3, 'MIN': 0, 'MAX': 3, 'AI': -1}
speed   = { 'start': 0.6, 'decrement': 0.005, 'min': 0.1 } # how long before piece drops by 1 row (seconds)
nx      = 10 # width of tetris court (in blocks)
ny      = 20 # height of tetris court (in blocks)
nu      = 5  # width/height of upcoming preview (in blocks)
i = { 'size': 4, 'blocks': [0x0F00, 0x2222, 0x00F0, 0x4444], 'color': 'cyan'   }
j = { 'size': 3, 'blocks': [0x44C0, 0x8E00, 0x6440, 0x0E20], 'color': 'blue'   }
l = { 'size': 3, 'blocks': [0x4460, 0x0E80, 0xC440, 0x2E00], 'color': 'orange' }
o = { 'size': 2, 'blocks': [0xCC00, 0xCC00, 0xCC00, 0xCC00], 'color': 'yellow' }
s = { 'size': 3, 'blocks': [0x06C0, 0x8C40, 0x6C00, 0x4620], 'color': 'green'  }
t = { 'size': 3, 'blocks': [0x0E40, 0x4C40, 0x4E00, 0x4640], 'color': 'purple' }
z = { 'size': 3, 'blocks': [0x0C60, 0x4C80, 0xC600, 0x2640], 'color': 'red'    }
def eachblock(type, x, y, dir, fn):
        row = 0
        col = 0
        blocks = type.blocks[dir]
        bit = 0x8000
        while bit > 0:
            if (blocks & bit):
                fn(x+col,y+row)
            if ++col==4:
                col = 0
                row+=1
            bit = bit>>1
def occupied(type, x, y, dir):
        result = 0
        eachblock(type, x, y, dir, function(x, y) {
            if ((x < 0) || (x >= nx) || (y < 0) || (y >= ny) || getBlock(x,y))
                result = true;
        });
        return result;

