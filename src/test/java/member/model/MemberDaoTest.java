package member.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import mvc.util.MySqlSessionFactory;

public class MemberDaoTest {

	//@Test
	public void testInsert(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();			
			MemberDao dao = session.getMapper(MemberDao.class);
			
			Member mem = new Member("test", "이쁘니","111", new Date());
			dao.insert(mem);
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}				
	}
	
	@Test
	public void testListAll(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();			
			MemberDao dao = session.getMapper(MemberDao.class);
			
			List<Member> list = dao.listAll();
			if(list.size() > 0){
				for(Member member : list){
					System.out.println(member);
				}
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}
	}
}









