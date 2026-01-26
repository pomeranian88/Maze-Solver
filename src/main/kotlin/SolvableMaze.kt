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
        var keepGoing: Boolean = true
        var keepCount: Int = 0
        var checkDirecs: MutableList<Int>
        
        // --------------------------------------------------------------------- //

        // WHILE we haven't backtracked all the way to the beginning & visited every possible square...
        while(fullMazePath.isEmpty()!=true){
            // 1st check: if we've reached the end, cut off the loop & return true
            if(fullMazePath.peek() == squares[finishRow][finishCol]){
                return true
            }
            checkDirecs = mutableListOf(1,2,3,4) //reset loop list: 1=up, 2=down, 3=left, 4=right
            keepGoing = true //reset keepGoing condition

            // CHECK IF ON FINAL/START OF ANY ROW/COL
            if(currentSquare.row==0){checkDirecs.remove(1)}
            if(currentSquare.row==numRows-1){checkDirecs.remove(2)}
            if(currentSquare.col==0){checkDirecs.remove(3)}
            if(currentSquare.col==numCols-1){checkDirecs.remove(4)}

            // 2nd check: loop through each direction (1,2,3,4). If you choose any, loop through the rest of nums WITHOUT doing anything
            //            if none of the directions work, keepGoing transmits to the if statement after that BACKTRACKS!
            for(direction in checkDirecs){
                if(keepGoing==true){
                    when(direction){
                        1 -> {
                            if(
                                currentSquare.hasTopWall==false && squares[currentSquare.row-1][currentSquare.col].visited==false)
                                {
                                addSquare(squares[currentSquare.row-1][currentSquare.col])
                                currentSquare = fullMazePath.peek()
                                keepGoing = false
                            }
                            // if there's no down wall & haven't gone before, GO DOWN, make currentSquare = down, keepGoing = false to ignore rest of directions
                        }
                        2 -> {
                            if(
                                squares[currentSquare.row+1][currentSquare.col].hasTopWall==false && squares[currentSquare.row+1][currentSquare.col].visited==false)
                                {
                                addSquare(squares[currentSquare.row+1][currentSquare.col])
                                currentSquare = fullMazePath.peek()
                                keepGoing = false
                            }
                            /// if there's no top wall & haven't gone before, GO UP, make currentSquare = up, keepGoing = false to ignore rest of directions
                        }
                        3 -> {
                            if(
                                squares[currentSquare.row][currentSquare.col-1].hasRightWall==false && squares[currentSquare.row][currentSquare.col-1].visited==false)
                                {
                                addSquare(squares[currentSquare.row][currentSquare.col-1])
                                currentSquare = fullMazePath.peek()
                                keepGoing = false
                            }
                            // if there's no left wall & haven't gone before, GO LEFT, make currentSquare = left, keepGoing = false to ignore rest of directions
                        }
                        4 -> {
                            if(
                                currentSquare.hasRightWall==false && squares[currentSquare.row][currentSquare.col+1].visited==false)
                                {
                                addSquare(squares[currentSquare.row][currentSquare.col+1])
                                currentSquare = fullMazePath.peek()
                                keepGoing = false
                            }
                            // if there's no right wall & haven't gone before, GO RIGHT, make currentSquare = right, keepGoing = false to ignore rest of directions
                        }
                    }
                }
            }
            // 3rd check: if no direction works, backtrack
            if(keepGoing){
                currentSquare.solutionPiece = false
                currentSquare.visited = true
                fullMazePath.pop()
                if(fullMazePath.isEmpty()!=true){
                    currentSquare = fullMazePath.peek()
                }
            }
        }
        
        return false // made it through the whole while loop w no solution, return false
    }
}