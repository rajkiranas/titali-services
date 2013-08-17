package com.quick.tim.mobileserviceprovider.entity;
// Generated 5 Jun, 2013 6:08:00 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * ExamEntry generated by hbm2java
 */
@Entity
@Table(name="exam_entry", schema="public"
    , uniqueConstraints = @UniqueConstraint(columnNames="ex_name")
)
public class ExamEntry  implements java.io.Serializable {


     private int exId;
     private Std std;
     private Sub sub;
     private String exName;
     private int exType;
     private Date startDt;
     private Date endDt;
     private String fordiv;
     private String topic;
     private String createdBy;
     private Date creationDt;
     private int noOfQuestions;
     private int totalMarks;
     private int passingMarks;
     private int totalStudents;
     private int appearedStudents;
     private int passedStudents;
     private int failedStudents;
     private Set<ExamQuestionsAnswers> examQuestionsAnswerses = new HashSet<ExamQuestionsAnswers>(0);
     private Set<ExamStudentResponse> examStudentResponses = new HashSet<ExamStudentResponse>(0);
     private Set<StudentExamSummary> studentExamSummaries = new HashSet<StudentExamSummary>(0);

    public ExamEntry() {
    }

	
    public ExamEntry(int exId) {
        this.exId = exId;
    }
    public ExamEntry(int exId, Std std, Sub sub, String exName, int exType, Date startDt, Date endDt, String fordiv, String topic, String createdBy, Date creationDt, int noOfQuestions, int totalMarks, int passingMarks, int totalStudents, int appearedStudents, int passedStudents, int failedStudents, Set<ExamQuestionsAnswers> examQuestionsAnswerses, Set<ExamStudentResponse> examStudentResponses, Set<StudentExamSummary> studentExamSummaries) {
       this.exId = exId;
       this.std = std;
       this.sub = sub;
       this.exName = exName;
       this.exType = exType;
       this.startDt = startDt;
       this.endDt = endDt;
       this.fordiv = fordiv;
       this.topic = topic;
       this.createdBy = createdBy;
       this.creationDt = creationDt;
       this.noOfQuestions = noOfQuestions;
       this.totalMarks = totalMarks;
       this.passingMarks = passingMarks;
       this.totalStudents = totalStudents;
       this.appearedStudents = appearedStudents;
       this.passedStudents = passedStudents;
       this.failedStudents = failedStudents;
       this.examQuestionsAnswerses = examQuestionsAnswerses;
       this.examStudentResponses = examStudentResponses;
       this.studentExamSummaries = studentExamSummaries;
    }
   
     @Id 
    
    @Column(name="ex_id", unique=true, nullable=false)
    public int getExId() {
        return this.exId;
    }
    
    public void setExId(int exId) {
        this.exId = exId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="forstd")
    public Std getStd() {
        return this.std;
    }
    
    public void setStd(Std std) {
        this.std = std;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sub")
    public Sub getSub() {
        return this.sub;
    }
    
    public void setSub(Sub sub) {
        this.sub = sub;
    }
    
    @Column(name="ex_name", unique=true, length=100)
    public String getExName() {
        return this.exName;
    }
    
    public void setExName(String exName) {
        this.exName = exName;
    }
    
    @Column(name="ex_type")
    public int getExType() {
        return this.exType;
    }
    
    public void setExType(int exType) {
        this.exType = exType;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="start_dt", length=13)
    public Date getStartDt() {
        return this.startDt;
    }
    
    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="end_dt", length=13)
    public Date getEndDt() {
        return this.endDt;
    }
    
    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }
    
    @Column(name="fordiv", length=3)
    public String getFordiv() {
        return this.fordiv;
    }
    
    public void setFordiv(String fordiv) {
        this.fordiv = fordiv;
    }
    
    @Column(name="topic", length=30)
    public String getTopic() {
        return this.topic;
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    @Column(name="created_by", length=200)
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="creation_dt", length=13)
    public Date getCreationDt() {
        return this.creationDt;
    }
    
    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }
    
    @Column(name="no_of_questions")
    public int getNoOfQuestions() {
        return this.noOfQuestions;
    }
    
    public void setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }
    
    @Column(name="total_marks")
    public int getTotalMarks() {
        return this.totalMarks;
    }
    
    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }
    
    @Column(name="passing_marks")
    public int getPassingMarks() {
        return this.passingMarks;
    }
    
    public void setPassingMarks(int passingMarks) {
        this.passingMarks = passingMarks;
    }
    
    @Column(name="total_students")
    public int getTotalStudents() {
        return this.totalStudents;
    }
    
    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }
    
    @Column(name="appeared_students")
    public int getAppearedStudents() {
        return this.appearedStudents;
    }
    
    public void setAppearedStudents(int appearedStudents) {
        this.appearedStudents = appearedStudents;
    }
    
    @Column(name="passed_students")
    public int getPassedStudents() {
        return this.passedStudents;
    }
    
    public void setPassedStudents(int passedStudents) {
        this.passedStudents = passedStudents;
    }
    
    @Column(name="failed_students")
    public int getFailedStudents() {
        return this.failedStudents;
    }
    
    public void setFailedStudents(int failedStudents) {
        this.failedStudents = failedStudents;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="examEntry")
    public Set<ExamQuestionsAnswers> getExamQuestionsAnswerses() {
        return this.examQuestionsAnswerses;
    }
    
    public void setExamQuestionsAnswerses(Set<ExamQuestionsAnswers> examQuestionsAnswerses) {
        this.examQuestionsAnswerses = examQuestionsAnswerses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="examEntry")
    public Set<ExamStudentResponse> getExamStudentResponses() {
        return this.examStudentResponses;
    }
    
    public void setExamStudentResponses(Set<ExamStudentResponse> examStudentResponses) {
        this.examStudentResponses = examStudentResponses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="examEntry")
    public Set<StudentExamSummary> getStudentExamSummaries() {
        return this.studentExamSummaries;
    }
    
    public void setStudentExamSummaries(Set<StudentExamSummary> studentExamSummaries) {
        this.studentExamSummaries = studentExamSummaries;
    }




}

