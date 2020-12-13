package com.bell.myproject.Organization;

public interface OrganizationRest {
    public void GetOrganizationById_IdEqualsOne_Success() throws Exception;

    public void GetOrganizationById_IdEqualsOneHundred_NoSuchOrganizationExceptionThrown() throws Exception;

    public void GetListOfOrganization_FilterNameEqual_S_Success() throws Exception;

    public void GetListOfOrganization_LengthOfInnEqual13_BadRequest() throws Exception;

    public void UpdateOrganization_WithSomeValues_Success() throws Exception;

    public void UpdateOrganization_NoSuchOrgId_NoSuchExceptionThrown() throws Exception;

    public void UpdateOrganization_IncorrectLenghtOfInn_NoValidExceptionThrown() throws Exception;

    public void UpdateOrganization_IncorrectLenghtOfKpp_NoValidExceptionThrown() throws Exception;

    public void UpdateOrganization_NoKpp_NoValidExceptionThrown() throws Exception;

    public void UpdateOrganization_EmptyName_NoValidExceptionThrown() throws Exception;

    public void UpdateOrganization_NoInn_NoValidExceptionThrown() throws Exception;

    public void UpdateOrganization_NoName_NoValidExceptionThrown() throws Exception;

    public void UpdateOrganization_NoAddress_NoValidExceptionThrown() throws Exception;

    public void UpdateOrganization_NoFullName_NoValidExceptionThrown() throws Exception;

    public void UpdateOrganization_NoId_NoValidExceptionThrown() throws Exception;

    public void SaveOrganization_CorrectRequest_Success() throws Exception;

    public void SaveOrganization_NoName_NoValidExceptionThrown() throws Exception;

    public void SaveOrganization_NoFulName_NoValidExceptionThrown() throws Exception;

    public void SaveOrganization_NoAdress_NoValidExceptionThrown() throws Exception;

    public void SaveOrganization_EmptyName_NoValidExceptionThrown() throws Exception;

    public void SaveOrganization_EmptyFullName_NoValidExceptionThrown() throws Exception;

    public void SaveOrganization_EmptyAddress_NoValidExceptionThrown() throws Exception;

    public void SaveOrganization_IncorrectLenghtOfKpp_NoValidExceptionThrown() throws Exception;

    public void SaveOrganization_IncorrectLenghtOfInn_Success() throws Exception;
}
