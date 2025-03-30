# Arkanoid Game

## Overview
Arkanoid is a classic brick-breaker game where players control a paddle at the bottom of the screen to prevent a ball from falling out of bounds while trying to destroy all the bricks in each level.

## Installation Instructions

### Prerequisites
- Java JDK (version 8 or higher)
- Git

### Getting Started
1. **Clone the Repository**
   ```bash
   git clone https://github.com/OzGutman485/Arknoid-Game
   cd Arknoid-Game/src
   ```

2. **Compile the Game**
   ```bash
   # For Windows
   javac -cp .;biuoop-1.4.jar Ass6Game.java
   
   # For Mac/Linux
   javac -cp .:biuoop-1.4.jar Ass6Game.java
   ```

3. **Run the Game**
   ```bash
   # For Windows
   java -cp .;biuoop-1.4.jar Ass6Game
   
   # For Mac/Linux
   java -cp .:biuoop-1.4.jar Ass6Game
   ```
   
   **Note:** If no levels are provided as arguments, the game will run with the default 3 levels.

### Running Specific Levels
You can choose which levels to play by providing level numbers as arguments:

```bash
# For Windows - Play only level 1
java -cp .;biuoop-1.4.jar Ass6Game 1

# For Windows - Play levels 1 and 3
java -cp .;biuoop-1.4.jar Ass6Game 1 3

# For Mac/Linux - Play level 2
java -cp .:biuoop-1.4.jar Ass6Game 2
```

**Available Levels:**
1. Direct Hit - Aim at a single brick
2. Wide Easy - A wider level with more bricks
3. Green 3 - Complex level with multiple layers of bricks

## Controls
- **Left/Right Arrow Keys**: Move the paddle
- **P**: Pause the game
- **Space**: Launch the ball
- **ESC**: Exit the game

## Game Levels

### Level 1: Direct Hit
The first level, "Direct Hit," is a straightforward level where the player must aim for a single brick. This is an easy introduction to the mechanics.

![Direct Hit Level Screenshot](https://github.com/user-attachments/assets/1d34d2f0-4a17-4c29-958d-38eea3fd5b91)

### Level 2: Wide Easy
The second level, "Wide Easy," introduces more bricks and a wider paddle. This level is slightly more challenging but still accessible for beginners.

![Wide Easy Level Screenshot](https://github.com/user-attachments/assets/842ec1d6-931e-4b71-b9e8-44bad25e15a6)

### Level 3: Green 3
The third level, "Green 3," is more complex, with multiple layers of bricks to destroy. The difficulty increases as players must strategize and keep the ball in play for longer periods.

![Green 3 Level Screenshot](https://github.com/user-attachments/assets/1f22625e-ae65-4c90-9b63-553d62213e1f)

### End Screen
When you complete all the levels, you'll see the end screen!

![End Screen](https://github.com/user-attachments/assets/7a4568ba-3263-4792-bb87-cf4bf23933e4)

## Features
- Three unique levels with increasing difficulty
- Colorful and engaging gameplay
- Score tracking
- Multiple lives
- Customizable level selection via command line arguments

## Dependencies
- biuoop-1.4.jar - BIU Object-Oriented Programming library

## Development
This game was developed as part of the Object-Oriented Programming course at Bar-Ilan University.

## Good luck, and have fun breaking all the bricks!
