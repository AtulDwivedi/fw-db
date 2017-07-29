package com.atuldwivedi.fw.db.ddl;

public interface DdlDao {
	
	public void dropTables(String path);

	public void createTables(String path);

}
