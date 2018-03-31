package com.emirates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.emirates.entity.Task;



@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long> {

	@Modifying
	@Query("update Task t set t.status = :status where t.name = :name")
	Integer updateTaskStatus(@Param("status") String status, @Param("name") String name);
}


