package com.redhat.poc.service;

import com.redhat.poc.dao.HatDAO;
import com.redhat.poc.model.Hat;

public class HatService {
    // put logic to query the db in hatDAO
    private HatDAO dao;

    public Hat createHat(Hat hat){
        return dao.createHat(hat);
    }


    public Hat getHat(Integer id){
        Hat hat = new Hat();
        hat.setId(id);
        hat.setColor("blue");
        hat.setType("fedora");
        hat.setDescrption("blue hat");
//        return dao.getHat(id);
        return hat;
    }

    public void deleteHat(Integer id){
        dao.deleteHat(id);
    }

    public Hat updateHat(Hat hat){
        return dao.updateHat(hat);
    }


}
