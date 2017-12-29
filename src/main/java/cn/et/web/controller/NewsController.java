package cn.et.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.et.web.bean.News;
import cn.et.web.service.NewsService;
import cn.et.web.tools.PageTools;

/**
 * Servlet implementation class NewsController
 */
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡ����
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//�������л�ȡservice
		NewsService ns = (NewsService)context.getBean("newsServiceImpl");
		
		String myContent = request.getParameter("myContent");
		String myTitle = request.getParameter("myTitle");
	
		System.out.println(myContent+"----"+myTitle);
		//��ȡ��ѯ������
		List<News> queryByContentOrTitle = ns.queryNewsByContentOrTitle(myContent,myTitle);
		
		//����ѯ�����������������
		request.setAttribute("queryByContentOrTitle",queryByContentOrTitle);	
		
		request.setAttribute("myContent", myContent);
		request.setAttribute("myTitle", myTitle);
		//��ȡ��ǰҳ����
		String curPage = request.getParameter("curPage");
		Integer curPageVar = 1;
		if(curPage!=null){
			curPageVar = Integer.parseInt(curPage);
		}		
		
		//��ȡ��ҳ����
		PageTools pt = ns.getNewsListPage(curPageVar,myContent,myTitle);
		
		//�����ݴ���request������
		request.setAttribute("pt", pt);
		//����ת��������㣨��el���ʽ��request����������ݻ�ȡ������
		request.getRequestDispatcher("/news.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
