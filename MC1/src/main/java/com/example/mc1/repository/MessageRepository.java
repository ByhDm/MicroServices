package com.example.mc1.repository;

import com.example.mc1.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    Optional<MessageEntity> findFirstByOrderByIdDesc();
}
