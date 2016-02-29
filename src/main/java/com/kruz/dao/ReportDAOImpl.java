package com.kruz.dao;

import java.util.List;
import java.util.Date;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;

import com.kruz.model.Report;

public class ReportDAOImpl implements ReportDAO{
    
    private SessionFactory sf;
     
    public ReportDAOImpl(SessionFactory sf){
        this.sf = sf;
    }
    
    @Override
    public List<Report> getReportsByParam(Date startDate, 
                                          Date endDate, 
                                          String performer) {
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        List<Report> reportList = null;
        
        try {
            // Add queries use input params
            Criteria criteria = session.createCriteria(Report.class);
            if (startDate != null) {
                criteria.add(Restrictions.like("startDate", startDate));
            }
            if (endDate != null) {
                criteria.add(Restrictions.like("endDate", endDate));
            }
            if ( (performer != null) && (!performer.isEmpty()) ) {
                criteria.add(Restrictions.like("performer", performer));
            }
            criteria.addOrder(Order.asc("startDate"));
            reportList = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        tx.commit();
        return reportList;
    }

    @Override
    public List<String> getPerformerList() {
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        List<String> performers = null;
        
        try {
            performers = session.createCriteria(Report.class)
                .setProjection(Projections.property("performer")).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        tx.commit();
        return performers;
    }
}
