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
package com.yaotrue.base.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2018年3月6日 下午6:17:47
 */
public class NioTest {

	@Test
	public void testNio(){
		FileInputStream fin;
		try {
			fin = new FileInputStream( "D://123.txt" );
			FileChannel fc = fin.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate( 1024 );
			fc.read( buffer );
			buffer.flip();

		    int i=0;
		    while (buffer.remaining()>0) {
		      byte b = buffer.get();
		      System.out.println( "Character "+i+": "+((char)b) );
		      i++;
		    }

		    fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
