package com.mentoring.core;

import java.time.Duration;
import java.util.Calendar;

public class Configuration {

    public static final String EMAIL_ADDRESS = "mentoring.test.email@gmail.com";
    public static final String EMAIL_PASSWORD = "Hard_Passw0rd";

    public static final Duration WAIT_TIMEOUT = Duration.ofSeconds(15);
    public static final Duration WAIT_POLLING_INTERVAL = Duration.ofSeconds(1);

    public static final String DATE_TODAY = Calendar.getInstance().getTime().toString();

}
