/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.tim.mobileserviceprovider.services;

import com.quick.tim.mobileserviceprovider.entity.Whatsnew;
import com.quick.tim.mobileserviceprovider.DAO.WhatsNewDao;
import com.quick.tim.mobileserviceprovider.bean.MasteParmBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rajkirans
 */
@Component
public class WhatsNewService 
{
    @Autowired
    WhatsNewDao whatsNewDao;
    
    public List<Whatsnew> getWhatsNewForMe(String forStd, String forDiv)
    {
         List<Whatsnew> whatsNewList = whatsNewDao.getWhatsNewForMe(forStd, forDiv);
         System.out.println("whatsNewList="+whatsNewList.get(0).getTopic());
        return whatsNewList;
    }
    
      public List<MasteParmBean> getWhatsNewForMe(String subject) {
         List<MasteParmBean> whatsNewList = whatsNewDao.getWhatsNewForMe(subject);
         return whatsNewList;
    }
    
}
