package com.platform.serialize.Impl;

import com.platform.serialize.AbstractSerializer;

public class JSONSerializer extends AbstractSerializer {
    @Override
    public byte getSerializerAlgorithm() {
        return 0;
    }

    @Override
    public byte[] serialize(Object object) {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return null;
    }
}
