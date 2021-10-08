package com.oxygen.backendoxygen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.backendoxygen.model.Rol;

@Repository
public interface RolDao extends JpaRepository<Rol, Long> {

}
