package article.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.util.JdbcUtil;

public class ArticleContentDao {
	private static final ArticleContentDao dao = new ArticleContentDao();
	
	public static ArticleContentDao getInstance(){
		return dao;
	}
	
	private ArticleContentDao(){		
	}
	
	public int insert(Connection conn, ArticleContent content) throws SQLException{
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into article_content (article_no, content) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int result = pstmt.executeUpdate();
			if(result > 0){
				return content.getNumber();
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
		return -1;
	}
	
	public ArticleContent selectById(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from article_content where article_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ArticleContent article = null; 
			if(rs.next()){
				article =  new ArticleContent(	
								rs.getInt("article_no"),
								rs.getString("content")
							);
			}
			return article;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);			
		}
	}
}















