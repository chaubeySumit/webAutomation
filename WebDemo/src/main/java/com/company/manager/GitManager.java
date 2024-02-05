package com.company.manager;

import com.company.utils.Base;
import com.company.utils.ILogger;
import com.company.utils.ReadEnvDetails;
import com.company.utils.ReadIdentifier;

public class GitManager implements ILogger {
    private final ReadEnvDetails readEnvDetails;
    private final ReadIdentifier readIdentifier;
    private final Base base;

    public GitManager() {
        this.readEnvDetails = new ReadEnvDetails();
        this.readIdentifier = new ReadIdentifier();
        this.base = new Base();
    }

    public ReadEnvDetails getReadEnvDetails() {
        return readEnvDetails;
    }

    public ReadIdentifier getReadIdentifier() {
        return readIdentifier;
    }

    public Base getBase() {
        return base;
    }


}
