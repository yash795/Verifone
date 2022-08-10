package com.example.SimApi.Controller;

import com.example.SimApi.Model.SimCard;
import com.example.SimApi.Service.SimDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimApiController {
    @Autowired
    private SimDataService simDataService;

    @GetMapping
    public void home(){
    }
    @PostMapping("/add")
    public void add(@RequestBody SimCard simCard){
        simDataService.add(simCard);
    }
    @GetMapping("/listall")
    public List<SimCard> listAll(){
        return simDataService.listAll();
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody SimCard simCard){
        simDataService.update(id,simCard);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        simDataService.delete(id);
    }
    @GetMapping("/to-renew")
    public List<SimCard> toRenew(){
        return simDataService.toRenew();
    }
//    @PutMapping("/renew/{id}")
//    public void renew(@PathVariable Long id) throws JsonProcessingException {
//        simDataService.renew(id);
//    }
}
