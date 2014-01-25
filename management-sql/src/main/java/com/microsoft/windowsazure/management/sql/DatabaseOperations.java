/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.sql;

import com.microsoft.windowsazure.core.OperationResponse;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.sql.models.DatabaseCreateParameters;
import com.microsoft.windowsazure.management.sql.models.DatabaseCreateResponse;
import com.microsoft.windowsazure.management.sql.models.DatabaseGetResponse;
import com.microsoft.windowsazure.management.sql.models.DatabaseListResponse;
import com.microsoft.windowsazure.management.sql.models.DatabaseUpdateParameters;
import com.microsoft.windowsazure.management.sql.models.DatabaseUpdateResponse;
import java.io.IOException;
import java.util.concurrent.Future;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
* The SQL Database Management API includes operations for managing SQL
* Databases for a subscription.
*/
public interface DatabaseOperations
{
    /**
    * Creates a database in a SQL Server database server.
    *
    * @param serverName The name of the SQL Server where the database will be
    * created.
    * @param parameters The parameters for the create database operation.
    * @throws ParserConfigurationException Thrown if there was an error
    * configuring the parser for the response body.
    * @throws SAXException Thrown if there was an error parsing the response
    * body.
    * @throws TransformerException Thrown if there was an error creating the
    * DOM transformer.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    DatabaseCreateResponse create(String serverName, DatabaseCreateParameters parameters) throws ParserConfigurationException, SAXException, TransformerException, IOException, ServiceException;
    
    /**
    * Creates a database in a SQL Server database server.
    *
    * @param serverName The name of the SQL Server where the database will be
    * created.
    * @param parameters The parameters for the create database operation.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<DatabaseCreateResponse> createAsync(String serverName, DatabaseCreateParameters parameters);
    
    /**
    * Drops a SQL Database server from a subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg715285.aspx for
    * more information)
    *
    * @param serverName The name of the server on which the database is found.
    * @param databaseName The name of the database to be deleted.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse delete(String serverName, String databaseName) throws IOException, ServiceException;
    
    /**
    * Drops a SQL Database server from a subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg715285.aspx for
    * more information)
    *
    * @param serverName The name of the server on which the database is found.
    * @param databaseName The name of the database to be deleted.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<OperationResponse> deleteAsync(String serverName, String databaseName);
    
    /**
    * Returns information about a SQL Server database.
    *
    * @param serverName The name of the SQL Server on which the database is
    * housed.
    * @param databaseName The name of the SQL Server database to be obtained.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    DatabaseGetResponse get(String serverName, String databaseName) throws IOException, ServiceException, ParserConfigurationException, SAXException;
    
    /**
    * Returns information about a SQL Server database.
    *
    * @param serverName The name of the SQL Server on which the database is
    * housed.
    * @param databaseName The name of the SQL Server database to be obtained.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<DatabaseGetResponse> getAsync(String serverName, String databaseName);
    
    /**
    * Returns the list SQL Server databases.
    *
    * @param serverName The name of the database server to be queried.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return Response containing the list of databases for a given server.
    */
    DatabaseListResponse list(String serverName) throws IOException, ServiceException, ParserConfigurationException, SAXException;
    
    /**
    * Returns the list SQL Server databases.
    *
    * @param serverName The name of the database server to be queried.
    * @return Response containing the list of databases for a given server.
    */
    Future<DatabaseListResponse> listAsync(String serverName);
    
    /**
    * Updates SQL Server database information.
    *
    * @param serverName The name of the SQL Server where the database is housed.
    * @param databaseName The name of the SQL Server database to be obtained.
    * @param parameters The parameters for the update database operation.
    * @throws ParserConfigurationException Thrown if there was an error
    * configuring the parser for the response body.
    * @throws SAXException Thrown if there was an error parsing the response
    * body.
    * @throws TransformerException Thrown if there was an error creating the
    * DOM transformer.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    DatabaseUpdateResponse update(String serverName, String databaseName, DatabaseUpdateParameters parameters) throws ParserConfigurationException, SAXException, TransformerException, IOException, ServiceException;
    
    /**
    * Updates SQL Server database information.
    *
    * @param serverName The name of the SQL Server where the database is housed.
    * @param databaseName The name of the SQL Server database to be obtained.
    * @param parameters The parameters for the update database operation.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<DatabaseUpdateResponse> updateAsync(String serverName, String databaseName, DatabaseUpdateParameters parameters);
}
