from selenium import webdriver

driver = webdriver.Chrome()
driver.get("http://localhost/login.php")

username = driver.find_element("name", "username")
username.send_keys("<script>alert('XSS')</script>")
driver.find_element("name", "submit").click()

# secure test case: the payload must not execute
assert "alert" not in driver.page_source

driver.quit()
print("Secure test case passed: XSS payload was not reflected.")
