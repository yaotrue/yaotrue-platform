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
package com.yaotrue.framework.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2018年4月24日 上午7:15:02
 */
public class ZookeeperTest {

	@Test
	public void testZookeeperRead() throws IOException {
		ZooKeeper zooKeeper = new ZooKeeper("localhost:2181,localhost:2182,localhost:2183", 5000, new MyWatcher());
	}
}
