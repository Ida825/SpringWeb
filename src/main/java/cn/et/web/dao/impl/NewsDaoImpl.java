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
 * ���ݲ�
 * @author sunying 18919890415@sina.cn
 *
 */
@Repository
public class NewsDaoImpl implements NewsDao{

	/**
	 * ����ʵ���࣬����ģ����JdbcTemplate���ӵ����ݿ⣩
	 * �Զ�װ��
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
		//��ȡ����������
		Integer totalCount = getNewsListCount();
		
		//��ȡ��ҳ�����Ķ���
		PageTools pt = new PageTools(curPage, totalCount,null);
		//��ѯ��ҳ��Ҫ��ʾ�����ݲ����뼯��
		String sql = "select * from mynews where content like '%"+content+"%' and title like '%"+title+"%' limit "+pt.getStartIndex()+","+pt.getEndIndex();
		List<News> list = jdbc.query(sql,new BeanPropertyRowMapper<News>(News.class));
		//�����ݴ��뼯��
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
