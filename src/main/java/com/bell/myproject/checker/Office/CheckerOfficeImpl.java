package com.bell.myproject.checker.Office;

import com.bell.myproject.view.office.OfficeView;
import org.springframework.stereotype.Service;

@Service
public class CheckerOfficeImpl implements Checker{
    @Override
    public boolean checkOfficeListRequest(OfficeView officeView) {
        if (officeView.getOrgId() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkOfficeUpdate(OfficeView officeView) {
        if (officeView.getId() == 0) {
            return false;
        }
        if (officeView.getName() == null) {
            return false;
        }
        if (officeView.getAddress() == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkOfficeSave(OfficeView officeView) {
        if (officeView.getOrgId() == 0) {
            return false;
        }
        return true;
    }
}
