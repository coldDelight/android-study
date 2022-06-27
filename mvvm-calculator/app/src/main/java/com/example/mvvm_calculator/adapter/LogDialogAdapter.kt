package com.example.mvvm_calculator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_calculator.data.model.Log
import com.example.mvvm_calculator.databinding.LogItemBinding
import com.example.mvvm_calculator.viewmodel.LogDialogViewModel
class LogDialogAdapter(private val memoViewModel: LogDialogViewModel) : RecyclerView.Adapter<LogDialogAdapter.MyViewHolder>() {

    private var logList = emptyList<Log>()
    class MyViewHolder(private val binding: LogItemBinding) : RecyclerView.ViewHolder(binding.root){
        lateinit var log : Log
        lateinit var logDialogViewModel: LogDialogViewModel
        fun bind(currentLog : Log, logDialogViewMode: LogDialogViewModel){
            binding.log = currentLog
            this.logDialogViewModel = logDialogViewMode
            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LogItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(logList[position],LogDialogViewModel())
    }
    override fun getItemCount(): Int {
        return logList.size
    }
    fun setData(memo : List<Log>){
        logList = memo
        notifyDataSetChanged()
    }
}