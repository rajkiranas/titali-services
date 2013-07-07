/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.tim.mobileserviceprovider.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.quick.tim.mobileserviceprovider.DAO.ExamDao;
import com.quick.tim.mobileserviceprovider.bean.ExamBean;
import com.quick.tim.mobileserviceprovider.bean.ExamQueAnsBean;
import com.quick.tim.mobileserviceprovider.entity.ExamEntry;
import com.quick.tim.mobileserviceprovider.entity.ExamQuestionsAnswers;
import com.quick.tim.mobileserviceprovider.entity.Std;
import com.quick.tim.mobileserviceprovider.global.GlobalConstants;
import com.quick.tim.mobileserviceprovider.resource.PersonResource;
import com.quick.tim.mobileserviceprovider.utilities.DateUtil;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rajkiran
 */
@Component
public class ExamService {
    @Autowired
    private ExamDao examDao;
    public List<ExamBean> getExamList(String std,String div){
        return examDao.getExamList(std,div);
    }

    public List<ExamBean> getExamDetailsById(int exmId) {
        return examDao.getExamDetailsById(exmId);
    }

    public List<ExamQueAnsBean> getExamQuestionById(int exmId) {
        return examDao.getExamQuestionById(exmId);
      
    }

    public void createExam(JSONObject inputRequest) {
        ExamEntry entry = getExamEntry(inputRequest);
        examDao.createExam(entry);
    }

    private ExamEntry getExamEntry(JSONObject inputRequest) {
         ExamEntry entry =null;
        try {
           entry = new ExamEntry();
           entry.setCreatedBy(inputRequest.getString("createdBy"));
           entry.setCreationDt(new Date());
           entry.setEndDt(DateUtil.stringToDate(inputRequest.getString("endDt")));
           entry.setStartDt(DateUtil.stringToDate(inputRequest.getString("startDt")));
           entry.setExName(inputRequest.getString("exName"));
           entry.setExType(inputRequest.getInt("exType"));
           entry.setFordiv(inputRequest.getString("fordiv"));
           entry.setNoOfQuestions(inputRequest.getInt("noOfQuestions"));
           entry.setPassingMarks(inputRequest.getInt("passingMarks"));
           entry.setExamQuestionsAnswerses(getExamQuestions(inputRequest));
           entry.setStd(getStandard(inputRequest));
           
        } catch (ParseException ex) {
            Logger.getLogger(ExamService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ExamService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return entry;
    }


    private Set<ExamQuestionsAnswers> getExamQuestions(JSONObject inputRequest) {
        Set<ExamQuestionsAnswers> questionsAnswerses = null;
        try {
            Type listType = new TypeToken<Set<ExamQuestionsAnswers>>() {}.getType();
            questionsAnswerses = new Gson().fromJson(inputRequest.getString(GlobalConstants.EXAMQUESTIONLIST), listType);
        } catch (JSONException ex) {
            Logger.getLogger(ExamService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questionsAnswerses;
    }
    
    

    private Std getStandard(JSONObject inputRequest) {
        Std std=new Std(); 
        try {           
            std.setStd(inputRequest.getString("std"));        
        } catch (JSONException ex) {
            Logger.getLogger(PersonResource.class.getName()).log(Level.SEVERE, null, ex);
        }
       return std;
    }
    
}
