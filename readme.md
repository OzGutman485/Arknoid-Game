Arkanoid Game
Overview
Arkanoid is a classic brick-breaker game where players control a paddle at the bottom of the screen to prevent a ball from falling out of bounds while trying to destroy all the bricks in each level.
Installation Instructions
Prerequisites

Java JDK (version 8 or higher)
Git

Getting Started

Clone the Repository
bashCopygit clone https://github.com/OzGutman485/Arknoid-Game
cd Arknoid-Game/src

Compile the Game
bashCopy# For Windows
javac -cp .;biuoop-1.4.jar Ass6Game.java

# For Mac/Linux
javac -cp .:biuoop-1.4.jar Ass6Game.java

Run the Game
bashCopy# For Windows
java -cp .;biuoop-1.4.jar Ass6Game

# For Mac/Linux
java -cp .:biuoop-1.4.jar Ass6Game
Note: If no levels are provided as arguments, the game will run with the default 3 levels.

Controls

Left/Right Arrow Keys: Move the paddle
P: Pause the game
Space: Launch the ball
ESC: Exit the game

Game Levels
Level 1: Direct Hit
The first level, "Direct Hit," is a straightforward level where the player must aim for a single brick. This is an easy introduction to the mechanics.
Show Image
Level 2: Wide Easy
The second level, "Wide Easy," introduces more bricks and a wider paddle. This level is slightly more challenging but still accessible for beginners.
Show Image
Level 3: Green 3
The third level, "Green 3," is more complex, with multiple layers of bricks to destroy. The difficulty increases as players must strategize and keep the ball in play for longer periods.
Show Image
Victory Screen
Complete all levels to see the victory screen!
Show Image
Features

Three unique levels with increasing difficulty
Colorful and engaging gameplay
Score tracking
Multiple lives

Dependencies

biuoop-1.4.jar - BIU Object-Oriented Programming library

Development
This game was developed as part of the Object-Oriented Programming course at Bar-Ilan University.
Good luck, and have fun breaking all the bricks!
