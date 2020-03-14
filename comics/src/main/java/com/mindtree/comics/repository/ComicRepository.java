package com.mindtree.comics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.comics.entity.Comic;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Integer>{

}
