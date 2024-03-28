#Running cucumber tests using maven profile
Navigate to Project folder 
mvn test -P<maven profile name> -D<deviceId> -D<platformName> -D<platformVersion>
For example
mvn test -PprofileIdFromMaven -DdeviceId="Device id from adb devices"# odbm-native-mobile-app-automation
