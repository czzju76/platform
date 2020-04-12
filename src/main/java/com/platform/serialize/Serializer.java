package com.platform.serialize;

public interface Serializer {
    /**
     * 获得序列化的算法
     */
    byte getSerializerAlgorithm();

    /**
     * 将java对象转换为字节数组
     */
    byte[] serialize(Object object);

    /**
     * 将字节数组转换为java对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
