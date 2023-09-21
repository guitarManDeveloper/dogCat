package kr.co.th.dogCat.adopt.vo;

public class AdoptVO extends Adopt {
	private String viewType = "list";
	private int pageSize = 10;
	private int offset;
	private int page = 1;
	private String hitOrder; //조회순정렬값
	private String searchContentAt = "N"; //
	private String searchStartDate = ""; //
	private String searchEndDate = ""; //
	
	
	
	
	
	
	
	public String getSearchEndDate() {
		return searchEndDate;
	}
	public void setSearchEndDate(String searchEndDate) {
		this.searchEndDate = searchEndDate;
	}
	public String getSearchStartDate() {
		return searchStartDate;
	}
	public void setSearchStartDate(String searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	public String getSearchContentAt() {
		return searchContentAt;
	}
	public void setSearchContentAt(String searchContentAt) {
		this.searchContentAt = searchContentAt;
	}
	public String getHitOrder() {
		return hitOrder;
	}
	public void setHitOrder(String hitOrder) {
		this.hitOrder = hitOrder;
	}
	public String getViewType() {
		return viewType;
	}
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getOffset() {
		int offset = (page-1)*pageSize;
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
