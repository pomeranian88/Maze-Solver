class SolvableMaze(filename: String) : Maze(filename) {

    // returns true if there is a solution, false otherwise
    fun solveMaze(): Boolean {
        
        // declare the stack that will be used to track the maze square
        var fullMazePath: ListStack<MazeSquare> = ListStack()
        // function for adding squares to the stack & then marking them as visited
        fun addSquare(square: MazeSquare, addTo: ListStack<MazeSquare> = fullMazePath){
            addTo.push(square)
            square.visited = true
            square.solutionPiece = true
        }
        // add the first square to the stack, and now you're at the start of the maze -- also initialize later used vars
        addSquare(squares[startRow][startCol])
        var currentSquare: MazeSquare = fullMazePath.peek()

        // WHILE we haven't backtracked all the way to the beginning & visited every possible square...
        while(fullMazePath.isEmpty()!=true){
            // if we're all the way to the right OR we encounter a right wall, end the loop
            if(currentSquare.col==numCols-1 || currentSquare.hasRightWall==true){
                return true
            }

            // otherwise, move to the right, and set the current square to be one to the right
            addSquare(squares[currentSquare.row][currentSquare.col+1])
            currentSquare = fullMazePath.peek()
        }
        return false // made it through the whole while loop w no solution, return false
    }
}