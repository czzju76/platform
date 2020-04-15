package com.platform.serialize.Impl;

import com.alibaba.fastjson.JSON;
import com.platform.serialize.Serializer;
import com.platform.serialize.SerializerAlgorithm;

public class JSONSerializer implements Serializer {

    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
