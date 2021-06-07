package com.mentoring.core;

import static com.mentoring.driver.DriverUtils.getDriver;

public final class ConciseAPI {

    public static String getPageTitle() {
        return getDriver().getTitle();
    }

    public static void visit(String link) {
        getDriver().get(link);
    }
}
