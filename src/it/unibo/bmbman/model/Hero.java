package it.unibo.bmbman.model;


import it.unibo.bmbman.controller.GameController;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.model.utilities.Velocity;
import it.unibo.bmbman.view.entities.BombState;
/**
 * Representing a hero in our application.
 */
public class Hero extends AbstractLivingEntity {
    private Double velocityModifier = 1.0;
    private int bombNumber;
    private boolean gotKey = false;
    private static final int START_POSITION = 50;
    private static final int DIMX = 48;
    private static final int DIMY = 48;
    private static final int NLIVES = 3;
    /**
     * Construct a Hero in game.
     */
    public Hero() {
        super(new Position(START_POSITION, START_POSITION), EntityType.HERO, new Dimension(DIMX, DIMY), NLIVES);
        this.bombNumber = 2;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void onCollision(final Collision c) {
        switch (c.getReceiver().getType()) {
        case BOMB:
            if (((Bomb) c.getReceiver()).getState() == BombState.IN_EXPLOSION) {
                removeLife();
            }
            break;
        case MONSTER:
            this.setPosition(c.getPosition());
            this.setDirection(Direction.IDLE);
            removeLife();
            break;
        default:
            this.setPosition(c.getPosition());
            this.setDirection(Direction.IDLE);
            break;

        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void move() {
        switch (getDirection()) {
        case IDLE:
            setVelocity(Velocity.ZERO);
            break;
        case UP:
            setVelocity(new Velocity(0, (int) (-Velocity.SPEED * velocityModifier)));
            break;
        case DOWN:
            setVelocity(new Velocity(0, (int) (Velocity.SPEED * velocityModifier)));
            break;
        case LEFT:
            setVelocity(new Velocity((int) (-Velocity.SPEED * velocityModifier), 0));
            break;
        case RIGHT:
            setVelocity(new Velocity((int) (Velocity.SPEED * velocityModifier), 0));
            break;
        default:
            break;
        }
    }
    /**
     * Set the velocity modifier field.
     * @param modifier the new value.
     */
    public void setVelocityModifier(final Double modifier) {
        this.velocityModifier = modifier;
    }
    /**
     * Used to know how many bombs the hero can plant.
     * @return the number of bombs
     */
    public int getBombNumber() {
        return this.bombNumber;
    }
    /**
     * Used to add a bomb to hero stock.
     */
    public void incrementBombNumber() {
        this.bombNumber++;
    }
    /**
     * Used to set if the hero has got the key.
     */
    public void setKeyFind() {
        this.gotKey = true;
    }
    /**
     * Method called only when the hero reach the door.
     * If he already got the key, he win the match, otherwise do nothing.
     */
    public boolean win() {
        return gotKey;
    }

}
