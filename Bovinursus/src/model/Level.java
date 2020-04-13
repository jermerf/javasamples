package model;
import java.io.*;
import java.util.ArrayList;

public class Level{
	
	private ArrayList<LevelElement> elements;
	private int levelLength;
	
	public Level(int level) {
		
		elements = new ArrayList<LevelElement>();
		levelLength = 900;
		switch(level){
		case 1:
			parseFile("level1.lvl");
			break;
		case 2:
			parseFile("level2.lvl");
			break;
		}
	}
	
	private void parseFile(String filename) {
		// parameters: int x, int y, char type, char path, int param1, int param2
		// x= x position,  y= y position
		// type= type of element ie. enemy=a, powerup
		// path= motion path  a=unidirectional, takes 1 parameter=angle
		//										can take no parameter. default angle =180
		//					  b=sine, takes 2 parameters, amplitude followed by period
		// param1 and param2 = extra parameters used for such things as path
		// NOTE, THESE MUST BE ARRANGED IN THE ORDER THAT THEY APPEAR IN THE LEVEL
		// BECAUSE OF HOW THE ARRAY IS SEARCHED THROUGH. IE. IN ORDER OF X POSITION
		//elements.add(new LevelElement(0,300,'a','c'));
		BufferedReader fileR;
		String line;
		try{
			fileR = new BufferedReader(new FileReader(new File(filename)));
			levelLength =Integer.parseInt(fileR.readLine());
			line = fileR.readLine();
		}catch (Exception e){
			System.out.println(e.getMessage());
			line=null;
			fileR=null;
		}
		
		while(line!=null){
			ArrayList<String> words = new ArrayList<String>();
			if(line.indexOf("//")==0){
				try{
					line = fileR.readLine();
				}catch(Exception e){
					System.out.println("ERROR: Either unable to read level file " +
							"or file is badly formatted.");
				}
			}else{
				for(int i=0;i<line.length();i++){
					if(line.indexOf(',')==0){line=line.replaceFirst(",", "");}
					if(line.indexOf(',')==-1){
						words.add(line.substring(0, line.length()));
						line="";
					}else{
						words.add(line.substring(0, line.indexOf(',')));
						line=line.substring(line.indexOf(',')+1);
					}
					i=-1;
				}
				try{
					line = fileR.readLine();
					int x=Integer.parseInt(words.get(0));
					int y=Integer.parseInt(words.get(1));
					char type = words.get(2).charAt(0);//Should only be 1 char anyways
					char path = words.get(3).charAt(0);//Should only be 1 char anyways
					if(words.size()==4){
						elements.add(new LevelElement(x,y,type,path));
					}else if(words.size()==5){
						elements.add(new LevelElement(x,y,type,path,Integer.parseInt(words.get(4))));
					}else if(words.size()==6){
						elements.add(new LevelElement(x,y,type,path,Integer.parseInt(words.get(4)),Integer.parseInt(words.get(5))));
					}else{
						System.out.println("A problem might have occurred reading the level file");
					}
				}catch(Exception e){
					System.out.println("ERROR: Either unable to read level file " +
							"or file is badly formatted.");
				}
			}
		}
	}
	
	public LevelElement getElement (int index){
		return elements.get(index);
	}
	
	public int size(){
		return elements.size();
	}
	
	public int getLength(){
		return levelLength;
	}
}
