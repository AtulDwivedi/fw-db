package com.atuldwivedi.fw.db.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class QueryReaderImpl implements QueryReader {

	@Override
	public List<String> getQueryList(String sqlType) throws IOException {

		System.out.println(">> getQueryList");
		
		String filePath = null;
		
		if(sqlType.equalsIgnoreCase("DDL")){
			filePath = (new File((String) System.getProperty("ddl.filePath"))).getAbsolutePath();
		}else if(sqlType.equalsIgnoreCase("DML")){
			filePath = (new File((String) System.getProperty("dml.filePath"))).getAbsolutePath();
		}else if(sqlType.equalsIgnoreCase("DQL")){
			filePath = (String) System.getProperty("dql.filePath");
		}else{
			return null;
		}
		
		List<String> queryList = new ArrayList<String>();

		FileInputStream fin = new FileInputStream(filePath);
		byte data[] = new byte[fin.available()];
		fin.read(data);
		fin.close();
		String str = new String(data);
		StringTokenizer st = new StringTokenizer(str, "/");
		while (st.hasMoreTokens()) {
			String query = st.nextToken();
			if (query.trim().equals("stop")) {
				break;
			}
			queryList.add(query);
		}
		System.out.println("<< getQueryList");
		return queryList;
	}
}
