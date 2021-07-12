# Library

## Guidelines

Run the blog application

- Clone this repository

```
git clone https://github.com/kostikroverist/library.git
```

## Postman

If you just want to save your data to use the library in the future then this URL help you

- POST  http://localhost:8080/user/save
```
{
"firstName":"Kostya",
"lastName":"Zhurakovskiy"
}
```
otherwise, if you want to give your books to the library, you can do so using this URl

- POST  http://localhost:8080/book/save

```
  {
"name":"Жуль Верн",
"page":450,
"nameAuthor":"Алексі Нем",
"yearOfPublication":1867 ,
"price":0,
"genre":"фантастика"
    }
```








if you dont now which book you want to read you can review all book which library have

- GET http://localhost:8080/book/getall

```
{
        "name": "Andruya",
        "page": 250213,
        "nameAuthor": "Andruya",
        "yearOfPublication": 1923,
        "genre": "rome",
        "price": 2.0,
        "free": false
    },
    {
        "name": "Жуль Верн",
        "page": 450,
        "nameAuthor": "Алексі Нем",
        "yearOfPublication": 1867,
        "genre": "фантастика",
        "price": 0.0,
        "free": true
    }

```
when you go to the library, you can take the book home. if you are first in it then when you take the book your data and what book you wanted to take will be automatically saved in the database

 This URL Help to take book

- POST http://localhost:8080/library/takebook

```
{
    "firstName":"Kostya",
    "lastName":"Zhurakovskiy",
    "name":"Жуль Верн",
    "nameAuthor":"Алексі Нем"
}
```
you can see who has the books you might want

- GET http://localhost:8080/user/getwhohavebook
```
[
    {
        "firstName": "Kostya",
        "lastName": "Zhurakovskiy",
        "books": [
            {
                "id": 13,
                "name": "Жуль Верн",
                "page": 450,
                "nameAuthor": "Алексі Нем",
                "yearOfPublication": 1867,
                "price": 0.0,
                "free": true,
                "genre": "фантастика"
            }
        ]
    },
    {
        "firstName": "KoStyaa",
        "lastName": "Zhora",
        "books": [
            {
                "id": 14,
                "name": "a",
                "page": 450,
                "nameAuthor": "a",
                "yearOfPublication": 1867,
                "price": 0.0,
                "free": true,
                "genre": "фантастика"
            }
        ]
    }
]

```



When you have finished reading the book, you must return the book and write who and what book was returned to the library.

- POST http://localhost:8080/library/returnbook
```
{
    "firstName":"Kostya",
    "lastName":"Zhurakovskiy",
    "name":"Жуль Верн",
    "nameAuthor":"Алексі Нем"
}
```


