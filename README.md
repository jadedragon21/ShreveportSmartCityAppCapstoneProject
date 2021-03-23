# ShreveportSmartCityAppCapstoneProject
This is a Capstone Project that encompasses Spring boot, Security, Bootstrap, Local Api calls, Google Maps, CSS, Crud Database

## Description:
This is a Capstone project created by Software Developers from Tech Talent South that is designed to assist tourists and newcomers to the Shreveport area in finding good deals on hotels, local weather, maps, good local restaurants, festivals and more so that they can plan their stay here whether it is for local tourism, as a newcomer to area coming to stay for an extended stay, or some one coming to live here that would like to know the area better before settling here. Also includes information about local crime areas to veer away from so that the user can be warned about dangerous areas.

## Group Members:
* Sarah Hoffman-Lead/BackEnd/FrontEnd
* Scottie Horne-Backend/Presentation Speaker
* Aaliyah Phillips-Front End Developer
* Aparna Chellapilla-Technical Developer
* Pradhi Kohli-Technical Developer 

## Software used
* Java
* Spring Boot
* React
* Bootstrap
* Html
* CSS
* Thymeleaf
* Google Maps APIs
* [Maps JavaScript API ](https://developers.google.com/maps/documentation/javascript/overview?hl=en_US)
* [Geocoding API ](https://developers.google.com/maps/documentation/geocoding/overview?hl=en_US)


<a href="https://getbootstrap.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-plain-wordmark.svg" alt="bootstrap" width="40" height="40"/> </a>    <a href="https://heroku.com" target="_blank"> <img src="https://www.vectorlogo.zone/logos/heroku/heroku-icon.svg" alt="heroku" width="40" height="40"/> </a> <a href="https://www.w3.org/html/" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/> </a>  <a href="https://reactjs.org/" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/react/react-original-wordmark.svg" alt="react" width="40" height="40"/> </a> <a href="https://reactnative.dev/" target="_blank"> <a href="https://spring.io/" target="_blank"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> <a href="https://webpack.js.org" target="_blank"> </p>

## Setup
The application consists of two main parts:
1. The backend server, built with Spring Boot, JPA, Spring Security 5, Web, Lombok, and added Validation.
2. The frontend client, built with HTML 5, CSS, and Thymeleaf.
3. Was built using the Intellij by JetBrains and Microsoft VSCode IDEs.

During the current stage of development, both parts can be run locally, and will interact with each other on your
machine.

Need an application-local.properties file with the API key you get from here  
https://console.cloud.google.com/.

You also need to insert this API KEY into the aforementioned 
application-local.properties file under the format:

API_KEYL = **************************************** for the app to work.

### Backend Server:
Clone the project, and build with Gradle. Once dependencies have downloaded, run the SmartShreveCityApplication.java file to start the server. Main Home page will show on the hosted http://localhost:8080 . Can be deployed via heroku at a later date.

### Frontend Client:
After building the app via gradle and launching via the little green play button go to your local web browser and type in http://localhost:8080 and create a user account via signup button and login through the signin button.
Once you login you should be able to view the main page and navigate where you want to go via the navbar.

## Code examples:
An example of one the post mapping methods in the authorization controller , demonstrated in the following code snippet:
```Java
  @PostMapping("/signup")
    public String createNewUser(@Valid User user,
                                BindingResult bindingResult,
                                Model model) {

        User userExists = userService.findByUsername(user.getUsername());

        System.out.println(user);

        if (userExists != null) {
            bindingResult.rejectValue("username",
                    "error.user",
                    "Username is already taken");
        }
        if (!bindingResult.hasErrors()) {
            userService.saveNewUser(user);
            model.addAttribute("success",
                    "Sign up successful!");
            model.addAttribute("user", new User());
        }
        return "/registration";
    }
}
```


## Features

1. Create, read, update from the database (delete to be added at a later date)
2. Using the google APIs attached to the maps are able to type in a variety of cities & states as well
as the local area of Shreveport, LA. 
3. Can see a 7-day weather forecast.
4. Client app is mobile and web friendly meaning it is responsive and scales to device screen size.
5. Visit local restuarants websites, find crime info, good deals on local hotels, festivals and entertainment
in the surrounding areas.


## Status
Fully working as of 03/22/21.
This project is still under development. There may be 1-2 things still needing some attention. Not all future features are currently implemented. 

<h4>Screenshots:</h4>
<p>All webpages shown below have the navbars open to showcase them in the screenshots. With bootstrap they are responsive but open and close via the hamburger menu icon.</p>

Login Page:

![login.html](https://github.com/jadedragon21/ShreveportSmartCityAppCapstoneProject/blob/main/Screenshot_2021-03-22%20Log%20in.png)

Home Page:

![index.html](https://github.com/jadedragon21/ShreveportSmartCityAppCapstoneProject/blob/main/Screenshot_2021-03-22%20Home.png)

Festivals Page:

![Festivals.html](https://github.com/jadedragon21/ShreveportSmartCityAppCapstoneProject/blob/main/Screenshot_2021-03-22%20Shreveport-Bossier%20Festivals%20Events.png)

Entertainment Page:

![Entertainment.html](https://github.com/jadedragon21/ShreveportSmartCityAppCapstoneProject/blob/main/Screenshot_2021-03-22%20Shreveport-Bossier%20Entertainment.png)

Local Weather/Maps Page:

![mappyweather.html](https://github.com/jadedragon21/ShreveportSmartCityAppCapstoneProject/blob/main/Screenshot_2021-03-22%20Weather%20LocalMap.png)

Hotels Page:

![hotel.html](https://github.com/jadedragon21/ShreveportSmartCityAppCapstoneProject/blob/main/Screenshot_2021-03-22%20Title.png)

Restaurant Page:

![rest.html](https://github.com/jadedragon21/ShreveportSmartCityAppCapstoneProject/blob/main/Screenshot_2021-03-22%20Shreveport%20Restaurants.png)


Agile development via Trello:

Page 1:

![trello1](https://github.com/jadedragon21/ShreveportSmartCityAppCapstoneProject/blob/main/Screenshot_2021-03-22%20Capstone-%20shreveport%20app%20Trello(1).png)

Page 2:

![trello2](https://github.com/jadedragon21/ShreveportSmartCityAppCapstoneProject/blob/main/Screenshot_2021-03-22%20Capstone-%20shreveport%20app%20Trello.png)

