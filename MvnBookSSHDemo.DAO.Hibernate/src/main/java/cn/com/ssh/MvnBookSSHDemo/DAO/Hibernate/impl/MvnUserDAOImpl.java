package cn.com.ssh.MvnBookSSHDemo.DAO.Hibernate.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ssh.MvnBookSSHDemo.DAO.IMvnUserDAO;
import cn.com.ssh.MvnBookSSHDemo.DAO.Hibernate.AbstractDAO;
import cn.com.ssh.MvnBookSSHDemo.DAO.entity.MvnUser4Hibernate;
import cn.com.ssh.MvnBookSSHDemo.Entity.MvnUser;
@Repository("userDAO")
@Transactional// 标记使用事务，为了方便DAO设置，是临时的，正式事务应该设置在服务层
//该类实现了这个类的所有持久化方法
public class MvnUserDAOImpl extends  AbstractDAO<Integer,MvnUser4Hibernate> implements IMvnUserDAO{
	public MvnUser findUserById(int id) {
		return super.getByKey(id);
	}
    
	public void addUser(MvnUser user) {
		MvnUser4Hibernate u = this.convertToMvnUser4Hibernate(user);
		super.persist(u);
	}
	
	public void update(MvnUser user) {
		MvnUser4Hibernate u = this.convertToMvnUser4Hibernate(user);
		super.update(u);
	}
	
	public void deleteUser(MvnUser user) {
		MvnUser4Hibernate u = this.convertToMvnUser4Hibernate(user);
		super.delete(u);
	}
    
	public MvnUser findUserByUserName(String userName) {
		Criteria criteria = super.createEntityCriteria();
		criteria.add(Restrictions.eq("urUserName", userName));
		return (MvnUser)criteria.uniqueResult();
	}
	public List<MvnUser> findUsers() {
		Criteria criteria = super.createEntityCriteria();
		return criteria.list();
	}
	
    private 	MvnUser4Hibernate  convertToMvnUser4Hibernate(MvnUser user) {
    	   MvnUser4Hibernate u = (MvnUser4Hibernate) this.findUserById(user.getUrId());
    	// 这里不要轻易new一个同已经存在的一样的对象，否则会抛
   		//org.hibernate.NonUniqueObjectException: 
   		//a different object with the same identifier value was
   		//already associated withthe session异常
    	   if(u==null) {
    		   u=new MvnUser4Hibernate();
    		   u.setUrId(user.getUrId());
    	   }
    	      u.setUrAge(user.getUrAge());
    	      u.setUrPassWord(user.getUrPassWord());
    	      u.setUrStatus(user.getUrStatus());
    	      u.setUrUserName(user.getUrUserName());
    	   return u;
    }
}
