package it.unibo.bmbman.controller;

import java.util.Set;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.view.entities.EntityView;
/**
 * Interface to handler all the entity in game.
 */
public interface GameController {
    /**
     * Used to start the game.
     */
    void startGame();
    /**
     * Used to notify GameOver.
     */
    void gameOver();
    /**
     * Used to store all the entities in game.
     * @param entity the {@link Entity} to add
     * @param enitityView the {@link EntityView} of entity to add
     */
    void addEntity(Entity entity, EntityView enitityView);
    /**
     * Used to add a {@link Bomb}.
     */
    void addBomb();
    /**
     * used to know all the unwalkable entities.
     * @return a set of entity
     */
    Set<Entity> getUnwalkableEntity();
    /**
     *used to know all the walkable entities.
     * @return a set of entity
     */
    Set<Entity> getWalkableEntity();
    /**
     *used to know all the breakable entities.
     * @return a set of entity
     */
    Set<Entity> getBreakableEntity();
    /**
     *used to know all the unbreakable entities.
     * @return a set of entity
     */
    Set<Entity> getUnbreakableEntity();
    /**
     * Used to get the hero.
     * @return {@link Entity} representing player. 
     */
    Hero getHero();
    /**
     * Used to know if game is over.
     * @return true if hero is dead
     */
    boolean isGameOver();
    /**
     * Used to update any entity in the world.
     */
    void update();
    /**
     * this method notify a collision to {@link collisionController}.
     */
    void collisionDetect();
    /**
     * Remove entities from the world.
     */
    void removeEntities();
}

