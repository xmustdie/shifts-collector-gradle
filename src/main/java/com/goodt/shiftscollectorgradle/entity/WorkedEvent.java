package com.goodt.shiftscollectorgradle.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "worked_events")
public class WorkedEvent extends AbstractBaseEntity {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    public static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    @Column(name = "typename")
    private String __typename;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private String type;

    @Column(name = "day_type")
    private String dayType;

    @Column(name = "lunch_time")
    private Double lunchTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Position position;

    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_position_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmployeePosition employeePosition;
}
