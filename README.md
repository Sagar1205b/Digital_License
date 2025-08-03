# 🛡️ Digital Identity Protection Platform

A full-stack facial recognition platform built using **Java 17**, **Spring Boot**, **PostgreSQL**, **Thymeleaf**, and **CompreFace**, designed to help users verify identity and protect digital content from impersonation and misuse.

---

## 🔍 Key Features

- ✅ User registration with **email verification**
- ✅ **Login authentication** with secure credential storage
- ✅ **Facial recognition verification** using CompreFace
  - Match live webcam photo with public image URL
  - Supports scraping of protected image URLs
- ✅ Subject creation and face data management
- 🔄 (Coming soon) Digital licensing, content monitoring, and takedown automation

---

## 🧠 Tech Stack

- Java 17  
- Spring Boot 3.2  
- PostgreSQL 14  
- Thymeleaf (for frontend rendering)  
- Docker (for containerization)  
- CompreFace (for facial recognition API integration)

---

## 🧩 Architecture Overview


User Browser
    ↓
Spring Boot App (REST APIs + Thymeleaf UI)
    ↓         ↘
PostgreSQL    CompreFace API (hosted separately)

## 🎯 Real-World Challenges Solved

- ✅ Integrated CompreFace API to deliver AI-based facial recognition
- ✅ Scraped protected image URLs to compare against user identity
- ✅ Automatically extracted **profile photo from user-provided account links** (e.g., LinkedIn, Instagram)
- ✅ Converted those links into downloadable images for face matching — fully automated in code
- ✅ Built secure, scalable authentication workflows with REST endpoints
- ✅ Modularized architecture for easy extension into content licensing and monitoring

  🧑‍💼 About Me
I'm Sagar, a full-stack Java developer who loves solving real-world problems using Spring Boot, AI APIs, and modern web architecture.
 I’m actively looking for full-time  roles in Java backend or full-stack development.
  Email: sbadammanavar@gmail.com
  Phone: +91 9380179620
  
  
