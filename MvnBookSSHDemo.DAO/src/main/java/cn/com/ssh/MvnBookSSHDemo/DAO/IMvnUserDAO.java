package cn.com.ssh.MvnBookSSHDemo.DAO;

import java.util.List;

import cn.com.ssh.MvnBookSSHDemo.Entity.MvnUser;

public interface IMvnUserDAO {
    //在数据中，添加一个新的MvnUser对象
	public void addUser(MvnUser user);
	
	//更新User对象，该对象中需要设置年龄、状态和id属性，属性和状态是需要更新的新值。
	public void update(MvnUser user);
	
	//删除MvnUser对象，该对象中需要又要删除对象的id属性，id为删除条件。
	public void deleteUser(MvnUser user);
	
	//根据id查询对应的MvnUser对象
	public MvnUser findUserById(int id);
	
	//根据用户名查询对应的MvnUser对象
	public MvnUser findUserByUserName(String  userName);
	
	//查找数据库中所有的用户对象，以List集合的形式返回
	public List<MvnUser>  findUsers();
}
