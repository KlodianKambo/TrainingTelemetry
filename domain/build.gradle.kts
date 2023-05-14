plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("javax.inject:javax.inject:1")
    implementation(project(mapOf("path" to ":enterprise")))
    testImplementation(project(mapOf("path" to ":enterprise")))
    testImplementation ("junit:junit:4.13.2")

    implementation("com.google.dagger:hilt-core:2.45")
    kapt("com.google.dagger:hilt-compiler:2.45")
}
