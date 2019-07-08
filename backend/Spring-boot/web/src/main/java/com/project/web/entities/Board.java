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
@Table(name = "Board")
public class Board implements Serializable /**직렬화 데이터를 한줄로 세운다. */ 
{
    

    /**
     * 객체 스트림으로 변환하는 것을 직렬화 스트림을 객체로 변환하는게 역직렬화
     */

    private static final long serialVersionUID = 1L; //직렬화 버전()
    
    //pk를 자동생성하는 방식
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //IDENTITY sequences 때문에 전역적으로 하면안되서...
    private Long bno;
    @Column(name="title") private String title;
    @Column(name="content") private String content;


    //tostring 스트링타입으로 리턴해주기 위해 사용한다.
  
    
    @Override
    public String toString() {
        return "board [content=" + content + ", title=" + title + "]";
    }

    //모델객체를 생성하기위해 롬복에 있는 빌터패턴을 사용함.
    @Builder
    public Board(String title,String text,Long bno){
        this.bno = bno;
        this.title= title;
        this.content= content;

    }


 

    
  
}