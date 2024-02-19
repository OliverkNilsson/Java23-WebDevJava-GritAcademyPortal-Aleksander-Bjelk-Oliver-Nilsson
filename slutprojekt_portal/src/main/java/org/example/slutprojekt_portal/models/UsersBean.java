package org.example.slutprojekt_portal.models;

import java.io.Serializable;

public class UsersBean implements Serializable {

    private USER_TYPE userType;
    private PRIVILAGE_TYPE privilageType = PRIVILAGE_TYPE.user;
    private STATE_TYPE stateType = STATE_TYPE.anonymous;


    public UsersBean() {
    }

    ;

    public USER_TYPE getUserType() {
        return userType;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }

    public STATE_TYPE getStateType() {
        return stateType;
    }

    public void setStateType(STATE_TYPE stateType) {
        this.stateType = stateType;
    }

    public PRIVILAGE_TYPE getPrivilageType() {
        return privilageType;
    }

    public void setUserPrivilage(PRIVILAGE_TYPE userPrivilage) {
        this.privilageType = userPrivilage;
    }

    @Override
    public String toString() {
        return userType + " " + privilageType + " " + stateType;
    }
}



