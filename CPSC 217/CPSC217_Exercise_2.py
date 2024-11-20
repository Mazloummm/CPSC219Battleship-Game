import math

# Number of people at party
numPeople= input("How many people will there be? ")
intnumPeople = int(numPeople)

# Number of pizza slices each person would eat
numSlices = input("How many slices will each person eat? ")
intnumSlices = int(numSlices)

# Number of slices per pizza
intpizzaSlices = 8

# Total Number of pizza slices
inttotalSlices = intnumPeople * intnumSlices

# Calculate the number of pizzas to order
pizzaOrder = math.ceil(inttotalSlices / intpizzaSlices)

# Print number of pizzas to order
print(f"You should order {pizzaOrder} pizzas.")
