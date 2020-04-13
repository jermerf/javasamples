package controller;
import java.io.*;

public class FileLoader {
	private String rootDirectory;
	public FileLoader(String rootDirectory) {
		this.rootDirectory = rootDirectory;
	}
	
	public File getFile(String fileName) {
		try{
			return new File(rootDirectory+"/"+fileName);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
}
