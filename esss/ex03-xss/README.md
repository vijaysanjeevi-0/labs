# Ex 3 — Cross-Site Scripting (XSS)

**Aim:** Demonstrate stored XSS and its fix.

**Apparatus / Tools required:** XAMPP (PHP + MySQL), a browser.

**Algorithm**
1. Take username/comment from the POST form.
2. Insert them into the database unescaped.
3. On page load, read all comments and echo them straight into the HTML.

**Procedure**
```sql
CREATE TABLE comments (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  comment TEXT NOT NULL
);
```
Serve `xss.php` with XAMPP, then submit comment: `<script>alert('XSS Attack!');</script>`

**Program**
```php
<?php
$conn = new mysqli('localhost', 'root', '', 'xss_demo');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $username = $_POST['username'];
    $comment  = $_POST['comment'];
    // Vulnerable - raw input stored
    $conn->query("INSERT INTO comments (username, comment) VALUES ('$username', '$comment')");
}
$result = $conn->query("SELECT * FROM comments");
?>
<!DOCTYPE html>
<html>
<head><title>XSS Demonstration</title></head>
<body>
  <h1>Comment Section</h1>
  <form method="POST" action="">
    Username: <input type="text" name="username" required><br>
    <textarea name="comment" required></textarea><br>
    <button type="submit">Submit</button>
  </form>
  <h2>Comments:</h2>
  <?php while ($row = $result->fetch_assoc()): ?>
    <!-- vulnerable: echoed without htmlspecialchars() -->
    <p><strong><?php echo $row['username']; ?>:</strong> <?php echo $row['comment']; ?></p>
  <?php endwhile; ?>
</body>
</html>
```

**Sample Output:** an alert box fires every time the page (and the stored comment) is loaded.

**Result:** A stored XSS vulnerability was demonstrated successfully; the payload executed on every page load.

## Notes
Fix: escape on output — `<?php echo htmlspecialchars($row['comment']); ?>`. After the fix, the same payload is displayed as plain text instead of executing.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions. General questions are in the [base VIVA.md](../VIVA.md).
