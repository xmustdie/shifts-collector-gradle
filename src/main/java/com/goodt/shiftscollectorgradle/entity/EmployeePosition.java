package com.goodt.shiftscollectorgradle.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employee_positions")
public class EmployeePosition extends AbstractBaseEntity{

    @Column(name = "external_id")
    private Integer externalId;
    @Column (name = "card_number")
    private String cardNumber;
}
