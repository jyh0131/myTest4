package article.model;

public class ArticleContent {

	private int number;
	private String content;

	public ArticleContent(int number, String content) {
		this.number = number;
		this.content = content;
	}

	public int getNumber() {
		return number;
	}

	public String getContent() {
		return content;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
