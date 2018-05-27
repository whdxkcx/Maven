package cn.com.ssh.MvnBookSSHDemo.DAO.Hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public  abstract  class AbstractDAO <PK extends Serializable,T>{
	   private final Class<T> persistentClass;
	   @SuppressWarnings("unchecked")
	    public AbstractDAO(){
	        this.persistentClass =(Class<T>) (
	        		(ParameterizedType) this.getClass().getGenericSuperclass()
	        		).getActualTypeArguments()[1];
	    }
	   
	   @Autowired
	    private SessionFactory sessionFactory;
	   
	   
	   //通过hibernate的session工程获取session实例
	   protected Session getSession() {
		   return sessionFactory.getCurrentSession();
	   }
	   
	   //获取session保存的值
	   @SuppressWarnings("unchecked")
	   public T  getByKey(PK key) {
            return (T) getSession().get(persistentClass, key);
	   }
	   
	   //持久化实体
	   public void persist(T entity) {
	        getSession().persist(entity);
	    }
	   
	   //删除实体
	   public void delete(T entity) {
	        getSession().delete(entity);
	    }
	   
	   //更新实体
	   public void update(T entity){
	    	getSession().merge(entity);
	    }
	   
	   //查询所有的数据
	   public List<T> findAll(){
	    	Criteria cri = this.createEntityCriteria();
	    	cri.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//消除重复对象
	    	return cri.list();
	    }
	   
	   protected Criteria createEntityCriteria(){
	        return getSession().createCriteria(persistentClass);
	    }
}
	   
	   
