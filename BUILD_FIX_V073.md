# Build fix v0.7.3

GitHub Actions failed in `app/build.gradle.kts` because Kotlin 2.3 rejects the old string-based `jvmTarget` API.

Removed:
```kotlin
kotlinOptions {
    jvmTarget = "17"
}
```

Added at project level:
```kotlin
kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}
```
