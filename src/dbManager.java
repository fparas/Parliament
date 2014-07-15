import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.*;
import java.util.Set;

import org.h2.tools.Server;

public class dbManager {
	
	Connection conn;
	Statement stmt;
	Server server;
	
	dbManager() throws ClassNotFoundException, SQLException{
		server = Server.createTcpServer().start();
		Class.forName("org.h2.Driver");
	    conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/parliamentdb", "sa", "");
	    stmt=conn.createStatement();
	}
	
	public void  close() throws ClassNotFoundException, SQLException{
		
		    	
    	conn.close();
    	server.stop();
    	}
	
	public boolean insertParlmember(ParlMember parlmember) throws ClassNotFoundException, SQLException{
		
		String SQL;
		String ParlmemberName=parlmember.getName();
		String ParlmemberProvince=parlmember.getProvince();
		boolean ret=false;
		
		ResultSet r = stmt.executeQuery(
				"SELECT * FROM PARLMEMBER "
				+ "WHERE NAME='"+ParlmemberName
				+"' AND (PROVINCE='"+ParlmemberProvince +"' OR PROVINCE=NULL)");
		
		if (!r.next()) { 
			ret=true;
		if (parlmember.getProvince().equals(""))
			SQL= "INSERT INTO PARLMEMBER VALUES (NULL,'"+ParlmemberName+"',NULL,NULL)";
		else
			 SQL= "INSERT INTO PARLMEMBER VALUES (NULL,'"+ParlmemberName+"','"+ParlmemberProvince+"',NULL)";
		
		System.out.println(stmt.executeUpdate(SQL));
		System.out.println("ParlMember inserted! " + parlmember);
		}
		r.close();
		
		return ret;
		}
	
	
	public int insertConference (Conference c) throws ClassNotFoundException, SQLException{
		Date date = new java.sql.Date(c.getDate().getTime());
		ParlMember parlmember=c.getChairman();
		insertParlmember(parlmember);
		
		ResultSet r = stmt.executeQuery("SELECT * FROM PARLMEMBER WHERE NAME='"+parlmember.getName()+"'");
		System.out.println(r.next());
		int chairmanID = r.getInt(1);
		
		PreparedStatement statement=conn.prepareStatement("INSERT INTO CONFERENCE VALUES (NULL,'"+chairmanID+"','"+date+"',?)");
		statement.setCharacterStream(1, new StringReader(c.getContent())); 
		statement.execute();
		ResultSet resultID = stmt.executeQuery("SELECT * FROM CONFERENCE WHERE DATE='"+date+"'");
		resultID.first();
		return resultID.getInt(1);
		}
	
	public void insertReport (ParlReport p, int confID) throws ClassNotFoundException, SQLException{
		ParlMember reporter = p.getReporter();
		System.out.println(reporter);
		insertParlmember(reporter);
		ResultSet resultID = stmt.executeQuery("SELECT * FROM PARLMEMBER WHERE NAME='"+reporter.getName()+"'");
		resultID.next();
		int reporterID=resultID.getInt(1);
		PreparedStatement statement=conn.prepareStatement("INSERT INTO REPORT VALUES (NULL,'"+confID+"','"+reporterID+"',?)");
		statement.setCharacterStream(1, new StringReader(p.getBody())); 
		statement.execute();
		//stmt.executeUpdate("INSERT INTO CONFERENCE VALUES (NULL,'"+chairmanID+"','"+new java.sql.Date(c.getDate().getTime())+"',' ')");
		
		}
	
	public void insertSpeech (ParlReport p, int confID) throws ClassNotFoundException, SQLException{
		ParlMember reporter = p.getReporter();
		System.out.println(reporter);
		insertParlmember(reporter);
		ResultSet resultID = stmt.executeQuery("SELECT * FROM PARLMEMBER WHERE NAME='"+reporter.getName()+"'");
		resultID.next();
		int reporterID=resultID.getInt(1);
		PreparedStatement statement=conn.prepareStatement("INSERT INTO REPORT VALUES (NULL,'"+confID+"','"+reporterID+"',?)");
		statement.setCharacterStream(1, new StringReader(p.getBody())); 
		statement.execute();
		//stmt.executeUpdate("INSERT INTO CONFERENCE VALUES (NULL,'"+chairmanID+"','"+new java.sql.Date(c.getDate().getTime())+"',' ')");
		
		}



}
