package com.beingjavaguys.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beingjavaguys.dao.CSVLoader;
import com.beingjavaguys.domain.Customer;
import com.beingjavaguys.domain.Employee;
import com.beingjavaguys.services.CustService;
import com.beingjavaguys.services.DataService;

@Controller
public class DataController {
	
	@Autowired
	DataService dataService;
	
	@Autowired
	CustService custService;
	private static String JDBC_CONNECTION_URL = 
			"jdbc:mysql://localhost:3306/springhibernate_db";

	@RequestMapping("form")
	public ModelAndView getForm(@ModelAttribute Employee employee) {
		return new ModelAndView("form");
	}
	
	@RequestMapping("register")
	public ModelAndView registerUser(@ModelAttribute Employee employee) {
		dataService.insertRow(employee);
		return new ModelAndView("redirect:list");
	}
			
	@RequestMapping("list")
	public ModelAndView getList() {
		List employeeList = dataService.getList();
		return new ModelAndView("list","employeeList",employeeList);
	}
	
	@RequestMapping("list1")
	public ModelAndView getCustomer() {
		List customerList = custService.getCustomer();
		return new ModelAndView("list1","customerList",customerList);
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		dataService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("edit")
	public ModelAndView editUser(@RequestParam int id,@ModelAttribute Employee employee) {
		Employee employeeObject = dataService.getRowById(id);
		return new ModelAndView("edit","employeeObject",employeeObject);
	}
	
	@RequestMapping("update")
	public ModelAndView updateUser(@ModelAttribute Employee employee) {
		dataService.updateRow(employee);
		return new ModelAndView("redirect:list");
		
	}
	@RequestMapping("csvparser")
	public ModelAndView csvparse() {
		CSVLoader loader = new CSVLoader(getCon());
		try {
			loader.loadCSV("D://employee.csv", "customer", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("csvparser");
	}
	private static Connection getCon() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_CONNECTION_URL,"root","root");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}	

}
