package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.modeel.Category
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment () {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = GroupieAdapter()
        recyclerView.adapter = adapter

        adapter.add(CategoryItem(Category("categoria 1", 0xffface6e)))
        adapter.add(CategoryItem(Category("categoria 2", 0xffecd16d)))
        adapter.add(CategoryItem(Category("categoria 3", 0xffded36e)))
        adapter.add(CategoryItem(Category("categoria 4", 0xffcfd571)))

        adapter.notifyDataSetChanged()
    }
}