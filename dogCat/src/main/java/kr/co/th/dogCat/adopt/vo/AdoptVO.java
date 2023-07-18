package kr.co.th.dogCat.adopt.vo;

public class AdoptVO extends Adopt {
	private String viewType = "list";
	private int pageSize = 10;
	private int offset;
	private int page = 1;
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
