package com.project.web.repositories;

import java.util.List;

import com.project.web.entities.Board;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * CustomerRepository
 */
@Repository //저장소 Mapper
public interface BoardRepository extends CrudRepository<Board,Long>{
     
    @Query(value = "SELECT MAX(bno) from board"
    ,nativeQuery = true)
	public int SEQUNCE();

}