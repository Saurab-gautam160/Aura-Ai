# Aura AI

An AI-powered Android application built using Jetpack Compose following an offline-first architecture.

## Features

### Onboarding Flow

* 3-step swipeable onboarding
* Animated value proposition screen
* User profile collection
* OTP validation (mock OTP: 1234)
* Personality trait selection
* DataStore persistence

### Home Screen

* Aura Circle built using Canvas API
* Breathing pulse animation
* Listening state support
* Custom animated text input panel
* Scroll-based Aura transition
* Chat history screen

### Chat System

* Coroutine-based state machine
* States:

  * Typing
  * Validating
  * Processing
  * Responding
  * Idle
  * Error

### Offline First Architecture

* Room Database
* Flow-based queries
* Repository pattern
* TypeConverters
* Reminder support
* Sync-ready architecture

### Tech Stack

* Kotlin
* Jetpack Compose
* StateFlow
* Coroutines
* Room Database
* DataStore
* WorkManager

## Project Structure

```text
app
├── data
│   ├── datastore
│   ├── local
│   └── repository
├── model
├── presentation
│   ├── onboarding
│   ├── home
│   └── chat
└── ui
```

## Assignment Requirements Covered

* Swipeable onboarding
* DataStore persistence
* Canvas-based Aura animation
* Audio listening state
* Custom input animations
* Room database integration
* Pagination-ready chat architecture
* Coroutine state machine
* Offline-first data layer
* WorkManager sync infrastructure

## Setup

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle
4. Run on emulator or physical device


Test screen shot:-
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/af0620b3-a820-4f22-b58f-5dc6cba5b861" />

loom video link:- https://drive.google.com/file/d/1TgHruZ1plkG7vIWnVzeG-Mv53JqtIham/view?usp=drive_link


## Author

Saurab Gautam
