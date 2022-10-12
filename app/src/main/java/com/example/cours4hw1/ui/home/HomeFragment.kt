package com.example.cours4hw1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.cours4hw1.App
import com.example.cours4hw1.R
import com.example.cours4hw1.ui.task.TaskFragment
import com.example.cours4hw1.databinding.FragmentHomeBinding
import com.example.cours4hw1.ui.Task
import com.example.cours4hw1.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter=TaskAdapter(requireContext(),
            this::onLongClick,this::onClick
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
    private fun onClick(pos:Int){
        val task=adapter.getTask(pos)
        findNavController().navigate(R.id.taskFragment, bundleOf("k_task" to task))

    }
    private fun onLongClick(pos:Int){
        val alertDialog=AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Delete?")
        alertDialog.setPositiveButton("Yes"){dialog, _ ->
            App.db.dao().delete(adapter.getTask(pos))
            setData()
            dialog.dismiss()
        }
        alertDialog.setNegativeButton("No"){dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.create().show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener() {
            findNavController().navigate(R.id.taskFragment)
        }
        binding.recyclerView.adapter= adapter
        setData()
    }

     private fun setData(){
        val list= App.db.dao().getAllTask()
        adapter.addTasks(list.reversed())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}