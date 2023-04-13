package com.gajeks.pr8

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment


class ListFragment : Fragment() {

    internal interface OnFragmentSendDataListener {
        fun onSendData(data: String?)
    }

    private var fragmentSendDataListener: OnFragmentSendDataListener? = null
    private var countries = arrayOf<String?>("Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай")


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            fragmentSendDataListener = context as OnFragmentSendDataListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString()
                        + " должен реализовывать интерфейс OnFragmentInteractionListener"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        val countriesList: ListView = view.findViewById(R.id.countriesList)
        val adapter =
            ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_list_item_1, countries)
        countriesList.adapter = adapter
        countriesList.onItemClickListener = OnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as String
            fragmentSendDataListener!!.onSendData(selectedItem)
        }
        return view
    }

}