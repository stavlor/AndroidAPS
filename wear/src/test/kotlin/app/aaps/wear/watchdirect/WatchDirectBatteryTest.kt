package app.aaps.wear.watchdirect

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class WatchDirectBatteryTest {

    @Test
    fun `the Wear OS settings placeholder is not a battery screen`() {
        // Seen on a Pixel Watch 4 with Wear OS 7: it answers both battery actions and can allow nothing
        assertThat(isPlaceholderSettings("com.google.android.clockwork.settings.FakeSettingsActivity")).isTrue()
    }

    @Test
    fun `a real settings screen counts`() {
        assertThat(isPlaceholderSettings("com.android.settings.fuelgauge.RequestIgnoreBatteryOptimizations")).isFalse()
        assertThat(isPlaceholderSettings("com.android.settings.Settings\$HighPowerApplicationsActivity")).isFalse()
    }

    @Test
    fun `only the exact placeholder class is skipped`() {
        assertThat(isPlaceholderSettings("com.example.FakeSettingsActivity")).isFalse()
        assertThat(isPlaceholderSettings("")).isFalse()
    }
}
