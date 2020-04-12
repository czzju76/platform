package com.platform.serialize;

public abstract class AbstractSerializer implements Serializer {

    public abstract byte getSerializerAlgorithm();

    public abstract byte[] serialize(Object object);

    public abstract <T> T deserialize(Class<T> clazz, byte[] bytes);
}