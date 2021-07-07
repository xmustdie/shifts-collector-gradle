package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.Position;
import com.goodt.shiftscollectorgradle.repository.PositionRepository;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    private PositionRepository repository;

    public Position save(Position position) {
        if (!position.isNew() && get(position.getName()) == null) {
            return get(position.getName());
        } else {
            return repository.save(position);
        }
    }

    public Position get(String name) {
        return repository.findFirstByName(name);
    }
}
