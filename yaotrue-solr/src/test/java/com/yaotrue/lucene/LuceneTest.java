/*
 * Copyright 1999-2017 YaoTrue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yaotrue.lucene;

import java.io.IOException;

import org.apache.lucene.queryParser.ParseException;
import org.junit.Test;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2017年3月17日 下午5:32:30
 */
public class LuceneTest {

	@Test
	public void testIndex() throws IOException{
		long start = System.currentTimeMillis();
		
		Indexer indexer = new Indexer("G:\\development\\项目\\yaotrue\\solr\\lucene_index");
		
		int index = 0;
		try {
			index = indexer.index("G:\\development\\项目\\yaotrue\\solr\\lucene_source", new TextFilesFilter());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			indexer.close();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Indexing " + index + " files took " + (end-start) + " milliseconds");
	}
	
	@Test
	public void testSearch() throws IOException, ParseException{
		Searcher searcher = new Searcher();
		searcher.search("G:\\development\\项目\\yaotrue\\solr\\lucene_index", "梁惠王上");
		
		searcher.search("G:\\development\\项目\\yaotrue\\solr\\lucene_index", "zhangsan");
		
		searcher.search("G:\\development\\项目\\yaotrue\\solr\\lucene_index", "lisi");
	}
}
