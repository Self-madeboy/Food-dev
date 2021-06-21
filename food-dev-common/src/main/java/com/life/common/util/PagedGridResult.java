package com.life.common.util;

import lombok.Data;

import java.util.List;

/**
 * 
 * @author 17382
 * @Title: PagedGridResult.java
 * @Description: 用来返回分页Grid的数据格式
 * Copyright: Copyright (c) 2019
 */
@Data

public class PagedGridResult {
	/**
	 * 当前页数
	 */
	private int page;
	/**
	 *  总页数
	 */
	private int total;
	/**
	 * 总记录数
	 */

	private long records;
	/**
	 * 每行显示的内容
	 */
	private List<?> rows;

}
