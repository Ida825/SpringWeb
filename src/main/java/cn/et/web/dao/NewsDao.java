package cn.et.web.dao;

import java.util.List;

import cn.et.web.bean.News;
import cn.et.web.tools.PageTools;


public interface NewsDao {
	/**
	 * 查询所有的新闻（只会查前100条）
	 * @return
	 */
	public List<News> queryAll();
	
	/**
	 * 返回查询到的数据总数
	 * @return
	 */
	public Integer getNewsListCount();
	
	/**
	 * 获取分页参数
	 * @param curPage
	 * @return
	 */
	public PageTools getNewsListPage(Integer curPage,String content,String title);
	
	/**
	 * 根据内容或标题模糊查询所有新闻
	 * @param content 新闻内容
	 * @return 所有新闻列表
	 */
	public List<News> queryNewsByContentOrTitle(String content,String title);
		
	
	/**
	 * 添加新闻
	 * @param title 新闻标题
	 * @param content 新闻内容
	 * @param createtime 新闻创建时间
	 */
	public void insertNews(String title,String content,String createtime);
		

}
