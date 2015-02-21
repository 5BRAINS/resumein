package ua.dou.hack.repository.common;

import java.io.Serializable;

public interface GenericRepository<T, PK extends Serializable>
        extends Operations<T, PK> {
}
