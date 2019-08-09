# TODO rest API with Java EE

## Prerequisites

- Maven 3.3+
- JDK 1.8+

### Setup

After cloning this repository, install dependencies and compile code:

```
$  mvn package
```

To start TomEE server which will be available in port 8001 on localhost:

```
$  mvn tomee:run
```

You can also cluster above commands together:

```
$  mvn package tomee:run
```

## Usage

Use Postman or any other methods to make following requests to the API:

DELETE http://localhost:8001/todo/api/entries/{id}

GET http://localhost:8001/todo/api/entries/

GET http://localhost:8001/todo/api/entries/{id}

POST http://localhost:8001/todo/api/entries/

```json
{
  "task": "Milk",
  "description": "Purchase fatty milk for coffee"
}
```

PUT http://localhost:8001/todo/api/entries/{id}

```json
{
  "id": 1,
  "task": "Milk",
  "description": "Purchase light milk for coffee, no no to fatty!"
}
```
