package com.example.cours4hw1.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.cours4hw1.OnBoard
import com.example.cours4hw1.R
import com.example.cours4hw1.databinding.ItemOnBoardingPageBinding
import com.example.cours4hw1.loadImage

class OnBoardAdapter (private val onClick:()->Unit) : RecyclerView.Adapter <OnBoardAdapter.OnBoardViewHolder>() {

    private val arrayListBoarding= arrayListOf<OnBoard>()

    init {
        arrayListBoarding.add(
            OnBoard(
                R.raw.task_one,
                "hi_user",
                "welcom to my app ;)")
        )
        arrayListBoarding.add(
            OnBoard(
                R.raw.task_2,
            "any text",
            "Description 2")
           )
        arrayListBoarding.add(
            OnBoard(
                R.raw.task_3,
                "any text 3",
                "Description 3")
        )
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(ItemOnBoardingPageBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(arrayListBoarding[position])
    }

    override fun getItemCount(): Int =arrayListBoarding.size

    inner class OnBoardViewHolder(private val binding : ItemOnBoardingPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(onBoard: OnBoard){
                binding.skip.setOnClickListener { onClick() }
                binding.btnStart.setOnClickListener { onClick() }
                binding.skip.isVisible=adapterPosition!=arrayListBoarding.size - 1
                binding.btnStart.isVisible=adapterPosition==arrayListBoarding.size - 1

                binding.tvTitle.text=onBoard.title
                binding.tvDesc.text=onBoard.description
                onBoard.animation?.let { binding.animationView.setAnimation(it) }
              //  binding.imagePager.loadImage(onBoard.image)
            }

    }
}