/*
 * Author: Zev Thompson
 * 
 * Collaboration Statement: I Thought through how to structure the code for Part 2 (how to track directions, how to monitor
 *                          directions that had already been checked, most efficient ways to use functions to simplify code,
 *                          logic of if statements, how to not run into index errors with being in the top/last row or 
 *                          column, how to track checked squares, how to backtrack, etc.) with Ben, Sadie, and Ian one
 *                          night in a study room for two hours. Chatted with Rachel in prefect hours to figure out
 *                          Step 4, but Jean ended up helping me understand in class. 
 * 
 *                          For shrinking that code to complete the requirements of Part 1, I alone reworked (deleted
 *                          most of) that code to have the solver only move right.
 * 
 * Reflection: There were actually no particular issues I ran into -- most of my debugging was pretty straightforward.
 *             The challenge was mainly in mentally figuring out how to structure the code before getitng to writing it,
 *             and realizing better ways to have done things after I'd already done them (i.e. repeatedly referencing
 *             fullMazePath.peek() instead of assigning it as a variable, or repeatedly doing the same features in
 *             addSquare instead of making it a function). Going back to fix those annoyances probably took the most time.
 *             
 *             Because I finished Pt 2 first, finishing all of Pt 2 took probably 3.5 hours, and shrinking that code to
 *             complete only Pt 1 took probably 30 more minutes. 4 hours total.
 */

fun main(args: Array<String>) {
    if(args.size==2){
        if(args[1]=="--solve"){
            var myMaze = SolvableMaze("${args[0]}")
            myMaze.printMaze()
            println("function worked?: ${myMaze.solveMaze()}")
            myMaze.printMaze()
        }
        else{println("You probably entered something wrong -- redo your entry")}
    }
    else if(args.size==1){
        var myMaze = SolvableMaze("${args[0]}")
        myMaze.printMaze()
    }
    else{
        println("You may have entered something wrong, or run the code in Maven, which will not work because there are no args!")
    }
}