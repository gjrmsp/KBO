package com.kbo.s1.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.kbo.s1.member.MemberDAO.";
	
	//Join
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
	}

	//ID Check
	public int memberIdCheck(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberIdCheck", memberDTO);
	}
	
	//Login
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberDTO);
	}
	
	public MemberFileDTO memberLoginFile(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberLoginFile", memberDTO);
	}

	public MemberFileDTO getMemberFile(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getMemberFile", memberDTO);
	}
	
	//Update
	public int memberUpdate(MemberDTO memberDTO) throws Exception {	
		return sqlSession.update(NAMESPACE+"memberUpdate", memberDTO);
	}

	//Delete
	public int memberDelete(MemberDTO memberDTO) throws Exception {	
		return sqlSession.delete(NAMESPACE+"memberDelete", memberDTO);
	}

	//setFileInsert
	public int setFileInsert(MemberFileDTO memberFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setFileInsert", memberFileDTO);
	}
	
}
