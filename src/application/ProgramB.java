package application;

import java.util.List; 
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramB {

	public static void main(String[] args) {
		// TEST PROGRAM
		Scanner sc = new Scanner(System.in);
		Integer id;
		String name;
		List<Department> list;
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();	//DATA ACCESS OBJECT
		
		System.out.println("===== TEST 1: department insertion =====");
		System.out.print("Insert department name for insertion test: ");
		name = sc.next();
		Department newDepartment = new Department(null, name);
		departmentDao.insert(newDepartment);
		System.out.println("Inserted. New Id = " + newDepartment.getId());		
		
		System.out.println("===== TEST 2: find department by id =====");
		System.out.print("Insert Id to find department: ");
		id = sc.nextInt();
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("===== TEST 3: department update");
		System.out.print("Insert Id for update test: ");
		id = sc.nextInt();
		department = departmentDao.findById(id);
		System.out.print("Insert name: ");
		name = sc.next();
		department.setName(name);
		departmentDao.update(department);
		System.out.println("update completed");
		
		System.out.println("===== TEST 4: department deletion");
		System.out.print("Enter Id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deletion completed");
		
		System.out.println("===== TEST 5: department find all");
		list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		sc.close();
	}

}
