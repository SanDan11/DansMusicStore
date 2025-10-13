# 🎸 Music Store Inventory App

A full-stack Java desktop application designed to manage a music store’s inventory.  
Built with **Swing (GUI)**, **JDBC (database integration)**, and **SQLite (local data persistence)**.

---

## ✨ Features
1. Add, view, update, and delete music store products  
2. Product categories: Guitars, Drums, Basses, Keyboards, Amps, Accessories, Audio Gear  
3. Clean and intuitive Swing user interface  
4. Persistent data storage using SQLite  
5. Modular architecture following OOP best practices  

---

## 💼 Tech Stack

| Layer | Technology |
|-------|-------------|
| Frontend | Java Swing |
| Backend | JDBC |
| Database | SQLite |
| Language | Java 25 (OpenJDK) |

*(Work in progress — this project is part of my Java portfolio for learning full-stack development.)*

---

## 🛠️ Project Roadmap — Music Store Inventory App

A structured plan outlining each development phase, from initial setup to advanced features.

---

### ✅ **Phase 1 — Core Setup**
**Goal:** Establish the database foundation and environment.

**Completed Tasks:**
- Set up main entry point (`main.Main`)
- Implemented `DatabaseSetup` class
- Connected to SQLite using JDBC
- Auto-created tables for:
  - Guitar, Bass, Drums, Keyboards, Amps, Audio, Accessories
- Verified stable database connection and structure

---

### ✅ **Phase 2 — CRUD Logic**
**Goal:** Implement backend logic and data management.

**Completed Tasks:**
- Created DAO classes for each category
- Implemented Add, View, Search, and Delete operations
- Integrated `PreparedStatement` and `ResultSet`
- Tested all operations through console
- Planned database backup feature *(optional add-on)*

---

### 💻 **Phase 3 — Swing GUI Layer**
**Goal:** Develop a professional, user-friendly desktop interface.

**Planned Tasks:**
- Build main `JFrame` application window
- Add `JTabbedPane` for each category (Guitar, Drum, etc.)
- Create “Add Product” and “View Products” panels
- Integrate `JTable` for product display
- Add search & delete functionality through GUI
- Link UI buttons to DAO backend logic
- Maintain clean, consistent layout and fonts
- Include simple menu bar (File, Help, Exit)

---

### 🌟 **Phase 4 — Polish & Professionalization**
**Goal:** Prepare the app for portfolio and interview presentation.

**Planned Tasks:**
- Add an “About” or “Info” tab with app details
- Implement confirmation and error dialogs
- Create export options (CSV or PDF reports)
- Add database backup button
- Comment and refactor all code
- Finalize standardized README
- Capture UI screenshots
- Include UML or class diagram image

---

### 🚀 **Phase 5 — Optional Enhancements**
**Goal:** Strengthen reliability and add professional-grade features.

**Planned Tasks:**
- Automatic database backup system
- Low-stock alerts
- CSV/Excel export functionality
- Total inventory value reports
- Basic data visualization (charts or summaries)

---

### 🎶 **Phase 6 — Real Store Expansion**
**Goal:** Simulate a real-world music store with realistic organization.

**Planned Features:**
- Add *subcategories* for each main product type:
  - **Guitars:** Electric, Acoustic, Classical, Acoustic-Electric  
  - **Amps:** Combo, Cabinet, Head, Mini  
  - **Drums:** Acoustic, Electronic, Cymbals, Hardware  
  - **Bass:** 4-String, 5-String, Fretless  
  - **Keyboards:** Synthesizer, Digital Piano, Workstation, MIDI Controller  
  - **Audio:** Mixers, Microphones, Interfaces, Monitors  
  - **Accessories:** Strings, Picks, Straps, Stands, Cables
- Add `subcategory` column to database tables
- Enable filtering and sorting by subcategory
- Include subcategory field in exports/reports
- Display inventory summaries (e.g., “12 Electric Guitars in stock”)
- Clean and simple UI — **no product images**

---

### 🧭 **Beyond Phase 6 (Future Stretch Goals)**
**Potential Long-Term Enhancements:**
- User login system with roles (Admin / Employee)
- Sales tracking system
- Cloud sync with Spring Boot + AWS RDS
- REST API endpoints
- Real-time analytics dashboard

---

✅ **Current Status:**  
Core backend and database complete.  
Next milestone: Begin Swing GUI interface (Phase 3).
