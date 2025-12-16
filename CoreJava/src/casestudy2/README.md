# 💡 Smart Home Management System 💡

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange.svg" alt="Language: Java"/>
  <img src="https://img.shields.io/badge/Platform-Console-lightgrey.svg" alt="Platform: Console"/>
  <img src="https://img.shields.io/badge/License-MIT-blue.svg" alt="License: MIT"/>
</p>

A console-based Java application to simulate and manage a smart home. Add rooms, add/remove devices, and control them with ease. Your home's state is automatically saved and loaded!

---

## 📋 Table of Contents

- [Features](#-features)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation & Running](#installation--running)
- [Contributing](#-contributing)
- [License](#-license)

---

## ✨ Features

*   **🏠 Room Management**:
    *   Add new rooms (`Bedroom`, `Bathroom`, `Kitchen`, `Hall`).
    *   Remove existing rooms.
    *   List all rooms and their devices, including status and properties.
*   **🔌 Device Management**:
    *   Add various smart devices (`Light`, `Fan`, `AC`, `TV`, `Shower`).
    *   Enforces device-room compatibility (e.g., a `Shower` only in a `Bathroom`).
    *   Remove devices from rooms.
    *   Turn devices `ON` and `OFF`.
    *   Check the status (`ON`/`OFF`) of any device.
*   **🎛️ Device Operation**:
    *   Perform device-specific actions:
        *   **Light**: Change color and intensity.
        *   **Fan**: Change speed.
        *   **AC**: Change temperature, fan speed, and mode.
        *   **TV**: Change channel, volume, and input source.
        *   **Shower**: Change water temperature and flow rate.
*   **💾 Data Persistence**:
    *   The entire state of the house is automatically saved to `house.txt` on any change.
    *   The application loads the saved state from `house.txt` on startup.

---

## 🏗️ Project Structure

The project follows a **Model-View-Controller (MVC)** architectural pattern.

*   `src/casestudy2/model`: Contains entity classes like `House`, `Room`, `Device`, and specific device types (`Light`, `Fan`, `Tv`, etc.). It also includes marker interfaces (`BedRoomDevices`, `HallDevices`, etc.) to enforce device compatibility with room types.
*   `src/casestudy2/controller`:
    *   `HouseController.java`: Acts as a bridge between the view and the data access layer, forwarding requests.
    *   `HouseDao.java`: Handles all data manipulation, business logic, and persistence (reading from/writing to `house.txt`).
*   `src/casestudy2/view`: Contains `HouseView.java` for handling all user interaction via the console menu.
*   `src/casestudy2/test`: Contains `TestApp.java`, which is the main entry point of the application.

---

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher.

### Installation & Running

1.  **Clone the repository** (or download the source code).

2.  **Compile the code**:
    Navigate to the `src` directory in your terminal. It's recommended to compile the output to a separate `bin` directory.

    ```sh
    # Create a bin directory if it doesn't exist
    mkdir -p ../bin

    # Compile the Java source files
    javac -d ../bin casestudy2/test/TestApp.java
    ```

3.  **Run the application**:
    From the `bin` directory, run the main class.

    ```sh
    # Navigate to the bin directory
    cd ../bin

    # Run the application
    java casestudy2.test.TestApp
    ```

4.  **Interact with the application**:
    Once running, you will be presented with a menu of options to manage your smart home. The application state will be saved in a `house.txt` file in the project's root directory (`e:\Bramha_FBS_Work\CoreJava\`).

---

## 🤝 Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

---

## 📜 License

Distributed under the MIT License. See `LICENSE` for more information.
