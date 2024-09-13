# Vacuum Cleaner Agent Simulation

This Java program simulates a model-based agent for a vacuum cleaner in a 2x2 grid environment. The vacuum cleaner decides its next action based on its current location and the cleanliness status of each square in the grid.

## Features

- Simulates a vacuum cleaner's decision-making process in a 2x2 grid.
- Accepts input via command-line arguments or interactive user input.
- Implements prioritized decision-making based on specified rules.
- Includes input validation and re-prompting for incorrect inputs.

## Environment Layout

The vacuum cleaner operates in a 2x2 grid environment:

```
| A | B |
| C | D |
```

## Rules

1. If all squares are clean, the vacuum cleaner stays in its current location.
2. If the current location is not clean, the vacuum cleaner stays to clean it.
3. The vacuum cleaner can only move horizontally or vertically (no diagonal moves).
4. Horizontal moves have higher priority than vertical moves.
5. The vacuum cleaner moves only when a square needs cleaning.
6. For diagonal dirty squares, the vacuum cleaner prioritizes the vertical neighbor.

## How to Run

### Compile the Program

```
javac Main.java
```

### Run with Command-line Arguments

```
java Main [current_location] [A_status] [B_status] [C_status] [D_status]
```

Example:
```
java Main A true false true true
```

### Run Interactively

Simply run the program without arguments:

```
java Main
```

Then follow the prompts to enter the required information.

## Input Format

- Current Location: A, B, C, or D (case-insensitive)
- Square Status: true (for clean) or false (for dirty)

## Output

The program will display:
1. The input state (current location and status of each square)
2. The next action (stay in the current location or move to a new square)

## Error Handling

- If invalid input is provided, the program will prompt for correct input.
- For command-line arguments, invalid input will throw an IllegalArgumentException.

## Example Usage

```
Enter current location (A, B, C, or D):
A
Enter status for A (true for clean, false for dirty):
true
Enter status for B (true for clean, false for dirty):
false
Enter status for C (true for clean, false for dirty):
true
Enter status for D (true for clean, false for dirty):
true

Current Location = A
Square A status = true
Square B status = false
Square C status = true
Square D status = true

Action - Next Location = B
```

In this example, the vacuum cleaner moves to B because it's the only dirty square and it's a horizontal move from the current location A.
