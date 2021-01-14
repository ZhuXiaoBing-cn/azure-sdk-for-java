/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cosmosdb.v2020_06_01_preview;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.cosmosdb.v2020_06_01_preview.implementation.DatabaseRestoreResourceInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.cosmosdb.v2020_06_01_preview.implementation.CosmosDBManager;
import java.util.List;

/**
 * Type representing RestorableDatabaseAccountLocationDatabaseRestoreResource.
 */
public interface RestorableDatabaseAccountLocationDatabaseRestoreResource extends HasInner<DatabaseRestoreResourceInner>, HasManager<CosmosDBManager> {
    /**
     * @return the collectionNames value.
     */
    List<String> collectionNames();

    /**
     * @return the databaseName value.
     */
    String databaseName();

}
