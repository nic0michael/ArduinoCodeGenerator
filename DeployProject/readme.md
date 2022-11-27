# Installing Arduino Code Generator 

## 1. Install MariaDB


### 1.1 create database
Open Database in terminal run this command
```
create database arduino_generator;
```
## 2. Install Tomcat on server

I have published an article in my Blog  
  
http://rino.kozow.com/dvp/posts/install-tomcat-on-centos/
  

### 2.1 Deploy Arduino Code Generator on server

Upload the following file : ArduinoCodeGenerator.war  
  
to the Tomcat server folder :  
/opt/tomcat/apache-tomcat-9.0.69/webapps/ 

Read this article in my Blog: \
http://rino.kozow.com/dvp/posts/deploying-war-files-on-tomcat/

## Access server from web  
Open your browser to :
http://localhost:8080/code-generator  
  
My server is accessable at 
http://rino.kozow.com:8080/code-generator  


**73 de Nico**  

**ZS6BVR**
