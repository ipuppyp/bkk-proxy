package com.ipuppyp.bkkproxy.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipuppyp.bkkproxy.entity.StopEntity;

public interface StopRepository extends JpaRepository<StopEntity, Integer> {

	Collection<StopEntity> findByEnabledTrue();
}
