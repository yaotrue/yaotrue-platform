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
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2017年3月17日 下午5:38:56
 */
public class Indexer {

	private IndexWriter indexWriter;
	
	/**
	 * Creates a new instance of Indexer.
	 * @throws IOException 
	 */
	public Indexer(String indexDir) throws IOException {
		Directory directory = FSDirectory.open(new File(indexDir));
		indexWriter = new IndexWriter(directory, new StandardAnalyzer(Version.LUCENE_30), true,IndexWriter.MaxFieldLength.UNLIMITED);
	}
	
	public void close(){
		try {
			indexWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int index(String dataDir,FileFilter fileFilter) throws IOException{
		File[] files = new File(dataDir).listFiles();
		
		for (File file : files) {
			if(!file.isDirectory() && !file.isHidden() && file.exists() && file.canRead() && (fileFilter == null || fileFilter.accept(file))){
				indexFile(file);
			}
		}
		
		return indexWriter.numDocs();
	}
	
	private Document getDocument(File file) throws IOException{
		Document document = new Document();
		document.add(new Field("contents",new FileReader(file)));
		document.add(new Field("filename", file.getName(),Field.Store.YES,Field.Index.NOT_ANALYZED));
		document.add(new Field("fullpath",file.getCanonicalPath(),Field.Store.YES,Field.Index.NOT_ANALYZED));
		return document;
	}
	
	private void indexFile(File file) throws IOException{
		System.out.println("Indexing " + file.getCanonicalPath());
		Document document = getDocument(file);
		indexWriter.addDocument(document);
	}
}
