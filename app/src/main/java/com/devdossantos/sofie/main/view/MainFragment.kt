package com.devdossantos.sofie.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devdossantos.sofie.R
import com.devdossantos.sofie.main.model.TodoModel
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

        //        Test Adapter

        val todo1 = TodoModel("Tarefa 1", "paulo@teste.com", "Este é um item de teste, e deve ser ignorado futuramente")
        val todo2 = TodoModel("Tarefa 2", "jon@teste.com", "Este é um item de teste, e deve ser ignorado futuramente")
        val todo3 = TodoModel("Tarefa 3", "kate@teste.com", "Este é um item de teste, e deve ser ignorado futuramente")

//        Test Adapter

        val navController = Navigation.findNavController(view)
        val addButton = view.findViewById<FloatingActionButton>(R.id.btn_addNewTodo_main)
        val viewManager = LinearLayoutManager(view.context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_main)
        val mainAdapter = MainAdapter(listOf(todo1, todo2, todo3))

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = mainAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }


        addButton.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_newTodoFragment)
        }

    }
}