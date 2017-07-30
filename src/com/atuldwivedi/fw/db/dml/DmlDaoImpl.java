package com.atuldwivedi.fw.db.dml;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.atuldwivedi.fw.db.reader.QueryReader;
import com.atuldwivedi.fw.db.util.ConnectionProvider;
import com.atuldwivedi.fw.db.util.InstanceFactory;

public class DmlDaoImpl implements DmlDao {

	@Override
	public int insertBaseData() {

		System.out.println(">> inserBaseData");
		int retVal = 0;
		try (Connection con = ConnectionProvider.getConnection(); Statement stmt = con.createStatement();) {

			QueryReader queryReader = InstanceFactory.getQueryReader();
			List<String> queryList;
			queryList = queryReader.getQueryList("DML");

			// TODO: check if record already exists

			if (queryList != null && queryList.size() > 0) {

				for (Iterator iterator = queryList.iterator(); iterator.hasNext();) {
					String query = (String) iterator.next();
					retVal = retVal + stmt.executeUpdate(query);
					System.out.println(query.split(" ")[2] + " record inserted.");
				}
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " " + e);
		}
		System.out.println("<< inserBaseData");

		return retVal;
	}

}
