package com.example.onboarding.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.onboarding.model.UserProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("user_profile")

class UserPreferences(
    private val context: Context
) {

    companion object {

        private val NAME = stringPreferencesKey("name")
        private val AGE = stringPreferencesKey("age")
        private val PHONE = stringPreferencesKey("phone")
        private val TRAITS = stringPreferencesKey("traits")
    }

    suspend fun saveProfile(profile: UserProfile) {

        context.dataStore.edit { prefs ->

            prefs[NAME] = profile.name
            prefs[AGE] = profile.age
            prefs[PHONE] = profile.phone
            prefs[TRAITS] = profile.traits.joinToString(",")
        }
    }

    val profileFlow: Flow<UserProfile> =
        context.dataStore.data.map { prefs ->

            UserProfile(
                name = (prefs[NAME] ?: "") as String,
                age = (prefs[AGE] ?: "") as String,
                phone = (prefs[PHONE] ?: "") as String,
                traits = prefs[TRAITS]
                    ?.split(",")
                    ?.filter { it.isNotBlank() }
                    ?: emptyList()
            )
        }
}