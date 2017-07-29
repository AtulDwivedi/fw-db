package com.atuldwivedi.fw.db.dml;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.StringTokenizer;

import com.atuldwivedi.fw.db.util.ConnectionProvider;

public class DmlDaoImpl implements DmlDao {

	@Override
	public int insertBaseData(String dmlFilePath) {

		System.out.println(">> inserBaseData");
		int retval = 0;
		try {
			FileInputStream fin = new FileInputStream(dmlFilePath);
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

				// TODO: check if record already exists

				try (Connection con = ConnectionProvider.getConnection(); Statement stmt = con.createStatement();) {
					retval = stmt.executeUpdate(query);
					System.out.println(query.split(" ")[2] + " record inserted created.");
				} catch (Exception e) {
					System.out.println(this.getClass().getSimpleName() + " " + e);
				}

				System.out.println("<< inserBaseData");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retval;
	}

}
