package me.rndstad.signapi.wrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import me.rndstad.signapi.objects.AbstractPacket;

public class WrapperPlayServerUpdateSign
        extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Server.UPDATE_SIGN;

    public WrapperPlayServerUpdateSign() {
        super(new PacketContainer(TYPE), TYPE);
        this.handle.getModifier().writeDefaults();
    }

    public WrapperPlayServerUpdateSign(PacketContainer packet) {
        super(packet, TYPE);
    }

    public BlockPosition getLocation() {
        return (BlockPosition) this.handle.getBlockPositionModifier().read(0);
    }

    public void setLocation(BlockPosition value) {
        this.handle.getBlockPositionModifier().write(0, value);
    }

    public WrappedChatComponent[] getLines() {
        return (WrappedChatComponent[]) this.handle.getChatComponentArrays().read(0);
    }

    public void setLines(WrappedChatComponent[] value) {
        if (value == null) {
            throw new IllegalArgumentException("[SignAPI] Value cannot be null!");
        }
        if (value.length != 4) {
            throw new IllegalArgumentException("[SignAPI] Value must have 4 elements!");
        }
        this.handle.getChatComponentArrays().write(0, value);
    }
}
