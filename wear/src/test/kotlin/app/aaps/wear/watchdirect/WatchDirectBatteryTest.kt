package app.aaps.wear.watchdirect

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class WatchDirectBatteryTest {

    @Test
    fun `the Wear OS settings placeholder is not a battery screen`() {
        // Seen on a Pixel Watch 4 with Wear OS 7 and a Galaxy Watch 5 with Wear OS 6: it answers both battery actions and can allow nothing
        assertThat(isPlaceholderSettings("com.google.android.clockwork.settings.FakeSettingsActivity")).isTrue()
        // The package may differ between watch makers, so only the class name counts
        assertThat(isPlaceholderSettings("com.example.FakeSettingsActivity")).isTrue()
    }

    @Test
    fun `a real settings screen counts`() {
        assertThat(isPlaceholderSettings("com.android.settings.fuelgauge.RequestIgnoreBatteryOptimizations")).isFalse()
        assertThat(isPlaceholderSettings("com.android.settings.Settings\$HighPowerApplicationsActivity")).isFalse()
    }

    @Test
    fun `a class that only ends like the placeholder counts`() {
        assertThat(isPlaceholderSettings("com.example.NotFakeSettingsActivity")).isFalse()
        assertThat(isPlaceholderSettings("")).isFalse()
    }
}
