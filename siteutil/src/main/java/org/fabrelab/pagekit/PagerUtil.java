package org.fabrelab.pagekit;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class PagerUtil {
	
	public static PageInfo buildPageInfo(HttpServletRequest request) {
		Integer pageStart = MappingUtil.parseInt(request, "pageStart");
		Integer pageSize = MappingUtil.parseInt(request, "pageSize");
		PageInfo pageInfo = new PageInfo();
		if(pageStart==null){
			pageStart=0;
		}
		if(pageSize==null){
			pageSize=10;
		}
		pageInfo.setPageSize(pageSize);
		pageInfo.setPageStart(pageStart);
		return pageInfo;
	}

	public static void setPageModel(PageInfo pageInfo, Map<String, Object> model, int thisPageSize) {
		model.put("pageStart", pageInfo.getPageStart());
		model.put("pageSize", pageInfo.getPageSize());
		model.put("nextPageStart", pageInfo.nextPageStart());
		model.put("prevPageStart", pageInfo.prevPageStart());
		model.put("hasPrev", true);
		model.put("hasNext", true);
		if(pageInfo.getPageStart().equals(0)){
			model.put("hasPrev", false);
		}
		if(pageInfo.prevPageStart()<0){
			model.put("prevPageStart", 0);
		}
		if(thisPageSize<pageInfo.getPageSize()){
			model.put("hasNext", false);
		}
	}

}
