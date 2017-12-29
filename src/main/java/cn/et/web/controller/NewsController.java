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
		
		//获取容器
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//从容器中获取service
		NewsService ns = (NewsService)context.getBean("newsServiceImpl");
		
		String myContent = request.getParameter("myContent");
		String myTitle = request.getParameter("myTitle");
	
		System.out.println(myContent+"----"+myTitle);
		//获取查询的数据
		List<News> queryByContentOrTitle = ns.queryNewsByContentOrTitle(myContent,myTitle);
		
		//将查询到的数据设进作用域
		request.setAttribute("queryByContentOrTitle",queryByContentOrTitle);	
		
		request.setAttribute("myContent", myContent);
		request.setAttribute("myTitle", myTitle);
		//获取当前页参数
		String curPage = request.getParameter("curPage");
		Integer curPageVar = 1;
		if(curPage!=null){
			curPageVar = Integer.parseInt(curPage);
		}		
		
		//获取分页数据
		PageTools pt = ns.getNewsListPage(curPageVar,myContent,myTitle);
		
		//将数据存入request请求域
		request.setAttribute("pt", pt);
		//请求转发到界面层（用el表达式将request作用域的数据获取出来）
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
