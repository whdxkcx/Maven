package cn.com.ssh.MvnBookSSHDemo.Entity;

public class MvnUser {
     private int urId;
     private String urUserName;
     private String urPassWord;
     private int urAge;
     private String urStatus=Status.ACTIVE.getStatus();//Active
	public int getUrId() {
		return urId;
	}
	public void setUrId(int urId) {
		this.urId = urId;
	}
	public String getUrUserName() {
		return urUserName;
	}
	public void setUrUserName(String urUserName) {
		this.urUserName = urUserName;
	}
	public String getUrPassWord() {
		return urPassWord;
	}
	public void setUrPassWord(String urPassWord) {
		this.urPassWord = urPassWord;
	}
	public int getUrAge() {
		return urAge;
	}
	public void setUrAge(int urAge) {
		this.urAge = urAge;
	}
	public String getUrStatus() {
		return urStatus;
	}
	public void setUrStatus(String urStatus) {
		this.urStatus = urStatus;
	}
    
}
