package com.kbo.s1.rank;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class RankDAO {
	
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.kbo.s1.rank.RankDAO.";
	
	public List<RankDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public RankDTO getSelect(RankDTO rankDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect", rankDTO);
	}
	
	public int setInsert(RankDTO rankDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", rankDTO);
	}

	public int setUpdate(RankDTO rankDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", rankDTO);
	}
	
	public int setDelete(RankDTO rankDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", rankDTO);
	}
	
}
