package com.accolite.au.java.Main;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.accolite.au.java.Model.Employee;
import com.accolite.au.java.Model.Organization;

@Path("RestApp")
public class RestApp {
	
	static Organization org = new Organization();
	
	@POST
	@Path("/addEmployee/")
	@Produces(MediaType.APPLICATION_JSON)
	public String addEmployee(Employee e) {
		org.addEmployee(e);
		return "Added employee successfully!";
	}
	
	@GET
	@Path("/deleteEmployee")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee(@QueryParam("id") Integer id) {
		if(org.deleteEmployee(id))
			return "Deleted employee successfully!";
		return "No such employee!";
	}
	
	@GET
	@Path("/getAllEmployee")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllEmployee() {
		return org.getAllEmployee().toString();
	}
	
	@GET
	@Path("/getEmployeeById")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmployeeById(@QueryParam("id") Integer id) {
		Employee e = org.getEmployeeById(id);
		if(e != null)
		return e.toString();
		else
			return "No such employee exists!";
	}
	
	@POST
	@Path("/updateEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateEmployee(Employee e) {
		if(org.updateEmployee(e))
			return "Updated employee successfully!";
		else
			return "No such employee exists!";
	}
}
