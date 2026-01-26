fun main(args: Array<String>) {
    var myMaze = SolvableMaze("${args[0]}")

    myMaze.printMaze()
    println("ability to solve the maze: ${myMaze.solveMaze()}")
    myMaze.printMaze()
}