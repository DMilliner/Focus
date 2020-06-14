package milliner.hc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by davidmilliner on 12/06/16.
 */
public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        //IT NEVER GETS IN HERE!
        if (key.equals("user_name")) {
            // Set summary to be the user-description for the selected value
            Preference exercisesPref = findPreference(key);
            exercisesPref.setSummary(sharedPreferences.getString(key, ""));
        }
        if (key.equals("game_mode")) {
            // Set summary to be the user-description for the selected value
            Preference exercisesPref = findPreference(key);
            exercisesPref.setSummary(sharedPreferences.getString(key, ""));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }
}
