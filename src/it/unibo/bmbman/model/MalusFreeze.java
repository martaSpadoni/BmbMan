package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Model a malus freeze power-up.
 */
public class MalusFreeze extends AbstractPowerupEntity {
    /**
     * Construct a malus freeze power-up in the world.
     * @param position where to create it.
     * @param dimension the dimension of the power-up.
     */
    public MalusFreeze(final Position position, final Dimension dimension) {
        super(position, dimension);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void powerupEffect(final Hero hero) {
        hero.setVelocityModifier(0.0);
    }
}