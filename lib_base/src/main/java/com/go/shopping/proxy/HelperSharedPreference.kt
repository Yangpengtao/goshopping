package com.go.shopping.proxy

import com.go.shopping.lib_base.shared_preference.interfaces.ISharedPreferenceProcessor


/**
 * sp的代理
 */

object HelperSharedPreference  :
    ISharedPreferenceProcessor {



    private var mSharedPreferenceProcessor: ISharedPreferenceProcessor? = null

    fun  init( iSharedPreferenceProcessor: ISharedPreferenceProcessor) {
        mSharedPreferenceProcessor = iSharedPreferenceProcessor
    }

    override fun putData(key: String, value: Any) {
        mSharedPreferenceProcessor!!.putData(key, value)
    }

    override fun getData(key: String, dataType: Int): Any {
        return mSharedPreferenceProcessor!!.getData(key, dataType)
    }

    override fun getData(key: String, defaultValue: Any, dataType: Int): Any {
        return mSharedPreferenceProcessor!!.getData(key, defaultValue, dataType)
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return mSharedPreferenceProcessor!!.getBoolean(key, defaultValue)
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return mSharedPreferenceProcessor!!.getInt(key, defaultValue)
    }

    override fun getFloat(key: String, defaultValue: Float): Float {
        return mSharedPreferenceProcessor!!.getFloat(key, defaultValue)
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        return mSharedPreferenceProcessor!!.getLong(key, defaultValue)
    }

    override fun getString(key: String, defaultValue: String): String {
        return mSharedPreferenceProcessor!!.getString(key, defaultValue)
    }

    override fun getBoolean(key: String): Boolean {
        return mSharedPreferenceProcessor!!.getBoolean(key)
    }

    override fun getInt(key: String): Int {
        return mSharedPreferenceProcessor!!.getInt(key)
    }

    override fun getFloat(key: String): Float {
        return mSharedPreferenceProcessor!!.getFloat(key)
    }

    override fun getLong(key: String): Long {
        return mSharedPreferenceProcessor!!.getLong(key)
    }

    override fun getString(key: String): String {
        return mSharedPreferenceProcessor!!.getString(key)
    }

}
