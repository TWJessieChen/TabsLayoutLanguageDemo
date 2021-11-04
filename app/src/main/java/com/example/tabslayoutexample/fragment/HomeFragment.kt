package com.example.tabslayoutexample.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tabslayoutexample.R
import com.example.tabslayoutexample.utils.LocalManageUtils

class HomeFragment : Fragment() {
    private val TAG = HomeFragment::class.java.simpleName

    private var tv_home //系统语言
            : TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        LocalManageUtils.onFragmentAttach(requireActivity()) //Fragment 一定要加上這段

        tv_home = view.findViewById(R.id.tv_home)
        tv_home!!.setText(
            getString(R.string.current_language) +
                    LocalManageUtils.getSelectLanguage(requireContext())
        )

        // Return the fragment view/layout
        return view
    }
}