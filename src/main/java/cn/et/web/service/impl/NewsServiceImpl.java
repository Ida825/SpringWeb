package cn.et.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.web.bean.News;
import cn.et.web.dao.NewsDao;
import cn.et.web.service.NewsService;
import cn.et.web.tools.PageTools;

/**
 * ÒµÎñÂß¼­²ã
 * @author Administrator
 *
 */
@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao dao;
	
	public List<News> queryAll() {
		
		return dao.queryAll();
	}
	
	public Integer getNewsListCount() {
		
		return dao.getNewsListCount();
	}



	public PageTools getNewsListPage(Integer curPage,String content,String title) {
		if(content==null){
			content="";
		} 
		if(title==null){
			title="";
		}

		return dao.getNewsListPage(curPage,content, title);
	}
	
	public List<News> queryNewsByContentOrTitle(String content,String title) {
		if(content==null){
			content="";
		} 
		
		if(title==null){
			title="";
		}

		
		return dao.queryNewsByContentOrTitle(content,title);
	}

	

	public void insertNews(String title, String content, String createtime) {
		dao.insertNews(title, content, createtime);
	}

}
