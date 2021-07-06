package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.Shift;
import com.goodt.shiftscollectorgradle.repository.ShiftRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShiftService {
    private final ShiftRepository repository;

    public Shift create(Shift shift) {
        if (shift == null) return null;
        return repository.save(shift);
    }
}
