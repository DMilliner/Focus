package milliner.hc

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import android.preference.PreferenceFragment

/**
 * Created by davidmilliner on 12/06/16.
 */
class SettingsFragment : PreferenceFragment(), OnSharedPreferenceChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.settings)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        //IT NEVER GETS IN HERE!
        if (key == "user_name") {
            // Set summary to be the user-description for the selected value
            val exercisesPref = findPreference(key)
            exercisesPref.summary = sharedPreferences.getString(key, "")
        }
        if (key == "game_mode") {
            // Set summary to be the user-description for the selected value
            val exercisesPref = findPreference(key)
            exercisesPref.summary = sharedPreferences.getString(key, "")
        }
    }

    override fun onResume() {
        super.onResume()
        preferenceManager.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        preferenceManager.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
        super.onPause()
    }
}