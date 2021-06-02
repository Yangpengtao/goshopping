package com.go.shopping.base_components.proxy

import com.go.lib_base1.shared_preference.interfaces.ISharedPreferenceProcessor

/**
 * sp的代理
 */

object HelperSharedPreference  :
    ISharedPreferenceProcessor {



    private var mSharedPreferenceProcessor: ISharedPreferenceProcessor? = null

    fun  init( iSharedPreferenceProcessor: ISharedPreferenceProcessor) {
        mSharedPreferenceProcessor = iSharedPreferenceProcessor
    }

    override fun _putData(key: String, value: Any) {
        mSharedPreferenceProcessor!!._putData(key, value)
    }

    override fun _getData(key: String, dataType: Int): Any {
        return mSharedPreferenceProcessor!!._getData(key, dataType)
    }

    override fun _getData(key: String, defaulrValue: Any, dataType: Int): Any {
        return mSharedPreferenceProcessor!!._getData(key, defaulrValue, dataType)
    }

    override fun _getBoolean(key: String, defaulrValue: Boolean): Boolean {
        return mSharedPreferenceProcessor!!._getBoolean(key, defaulrValue)
    }

    override fun _getInt(key: String, defaulrValue: Int): Int {
        return mSharedPreferenceProcessor!!._getInt(key, defaulrValue)
    }

    override fun _getFloat(key: String, defaulrValue: Float): Float {
        return mSharedPreferenceProcessor!!._getFloat(key, defaulrValue)
    }

    override fun _getLong(key: String, defaulrValue: Long): Long {
        return mSharedPreferenceProcessor!!._getLong(key, defaulrValue)
    }

    override fun _getString(key: String, defaulrValue: String): String {
        return mSharedPreferenceProcessor!!._getString(key, defaulrValue)
    }

    override fun _getBoolean(key: String): Boolean {
        return mSharedPreferenceProcessor!!._getBoolean(key)
    }

    override fun _getInt(key: String): Int {
        return mSharedPreferenceProcessor!!._getInt(key)
    }

    override fun _getFloat(key: String): Float {
        return mSharedPreferenceProcessor!!._getFloat(key)
    }

    override fun _getLong(key: String): Long {
        return mSharedPreferenceProcessor!!._getLong(key)
    }

    override fun _getString(key: String): String {
        return mSharedPreferenceProcessor!!._getString(key)
    }

}
