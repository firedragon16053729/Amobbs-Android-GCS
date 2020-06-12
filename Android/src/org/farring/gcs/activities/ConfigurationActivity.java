package org.farring.gcs.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.farring.gcs.R;
import org.farring.gcs.fragments.ParamsFragment;
import org.farring.gcs.fragments.SensorSetupFragment;

/**
 * This class implements and handles the various ui used for the drone configuration.
 */
public class ConfigurationActivity extends DrawerNavigationUI {

    public static final String EXTRA_CONFIG_SCREEN_ID = ConfigurationActivity.class.getPackage().getName() + ".EXTRA_CONFIG_SCREEN_ID";

    private int mConfigScreenId = R.id.navigation_params;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        if (savedInstanceState != null) {
            mConfigScreenId = savedInstanceState.getInt(EXTRA_CONFIG_SCREEN_ID, mConfigScreenId);
        }

        handleIntent(getIntent());
    }

    @Override
    protected int getToolbarId() {
        return R.id.actionbar_toolbar;
    }

    @Override
    protected int getNavigationDrawerMenuItemId() {
        return mConfigScreenId;
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_CONFIG_SCREEN_ID, mConfigScreenId);
    }

    private void handleIntent(Intent intent) {
        final int configScreenId = intent.getIntExtra(EXTRA_CONFIG_SCREEN_ID, mConfigScreenId);
        final Fragment currentFragment = getCurrentFragment();
        if (currentFragment == null || getIdForFragment(currentFragment) != configScreenId) {
            mConfigScreenId = configScreenId;
            getSupportFragmentManager().beginTransaction().replace(R.id.configuration_screen, getFragmentForId(configScreenId)).commit();
        }
    }

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.configuration_screen);
    }

    private Fragment getFragmentForId(int fragmentId) {
        final Fragment fragment;
        switch (fragmentId) {
            case R.id.navigation_calibration:
                fragment = new SensorSetupFragment();
                break;

            case R.id.navigation_params:
            default:
                fragment = new ParamsFragment();
                break;
        }

        return fragment;
    }

    private int getIdForFragment(Fragment fragment) {
        if (fragment instanceof SensorSetupFragment) {
            return R.id.navigation_calibration;
        } else {
            return R.id.navigation_params;
        }
    }
}
