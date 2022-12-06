package com.example.mc1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "message")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "session_id", nullable = false)
    private Long session_id;

    @Column(name = "MC1_timestamp")
    private Long mc1_timestamp;

    @Column(name = "MC2_timestamp")
    private Long mc2_timestamp;

    @Column(name = "MC3_timestamp")
    private Long mc3_timestamp;

    @Column(name = "end_timestamp")
    private Long end_timestamp;
}