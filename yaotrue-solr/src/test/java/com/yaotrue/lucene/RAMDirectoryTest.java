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

import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2017年3月22日 下午8:30:37
 */
public class RAMDirectoryTest extends TestCase {
	
	private String[] ids = {"1","2"};
	private String[] unindexed = {"Netherlands","Italy"};
	private String[] unstored = {"Amsterdam has lots of bridges","Venice has lots of canals"};
	private String[] text = {"Amsterdam","Venice"};
	
	private Directory directory;
	
	private IndexWriter getWriter() throws CorruptIndexException, LockObtainFailedException, IOException{
		return new IndexWriter(directory, new WhitespaceAnalyzer(), IndexWriter.MaxFieldLength.UNLIMITED);
	}

	@Before
	public void setUp() throws IOException{
		directory = new RAMDirectory();
		
		IndexWriter indexWriter = getWriter();
		
		for(int i = 0;i<ids.length;i++){
			Document document = new Document();
			document.add(new Field("id", ids[i],Field.Store.YES,Field.Index.NOT_ANALYZED));
			document.add(new Field("country",unindexed[i],Field.Store.YES,Field.Index.NO));
			document.add(new Field("contents",unstored[i],Field.Store.NO,Field.Index.ANALYZED));
			document.add(new Field("city",text[i],Field.Store.YES,Field.Index.ANALYZED));
			
			indexWriter.addDocument(document);
		}
		
		indexWriter.close();
	}
	
	public int getHitCount(String fieldName,String searchString) throws IOException{
		IndexSearcher indexSearcher = new IndexSearcher(directory);
		
		Term term = new Term(fieldName, searchString);
		Query query = new TermQuery(term);
		ScoreDoc[] scoreDocs = indexSearcher.search(query,1).scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			Document document = indexSearcher.doc(scoreDoc.doc);
			System.out.println(document.get("id"));
		}
		
		int count = hitCount(indexSearcher, query);
		
		indexSearcher.close();
		return count;
	}
	
	private int hitCount(IndexSearcher indexSearcher,Query query) throws IOException{
		return indexSearcher.search(query, 1).totalHits;
	}
	
	public void testIndexWriter(){
		try {
			IndexWriter indexWriter = getWriter();
			assertEquals(ids.length, indexWriter.numDocs());
			indexWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testIndexReader(){
		try {
			IndexReader indexReader = IndexReader.open(directory);
			assertEquals(ids.length, indexReader.maxDoc());
			assertEquals(ids.length, indexReader.numDocs());
			indexReader.clone();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRAMDirectory() throws IOException{
		getHitCount("id", "1");
	}
}
