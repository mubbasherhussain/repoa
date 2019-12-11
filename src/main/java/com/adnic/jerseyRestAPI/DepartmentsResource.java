package com.adnic.jerseyRestAPI;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("departments")
public class DepartmentsResource {
	DepartmentsRepository depo = new DepartmentsRepository();
	//
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Departments> getAllDepartments(){
		return depo.getAllDepartments();
	}
	//
	@Path("department/{departmentId}")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Departments> getDepartmentsById(@PathParam("departmentId") int departmentId){
		return depo.getDepartmentsById(departmentId);
	}
	//
	@Path("createDepartment")
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void createDepartment(Departments dept){
		depo.createDepartments(dept);
	}
	//
	@Path("updateDepartment")
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void updateDepartment(Departments dept){
		depo.updateDepartments(dept);
	}
	//
	@Path("deleteDepartment")
	@DELETE
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void deleteDepartment(Departments dept){
		depo.deleteDepartments(dept);
	}
}
