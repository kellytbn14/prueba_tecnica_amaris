package com.kellytbn.msstudenttest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "class_test")
@Entity
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RegistrationTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "eid")
    private Long eid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eid", insertable = false, updatable = false)
    private StudentTest studentTest;

    @Column(name = "class_name")
    private String className;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_name", insertable = false, updatable = false)
    private ClassTest classTest;

    @Column(name = "position")
    private Integer position;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
