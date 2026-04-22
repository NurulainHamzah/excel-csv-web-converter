# Excel to CSV Converter Web Application

## 📌 Project Overview
This project is a web-based application that allows users to upload an Excel file and convert it into a CSV file. The system uses a combination of frontend and backend technologies including HTML, CSS, JavaScript, PHP, and Java.

The project is deployed in a server environment using Docker with a Linux Apache setup.

---

## 🎯 Features
- Upload Excel files via web interface
- Convert Excel files into CSV format
- Download converted CSV file
- User-friendly GUI design
- Server-side processing
- File handling and validation

---

## ⚙️ Technologies Used
- HTML5
- CSS3
- JavaScript
- PHP
- Java (Apache POI)
- Apache Web Server
- Docker (Linux container)

---

## 🧠 System Workflow
1. User uploads Excel file via web interface  
2. File is sent to server using PHP  
3. Java program (ExcelToCsv.java) processes file  
4. Apache POI library reads Excel content  
5. Data is converted into CSV format  
6. CSV file is generated and stored on server  
7. User downloads converted file via link  

---

## 📂 Project Structure
```text
excel-to-csv-converter/
│
├── index.html          # Main UI page
├── style.css           # Styling
├── script.js           # Frontend logic
├── convert.php         # Backend file handler
├── ExcelToCsv.java     # Java conversion logic
├── bg.mp4              # Background video
├── icons               # UI icon
  ├── csvicon.png         
  ├── xlsicon.png        
└── README.md
```

---

## 🚀 How to Run the Project
1. Setup Server (Docker)
- Install Docker
- Run Ubuntu/Apache container
- Configure Apache web server
2. Place Files

Move project into:
```
/var/www/html/
```

3. Compile Java File
```
javac ExcelToCsv.java
```

4. Run Web Application

Open browser:
```
http://localhost/index.html
```

---

## 📌 Learning Outcomes
- Web application development
- Client-server architecture
- File upload and handling
- Excel file processing using Java
- Integration of multiple programming languages
- Basic server deployment using Docker

---


