fun main(args: Array<String>) {
    if(args.size==2){
        if(args[1]=="--solve"){
            var myMaze = SolvableMaze("${args[0]}")
            myMaze.printMaze()
            println("ability to solve the maze: ${myMaze.solveMaze()}")
            myMaze.printMaze()
        }
        else{println("You probably entered something wrong -- redo your entry")}
    }
    else if(args.size==1){
        var myMaze = SolvableMaze("${args[0]}")
        myMaze.printMaze()
    }
    else{
        println("You probably entered something wrong -- redo your entry")
    }
}