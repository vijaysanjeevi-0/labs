# Ex 7.2.3 viva — Switch-controlled LED

1. **Why use a pull-down with a switch?** To keep the input at a defined LOW when the switch is open, avoiding a floating pin.
2. **What is switch bounce?** Mechanical contacts can toggle rapidly for a few ms when pressed; this script doesn't debounce it.
3. **How would you debounce in software?** Ignore further reads for a short delay (or check for a stable level) after the first detected change.
4. **Polling vs interrupt for a switch?** This script polls `sw.value()` in a loop; an interrupt (`irq`) would react immediately without polling.
5. **What does `Pin.IN` read if nothing is connected?** An undefined ("floating") value, unless an internal pull-up/down is enabled.
