package com.examly.springapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {
    
    @Autowired
    private TravelService ts;

    @PostMapping("/addTravel")
    public String addTravel(@RequestBody Travel travel){
        return ts.addTravel(travel);
    }

    @PostMapping("/travel/{id}")
    public String editTravel(@PathVariable String id, @RequestBody Travel travel){
        return ts.editTravel(id, travel);
    }

    @DeleteMapping("/travel/{id}")
    public String deleteTravel(@PathVariable String id){
        return ts.deleteTravel(id);
    }

    @GetMapping("/travel")
    public List<Travel> getAlTravels(){
        return ts.getAllTravel();
    }

    @GetMapping("/travel/{id}")
    public Travel getTravelById(@PathVariable String id, @RequestBody Travel travel){
        return ts.getTravelById(id, travel);
    }
}
