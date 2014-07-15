
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "conference")
public class Conference {
	
	final static String PARLMEMBER_DICT_PATH = "C:/Users/fotis/workspace/Parliament/dict/ParlMembers.lst";
	final static String PROVINCE_DICT_PATH = "C:/Users/fotis/workspace/Parliament/dict/Provinces.lst";

	String [] tokens;
	Date date;
	ParlMember chairman;
	List<ParlMember> speakers;
	List<ParlReport> reports;
	String content;
		
	Dictionary parlMemberDictionary;
	Dictionary provinceDictionary;
	
	public Conference(){}
	public Conference(Date date, String content) throws IOException {
		
		this.content=content;
		this.date = date;
		this.tokens= content.split("\\s");
		init();
		}
	
	void init() throws IOException{
		parlMemberDictionary=new Dictionary(PARLMEMBER_DICT_PATH);
		provinceDictionary=new Dictionary(PROVINCE_DICT_PATH);
		removeTrash();
		chairman=new ParlMember(findChairman());
		reports=findReports();
		//speakers=findSpeakers();
		
	}
	
	String findChairman(){
		
		int i=0;
		String returnString="";
		//boolean f = true;
		
			while (true){
				
				i++;
				if (i>tokens.length-10){ 
					System.out.println("Chairman not found!");
					break;
				}
				if (tokens[i].equals("ΠΡΟΕΔΡΟΣ") || tokens[i].equals("ΠΡΟΕΔΡΕΥΩΝ") || (tokens[i].equals("ΠΡΟΕΔΡΕΥΟΥΣΑ") && tokens[i+1].contains("(")) || (tokens[i].equals("ΠΡΟΕΔΡΕΥΟΥΣΑ") && tokens[i+1].contains(" ("))){
					int j=i+1;
					returnString=tokens[j];
					while (!tokens[j].contains(")")) {
						returnString+=" "+ tokens[j+1];
						j++;
						}
					returnString = returnString.substring(1,returnString.indexOf(')'));
					break;
				}
				
				}
			
			//i++;}
			chairman=new ParlMember(returnString,"");
			return (returnString);
		//
		//return returnString.substring(1, returnString.length()-1);
	}	
	
	List<ParlMember> findSpeakers(){
		System.out.println("Finding speakers");
		List<ParlMember> returnList= new ArrayList<ParlMember>();
		for (int i=0;i<tokens.length-5;i++){
			if (parlMemberDictionary.lookup(tokens[i] + tokens[i+1]))
		{
			System.out.println("Speaker Found!");
			returnList.add(new ParlMember(tokens[i]));	
				}
		if (parlMemberDictionary.lookup(tokens[i]+tokens[i+1]+tokens[i+2])){
			
			System.out.println("Speaker Found!");
			returnList.add(new ParlMember(tokens[i]));	
			
		}
		}
		return returnList;
	}
	
	List<ParlReport> findReports() throws IOException{
		
		List<ParlReport> returnTable=new ArrayList<ParlReport> ();
		
		String parlMemberFullName;
		String provinceName;
		String reportBody;
		int i=0;
		
		while (i<tokens.length-20){
			 	
			if (tokens[i].equals("Βουλευτής")|| tokens[i].equals("Βουλευτές")){
				
				
				System.out.println("Report found!");
				parlMemberFullName="";
				provinceName="";
				reportBody="";
				
				
				if (StringUtils.isAllUpperCase(tokens[i+3]) && StringUtils.isAllUpperCase(tokens[i+4])){
			 			
			 			parlMemberFullName+=(tokens[i+3]+ " " + tokens[i+4]);
			 			provinceName=tokens[i+1];
	 						 					
	 					if (StringUtils.isAllUpperCase(tokens[i+5])){
	 						parlMemberFullName+=(" " + tokens[i+5]);	
			 			}
	 					
	 					while (!tokens[i].equals("κατέθεσε") && !tokens[i].equals("κατέθεσαν") && !tokens[i].equals(".")) {
	 						i++;
	 						if (i<tokens.length-20){
	 							break;
	 						}
	 						}
	 					i++;
	 					
	 					do{
	 						if (i<tokens.length-20)
	 							break;
	 						reportBody+=tokens[i]+ " ";
	 						i++;
	 						
	 					}
	 					
	 					while ( !( tokens[i].endsWith(".") && ( tokens[i+1].equals("Σελίδα") || StringUtils.endsWith(tokens[i+1], ")")  || StringUtils.endsWith(tokens[i+1], ")Οι")  || StringUtils.endsWith(tokens[i+1], ")Ο")  || StringUtils.endsWith(tokens[i+1], ")Η")  ||  StringUtils.endsWith(tokens[i+1],"'") || tokens[i+1].equals("Β."))));	 							
	 					
	 					reportBody+=tokens[i];
	 				
	 				provinceDictionary.check(provinceName);	
	 				parlMemberDictionary.check(parlMemberFullName);
	 				System.out.println("Report number :" + returnTable.size() +1);
	 				returnTable.add(new ParlReport(new ParlMember(parlMemberFullName,provinceName),reportBody));
	 				
	 					
			 		}
				
				
				
				
			 			
			}
			
			i++;		
			}
		
		return returnTable;
		}
	
	void removeTrash(){
		System.out.println("Removing gaps..");
		int count=0;
		int i,j=0;
		List<String> result=new ArrayList<String>();
		
		for (i=0;i<tokens.length;i++){
			if (!(tokens[i].equals(""))){
				result.add(tokens[i]);
			}
			else count++;
				}
		
		while (j<result.size()-2){
		if (result.get(j).equals("Σελίδα") && result.get(j+1).matches("[0-9]{4}")){		
			result.remove(j);
			result.remove(j);
		}
		
		result.get(j).replace("'", "");
		j++;
		}
		
		
		tokens= result.toArray(new String[result.size()]);
		System.out.println( count + " Gaps removed.");
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ParlMember getChairman() {
		return chairman;
	}
	public void setChairman(ParlMember chairman) {
		this.chairman = chairman;
	}
	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}
	String getTokens(){
		String returnString = "";
		System.out.println("Number of tokens are :"+ tokens.length);
		for (int i=0;i<tokens.length;i++){
			returnString+=" " + tokens[i];
		}
		return returnString;
	}
	
	void updateDictionary() throws IOException{
		String tempName="";
		for (int i=0;i<tokens.length;i++){
			if (tokens[i].endsWith(":") && StringUtils.isAllUpperCase(tokens[i-1]) && StringUtils.isAllUpperCase(tokens[i].substring(0, tokens[i].length()-1))){
				if ( StringUtils.isAllUpperCase(tokens[i-2])){
					tempName+=(tokens[i-2]+ " " + tokens[i-1]+ " " + tokens[i].substring(0, tokens[i].length()-1));
				}
				
				else {
					tempName+=(tokens[i-1]+" "+tokens[i].substring(0, tokens[i].length()-1));
				}
				System.out.println("Name Found: "+ tempName);
				if (!parlMemberDictionary.check(tempName))
				System.out.println("Added");
				tempName="";
				
		}
	}
}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Conference [date=" + date + ", chairman=" + chairman
				+ ", speakers=" + speakers + ", reports=" + reports + "]";
	}

		

	
	
	
}