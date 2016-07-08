
public class Maze {

	private int height;
	private int width;
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private String[][] maze;
	private String[][] result;
	
	public Maze(int height, int width, int startX, int startY, int endX, int endY, String[][] maze) {
		this.height = height;
		this.width = width;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.maze = maze;
		
		// initial result array
		result = new String[height][width];
		
		for(int i = 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				if(maze[i][j].equals("1")) {
					result[i][j] = "#";
				}
				else {
					result[i][j] = " ";
				}
			}
		}
		
		result[startY][startX] = "S";
		result[endY][endX] = "E";
	}
	
	//based off of a depth first search
	public Boolean solve() {
		
		Boolean solutionFound = false;
		
		result = solveMaze(startX, startY, result);
		
		if(result != null) {
			solutionFound = true;
		}
		
		return solutionFound;
		
	}
	
	/**
	 * Takes in the 2d maze and returns a copy
	 * @param maze
	 * @return clone of maze
	 */
	public static String[][] cloneMaze(String[][] maze) {
	    int length = maze.length;
	    String[][] target = new String[length][maze[0].length];
	    for (int i = 0; i < length; i++) {
	        System.arraycopy(maze[i], 0, target[i], 0, maze[i].length);
	    }
	    return target;
	}
	
	private String[][] solveMaze(int x, int y, String[][] partialResult) {
		
		String[][] currentResult = cloneMaze(partialResult);
		
		//search north
		if(searchNorth(x, y, currentResult)) {
			//if north possible, get new co-ordinates
			int[] newCoords = moveNorth(x, y);
			//if the new co-ordinates are the end, return the new result array.
			if(currentResult[newCoords[1]][newCoords[0]].equals("E")) {
				return currentResult;
			}
			//else set the new co-ordinates to "X"
			currentResult[newCoords[1]][newCoords[0]] = "X";
			//and call solve on the new array
			String[][] northResult = solveMaze(newCoords[0], newCoords[1], currentResult);
			//if returned array isn't null then is the found end.
			if(northResult != null) {
				//return completed array
				return northResult;
			}
			else { //remove the previously added "X" as not the current path
				currentResult[newCoords[1]][newCoords[0]] = " ";
			}
		}
		//search east
		if(searchEast(x, y, currentResult)) {
			//if east possible, get new co-ordinates
			int[] newCoords = moveEast(x, y);
			//if the new co-ordinates are the end, return the new result array.
			if(currentResult[newCoords[1]][newCoords[0]].equals("E")) {
				return currentResult;
			}
			//else set the new co-ordinates to "X"
			currentResult[newCoords[1]][newCoords[0]] = "X";
			//and call solve on the new array
			String[][] eastResult = solveMaze(newCoords[0], newCoords[1], currentResult);
			//if returned array isn't null then is the found end.
			if(eastResult != null) {
				//return completed array
				return eastResult;
			}
			else { //remove the previously added "X" as not the current path
				currentResult[newCoords[1]][newCoords[0]] = " ";
			}
		}
		//search south
		if(searchSouth(x, y, currentResult)) {
			//if south possible, get new co-ordinates
			int[] newCoords = moveSouth(x, y);
			//if the new co-ordinates are the end, return the new result array.
			if(currentResult[newCoords[1]][newCoords[0]].equals("E")) {
				return currentResult;
			}
			//else set the new co-ordinates to "X"
			currentResult[newCoords[1]][newCoords[0]] = "X";
			//and call solve on the new array
			String[][] southResult = solveMaze(newCoords[0], newCoords[1], currentResult);
			//if returned array isn't null then is the found end.
			if(southResult != null) {
				//return completed array
				return southResult;
			}
			else { //remove the previously added "X" as not the current path
				currentResult[newCoords[1]][newCoords[0]] = " ";
			}
		}
		//search west
		if(searchWest(x, y, currentResult)) {
			//if west possible, get new co-ordinates
			int[] newCoords = moveWest(x, y);
			//if the new co-ordinates are the end, return the new result array.
			if(currentResult[newCoords[1]][newCoords[0]].equals("E")) {
				return currentResult;
			}
			//else set the new co-ordinates to "X"
			currentResult[newCoords[1]][newCoords[0]] = "X";
			//and call solve on the new array
			String[][] westResult = solveMaze(newCoords[0], newCoords[1], currentResult);
			//if returned array isn't null then is the found end.
			if(westResult != null) {
				//return completed array
				return westResult;
			}
			else { //remove the previously added "X" as not the current path
				currentResult[newCoords[1]][newCoords[0]] = " ";
			}
		}
		//return null if cannot move anywhere new.
		return null;
		
	}
	
	/**
	 * Test if possible to move north
	 * @param x
	 * @param y
	 * @return true if possible to move north, false if not
	 */
	private Boolean searchNorth(int x, int y, String[][] maze) {
		//if inbound and (blank space or the end) return true
		if((y-1 > 0) && (maze[y-1][x].equals(" ") || maze[y-1][x].equals("E"))) {
			return true;
		}

		return false;
	}
	
	/**
	 * Move north
	 * @param x
	 * @param y
	 * @return array of int's for x and y co-ordinates when moving north
	 */
	private int[] moveNorth(int x, int y) {
		int[] north = {x, y-1};
		return north;
	}
	
	
	/**
	 * Test if possible to move east
	 * @param x
	 * @param y
	 * @return true if possible to move east, false if not
	 */
	private Boolean searchEast(int x, int y, String[][] maze) {
		//if inbound and (blank space or the end) return true
		if((x+1 < width) && (maze[y][x+1].equals(" ") || maze[y][x+1].equals("E"))) {
			return true;
		}

		return false;
	}
	/**
	 * Move east
	 * @param x
	 * @param y
	 * @return array of int's for x and y co-ordinates when moving east
	 */
	private int[] moveEast(int x, int y) {
		int[] east = {x+1, y};
		return east;
	}
	
	
	/**
	 * Test if possible to move south
	 * @param x
	 * @param y
	 * @return true if possible to move south, false if not
	 */
	private Boolean searchSouth(int x, int y, String[][] maze) {
		//if inbound and (blank space or the end) return true
		if((y+1 < height) && (maze[y+1][x].equals(" ") || maze[y+1][x].equals("E"))) {
			return true;
		}

		return false;
	}
	/**
	 * Move south
	 * @param x
	 * @param y
	 * @return array of int's for x and y co-ordinates when moving south
	 */
	private int[] moveSouth(int x, int y) {
		int[] south = {x, y+1};
		return south;
	}
	
	
	/**
	 * Test if possible to move west
	 * @param x
	 * @param y
	 * @return true if possible to move west, false if not
	 */
	private Boolean searchWest(int x, int y, String[][] maze) {
		//if inbound and (blank space or the end) return true
		if((x-1 > 0) && (maze[y][x-1].equals(" ") || maze[y][x-1].equals("E"))) {
			return true;
		}

		return false;
	}
	/**
	 * Move west
	 * @param x
	 * @param y
	 * @return array of int's for x and y co-ordinates when moving west
	 */
	private int[] moveWest(int x, int y) {
		int[] west = {x-1, y};
		return west;
	}
	
	public void printMaze() {
		System.out.println(width + " " + height);
		System.out.println(startX + " " + startY);
		System.out.println(endX + " " + endY);
		for(int i = 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
	
	public void printResult() {
		if(result == null) {
			System.out.println("No solution found.");
		}
		else {
			for(int i = 0; i<height; i++) {
				for(int j = 0; j<width; j++) {
					System.out.print(result[i][j]);
				}
				System.out.println();
			}
		}
	}
	
}
