# MYCVTech

My CVTech es una plataforma innovadora para estudiantes de carreras tecnológicas que facilita la creación de sus perfiles profesionales,
La plataforma busca desarrollar el perfil profesional de los estudiantes de carreras en tecnología, construyendo un CV que destaque sus habilidades y logros junto con la posibilidad de mostrar sus proyectos desarrollados a lo largo de su aprendizaje, A la par, quiere apoyar a las entidades educativas en el proceso de vender a sus estudiantes como practicantes a las diferentes empresas interesadas en buscar talentos dentro de sus estudiantes

## Documentacion EndPoint's

ADMIN
{
"firstName": "string",
"lastName": "string",
"email": "string",
"phone": "string",
"password": "string",
"accessLevel": "string",
"department": "string"
}

Student
{
"firstName": "string",
"lastName": "string",
"email": "string",
"phone": "string",
"password": "string",
"academicProgram": "string",
"semester": "string",
"interestedArea": "string",
"softSkills": [
    {
        "name": "string"
    }
],
"expertise": [
    {
        "name": "string",
        "level": "string"
    }
]
}

### Get a list of all users
GET /users
Authorization: Bearer YOUR_JWT

### Get a user by ID
GET /users/1234567890
Authorization: Bearer YOUR_JWT

### Delete a user by ID
DELETE /users/1234567890
Authorization: Bearer YOUR_JWT

### Add a new student
POST /students
Content-Type: application/json
Authorization: Bearer YOUR_JWT
{
"firstName": "Juan",
"lastName": "Pérez",
"email": "juan.perez@example.com",
"phone": "555-123-4567",
"password": "secreto123",
"academicProgram": "Ingeniería Informática",
"semester": "3",
"interestedArea": "Inteligencia Artificial",
"softSkills": [
    { "name": "resiliencia" },
    { "name": "comunicación efectiva" }
],
"expertise": [
    { "name": "Inglés", "level": "BASIC" },
    { "name": "Python", "level": "GOOD" }
]
}

### Update an existing student
PUT /students/1234567890
Content-Type: application/json
Authorization: Bearer YOUR_JWT
{
"fristName": "Jane Doe"
}

### Add a new admin
POST /admins
Content-Type: application/json
Authorization: Bearer YOUR_JWT
{
"firstName": "Luisa",
"lastName": "Pérez",
"email": "luisa.perez@example.com",
"phone": "555-888-9999",
"password": "claveAdmin888",
"accessLevel": "5",
"department": "Área de Admisiones"
}

### Update an existing admin
PUT /admins/1234567890
Content-Type: application/json
Authorization: Bearer YOUR_JWT
{
"password": "newpassword"
}

## Integrantes
**Jorge David Sáenz Diaz **
**Julian David Castillo Soto **
**Sebastian Porras Rozo **
**Camilo Andres Cantillo Tatis **
**Santiago Cárdenas Amaya **