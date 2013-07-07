/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.tim.mobileserviceprovider.services;

import com.quick.tim.mobileserviceprovider.entity.Whoisdoingwhat;
import com.quick.tim.mobileserviceprovider.DAO.WhoseDoingWhatDao;
import com.quick.tim.mobileserviceprovider.bean.MasteParmBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author suyogn
 */
@Component
public class WhoseDoingWhatService {
    
    @Autowired
    WhoseDoingWhatDao whoseDoingWhatDao;
    
       public List<MasteParmBean> getWhoIsDoingWhat(String forStd, String forDiv)
     {
         List<MasteParmBean> whoisdoingwhats = whoseDoingWhatDao.getWhoIsDoingWhat(forStd, forDiv);
         
         return whoisdoingwhats;
     }
}
