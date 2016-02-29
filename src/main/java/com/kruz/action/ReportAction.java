package com.kruz.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.kruz.dao.ReportDAO;
import com.kruz.dao.ReportDAOImpl;

import org.hibernate.SessionFactory;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class ReportAction extends ActionSupport{
	
    private Date startDate;
    private Date endDate;
    private String performer;
    private String timePeriod;

    private List timePeriods = new ArrayList();
    private List reportList = new ArrayList();
    private Set performers;
    private String errorMessage = "";
    
    public ReportAction() {
        
        // Set the performers list
        SessionFactory sf = (SessionFactory) ServletActionContext
            .getServletContext().getAttribute("SessionFactory");
        ReportDAO reportDAO =  new ReportDAOImpl(sf);
        performers = new HashSet(reportDAO.getPerformerList());
        
        // Set the timePeriods list
        timePeriods.add("Last Qtr");
        timePeriods.add("Last Month");
        timePeriods.add("Last Calendar Year");
        timePeriods.add("Current Year to Date");
        timePeriods.add("Current Qtr to Date");
        timePeriods.add("Current Month to Date");
    }
    
    @Override
    public String execute() throws Exception{
        return SUCCESS;
    }

    public String fetchReports() throws Exception{
        
        // Getting the report list use the input form parameters
        SessionFactory sf = (SessionFactory) ServletActionContext
            .getServletContext().getAttribute("SessionFactory");
        ReportDAO reportDAO =  new ReportDAOImpl(sf);
        reportList = reportDAO.getReportsByParam(startDate, endDate, performer);
        
        if(reportList.isEmpty() || (reportList == null) ) {
            errorMessage = "Reports not find..";
        }
        return SUCCESS;
    }
    
    // Getters & Setters
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }
    
    public List getTimePeriods() {
        return timePeriods;
    }

    public void setTimePeriods(List timePeriods) {
        this.timePeriods = timePeriods;
    }
    
    public Set getPerformers() {
        return performers;
    }

    public void setPerformers(Set performers) {
        this.performers = performers;
    }
    
    public List getReportList() {
        return reportList;
    }

    public void setReportList(List reportList) {
        this.reportList = reportList;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}