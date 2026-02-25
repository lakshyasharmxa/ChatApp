# 📱 Real-Time Chat Application (Android)

A real-time chat application built using **Kotlin** and **Jetpack Compose**, powered by **Firebase Authentication** and **Firebase Firestore**.

This project demonstrates clean architecture, real-time data handling, and modern Android development practices.

---

## 🚀 Features

- 🔐 User Authentication (Email & Password) using Firebase Auth
- 🏠 Create and Join Chat Rooms
- 💬 Real-Time Messaging using Firestore Snapshot Listeners
- 🧠 MVVM Architecture
- ⚡ Kotlin Coroutines for asynchronous operations
- 🎨 Built completely using Jetpack Compose
- 🔄 Automatic UI updates with LiveData

---

## 🏗️ Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Firebase Authentication**
- **Firebase Firestore**
- **MVVM Architecture**
- **Kotlin Coroutines**

---

## 📂 Project Architecture

The project follows MVVM architecture:

UI (Compose Screens)
↓
ViewModel (Business Logic + State Management)
↓
Repository (Firebase Communication)
↓
Firebase Backend

This separation ensures clean, maintainable, and scalable code.

---

## 🔄 How Real-Time Messaging Works

- Messages are stored inside a Firestore sub-collection for each chat room.
- A Firestore snapshot listener listens for updates.
- When a user sends a message, all connected users receive it instantly.
- Messages are ordered using timestamps.

---

## 📸 Screens

- Login Screen
- Signup Screen
- Chat Room List Screen
- Chat Screen (Real-Time Messaging)

---

## 🧩 Key Learnings

- Implementing real-time systems with Firestore
- Handling asynchronous operations using coroutines
- Managing UI state using LiveData
- Preventing UI blocking during network operations
- Clean architecture implementation in Android

---

## ⚙️ Setup Instructions

1. Clone the repository:

## bash
git clone https://github.com/lakshyasharmxa/ChatApp.git

2. Open in Android Studio.

3. Connect Firebase project.

4. Add your google-services.json file.

5, Build and run.
