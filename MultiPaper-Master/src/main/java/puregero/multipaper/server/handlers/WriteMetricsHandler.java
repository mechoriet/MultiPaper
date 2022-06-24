package puregero.multipaper.server.handlers;

import puregero.multipaper.mastermessagingprotocol.messages.masterbound.WriteMetricsMessage;
import puregero.multipaper.server.ServerConnection;

public class WriteMetricsHandler {
    public static void handle(ServerConnection connection, WriteMetricsMessage message) {
        connection.setChunksloaded(message.chunksloaded);
        connection.setMemoryfree(message.memoryfree);
        connection.setEntities(message.entities);
    }
}
