package com.platform.serialize.Impl;

import com.alibaba.fastjson.JSON;
import com.platform.serialize.AbstractSerializer;

public class JSONSerializer extends AbstractSerializer {
    @Override
    public byte getSerializerAlgorithm() {
        return 0;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
