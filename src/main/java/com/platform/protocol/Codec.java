package com.platform.protocol;

import io.netty.buffer.ByteBuf;

public interface Codec {

    void encode(ByteBuf byteBuf, Packet packet);
    Packet decode(ByteBuf byteBuf);
}
