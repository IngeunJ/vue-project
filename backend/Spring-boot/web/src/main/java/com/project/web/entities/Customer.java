package com.project.web.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity
@Setter
@ToString
@Table(name = "customers")
public class Customer implements Serializable /**직렬화 데이터를 한줄로 세운다. */ 
{
    

    /**
     * 객체 스트림으로 변환하는 것을 직렬화 스트림을 객체로 변환하는게 역직렬화
     */

    private static final long serialVersionUID = 1L; //직렬화 버전()
    
    //pk를 자동생성하는 방식
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="customer_id") private String customerId;
    @Column(name="password") private String password;
    @Column(name="customer_name") private String customerName;
    @Column(name="email") private String email;
    @Column(name="phone") private String phone;
    @Column(name="city") private String city;
    @Column(name="address") private String address;
    @Column(name="postalcode") private String postalcode;
    @Column(name="introduction") private String introduction;


    //tostring 스트링타입으로 리턴해주기 위해 사용한다.
    @Override
    public String toString() {
        return "Customer [address=" + address + ", city=" + city + ", customerId=" + customerId + ", customerName="
                + customerName + ", email=" + email + ", id=" + id + ", introduction=" + introduction + ", password="
                + password + ", phone=" + phone + ", postalcode=" + postalcode + "]";
    }

    //모델객체를 생성하기위해 롬복에 있는 빌터패턴을 사용함.
    @Builder
    public Customer(String customerId,String password,String customerName,String email,String phone,String city,String address,
    String postalcode,String introduction){
        this.customerId = customerId;
        this.password = password;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.address = address;
        this.postalcode = postalcode;
        this.introduction = introduction;

    }


 

    
  
}