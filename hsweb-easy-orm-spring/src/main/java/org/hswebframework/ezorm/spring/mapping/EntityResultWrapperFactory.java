package org.hswebframework.ezorm.spring.mapping;

import org.hswebframework.ezorm.rdb.executor.wrapper.ResultWrapper;

public interface EntityResultWrapperFactory {

    <T> ResultWrapper<T, ?> getWrapper(Class<T> tClass);
}
