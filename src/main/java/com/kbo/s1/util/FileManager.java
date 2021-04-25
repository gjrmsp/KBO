package com.kbo.s1.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	//Save
	public String save(String name, MultipartFile multipartFile, HttpSession session) throws Exception {

		//경로 설정
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		System.out.println(path);
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}

		//저장할 파일명
		String fileName="";

		//API
		fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();

		//HDD에 저장
		file = new File(file, fileName);

		multipartFile.transferTo(file);
		return fileName;
	}

	//Delete
	public boolean delete(String name, String fileName, HttpSession session) throws Exception {

		//경로 설정
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		File file = new File(path, fileName);
		boolean check = false;
		if(file.exists()) {
			check= file.delete();
		}
		return check;
	}

	//makePath
	public File makePath(HttpSession session) throws Exception {

		//저장할 폴더 지정
		String path = session.getServletContext().getRealPath("resources/upload/member");
		System.out.println(path);

		File file = new File(path);

		if(!file.exists()) {
			file.mkdirs();
		}
		return file;
	}

}