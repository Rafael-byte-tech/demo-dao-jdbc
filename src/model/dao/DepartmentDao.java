package model.dao;

import java.util.List; 

import model.entities.Department;

public interface DepartmentDao {
	//CLASS ACCESS DATA OF THE DEPARTMENT ENTITIE
	
	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
}