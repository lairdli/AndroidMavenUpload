## AndroidMaven Upload 上传aar

## 步骤

### 步骤1

编辑home gradle.properties,默认路径 `USER_HOME/.gradle/gradle.properties`

在此配置signed签名信息 以及 maven相关账号 链接,下文xxxx替换成自己实际的配置

```properties
...
##################### Step 1
# Update your home gradle.properties which is location in ~/.gradle/.gradle.properties
# This will include the username and password to upload to the Maven server and so that they are
# kept local on your machine. The location defaults to USER_HOME/.gradle/gradle.properties.
#
# It may also include your signing key id, password, and secret key ring file (for signed uploads).
# Signing is only necessary if you're putting release builds of your project on maven central.
signing.keyId=xxxxxxxx
signing.password=xxxxxxx
signing.secretKeyRingFile=/Users/laird/.gnupg/secring.gpg

MAVEN_NEXUS_USERNAME=xxxxxxxx
MAVEN_NEXUS_PASSWORD=xxxxxxxx
MAVEN_REPOSITORY_URL_RELEASE=https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/
MAVEN_REPOSITORY_URL_SNAPSHOT=https://s01.oss.sonatype.org/content/repositories/snapshots/

```

### 步骤2

编辑root  gradle.properties,默认路径在项目根目录下 `gradle.properties`

在此配置pom相关信息

```properties
...
##################### Step 2
# Create project root gradle.properties
# You may already have this file, in which case just edit the original.
# This file should contain the POM values which are common to all of your sub-project (if you have any).
VERSION_NAME=0.0.1
GROUP=com.1024developer.android.xtools
NEED_SIGN=true
NEED_DEBUG=false

POM_DESCRIPTION=A tools lib for Android
POM_URL=https://github.com/lairdli/androidlibs
POM_SCM_URL=https://github.com/lairdli/androidlibs
POM_SCM_CONNECTION=scm:git@github.com:lairdli/androidlibs.git
POM_SCM_DEV_CONNECTION=scm:git@github.com:lairdli/androidlibs.git
POM_LICENCE_NAME=The Apache Software License, Version 2.0
POM_LICENCE_URL=http://www.apache.org/licenses/LICENSE-2.0.txt
POM_LICENCE_DIST=repo
POM_DEVELOPER_ID=laird.li
POM_DEVELOPER_NAME=laird.li
```

### 步骤3

编辑sub  gradle.properties,路径位于子模块目录下`gradle.properties`

```properties
##################### Step 3
# Create gradle.properties in each sub-project
# The values in this file are specific to the sub-project (and override those in the root gradle.properties).
# In this example, this is just the name, artifactId and packaging type:
POM_NAME=Laird.li Test Share Library
POM_PACKAGING=aar
ARTIFACT_ID=testlib
```

### 步骤4

编辑sub build.gradle,路径位于子模块下`gradle.properties` 

在文件末尾添加`gradle-maven-push.gradle`脚本依赖

```groovy
...
apply from:"$rootDir/gradle-maven-push.gradle"
```

### 步骤5

执行上传task上传aar

在项目根目录执行命令脚本

```shell
./gradlew clean build publish 
```

或点击AS项目右侧Gradle展开对应`publishing`Task ,双击执行`pubish`

## 参考
- [gradle-mvn-push](https://github.com/chrisbanes/gradle-mvn-push)

