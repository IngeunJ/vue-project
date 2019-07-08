package com.project.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 @Component 개발자가 직접 작성한 Class를 Bean으로 등록하기 위해.
 @Data getter,setter,@ToString 과 @EqualsAndHashCode를 적용시켜 메소드를 오버라이드 해주며 @RequiredArgsConstructor를 지정해 준다.
 @Lazy 한번에 작업.
 */
@Data @Component @Lazy
public class CustomerDTO {

    private String customerId,password,customerName,email,phone,city,address,postalcode,introduction;


    
}