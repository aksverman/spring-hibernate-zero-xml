package com.rudra.aks.test;

import org.hibernate.FlushMode;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rudra.aks.AppConfiguration;
import com.rudra.aks.bo.TestBO;

public class HibernateTest {

	/*@Autowired
	static
	HibernateTemplate	hibernateTemplate;*/
	
	@Transactional //( propagation = Propagation.REQUIRED, readOnly = false)
	public static void main(String[] args) {
		 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class, TestBO.class);
	        
	        
	     HibernateTemplate template = ctx.getBean(HibernateTemplate.class);
	     /*FlushMode flushMode = FlushMode.AUTO; 
		template.getSessionFactory().getCurrentSession().setFlushMode(flushMode);*/
	     int id = 1;
	     TestBO testbo = template.load(TestBO.class, id);
	     
	     TestBO testtoinsert = new TestBO();
	     testtoinsert.setAddress("address");
	     int newid = (int) template.save(testbo);
	     System.out.println(newid);
	}

}
