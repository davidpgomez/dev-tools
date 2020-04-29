@file:DependsOn("org.apache.hadoop:hadoop-common:2.6.0")

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.security.UserGroupInformation

import java.sql.Connection
import java.sql.DriverManager


fun connectToHiveServer(hiveServer: String, hivePrincipal: String, krbUser: String, krbKeytab: String): Connection {
  Class.forName("org.apache.hive.jdbc.HiveDriver")

  if(krbUser.isNotBlank() && krbKeytab.isNotBlank()) {
    val conf = Configuration()
    conf.set("hadoop.security.authentication", "kerberos")
    UserGroupInformation.setConfiguration(conf)
    UserGroupInformation.loginUserFromKeytab(krbUser, krbKeytab)
  }

  val hiveConfList = "hive.root.logger=NONE"
  val url = "jdbc:hive2://$hiveServer/default;principal=$hivePrincipal?$hiveConfList"

  return DriverManager.getConnection(url)
}
