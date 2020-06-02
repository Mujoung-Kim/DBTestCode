package company.domain.roomtestdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil

import company.domain.roomtestdb.databinding.ActivityMainBinding
import company.domain.roomtestdb.design.layout.TestViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        val viewModel: TestViewModel by viewModels()

        binding.viewModel = viewModel

    }
}
