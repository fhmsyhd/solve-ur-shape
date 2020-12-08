package org.d3if4097.solveurshape.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.d3if4097.solveurshape.database.db.DataDatarDAO
import org.d3if4097.solveurshape.database.db.DataDatarDB
import org.d3if4097.solveurshape.database.db.ShapeDatabase
import org.d3if4097.solveurshape.repository.BangunDatarRepository

class ShapeViewModel(application: Application) : AndroidViewModel(application) {

    // get DAO
    private val bangunDatarDao: DataDatarDAO = ShapeDatabase.getInstance(application).dataDatarDAO

    // get repository
    private val bangunDatarRepository = BangunDatarRepository(bangunDatarDao)

    // tempat response
    private val _dataBangunDatar: LiveData<List<DataDatarDB>>
    val dataBangunDatar: LiveData<List<DataDatarDB>>
        get() = _dataBangunDatar

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    // handling async
    private var job = Job()
    private val uiScope = CoroutineScope(job + Dispatchers.Main)

    init {
        _response.value = ""
        uiScope.launch {
            try {
                bangunDatarRepository.refreshDataBangunDatar()
                _response.value = "Sinkronisasi berhasil!"

            } catch (t: Throwable) {
                _response.value = "Anda sedang offline!"
            }
        }

        _dataBangunDatar = bangunDatarRepository.bangunDatar
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}