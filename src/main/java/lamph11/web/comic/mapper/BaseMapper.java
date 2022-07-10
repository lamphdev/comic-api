package lamph11.web.comic.mapper;

import java.util.List;

public interface BaseMapper <E, D> {

    E toEntity(D DTO);

    List<E> toEntity(List<D> DTO);

    D toDTO(E entity);

    List<D> toDTO(List<E> entity);

}
