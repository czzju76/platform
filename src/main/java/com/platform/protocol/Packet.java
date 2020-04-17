package com.platform.protocol;

import lombok.Data;

@Data
public abstract class Packet {

    /**
     * 协议版本
     */
    private final Byte version = 1;

    /**
     * 指令
     */
    public abstract Byte getCommand();

}
