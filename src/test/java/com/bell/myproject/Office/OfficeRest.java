package com.bell.myproject.Office;

public interface OfficeRest {
    public void getOfficeById_IdEqualOne_Success() throws Exception;

    public void getOfficeById_NoSuchOffice_NoSuchExceptionThrown() throws Exception;
    
    public void updateOfficeById_IdEqualTwo_Success() throws Exception;

    public void updateOfficeById_WithIncorrectId_NoSuchOfficeExceptionThrown() throws Exception;

    public void updateOfficeById_EmptyAddress_NoValidRequestExceptionThrown() throws Exception;

    public void updateOfficeById_EmptyName_NoValidRequestExceptionThrown() throws Exception;

    public void updateOfficeById_NoAddress_NoValidRequestExceptionThrown() throws Exception;

    public void updateOfficeById_NoName_NoValidRequestExceptionThrown() throws Exception;

    public void updateOfficeById_NoValidRequest_NoValidRequestExceptionThrown() throws Exception;

    public void saveOfficeById_CorrectRequest_Success() throws Exception;

    public void saveOfficeById_WithIncorrectId_NoSuchOrganizationExceptionThrown() throws Exception;

    public void saveOfficeById_NoValidRequest_NoValidRequestExceptionThrown() throws Exception;

    public void getListOfOffices_ValidRequestOrgIdEqualTwo_Success() throws Exception;

    public void getListOfOffices_ValidRequestOrgIdEqualTwoAndNameIsEmpty_Success() throws Exception;

    public void getListOfOffices_ValidRequestOrgIdEqualTwoAndNameIsEmptyAndPhoneEqualSeven_Success() throws Exception;

    public void getListOfOffices_ValidRequestNoSuchOrgId_Success() throws Exception;

    
}
