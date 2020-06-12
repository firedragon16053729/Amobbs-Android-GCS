package org.farring.gcs.fragments.widget

import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.app.DialogFragment
import org.farring.gcs.R
import org.farring.gcs.fragments.widget.diagnostics.FullWidgetDiagnostics
import org.farring.gcs.fragments.widget.diagnostics.MiniWidgetDiagnostics
import org.farring.gcs.fragments.widget.telemetry.MiniWidgetAttitudeSpeedInfo
import org.farring.gcs.fragments.widget.telemetry.MiniWidgetFlightTimer
import org.farring.gcs.fragments.widget.telemetry.MiniWidgetGeoInfo
import org.farring.gcs.fragments.widget.video.FullWidgetUVCLinkVideo
import org.farring.gcs.fragments.widget.video.MiniWidgetUVCLinkVideo

enum class TowerWidgets(@IdRes val idRes: Int, @StringRes val labelResId: Int, @StringRes val descriptionResId: Int, val prefKey: String) {

    FLIGHT_TIMER(R.id.tower_widget_flight_timer, R.string.label_widget_flight_timer, R.string.description_widget_flight_timer, "pref_widget_flight_timer") {
        override fun getMinimizedFragment() = MiniWidgetFlightTimer()

        override fun isEnabledByDefault() = true
    },

    VEHICLE_DIAGNOSTICS(R.id.tower_widget_vehicle_diagnostics, R.string.label_widget_vehicle_diagnostics, R.string.description_widget_vehicle_diagnostics, "pref_widget_vehicle_diagnostics") {
        override fun getMinimizedFragment() = MiniWidgetDiagnostics()

        override fun canMaximize() = true

        override fun getMaximizedFragment() = FullWidgetDiagnostics()
    },
    GEO_INFO(R.id.tower_widget_geo_info, R.string.label_widget_geo_info, R.string.description_widget_geo_info, "pref_widget_geo_info") {
        override fun getMinimizedFragment() = MiniWidgetGeoInfo()
        override fun isEnabledByDefault() = true
    },

    ATTITUDE_SPEED_INFO(R.id.tower_widget_attitude_speed_info, R.string.label_widget_attitude_speed_info, R.string.description_widget_attitude_speed_info, "pref_widget_attitude_speed_info") {

        override fun getMinimizedFragment() = MiniWidgetAttitudeSpeedInfo()
        override fun isEnabledByDefault() = true
    },


    UVC_VIDEO(R.id.tower_widget_uvc_video, R.string.label_widget_uvc_video, R.string.description_widget_uvc_video, "pref_widget_uvc_video") {

        override fun canMaximize() = true

        override fun getMinimizedFragment() = MiniWidgetUVCLinkVideo()

        override fun getMaximizedFragment() = FullWidgetUVCLinkVideo()
    };

    abstract fun getMinimizedFragment(): TowerWidget

    open fun canMaximize() = false

    open fun isEnabledByDefault() = false

    open fun getMaximizedFragment(): TowerWidget? = null

    open fun hasPreferences() = false

    open fun getPrefFragment(): DialogFragment? = null

    companion object {
        @JvmStatic fun getWidgetById(@IdRes id: Int): TowerWidgets? {
            return when (id) {
                FLIGHT_TIMER.idRes -> FLIGHT_TIMER
                ATTITUDE_SPEED_INFO.idRes -> ATTITUDE_SPEED_INFO
                VEHICLE_DIAGNOSTICS.idRes -> VEHICLE_DIAGNOSTICS
                UVC_VIDEO.idRes -> UVC_VIDEO
                GEO_INFO.idRes -> GEO_INFO
                else -> null
            }
        }

        @JvmStatic fun getWidgetByPrefKey(prefKey: String): TowerWidgets? {
            return when (prefKey) {
                FLIGHT_TIMER.prefKey -> FLIGHT_TIMER
                ATTITUDE_SPEED_INFO.prefKey -> ATTITUDE_SPEED_INFO
                VEHICLE_DIAGNOSTICS.prefKey -> VEHICLE_DIAGNOSTICS
                UVC_VIDEO.prefKey -> UVC_VIDEO
                GEO_INFO.prefKey -> GEO_INFO
                else -> null
            }
        }
    }
}