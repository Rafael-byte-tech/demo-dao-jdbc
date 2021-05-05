package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramB {

	public static void main(String[] args) {
		// TEST PROGRAM
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		/*
		System.out.println("===== TEST 1: department insert =====");
		Department newDepartment = new Department(null, "Department2");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted. New Id = " + newDepartment.getId());
		*/
		
		System.out.println("===== TEST 2: find department by id =====");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("===== TEST 3: update department");
		department = departmentDao.findById(6);
		department.setName("Department3");
		departmentDao.update(department);
		System.out.println("update completed");
	}

}
