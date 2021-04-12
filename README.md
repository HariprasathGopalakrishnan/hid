# hid
ADD a Product - POST - /api/ecom/product/add

Request:
{
    "name": "laptop",
    "price": 1000.0,
    "userId": "John"
}

Response:
{
    "id": 1,
    "name": "laptop",
    "price": 1000.0,
    "userId": "John"
}


GET By UserId: /api/ecom/products/John

Sample response:
[
    {
        "id": 1,
        "name": "laptop",
        "price": 1000.0,
        "userId": "John"
    }
]

GET All Products - /api/ecom/products

[
    {
        "id": 1,
        "name": "laptop",
        "price": 1000.0,
        "userId": "John"
    },
    {
        "id": 2,
        "name": "desktop",
        "price": 5000.0,
        "userId": "Ben"
    }
]

REMOVE a product - DELETE - /api/ecom/product/remove/{id}





