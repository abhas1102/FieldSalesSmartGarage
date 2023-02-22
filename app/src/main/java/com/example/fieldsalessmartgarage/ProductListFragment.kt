package com.example.fieldsalessmartgarage

import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fieldsalessmartgarage.adapter.HomeFragmentProductsDataAdapter
import com.example.fieldsalessmartgarage.model.ProductsInHomeFragment


class ProductListFragment : Fragment() {

    private val dataSourceForProductRecyclerView:ArrayList<ProductsInHomeFragment> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))

        val view = inflater.inflate(R.layout.fragment_product_list,container,false)
        val recyclerView:RecyclerView = view.findViewById(R.id.recyclerViewProductListFragment)
        recyclerView.adapter = HomeFragmentProductsDataAdapter(dataSourceForProductRecyclerView)
      /*  val cl = view.findViewById<ConstraintLayout>(R.id.constraintLayoutProductList)
        val params = cl.layoutParams
        params.height = LayoutParams.MATCH_PARENT
        view.requestLayout() */
        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }


}