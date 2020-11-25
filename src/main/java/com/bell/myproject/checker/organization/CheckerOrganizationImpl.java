package com.bell.myproject.checker.organization;

import com.bell.myproject.view.organization.OrganizationView;

import org.springframework.stereotype.Service;

@Service
public class CheckerOrganizationImpl implements Checker{
    
    @Override
    public boolean checkListRequest(OrganizationView organizationView) {
        if (organizationView.getName().equals(""))
            return false;
        return true;
    }

    @Override
    public boolean checkSaveRequest(OrganizationView organizationView) {
        if (organizationView.getName().equals("")) {
            return false;
        } else if (organizationView.getFullName().equals("")) {
            return false;
        } else if (organizationView.getInn().equals("")) {
            return false;
        } else if (organizationView.getKpp().equals("")) {
            return false;
        } else if (organizationView.getAddress().equals("")) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkUpdateRequest(OrganizationView organizationView) {
        if (organizationView.getName().equals("")) {
            return false;
        } else if (organizationView.getFullName().equals("")) {
            return false;
        } else if (organizationView.getInn().equals("")) {
            return false;
        } else if (organizationView.getKpp().equals("")) {
            return false;
        } else if (organizationView.getAddress().equals("")) {
            return false;
        } else if (organizationView.getId() == 0) {
            return false;
        }
        return true;
    }
}
