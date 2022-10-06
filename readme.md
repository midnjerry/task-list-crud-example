# Task List CRUD Example

# YOUR GOAL AS A FULL-STACK DEVELOPER

Your goal is to write CRUD functionality from the UI all the way down to the database, complete with testing... and from your memory - no Googling
If you can get to this level, you would be better than 90% of the junior developers I worked with... and they had jobs and were getting paid.

## Requirements
* GitHub account
* Git Bash
* IntelliJ
* Java SDK 11
* Postman

## Spring Start Website
* https://start.spring.io/

## What is a CRUD?
A CRUD is an acronym that represents CREATE, READ, UPDATE, DELETE.  This sample application will allow the user to create
todo tasks that have to be saved.  Each task has to be CREATED.  As the days pass, and the person wants to retrieve their tasks,
they have to READ from the database.  If user wants to edit or complete the task, this will require UPDATING.  If a user made a mistake
and wants to get rid of the task, they can DELETE it.

What we are writing is actually called a microservice, and a microservice follows a particular pattern.
* Controller layer (this handles HTTP traffic)
* Service layer (this is your business logic)
* Database layer (this is what talks to the database)
  
### How do you organize and persist data?
In Spring Boot we do it with tables.  The Task table should have the following:

* Id:
* Title: 
* Description: 
* Completed: (True / False)

In SpringBoot you can make a model (which is a Java class) so that it corresponds with a database table!

### Implementing RESTful CRUD behavior

* Create: POST (should ignore ids)
* Update record: PUT (uses id, but it copies over object in database) (like a Database Insert)
* Update record: PATCH (like database update), only copy values that are not null
* Read a record (and not change the data): GET with ID
* Read all records: GET (with no id)
* Delete a record: DELETE

