package fish.chandlergiusti.gradle.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GradleExampleApplication

fun main(args: Array<String>) {
	runApplication<GradleExampleApplication>(*args)
}
