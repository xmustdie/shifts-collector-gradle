package com.goodt.shiftscollectorgradle.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "positions")
public class Position extends AbstractBaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "organization_id")
    private Integer organizationExternalId;
}
