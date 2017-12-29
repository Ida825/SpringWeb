package cn.et.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.web.bean.News;
import cn.et.web.dao.NewsDao;
import cn.et.web.tools.PageTools;

/**
 * 数据层
 * @author sunying 18919890415@sina.cn
 *
 */
@Repository
public class NewsDaoImpl implements NewsDao{

	/**
	 * （在实现类，根据模板类JdbcTemplate连接到数据库）
	 * 自动装配
	 */
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public List<News> queryAll() {
		String sql = "select newid,title,content from mynews";
		List<News> list = jdbc.query(sql, new BeanPropertyRowMapper<News>(News.class));		
		return list;
	}

	public Integer getNewsListCount() {
		String sql = "select count(newid) as cr from mynews";
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		System.out.println(list);
		return Integer.parseInt(list.get(0).get("cr").toString());
	}

	public PageTools getNewsListPage(Integer curPage,String content,String title) {
		//获取数据总条数
		Integer totalCount = getNewsListCount();
		
		//获取分页参数的对象
		PageTools pt = new PageTools(curPage, totalCount,null);
		//查询出页面要显示的数据并存入集合
		String sql = "select * from mynews where content like '%"+content+"%' and title like '%"+title+"%' limit "+pt.getStartIndex()+","+pt.getEndIndex();
		List<News> list = jdbc.query(sql,new BeanPropertyRowMapper<News>(News.class));
		//将数据存入集合
		pt.setData(list);
		return pt;
	}
	
	public List<News> queryNewsByContentOrTitle(String content, String title) {
		String sql = "select newid,title,content from mynews where content like '%"+content+"%' and title like '%"+title+"%'";
		List<News> list = jdbc.query(sql, new BeanPropertyRowMapper<News>(News.class));		
		return list;
	}


	public void insertNews(String title, String content, String createtime) {
		String sql = "insert into mynews(title,content,createtime) values('"+title+"','"+content+"','"+createtime+"')";
		jdbc.batchUpdate(sql);
	}

	



}
