package com.goodt.shiftscollectorgradle.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class GetTimesheetRosterReport {
    private ArrayList<WorkedEvent> workedEvents;
    private OrganizationUnit organizationUnit;
}
