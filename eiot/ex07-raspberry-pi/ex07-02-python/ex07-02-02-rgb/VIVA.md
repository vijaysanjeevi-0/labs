# Ex 7.2.2 viva — RGB LED cycle

1. **Why three separate `Pin` objects?** Each LED is on its own GPIO and must be driven independently.
2. **Could this run on a timer interrupt instead of `sleep`?** Yes — a hardware timer with a callback avoids blocking the main loop.
3. **What is a common application of this pattern?** Traffic-light simulation / state-sequencing in embedded systems.
4. **What happens if two LEDs share a GPIO by mistake?** Both switch together, since they are electrically the same signal.
5. **How would you add PWM fading instead of hard on/off?** Use the `machine.PWM` class to vary duty cycle in each colour's pin.
