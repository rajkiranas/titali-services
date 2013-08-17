package com.quick.tim.mobileserviceprovider.entity;
// Generated 5 Jun, 2013 6:08:00 PM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * QuickLearn generated by hbm2java
 */
@Entity
@Table(name="quick_learn", schema="public"
)

@SequenceGenerator(name = "itemid", sequenceName = "public.seq_quicklearn_uploadid")
public class QuickLearn  implements java.io.Serializable {


     private int uploadId;
     private Std std;
     private Sub sub;
     private Date uploadDate;
     private String fordiv;
     private String topic;
     private String videoPath;
     private String videoInfo;
     private String lectureNotes;
     private String lectureNotesInformation;
     private String otherNotes;
     private String otherNotesInformation;
     private String previousQuestion;
     private String previousQuestionInformation;
     private String topicTags;
     private Set<QuickNotes> quickNoteses = new HashSet<QuickNotes>(0);

    public QuickLearn() {
    }

	
    public QuickLearn(int uploadId) {
        this.uploadId = uploadId;
    }
    public QuickLearn(int uploadId, Std std, Sub sub, Date uploadDate, String fordiv, String topic, String videoPath, String videoInfo, String lectureNotes, String lectureNotesInformation, String otherNotes, String otherNotesInformation, String previousQuestion, String previousQuestionInformation, String topicTags, Set<QuickNotes> quickNoteses) {
       this.uploadId = uploadId;
       this.std = std;
       this.sub = sub;
       this.uploadDate = uploadDate;
       this.fordiv = fordiv;
       this.topic = topic;
       this.videoPath = videoPath;
       this.videoInfo = videoInfo;
       this.lectureNotes = lectureNotes;
       this.lectureNotesInformation = lectureNotesInformation;
       this.otherNotes = otherNotes;
       this.otherNotesInformation = otherNotesInformation;
       this.previousQuestion = previousQuestion;
       this.previousQuestionInformation = previousQuestionInformation;
       this.topicTags = topicTags;
       this.quickNoteses = quickNoteses;
    }
   
     @Id 
    @GeneratedValue(generator = "itemid", strategy = GenerationType.SEQUENCE)
    @Column(name="upload_id", unique=true, nullable=false)
    public int getUploadId() {
        return this.uploadId;
    }
    
    public void setUploadId(int uploadId) {
        this.uploadId = uploadId;
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
    @JoinColumn(name="subject")
    public Sub getSub() {
        return this.sub;
    }
    
    public void setSub(Sub sub) {
        this.sub = sub;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="upload_date", length=13)
    public Date getUploadDate() {
        return this.uploadDate;
    }
    
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
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
    
    @Column(name="video_path", length=200)
    public String getVideoPath() {
        return this.videoPath;
    }
    
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
    
    @Column(name="video_info", length=150)
    public String getVideoInfo() {
        return this.videoInfo;
    }
    
    public void setVideoInfo(String videoInfo) {
        this.videoInfo = videoInfo;
    }
    
    @Column(name="lecture_notes", length=10000)
    public String getLectureNotes() {
        return this.lectureNotes;
    }
    
    public void setLectureNotes(String lectureNotes) {
        this.lectureNotes = lectureNotes;
    }
    
    @Column(name="lecture_notes_information", length=150)
    public String getLectureNotesInformation() {
        return this.lectureNotesInformation;
    }
    
    public void setLectureNotesInformation(String lectureNotesInformation) {
        this.lectureNotesInformation = lectureNotesInformation;
    }
    
    @Column(name="other_notes", length=5000)
    public String getOtherNotes() {
        return this.otherNotes;
    }
    
    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes;
    }
    
    @Column(name="other_notes_information", length=150)
    public String getOtherNotesInformation() {
        return this.otherNotesInformation;
    }
    
    public void setOtherNotesInformation(String otherNotesInformation) {
        this.otherNotesInformation = otherNotesInformation;
    }
    
    @Column(name="previous_question", length=5000)
    public String getPreviousQuestion() {
        return this.previousQuestion;
    }
    
    public void setPreviousQuestion(String previousQuestion) {
        this.previousQuestion = previousQuestion;
    }
    
    @Column(name="previous_question_information", length=150)
    public String getPreviousQuestionInformation() {
        return this.previousQuestionInformation;
    }
    
    public void setPreviousQuestionInformation(String previousQuestionInformation) {
        this.previousQuestionInformation = previousQuestionInformation;
    }
    
    @Column(name="topic_tags", length=50)
    public String getTopicTags() {
        return this.topicTags;
    }
    
    public void setTopicTags(String topicTags) {
        this.topicTags = topicTags;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="quickLearn")
    public Set<QuickNotes> getQuickNoteses() {
        return this.quickNoteses;
    }
    
    public void setQuickNoteses(Set<QuickNotes> quickNoteses) {
        this.quickNoteses = quickNoteses;
    }




}


