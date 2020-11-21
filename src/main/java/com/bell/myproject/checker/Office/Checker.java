package com.bell.myproject.checker.Office;

import com.bell.myproject.view.OfficeView;

public interface Checker {
    boolean checkOfficeListRequest(OfficeView officeView);

    boolean checkOfficeUpdate(OfficeView officeView);

    boolean checkOfficeSave(OfficeView officeView);
}
