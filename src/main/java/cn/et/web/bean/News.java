package cn.et.web.bean;

import java.util.Date;

/**
 *  µÃÂ¿‡
 * @author Administrator
 *
 */
public class News {
	private String newid;
	private String title;
	private String content;
	private Date createtime;
	private String htmlpath;
	
	public News(){
		
	}

	public News(String newid, String title, String content, Date createtime, String htmlpath) {
		super();
		this.newid = newid;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
		this.htmlpath = htmlpath;
	}

	public String getNewid() {
		return newid;
	}

	public void setNewid(String newid) {
		this.newid = newid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getHtmlpath() {
		return htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}

	
}
