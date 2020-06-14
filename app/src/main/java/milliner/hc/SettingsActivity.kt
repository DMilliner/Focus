package milliner.hc

import android.os.Bundle
import android.preference.PreferenceActivity

/**
 * Created by davidmilliner on 28/05/16.
 */
class SettingsActivity : PreferenceActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display the fragment as the main content
        fragmentManager.beginTransaction().replace(R.id.content,
                SettingsFragment()).commit()
    }
}