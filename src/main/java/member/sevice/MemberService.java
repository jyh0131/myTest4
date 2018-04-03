package member.sevice;


import org.apache.ibatis.session.SqlSession;

import member.model.Member;
import member.model.MemberDao;
import mvc.util.MySqlSessionFactory;

public class MemberService {
	private static final MemberService instance = new MemberService();
	
	public static MemberService getInstance(){
		return instance;
	}
	
	private MemberService() {
		// TODO Auto-generated constructor stub
	}
	
	
	// -2 : duplicatedId
	public int insertMember(Member member){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);			
			
			//id 중복 체크
			Member existMember = dao.selectById(member.getId());
			if(existMember != null){
				return -2;
			}
			
			dao.insert(member);
			session.commit();
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}
		
		return -1;		
	}
}













