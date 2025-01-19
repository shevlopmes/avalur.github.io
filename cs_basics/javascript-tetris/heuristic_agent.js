// Heuristic evaluation function
function evaluateBoard(board) {
    let aggregateHeight = 0;
    let completeLines = 0;
    let holes = 0;
    let bumpiness = 0;
    let columnHeights = new Array(nx).fill(0);
    let ignore = new Array(ny).fill(0);
    for(let x = 0; x < nx; ++x){
        for(let y = 0; y < ny; ++y){
            if(board[x][y] === null) {
                board[x][y]= 0;
            }
        }
    }
    // Calculate complete lines
    for (let y = 0; y < ny; y++) {
        var complete = true;
        for (let x = 0; x < nx; x++) {
            if (board[x][y] === 0 || board[x][y] === null) {
                complete = false;
                break;
            }
        }
        if (complete) {
            completeLines++;
        }
    }
/*
    // Calculate aggregate height and column heights
    for (let y = 0;y< ny; y++) {
        for (let x = 0; x < nx; x++) {
            if (board[x][y] !== 0 && board[x][y] !== null) {
                if(columnHeights[x] === 0) {
                    console.log("upd columnHeights",x,ny-y);
                    columnHeights[x] = ny - y;
                }
                //aggregateHeight += columnHeights[x];
            }
        }
    }

 */

    for(let x = 0; x < nx; ++x){
        for(let y = 0; y < ny; ++y){
            if(board[x][y] !==0){
                columnHeights[x] = ny-y;
                break;
            }
        }
    }
    for (let y = 0; y < nx; ++y){
        aggregateHeight += columnHeights[y];
    }

    // Calculate holes
    for (let x = 0; x < nx; x++) {
        let blockFound = false;
        for (let y = 0; y < ny; y++) {
            if (board[x][y] !== 0) {
                blockFound = true;
            } else if (blockFound && board[x][y] === 0) {
                holes++;
                blockFound= false;
            }
        }
    }

    // Calculate bumpiness
    for (let x = 0; x < nx - 1; x++) {
        bumpiness += Math.abs(columnHeights[x] - columnHeights[x + 1]);
    }
    console.log("board",board);
    console.log("columnHeights",columnHeights);
   // console.log(aggregateHeight, completeLines, holes, bumpiness,-0.51 * aggregateHeight + 0.76 * completeLines - 0.36 * holes - 0.18 * bumpiness - MaxHeight);

    // Combine features into a heuristic score
    return -0.51 * aggregateHeight + 0.76 * completeLines - 0.36 * holes - 0.18 * bumpiness;
}

// Function to deep copy the blocks array
function copyBlocks(blocks) {
    let new_blocks = [];
    for (let x = 0; x < nx; x++) {
        new_blocks[x] = [];
        for (let y = 0; y < ny; y++) {
            new_blocks[x][y] = blocks[x][y];
        }
    }
    return new_blocks;
}
function copyPiece (piece){
    let new_piece = {dir: piece.dir,type:piece.type,x:piece.x,y:piece.y};
    return new_piece;
}

// Generate all possible moves for the current piece
function getPossibleMoves(piece) {
    let moves = [];
    // For each rotation of the piece
    console.log(piece);
    for (let dir = 0; dir < 4; dir++) {
        new_piece = copyPiece(piece);
        new_piece.dir = dir;

        // For each horizontal position
        for (let x = -3; x < nx; x++) {
            let y = getDropPosition(new_piece, x);
            if (y===-1){
                continue;
            }
            let new_blocks = copyBlocks(blocks);
            eachblock(new_piece.type, x, y, new_piece.dir, function(x, y) {
                new_blocks[x][y] = new_piece.type;
            });
            moves.push({piece: new_piece, x: x, y: y, board: new_blocks});
        }
    }
    console.log("moves",moves);
    return moves;
}

// Select the best move based on heuristic evaluation
function selectBestMove(piece, board) {
    let moves = getPossibleMoves(piece);
    let bestMove = null;
    let bestScore = -Infinity;
    moves.forEach(move => {
        let score = evaluateBoard(move.board);
        if (score > bestScore) {
            bestScore = score;
            bestMove = move;
        }
    });
    console.log(bestScore);
    console.log("direction",bestMove.piece.dir);
    return bestMove;
}

// Function to get the drop position of the piece
function getDropPosition(piece, x) {
    let y = -1;
    while (!occupied(piece.type, x, y + 1, piece.dir)) {
        y++;
    }
    console.log("getDropPosition:",piece,x,y);
    return y;
}
