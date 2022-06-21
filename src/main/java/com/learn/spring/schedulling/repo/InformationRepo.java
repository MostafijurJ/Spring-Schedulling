package com.learn.spring.schedulling.repo;

import com.learn.spring.schedulling.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepo extends JpaRepository<Information, Integer> {
}
