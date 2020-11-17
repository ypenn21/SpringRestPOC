package com.redhat.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.poc.dao.HatDAO;
import com.redhat.poc.model.Hat;

@Component
public class HatService {

	@Autowired
    private HatDAO dao;

    public Hat createHat(Hat hat){
//        return dao.save(hat);
        Iterable<Hat> a = dao.findAll();
        System.out.println(a);
        Hat o = dao.save(hat);
        a = dao.findAll();
        System.out.println(a);
        return o;
    }


    public Iterable<Hat> getHats(){
    	return dao.findAll();
    }

    public Hat getHat(Integer id){
    	return dao.findById(id).orElse(null);
    }

    public void deleteHat(Integer id){
        dao.deleteById(id);
    }

    public Hat updateHat(Hat hat){
        return dao.save(hat);
    }


}
