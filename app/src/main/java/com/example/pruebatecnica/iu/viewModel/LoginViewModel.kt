package com.example.pruebatecnica.iu.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.domain.LoginUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUC: LoginUC
) : ViewModel() {

    private val _resultLogin: MutableLiveData<GetResultLoginState> = MutableLiveData()
    fun resultLogin(): LiveData<GetResultLoginState> = _resultLogin

    fun getResultLogin(email: String, password: String) {
        viewModelScope.launch {
            try {
                val dataLogin = loginUC.getResultLogin(email, password)
                dataLogin.addOnCompleteListener {
                    if (it.isSuccessful) {
                        _resultLogin.postValue(GetResultLoginState.SuccessLogin)
                    }else{
                        _resultLogin.postValue(GetResultLoginState.Error("credenciales no validas"))
                    }
                }
            } catch (e: Exception) {
                _resultLogin.postValue(GetResultLoginState.Error("error"))
            }
        }
    }

    sealed class GetResultLoginState() {
        object SuccessLogin : GetResultLoginState()
        data class Error(val message: String) : GetResultLoginState()
    }

}