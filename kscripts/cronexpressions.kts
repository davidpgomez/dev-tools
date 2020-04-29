@file:DependsOn("com.cronutils:cron-utils:9.0.2")

import com.cronutils.model.CronType
import com.cronutils.model.definition.CronDefinitionBuilder
import com.cronutils.model.time.ExecutionTime
import com.cronutils.parser.CronParser

import java.time.ZoneId
import java.time.ZonedDateTime

val cronParser   = CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.UNIX))
val dates = cronParser.parse(cronExpression)
