import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;



public class Dictionary {
	String [] tokens;
	String path;
	
	
	public Dictionary(String path) throws IOException {
		
		this.path=path;
		update();
		
		
	}
	
	
	boolean lookup(String s){
		Boolean b=false;
		int i=0;
		while (i<tokens.length){
			if (tokens[i].equals(s) || tokens[i].equals(s.toLowerCase()) || tokens[i].equals(s.toLowerCase()) ){
				b=true;
				i=tokens.length;
			}
			i++;
		}
		return b;
		
	}
	
	void update() throws IOException{
		
		String temp= IO.readFile(new File(path).getPath(), StandardCharsets.UTF_8);
		tokens=temp.split("\n");
		System.out.println("Updating Dictionary " +path);
	}
	
	boolean check (String s) throws IOException{
		
		boolean b = lookup(s);
		if (b==false){
			IO.appendtoFile(s, path);
			update();
			}
		return b;
		}
}
