package com.mindtree.comics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.comics.entity.SuperHero;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Integer>{

}
