package com.adnic.jerseyRestAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsRepository {
	static final String url = "jdbc:mysql://localhost:3306/hr";
	static final String username = "root";
	static final String password = "root";
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
// Constructor
	public DepartmentsRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
// get all departments
	public List<Departments> getAllDepartments(){
		List<Departments> dept = new ArrayList<>();
		String sql = "select * from departments";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Departments d = new Departments();
				d.setDepartmentId(rs.getInt(1));
				d.setDepartmentName(rs.getString(2));
				d.setLocationId(rs.getInt(3));
				d.setManagerId(rs.getInt(4));
				dept.add(d);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dept;
}
	
// get department by id
	
	public List<Departments> getDepartmentsById(int id){
		List<Departments> dept = new ArrayList<>();
		String sql = "select * from departments where department_id = "+id;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Departments d = new Departments();
				d.setDepartmentId(rs.getInt(1));
				d.setDepartmentName(rs.getString(2));
				d.setLocationId(rs.getInt(3));
				d.setManagerId(rs.getInt(4));
				dept.add(d);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dept;
}

// create department

	public void createDepartments(Departments d){
		String sql = "insert into departments (department_id,department_name,manager_id,location_id) values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDepartmentId());
			pstmt.setString(2, d.getDepartmentName());
			pstmt.setInt(3, d.getManagerId());
			pstmt.setInt(4, d.getLocationId());
			pstmt.executeUpdate();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
}
	// update department
	
	public void updateDepartments(Departments d){
		String sql = "update departments set department_name = ?, manager_id = ?, location_id = ? where department_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, d.getDepartmentName());
			pstmt.setInt(2, d.getManagerId());
			pstmt.setInt(3, d.getLocationId());
			pstmt.setInt(4, d.getDepartmentId());
			pstmt.executeUpdate();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
}
	// delete department
	
	public void deleteDepartments(Departments d){
		String sql = "delete from departments where department_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, d.getDepartmentId());
			pstmt.executeUpdate();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
}
	
}