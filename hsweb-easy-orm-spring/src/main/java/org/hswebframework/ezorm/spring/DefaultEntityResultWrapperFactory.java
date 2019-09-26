package org.hswebframework.ezorm.spring;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.hswebframework.ezorm.rdb.executor.wrapper.ResultWrapper;
import org.hswebframework.ezorm.rdb.mapping.EntityManager;
import org.hswebframework.ezorm.rdb.mapping.wrapper.EntityResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class DefaultEntityResultWrapperFactory implements EntityResultWrapperFactory {

    private EntityManager entityManager;

    @Override
    @SneakyThrows
    public <T> ResultWrapper<T, ?> getWrapper(Class<T> tClass) {
        return new EntityResultWrapper<>(() -> entityManager.newInstance(tClass),
                entityManager.getMapping(tClass));

    }
}
