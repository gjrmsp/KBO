package com.kbo.s1.member;

public class MemberFileDTO {

	private long num;
	private String id;
	private String fileName;
	private String origineName;
	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
