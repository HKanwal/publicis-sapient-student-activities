package com.sapient.dbexample.model.dao;

import com.sapient.dbexample.model.beans.User_;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User_, Integer> { }
