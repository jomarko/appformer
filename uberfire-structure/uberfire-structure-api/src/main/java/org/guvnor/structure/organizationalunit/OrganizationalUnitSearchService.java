/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
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

package org.guvnor.structure.organizationalunit;

import java.util.Collection;

import org.jboss.errai.bus.server.annotations.Remote;

/**
 * {@link OrganizationalUnit} remote search interface
 */
@Remote
public interface OrganizationalUnitSearchService {

    /**
     * Retrieve a max number of {@link OrganizationalUnit} instances given a name pattern.
     * <p>
     * <p>Examples:</p>
     * <ul>
     * <li>{@code searchByName("", 20, true);} => get 20 instances, no matter their name</li>
     * <li>{@code searchByName("A", 10, true);} => get the first 10 instances that match the letter A</li>
     * <li>{@code searchByName("alfa", -1, false);} => get all the instances which name contains the word "alfa" (case unsensitive)</li>
     * </ul>
     * @param pattern An string fragment which must be present in any of the instances retrieved.
     * @param maxItems Max number of instances to retrieve. This setting is ruled out if zero or negative.
     * @param caseSensitive Case sensitiveness flag
     * @return A collection of {@link OrganizationalUnit} instances
     */
    Collection<OrganizationalUnit> searchByName(String pattern,
                                                int maxItems,
                                                boolean caseSensitive);

    /**
     * Retrieve a collection of {@link OrganizationalUnit} instances given their identifier.
     * <p>
     * <p>Example:</p>
     * <ul>
     * <li>{@code searchById(Arrays.asList("orgunit1"));} => get the "orgunit1" instance</li>
     * </ul>
     * @param ids A collection of identifiers
     * @return A collection of {@link OrganizationalUnit} instances
     */
    Collection<OrganizationalUnit> searchById(Collection<String> ids);
}