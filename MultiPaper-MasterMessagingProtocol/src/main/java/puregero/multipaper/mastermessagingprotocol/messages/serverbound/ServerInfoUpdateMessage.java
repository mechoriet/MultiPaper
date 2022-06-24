package puregero.multipaper.mastermessagingprotocol.messages.serverbound;

import puregero.multipaper.mastermessagingprotocol.ExtendedByteBuf;

public class ServerInfoUpdateMessage extends ServerBoundMessage {

    public final String name;
    public final int averageTickTime;
    public final float tps;

    public final int chunksloaded;
    public final long memoryfree;
    public final int entities;

    public ServerInfoUpdateMessage(String name, int averageTickTime, float tps,int chunksloaded, long memoryfree, int entities) {
        this.name = name;
        this.averageTickTime = averageTickTime;
        this.tps = tps;
        this.chunksloaded = chunksloaded;
        this.memoryfree = memoryfree;
        this.entities = entities;
    }

    public ServerInfoUpdateMessage(ExtendedByteBuf byteBuf) {
        name = byteBuf.readString();
        averageTickTime = byteBuf.readInt();
        tps = byteBuf.readFloat();
        chunksloaded = byteBuf.readInt();
        memoryfree = byteBuf.readLong();
        entities = byteBuf.readInt();

    }

    @Override
    public void write(ExtendedByteBuf byteBuf) {
        byteBuf.writeString(name);
        byteBuf.writeInt(averageTickTime);
        byteBuf.writeFloat(tps);
        byteBuf.writeInt(chunksloaded);
        byteBuf.writeLong(memoryfree);
        byteBuf.writeInt(entities);
    }

    @Override
    public void handle(ServerBoundMessageHandler handler) {
        handler.handle(this);
    }
}
