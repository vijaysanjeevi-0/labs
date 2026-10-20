# Viva: ex12-smart-home

**Q1. How does the cloud turn the LED on?**
The switch writes 1 to V0; the handler gets the value and sets the pin.

**Q2. What is a decorator in this code?**
@blynk.on registers the function as the callback for V0.

**Q3. Why check wlan.status()?**
To confirm the Wi-Fi connection before contacting the cloud.

**Q4. How to extend it?**
Add more virtual pins for fans, relays or sensors.

**Q5. What is the risk of hard-coded credentials?**
They leak with the source; keep them in a separate config file.
