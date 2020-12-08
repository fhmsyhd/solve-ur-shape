package org.d3if4097.solveurshape.ui

import android.app.AlarmManager
import android.app.Application
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import androidx.core.app.AlarmManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HitungViewModel(private val app: Application) : AndroidViewModel(app) {

//    private val alarmManager = app.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//    private val notifyIntent = Intent(app, AlarmReceiver::class.java)
//    private val notifyPendingIntent: PendingIntent = TODO()


    val _rumus = MutableLiveData<Unit>()
    val rumus: LiveData<Unit>
        get() = _rumus

    val _inputSatu = MutableLiveData<Double>()
    val inputSatu: LiveData<Double>
        get() = _inputSatu

    val _inputDua = MutableLiveData<Double>()
    val inputDua: LiveData<Double>
        get() = _inputDua

    val _inputTiga = MutableLiveData<Double>()
    val inputTiga: LiveData<Double>
        get() = _inputTiga

    val _inputEmpat = MutableLiveData<Double>()
    val inputEmpat: LiveData<Double>
        get() = _inputEmpat

    val _hasilKel = MutableLiveData<Double>()
    val hasilKel: LiveData<Double>
        get() = _hasilKel

    val _hasilLuas= MutableLiveData<Double>()
    val hasilLuas: LiveData<Double>
        get() = _hasilLuas

    var phi: Double = 3.14

    init {
        _inputSatu.value = 0.0
        _inputDua.value = 0.0
        _inputTiga.value = 0.0
        _inputEmpat.value = 0.0
        _hasilKel.value = 0.0
        _hasilLuas.value = 0.0
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "ViewModel destroyed!")
    }

    fun luasPersegi(){
        _hasilLuas.value = (inputSatu.value)?.times(inputSatu.value!!)
    }

    fun luasPersegiPanjang(){
        _hasilLuas.value = ((inputSatu.value)?.times(inputDua.value!!))
    }

    fun luasSegitiga(){
        _hasilLuas.value = (inputSatu.value)?.times(inputDua.value!!)?.times(0.5)
    }

    fun luasJajarGenjang(){
        _hasilLuas.value = ((inputSatu.value)?.times(inputDua.value!!))
    }

    fun luasTrapesium(){
        _hasilLuas.value = ((inputSatu.value)?.plus(inputDua.value!!))?.times(0.5)?.times(inputTiga.value!!)
    }

    fun luasLingkaran(){
        _hasilLuas.value = (phi).times(inputSatu.value!!).times(inputSatu.value!!)
    }

    fun kelPersegi(){
        _hasilKel.value = (inputSatu.value)?.times(4)
    }

    fun kelPersegiPanjang(){
        _hasilKel.value = ((inputSatu.value)?.plus(inputDua.value!!))?.times(2)
    }

    fun kelSegitiga(){
        _hasilKel.value = (inputSatu.value)?.plus(inputDua.value!!)?.plus(inputTiga.value!!)
    }

    fun kelJajarGenjang(){
        _hasilKel.value = ((inputSatu.value)?.plus(inputDua.value!!))?.times(2)
    }

    fun kelTrapesium(){
        _hasilKel.value = (inputSatu.value)?.plus(inputDua.value!!)?.plus(inputTiga.value!!)?.plus(inputEmpat.value!!)
    }

    fun kelLingkaran(){
        _hasilKel.value = (inputSatu.value)?.times(2)?.times(phi)
    }

//    fun startNotif(){
//        val triggerTime = SystemClock.elapsedRealtime()
//
//        val notificationManager = ContextCompat.getSystemService(
//            app,
//            NotificationManager::class.java
//        ) as NotificationManager
//        notificationManager.cancelNotification()
//
////        AlarmManagerCompat.setExactAndAllowWhileIdle(
////            alarmManager,
////            AlarmManager.ELAPSED_REALTIME_WAKEUP,
////            triggerTime,
////            notify
////        )
//    }
}