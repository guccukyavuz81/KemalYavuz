package com.codingtech.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.syntax.utils.ConfigsReader;

public class US38DBSteps {

@Test
public static List<Map<String, String>>  getAllJobTitleListn() throws SQLException {
	
	
	Connection 	connection = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"),
			ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbpassword"));
	Statement st = connection.createStatement();
	String query = "select job_title from ohrm_job_title where job_title =is_deleted order by job_title";
	ResultSet rs = st.executeQuery(query);
	
	ResultSetMetaData rsMetaData = rs.getMetaData();
	List<Map<String, String>> listData = new ArrayList<>();
	Map<String, String> mapData;
	
	while(rs.next()) {
		mapData = new LinkedHashMap<>();
		for(int i = 1; i <= rsMetaData.getColumnCount(); i++) {
			mapData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
		}
		listData.add(mapData);
	}
	return listData;
	
//System.out.println("Following from db");
//	System.out.println(listData);
//


}

	
}

