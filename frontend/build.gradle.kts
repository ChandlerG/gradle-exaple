import com.moowork.gradle.node.yarn.YarnTask


plugins {
    id("com.moowork.node")
}

tasks {

    val yarnInstallTask = getByName<YarnTask>("yarn_install")
    val yarnBuildTask = getByName<YarnTask>("yarn_build")

    val yarnTestTask = getByName<YarnTask>("yarn_test")

    withType <Test> {
        dependsOn(yarnInstallTask)
        dependsOn(yarnTestTask)
    }

    register("ProcessResources") {
        println("Yo gabba gabba")
        dependsOn(yarnInstallTask)
        dependsOn(yarnBuildTask)
        doLast {
            copy {
                from("build")
                into("../src/main/resources/static")
            }
        }
    }

    register("build") {
        dependsOn(yarnInstallTask)
        dependsOn(yarnBuildTask)
        doLast {
            copy {
                from("build")
                into("../src/main/resources/static")
            }
        }
    }
}