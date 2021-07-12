package com.go.shopping.lib_base.shared_preference.interfaces

interface ISharedPreferenceProcessor {
    fun putData(key: String, value: Any)
    fun getData(key: String, dataType: Int): Any
    fun getData(key: String, defaultValue: Any, dataType: Int): Any

    fun getBoolean(key: String, defaultValue: Boolean): Boolean
    fun getInt(key: String, defaultValue: Int): Int
    fun getFloat(key: String, defaultValue: Float): Float
    fun getLong(key: String, defaultValue: Long): Long
    fun getString(key: String, defaultValue: String): String

    fun getBoolean(key: String): Boolean
    fun getInt(key: String): Int
    fun getFloat(key: String): Float
    fun getLong(key: String): Long
    fun getString(key: String): String

}