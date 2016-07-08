import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MazeReader {

	private String path;
	
	public MazeReader(String path) {
		this.path = path;
	}
	
	
	public Maze readMaze() {
		
		BufferedReader br = null;
		int width = 0;
		int height = 0;
		int startX = 0;
		int startY = 0;
		int endX = 0;
		int endY = 0;
		String[][] maze = null;
		
		try {
		
			br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			String[] size = line.split(" ");
			
			width = Integer.parseInt(size[0]);
			height = Integer.parseInt(size[1]);
			
			line = br.readLine();
			String[] start = line.split(" ");
			
			startX = Integer.parseInt(start[0]);
			startY = Integer.parseInt(start[1]);
			
			line = br.readLine();
			String[] end = line.split(" ");
			
			endX = Integer.parseInt(end[0]);
			endY = Integer.parseInt(end[1]);
			
			maze  = new String[height][width];
		
			for(int i = 0; i<height; i++) {
				line = br.readLine();
				String[] walls = line.split(" ");
				maze[i] = walls;
			}
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return new Maze(height, width, startX, startY, endX, endY, maze);
		
	}
	
}
