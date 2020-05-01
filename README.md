# Dbio Java library
A java library for the discord.bio library endpoint.

[![Build Status](https://travis-ci.com/zastrixarundell/dbio.svg?branch=master)](https://travis-ci.com/zastrixarundell/dbio) ![Latest version](https://img.shields.io/github/v/release/zastrixarundell/dbio)

![discord.bio homepage](https://raw.githubusercontent.com/zastrixarundell/dbio/master/assets/home.png)

## Why use this?
This is an async library filled with CompletableFutures and Optional making it easy to use but data-safe as well.

... and it's much easier to use than creating a consumer for the API endpoints yourself.

## What are the functionalities?
The library has all of the functionalities which the original endpoint does (they can be seen [here](https://docs.discord.bio/)) but the main feature is that the library uses async meaning it won't block your main thread if used correctly.

## How do I start?
This library is easy to add to your project and use it! Here's how:

### Adding to maven:
Repositories:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Dependency:
```xml
<dependency>
    <groupId>com.github.zastrixarundell</groupId>
    <artifactId>dbio</artifactId>
    <version>Tag</version> <!-- replace this with the current version -->
</dependency>
```

### General usage:
Currently there are 5 main functions for the 5 API endoiints. An example of fetching an info about a user would be:
```java
Optional<User> userOptional = Dbio.getUserDetails("192300733234675722").get();

userOptional.ifPresent(System.out::print);
```
And the result output on the console would be:
```
User{discord=DiscordInformation{id='192300733234675722', username='Zastrix', avatar='4b63183d13632ebcb89a79c3031f5105', discriminator='9202', flags=131136}, settings=SettingsInformation{name='zastrix', userId='192300733234675722', description='Backend software developer in Rails and Phoenix. I enjoy helping people out and creating discord bots. You can check out my work on github.com/zastrixarundell. I can as well sell my services of API management and Discord bots, PM me if you want. ', location='Novi Sad, Serbia', email='null', occupation='Backend Developer', banner='https://s3.eu-west-2.amazonaws.com/discord.bio/banners/192300733234675722', premium=false, verified=false, staff=false, upvotes=0, createdAt=Tue Apr 28 12:35:48 CEST 2020, birthday=Thu Sep 14 02:00:00 CEST 2000, gender=MALE}}
```

## Docs
Coming ASAP when the project is released on the maven central.