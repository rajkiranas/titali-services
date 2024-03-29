/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.tim.mobileserviceprovider.services;

import com.quick.tim.mobileserviceprovider.DAO.QuickDao;
import com.quick.tim.mobileserviceprovider.bean.MasteParmBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sonali Sangle
 */
@Component
public class QuickService {

    @Autowired
    QuickDao quickDao;
     
    public List<MasteParmBean> getQuickLearnUploadList() {
        List<MasteParmBean> quickLearnList = quickDao.getQuickLearnUploadList();         
        return quickLearnList;
    }
    
}
