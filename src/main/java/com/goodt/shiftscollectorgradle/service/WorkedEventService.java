package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.WorkedEvent;
import com.goodt.shiftscollectorgradle.repository.WorkedEventRepository;
import org.springframework.stereotype.Service;

@Service("workedEventService")
public class WorkedEventService {
    private final WorkedEventRepository repository;

    public WorkedEventService(WorkedEventRepository repository) {
        this.repository = repository;
    }

    public WorkedEvent save(WorkedEvent workedEvent) {
        if (workedEvent == null) return null;
        return repository.save(workedEvent);
    }
}
