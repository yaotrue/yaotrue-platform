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
package com.yaotrue.command;

import java.io.Serializable;
import java.util.List;

/**
 * 分页组件
 * 
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2016年11月1日 下午2:30:16
 */
public class Pagination<T> implements Serializable {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = -1141719256648283352L;

	public Pagination() {
	}

	public Pagination(List<T> items, long count) {
		this.items = items;
		this.count = count;
	}

	public Pagination(List<T> items, long count, int currentPage, int totalPages, int start, int size) {
		this.items = items;
		this.count = count;
		this.currentPage = currentPage;
		this.totalPages = totalPages;
		this.start = start;
		this.size = size;
	}

	/** 分页数据 */
	private List<T> items;
	/** 总个数 */
	private long count;
	/** 当前页码 */
	private int currentPage;
	/** 总页数 */
	private int totalPages;
	/** 开始行数 */
	private int start;
	/** 每页行数 */
	private int size;
	/** 排序字符 */
	private String sortStr;

	/**
	 * @return the items
	 */
	public List<T> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<T> items) {
		this.items = items;
	}

	/**
	 * @return the count
	 */
	public long getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(long count) {
		this.count = count;
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages
	 *            the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the sortStr
	 */
	public String getSortStr() {
		return sortStr;
	}

	/**
	 * @param sortStr
	 *            the sortStr to set
	 */
	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}
	
	/**当前是否为第一页*/
	public boolean isFirstPage(){
		return getCurrentPage() == 1;
	}
	
	/**当前是否为最后一页*/
	public boolean isLastPage(){
		return getCurrentPage() >= getTotalPages();
	}
}
