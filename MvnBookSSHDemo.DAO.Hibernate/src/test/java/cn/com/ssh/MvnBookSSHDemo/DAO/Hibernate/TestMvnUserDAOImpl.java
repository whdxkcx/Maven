package cn.com.ssh.MvnBookSSHDemo.DAO.Hibernate;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import cn.com.ssh.MvnBookSSHDemo.DAO.IMvnUserDAO;
import cn.com.ssh.MvnBookSSHDemo.Entity.MvnUser;
import cn.com.ssh.MvnBookSSHDemo.Entity.Status;
import junit.framework.Assert;


public class TestMvnUserDAOImpl {
	private IMvnUserDAO userDAO;
	private ApplicationContext ctx = null;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDAO = (IMvnUserDAO)this.ctx.getBean("userDAO");
//		userDAO = (IMvnUserDAO) this.ctx.getBean(MvnUserDAOImpl.class);
	}
	@Test
	public void testAddUser(){
		MvnUser user= new MvnUser();
		user.setUrAge(11);
		user.setUrPassWord("11");
		user.setUrStatus(Status.ACTIVE.getStatus());
		user.setUrUserName("userName11");
		this.userDAO.addUser(user);
		
		MvnUser u = this.userDAO.findUserByUserName("userName11");
		Assert.assertTrue(u != null && u.getUrAge()==11);
		this.userDAO.deleteUser(u);
	}
	@Test
	public void testFindUserById(){
		MvnUser user = this.userDAO.findUserById(1);
		System.out.println(user.getUrAge()+":"+user.getUrUserName());
		Assert.assertEquals("zhangsan", user.getUrUserName());
	}
	@Test
	public void testUpdate(){
		MvnUser user = this.userDAO.findUserById(1);
		user.setUrAge(100);
		this.userDAO.update(user);
		user = this.userDAO.findUserById(1);
		Assert.assertEquals(100, user.getUrAge());
	}
	@After
	public void destory(){
		this.userDAO = null;
		this.ctx = null;
	}
}
