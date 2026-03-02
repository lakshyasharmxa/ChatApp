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
- 🎨 Fully Declarative UI using Jetpack Compose  
- 🔄 Automatic UI updates using LiveData  

---

## 🏗️ Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Firebase Authentication**
- **Firebase Firestore**
- **MVVM Architecture**
- **Kotlin Coroutines**
- **LiveData**

---

## 🧠 Architecture Overview

The project follows the MVVM architecture pattern:

```
UI (Compose Screens)
        ↓
ViewModel (Business Logic + State Management)
        ↓
Repository (Firebase Communication Layer)
        ↓
Firebase Backend (Authentication + Firestore)
```

This separation ensures clean, maintainable, and scalable code.

---

## 🔄 How Real-Time Messaging Works

1. Each chat room has its own Firestore sub-collection.
2. Messages are stored with timestamps.
3. Firestore snapshot listeners observe changes.
4. When a user sends a message:
   - It is saved to Firestore.
   - All connected users receive it instantly.
5. Messages are ordered using timestamps for correct sequence.

---

## 📸 Screens

- Login Screen  
- Signup Screen  
- Chat Room List Screen  
- Real-Time Chat Screen  

(You can add screenshots inside a `/screenshots` folder and link them here.)

---

## ⚙️ Setup Instructions

1️⃣ Clone the repository:

```
git clone https://github.com/lakshyasharmxa/ChatApp.git
```

2️⃣ Open the project in Android Studio.

3️⃣ Create your own Firebase project at:
https://console.firebase.google.com

4️⃣ Add an Android app inside Firebase.

5️⃣ Download your own `google-services.json` file.

6️⃣ Place it inside:

```
app/google-services.json
```

7️⃣ Sync Gradle and run the application.

---

## 🔐 Security Note

The `google-services.json` file is intentionally excluded from this repository for security reasons.

Each developer must use their own Firebase project credentials.

---

## 🧩 Key Learnings

- Implementing real-time systems using Firestore
- Managing asynchronous operations using Kotlin Coroutines
- Handling UI state efficiently with LiveData
- Designing scalable architecture using MVVM
- Preventing UI blocking during network operations

---

## 🚀 Possible Future Improvements

- 🔔 Push Notifications
- 📄 Pagination for large chat histories
- 👤 User profile pictures
- ✔️ Message read receipts
- 🌙 Dark mode support
- 🤖 AI chatbot integration

---

## 👨‍💻 Author

Lakshya Sharma  
Android Developer | Kotlin | Firebase  

GitHub: https://github.com/lakshyasharmxa  

---

