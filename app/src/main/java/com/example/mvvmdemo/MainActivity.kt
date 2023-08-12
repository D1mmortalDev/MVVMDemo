package com.example.mvvmdemo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner=this

        var viewModel =ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.mainViewModel =viewModel

        //add observer
        viewModel.loginResult.observe(this, Observer { success->
            if(success){
                Toast.makeText(applicationContext,"Logged in!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Authentication Failed!",Toast.LENGTH_SHORT).show()
            }
        })

        binding.btnLogin.setOnClickListener {
            var username=binding.txtInputUsername.text.toString()
            var password=binding.txtInputPassword.text.toString()
            viewModel.performLogin(username,password)

        }
    }
}