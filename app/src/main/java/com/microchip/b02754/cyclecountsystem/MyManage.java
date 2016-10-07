package com.microchip.b02754.cyclecountsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 10/6/2016 AD.
 */

public class MyManage {

    //Explicit
    private Context context;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    //For UserTable
    public static final String table_userTABLE = "userTABLE";

    public static final String column_id = "_id";
    public static final String column_Name = "Name";
    public static final String column_ID_card = "ID_card";
    public static final String column_User = "User";
    public static final String column_Password = "Password";
    public static final String column_Position = "Position";
    public static final String column_Status = "Status";

    //For Tb_CountTxns
    public static final String table_Tb_CountTxns = "Tb_CountTxns";
    public static final String column_LotID = "LotID";
    public static final String column_Quantity = "Quantity";
    public static final String column_Price = "Price";
    public static final String column_UOM = "UOM";
    public static final String column_CountedDateTime = "CountedDateTime";

    //For Tb_CountMst
    public static final String table_Tb_CountMst = "Tb_CountMst";
    public static final String column_TagName = "TagName";
    public static final String column_ShelfID = "ShelfID";
    public static final String column_TxnDateTime = "TxnDateTime";
    public static final String column_CountedBy = "CountedBy";
    public static final String column_CheckedBy = "CheckedBy";

    public MyManage(Context context) {
        this.context = context;

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    }   // Constructor

    public long addTb_CountMst(String strTagName,
                                String strShelfID,
                                String strTxnDateTime,
                                String strCountedBy,
                                String strCheckedBy,
                                String strStatus) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(column_TagName, strTagName);
        contentValues.put(column_ShelfID, strShelfID);
        contentValues.put(column_TxnDateTime, strTxnDateTime);
        contentValues.put(column_CountedBy, strCountedBy);
        contentValues.put(column_CheckedBy, strCheckedBy);
        contentValues.put(column_Status, strStatus);

        return sqLiteDatabase.insert(table_Tb_CountMst,null,contentValues);
    }

    public long addTb_CountTxns(String strTagName,
                                String strLotID,
                                String strQuantity,
                                String strPrice,
                                String strUOM,
                                String strCountedDateTime,
                                String strStatus) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(column_TagName, strTagName);
        contentValues.put(column_LotID, strLotID);
        contentValues.put(column_Quantity, strQuantity);
        contentValues.put(column_Price, strPrice);
        contentValues.put(column_UOM, strUOM);
        contentValues.put(column_CountedDateTime, strCountedDateTime);
        contentValues.put(column_Status, strStatus);

        return sqLiteDatabase.insert(table_Tb_CountTxns,null,contentValues);
    }

    public long addUserTABLE(String strName,
                             String strID_card,
                             String strUser,
                             String strPassword,
                             String strPosition,
                             String strStatus) {

        ContentValues contentValues = new ContentValues();
        //contentValues.put(column_id, str_id);
        contentValues.put(column_Name, strName);
        contentValues.put(column_ID_card, strID_card);
        contentValues.put(column_User, strUser);
        contentValues.put(column_Password, strPassword);
        contentValues.put(column_Position, strPosition);
        contentValues.put(column_Status, strStatus);

        return sqLiteDatabase.insert(table_userTABLE,null,contentValues);
    }




}   // Main Class