package com.atuldwivedi.fw.db.util;

import com.atuldwivedi.fw.db.ddl.DdlDao;
import com.atuldwivedi.fw.db.ddl.DdlDaoImpl;
import com.atuldwivedi.fw.db.dml.DmlDao;

public class DatabaseManager {

	public static void runSchemaScreator(String dbPropFile, String... files) {
		if (dbPropFile != null)
			LoadProperty.load(dbPropFile);

		String ddlFilePath = null;
		String dmlFilePath = null;
		String dqlFilePath = null;

		if (files != null && files.length > 0) {
			ddlFilePath = files[0];
			dmlFilePath = files[1];
			dqlFilePath = files[2];
		}

		if (((String) System.getProperty("ddl")).equalsIgnoreCase("true")) {
			System.setProperty("ddl.filePath", dmlFilePath);
			DdlDao ddlDao = new DdlDaoImpl();
			if(((String) System.getProperty("ddl.drop")).equalsIgnoreCase("true")){
				ddlDao.dropTables(ddlFilePath);
			}
			ddlDao.createTables(ddlFilePath);
		}

		if (((String) System.getProperty("dml")).equalsIgnoreCase("true")) {
			System.setProperty("dml.filePath", dmlFilePath);
			DmlDao dmlDao = InstanceFactory.getDmlDao();
			dmlDao.insertBaseData();
		}

		if (((String) System.getProperty("dql")).equalsIgnoreCase("true")) {
		}
	}

}
