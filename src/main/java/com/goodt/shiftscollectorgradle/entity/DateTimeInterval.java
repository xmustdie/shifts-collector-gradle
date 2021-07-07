package com.goodt.shiftscollectorgradle.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class DateTimeInterval {
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
}
