package com.example.attend.common;

public enum AttendCategory {


    STANDARD("8","19","일반"),
    MORNING_OFF("8","14","오전 반차"),
    AFTERNOON_OFF("13","19","오후 반차");

    private String startTime;
    private String endTime;
    private String attendType;

    AttendCategory(String startTime, String endTime, String attendType) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.attendType = attendType;
    }
}
