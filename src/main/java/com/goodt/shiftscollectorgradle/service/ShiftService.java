package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.WorkedEvent;
import com.goodt.shiftscollectorgradle.repository.ShiftRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShiftService {
    private final ShiftRepository repository;

    public WorkedEvent create(WorkedEvent workedEvent) {
        if (workedEvent == null) return null;
        return repository.save(workedEvent);
    }
}
