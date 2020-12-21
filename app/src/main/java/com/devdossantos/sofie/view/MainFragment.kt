package com.devdossantos.sofie.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.devdossantos.sofie.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val addButton = view.findViewById<FloatingActionButton>(R.id.btn_addNewTodo_main)

        addButton.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_newTodoFragment)
        }

    }
}