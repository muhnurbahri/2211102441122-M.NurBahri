import greenfoot.*;
public class Bird extends Actor {
    private int gravity = 1;
    private int jumpStrength = -15;
    private int velocity = 0;

    public void act() {
        applyGravity();
        checkKeyPress();
        checkCollision();
    }

    private void applyGravity() {
        velocity += gravity;
        setLocation(getX(), getY() + velocity);
    }

    private void checkKeyPress() {
        if (Greenfoot.isKeyDown("space")) {
            jump();
        }
    }

    private void jump() {
        velocity = jumpStrength;
    }

    private void checkCollision() {
        if (isTouching(Pipe.class)) {
            // Game over logic (e.g., end the game, show score, etc.)
            getWorld().showText("Game Over", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop(); // Stop the game
        }
    }
}

