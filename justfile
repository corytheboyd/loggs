runDebug:
    ./gradlew :composeApp:run

buildDistAndOpen:
    @./gradlew packageDistributionForCurrentOS
    @open ./composeApp/build/compose/binaries/main/app/com.corytheboyd.loggs.app
