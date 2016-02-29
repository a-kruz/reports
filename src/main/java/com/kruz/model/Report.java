package com.kruz.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reports")
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Column(name = "performer")
    private String performer;
    
    @Column(name = "activity")
    private String activity;

    public Report() {
    }

    public Report(Long id, Date startDate, Date endDate, String performer, String activity) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.performer = performer;
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + 
            " Start Date: " + getStartDate() + 
            " End Date: " + getEndDate() + 
            " Performer: " + getPerformer() + 
            " Activity: " + getActivity();
    }
}
