package com.bell.myproject.checker.organization;

import com.bell.myproject.view.organization.OrganizationView;

public interface Checker {
    boolean checkListRequest(OrganizationView organizationView);

    boolean checkUpdateRequest(OrganizationView organizationView);

    boolean checkSaveRequest(OrganizationView organizationView);
}
