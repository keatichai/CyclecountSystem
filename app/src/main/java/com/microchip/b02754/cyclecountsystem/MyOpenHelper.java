package com.microchip.b02754.cyclecountsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterUNG on 10/6/2016 AD.
 */

public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    private Context context;
    public static final String database_name = "Cycle.db";
    private static final int database_version = 1;

    private static final String create_table_user = "create table userTABLE (" +
            "_id integer primary key," +
            "Name text," +
            "ID_card text," +
            "User text," +
            "Password text," +
            "Position text," +
            "Status text);";

    private static final String create_table_Tb_CountTxns = "create table Tb_CountTxns (" +
            "TagName integer primary key," +
            "LotID text, " +
            "Quantity text," +
            "Price text," +
            "UOM text," +
            "CountedDateTime text," +
            "Status text);";



    private static final String create_table_Tb_CountMst = "create table Tb_CountMst (" +
            "TagName integer primary key," +
            "ShelfID text," +
            "TxnDateTime text," +
            "CountedBy text," +
            "CheckedBy text," +
            "Status text);";

    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_table_Tb_CountMst);
        sqLiteDatabase.execSQL(create_table_Tb_CountTxns);
        sqLiteDatabase.execSQL(create_table_user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class