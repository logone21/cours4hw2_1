package com.example.cours4hw1.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.cours4hw1.App
import com.example.cours4hw1.R
import com.example.cours4hw1.databinding.FragmentTaskBinding
import com.example.cours4hw1.ui.Task

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    private var task:Task?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments!=null){
            binding.btbSave.text=getString(R.string.update)
            task = arguments?.getSerializable("k_task") as Task
            binding.etTitle.setText(task?.title)
            binding.etDescription.setText(task?.descriptor)
        }else{
            binding.btbSave.text=getString(R.string.save)
        }


        binding.btbSave.setOnClickListener{
            if (arguments!=null){
                task?.let { it1 -> update(it1) }
            } else{
                save()
            }
        }
    }

    private fun update(task: Task){
        task.title=binding.etTitle.text.toString()
        task.descriptor=binding.etDescription.text.toString()
        App.db.dao().update(task)
        findNavController().navigateUp()
    }

    private fun save(){
        App.db.dao().insert(
            Task(
                title = binding.etTitle.text.toString(),
                descriptor = binding.etDescription.text.toString()
            )
        )

        findNavController().navigateUp()
    }

    companion object{
    const val FRAGMENT_RESULT ="tf_result"
        const val TASK_KEY="task.key"
    }
}