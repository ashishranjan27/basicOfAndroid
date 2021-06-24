package com.example.databindingfragment

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.databindingfragment.databinding.FragmentMainBinding
import com.example.databindingfragment.model.Product
import com.example.databindingfragment.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.view.*

import java.io.IOException
class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentMainBinding.inflate(inflater, container, false)

        //see the power of data binding either you keep same or uncomment line no 35,
        //38,44,45,46,47 and comment line no 32,34,37 both give same result due to data binding

        //val rootView = inflater.inflate(R.layout.fragment_main,container,false)

        val viewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        binding.product = viewModel.getProduct()

        setData(binding.root, viewModel.getProduct())
        //setData(rootView,viewModel.getProduct())

        return binding.root
        //return rootView

    }

    private fun setData(rootView: View, product: Product) {

       // rootView.tv_name.text = product.name
        //rootView.tv_price.text = "${product.price}"
        //rootView.tv_description.text = product.description
        //rootView.tv_num_rating.text = "(${product.totalRatings})"
        rootView.iv_product_sale.visibility = if (product.salePrice > 0.0) View.VISIBLE else View.GONE
        rootView.iv_product.setImageBitmap(getBitmapFromAssets(product.image))

    }

    private fun getBitmapFromAssets(fileName: String): Bitmap? {
        return try {
            BitmapFactory.decodeStream(context?.assets?.open(fileName))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }


}