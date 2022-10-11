package com.example.cours4hw1.ui.profile

import android.R.attr.previewImage
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.cours4hw1.data.Preference
import com.example.cours4hw1.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var preference:Preference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preference
    }

    var mGetContent: ActivityResultLauncher<String> = registerForActivityResult(
        ActivityResultContracts.GetContent()){ uri ->
        preference.setProfileImage(uri.toString())
        Glide.with(requireContext()).load(uri.toString()).into(binding.profileImage)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preference= Preference(requireContext())
        binding.etName.setText(preference.getName())
        Glide.with(requireContext()).load(preference.getProfileImage()).into(binding.profileImage)
        binding.profileImage.setOnClickListener {
            mGetContent.launch("image/*");
        }
        binding.etName.addTextChangedListener {
            preference.setName(binding.etName.text.toString())
        }
    }
}