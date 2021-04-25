package com.kbo.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbo.s1.board.BoardDAO;
import com.kbo.s1.board.BoardDTO;
import com.kbo.s1.board.BoardFileDTO;
import com.kbo.s1.util.Pager;
import com.kbo.s1.util.Pager_BackUp;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kbo.s1.board.notice.NoticeDAO.";

	public BoardFileDTO getFileSelect(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getFileSelect", boardFileDTO);
	}
	public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setFileDelete", boardFileDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}

	@Override
	public long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect", boardDTO);
	}

	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setHitUpdate", boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
	}

	public long getNum() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getNum");
	}

	public int setFileInsert(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setFileInsert", boardFileDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	
}