package org.fabrelab.pagekit;

public class PageInfo {

	Integer pageStart;
	
	Integer pageSize = 10;
	
	public Integer getPageStart() {
		return pageStart;
	}
	
	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getPageEnd() {
		return pageSize+pageStart;
	}
	
	public Integer nextPageStart() {
		return pageSize+pageStart;
	}
	
	public Integer prevPageStart() {
		return pageStart-pageSize;
	}
}
