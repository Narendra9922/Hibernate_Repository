package com.ketan.DAO;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ketan.DO.StudentDO;
import com.ketan.utility.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {

	public int saveStudentInfo(StudentDO s) {
		Transaction tx = null;
		Session ses = null;
		int id = 0;
		ses = HibernateUtil.getSession();
		
		try {
			tx = ses.beginTransaction();
			id = (Integer) ses.save(s);
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		HibernateUtil.closeSession(ses);
		return id;
	}

	public StudentDO getStudent(int srollno) {
		Transaction tx = null;
		Session ses = null;
		StudentDO student = null;
		ses = HibernateUtil.getSession();
		try {
				tx = ses.beginTransaction();
				student = (StudentDO) ses.get(StudentDO.class, srollno);
				tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}	
		HibernateUtil.closeSession(ses);	
		return student;
	}

	public int updateStuentInfo(int srollno, int smarks, char sgrade) {
		Transaction tx = null;
		Session ses = null;
		ses = HibernateUtil.getSession();
		StudentDO student = null;
		Timestamp updt_tmsp = new Timestamp(new Date().getTime());
		student = (StudentDO) ses.get(StudentDO.class, srollno);
		if(student != null) {
			try {
				tx = ses.beginTransaction();
				student.setSmarks(smarks);
				student.setSgrade(sgrade);
				student.setUpdt_dt(updt_tmsp);
				ses.update(student);
				tx.commit();
				HibernateUtil.closeSession(ses);
				return 1;
			}catch (Exception e) {
				tx.rollback();
				return 0;
			}
		}else {
			HibernateUtil.closeSession(ses);
			return 0;
		}
	}

}
