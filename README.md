# simple_catgory_project
this project is a simple App which allows user to select sub catgory from selected catgory and also select items under selected catgory and any subcagtory thats under selected catgory or deleted a selected item from catgory. Ingeneral this App provide 3 functions
1. select sub catgories of given catgory
2. select items under a catgory and also all items in the subcatgory of current catgory
3. delete an item

## tech used
### backend
java spring <br>
java 1.8<br>
Mysql 8.0.16<br>
Apache Maven 3.3.9<br>
### frontend
react.js<br>
npm 6.5.09<br>
axios
## run the app
download the project to your computer
### create database in MySQL
can just copy past comments below to build the data base

mysql> create database db_example; -- Create the new database<br>
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user<br>
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all the privileges to the new user on the newly created database<br>

There is a folder in catgoryAPP called sql, which contains sql queries to create the table, and insert some test data into the table.

### start backend:
cd to 'catgoryAPP' directory type  `./mvnw spring-boot:run` to run the backend<br>
back end will be running at [http://localhost:8080](http://localhost:8080)
### start frontend:

cd to 'reactFrontEnd' directory type  `npm install` to install react.js<br>
type `npm start` to run the frontend<br>
front end will be running at [http://localhost:3000](http://localhost:3000)<br>
***Note: there is an offical document on how to run react front the react team, just goto reactFrontEnd to see the readme.md there***



**Note: I have used axios to send HTTP request to the server, Install axios before running the react app**<br>
type `npm install axios` to install axios
