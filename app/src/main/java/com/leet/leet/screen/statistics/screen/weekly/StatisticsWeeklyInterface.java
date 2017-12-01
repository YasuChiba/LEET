package com.leet.leet.screen.statistics.screen.weekly;

import org.joda.time.LocalDate;

/**
 * Created by YasuhiraChiba on 2017/12/01.
 */

//interface for connecting weeklyfragment and statisticsfragment
public interface StatisticsWeeklyInterface {

    void changeToDaily(LocalDate date);
}
