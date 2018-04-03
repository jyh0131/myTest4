package article.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mvc.util.JdbcUtil;

public class ArticleDao {
	private static final ArticleDao dao = new ArticleDao();
	
	public static ArticleDao getInstance(){
		return dao;
	}
	
	private ArticleDao(){		
	}
	
	public int insert(Connection conn, Article article) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "insert into article "+
						"(writer_id, writer_name, title, regdate, moddate, read_cnt)"
						+" values (?,?,?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getId());
			pstmt.setString(2, article.getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, toTimeStamp(article.getRegDate()));
			pstmt.setTimestamp(5, toTimeStamp(article.getModifiedDate()));
			int result = pstmt.executeUpdate();
			if(result > 0){
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from article");
				if(rs.next()){
					int newNo = rs.getInt(1);
					return newNo;
				}
			}
			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
		
		return -1;
	}
	
	private Timestamp toTimeStamp(Date date){
		return new Timestamp(date.getTime());
	}
	
	public List<Article> listArticle(Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from article order by article_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Article> list = new ArrayList<Article>();
			while(rs.next()){
				Article article = new Article(
									rs.getInt("article_no"),
									rs.getString("writer_id"),
									rs.getString("writer_name"),
									rs.getString("title"),
									rs.getTimestamp("regdate"),
									rs.getTimestamp("moddate"),
									rs.getInt("read_cnt")											
								);
				list.add(article);				
			}
			return list;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}		
	}
	
	public Article selectById(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 
		System.out.println("articleNum : "+no);
		try {
			String sql = "select * from article where article_no = ?";
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Article article = null; 
			if(rs.next()){
				article =  new Article(
								rs.getInt("article_no"),
								rs.getString("writer_id"),
								rs.getString("writer_name"),
								rs.getString("title"),
								rs.getTimestamp("regdate"),
								rs.getTimestamp("moddate"),
								rs.getInt("read_cnt")											
							);
			}
			return article;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);			
		}
	}
	
	
}























