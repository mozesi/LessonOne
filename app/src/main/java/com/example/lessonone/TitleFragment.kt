package com.example.lessonone

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.lessonone.databinding.FragmentTitleBinding
import com.example.lessonone.viewModels.TitleViewModel
import com.example.lessonone.viewModels.TitleViewModelfactory

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    private lateinit var viewModel:TitleViewModel
    private  lateinit var viewModelFactory: TitleViewModelfactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingObj = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,R.layout.fragment_title,container,false)
//        bindingObj.goAbout.setOnClickListener(
//           Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_aboutFragment)
//                  //  Navigation.createNavigateOnClickListener()
//        )

        //init the view model
        viewModelFactory = TitleViewModelfactory("Moses Msukwa")
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(TitleViewModel::class.java)
        bindingObj.titleViewModel = viewModel
        bindingObj.lifecycleOwner = viewLifecycleOwner
        setHasOptionsMenu(true)
        viewModel.titlename.observe(viewLifecycleOwner, Observer { newTitlename ->
            //bindingObj.goAbout.text = newTitlename.toString()
            //Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_aboutFragment)
        })

        return bindingObj.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_menu -> {
                Toast.makeText(context,"about clicked",Toast.LENGTH_LONG).show()}
        R.id.settings_menu -> {
            Toast.makeText(context,"ssetting clicked",Toast.LENGTH_LONG).show()}
        }
        return super.onOptionsItemSelected(item)
    }
}
