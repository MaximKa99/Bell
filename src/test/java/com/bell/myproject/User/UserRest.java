package com.bell.myproject.User;

public interface UserRest {
    public void GetUserById_IdEqualThree_Success() throws Exception;

    public void GetUserById_IdEqualTen_NoSuchUserExceptionThrown() throws Exception;

    public void UpdateUser_ValidRequest_Success() throws Exception;

    public void UpdateUser_NoValidRequestNoId_NoValidRequestException() throws Exception;

    public void UpdateUser_NoFirstName_NoValidRequestException() throws Exception;

    public void UpdateUser_EmptyFirstName_NoValidRequestException() throws Exception;

    public void UpdateUser_NoPosition_NoValidRequestException() throws Exception;

    public void UpdateUser_EmptyPosition_NoValidRequestException() throws Exception;

    public void UpdateUser_NoSuchOfficeId_NoSuchOfficeExceptionThrown() throws Exception;

    public void SaveUser_ValidRequest_Success() throws Exception;

    public void SaveUser_NoOfficeId_NoValidRequestException() throws Exception;

    public void SaveUser_EmptyOfficeId_NoValidRequestException() throws Exception;

    public void SaveUser_NoFirstName_NoValidRequestException() throws Exception;

    public void SaveUser_EmptyFirstName_NoValidRequestException() throws Exception;

    public void SaveUser_NoPostion_NoValidRequestException() throws Exception;

    public void SaveUser_EmptyPostion_NoValidRequestException() throws Exception;

    public void GetListOfUsers_OfficeIdEqualOne_Success() throws Exception;

    public void GetListOfUsers_NoOfficeId_NoValidRequestException() throws Exception;

    public void GetListOfUsers_EmptyOfficeId_NoValidRequestException() throws Exception;

    
}
