package com.atuldwivedi.fw.db.util;

import com.atuldwivedi.fw.db.ddl.DdlDao;
import com.atuldwivedi.fw.db.ddl.DdlDaoImpl;
import com.atuldwivedi.fw.db.dml.DmlDao;
import com.atuldwivedi.fw.db.dml.DmlDaoImpl;
import com.atuldwivedi.fw.db.dql.DqlDao;
import com.atuldwivedi.fw.db.dql.DqlDaoImpl;

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
}
