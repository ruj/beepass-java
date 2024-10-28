### API

#### POST /api/generate-password

Request Body:
```json
{
    "length": 12,
    "includeUppercase": true,
    "includeLowercase": true,
    "includeNumbers": true,
    "includeSpecialChars": false
}
```

Response:
```json
{
  "password": "Abc123!@#"
}
```

#### GET /api/password-history

Response:
```json
[
  {
    "id": 1,
    "password": "Abc123!@#",
    "createdAt": "2024-10-27T10:15:30"
  },
  {
    "id": 2,
    "password": "Xyz456$%^",
    "createdAt": "2024-10-26T08:45:00"
  }
]

```

### MySQL (ver. 8.0.31)

```sql
CREATE USER 'root'@'%' IDENTIFIED BY 'root';

GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;

DROP USER 'root'@'localhost';

CREATE DATABASE beepass;

USE beepass;

CREATE TABLE passwords (
    id INT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(32) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

FLUSH PRIVILEGES;
```