import numpy as np
import matplotlib.pyplot as plt

# Define the function
x = np.linspace(0, 2*np.pi, 400)
y = -abs(x-3)**0.5 + np.sin(x) + np.sin(3*x)/2 + 1

# Create a plot
fig, ax = plt.subplots()

# Plot the function
ax.plot(x, y, 'b')

# Highlight the maximum point
ymax = max(y)
xmax = x[y.argmax()]
ax.plot(xmax, ymax, 'go')
ax.annotate('θ MaxL', (xmax, ymax), textcoords="offset points", xytext=(10,10), ha='center')

# Set axes limits
ax.set_xlim(0, 2*np.pi)
ax.set_ylim(min(y) - 0.5, ymax + 0.5)
ax.axhline(0, color='black',linewidth=0.5)
ax.axvline(0, color='black',linewidth=0.5)

# Show the plot
plt.tight_layout()
plt.show()

plt.savefig('robustness.png')
