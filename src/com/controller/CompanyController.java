package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CompanyDao;
import com.model.Company;

@WebServlet("/CompanyController")
public class CompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/company.jsp";
	private static String LIST_COMPANY = "/listCompany.jsp";
	private static String HOME = "/index.jsp";
	private CompanyDao dao;
       
    public CompanyController() {
        super();
        dao = new CompanyDao();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");
        System.out.println("action is : "+action);
        if (action.equalsIgnoreCase("delete")){
        	String companyId = request.getParameter("companyId");
            dao.deleteCompany(companyId);
            forward = LIST_COMPANY;
            request.setAttribute("companies", dao.getAllCompanies());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            String companyId = request.getParameter("companyId");
            Company company = dao.getCompanyById(companyId);
            System.out.println("business activity is : "+company.getBusinessActivity());
            request.setAttribute("company", company);
        } else if (action.equalsIgnoreCase("listCompany")){
            forward = LIST_COMPANY;
            request.setAttribute("companies", dao.getAllCompanies());
        } else if(action.equalsIgnoreCase("import")){
        	dao.importFromCSV("test");
        	forward = LIST_COMPANY;
            request.setAttribute("companies", dao.getAllCompanies()); 
        } else if(action.equalsIgnoreCase("home")){
        	forward = HOME;
        } else {
       
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Company company = new Company();
		try {
            Date registration = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("registration"));
            company.setRegistrationDate(registration);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		company.setName(request.getParameter("name"));
		company.setStatus(request.getParameter("status"));
        company.setCompanyClass(request.getParameter("companyClass"));
        company.setCategory(request.getParameter("category"));
		company.setAuthorizedCapital(request.getParameter("authorizedCapital"));
		company.setPaidupCapital(request.getParameter("paidupCapital"));
		company.setState(request.getParameter("state"));
        company.setRegistrar(request.getParameter("registrar"));
        company.setBusinessActivity(request.getParameter("businessActivity"));
		company.setOfficeAddress(request.getParameter("officeAddress"));
		company.setSubCategory(request.getParameter("subCategory"));
        String companyid = request.getParameter("companyid");
        if(companyid == null || companyid.isEmpty())
        {
            dao.addCompany(company);
        }
        else
        {
        	company.setId(companyid);
            dao.updateCompany(company);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_COMPANY);
        request.setAttribute("companies", dao.getAllCompanies());
        view.forward(request, response);
	}

}
