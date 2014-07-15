import gate.Annotation;
import gate.AnnotationSet;
import gate.Corpus;
import gate.DocumentContent;
import gate.Gate;
import gate.LanguageAnalyser;
import gate.Node;
import gate.SimpleDocument;
import gate.annotation.AnnotationImpl;
import gate.creole.ResourceInstantiationException;
import gate.creole.SerialAnalyserController;
import gate.creole.ontology.Ontology;
import gate.relations.RelationSet;
import gate.util.Err;
import gate.util.GateException;
import gate.util.Out;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RunGate {

	public void Run(String path) throws GateException, IOException, ClassNotFoundException, SQLException{
		dbManager d=new dbManager();
		
		
		try {
		      Gate.init();
		      Out.prln("GATE initialised...");
		    }
		    catch (GateException gex) {
		      Err.prln("cannot initialise GATE...");
		      gex.printStackTrace();
		      return;
		    }

		 Gate.getCreoleRegister().registerDirectories(
		            new File(Gate.getPluginsHome(), "ANNIE").toURI().toURL());
		 SerialAnalyserController pipeline =
		           (SerialAnalyserController)gate.Factory.createResource(
		              "gate.creole.SerialAnalyserController");
		 LanguageAnalyser tokeniser = (LanguageAnalyser)gate.Factory.createResource(
		              "gate.creole.tokeniser.DefaultTokeniser");
		 LanguageAnalyser gazeteer = (LanguageAnalyser)gate.Factory.createResource(
				 "gate.creole.gazetteer.DefaultGazetteer",gate.Utils.featureMap(
			               "listsURL", new File("C:\\users\\fotis\\workspace\\Parliament\\dict\\lists.def").toURI().toURL()));
		 LanguageAnalyser jape;
		 
		try {
			jape = (LanguageAnalyser)gate.Factory.createResource(
			           "gate.creole.Transducer", gate.Utils.featureMap(
			               "grammarURL", new File("C:\\users\\fotis\\workspace\\Parliament\\jape\\main.jape").toURI().toURL(),
			               "encoding", "UTF-8"));
		} catch (ResourceInstantiationException e) {
			
			System.out.println("exception");
			e.printStackTrace();
			jape=null;
		}
		 pipeline.add(tokeniser);
		 pipeline.add(gazeteer);
		 pipeline.add(jape);
		 
		 Corpus corpus = gate.Factory.newCorpus(null);
		 corpus.populate(new File(path).toURI().toURL(), new gate.util.ExtensionFileFilter("TXT files", "txt"), "UTF-8", false);
		 
		 String content=corpus.get(0).getContent().toString();
		 System.out.println(content);
		 
		 gate.Document doc = gate.Factory.newDocument(content);
		 
		 DocumentContent dc=doc.getContent();
		 	 
		  corpus.add(doc);
		 //corpus.add(doc2);
		 pipeline.setCorpus(corpus);
		 pipeline.execute();
		 		 
		 // Find the directory for the Ontology plugin 
//		 File pluginHome = 
//		 new File(new File(Gate.getGateHome(), "plugins"), "Ontology"); 
		 // Load the plugin from that directory 
		// Gate.getCreoleRegister().registerDirectories(pluginHome.toURI().toURL());
		 
		 AnnotationSet annSet = doc.getAnnotations();
		 RelationSet relSet;
		 
		 System.out.println("Found annotations of the following types: " +annSet.getAllTypes());
		 
		  		   
		  		   
		 		   AnnotationSet speeches = doc.getAnnotations().get(("Speech"));
		 		   relSet = SpeechParlmember(speeches,annSet);
		  		   
		 		   System.out.println(relSet.getRelations(0).get(1).getMembers());
		 		   
		 		  
		 		   
		 		  for (Annotation speech: speeches ){
		 			   		
		 			  		AnnotationImpl speechImpl=(AnnotationImpl) speech;
		 				    DocumentContent speechContent = dc.getContent(speechImpl.getStartNode().getOffset(), speechImpl.getEndNode().getOffset());
		 				    
		 				    AnnotationImpl parMemberImpl=(AnnotationImpl) speeches.get("ParlMember").firstNode();
		 				    DocumentContent parlMemberInSpeech = dc.getContent(parMemberImpl.getStartNode().getOffset(), parMemberImpl.getEndNode().getOffset());
		 				    
		 		  }		
		 				   
//		 		   }	  	
		 			   		
	}
	
	
	
	
	static RelationSet SpeechParlmember(AnnotationSet speeches,AnnotationSet annSet){
		   RelationSet relSet=RelationSet.getRelations(annSet);
		   for (Annotation speech: speeches ){
 			   int parlMemberID= annSet.get("Parlmember").firstNode().getId();
 			   relSet.addRelation("SpeakerOf",speech.getId(),parlMemberID);
 		   }
		   return relSet;
		   }
	
	
}
