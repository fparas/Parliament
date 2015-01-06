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
    				
    				String urlname[] = new String[28]; 
    				urlname[0] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+".txt");
    				urlname[1] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/synedri-"+stringMonth+"-"+stringDay+"-"+year+".txt");
    				 urlname[2] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/End"+ year  + stringMonth + stringDay+".txt");
    				 urlname[3] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ day+"_" + month +"_"+ year+".txt");
    				 urlname[4]  = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ stringDay+"_" + stringMonth +"_"+ year+".txt");
    				 urlname[5]  = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ stringDay+"_" + stringMonth +"_"+ year+".txt");
    				 urlname[6]  = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ stringDay+"_" + stringMonth +"_"+ year+".txt");
    				 urlname[7]  = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ stringDay+ stringMonth + year+".txt");
    				 urlname[8] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+".doc");
     				 urlname[9] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/synedri-"+stringMonth+"-"+stringDay+"-"+year+".doc");
     				 urlname[10] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/End"+ year  + stringMonth + stringDay+".doc");
     				 urlname[11] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ day+"_" + month +"_"+ year+".doc");
     				 urlname[12]  = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ stringDay+"_" + stringMonth +"_"+ year+".doc");
     				 urlname[13]  = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/"+ stringDay+"_" + stringMonth +"_"+ year+".doc");
     				 urlname[14]  = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ stringDay+"_" + stringMonth +"_"+ year+".doc");
     				 urlname[15]  = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ stringDay+ stringMonth + year+".doc");
     				 urlname[16] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Esl"+ year +  stringMonth + stringDay+".txt");
     				 urlname[17] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Esl"+ year +  stringMonth + stringDay+".doc");
     				urlname[18] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"_1.doc");
     				urlname[19] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"_1.txt");
     				urlname[20] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"pr.doc");
     				urlname[21] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"pr.txt");
     				urlname[20] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"ap.doc");
     				urlname[21] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"ap.txt");
     				urlname[22] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"pr.doc");
     				urlname[23] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"ap.doc");
     				urlname[22] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"pr.txt");
     				urlname[23] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"ap.txt");
     				urlname[24] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"_1.doc");
     				urlname[25] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"_1.txt");
     				urlname[26] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es "+ year +  stringMonth + stringDay+".txt");
     				urlname[27] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es "+ year +  stringMonth + stringDay+".doc");
     				urlname[26] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"vr.txt");
     				urlname[27] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"vr.doc");
     				urlname[26] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"vr.txt");
     				urlname[27] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/syne"+ year +  stringMonth + stringDay+"vr.doc");
     				urlname[28] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/es"+year+"."+stringMonth+"."+stringDay+".doc");
     				urlname[29] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/es"+year+"."+stringMonth+"."+stringDay+".txt");
     				urlname[30] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es "+ year +  stringMonth + stringDay+"_1.doc");
     				urlname[31] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es "+ year +  stringMonth + stringDay+"_1.txt");
     				urlname[32] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"-1.doc");
     				urlname[33] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es"+ year +  stringMonth + stringDay+"-1.txt");
     				urlname[34] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es "+ year +  stringMonth + stringDay+"_2.doc");
     				urlname[35] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es "+ year +  stringMonth + stringDay+"_2.txt");
     				urlname[36] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es "+ year +  stringMonth + stringDay+"_4.doc");
     				urlname[37] = ("http://www.hellenicparliament.gr/UserFiles/a08fc2dd-61a9-4a83-b09a-09f4c564609d/Es "+ year +  stringMonth + stringDay+"_4.txt");
     				
    				for (int i=0;i<urlname.length;i++){
    				System.out.println("Searching url : "+urlname[i]);
    				URL url = new URL (urlname[i]);
    				
    					File file = null;
    					if (urlname[i].endsWith(".doc")){
    							file= new File ("C:/Users/fotis.paraschiakos/Dropbox/Public/Javaprojects/Parliament/Parliament/corpus/java/"+fullyear+"/"+day+"-"+month+"-"+fullyear+".doc");
    					}
    					else if (urlname[i].endsWith(".txt")) {
    						file= new File ("C:/Users/fotis.paraschiakos/Dropbox/Public/Javaprojects/Parliament/Parliament/corpus/java/"+fullyear+"/"+day+"-"+month+"-"+fullyear+".txt");
    					}
    					
    							    					
    					if (copyFile(url,file) == true) n++; 
    					
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
			else return false;
			
			
			//boolean added = conferenceList.add(new Conference(day, month,year,file));
			
			}
		
		catch (Exception e){ System.out.println("Not found!"); return false;}
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