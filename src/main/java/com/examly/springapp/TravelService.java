package com.examly.springapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelService {
    
    @Autowired
    public TravelRepository tr;

    public List<Travel> getAllTravel(){
        List<Travel> t=new ArrayList<Travel>();
        tr.findAll().forEach(t::add);
        return t;
    }

    public String addTravel(Travel travel){
        tr.save(travel);
        return "Travel Added Successfully!";
    }

    public String editTravel(String id, Travel travel){
        tr.save(travel);
        return "Travel Updated Successfully ! "+id;
    }

    public String deleteTravel(String id){
        tr.deleteById(id);
        return "Travel Deleted Successfully ! "+id;
    }

    public Travel getTravelById(String id, Travel travel){
        return tr.findById(id).get();
    }
}
