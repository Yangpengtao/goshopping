package com.go.shopping.lib_base.shared_preference

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import com.go.shopping.lib_base.shared_preference.config.SpType
import com.go.shopping.lib_base.shared_preference.interfaces.ISharedPreferenceProcessor

/**
 * sp 生成器
 */
class SharedPreferenceProcessor(context: Context) :
    ISharedPreferenceProcessor {


    private var sharedPreferences: SharedPreferences? = null


    init {
        sharedPreferences = context.getSharedPreferences("happy_shopping", Context.MODE_PRIVATE)
    }


    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    override fun putData(key: String, value: Any) {
        when (value) {
            is String -> {
                sharedPreferences!!.edit().putString(key, value).apply()
            }
            is Boolean -> {
                sharedPreferences!!.edit().putBoolean(key, value).apply()
            }
            is Float -> {
                sharedPreferences!!.edit().putFloat(key, value).apply()
            }
            is Int -> {
                sharedPreferences!!.edit().putInt(key, value).apply()
            }
            is Long -> {
                sharedPreferences!!.edit().putLong(key, value).apply()
            }
            is Set<*> -> {
            }
        }
    }

    override fun getData(key: String, dataType: Int): Any {
        return getData(key, 0, dataType)
    }

    override fun getData(key: String, defaultValue: Any, dataType: Int): Any {
        when (dataType) {
            SpType.STRING -> {
                return sharedPreferences!!.getString(key, defaultValue as String) as String
            }
            SpType.BOOLEAN -> {
                return sharedPreferences!!.getBoolean(key, defaultValue as Boolean)
            }
            SpType.FLOAT -> {
                return sharedPreferences!!.getFloat(key, defaultValue as Float)
            }
            SpType.INT -> {
                return sharedPreferences!!.getInt(key, defaultValue as Int)
            }
            SpType.LONG -> {
                return sharedPreferences!!.getLong(key, defaultValue as Long)
            }
        }
        return 0
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences!!.getBoolean(key, defaultValue)
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences!!.getInt(key, defaultValue)
    }

    override fun getFloat(key: String, defaultValue: Float): Float {
        return sharedPreferences!!.getFloat(key, defaultValue)
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        return sharedPreferences!!.getLong(key, defaultValue)
    }

    override fun getString(key: String, defaultValue: String): String {
        return sharedPreferences!!.getString(key, defaultValue).toString()
    }

    override fun getBoolean(key: String): Boolean {
        return sharedPreferences!!.getBoolean(key, false)
    }

    override fun getInt(key: String): Int {
        return sharedPreferences!!.getInt(key, 0)
    }

    override fun getFloat(key: String): Float {
        return sharedPreferences!!.getFloat(key, 0F)
    }

    override fun getLong(key: String): Long {
        return sharedPreferences!!.getLong(key, 0L)
    }

    override fun getString(key: String): String {
        return sharedPreferences!!.getString(key, "").toString()
    }
}


