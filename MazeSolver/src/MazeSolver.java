
public class MazeSolver {

	public static void main(String[] args) {
		
		//input.txt
		MazeReader mr = new MazeReader("inputs/input.txt");
		Maze maze = mr.readMaze();
		System.out.println("input.txt");
		if(maze.solve()) {
			maze.printResult();
		}
		else {
			System.out.println("No solution found.");
		}
		
		//small.txt
		mr = new MazeReader("inputs/small.txt");
		maze = mr.readMaze();
		System.out.println("small.txt");
		if(maze.solve()) {
			maze.printResult();
		}
		else {
			System.out.println("No solution found.");
		}
		
		//medium_input.txt
		mr = new MazeReader("inputs/medium_input.txt");
		maze = mr.readMaze();
		System.out.println("medium_input.txt");
		if(maze.solve()) {
			maze.printResult();
		}
		else {
			System.out.println("No solution found.");
		}
		
		//sparse_medium
		mr = new MazeReader("inputs/sparse_medium.txt");
		maze = mr.readMaze();
		System.out.println("sparse_medium.txt");
		if(maze.solve()) {
			maze.printResult();
		}
		else {
			System.out.println("No solution found.");
		}
		
		//large_input
		mr = new MazeReader("inputs/large_input.txt");
		maze = mr.readMaze();
		System.out.println("large_input.txt");
		if(maze.solve()) {
			maze.printResult();
		}
		else {
			System.out.println("No solution found.");
		}
		
	}

}
