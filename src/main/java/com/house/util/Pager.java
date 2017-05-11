package com.house.util;

public class Pager {

	private Integer totalCount;// 总条数
	private Integer maxPage=1;// 最大页
	private Integer overleapLines;
	private Integer pageLines;
	private Integer page=1 ;// 当前页
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getOverleapLines() {
		if (this.page != 1) {
			overleapLines=((this.page - 1) * this.pageLines);
		}
		return overleapLines;
	}

	public void setOverleapLines(Integer overleapLines) {
		
		this.overleapLines = overleapLines;
	}

	public Integer getPageLines() {
		return pageLines;
	}

	public void setPageLines(Integer pageLines) {
		this.pageLines = pageLines;
	}

	public Integer getMaxPage() {
		double s = Math.IEEEremainder(this.totalCount, this.pageLines);
		if (s != 0) {
			maxPage = this.totalCount / this.pageLines + 1;
		} else {
			maxPage =this.totalCount / this.pageLines;
		}
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

//	public static void main(String args[]){
//	Pager pager =new Pager();
//	pager.setTotalCount(30);
//	pager.setPage(1);
//	pager.setPageLines(10);
//	System.out.println("最大页："+pager.getMaxPage());
//	pager.setTotalCount(30);
//	pager.setPage(2);
//	pager.setPageLines(10);
//	System.out.println("最大数："+pager.getOverleapLines());
//}
}