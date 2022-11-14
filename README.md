[![Maven Central](https://img.shields.io/maven-central/v/tech.dev-scion/typist.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22tech.dev-scion%22%20AND%20a:%22typist%22)

# Typist
A Jetpack Compose Text Typing Animation Library



## Usage
<p>Add this to your project level "build.gradle" or in newer versions of gradle in "settings.gradle" under repositories section:</p>

 ```groovy
repositories {
   mavenCentral()
}
```
<p>Add this to your module level build.gradle file:</p>

```groovy/kotlin
implementation 'tech.dev-scion:typist:TAG'

or for kotlin

implementation("tech.dev-scion:typist:TAG")
```
<p>Replace TAG with library version</p>

<p>Add Typist Composable to your app and configure accordingly:</p>

```kotlin
Typist(
    text = "Hi! I am Typist.",
    modifier = Modifier
                .align(Alignment.Center),
    typistSpeed = TypistSpeed.NORMAL,
    textStyle = TextStyle(
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        textAlign = TextAlign.Center
    )
)
```
