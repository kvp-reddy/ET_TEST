package test.apis;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.hibernate.models.Employeedetails;
import test.hibernate.models.address;
import test.hibernate.models.employee;

import com.google.gson.Gson;

/**
 * Servlet implementation class employeesapis
 */
@WebServlet(name = "employees", urlPatterns = { "/apis/v1/*" })
public class employeesapis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeesapis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuffer pathinfo = request.getRequestURL();
		System.out.println(pathinfo+"------------------");
		String endurl = pathinfo.substring(pathinfo.indexOf("v1"));
		System.out.println("ENDURL----------"+endurl);
		if(endurl.substring(endurl.lastIndexOf("/")+1).equals("all"))
		{
		List<employee> employees = new ArrayList<employee>(0);
		employees = Utilities.getallemployees();
		List<Employeedetails> employeedetails = new ArrayList<Employeedetails>(0);
		if(!employees.isEmpty())
		{
		for(employee emp : employees)
		{
			Employeedetails empd = new Employeedetails();
			empd.setDepartment(emp.getDept());
			empd.setDesignation(emp.getDesgn());
			empd.setDob(emp.getDob());
			empd.setEmpadd(emp.getEmpadd());
			empd.setFname(emp.getFirst_name());
			empd.setLname(emp.getLast_name());
			empd.setSalary(emp.getSalary());
			empd.setJoiningdate(emp.getJoined_date());
			empd.setWorking_city(emp.getCty());
			empd.setWorking_state(emp.getSt());
			empd.setWorking_country(emp.getCntry());
			employeedetails.add(empd);
		}
		Map<String, Object> jsonmap = new HashMap<String,Object>();
		jsonmap.put("employeesdetails", employeedetails);
		String jsoncheck = new Gson().toJson(jsonmap);
		PrintWriter out = response.getWriter();
		out.print(jsoncheck);
		out.flush();
		}
		}
		else
		{
			int empid = Integer.parseInt(endurl.substring(endurl.lastIndexOf("/")+1));
			employee emp = Utilities.getemployeebyid(empid);
			if(!emp.equals(null))
			{
			Employeedetails empd =new Employeedetails();
			empd.setDepartment(emp.getDept());
			empd.setDesignation(emp.getDesgn());
			empd.setDob(emp.getDob());
			empd.setEmpadd(emp.getEmpadd());
			empd.setFname(emp.getFirst_name());
			empd.setLname(emp.getLast_name());
			empd.setSalary(emp.getSalary());
			empd.setJoiningdate(emp.getJoined_date());
			empd.setWorking_city(emp.getCty());
			empd.setWorking_state(emp.getSt());
			empd.setWorking_country(emp.getCntry());
			Map<String, Object> jsonmap = new HashMap<String,Object>();
			jsonmap.put("employeedetails", empd);
			String jsoncheck = new Gson().toJson(jsonmap);
			PrintWriter out = response.getWriter();
			out.print(jsoncheck);
			out.flush();
			System.out.println("endurl------------------"+endurl);
			System.out.println("empid------------"+empid);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cityid = Integer.parseInt(request.getParameter("rescityid"));
		int state_id =Integer.parseInt(request.getParameter("resstateid"));
		int country_id = Integer.parseInt(request.getParameter("rescountryid"));
		String doorno = request.getParameter("doorno");
		String streetname = request.getParameter("streetname");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		int des_id = Integer.parseInt(request.getParameter("desid"));
		int dep_id = Integer.parseInt(request.getParameter("depid"));
		Date joineddate = Utilities.getDatefromString(request.getParameter("joiningdate"));
		Date dob = Utilities.getDatefromString(request.getParameter("dob"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int city_id = Integer.parseInt(request.getParameter("wrk_city_id"));
		int stateid = Integer.parseInt(request.getParameter("wrk_state_id"));
		int countryid = Integer.parseInt(request.getParameter("wrk_country_id"));
		Utilities.insertemployee(fname, lname, dob, joineddate, des_id, dep_id, city_id, countryid, stateid , salary,cityid,state_id, country_id,doorno,streetname,pincode);

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empid = Integer.parseInt(request.getParameter("empid"));
		employee emp = Utilities.getemployeebyid(empid);
		int empaddid = emp.getEmpadd().getaddressid();
		address empadd = Utilities.getaddressbyid(empaddid);
		empadd.setCty(Utilities.getcitybyid(Integer.parseInt(request.getParameter("rescityid"))));
		empadd.setCntry(Utilities.getcountrybyid(Integer.parseInt(request.getParameter("resstateid"))));
		empadd.setSt(Utilities.getstatebyid(Integer.parseInt(request.getParameter("rescountryid"))));
		empadd.setDoorno(request.getParameter("doorno"));
		empadd.setStreetname(request.getParameter("streetname"));
		Utilities.updateaddress(empadd);
		emp.setDesgn(Utilities.getdesignationnamebyid(Integer.parseInt(request.getParameter("desid"))));
		emp.setDept(Utilities.getdepartmentnamebyid(Integer.parseInt(request.getParameter("depid"))));
		emp.setJoined_date(Utilities.getDatefromString(request.getParameter("joiningdate")));
		emp.setDob(Utilities.getDatefromString(request.getParameter("dob")));
		emp.setFirst_name(request.getParameter("fname"));
		emp.setLast_name(request.getParameter("lname"));
		emp.setSalary(Integer.parseInt(request.getParameter("salary")));
		emp.setCty(Utilities.getcitybyid(Integer.parseInt(request.getParameter("wrk_city_id"))));
		emp.setCntry(Utilities.getcountrybyid(Integer.parseInt(request.getParameter("wrk_country_id"))));
		emp.setSt(Utilities.getstatebyid(Integer.parseInt(request.getParameter("wrk_state_id"))));
		Utilities.updateemployee(emp);
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer pathinfo = request.getRequestURL();
		String endurl = pathinfo.substring(pathinfo.indexOf("v1"));
		int empid = Integer.parseInt(endurl.substring(endurl.lastIndexOf("/")+1));
		Utilities.deleteemployeebyid(empid);
		
	}

}
