package com.platform.protocol;

import com.platform.serialize.Impl.JSONSerializer;
import com.platform.serialize.Serializer;
import com.platform.serialize.SerializerAlgorithm;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Map;

public class PacketCodec implements Codec {

    // 协议magic number
    private final static int MAGIC_NUMBER = 20100719;
    // 缺省的序列化算法
    private final Byte defaultSA = SerializerAlgorithm.JSON;
    // 协议指令集合
    private final Map<Byte, Class<? extends Packet>> packetMap;
    // 所有序列化算法与序列化工具的集合
    private final Map<Byte, Serializer> serializerMap;

    public PacketCodec(){
        packetMap = new HashMap<Byte, Class<? extends Packet>>();
        serializerMap = new HashMap<Byte, Serializer>();

        serializerMap.put(SerializerAlgorithm.JSON, new JSONSerializer());
    }

    public void encode(ByteBuf byteBuf, Packet packet) {
        // 1、写入magic number, 4字节
        byteBuf.writeInt(MAGIC_NUMBER);
        // 2、版本号，1字节
        byteBuf.writeByte(packet.getVersion());
        // 3、序列化算法，1字节
        byteBuf.writeByte(defaultSA);
        // 4、命令名称，1字节
        byteBuf.writeByte(packet.getCommand());
        // 5、指令长度，4字节
        byte[] bytes = serializerMap.get(defaultSA).serialize(packet);
        byteBuf.writeInt(bytes.length);
        // 6、指令数据
        byteBuf.writeBytes(bytes);

    }

    public Packet decode(ByteBuf byteBuf) {
        // 1、读出magic number，4字节
        int number = byteBuf.readInt();
        // 2、版本号，1字节
        byte version = byteBuf.readByte();
        // 3、序列化算法，1字节
        byte algorithm = byteBuf.readByte();
        Serializer serializer = serializerMap.get(algorithm);
        // 4、命令名称，1字节
        byte command = byteBuf.readByte();
        //Class<? extends Packet> packetType = packetMap.get(command);
        Class<? extends Packet> packetType = packetMap.get(command);
        // 5、指令长度，4字节
        int length = byteBuf.readInt();
        // 6、指令数据
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        if(packetType != null && serializer != null) {
            Packet packet = serializer.deserialize(packetType, bytes);
            return packet;
        }
        return null;
    }
}
