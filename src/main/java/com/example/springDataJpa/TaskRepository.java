package com.example.springDataJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t from Task t WHERE t.isDone = FALSE order by t.deadline asc")
    List<Task> findByDoneIsFalse();

    @Query("SELECT t from Task t WHERE t.isDone = TRUE order by t.deadline asc")
    List<Task> findByDoneIsTrue();

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.isDone = TRUE WHERE t.id = :id")
    void checkTaskAsDone(Long id);

}
