/** *********************************************************************
 * Copyright (c) 2015-2020 Commonwealth Computer Research, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, Version 2.0
 * which accompanies this distribution and is available at
 * http://www.opensource.org/licenses/apache2.0.php.
 * **********************************************************************/

package org.geomesa.nifi.processors.cql

import org.apache.nifi.annotation.behavior.InputRequirement.Requirement
import org.apache.nifi.annotation.behavior.{InputRequirement, SupportsBatching}
import org.apache.nifi.annotation.documentation.{CapabilityDescription, Tags}
import org.geomesa.nifi.datastore.processor.utils.PropertyDescriptorUtils
import org.geomesa.nifi.datastore.processor.{AbstractGeoIngestProcessor}
import org.locationtech.geomesa.cassandra.data.CassandraDataStoreFactory

@Tags(Array("geomesa", "geo", "ingest", "convert", "cassandra", "geotools"))
@CapabilityDescription("Convert and ingest data files into a GeoMesa Cassandra Datastore")
@InputRequirement(Requirement.INPUT_REQUIRED)
@SupportsBatching
abstract class GeoMesaCassandraProcessor
  extends AbstractGeoIngestProcessor(GeoMesaCassandraProcessor.CassandraProperties) {

  //可以重写ingest函数写入cassandra
}

object GeoMesaCassandraProcessor extends PropertyDescriptorUtils {
  //给定一个Cassandra配置参数进行转换
  private val CassandraProperties = CassandraDataStoreFactory.ParameterInfo.toList.map(createPropertyDescriptor)
}


