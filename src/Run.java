import gate.Corpus;
import gate.DocumentContent;
import gate.Gate;
import gate.LanguageAnalyser;
import gate.creole.SerialAnalyserController;
import gate.util.Err;
import gate.util.GateException;
import gate.util.Out;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;



public class Run {
final static String PATH = "D:/Corpora/TestFolder/";
final static String PARLMEMBER_DICT_PATH = "C:/Users/fotis/workspace/Parliament/dict/ParlMembers.lst";
	
	public static void main (String args[]) throws IOException, ParseException, GateException, ClassNotFoundException, SQLException{
		
		System.out.println(PATH);
		
		
		
		
		//*********************************************** /GATE *****************************			
		
		
		
//		
//		
//		try {
//		      Gate.init();
//		      Out.prln("GATE initialised...");
//		    }
//		    catch (GateException gex) {
//		      Err.prln("cannot initialise GATE...");
//		      gex.printStackTrace();
//		      return;
//		    }
//
//		 Gate.getCreoleRegister().registerDirectories(
//		            new File(Gate.getPluginsHome(), "ANNIE").toURI().toURL());
//		 SerialAnalyserController pipeline =
//		           (SerialAnalyserController)gate.Factory.createResource(
//		              "gate.creole.SerialAnalyserController");
//		 LanguageAnalyser tokeniser = (LanguageAnalyser)gate.Factory.createResource(
//		              "gate.creole.tokeniser.DefaultTokeniser");
//		 LanguageAnalyser jape = (LanguageAnalyser)gate.Factory.createResource(
//		           "gate.creole.Transducer", gate.Utils.featureMap(
//		               "grammarURL", new File("C:\\users\\fotis\\workspace\\Parliament\\jape\\chairman.jape").toURI().toURL(),
//		               "encoding", "UTF-8"));
//		 pipeline.add(tokeniser);
//		 pipeline.add(jape);
//		 Corpus corpus = gate.Factory.newCorpus(null);
//		 gate.Document doc = gate.Factory.newDocument("Who is author of Inception");
//		 DocumentContent dc=doc.getContent();        
//		 corpus.add(doc);
//		 pipeline.setCorpus(corpus);
//		 pipeline.execute();
//		 System.out.println("Found annotations of the following types: " +
//		           doc.getAnnotations().getAllTypes());

		 
		 
		 
//*********************************************** /GATE *****************************		 
		 
		 
		//Initializing 
		Dictionary dictParlMembers=new Dictionary(PARLMEMBER_DICT_PATH);
		dictParlMembers.check("Παναγιώτης Σγουρίδης");
		dbManager d=new dbManager();
		File fileList [] = new File(PATH).listFiles();
		System.out.println(fileList.length);
		//RunGate r = new RunGate();
		
		//
		
//		
//		
//		
		for (int i=1;i<fileList.length;i++){
			
			System.out.println("File Number : " + i + "Name : " + fileList[i].getName() );
			String conferencePath = PATH + fileList[i].getName();
			
			Conference c = new Conference(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(fileList[i].getName()),IO.readFile(conferencePath, StandardCharsets.UTF_8));
			//r.Run(conferencePath);
			
			
			//System.out.println("Built");
			System.out.println(c.findChairman());
			int confID = d.insertConference(c);

//				 
//			
//			
//			
//			
//			
			//List <ParlMember> speakers = c.findSpeakers();
			for (int j=0;j<c.reports.size();j++){
				ParlReport report = c.reports.get(j);
				System.out.println(report);
				
				d.insertReport(report,confID);
				
			}
			//c.updateDictionary();
			
//			System.out.println(c);
			
		
		//for (int i=0;i<fileList.length;i++)
		//System.out.println(readFile(PATH + fileList[1].getName(), StandardCharsets.UTF_8 ));	
	}
	
		d.close();
	}
	
	
	
}


