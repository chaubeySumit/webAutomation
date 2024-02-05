package com.company.dataProvider;

import org.testng.annotations.DataProvider;

public class Browser {

    @DataProvider(name="BrowserData")
    public Object[][] getBrowserData(){
        return new Object[][]
                {
                        {"chrome"}
                };

    }
}
