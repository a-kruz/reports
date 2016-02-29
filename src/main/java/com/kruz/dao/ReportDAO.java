package com.kruz.dao;

import java.util.List;
import java.util.Date;
import com.kruz.model.Report;

public interface ReportDAO {
    
    // Getting the reports list from the DB by the parameters
    List<Report> getReportsByParam(Date startDate, 
                                   Date endDate, 
                                   String performer);
    
    // Getting the performer list from the reports table 
    List<String> getPerformerList();
}
