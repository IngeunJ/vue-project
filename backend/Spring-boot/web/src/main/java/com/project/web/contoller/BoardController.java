package com.project.web.contoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.project.web.common.lamda.ISupplier;
import com.project.web.domain.BoardDTO;
import com.project.web.repositories.BoardRepository;
import com.project.web.entities.Board;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600) // 분리해서
@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired BoardDTO dto;
    @Autowired ModelMapper modelMapper2; // DTO,Entity 타입 변환해준다.
    @Autowired BoardRepository br; 

    @Bean
    public ModelMapper modelMapper2() {
        return new ModelMapper();
    }
    //리스트 뿌리기
    @GetMapping("")
    public List<BoardDTO> findAll() {
        Iterable<Board> entities = br.findAll();
        List<BoardDTO> list = new ArrayList<>();
        for (Board b : entities) {
            BoardDTO bo = modelMapper2.map(b, BoardDTO.class);
            list.add(bo);
        }
        System.out.println(list);
        return list;
    }
    //상세페이지
    @GetMapping("/{id}")
    public BoardDTO findById(@PathVariable String id) {
        //
        BoardDTO d = modelMapper2.map(br.findById(Long.parseLong(id)).orElseThrow(EntityNotFoundException::new),
        BoardDTO.class);
        System.out.println(id);
        return d;
    }
    //게시물 저장
    @PostMapping("")
    public HashMap<String, String> save(@RequestBody BoardDTO dto) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println(dto);
        Board entity = new Board();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        System.out.println(entity);
        br.save(entity);
        map.put("result", "success");
        return map;
    }

    //게시물 수정
    @PutMapping("/{id}")
    public HashMap<String, String> updateList(@PathVariable String id, @RequestBody BoardDTO dto) {       
        Board entity = br.findById(Long.parseLong(id)).get();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        br.save(entity);
        HashMap map = new HashMap<>();
        map.put("result", "SUCCESS");
        return map;
    }
    //게시물 삭제
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
     System.out.println(id);
       br.deleteById(Long.parseLong(id));
    }




}