<h1
style="background:#e7e7e7;
text-align:center;
padding: 15px 0;"
>Real Estate <br/>Spring</h1>

<h5>Author: Andoni Alonso Tort</h5>
<h5>21/10/2024</h5>

Back-end for CRUD Real Estate application.

To change the port of the server, change server.port value in <i>src/main/resources/application.properties</i>

<table>
    <tr>
        <td>Database used</td>     
        <td>PostgreSQL</td>     
    </tr>
    <tr>
        <td>Database port</td>     
        <td>5432</td>     
    </tr>
    <tr>
        <td>Application port</td>     
        <td>8082</td>     
    </tr>
    <tr>
        <td>Java version</td>     
        <td>17.0.1</td>     
    </tr>
</table>

Project generated in : https://start.spring.io

To see the project executed : http://localhost:8082

<hr/>

<h5>Database Help</h5>
In order to connect corretly to databasem please create the realestate database on your PostgreSQL.

> CREATE DATABASE realestate;

Check list of roles :
> \du 

Give rights to your user
> GRANT ALL  PRIVILEGES ON "realestate" TO postgres

Check list of databases:
> \l

Connect to your database:
> \c realestate

Check relations:
> \d

<h5>CRUD OPERATIONS HELP</h5>

To test the crud operations you can use postman as follows :

<h6>UserApp class</h6>

> GET : 
    http://localhost:8082/api/users

> GET By Id : 
    http://localhost:8082/api/users/:id

> POST : 
    http://localhost:8082/api/users
    <i>body example :</i>
    {
        "firstname": "George",
        "lastname": "Carrillo",
        "email": "george@example.com",
        "dob": "2004-12-17"
    }

> PUT : 
    http://localhost:8082/api/users/:id?firstname=Somefirstname&email=someemail@example.com

> DELETE : 
    http://localhost:8082/api/users/:id

<br/>
<h6>Estate class</h6>

> GET : 
    http://localhost:8082/api/estates

> GET By Id : 
    http://localhost:8082/api/estates/:id

> POST : 
    http://localhost:8082/api/estates
    <i>body example :</i>
    {
    "owner": {
        "email": "andoniexemple@exemple.com"
    },
    "country": "France",
	"city": "Nice",
	"cp": "52587",
	"number": "55",
	"street": "Sartre",
    "surface": 55,
    "price": 500.5,
    "description": "New appartment in the south",
    "title": "NEW EMPTY APPARTMENT"
  }

> DELETE : 
    http://localhost:8082/api/estates/:id