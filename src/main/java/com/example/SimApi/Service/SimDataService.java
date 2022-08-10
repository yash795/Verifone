package com.example.SimApi.Service;

import com.example.SimApi.Model.SimCard;
import com.example.SimApi.Repository.SimCardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SimDataService {
    @Autowired
    private SimCardRepository simCardRepository;

    public void add(SimCard simCard) {
        simCardRepository.save(simCard);
    }

    public List<SimCard> listAll() {
        return simCardRepository.findAll();
    }

    public void update(Long id, SimCard simCard) {
        if (simCardRepository.findById(id).isPresent()){
            SimCard existingSimCard = simCardRepository.findById(id).get();
            if(simCard.getSimCardNo()!=null)
            existingSimCard.setSimCardNo(simCard.getSimCardNo());
            if(simCard.getMobileNo()!=0)
            existingSimCard.setMobileNo(simCard.getMobileNo());
            if(simCard.getStatus()!=null)
            existingSimCard.setStatus(simCard.getStatus());
            if(simCard.getExpiryDate()!=null)
            existingSimCard.setExpiryDate(simCard.getExpiryDate());
            if(simCard.getStateOfRegistration()!=null)
            existingSimCard.setStateOfRegistration(simCard.getStateOfRegistration());
            if(simCard.getKYC()!=null)
            existingSimCard.setKYC(simCard.getKYC());
            if(simCard.getTelcomProvider()!=null)
            existingSimCard.setTelcomProvider(simCard.getTelcomProvider());
            if(simCard.getFullName()!=null)
            existingSimCard.setFullName(simCard.getFullName());
            simCardRepository.flush();
        }
    }
    public void delete(Long id) {
        simCardRepository.deleteById(id);
    }

    public List<SimCard> toRenew() {
        Calendar date=Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH,30);
        return listAll().stream().filter(simCard -> simCard.getExpiryDate()!=null&&
                date.toInstant().isAfter(simCard.getExpiryDate().toInstant())).toList();
    }

//    public void renew(Long id) throws JsonProcessingException {
//        if (simCardRepository.findById(id).isPresent()){
//            SimCard existingSimCard = simCardRepository.findById(id).get();
//            ObjectMapper objectMapper=new ObjectMapper();
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<String> request =
//                    new HttpEntity<String>("{}", headers);
//
//            String response =
//                    restTemplate.postForObject("some url", request, String.class);
//            JsonNode root = objectMapper.readTree(response);
//
//        }
//    }
}
