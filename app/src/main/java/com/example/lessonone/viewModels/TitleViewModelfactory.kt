package com.example.lessonone.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class TitleViewModelfactory(private val finalTitle:String) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TitleViewModel::class.java)){
            return TitleViewModel(finalTitle) as T
        }
        throw  IllegalArgumentException("Unknown viewModel class")
    }
}