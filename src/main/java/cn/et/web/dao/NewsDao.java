package cn.et.web.dao;

import java.util.List;

import cn.et.web.bean.News;
import cn.et.web.tools.PageTools;


public interface NewsDao {
	/**
	 * ��ѯ���е����ţ�ֻ���ǰ100����
	 * @return
	 */
	public List<News> queryAll();
	
	/**
	 * ���ز�ѯ������������
	 * @return
	 */
	public Integer getNewsListCount();
	
	/**
	 * ��ȡ��ҳ����
	 * @param curPage
	 * @return
	 */
	public PageTools getNewsListPage(Integer curPage,String content,String title);
	
	/**
	 * �������ݻ����ģ����ѯ��������
	 * @param content ��������
	 * @return ���������б�
	 */
	public List<News> queryNewsByContentOrTitle(String content,String title);
		
	
	/**
	 * �������
	 * @param title ���ű���
	 * @param content ��������
	 * @param createtime ���Ŵ���ʱ��
	 */
	public void insertNews(String title,String content,String createtime);
		

}
