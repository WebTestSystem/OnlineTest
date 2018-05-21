package tool;

import java.io.File;

public class PathTool {

	public static String getFile(String filename)
	{
		System.out.println(PathTool.class.getResource("/" + filename).getPath());
		return PathTool.class.getResource(filename).getPath();
	}
	
}
