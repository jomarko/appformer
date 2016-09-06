/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.ext.wires.client.preferences.example;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.ext.preferences.client.ioc.annotations.ComponentKey;
import org.uberfire.ext.preferences.client.ioc.annotations.PreferenceForm;
import org.uberfire.ext.preferences.client.ioc.store.PreferenceStore;
import org.uberfire.ext.wires.client.preferences.form.PreferencesEditorFormPresenter;
import org.uberfire.ext.wires.client.preferences.form.ViewMode;

@Dependent
@PreferenceForm
@WorkbenchScreen(identifier = ExtensionsPreferencesScreen.IDENTIFIER)
public class ExtensionsPreferencesScreen {

    public static final String IDENTIFIER = "ExtensionsPreferencesScreen";

    private final PreferencesEditorFormPresenter preferencesForm;

    private final PreferenceStore preferenceStore;

    @Inject
    public ExtensionsPreferencesScreen( final PreferencesEditorFormPresenter preferencesForm,
                                        @ComponentKey(IDENTIFIER) final PreferenceStore preferenceStore ) {
        this.preferencesForm = preferencesForm;
        this.preferenceStore = preferenceStore;
    }

    @PostConstruct
    public void init() {
        preferencesForm.init( preferenceStore, managedKeys(), getTitle(), ViewMode.USER_COMPONENT );
    }

    @WorkbenchPartView
    public PreferencesEditorFormPresenter.View getView() {
        return preferencesForm.getView();
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Extensions Preferences";
    }

    protected List<String> managedKeys() {
        List<String> keys = new ArrayList<>();
        keys.add( "connection.timeout" );

        return keys;
    }
}