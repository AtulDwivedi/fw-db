package com.atuldwivedi.fw.db.reader;

import java.io.IOException;
import java.util.List;

public interface QueryReader {
	public List<String> getQueryList(String queryFilePath) throws IOException;
}
