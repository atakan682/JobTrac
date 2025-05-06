package com.example.jobtrac.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.util.Log
import com.example.jobtrac.model.JobItem
import com.example.jobtrac.network.RetrofitClient
import com.example.jobtrac.model.SubmittedForm




class JobViewModel : ViewModel() {
    private val _jobs = MutableLiveData<List<JobItem>>()
    val jobs: LiveData<List<JobItem>> = _jobs

    val submittedForms = MutableLiveData<MutableList<SubmittedForm>>(mutableListOf())

    fun addForm(form: SubmittedForm) {
        val current = submittedForms.value ?: mutableListOf()
        current.add(form)
        submittedForms.value = current
    }


    fun fetchJobs() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.getJobs()
                val usJobs = response.data.filter {
                    it.location.contains("United States", ignoreCase = true) ||
                            it.location.contains("USA", ignoreCase = true) ||
                            it.remote
                }
                _jobs.value = usJobs
                val englishJobs = response.data.filter {
                    it.description.contains("the", ignoreCase = true) || it.title.contains("Engineer", ignoreCase = true)
                }
                _jobs.value = englishJobs

            } catch (e: Exception) {
                Log.e("JobViewModel", "Error: ${e.message}")
            }
        }
    }

}

