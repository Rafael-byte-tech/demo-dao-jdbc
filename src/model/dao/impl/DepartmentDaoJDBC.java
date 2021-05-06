package model.dao.impl;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	//THIS CLASS IMPLEMENTS THE DEPARTMENT DAO INTERFACE
	
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) { //DEPENDENCY
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) { // INSERT A DEPARTMENT INTO THE DB
		PreparedStatement st = null;
		//TRY BLOCK
		try {
			st = conn.prepareStatement( //SQL STATEMENT
					"INSERT INTO department "
					+ "(Name) "
					+ "VALUES "
					+ "(?)", 
					Statement.RETURN_GENERATED_KEYS); //RETURN THE ID OF THE INSERTED DEPARTMENT
			
			st.setString(1, obj.getName()); //SET DEPARTMENT NAME
			
			Integer rowsAffected = st.executeUpdate(); //RETURN THE NUMBER OF ROWS AFFECTED
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					Integer id = rs.getInt(1); //ID RECEIVES THE FIRST COLUMN COLUMN OF TABLE DEPARTMENT (ID)
					obj.setId(id); //THE OBJECT DEPARTMENT RECEIVES THE GENERATED ID
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error. No rows affected."); //EXCEPTION
			}
		}
		//CATCH BLOCK
		catch (SQLException e) {
			throw new DbException (e.getMessage()); //SQL EXCEPTION
		}
		//FINALLY BLOCK
		finally {
			DB.closeStatement(st); //CLOSE STATEMENT
		}
	}

	@Override
	public void update(Department obj) { //UPDATE A DEPARTMENT 
		
		PreparedStatement st = null; //SQL STATEMENT 
		//TRY BLOCK
		try {
			st = conn.prepareStatement(
					"UPDATE department "
					+ "SET Name = ? "
					+ "WHERE Id = ?");
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
		}
		//CATCH BLOCK
		catch(SQLException e) {
			throw new DbException(e.getMessage()); //SQL EXCEPTION
		}
		//FINALLY BLOCK
		finally {
			DB.closeStatement(st); //CLOSE STATEMENT
		}
	}

	@Override
	public void deleteById(Integer id) {
		// DELETE DEPARTMENT BY ID
		
		PreparedStatement st = null; //SQL STATEMENT
	    
		//TRY BLOCK
		try {
			st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		
		//CATCH BLOCK
		catch(SQLException e) {
			throw new DbException(e.getMessage()); //SQL EXCEPTION
		}
		
		//FINALLY BLOCK
		finally {
			DB.closeStatement(st); //CLOSE STATEMENT
		}
	}

	@Override
	public Department findById(Integer id) {
		//FIND DEPARTMENT BY ID
		PreparedStatement st = null; //SQL STATEMENT
		ResultSet rs = null; //DISPLAY DATA
		
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department "
					+ "WHERE department.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery(); 
			
			if (rs.next()) {
				Department obj = instantiateDepartment(rs); //METHOD THAT INSTATIATE A DEPARTMENT IF THE ROW ISN´T NULL
				return obj;
			}
			return null;
		}
		
		catch(SQLException e) {
			throw new DbException(e.getMessage()); //SQL EXCEPTION
		}
		
		finally {
			DB.closeStatement(st); //CLOSE STATEMENT
			DB.closeResultSet(rs); //CLOSE RESULT SET
		}
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException { //INSTATIATE A DEPARTMENT OF THE DB
		Department obj = new Department(); //EMPTY CONSTRUCTOR
		obj.setId(rs.getInt("Id"));        //SETS DEPARTMENT ID 
		obj.setName(rs.getString("Name")); //SET DEPARTMENT NAME
		return obj;
	}

	@Override
	public List<Department> findAll() {
		// DISPLAY ALL DEPARTMENTS
		return null;
	}

}
