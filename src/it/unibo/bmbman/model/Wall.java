package it.unibo.bmbman.model;
import java.awt.Dimension;
import java.awt.Point;
/**
 * Class used to model the beaviour of a wall.
 */
public class Wall extends AbstractEntity {
    /**
     * Create a wall.
     * @param position start position of the monster
     * @param entityType type of the entity
     * @param dimension dimension2D of the monster
     */
    public Wall(final Point position, final EntityType entityType, final Dimension dimension) {
        super(position, entityType, dimension);
    }

    @Override
    public void onCollision(final Entity receiver, final Point newPosition) {
    }

    @Override
    public void update() {
    }

    @Override
    protected void reachedBorder() {
    }
}
