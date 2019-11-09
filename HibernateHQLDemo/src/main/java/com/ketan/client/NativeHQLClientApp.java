package com.ketan.client;

import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.Query;

import com.ketan.DO.StudentDO;
import com.ketan.utility.HibernateUtil;

public class NativeHQLClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	 
	  Session ses = HibernateUtil.getSession();
	  //CallableStatement cs = null;
	  SQLQuery procCall = ses.createNativeQuery("CALL_PROC");
	 // procCall.addEntity(StudentDO.class);
	 List<StudentDO> list = procCall.list();
	 for(StudentDO s : list) {
			System.out.println(s);
		}
	}

}
