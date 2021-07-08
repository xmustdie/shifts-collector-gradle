package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.WorkedEvent;
import com.goodt.shiftscollectorgradle.repository.WorkedEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("workedEventService")
@AllArgsConstructor
public class WorkedEventService {
    private WorkedEventRepository repository;

    public WorkedEvent save(WorkedEvent workedEvent) {
        if (workedEvent == null) return null;
        if (checkUniqueWorkedEvent(workedEvent)) {
            return get(workedEvent);
        }
        return repository.save(workedEvent);
        //TODO check Event for uniqueness
        //TODO ScheduleRequest exclude
    }

    private WorkedEvent get(WorkedEvent workedEvent) {
        return repository.findFirstByEmployee_IdAndStartDateTimeAndEndDateTime(
                workedEvent.getEmployee().getId(), workedEvent.getStartDateTime(),
                workedEvent.getEndDateTime());
    }

    private boolean checkUniqueWorkedEvent(WorkedEvent workedEvent) {
        return repository.existsWorkedEventByEmployeeAndStartDateTimeAndEndDateTime(workedEvent.getEmployee(), workedEvent.getStartDateTime(),
                workedEvent.getEndDateTime());
    }
}
