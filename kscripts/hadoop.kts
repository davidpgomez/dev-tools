#!/usr/bin/env kscript

@file:MavenRepository("cloudera-artifactory","https://repository.cloudera.com/artifactory/cloudera-repos")
@file:DependsOn("org.apache.hadoop:hadoop-client:2.6.0-cdh5.8.2")

import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapred.*
