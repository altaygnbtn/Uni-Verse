package com.altaygunbatan.uni_verse.viewModels

import androidx.lifecycle.ViewModel
import com.altaygunbatan.uni_verse.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _user = MutableStateFlow<>

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = userRepository.getUser(email, password)
            _user.value = user

        }
    }
}