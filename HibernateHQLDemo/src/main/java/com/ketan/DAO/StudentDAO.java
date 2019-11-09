package com.ketan.DAO;

import com.ketan.DO.StudentDO;

public interface StudentDAO{
	public int saveStudentInfo(StudentDO s);
	public StudentDO getStudent(int srollno);
	public int updateStuentInfo(int srollno, int smarks , char sgrade);
}
