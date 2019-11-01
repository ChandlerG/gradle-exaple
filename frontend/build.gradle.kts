import com.moowork.gradle.node.yarn.YarnTask


plugins {
    id("com.moowork.node")
}

tasks {
    val yarnInstallTask = getByName<YarnTask>("yarn_install")
    val yarnBuildTask = getByName<YarnTask>("yarn_build")
    val yarnTestTask = getByName<YarnTask>("yarn_testnowatch")

    register ("test") {
        dependsOn(yarnTestTask)
    }

    register ("install"){
        dependsOn(yarnInstallTask)
    }


    register("build") {
        dependsOn("install")
        dependsOn(yarnBuildTask)
        doLast {
            copy {
                from("build")
                into("../src/main/resources/static")
            }
        }
    }

}