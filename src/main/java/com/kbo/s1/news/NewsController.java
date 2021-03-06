package com.kbo.s1.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kbo.s1.board.BoardDTO;
import com.kbo.s1.board.BoardFileDTO;
import com.kbo.s1.util.Pager;
import com.kbo.s1.util.Pager_BackUp;

@Controller
@RequestMapping("/news/**")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@PostMapping("summerFileDelete")
	public ModelAndView setSummerFileDelete(String fileName)throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean result = newsService.setSummerFileDelete(fileName);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}

	@PostMapping("summerFileUpload")
	public ModelAndView setSummerFileUpload(MultipartFile file) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Summer File Upload");
		System.out.println(file.getOriginalFilename());
		String fileName = newsService.setSummerFileUpload(file);
		fileName = "../resources/upload/news/"+fileName;
		mv.addObject("result", fileName);
		mv.setViewName("common/ajaxResult");

		return mv;
	}

	@GetMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFileDTO boardFileDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = newsService.setFileDelete(boardFileDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@GetMapping
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = newsService.getSelect(boardDTO);
		
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "news");
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@PostMapping
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv, MultipartFile [] files) throws Exception {
		int result = newsService.setUpdate(boardDTO, files);
		
		if(result>0) {
			//???????????? ???????????? ??????
			mv.setViewName("redirect:./newsList");
		} else {
			//???????????? ?????? ?????? alert, ???????????? ??????
			mv.addObject("msg", "?????? ??????");
			mv.addObject("path", "./newsList");
			mv.setViewName("common/commonResult");
		}
		return mv;
	}
	
	@PostMapping("newsDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = newsService.setDelete(boardDTO);
		
		String message = "?????? ??????";
		String path = "./newsList";
		
		if(result>0) {
			message = "?????? ??????";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");

		return mv;
	}
	
	@GetMapping("newsSelect")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = newsService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "news");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@RequestMapping("newsInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "news");
		return mv;
	}
	
	@RequestMapping(value = "newsInsert", method = RequestMethod.POST)
	public String setInsert(BoardDTO boardDTO, Model model, MultipartFile [] files) throws Exception {
		int result = newsService.setInsert(boardDTO, files);
		
		String message="?????? ??????";
		
		if(result>0) {
			message="?????? ??????";
		}
		model.addAttribute("msg", message);
		model.addAttribute("path", "./newsList");
		
		return "common/commonResult";
	}
	
	@RequestMapping("newsList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		
		List<BoardDTO> ar = newsService.getList(pager);
		
		//List<newsDTO> ar = newsService.getList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		mv.addObject("board", "news");
		mv.addObject("pager", pager);
		return mv;
	}
}	