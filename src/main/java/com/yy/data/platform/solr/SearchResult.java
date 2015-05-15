package com.yy.data.platform.solr;

import java.util.List;

public class SearchResult<T> {

	private long hitSize;
	
	private List<T> resultList;

	public SearchResult(long hitSize,List<T> resultList){
		this.hitSize = hitSize;
		this.resultList = resultList;
	}
	
	public long getHitSize() {
		return hitSize;
	}

	public void setHitSize(long hitSize) {
		this.hitSize = hitSize;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	
	
}
