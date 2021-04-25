package com.kbo.s1.news;

import java.util.List;

import com.kbo.s1.board.BoardDTO;
import com.kbo.s1.board.BoardFileDTO;

public class NewsDTO extends BoardDTO {
	
	private List<BoardFileDTO> boardFiles;

	public List<BoardFileDTO> getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(List<BoardFileDTO> boardFiles) {
		this.boardFiles = boardFiles;
	}

}
