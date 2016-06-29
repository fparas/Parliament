import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class IO {

	static void  URLRead(String year,String fullyear) throws MalformedURLException {
	    
	    

    	String stringDay;
		String stringMonth;
    	int n=0;
    	
    		
    		for (int month=1;month<13;month++){
    			for (int day=1;day<32;day++){
    				
    				if (day<10) stringDay= ( "0" + Integer.toString(day)); else stringDay = Integer.toString(day);
    				if (month<10) stringMonth= ("0"+Integer.toString(month)); else stringMonth = Integer.toString(month);
    				System.out.println(stringDay);
    				System.out.println(stringMonth);
    				System.out.println(year);
    				
    				ArrayList<String> urlnames = new ArrayList<String>(); 
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/synedri-"+stringMonth+"-"+stringDay+"-"+year+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/End"+ year  + stringMonth + stringDay+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ day+"_" + month +"_"+ year+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ stringDay+"_" + stringMonth +"_"+ year+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ stringDay+"_" + stringMonth +"_"+ year+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ stringDay+"_" + stringMonth +"_"+ year+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ stringDay+ stringMonth + year+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/synedri-"+stringMonth+"-"+stringDay+"-"+year+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/End"+ year  + stringMonth + stringDay+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ day+"_" + month +"_"+ year+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ stringDay+"_" + stringMonth +"_"+ year+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ stringDay+"_" + stringMonth +"_"+ year+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ stringDay+"_" + stringMonth +"_"+ year+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ stringDay+ stringMonth + year+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Esl"+ year +  stringMonth + stringDay+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Esl"+ year +  stringMonth + stringDay+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"_1.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"_1.txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"pr.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"ap.txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"pr.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"ap.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"_1.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"_1.txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"vr.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/es"+year+"."+stringMonth+"."+stringDay+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/es"+year+"."+stringMonth+"."+stringDay+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"-1.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"-1.txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"_2.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"_2.txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"_4.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"_4.txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ fullyear +  stringMonth + stringDay+".doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ fullyear +  stringMonth + stringDay+".txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"vr.txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"vr.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"vr.txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"pr.txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"ap.doc");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"pr.txt");
    				urlnames.add("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"ap.txt");
    				
     				for (int i=0;i<urlnames.size();i++){
    				String urlName=urlnames.get(i);
    				System.out.println("Searching url : "+urlName);
    				URL url = new URL (urlName);
    				
    					File file = null;
    					if (urlName.endsWith(".doc")){
    							file= new File ("C:/Users/fotis.paraschiakos/Dropbox/Public/Javaprojects/Parliament/Parliament/corpus/"+fullyear+"/"+day+"-"+month+"-"+fullyear+".doc");
    					}
    					else if (urlName.endsWith(".txt")) {
    						file= new File ("C:/Users/fotis.paraschiakos/Dropbox/Public/Javaprojects/Parliament/Parliament/corpus/"+fullyear+"/"+day+"-"+month+"-"+fullyear+".txt");
    					}
    					if (copyFile(url,file) == true) n++; 
    					file= new File ("C:/Users/fotis.paraschiakos/Dropbox/Public/Javaprojects/Parliament/Parliament/corpus/java"+fullyear+"/downloadedFiles/"+new String(urlName.substring(urlName.lastIndexOf("/"))));
    							    					
    					copyFile(url,file); 
    					
    				}
    				System.out.println(n+" Found"); 
    			}
    			System.out.println(n+" Found"); 
    		}
    	
    	  	
}  	
	
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return encoding.decode(ByteBuffer.wrap(encoded)).toString();
			}
	static boolean copyFile(URL url, File file) { 
		try {
			
			org.apache.commons.io.FileUtils.copyURLToFile(url, file);
			//org.apache.commons.io.FileUtils.copyURLToFile(urlB, fileB);
			if (file.exists()) {
				System.out.println("Found!");
				return true;
			}
			else {
				System.out.println ("Not Found!");
				return false;
			}
			
			
			//boolean added = conferenceList.add(new Conference(day, month,year,file));
			
			}
		
		catch (Exception e){ 
			System.out.println("Exception!"); 
						
			return false;}
	}
	static void appendtoFile(String s,String path) throws IOException{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true))); 
			out.print("\n" + s);
		    out.close();
		
		}
	static String newReadFile(String path) throws IOException{

		String content = "";
				
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(path), "UTF-16"));
				
		while ((in.readLine()) != null){ 
			content += "\n";
			content+=in.readLine();}
		in.close();
		
		return(content);
		}
	
	
}