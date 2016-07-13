package com.lovedou.qiang.qiangapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;

/**
 * Created by Qiang on 2016/7/13.
 */
public class DBHandler {

    private static final String TAG = "DBHandler";

    private static volatile DBHandler mInstance = null;
    protected volatile SQLiteDatabase mDB = null;
    protected SQLiteOpenHelper mDatabaseHelper = null;


    /**
     *  必须在应用启动的时候调用一下
     **/
    public static DBHandler getInstance( Context context ) throws IOException {

        if( null == mInstance ) {
            synchronized( DBHandler.class ) {
                if( mInstance == null ) {
                    if( null == context ) {
                        throw new IOException( "context is null" );
                    } else {
                        mInstance = new DBHandler( context );
                    }
                }
            }
        }
        return mInstance;
    }


    private DBHandler( Context context ) {

        mDatabaseHelper = new DBHelper( context );
        open();
    }

    /**
     * 打开数据库
     *
     * @return
     */
    private SQLiteDatabase open() {

        if( null == mDB ) {
            mDB = mDatabaseHelper.getWritableDatabase();
        }
        return mDB;
    }


    /**
     * 数据库
     *
     * @return
     */
    public SQLiteDatabase getDB() {

        if( null == mDB ) {
            synchronized( this ) {
                if( mDB == null ) {
                    mDB = mDatabaseHelper.getWritableDatabase();
                }
            }
        }
        return mDB;
    }


    /**
     * 关闭数据库
     */
    public synchronized void destroy() {

        if( mDB != null ) {
            if( mDB.isOpen() ) {
                mDB.close();
                mDB = null;
            }
        }
        mInstance = null;
    }


    public void deleteTable( String tableName ) {

        if( mDB != null ) {
            mDB.delete( tableName, null, null );
        }
    }

}
