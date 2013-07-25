/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.tim.mobileserviceprovider.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quick.tim.mobileserviceprovider.bean.MasteParmBean;
import com.quick.tim.mobileserviceprovider.entity.*;
import com.quick.tim.mobileserviceprovider.global.GlobalConstants;
import com.quick.tim.mobileserviceprovider.services.QuickLearnService;
import com.sun.jersey.api.core.ResourceContext;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author COMPUTER1
 */
@Component
@Path(GlobalConstants.QuickLearnResource)
public class QuickLearnResource {
    @Autowired
    QuickLearnService quickLearnService;
    private static final String getVideo = "getVideo";
    private static final String getNotes = "getnotes";
    private static final String getOtherNotes = "getOtherNotes";
    private static final String getPrevQue = "getPrevQue";
    private static final String myShortNotes = "saveMyShortNotes";
    private static final String whatsNewforme = "whatsNewforme";
    private static final String getstudQuickLearnDetails = "quickLearn";
    private static final String saveQuickUploadDetails="saveQuickUploadDetails";
    private static final String getquickLearnByUploadId="getquickLearnByUploadId";
    
    @Context
    private ResourceContext resourceContext;

    
    
    
    
    @Path(whatsNewforme)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getwhatsNewforme(JSONObject inputRequest) throws JSONException {


        System.out.println("userTrack=" + inputRequest);
        JSONObject response = new JSONObject();
        //org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        List<MasteParmBean> list = quickLearnService.getWhatsNewForMe(inputRequest.getString("subject"));
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.put(GlobalConstants.WHATSNEW, json);
        
       

        return response;
    }
    
   
    @Path(getstudQuickLearnDetails)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getQuickLearnByID(JSONObject inputRequest) throws JSONException {


        System.out.println("userTrack=" + inputRequest);
        JSONObject response = new JSONObject();
        //org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        List<QuickLearn> list = quickLearnService.getQuickLearnByID(inputRequest.getInt("uploadId"));
        Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();       
        String json = gson.toJson(list);  
        response.put(GlobalConstants.QUICKLEARNLIST, json);
        response.put(GlobalConstants.MYQUICKNOTEs, getMyQuickNotes(inputRequest.getInt("uploadId")));
        return response;
    }
   
    
      private String getMyQuickNotes(int uploadId) {
        return quickLearnService.getMyQuickNotesById(uploadId);
       
    }
      
      
   @Path(myShortNotes)
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public JSONObject  saveMyShortNotes(JSONObject inputRequest) throws JSONException {
        System.out.println("userTrack="+inputRequest);
        JSONObject response =  new JSONObject();
        //inputRequest.getString("notes")
        QuickNotes quickNotes = new QuickNotes();
        quickNotes.setUserNotes(inputRequest.getString("userNotes"));
        quickNotes.setId(new QuickNotesId(inputRequest.getString("userName"), inputRequest.getInt("uploadId")));
        quickLearnService.saveMyShortNotes(quickNotes);        
        response.put(GlobalConstants.STATUS,"updated Successfully");                   
        return response;       
    } 
   
   @Path(saveQuickUploadDetails)
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public JSONObject  saveQuickUploadDetails(JSONObject inputRequest) throws JSONException {
        System.out.println("userTrack="+inputRequest);
        JSONObject response =  new JSONObject();
        
        QuickLearn quickLearn=new QuickLearn(); 
        String uploadId=inputRequest.getString("uploadId");
        
        if(!uploadId.equals("null")){             
             quickLearn.setUploadId(Integer.parseInt(uploadId));
        }else{
             quickLearn.setUploadId(getMaxUplaodId());
        }
        
        String uploadedBy=inputRequest.getString("uploadedBy"); 
        String info=quickLearn.getUploadId()+"-"+uploadedBy;
        quickLearn.setStd(getuploadStd(inputRequest));
        quickLearn.setSub(getUploadSub(inputRequest));
        quickLearn.setTopic(inputRequest.getString("topic"));
        quickLearn.setTopicTags(inputRequest.getString("tags"));
          
        quickLearn.setUploadDate(new Date());
        quickLearn.setLectureNotes(inputRequest.getString("notes"));
        quickLearn.setLectureNotesInformation(info);
        quickLearn.setOtherNotes(inputRequest.getString("othernotes"));
        quickLearn.setOtherNotesInformation(info);
        quickLearn.setPreviousQuestion(inputRequest.getString("pq"));
        quickLearn.setPreviousQuestionInformation(info);
        quickLearn.setVideoPath(inputRequest.getString("video_path"));        
 
        quickLearnService.saveQuickUploadDetails(quickLearn);
        response.put(GlobalConstants.STATUS,GlobalConstants.YES);                   
        return response;
    }
   
   
   private Std getuploadStd(JSONObject inputRequest) {
        Std s=new Std();
        try {           
            s.setStd(inputRequest.getString("std"));             
        } catch (JSONException ex) {
            Logger.getLogger(QuickLearnResource.class.getName()).log(Level.SEVERE, null, ex);
        }
         return s;
    }

    private Sub getUploadSub(JSONObject inputRequest) {
        Sub s=new Sub();
        try {           
            s.setSub(inputRequest.getString("sub"));             
        } catch (JSONException ex) {
            Logger.getLogger(QuickLearnResource.class.getName()).log(Level.SEVERE, null, ex);
        }
         return s;
    }
    
    @Path(getquickLearnByUploadId)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getquickLearnByUploadId(JSONObject inputRequest) throws JSONException {


        System.out.println("userTrack=" + inputRequest);
        JSONObject response = new JSONObject();
        //org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        List<MasteParmBean> list = quickLearnService.getquickLearnByUploadId(inputRequest.getInt("uploadId"));
        Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();       
        String json = gson.toJson(list);  
        response.put(GlobalConstants.QUICKLEARNLIST, json);
       // response.put(GlobalConstants.MYQUICKNOTEs, getMyQuickNotes(inputRequest.getInt("uploadId")));
        return response;
    }
    
    
    private int getMaxUplaodId() {
       return quickLearnService.getMaxUplaodId();
    }
   
//    @Path(getVideo)
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public JSONObject getVideo(JSONObject inputRequest) throws JSONException {
//
//
//        System.out.println("userTrack=" + inputRequest);
//        JSONObject response = new JSONObject();
//        //org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
//        List<QuickLearn> list = quickLearnService.getVideoDetailsByID(inputRequest.getInt("upload_id"));
//
//        return response;
//    }
//    
    
//    @Path(getNotes)
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public JSONObject getNotes(JSONObject inputRequest) throws JSONException {
//
//
//       System.out.println("userTrack=" + inputRequest);
//       JSONObject response = new JSONObject();
//       List<QuickLearn> list = quickLearnService.getVideoDetailsByID(inputRequest.getInt("upload_id"));
//
//        return response;
//    }
//    
//    @Path(getOtherNotes)
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public JSONObject getOtherNotes(JSONObject inputRequest) throws JSONException {
//
//
//        System.out.println("userTrack=" + inputRequest);
//       JSONObject response = new JSONObject();
//       List<QuickLearn> list = quickLearnService.getVideoDetailsByID(inputRequest.getInt("upload_id"));
//
//        return response;
//    }
//    
//    @Path(getPrevQue)
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public JSONObject getPrevQue(JSONObject inputRequest) throws JSONException {
//
//         System.out.println("userTrack=" + inputRequest);
//       JSONObject response = new JSONObject();
//       List<QuickLearn> list = quickLearnService.getVideoDetailsByID(inputRequest.getInt("upload_id"));
//
//        return response;
//    }
//    
//    
//    

    

    

  
   
    
    
    
   
   
    
}
