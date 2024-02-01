import numpy as np
import matplotlib.pyplot as plt

# Settings
num_time_steps = 100
np.random.seed(0)

# Simulate expected rewards for the best action and the action chosen by the algorithm
expected_reward_best_action = 50 #np.random.rand(num_time_steps)
expected_reward_algorithm_action = np.random.rand(num_time_steps)

# Calculate regret
regret = (expected_reward_best_action - expected_reward_algorithm_action)/num_time_steps
cumulative_regret = np.cumsum(regret)

# Create a plot for an algorithm converging to 50
algo_performance = 10 * np.log(np.array(range(num_time_steps)) + 1)

plt.figure(figsize=(10, 6))
plt.plot(range(num_time_steps), algo_performance, label='Some agent', color='green')
# Fill the area
plt.fill_between(range(num_time_steps), algo_performance, 50, where=(algo_performance <= 50),
                 interpolate=True, color='gray', alpha=0.3, hatch='//')

# Plotting
plt.plot(range(num_time_steps), cumulative_regret, label='Random agent')
plt.plot(range(num_time_steps), [50]*num_time_steps, label='Optimal agent')
plt.xlabel('Time Step')
plt.ylabel('Reward')
plt.title('Cumulative Regret Over Time in a Multi-Armed Bandit Problem')
plt.legend()
plt.grid(True)
plt.show()
