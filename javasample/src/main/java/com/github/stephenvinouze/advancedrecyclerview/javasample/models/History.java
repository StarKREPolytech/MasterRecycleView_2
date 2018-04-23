package com.github.stephenvinouze.advancedrecyclerview.javasample.models;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Игорь Гулькин 24.04.2018
 *
 * Класс History описывает историю сеанса EEG.
 */

public final class History {

    /**
     * 1.) id указывает номер элемента;
     * 2.) rate указывает приоритет элемента;
     * 3.) name указывает имя элемента;
     * 4.) startTime указывает время начала сеанса;
     * 5.) endTime указывает время окончания сеанса.
     */

    private int id;

    private int rate;

    private String name;

    private final String startTime;

    private String endTime;

    /**
     * Используется пустой конструктор по умолчанию.
     * Таким образом, поля устанавливаются вручную
     * через сеттеры кроме времени.
     */

    public History(){
        //Устанавливаем время начала сеанса:
        this.startTime = this.getCurrentTime();
    }

    /**
     * getCurrentTime()
     *
     * @return текущее время в формате строки
     */

    private String getCurrentTime(){
        final Date date = Calendar.getInstance().getTime();
        @SuppressLint("SimpleDateFormat")
        final DateFormat commonDateFormat = new SimpleDateFormat("yyyy.dd.MM");
        @SuppressLint("SimpleDateFormat")
        final DateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return commonDateFormat.format(date) + simpleDateFormat.format(date);
    }

    /**
     * Стандартное объявление геттеров и сеттеров.
     */

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getRate() {
        return rate;
    }

    public final void setRate(final int rate) {
        this.rate = rate;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getStartTime() {
        return startTime;
    }

    public final String getEndTime(){
        return endTime;
    }

    public final void setEndTime(){
        this.endTime = this.getCurrentTime();
    }
}