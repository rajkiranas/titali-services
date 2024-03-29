/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.tim.mobileserviceprovider.DAOImpl;

import com.quick.tim.mobileserviceprovider.DAO.QuickLearnDAO;
import com.quick.tim.mobileserviceprovider.bean.MasteParmBean;
import com.quick.tim.mobileserviceprovider.entity.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Suyogn
 */
@Repository("quickLearnDAO")
@Transactional
public class QuickLearnDAOImpl implements QuickLearnDAO {
    private HibernateTemplate hibernateTemplate;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) 
    {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    private static final String getMaxUplaodIdByQry="select max(model.uploadId) from QuickLearn as model";
    
    public List<QuickLearn> getQuickLearnByID(int uploadId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(QuickLearn.class);
        criteria.add(Restrictions.eq("uploadId", uploadId));
//        criteria.createAlias("ql.std", "std");
//        criteria.createAlias("ql.sub", "sub");
        ProjectionList pl = Projections.projectionList();
        
      ///  pl.add(Projections.property("uploadId"), "uploadId");
        pl.add(Projections.property("std.std"), "std");
        pl.add(Projections.property("sub.sub"), "sub");
        pl.add(Projections.property("uploadDate"), "uploadDate");
        pl.add(Projections.property("fordiv"), "fordiv");
        pl.add(Projections.property("topic"), "topic");
        pl.add(Projections.property("videoPath"), "videoPath");
        pl.add(Projections.property("videoInfo"), "videoInfo");
        pl.add(Projections.property("lectureNotes"), "lectureNotes");
        pl.add(Projections.property("lectureNotesInformation"), "lectureNotesInformation");
        pl.add(Projections.property("otherNotes"), "otherNotes");
        pl.add(Projections.property("otherNotesInformation"), "otherNotesInformation");
        pl.add(Projections.property("previousQuestion"), "previousQuestion");
        pl.add(Projections.property("previousQuestionInformation"), "previousQuestionInformation");
        pl.add(Projections.property("topicTags"), "topicTags");
        criteria.setProjection(pl);
        criteria.setResultTransformer(Transformers.aliasToBean(com.quick.tim.mobileserviceprovider.bean.QuickLearn.class));
        return hibernateTemplate.findByCriteria(criteria);
    }
    
    
    public List<QuickLearn> getNotesByID(int aInt) {
        DetachedCriteria criteria = DetachedCriteria.forClass(QuickLearn.class);
        criteria.add(Restrictions.eq("uploadId", aInt));
        ProjectionList pl = Projections.projectionList();
        pl.add(Projections.property("uploadDate"), "uploadDate");
        pl.add(Projections.property("lectureNotes"), "lectureNotes");
        pl.add(Projections.property("lectureNotesInformation"), "lectureNotesInformation");
        criteria.setProjection(pl);
        criteria.setResultTransformer(Transformers.aliasToBean(QuickLearn.class));
        return hibernateTemplate.findByCriteria(criteria);
    }
    
    
    public List<QuickLearn> getgetOtherNotesByID(int aInt) {
        DetachedCriteria criteria = DetachedCriteria.forClass(QuickLearn.class);
        criteria.add(Restrictions.eq("uploadId", aInt));
        ProjectionList pl = Projections.projectionList();
        pl.add(Projections.property("uploadDate"), "uploadDate");
        pl.add(Projections.property("otherNotes"), "otherNotes");
        pl.add(Projections.property("otherNotesInformation"), "otherNotesInformation");
        criteria.setProjection(pl);
        criteria.setResultTransformer(Transformers.aliasToBean(QuickLearn.class));
        return hibernateTemplate.findByCriteria(criteria);
    }
    
    
    public List<QuickLearn> getpreviousQueByID(int aInt) {
        DetachedCriteria criteria = DetachedCriteria.forClass(QuickLearn.class);
        criteria.add(Restrictions.eq("uploadId", aInt));
        ProjectionList pl = Projections.projectionList();
        pl.add(Projections.property("uploadDate"), "uploadDate");
        pl.add(Projections.property("previousQuestion"), "previousQuestion");
        pl.add(Projections.property("previousQuestionInformation"), "previousQuestionInformation");
        criteria.setProjection(pl);
        criteria.setResultTransformer(Transformers.aliasToBean(QuickLearn.class));
        return hibernateTemplate.findByCriteria(criteria);
    }
    
     public void saveMyShortNotes(QuickNotes quickNotes) {
        hibernateTemplate.saveOrUpdate(quickNotes);
    }

    public List<MasteParmBean> getWhatsNewForMe(String subject) {
          List<MasteParmBean> whatsNewList=null;
        try 
        {
            //.createAlias("Whatsnew", "Whatsnew")
            DetachedCriteria detCri = DetachedCriteria.forClass(QuickLearn.class).createAlias("sub", "sub");
            ProjectionList proList = Projections.projectionList();
            proList.add(Projections.property("sub.sub"),"sub");
            proList.add(Projections.property("topic"),"topic");
            proList.add(Projections.property("uploadId"),"uploadId");
            
            proList.add(Projections.property("uploadDate"),"uploadDate");
            detCri.setProjection(proList);
            detCri.add(Restrictions.eq("sub.sub", subject));
            detCri.setResultTransformer(Transformers.aliasToBean(MasteParmBean.class));
            whatsNewList = hibernateTemplate.findByCriteria(detCri);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return whatsNewList;
    }

    public List getMyQuickNotesById(int uploadId) {
           List userNotes=null;
        try 
        {
            //.createAlias("Whatsnew", "Whatsnew")
            DetachedCriteria detCri = DetachedCriteria.forClass(QuickNotes.class);
            ProjectionList proList = Projections.projectionList();
            proList.add(Projections.property("userNotes"),"userNotes");
           detCri.setProjection(proList);
           detCri.add(Restrictions.eq("id.uploadId", uploadId));
           userNotes = hibernateTemplate.findByCriteria(detCri);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return userNotes;

    }
    
     public void saveQuickUploadDetails(QuickLearn quickLearn) {
        hibernateTemplate.saveOrUpdate(quickLearn);
    }
    
     
     public List<MasteParmBean> getquickLearnByUploadId(int uploadId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(QuickLearn.class,"ql");
        criteria.add(Restrictions.eq("uploadId", uploadId));
        criteria.createAlias("ql.std", "std");
        criteria.createAlias("ql.sub", "sub");
        ProjectionList pl = Projections.projectionList();
        
      ///  pl.add(Projections.property("uploadId"), "uploadId");
        pl.add(Projections.property("std.std"), "std");
        pl.add(Projections.property("sub.sub"), "sub");
        pl.add(Projections.property("uploadDate"), "uploadDate");
        pl.add(Projections.property("fordiv"), "div");
        pl.add(Projections.property("topic"), "topic");
        pl.add(Projections.property("videoPath"), "videoPath");
        pl.add(Projections.property("videoInfo"), "videoInfo");
        pl.add(Projections.property("lectureNotes"), "lectureNotes");
        pl.add(Projections.property("lectureNotesInformation"), "lectureNotesInformation");
        pl.add(Projections.property("otherNotes"), "otherNotes");
        pl.add(Projections.property("otherNotesInformation"), "otherNotesInformation");
        pl.add(Projections.property("previousQuestion"), "previousQuestion");
        pl.add(Projections.property("previousQuestionInformation"), "previousQuestionInformation");
        pl.add(Projections.property("topicTags"), "topicTags");
        criteria.setProjection(pl);
        criteria.setResultTransformer(Transformers.aliasToBean(MasteParmBean.class));
        return hibernateTemplate.findByCriteria(criteria);
    }

   public List getMaxUplaodId() {
      return (List<QuickLearn>)hibernateTemplate.find(getMaxUplaodIdByQry);
   }
    
   public void deleteTopicByUploadId(QuickLearn quickLearn) {
        hibernateTemplate.delete(quickLearn);
    }
    

}
