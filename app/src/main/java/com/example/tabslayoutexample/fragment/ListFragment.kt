package com.example.tabslayoutexample.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.tabslayoutexample.MainActivity
import com.example.tabslayoutexample.TabsMainActivity
import com.example.tabslayoutexample.R
import com.example.tabslayoutexample.utils.LocalManageUtils

class ListFragment : Fragment() {
    private val TAG = ListFragment::class.java.simpleName

    var lay_system: RelativeLayout? = null
    var lay_chinese: RelativeLayout? = null
    var lay_english: RelativeLayout? = null
    var lay_traditional_chinese: RelativeLayout? = null
    var tv_list: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        LocalManageUtils.onFragmentAttach(requireActivity()) //Fragment 一定要加上這段

        tv_list = view.findViewById<TextView>(R.id.tv_list)
        lay_system = view.findViewById<RelativeLayout>(R.id.lay_system)
        lay_chinese = view.findViewById<RelativeLayout>(R.id.lay_chinese)
        lay_english = view.findViewById<RelativeLayout>(R.id.lay_english)
        lay_traditional_chinese = view.findViewById<RelativeLayout>(R.id.lay_traditional_chinese)

        tv_list!!.setText(
            getString(R.string.current_language) +
                    LocalManageUtils.getSelectLanguage(requireContext())
        )

        lay_system!!.setOnClickListener { v ->
            Log.d("btnSetup", "lay_system")
            reStartActivity(requireContext(), 0)
        }

        lay_chinese!!.setOnClickListener { view ->
            Log.d("btnSetup", "lay_chinese")
            reStartActivity(requireContext(), 1)
        }

        lay_english!!.setOnClickListener { view ->
            Log.d("btnSetup", "lay_english")
            reStartActivity(requireContext(), 2)
        }

        lay_traditional_chinese!!.setOnClickListener { view ->
            Log.d("btnSetup", "lay_traditional_chinese")
            reStartActivity(requireContext(), 3)
        }

        // Return the fragment view/layout
        return view
    }

    /**
     * 选择语言后，重新进入setting页面
     *
     * @param context
     * @param select
     */
    fun reStartActivity(context: Context, select: Int) {
        LocalManageUtils.setSelectLanguage(context, select)
        LocalManageUtils.onFragmentAttach(requireActivity()) //Fragment 一定要加上這段
        requireActivity().finish()
        val intent = Intent(context, TabsMainActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }


}