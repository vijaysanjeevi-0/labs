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
