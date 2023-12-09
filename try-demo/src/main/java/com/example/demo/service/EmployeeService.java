package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;



    public void getAllEmployee() throws Exception {


        String data = "{\"eventName\": \"Load\", \"resourceName\": \"mbs\","+
                "\"details\":{" +
                "\"errorCode\": \"invalid_otp_required1\"," +
                "\"data\":{" +
                "\"detailsMap\":{" +
                "\"logDto\":{" +
                "\"status\": \"Success\", \"currencyCode\": \"PHP\", \"amount\": \"100\", \"mobileNumber\":\"+6342304923049\" }"+

                "}}}}}";

        System.out.println(data);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> result;
        result = mapper.readValue(data, HashMap.class);

//        HashMap<String, HashMap<String, HashMap<String, HashMap<String, Object>>>> details =
//                (HashMap<String, HashMap<String, HashMap<String, HashMap<String, Object>>>>) result.get("details");

        HashMap<String, Object> details =
                (HashMap<String, Object>) result.get("details");
        System.out.println(details);
//        HashMap<String, HashMap<String, Object>> stringObjectHashMap = details.get("data").get("detailsMap");

        if(details.containsKey("errorCode") && "invalid_otp_required".equalsIgnoreCase((String) details.get("errorCode"))){
                System.out.println("Requested");
        }

        HashMap<String, Object> dataHashMap =
                (HashMap<String,  Object> ) details.get("data");
        HashMap<String, HashMap<String,  Object> > detailsMap =
                (HashMap<String, HashMap<String,  Object> >) dataHashMap.get("detailsMap");

        if(detailsMap.containsKey("logDto")){
            System.out.println((String) detailsMap.get("logDto").get("status"));
        }

//        ObjectMapper mapper2 = new ObjectMapper();
//        HashMap<String, Object> result2;
//        result2 = mapper2.readValue(detailsMap, HashMap.class);
//        String logDto = (result2.get("logDto")).toString();
//
//        System.out.println(logDto);
//        ObjectMapper mapper3 = new ObjectMapper();
//        HashMap<String, Object> result3;
//        result3 = mapper3.readValue(logDto, HashMap.class);
//        String status = (result3.get("status")).toString();
    }






}
