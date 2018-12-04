/**
 * Copyright (c) 2012 YaoTrue All Rights Reserved.
 *
 * This software is the confidential and proprietary information of YaoTrue.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with YaoTrue.
 *
 * YaoTrue MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. YaoTrue SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.yaotrue.manager;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.springframework.core.task.AsyncTaskExecutor;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年11月17日 下午2:25:10
 */
public class CustomerAsyncTaskExecutor implements AsyncTaskExecutor {
	
	private AsyncTaskExecutor executor;
	
	/**
	 * Creates a new instance of CustomerAsyncTaskExecutor.
	 */
	public CustomerAsyncTaskExecutor(AsyncTaskExecutor executor) {
		this.executor = executor;
	}
	
	private <T> Callable<T> createCallable(final Callable<T> task) {
		return new Callable<T>() {
			public T call() throws Exception {
				try {
					return task.call();
				} catch (Exception ex) {
					handle(ex);
					throw ex;
				}
			}
		};
	}

	private Runnable createWrappedRunnable(final Runnable task) {
		return new Runnable() {
			public void run() {
				try {
					task.run();
				} catch (Exception ex) {
					handle(ex);
				}
			}
		};
	}

	private void handle(Exception ex) {
		// 具体的异常逻辑处理的地方
		System.err.println("Error during @Async execution: " + ex);
	}

	/* (non-Javadoc)
	 * @see org.springframework.core.task.TaskExecutor#execute(java.lang.Runnable)
	 */
	@Override
	public void execute(Runnable task) {
		//用独立的线程来包装，@Async其本质就是如此 
		executor.execute(createWrappedRunnable(task));
	}

	/* (non-Javadoc)
	 * @see org.springframework.core.task.AsyncTaskExecutor#execute(java.lang.Runnable, long)
	 */
	@Override
	public void execute(Runnable task, long startTimeout) {
		executor.execute(createWrappedRunnable(task), startTimeout);
	}

	/* (non-Javadoc)
	 * @see org.springframework.core.task.AsyncTaskExecutor#submit(java.lang.Runnable)
	 */
	@Override
	public Future<?> submit(Runnable task) {
		return executor.submit(createWrappedRunnable(task));
	}

	/* (non-Javadoc)
	 * @see org.springframework.core.task.AsyncTaskExecutor#submit(java.util.concurrent.Callable)
	 */
	@Override
	public <T> Future<T> submit(Callable<T> task) {
		return executor.submit(createCallable(task));
	}

}
