package org.traccar.repository;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.pelotas.arch.entity.BaseEntity;
import rs.pelotas.arch.repository.BaseRepository;

/**
 *
 * @author Rafael Guterres
 * @param <T>
 * @param <I>
 */
public abstract class BaseTraccarRepository<T extends BaseEntity, I extends Serializable> extends BaseRepository<T, I> {

    private static final long serialVersionUID = -6526885283678133001L;

    @PersistenceContext(unitName = "traccar")
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
