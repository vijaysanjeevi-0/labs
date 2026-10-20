# ex03 - Cross-Site Scripting (XSS)

## Aim
Demonstrate stored XSS and its fix.

## Setup
```sql
CREATE TABLE comments (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  comment TEXT NOT NULL
);
```
Serve `xss.php` with XAMPP.

## Attack
Submit comment: `<script>alert('XSS Attack!');</script>`

## Output
An alert box fires every time the page (and the stored comment) is loaded.

## Fix
Escape on output:
```php
<?php echo htmlspecialchars($row['comment']); ?>
```
After the fix, the same payload is displayed as plain text instead of executing.
