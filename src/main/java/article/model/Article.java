package article.model;

import java.util.Date;

public class Article {
	private int number;
	private String id;
	private String name;
	private String title;
	private Date regDate;
	private Date modifiedDate;
	private int readCount;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	public Article(int number, String id, String name, String title, Date regDate, Date modifiedDate, int readCount) {	
		this.number = number;
		this.id = id;
		this.name = name;
		this.title = title;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "Article [number=" + number + ", id=" + id + ", name=" + name + ", title=" + title + ", regDate="
				+ regDate + ", modifiedDate=" + modifiedDate + ", readCount=" + readCount + "]";
	}	
	
	
}
