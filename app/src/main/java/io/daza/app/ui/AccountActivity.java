/**
 * Copyright (C) 2015 JianyingLi <lijy91@foxmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.daza.app.ui;

import android.content.Intent;
import android.support.v14.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import io.daza.app.R;
import io.daza.app.ui.base.BaseActivity;
import io.daza.app.util.Auth;

public class AccountActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }


    public static class AccountFragment extends PreferenceFragment {

        private static final String KEY_EMAIL = "key_email";
        private static final String KEY_MODIFY_PASSWORD = "key_modify_password";

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            addPreferencesFromResource(R.xml.pref_account);

            if (Auth.check()) {
                findPreference(KEY_EMAIL).setSummary(Auth.user().getEmail());
            } else {
                findPreference(KEY_EMAIL).setSummary("");
            }
        }

        @Override
        public boolean onPreferenceTreeClick(Preference preference) {
            if (KEY_MODIFY_PASSWORD.equals(preference.getKey())) {
                Intent intent = new Intent(getActivity(), ModifyPasswordActivity.class);
                startActivity(intent);
            }
            return true;
        }
    }
}
