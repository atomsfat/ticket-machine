package org.atoms.ticketmachine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

/**
 * @param <E> Entity
 * @param <R> Repository
 * @param <P> POJO
 *
 */
public class GenericService<E, P, R extends JpaRepository<E, UUID>> {

  private final  R r;
  private final  Function<E, P> mapEntityToPojo;
  private final  Function<P, E> mapPojoToEntity;


  public GenericService(final R r, final Function<E, P> mapEntityToPojo, final Function<P, E> mapPojoToEntity) {
    this.r = r;
    this.mapEntityToPojo = mapEntityToPojo;
    this.mapPojoToEntity = mapPojoToEntity;
  }

  public Page<E> findAll(final Pageable pageable) {
    return r.findAll(pageable);
  }

  public E save(final E e) {
    return r.save(e);
  }

  public Optional<E> findById(final UUID uuid) {
    return r.findById(uuid);
  }

  public void deleteById(final UUID uuid) {
     r.deleteById(uuid);
  }

  public P savePojo(final P p) {
    E e = mapPojoToEntity.apply(p);
    e = r.save(e);
    return mapEntityToPojo.apply(e);
  }

  public Optional<P> findPojoById(final UUID uuid) {
    Optional<E> e = this.findById(uuid);
    return e.map(mapEntityToPojo);
  }

  public Page<P> findAllPojos(final Pageable pageable) {
    return r.findAll(pageable).map(mapEntityToPojo);
  }

}
