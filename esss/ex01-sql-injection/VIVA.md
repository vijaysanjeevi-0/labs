# ex01 viva — SQL Injection

1. **What is SQL injection?** Attacker-supplied input changes the structure/meaning of a SQL query because it is concatenated into the query unescaped.
2. **How did `admin' --` bypass the login?** It closed the username string early and commented out the rest of the query (including the password check) with `--`.
3. **Best fix for SQL injection?** Parameterised queries / prepared statements, so user input is always treated as data, never as SQL code.
4. **What else helps besides prepared statements?** Least-privilege DB accounts, input validation, and not displaying raw DB errors to users.
5. **Why is `DROP TABLE` via injection so dangerous?** A single unsanitised input field can let an attacker execute arbitrary SQL, including destructive statements, not just read data.
