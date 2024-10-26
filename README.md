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