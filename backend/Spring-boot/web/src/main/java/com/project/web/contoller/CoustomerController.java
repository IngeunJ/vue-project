package com.project.web.contoller;

import java.util.HashMap;

import com.project.web.common.lamda.ISupplier;
import com.project.web.domain.CustomerDTO;
import com.project.web.entities.Customer;
import com.project.web.repositories.CustomerRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600) // 분리해서
@RequestMapping("customers")
@RestController
public class CoustomerController{
    @Autowired CustomerRepository cr;
    @Autowired ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper ();
        return modelMapper;
    }

    @RequestMapping("/")
    public String index(){
        
        return "index";
    }
    //@GetMapping("/login")
    @GetMapping("/count")
    public long	count(){
        System.out.println("===count() 진입=====");
        return cr.count();
    }
    @PostMapping("/login")
    public CustomerDTO login(@RequestBody CustomerDTO dto){
        System.out.println("로그인 진입");
        System.out.println("ID: "+dto.getCustomerId());
        System.out.println("PW: "+dto.getPassword());
        //람다를 이용하여 리턴 Modelmapper로 entity를 dto 변환
        ISupplier fx =  (() ->{
            return cr.findByCustomerIdAndPassword(dto.getCustomerId(),dto.getPassword());
        }); 
        CustomerDTO cust  = modelMapper.map(fx.get(), CustomerDTO.class);
        return cust;
    } 
    @PostMapping("")
    public HashMap<String,String> save(@RequestBody CustomerDTO dto){
        System.out.println("넘어온 값:"+dto.toString());
        HashMap<String,String> map = new HashMap<>();
        Customer cust  = new Customer();
        cust.setCustomerId(dto.getCustomerId());
        cust.setPassword(dto.getPassword());
        cust.setCustomerName(dto.getCustomerName());
        cust.setEmail(dto.getEmail());
        cust.setPhone(dto.getPhone());
        cust.setCity(dto.getCity());
        cust.setAddress(dto.getAddress());
        cust.setPostalcode(dto.getPostalcode());
        cust.setIntroduction(dto.getIntroduction());
        System.out.println("들어간값"+cust.toString());
        cr.save(cust);
        map.put("result", "SUCCESS");
        return map;
    }


    
}