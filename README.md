# JDBC - BeersDB exercise

Welcome to the BeersDB exercise.  

## First things first

Start by cloning the repository with the link provided to you and opening it in your preferred IDE. Next open a terminal/console window in your and remove the current git repository from your newly cloned project. Use the following command:

```
    Linux/Mac: rm -vfr .git/
    Windows: del /F /Q /S .git
```
Then create your own repository in the project and share that project with me on github.


## Guidelines for the exercise

During this exercise you should focus on doing things with JDBC. I know a lot of these things are possible with a simple "SELECT the whole table, and filter those streams up to the moon" but that is not what you should be doing in this exercise. While reading a table and filtering the resulting objects feels like a good thing to do, remember that the BeersDB is a micro-database. A table in an enterprise grade database can easily contain a few million records, reading those records from the db alone would take up a significant amount of time and memory. While a well placed WHERE clause can make the query run really snappy.

## The goal of this exercise.

There are a few goals we want to reach with this exercise:
* Give you a better grip on using JDBC
* Give you a better understanding of layering your application and the reasons for using layers
* Show you why interfaces are so f-ing awesome
* Introduce you to the first _design pattern_: namely the 'Factory'

**IMPORTANT** : Treat this exercise not as if you are a student at a school, but as if you were a working junior developer.

## Your mission Jim, if you decide to accept it is:

In this application you will find 3 packages:
* The be.infernalwhale.view package: DO NOT TOUCH ANYTHING IN THIS PACKAGE. If something doesn't work, you will have to fix it somewhere else. The view classes are near perfection (because I wrote them - Nobody).
* The be.infernalwhale.model package: These classes are representations of the tables in your beers database. While you shouldn't have to change anything here. You are free to make additions. However, if you remove or change names, you might break your application. My suggestion is: do not alter these.
* The be.infernalwhale.service package: This is where your work will start. You will find a ServiceFactory and several interface classes in this package.

You will have to implement the interfaces in the be.infernalwhale.service package. The method signatures should be simple enough for you to understand what is expected of the method. If a method signature includes parameters they should be used in that method. The interfaces will also have some javadoc to help clear up any misunderstandings.

The most important part may be the ServiceFactory. This class is the link between your view and the rest of your code. If we look the methods in the ServiceFactory, you will notice a few rather simple methods. Let's look at the ServiceFactory.createCategoryService() method.

```
    public static CategoryService createCategoryService() {
        return new FakeCategoryService();
    }
```

This deceptively simple method provides a simple and centralised way to get a CategoryService (this class is an interface). When you have finished writing your CategoryService implementation, all you need to do is change the return part of the method to:

```
    public static CategoryService createCategoryService() {
        return new ActualCategoryService();
    }
```

Now all the classes (in the view layer) which need a CategoryService will no longer receive a 'FakeCategoryService', but your home-made, oven-baked 'ActualCategoryService'. (fyi, please don't call your class 'ActualCategoryService')

## Launching the application
To start the application. Use the Main.main() method. When opening the Launcher class, you will notice that some IDEs will give you the option to run the Launcher class using the main() method inherited from the Application class. Feel free to try this, but most of you will notice that your application will exit with the following error code:

```
Error: JavaFX runtime components are missing, and are required to run this application
```

This should not happen when launching the application using the Main.main() method.

## The linkage

This is purely for completeness and you hopefully you have already figured out how the views and services will be linked.

* ConnectionView uses a ConnectionManager
* BeerView uses a BeerService
* BrewerView uses a BrewerService
* CategoryView uses a CategoryService
