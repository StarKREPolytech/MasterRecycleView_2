package com.github.stephenvinouze.advancedrecyclerview.javasample.models;

import java.util.ArrayList;

/**
 * Created by Stephen Vinouze on 09/11/2015.
 */
public class History {

    /**
     * id указывает номер элемента;
     * rate указывает приоритет элемента;
     * name указывает имя элемента.
     */

    private int id;

    private int rate;

    private String name;

    /**
     * Используется пустой конструктор по умолчанию.
     * Таким образом, поля устанавливаются вручную
     * через сеттеры.
     */

    public History(){}

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
}
