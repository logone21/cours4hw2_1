package com.example.cours4hw1.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Preference (context:Context) {
    private var preference:SharedPreferences
    init {
        preference=context.getSharedPreferences("simple_data", MODE_PRIVATE)
    }

    fun getIsShowBoarding():Boolean{
        return preference.getBoolean("is_show",false)
    }
    fun showBoarding(){
        preference.edit().putBoolean("is_show", true).apply()
    }
    fun setProfileImage(url:String){
        preference.edit().putString("profile_image",url).apply()
    }
    fun getProfileImage():String=preference.getString("profile_image","").toString()

    fun setName(name: String){
        preference.edit().putString("profile_name",name).apply()
    }

    fun getName():String=preference.getString("profile_name","").toString()

    fun setAge(age: String){
        preference.edit().putString("profile_age",age).apply()
    }

    fun getAge():String=preference.getString("profile_age","").toString()

}