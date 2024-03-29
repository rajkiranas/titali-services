/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.tim.mobileserviceprovider.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quick.tim.mobileserviceprovider.bean.ExamBean;
import com.quick.tim.mobileserviceprovider.bean.ExamQueAnsBean;
import com.quick.tim.mobileserviceprovider.global.GlobalConstants;
import com.quick.tim.mobileserviceprovider.services.ExamService;
import com.sun.jersey.api.core.ResourceContext;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rajkiran
 */
@Component
@Path(GlobalConstants.EXAMRESOURCE)
public class ExamResource {
    @Autowired
    private ExamService examService;
    private static final String getExamList="getExamList";
    private static final String getExamDetailsById = "getExamDetailsById";
    private static final String GETEXAMQUESTIONBYID = "getExamQuestionById";
      private static final String CREATEEXAM = "createExam";
    @Context
    private ResourceContext resourceContext;

    // Basic "is the service running" test
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String respondAsReady() {
        return "Demo service is ready!";
    }

    @Path(getExamList)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getCreatedExamList(JSONObject inputRequest) throws JSONException {


        System.out.println("userTrack=" + inputRequest);
        JSONObject response = new JSONObject();
        List<ExamBean> examList = examService.getExamList(inputRequest.getString("std"),inputRequest.getString("div"));
        Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();       
        String json = gson.toJson(examList);  
        response.put(GlobalConstants.EXAMLIST, json);     
        return response;       

      
    }
    
    
    @Path(getExamDetailsById)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getExamDetailsById(JSONObject inputRequest) throws JSONException {

        System.out.println("userTrack=" + inputRequest);
        JSONObject response = new JSONObject();
        List<ExamBean> examList = examService.getExamDetailsById(inputRequest.getInt("exmId"));
        Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();       
        String json = gson.toJson(examList);  
        response.put(GlobalConstants.EXAMLIST, json);     
        return response;       

      
    }
    
    
    
    @Path(GETEXAMQUESTIONBYID)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getExamQuestionById(JSONObject inputRequest) throws JSONException {

        System.out.println("userTrack=" + inputRequest);
        JSONObject response = new JSONObject();
        List<ExamQueAnsBean> queList = examService.getExamQuestionById(inputRequest.getInt("exmId"));
        Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();       
        String json = gson.toJson(queList);  
        response.put(GlobalConstants.EXAMLIST, json);     
        return response;       

      
    }
    
    
    @Path(CREATEEXAM)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getCreateExam(JSONObject inputRequest) throws JSONException {

        System.out.println("userTrack=" + inputRequest);
        JSONObject response = new JSONObject();
        examService.createExam(inputRequest);
        
//        List<ExamQueAnsBean> queList = examService.getExamQuestionById(inputRequest.getInt("exmId"));
//        Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();       
//        String json = gson.toJson(queList);  
//        response.put(GlobalConstants.EXAMLIST, json);     
        return response;       

    }
    
    
    
    
    
}
