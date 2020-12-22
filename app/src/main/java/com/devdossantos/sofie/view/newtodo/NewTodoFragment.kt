package com.devdossantos.sofie.view.newtodo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.devdossantos.sofie.R
import com.devdossantos.sofie.model.post.Post
import com.devdossantos.sofie.repository.TodoRepository
import com.devdossantos.sofie.viewmodel.TodoViewModel
import com.google.android.material.textfield.TextInputLayout


class NewTodoFragment : Fragment() {

    private lateinit var _viewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        val closeButton = view.findViewById<ImageButton>(R.id.btn_cancelNewTodo_newTodo)
        val proceedButton = view.findViewById<ImageButton>(R.id.btn_proceed_newTodo)

        val email = view.findViewById<TextInputLayout>(R.id.editText_email_newTodo).editText
        val todo = view.findViewById<TextInputLayout>(R.id.editText_todoName_newTodo).editText
        val todoDescription =
            view.findViewById<TextInputLayout>(R.id.editText_todoDescription_newTodo).editText

        closeButton.setOnClickListener {
            navController.popBackStack()
        }

        proceedButton.setOnClickListener {
            if (isNullText(email)) {
                email?.error = getString(R.string.emailError)
            }
            if (isNullText(todo)) {
                todo?.error = getString(R.string.todoError)
            }
            if (isNullText(todoDescription)){
                todoDescription?.error = getString(R.string.todoDescriptionError)
            }
            if (!isNullText(email) && !isNullText(todo) && !isNullText(todoDescription)) {

                val newPost = Post(
                    todo!!.text.toString(),
                    email!!.text.toString(),
                    todoDescription!!.text.toString()
                )

                _viewModel = ViewModelProvider(
                    this,
                    TodoViewModel.TodoViewModelFactory(TodoRepository())
                ).get(TodoViewModel::class.java)

                _viewModel.post(newPost).observe(viewLifecycleOwner, {
                    when (it) {
                        true -> Toast.makeText(view.context, getString(R.string.successMessage), Toast.LENGTH_SHORT).show()
                        false -> Toast.makeText(view.context, getString(R.string.failMessage), Toast.LENGTH_LONG).show()
                    }
                })



                email.text.clear()
                todo.text.clear()
                todoDescription.text.clear()
            }

        }

    }

    private fun isNullText(editText: EditText?) = editText?.text.isNullOrEmpty()


}