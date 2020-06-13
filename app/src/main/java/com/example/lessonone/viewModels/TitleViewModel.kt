package com.example.lessonone.viewModels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.lessonone.R

class TitleViewModel(finalTitle: Any?) : ViewModel() {

    var _titlename = MutableLiveData<String>()
    val titlename : LiveData<String>
         get() = _titlename
    init {
      Log.i("TitleViewModel","Title view model called")
        _titlename.value = finalTitle.toString()

    }

    override fun onCleared() {
        super.onCleared()
        Log.i("TitleViewModel","on cleared in Title view model called")
    }
    fun goOn(){
        //Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_aboutFragment)
        _titlename.value = "Moses Msukwa Msukwa one"
        Log.i("TitleViewModel","button clicked")
        Log.i("TitleViewModel",titlename.value)
    }
}