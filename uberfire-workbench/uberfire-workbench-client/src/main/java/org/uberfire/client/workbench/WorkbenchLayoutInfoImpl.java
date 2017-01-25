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

package org.uberfire.client.workbench;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.errai.common.client.dom.DOMUtil;

@ApplicationScoped
public class WorkbenchLayoutInfoImpl implements WorkbenchLayoutInfo {

    @Inject
    private WorkbenchLayoutImpl workbenchLayout;

    @Override
    public int getHeaderHeight() {

        return workbenchLayout.getHeaderPanel().getBoundingClientRect().getHeight().intValue();

    }
}
