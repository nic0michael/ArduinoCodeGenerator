# Arduino (IDE) Code Generator
Nico Michael ZS6BVR is building this project using Software Industry Best practices TDD and Clean code.    

One day I felt that it would be nice to have a code generator for Arduino and Raspberry Pi Projects that could generate sample code using a library repository in a database.    
This would be deployed in a web server and allow users to select all the hardware components and generate sample code to get a quick start to coding for the project.    

This is a stand-alone web Service that will generate code for your Arduino and other MCU's projects .    
You create a project selecting the hardware you want to attach to your Arduino UNO , Nano or even ESP32.    
 

This project has a database where you can upload code snippets and instructions for which libraries need to be added to your Arduino IDE you can add up to 5 different types of boards (like LCDs , Servos, Relays , even user defined hardware.    

Once you have selected your 5 devices this will generate the code for you to put in your Arduino IDE using this software.    

## 1. Why do we want such an Application 
A newby or person with less experience in developing code for the Arduino project will be able to generate all the code with instructions to get it working.     
  
It should also become so useful for the seasoned Arduino project maker saving time building a project by reusing existing code and saving time debugging to get it working.    


## 2. How this project will be deployed
This project is written to build a WAR file this can be deployed on a web server  
Or as a standalone Java Microservice Application.   

### 2.1 Instructions to deploy this project on a Tomcat Server:
https://github.com/nic0michael/ArduinoCodeGenerator/tree/master/DeployProject
  
It will also be **Dockerized** so it can run on a **Portainer docker server** or even a **Raspberry Pi Docker docker** swarm or even a **Docker cluster**

The project will support any **MCU that can be programmed by the Arduino IDE** (this includes ESP32 and Raspberry Pi Pico)  
  
**The generated software is initially written in C and C++** it will be possible to generate **Python code in the future**   
  
## 3. You will be allowed to contribute your project code
All people will be invited to contribute Arduino code for Arduino projects.    
When you contribute Arduino code and someone uses your code in the code generated there will be a comment with your name, your Blog URL and your Youtube page which you can send the user of your code giving you more traffic.    
With Google dictating who and how many visitor hit your Blog and Youtube page **this will be a new avenue to get traffic on your Blog and Youtube VLOG page.**  

A SQL script will be provided to get started quickly.

## 4. Free Open Source FOS with the License based on GPL Version 3

This project is Free Open Source code FOS.    
We provide this Project as free of charge and subject to the terms and license of this project is GPL Version 3.   
**As this is Free Open Source Project you are welcome to make a fork of this project for commercial use.**   
In return for that please give the author of this project credit in your MD keeping the next line:   
[The Source of this project if Forked from GitHub and is Free for Commercial use.](https://github.com/nic0michael/RabbitMQProducerMicroservice)

## 5. No Warranty is provided or implied
This software is provided in terms of South African law as : "VOETS TOETS" "AS IS" (in English) with no warranty and no Guarantee provided or implied That the user shall agree to comply with these terms when using this software.

