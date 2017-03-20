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

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2017年3月17日 下午10:02:21
 */
public class Searcher {

	public void search(String indexDir,String q) throws IOException, ParseException{
		Directory directory = FSDirectory.open(new File(indexDir));
		IndexSearcher indexSearcher = new IndexSearcher(directory);
		
		QueryParser queryParser = new QueryParser(Version.LUCENE_30, "contents", new StandardAnalyzer(Version.LUCENE_30));
		
		Query query = queryParser.parse(q);
		long start = System.currentTimeMillis();
		
		TopDocs topDocs = indexSearcher.search(query, 10);
		long end = System.currentTimeMillis();
		
		System.out.println("在document中搜索 " + q + ",找到" + topDocs.totalHits + "条记录,花费"+(end-start)+"毫秒");
		
		for(ScoreDoc scoreDoc : topDocs.scoreDocs){
			Document document = indexSearcher.doc(scoreDoc.doc);
			System.out.println(document.get("fullpath"));
		}
		
		indexSearcher.close();
	}
}
