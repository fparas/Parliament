import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


public class IO {

	
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return encoding.decode(ByteBuffer.wrap(encoded)).toString();
			}
	
	
	static void appendtoFile(String s,String path) throws IOException{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true))); 
			out.print("\n" + s);
		    out.close();
		
		}
	
	
}
