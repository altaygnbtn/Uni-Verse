package com.altaygunbatan.uni_verse.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.altaygunbatan.uni_verse.dataClasses.UserProfile
import com.altaygunbatan.uni_verse.repositories.UserProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserProfileViewModel(private val repository: UserProfileRepository) : ViewModel() {

    private val _notifications = mutableStateListOf<String>()
    val notifications: List<String> = _notifications

    private val _profile = MutableStateFlow<UserProfile?>(null)
    val profile: StateFlow<UserProfile?> = _profile

    fun loadUserProfile() {
        viewModelScope.launch {
            _profile.value = repository.getUserProfile()
        }
    }

    fun saveUserProfile(profile: UserProfile) {
        viewModelScope.launch {
            repository.saveUserProfile(profile)

        }
    }

    fun updateUserProfile(profile: UserProfile) {
        viewModelScope.launch {
            repository.updateUserProfile(profile)
            _notifications.add("Your profile changes are saved!")
        }
    }
}