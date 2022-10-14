package com.bv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bv.entity.CitizenApps;

public interface CitizenAppsRepository extends JpaRepository<CitizenApps, Serializable> {

}
