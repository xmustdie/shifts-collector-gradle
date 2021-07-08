package com.goodt.shiftscollectorgradle.repository;

import com.goodt.shiftscollectorgradle.entity.Employee;
import com.goodt.shiftscollectorgradle.entity.WorkedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface WorkedEventRepository extends JpaRepository<WorkedEvent, Integer> {

    boolean existsWorkedEventByEmployeeAndStartDateTimeAndEndDateTime(Employee employee,
                                                                      LocalDateTime start,
                                                                      LocalDateTime end);

    WorkedEvent findFirstByEmployee_IdAndStartDateTimeAndEndDateTime(Integer employeeId, LocalDateTime start,
                                                                     LocalDateTime end);
}
