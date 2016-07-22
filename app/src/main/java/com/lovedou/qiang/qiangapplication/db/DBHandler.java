package com.lovedou.qiang.qiangapplication.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lovedou.qiang.qiangapplication.bean.User;

import java.util.List;

/**
 * Created by Qiang on 2016/7/13.
 *
 */
public class DBHandler {

    private static final String TAG = "DBHandler";

    private static volatile DBHandler mInstance = null;
    protected volatile SQLiteDatabase mDB = null;
    protected SQLiteOpenHelper mDatabaseHelper = null;


    /**
     *  必须在应用启动的时候调用一下
     **/
    public static DBHandler getInstance( Context context ) {

        if( null == mInstance ) {
            synchronized( DBHandler.class ) {
                if( mInstance == null ) {
                    if( null == context ) {
                        throw new IllegalArgumentException( "context is null" );
                    } else {
                        mInstance = new DBHandler( context );
                    }
                }
            }
        }
        return mInstance;
    }


    private DBHandler( Context context ) {
        mDatabaseHelper = new DBHelper( context.getApplicationContext() );
        open();
    }

    /**
     * 打开数据库
     *
     * @return SQLiteDatabase
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

    public void addUser(User user){
        if(user==null){return;}
        getDB().beginTransaction();
        long result=getDB().insert(User.TABLE_NAME,null,user.toContentValues());
        //getDB().execSQL("insert into user values(null,?,?)",new Object[]{user.getUsername(),user.getPassword()});
        getDB().close();
    }

    public void addUserList(List<User> userList){
        if(userList==null){return;}
        getDB().beginTransaction();
        for(User user:userList){
            getDB().insert(User.TABLE_NAME,null,user.toContentValues());
            //getDB().execSQL("insert into user values(null,?,?)",new Object[]{user.getUsername(),user.getPassword()});
        }
        getDB().close();
    }

    public void deleteUser(User user){
        getDB().beginTransaction();
        //getDB().delete(User.TABLE_NAME,User.USERNAME,new String[]{user.getUsername()});
        getDB().execSQL("delete from "+User.TABLE_NAME+" where "
                + User.USERNAME+"="+user.getUsername()
                +" and "
                + User.PASSWORD+"="+user.getPassword());
        getDB().close();
    }

    public User searchUser(String userName){
        getDB().beginTransaction();
        Cursor cursor=getDB().query(User.TABLE_NAME,null,User.USERNAME,new String[]{userName},null,null,null);
        getDB().close();
        User mUser=null;
        while (cursor!=null&&cursor.moveToNext()){
            mUser=new User();
            mUser.setUsername(cursor.getString(cursor.getColumnIndex(User.USERNAME)));
            mUser.setUsername(cursor.getString(cursor.getColumnIndex(User.PASSWORD)));
            break;
        }
        if (cursor != null) {
            cursor.close();
        }
        return mUser;
    }


}
