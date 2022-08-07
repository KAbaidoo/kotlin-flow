package com.example.kotlin_flow.ui.stateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.kotlin_flow.databinding.ActivityStateFlowBinding
import kotlinx.android.synthetic.main.activity_state_flow.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class StateFlowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStateFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStateFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel by viewModels<StateFlowViewModel>()

        binding.btnIncrease.setOnClickListener { viewModel.incrementCounter() }
        collectLatestLifecycleFlow(viewModel.stateFlow) {
            btnIncrease.text = "Counter: $it"
/*        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.stateFlow.collectLatest{
                    btnIncrease.text = "Counter: $it"
                }
            }

        }*/
        }
    }



    // extension function for collecting flows in a lifecycle aware way
    private fun <T> AppCompatActivity.collectLatestLifecycleFlow(
        flow: Flow<T>,
        collect: suspend (T) -> Unit
    ) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collectLatest(collect)
            }
        }

    }
}