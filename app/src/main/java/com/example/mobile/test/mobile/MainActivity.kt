package com.example.mobile.test.mobile

import android.os.Bundle
import android.util.Log
import android.webkit.CookieManager
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile.R
import com.example.mobile.arch.extension.setTextColorSpannableString
import com.example.mobile.arch.extension.toast
import com.example.mobile.test.algorithm.AlgorithmMiniMaxSum
import com.example.mobile.databinding.ActivityMainBinding
import com.example.mobile.local.LocalRepository
import java.net.HttpCookie
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var currentIndex: Int? = null
    private val cookieManager = CookieManager.getInstance()

    private val viewModel: MainVMContract by lazy {
        MainViewModel(LocalRepository(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initView()
        randomContentJoke(viewModel = viewModel)
        getCookie()
        initListener()

        //Build Algorithm
        AlgorithmMiniMaxSum().main(listOf(1, 2, 3, 4, 5))

    }

    private fun initView() {
        val titleHeader =
            "${getString(R.string.handicrafted_by_n_jim_hls)} ${getString(R.string.handicrafted_by_hls)}"
        binding?.tvHeader?.text = titleHeader.setTextColorSpannableString(
            getString(R.string.handicrafted_by_n_jim_hls).length + 1,
            titleHeader.length,
            R.color.colorBlack
        )
    }

    private fun initListener() {
        binding?.btnFunny?.setOnClickListener {
            currentIndex?.let {
                setCooke(viewModel.jokes[it].id.toString())
            }
            handleNextJoke()
        }
        binding?.btnNotFunny?.setOnClickListener {
            currentIndex?.let {
                setCooke(viewModel.jokes[it].id.toString())
            }
            handleNextJoke()
        }
    }

    private fun handleNextJoke() {
        if (viewModel.listIndex.size != viewModel.jokes.size) {
            randomContentJoke(viewModel)
        } else {
            toast("That's all the jokes for today! Come back another day!")
        }
    }

    private fun randomContentJoke(viewModel: MainVMContract) {
        currentIndex = Random.nextInt(0, viewModel.jokes.size)

        while (viewModel.listIndex.contains(currentIndex)) {
            currentIndex = Random.nextInt(0, viewModel.jokes.size)
        }
        currentIndex?.let {
            viewModel.setId(it)
            binding?.tvContent?.text = viewModel.jokes[it].content
        }
    }

    private fun setCooke(value: String) {
        val cookie = HttpCookie("jooke", value)
        cookieManager.setCookie("http://someHost.com", cookie.toString())
    }

    private fun getCookie() {
        val cookie = cookieManager.getCookie("http://someHost.com")
        Log.d("XXXXX", cookie)
    }
}