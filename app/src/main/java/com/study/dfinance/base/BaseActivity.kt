package com.study.dfinance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.stock.ant.base.BaseViewModel


abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity(){
    protected open lateinit var binding : VB

    protected abstract val viewModel : VM
    protected abstract val layoutRes : Int

    protected abstract fun init()
    protected abstract fun observerViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        init()
        observerViewModel()
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutRes)
    //    binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(::binding.isInitialized) binding.unbind()
    }
}