package puregero.multipaper.mastermessagingprotocol.messages.masterbound;

import puregero.multipaper.mastermessagingprotocol.ExtendedByteBuf;

public class WriteMetricsMessage extends MasterBoundMessage {


    public final int chunksloaded;
    public final long memoryfree;
    public final int entities;

    public WriteMetricsMessage(int chunksloaded, long memoryfree, int entities) {
        this.chunksloaded = chunksloaded;
        this.memoryfree = memoryfree;
        this.entities = entities;

    }

    public WriteMetricsMessage(ExtendedByteBuf byteBuf) {
        chunksloaded = byteBuf.readInt();
        memoryfree = byteBuf.readLong();
        entities = byteBuf.readInt();
    }

    @Override
    public void write(ExtendedByteBuf byteBuf) {
        byteBuf.writeInt(chunksloaded);
        byteBuf.writeLong(memoryfree);
        byteBuf.writeInt(entities);
    }

    @Override
    public void handle(MasterBoundMessageHandler handler) {
        handler.handle(this);
    }
}
