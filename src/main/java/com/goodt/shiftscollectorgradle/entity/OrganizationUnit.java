package com.goodt.shiftscollectorgradle.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "organization_units")
public class OrganizationUnit extends AbstractBaseEntity{

    @Column(name = "outer_id")
    private String outerId;

    @Column(name = "title")
    private String title;
}
