package com.example.fieldsalessmartgarage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fieldsalessmartgarage.adapter.HomeFragmentGridDataAdapter
import com.example.fieldsalessmartgarage.adapter.HomeFragmentOffersDataAdapter
import com.example.fieldsalessmartgarage.adapter.HomeFragmentProductsDataAdapter
import com.example.fieldsalessmartgarage.listener.Listener
import com.example.fieldsalessmartgarage.model.ItemDataOnHomeFragmentModel
import com.example.fieldsalessmartgarage.model.ItemOffersInHomeFragmentModel
import com.example.fieldsalessmartgarage.model.ProductsInHomeFragment


class HomeFragment : Fragment() {
    val dataSourceForRecyclerView:ArrayList<ItemDataOnHomeFragmentModel> = arrayListOf()
    val dataSourceForOfferRecyclerView:ArrayList<ItemOffersInHomeFragmentModel> = arrayListOf()
    val dataSourceForProductRecyclerView:ArrayList<ProductsInHomeFragment> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataSourceForRecyclerView.add(ItemDataOnHomeFragmentModel(R.drawable.attendancehomefragmenticon,"Attendance"))
        dataSourceForRecyclerView.add(ItemDataOnHomeFragmentModel(R.drawable.checkinhomefragmenticon,"Checkin"))
        dataSourceForRecyclerView.add(ItemDataOnHomeFragmentModel(R.drawable.collectionshomefragmenticon,"Collections"))
        dataSourceForRecyclerView.add(ItemDataOnHomeFragmentModel(R.drawable.ledgerhomefragmenticon,"Ledger"))
        dataSourceForRecyclerView.add(ItemDataOnHomeFragmentModel(R.drawable.ordershomefragmenticon,"Order"))
        dataSourceForRecyclerView.add(ItemDataOnHomeFragmentModel(R.drawable.partyhomefragmenticon,"Party"))
        dataSourceForRecyclerView.add(ItemDataOnHomeFragmentModel(R.drawable.storeshomefragmenticon,"Stores"))
        dataSourceForRecyclerView.add(ItemDataOnHomeFragmentModel(R.drawable.visitshomefragmenticon,"Visits"))

        dataSourceForOfferRecyclerView.add(ItemOffersInHomeFragmentModel(R.drawable.offerimage))
        dataSourceForOfferRecyclerView.add(ItemOffersInHomeFragmentModel(R.drawable.offerimage))
        dataSourceForOfferRecyclerView.add(ItemOffersInHomeFragmentModel(R.drawable.offerimage))
        dataSourceForOfferRecyclerView.add(ItemOffersInHomeFragmentModel(R.drawable.offerimage))

        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))
        dataSourceForProductRecyclerView.add(ProductsInHomeFragment(R.drawable.oilproduct,"1 lit Oil"))

        val clickListener = object: Listener{
            override fun onClick(itemDataOnHomeFragment: ItemDataOnHomeFragmentModel) {
               if (itemDataOnHomeFragment.image == R.drawable.partyhomefragmenticon) replaceFragment(PartiesFragment())
            }

        }

        val view = inflater.inflate(R.layout.fragment_home,container,false)

        val recyclerView1 = view.findViewById<RecyclerView>(R.id.recyclerViewHomeFragment)
        val recyclerView2 = view.findViewById<RecyclerView>(R.id.recyclerViewHomeFragment2)
        val recyclerView3 = view.findViewById<RecyclerView>(R.id.recyclerViewHomeFragment3)
        val textViewMore = view.findViewById<TextView>(R.id.textViewMore)
        recyclerView1.adapter = HomeFragmentGridDataAdapter(dataSourceForRecyclerView, clickListener)
        recyclerView2.adapter = HomeFragmentOffersDataAdapter(dataSourceForOfferRecyclerView)

        recyclerView3.adapter = HomeFragmentProductsDataAdapter(dataSourceForProductRecyclerView.take(3) as ArrayList<ProductsInHomeFragment>)

        textViewMore.setOnClickListener {
            replaceFragment(ProductListFragment())
        }





        return view
    }

    private fun replaceFragment(fragment:Fragment) {
        fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer,fragment)?.commit()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }


}