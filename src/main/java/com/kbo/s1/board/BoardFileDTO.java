package com.kbo.s1.board;

public class BoardFileDTO {

	private long fileNum;
	private long num;
	private String fileName;
	private String origineName;
	
	public long getFileNum() {
		return fileNum;
	}
	public void setFileNum(long fileNum) {
		this.fileNum = fileNum;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOrigineName() {
		return origineName;
	}
	public void setOrigineName(String origineName) {
		this.origineName = origineName;
	}
}
