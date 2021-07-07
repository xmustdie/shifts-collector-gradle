package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.WorkedEvent;
import com.goodt.shiftscollectorgradle.repository.WorkedEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkedEventService {
    private final WorkedEventRepository repository;

    public WorkedEvent create(WorkedEvent workedEvent) {
        if (workedEvent == null) return null;
        return repository.save(workedEvent);
    }
}