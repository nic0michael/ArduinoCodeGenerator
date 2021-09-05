# Arduino (IDE) Code Generator Postman Tests
This test generates the code for a project in the database

## Test 1 Generate Code Test

### HTTP CLASS
POST

### URL
http://localhost:8070/arduino/generate 

### Headers
```
Accept  :  application/json
Content-Type  :  application/json
```

### Body
```
{
"projectName":"Dummy Project",
"description":"This is a dummy project",
"firstModule":"LED1",
"secondModule":"N/A",
"ThirdModule":"N/A",
"forthModule":"N/A",
"fifthModule":"N/A"
}
```  
_____________________________________________________________________________________

## Test 2 Get ALL Descriptions Test
This test gets a list of all descriptions

### HTTP CLASS
POST

### URL
http://localhost:8070/arduino/descriptions

### Headers
```
Accept  :  application/json
Content-Type  :  application/json
```

### Body

_____________________________________________________________________________________


## Test 3 Create Test
This test creates a Project feature in the database

### HTTP CLASS
POST

### URL
http://localhost:8070/arduino/create 

### Headers
```
Accept  :  application/json
Content-Type  :  application/json
```

### Body
```
{
"projectGUID":"bjjj",	
"computerLanguage":"CPP",	
"microController":"Arduino UNO",	
"mcuPinsUsed":"",	
"contributorsName":"Nico Michael",	
"contributorsBlogPage":"https://arduino.org.za/arduino-code-generator/",	
"contributorsYoutubePage":"",	
"featureStatus":"DISABLED",
"featureName":"5 LEDS",	
"description":"Blinks 5 leds",	
"prerequisites":"GHGJGJGJGHJGJGJ",	
"featureDecleration":"YIYIYIUYIYI",
"featureAssignment":"LHFHFGHFGHFGHFG",
"featurecode":"SDSDSFDSFDSFSDF"
}
```  
_____________________________________________________________________________________

## Test 4 get all Features Test
This test retrieves all project features

### HTTP CLASS
POST

### URL
http://localhost:8070/arduino/features

### Headers
```
Accept  :  application/json
Content-Type  :  application/json
```

### Body

_____________________________________________________________________________________


## Test 5 Get Feature 1 Test
This test retrieves one project feature

### HTTP CLASS
POST

### URL
http://localhost:8070/arduino/features/1

### Headers
```
Accept  :  application/json
Content-Type  :  application/json
```

### Body

_____________________________________________________________________________________


## Test 6 Update Test
This test updates one project feature in the database

### HTTP CLASS
POST

### URL
http://localhost:8070/arduino/update/1

### Headers
```
Accept  :  application/json
Content-Type  :  application/json
```

### Body
```
{
"projectGUID":"bjjj",	
"computerLanguage":"CPP",	
"microController":"Arduino UNO",	
"mcuPinsUsed":"",	
"contributorsName":"Nico Michael",	
"contributorsBlogPage":"https://arduino.org.za/arduino-code-generator/",	
"contributorsYoutubePage":"",	
"featureStatus":"DISABLED",
"featureName":"5 LEDS",	
"description":"Blinks 5 leds",	
"prerequisites":"GHGJGJGJGHJGJGJ",	
"featureDecleration":"YIYIYIUYIYI",
"featureAssignment":"LHFHFGHFGHFGHFG",
"featurecode":"SDSDSFDSFDSFSDF"
}
```  
_____________________________________________________________________________________

