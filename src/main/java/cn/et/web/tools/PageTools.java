package cn.et.web.tools;

import java.util.List;

import cn.et.web.bean.News;

public class PageTools {
	
	
	public PageTools(Integer curPage ,Integer totalCount,Integer totalPage) {
		this.curPage = curPage;
		this.pageCount = pageCount==null?10:this.pageCount;;
		this.prePage = curPage==1?1:curPage-1;
		this.nextPage = curPage==totalPage?totalPage:curPage+1;
		this.totalCount = totalCount;
		this.totalPage = totalCount%this.pageCount==0?(totalCount/this.pageCount):(totalCount/this.pageCount+1);		
		this.startIndex = (curPage-1)*this.pageCount;
		this.endIndex = this.pageCount;
	}

	/**
	 * ��ǰҳ���ɶ�̬ҳ�洫�ݣ�
	 */
	private Integer curPage;
	
	/**
	 * ÿҳ��ʾ������Ĭ��10����
	 */
	private Integer pageCount=10;
	
	/**
	 * ��һҳ��prePage=curPage==1?1:curPage-1
	 */
	private Integer prePage;
	
	
	/**
	 * ��һҳ:nextPage=curPage==totalPage?totalPage:curPage+1
	 */
	private Integer nextPage;
	
	/**
	 * ��ҳ��:totalPage=totalCount%pageCount==0?(totalCount/pageCount):(totalCount/pageCount+1)
	 */
	private Integer totalPage;
	
	/**
	 * �ܼ�¼��
	 */
	private Integer totalCount;
	
	/**
	 * ��ʼ����λ��:startIndex=(curPage-1)*pageCount
	 */
	private Integer startIndex;
	
	
	/**
	 * ��������λ��:endIndex=pageCount
	 */
	private Integer endIndex;
	
	/**
	 * �洢�鵽������
	 */
	private List<News> data;

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public List<News> getData() {
		
		
		return data;
	}

	public void setData(List<News> data) {
		this.data = data;
	}
	
	
}
