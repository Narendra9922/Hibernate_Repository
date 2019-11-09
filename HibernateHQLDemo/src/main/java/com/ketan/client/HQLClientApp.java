package com.ketan.client;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ketan.DO.StudentDO;
import com.ketan.utility.HibernateUtil;

public class HQLClientApp {

	public static void main(String[] args) {
		// Get Session
		Session ses = HibernateUtil.getSession();
		
		//Create Query object representing HQL
		Query query = ses.createQuery("from StudentDO");
		
		//execute HQL
		List<StudentDO> list = query.list();
		for(StudentDO s : list) {
			System.out.println(s);
		}
		

		//Executing HQL qurey with Positional param(?)
		Query query1 = ses.createQuery("from StudentDO where marks > ?0");
		query1.setInteger(0, 70);
		List<StudentDO> list1 = query1.list();
		for(StudentDO s : list1) {
			System.out.println(s);
		}
		
		
		//Executing HQL qurey with Named param(?)
				Query query2 = ses.createQuery("from StudentDO where marks > :min");
				query2.setInteger("min", 80);
				Iterator<StudentDO> itr = query2.iterate();			
				while(itr.hasNext())
				{
					//StudentDO s = itr.next();
					System.out.println(itr.next());
				}
				
		//Retriving Specific coulunm values of Database		
		Query query4 = ses.createQuery("select rollno, sname, scity from StudentDO");
		List<Object[]> list4 = query4.list();
		for(Object[] row : list4) {
			{
				for(Object value : row) {
					System.out.println(value);
					
				}
			}
			
		}
		
		
		//Named Query
		Query Namedq = ses.createNamedQuery("ALL_STUDENT", StudentDO.class);
		Namedq.setString("name", "narendra");
		List<StudentDO> NamedList = Namedq.list();
		for(StudentDO s : NamedList) {
			System.out.println(s);
		}
	}

}
