package me.rndstad.signapi.wrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import me.rndstad.signapi.objects.AbstractPacket;

public class WrapperPlayServerOpenSignEntity
        extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Server.OPEN_SIGN_ENTITY;

    public WrapperPlayServerOpenSignEntity() {
        super(new PacketContainer(TYPE), TYPE);
        this.handle.getModifier().writeDefaults();
    }

    public WrapperPlayServerOpenSignEntity(PacketContainer packet) {
        super(packet, TYPE);
    }

    public BlockPosition getLocation() {
        return (BlockPosition) this.handle.getBlockPositionModifier().read(0);
    }

    public void setLocation(BlockPosition value) {
        this.handle.getBlockPositionModifier().write(0, value);
    }
}
