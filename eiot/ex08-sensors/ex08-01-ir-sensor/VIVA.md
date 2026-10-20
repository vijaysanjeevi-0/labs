# Ex 8.1 viva — IR sensor

1. **How does an IR obstacle sensor work?** An IR LED emits light; a photodiode detects the reflection off a nearby object.
2. **Why is the output LOW on detection?** Most IR modules pull their digital output low when reflected light is received above a threshold.
3. **What can affect its reliability?** Ambient light (especially sunlight), surface colour/reflectivity of the object, and sensor distance.
4. **Digital vs analog IR sensors?** Digital gives a simple on/off; analog gives a distance-related voltage that needs a threshold in software.
5. **What's a typical use of this circuit?** Obstacle avoidance in robotics, or an intrusion/proximity alert.
