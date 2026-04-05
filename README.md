# Coptic Keyboard

A custom Android input method (keyboard) that translates Cyrillic characters to Coptic Unicode characters.

## Features
- Input method service for Android
- Character mapping from Cyrillic to Coptic script
- Keyboard layout with Russian characters
- APK build and automated deployment via GitHub Actions

## Project Structure
```
.
├── app/
│   ├── src/main/
│   │   ├── java/com/example/coptickeyboard/
│   │   │   └── CopticInputService.kt
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── keyboard_view.xml
│   │   │   │   └── key_preview.xml
│   │   │   └── xml/
│   │   │       ├── keys_layout.xml
│   │   │       └── method.xml
│   │   └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── .github/workflows/
│   └── build.yml
├── build.gradle
├── settings.gradle
├── gradle.properties
├── gradlew
└── gradle/wrapper/
    └── gradle-wrapper.properties
```

## Building

### Local Build
```bash
chmod +x gradlew
./gradlew assembleDebug
```

The APK will be available at `app/build/outputs/apk/debug/app-debug.apk`

### Automatic Build (GitHub Actions)
Push code to the repository, and GitHub Actions will automatically:
1. Build the APK
2. Upload it to Artifacts

Download the APK from the Actions tab → Artifacts → apk

## Requirements
- Android 5.1 (minSdk 21)
- Android Studio or Gradle 8.2+
- Java 11+

## Configuration
- **Target SDK:** 33 (Android 13)
- **Compile SDK:** 33
- **Kotlin Version:** 1.8.20
- **Gradle Version:** 8.2

## Character Mapping
The keyboard maps Cyrillic characters to Coptic Unicode:
- а → ⲁ, б → ϭ, в → ⲃ, г → ⲅ, д → ⲇ
- е → ⲉ, ё → ⲉ, к → ⲕ, л → ⲗ, м → ⲙ
- н → ⲏ, о → ⲟ, п → ⲡ, р → ⲣ, с → ⲥ
- т → ⲧ, у → ⲩ, ф → ⲫ, х → ⲭ, ч → ϥ

Exceptions (not mapped): я, й, и, ю, з, ж, э, ц, ъ, ы, щ, ш

## License
MIT License
