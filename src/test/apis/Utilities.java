package test.apis;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import test.hibernate.Util;
import test.hibernate.models.address;
import test.hibernate.models.city;
import test.hibernate.models.country;
import test.hibernate.models.department;
import test.hibernate.models.designation;
import test.hibernate.models.employee;
import test.hibernate.models.state;

public class Utilities {

	
	public static void initializesessionfactory()
	{
		Session session = Util.getSessionFactory().openSession();
		session.close();
	}
		
	public static List<employee> getallemployees()
	{
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<employee> employees =  session.createQuery("from employee").list();
		tx.commit();
		session.close();
		return employees;
	}
	
	public static int insertempaddress(int cityid,int country_id,String doorno,
			String streetname,int pincode,int state_id)
	{
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		address empadd = new address();
		empadd.setCty(Utilities.getcitybyid(cityid));
		empadd.setCntry(Utilities.getcountrybyid(country_id));
		empadd.setDoorno(doorno);
		empadd.setSt(Utilities.getstatebyid(state_id));
		empadd.setStreetname(streetname);
		empadd.setPincode(pincode);
		session.save(empadd);
		int addid = empadd.getaddressid();
		tx.commit();
		session.close();
		return addid;
	}
	
	public static void insertemployee(String fname,String lname,
			Date dob, Date joineddate,int des_id, int dep_id,  
			int cityid, int countryid, int stateid, int salary , int city_id , int country_id , int state_id , String doorno , String streetname ,int pincode)
	{
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		employee emp = new employee();
		address empadd = new address();
		empadd.setCty(Utilities.getcitybyid(cityid));
		empadd.setCntry(Utilities.getcountrybyid(country_id));
		empadd.setDoorno(doorno);
		empadd.setSt(Utilities.getstatebyid(state_id));
		empadd.setStreetname(streetname);
		empadd.setPincode(pincode);
		session.save(empadd);
		int addid = empadd.getaddressid();
		emp.setFirst_name(fname);
		emp.setLast_name(lname);
		emp.setDob(dob);
		emp.setJoined_date(joineddate);
		emp.setDesgn(Utilities.getdesignationnamebyid(des_id));
		emp.setDept(Utilities.getdepartmentnamebyid(dep_id));
		emp.setEmpadd(Utilities.getaddressbyid(addid));
		emp.setCty(Utilities.getcitybyid(cityid));
		emp.setCntry(Utilities.getcountrybyid(countryid));
		emp.setSt(Utilities.getstatebyid(stateid));
		emp.setSalary(salary);
		session.save(emp);
		tx.commit();
		session.close();
		
	}
	
	public static employee getemployeebyid(int empid)
	{
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from employee where empid=:empid");
		query.setParameter("empid", empid);
		employee emp = (employee) query.uniqueResult();
		tx.commit();
		session.close();
		return emp;
	}
	
	public static void deleteemployeebyid(int empid)
	{
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(" from employee where empid=:empid");
		query.setParameter("empid", empid);
		employee emp = (employee) query.uniqueResult();
		//Query q2 = session.createQuery("from address where addressid=:addid");
		//q2.setParameter("addid", emp.getPerm_address_id());
		address empadd = emp.getEmpadd();
		session.delete(emp);
		session.delete(empadd);
		tx.commit();
		session.close();
	}

	public static address getaddressbyid(int empaddid) {
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(" from address where addressid=:empaddid");
		query.setParameter("empaddid", empaddid);
		address empadd = (address)query.uniqueResult();
		tx.commit();
		session.close();
		return empadd;
	}
	
	public static void updateaddress(address empadd)
	{
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(empadd);
		tx.commit();
		session.close();
	}
	
	public static void updateemployee(employee emp)
	{
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(emp);
		tx.commit();
		session.close();
	}

	public static city getcitybyid(int cityid) {
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from city where cityid=:cityid");
		query.setParameter("cityid", cityid);
		city citi = (city) query.uniqueResult();
		tx.commit();
		session.close();
		return citi;
	}

	public static country getcountrybyid(int countryid) {
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from country where id=:countryid");
		query.setParameter("countryid", countryid);
		country cntry = (country) query.uniqueResult();
		tx.commit();
		session.close();
		return cntry;
	}

	public static state getstatebyid(int stateid) {
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from state where stateid=:stateid");
		query.setParameter("stateid", stateid);
		state st = (state) query.uniqueResult();
		tx.commit();
		session.close();
		return st;
	}

	public static Date getDatefromString(String datestring) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date parsed = null;
		java.sql.Date sqldate = null;
		try {

			parsed = (java.util.Date) format.parse(datestring);
			sqldate = new java.sql.Date(parsed.getTime());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("selected date----------"+sqldate);
		return sqldate;
	}

	public static department getdepartmentnamebyid(int department_id) {
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from department where id=:department_id");
		query.setParameter("department_id", department_id);
		department dptmt = (department) query.uniqueResult();
		tx.commit();
		session.close();
		return dptmt;
	}

	public static designation getdesignationnamebyid(int designation_id) {
		Session session = Util.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from designation where id=:designation_id");
		query.setParameter("designation_id", designation_id);
		designation dsgn = (designation) query.uniqueResult();
		tx.commit();
		session.close();
		return dsgn;
	}
}


