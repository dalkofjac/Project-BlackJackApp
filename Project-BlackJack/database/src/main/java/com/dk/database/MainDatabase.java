package com.dk.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Dalibor on 12.2.2018..
 */

@Database(name = MainDatabase.NAME, version = MainDatabase.VERSION)
public class MainDatabase {
    public static final String NAME = "main";
    public static final int VERSION = 1;
}
