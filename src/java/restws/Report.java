/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fengcilin
 */
@Entity
@Table(name = "REPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r")
    , @NamedQuery(name = "Report.findByReportId", query = "SELECT r FROM Report r WHERE r.reportId = :reportId")
    , @NamedQuery(name = "Report.findByDate", query = "SELECT r FROM Report r WHERE r.date = :date")
    , @NamedQuery(name = "Report.findByTotalCalorieConsumed", query = "SELECT r FROM Report r WHERE r.totalCalorieConsumed = :totalCalorieConsumed")
    , @NamedQuery(name = "Report.findByTotalCalorieBurned", query = "SELECT r FROM Report r WHERE r.totalCalorieBurned = :totalCalorieBurned")
    , @NamedQuery(name = "Report.findByTotalSteps", query = "SELECT r FROM Report r WHERE r.totalSteps = :totalSteps")
    , @NamedQuery(name = "Report.findByCalorieGoal", query = "SELECT r FROM Report r WHERE r.calorieGoal = :calorieGoal")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPORT_ID")
    private Integer reportId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_CALORIE_CONSUMED")
    private int totalCalorieConsumed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_CALORIE_BURNED")
    private int totalCalorieBurned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_STEPS")
    private int totalSteps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALORIE_GOAL")
    private int calorieGoal;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private Appuser userId;

    public Report() {
    }

    public Report(Integer reportId) {
        this.reportId = reportId;
    }

    public Report(Integer reportId, Date date, int totalCalorieConsumed, int totalCalorieBurned, int totalSteps, int calorieGoal) {
        this.reportId = reportId;
        this.date = date;
        this.totalCalorieConsumed = totalCalorieConsumed;
        this.totalCalorieBurned = totalCalorieBurned;
        this.totalSteps = totalSteps;
        this.calorieGoal = calorieGoal;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalCalorieConsumed() {
        return totalCalorieConsumed;
    }

    public void setTotalCalorieConsumed(int totalCalorieConsumed) {
        this.totalCalorieConsumed = totalCalorieConsumed;
    }

    public int getTotalCalorieBurned() {
        return totalCalorieBurned;
    }

    public void setTotalCalorieBurned(int totalCalorieBurned) {
        this.totalCalorieBurned = totalCalorieBurned;
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public Appuser getUserId() {
        return userId;
    }

    public void setUserId(Appuser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restws.Report[ reportId=" + reportId + " ]";
    }
    
}
