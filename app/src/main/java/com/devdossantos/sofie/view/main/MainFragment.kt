package com.devdossantos.sofie.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devdossantos.sofie.R
import com.devdossantos.sofie.model.get.TodoModel
import com.devdossantos.sofie.repository.TodoRepository
import com.devdossantos.sofie.viewmodel.TodoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment() {

    private lateinit var _viewModel: TodoViewModel
    private lateinit var _listAdapter: MainAdapter
    private var _todoList = mutableListOf<TodoModel>()

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

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_main)
        val viewManager = LinearLayoutManager(view.context)

        _listAdapter = MainAdapter(_todoList.asReversed())

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = _listAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        _viewModel = ViewModelProvider(
            this,
            TodoViewModel.TodoViewModelFactory(TodoRepository())
        ).get(TodoViewModel::class.java)

        _viewModel.getList(EMAIL).observe(viewLifecycleOwner, {
            _todoList.addAll(it)
            _listAdapter.notifyDataSetChanged()
        })


        addButton.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_newTodoFragment)
            _todoList.clear()
        }

    }

    companion object {
        const val EMAIL = "paulo.dossantos@hotmail.com"
    }
}