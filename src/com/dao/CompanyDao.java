package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.model.Company;
import com.util.DatabaseUtil;

public class CompanyDao {
	private Connection connection;
	
	public CompanyDao() {
        connection = DatabaseUtil.getConnection();
    }
	

	public void addCompany(Company company) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into companies(CORPORATE_IDENTIFICATION_NUMBER,DATE_OF_REGISTRATION,COMPANY_NAME,COMPANY_STATUS,COMPANY_CLASS,COMPANY_CATEGORY,AUTHORIZED_CAPITAL,PAIDUP_CAPITAL," + 
                    		"REGISTERED_STATE,REGISTRAR_OF_COMPANIES,PRINCIPAL_BUSINESS_ACTIVITY,REGISTERED_OFFICE_ADDRESS,SUB_CATEGORY) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, generateCompanyID(company));
            preparedStatement.setDate(2, new java.sql.Date(company.getRegistrationDate().getTime()));
            preparedStatement.setString(3, company.getName());
            preparedStatement.setString(4, company.getStatus());
            preparedStatement.setString(5, company.getCompanyClass());
            preparedStatement.setString(6, company.getCategory());
            preparedStatement.setString(7, company.getAuthorizedCapital());
            preparedStatement.setString(8, company.getPaidupCapital());
            preparedStatement.setString(9, company.getState());
            preparedStatement.setString(10, company.getRegistrar());
            preparedStatement.setString(11, company.getBusinessActivity());
            preparedStatement.setString(12, company.getOfficeAddress());
            preparedStatement.setString(13, company.getSubCategory());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteCompany(String companyId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from companies where CORPORATE_IDENTIFICATION_NUMBER=?");
            preparedStatement.setString(1, companyId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private String generateCompanyID(Company company) {
    	Random rand = new Random();
    	String id= "L"+String.format("%05d", rand.nextInt(100000))+"KA"+company.getRegistrationDate().getYear()+"PLC"+String.format("%06d",rand.nextInt(1000000));
    	System.out.println("action is : "+id);
    	return id;
    }
    
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from companies");
            while (rs.next()) {
            	Company company = new Company();
            	company.setId(rs.getString("CORPORATE_IDENTIFICATION_NUMBER"));
            	company.setRegistrationDate(rs.getDate("DATE_OF_REGISTRATION"));
            	company.setName(rs.getString("COMPANY_NAME"));
            	company.setStatus(rs.getString("COMPANY_STATUS"));
            	company.setCompanyClass(rs.getString("COMPANY_CLASS"));
            	company.setCategory(rs.getString("COMPANY_CATEGORY"));
            	company.setAuthorizedCapital(rs.getString("AUTHORIZED_CAPITAL"));
            	company.setPaidupCapital(rs.getString("PAIDUP_CAPITAL"));
            	company.setState(rs.getString("REGISTERED_STATE"));
            	company.setRegistrar(rs.getString("REGISTRAR_OF_COMPANIES"));
            	company.setBusinessActivity(rs.getString("PRINCIPAL_BUSINESS_ACTIVITY"));
            	company.setOfficeAddress(rs.getString("REGISTERED_OFFICE_ADDRESS"));
            	company.setSubCategory(rs.getString("SUB_CATEGORY"));
            	//System.out.println("action is : "+company.getName());
            	companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return companies;
    }
    
    public Company getCompanyById(String companyId) {
    	Company company = new Company();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from companies where CORPORATE_IDENTIFICATION_NUMBER=?");
            preparedStatement.setString(1, companyId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	company.setId(rs.getString("CORPORATE_IDENTIFICATION_NUMBER"));
            	company.setRegistrationDate(rs.getDate("DATE_OF_REGISTRATION"));
            	company.setName(rs.getString("COMPANY_NAME"));
            	company.setStatus(rs.getString("COMPANY_STATUS"));
            	company.setCompanyClass(rs.getString("COMPANY_CLASS"));
            	company.setCategory(rs.getString("COMPANY_CATEGORY"));
            	company.setAuthorizedCapital(rs.getString("AUTHORIZED_CAPITAL"));
            	company.setPaidupCapital(rs.getString("PAIDUP_CAPITAL"));
            	company.setState(rs.getString("REGISTERED_STATE"));
            	company.setRegistrar(rs.getString("REGISTRAR_OF_COMPANIES"));
            	company.setBusinessActivity(rs.getString("PRINCIPAL_BUSINESS_ACTIVITY"));
            	company.setOfficeAddress(rs.getString("REGISTERED_OFFICE_ADDRESS"));
            	company.setSubCategory(rs.getString("SUB_CATEGORY"));
            	System.out.println("is : "+rs.getString("SUB_CATEGORY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return company;
    }
    
    public void importFromCSV(String file) {
        try {
        	String csvFile = "C:\\\\Workspace\\\\company_data.csv";
            String loadQuery = "LOAD DATA LOCAL INFILE '"+ csvFile+"' INTO TABLE companies FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n' IGNORE 1 LINES (CORPORATE_IDENTIFICATION_NUMBER,@var,COMPANY_NAME,COMPANY_STATUS,COMPANY_CLASS,COMPANY_CATEGORY,AUTHORIZED_CAPITAL,PAIDUP_CAPITAL," + 
            		"REGISTERED_STATE,REGISTRAR_OF_COMPANIES,PRINCIPAL_BUSINESS_ACTIVITY,REGISTERED_OFFICE_ADDRESS,SUB_CATEGORY) SET DATE_OF_REGISTRATION = STR_TO_DATE(@var, '%d-%m-%Y')\r\n";
            //System.out.println(loadQuery);
            Statement stmt = connection.createStatement();
            stmt.execute(loadQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateCompany(Company company) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update companies set DATE_OF_REGISTRATION=?, COMPANY_NAME=?, COMPANY_STATUS=?, COMPANY_CLASS=?, COMPANY_CATEGORY=?, AUTHORIZED_CAPITAL=?,"
                    		+ "PAIDUP_CAPITAL=?, REGISTERED_STATE=?,REGISTRAR_OF_COMPANIES=?,PRINCIPAL_BUSINESS_ACTIVITY=?,REGISTERED_OFFICE_ADDRESS=?,SUB_CATEGORY=?" +
                            " where CORPORATE_IDENTIFICATION_NUMBER= ?");
            System.out.println(company.getId());
            preparedStatement.setDate(1, new java.sql.Date(company.getRegistrationDate().getTime()));
            preparedStatement.setString(2, company.getName());
            preparedStatement.setString(3, company.getStatus());
            preparedStatement.setString(4, company.getCompanyClass());
            preparedStatement.setString(5, company.getCategory());
            preparedStatement.setString(6, company.getAuthorizedCapital());
            preparedStatement.setString(7, company.getPaidupCapital());
            preparedStatement.setString(8, company.getState());
            preparedStatement.setString(9, company.getRegistrar());
            preparedStatement.setString(10, company.getBusinessActivity());
            preparedStatement.setString(11, company.getOfficeAddress());
            preparedStatement.setString(12, company.getSubCategory());
            preparedStatement.setString(13, company.getId().trim());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
