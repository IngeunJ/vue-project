package com.project.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
/**
 * boardDTO
 */
@Data @Component @Lazy
public class BoardDTO {

    private String title,content;
    private Long bno;

}