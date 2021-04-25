package com.kbo.s1.news;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kbo.s1.board.BoardDTO;
import com.kbo.s1.board.BoardFileDTO;
import com.kbo.s1.board.BoardService;
import com.kbo.s1.util.FileManager;
import com.kbo.s1.util.Pager;
import com.kbo.s1.util.Pager_BackUp;

@Service
public class NewsService implements BoardService {

	@Autowired
	private NewsDAO newsDAO;

	@Autowired
	private FileManager fileManager;

	@Autowired
	private HttpSession session;

	public boolean setSummerFileDelete(String fileName) throws Exception {
		boolean result = fileManager.delete("news", fileName, session);
		return result;
	}

	public String setSummerFileUpload(MultipartFile file) throws Exception {
		String fileName = fileManager.save("news", file, session);
		return fileName;
	}

	public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception {
		//fileName을 print
		//1. 조회
		boardFileDTO = newsDAO.getFileSelect(boardFileDTO);
		//2. table 삭제
		int result = newsDAO.setFileDelete(boardFileDTO);
		//3. HDD 삭제
		if(result > 0) {
			fileManager.delete("news", boardFileDTO.getFileName(), session);
		}
		return result;
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		return newsDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		long num = newsDAO.getNum();
		boardDTO.setNum(num);
		int result = newsDAO.setInsert(boardDTO);

		//글번호 찾기
		for(MultipartFile mf : files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			String fileName= fileManager.save("news", mf, session);

			boardFileDTO.setNum(num);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOrigineName(mf.getOriginalFilename());
			newsDAO.setFileInsert(boardFileDTO);
		}
		return result; //newsDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		for(MultipartFile multipartFile:files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			//1. File들을 HDD에 저장
			String fileName= fileManager.save("news", multipartFile, session);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOrigineName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			//2. DB에 Insert
			newsDAO.setFileInsert(boardFileDTO);
		}
		return newsDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return newsDAO.setDelete(boardDTO);
	}

	public List<BoardDTO> getList(Pager pager) throws Exception {
		// ---- startRow, lastRow ----
		pager.makeRow();

		// ---- 페이징 계산 -------------
		long totalCount = newsDAO.getTotalCount(pager);
		pager.makeNum(totalCount);

		return newsDAO.getList(pager);
	}

}
