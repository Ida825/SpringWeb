<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
	<title>新闻</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body >
	<form action="listNews" method="get">
		内容：<input type="text" name="myContent" value="${param.myContent }"/>
		标题：<input type="text" name="myTitle" value="${param.myTitle }"/>
		<input type="submit" value="查询"/>
	</form>
	<table border=1>
		<tr>
			<th>新闻编号</th>
			<td>新闻标题</td>
			<td>新闻内容</td>
		</tr>
		<c:forEach var="newslist" items="${requestScope.pt.data}">
			<tr>
				<td>${pageScope.newslist.newid }</td>
				<td>${pageScope.newslist.title }</td>
				<td>${pageScope.newslist.content }</td>
			</tr>
		</c:forEach>	
		
		<tr>
			<td colspan="5">
				<a href="${pageContext.request.contextPath}/listNews?curPage=1">首页</a>
				<a href="${pageContext.request.contextPath}/listNews?curPage=${requestScope.pt.prePage}">上页</a>
				<c:forEach var="i" begin="1" end="${requestScope.pt.totalPage}">
					<a href="${pageContext.request.contextPath}/listNews?curPage=${pageScope.i}">${pageScope.i}</a>
				</c:forEach>
				<a href="${pageContext.request.contextPath}/listNews?curPage=${requestScope.pt.nextPage}">下页</a>
				<a href="${pageContext.request.contextPath}/listNews?curPage=${requestScope.pt.totalPage}">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>