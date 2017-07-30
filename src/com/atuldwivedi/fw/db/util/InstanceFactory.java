package com.atuldwivedi.fw.db.util;

import com.atuldwivedi.fw.db.ddl.DdlDao;
import com.atuldwivedi.fw.db.ddl.DdlDaoImpl;
import com.atuldwivedi.fw.db.dml.DmlDao;
import com.atuldwivedi.fw.db.dml.DmlDaoImpl;
import com.atuldwivedi.fw.db.dql.DqlDao;
import com.atuldwivedi.fw.db.dql.DqlDaoImpl;
import com.atuldwivedi.fw.db.reader.QueryReader;
import com.atuldwivedi.fw.db.reader.QueryReaderImpl;

public class InstanceFactory {
	
	public static DmlDao getDmlDao() {
		return new DmlDaoImpl();
	}
	
	public static DqlDao getDqlDao() {
		return new DqlDaoImpl();
	}
	
	public static DdlDao getDdlDao() {
		return new DdlDaoImpl();
	}
	
	public static QueryReader getQueryReader() {
		return new QueryReaderImpl();
	}
}
