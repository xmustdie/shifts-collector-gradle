package com.goodt.shiftscollectorgradle.entity;

import lombok.Data;

@Data
public class GetTimesheetRosterReport {
    private WorkedEvent[] workedEvents;
    private OrganizationUnit organizationUnit;
}
