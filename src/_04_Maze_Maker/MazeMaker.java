package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {
	//Cell rc = new Cell (2,2);
    private static int rows;
    private static int cols;

    private static Maze maze;

    private static Random ra = new Random();
    private static Stack<Cell> uncheckedCells = new Stack<Cell>();

    public static Maze generateMaze(int r, int c) {
        rows = r;
        cols = c;
        System.out.println(r + " <-r c-> " + c);
        maze = new Maze(rows, cols);  
        int bx=0;
        int by=0;
        int ex=0;
        int ey=0;


bx=0;	
by=ra.nextInt(5); 
by=0;
maze.getCell(by, bx).setNorthWall(false);		
ex=4;	
ey=ra.nextInt(5);
ey=4;
maze.getCell(ey, ex).setSouthWall(false);
System.out.println(by + " " + ey + " by ey");

by=ra.nextInt(5); 
ey=ra.nextInt(5);
Cell cel = maze.getCell(by, ey);

selectNextPath(cel);
	

	// 1. Pick a random cell along the border and remove its exterior wall.
        //    This will be the starting point. Then select a random cell along
        //    the opposite wall and remove its exterior wall. This will be the
        //    finish line.
        
        // 2. select a random cell in the maze to start 
        
        // 3. call the selectNextPath method with the randomly selected cell

        return maze;
    }

    // 4. Complete the selectNextPathMethod
    private static void selectNextPath(Cell cc) {
    	ArrayList<Cell> getun =getUnvisitedNeighbors(cc);
        // A. SET currentCell as visited
    //	System.out.println(cc.getCol() + "-- <-c r-> " + cc.getRow());
cc.setBeenVisited(true);
        // B. check for unvisited neighbors using the cell
if(getun.isEmpty() == false) {
        // C. if has unvisited neighbors,
        // C1. select one at random.
 //Cell rc = getun.get(ra.nextInt(getun.size()-1));
 //rc.setBeenVisited(true);
		// C2. push it to the stack
uncheckedCells.push(getun.get(ra.nextInt(getun.size())));
        // C3. remove the wall between the two cells
removeWalls(cc, uncheckedCells.peek());
        // C4. make the new cell the current cell and SET it as visited
uncheckedCells.peek().setBeenVisited(true);
cc=uncheckedCells.peek();
        // C5. call the selectNextPath method with the current cell
selectNextPath(cc);
}
 
		// D. if all neighbors are visited
        // D1. if the stack is not empty
else if(getun.isEmpty() == true && uncheckedCells.isEmpty() == false){
        // D1a. pop a cell from the stack
        // D1b. make that the current cell	
cc=uncheckedCells.pop();
        // D1c. call the selectNextPath method with the current cell
selectNextPath(cc);
}
    }

    // This method will check if c1 and c2 are adjacent.
    // If they are, the walls between them are removed.
    private static void removeWalls(Cell c1, Cell c2) {
        if (c1.getRow() == c2.getRow()) {
            if (c1.getCol() > c2.getCol()) {
                c1.setWestWall(false);
                c2.setEastWall(false);
            } else {
                c1.setEastWall(false);
                c2.setWestWall(false);
            }
        } else {
            if (c1.getRow() > c2.getRow()) {
                c1.setNorthWall(false);
                c2.setSouthWall(false);
            } else {
                c1.setSouthWall(false);
                c2.setNorthWall(false);
            }
        }
    }

    // This method returns a list of all the neighbors around the specified
    // cell that have not been visited. There are up to 4 neighbors per cell.
    //          1
    //       2 cell 3
    //          4
    private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
        int row = c.getRow();
        int col = c.getCol();

        ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

        if (row > 0 && !maze.getCell(row - 1, col).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row - 1, col));
        }

        if (col > 0 && !maze.getCell(row, col - 1).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row, col - 1));
        }

        if (row < rows - 1 && !maze.getCell(row + 1, col).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row + 1, col));
        }

        if (col < cols - 1 && !maze.getCell(row, col + 1).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row, col + 1));
        }

        return unvisitedNeighbors;
    }
}
