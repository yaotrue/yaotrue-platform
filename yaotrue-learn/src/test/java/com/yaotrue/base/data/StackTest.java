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
package com.yaotrue.base.data;

import java.util.Stack;

import org.junit.Test;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2018年4月15日 下午5:58:32
 */
public class StackTest {

	@Test
	public void testStack(){
		Stack<Integer> numStack = new Stack<>();
		numStack.push(2);
		numStack.push(3);
		numStack.push(1);
		
		System.out.println(numStack.toString());
		
		System.out.println(numStack.peek());
		
		System.out.println(numStack.toString());
		
		System.out.println(numStack.pop());
		
		System.out.println(numStack.toString());
		
		System.out.println(numStack.firstElement());
		
		System.out.println(numStack.size());
	}
}
