package tute01.decoupled.receiver;

import tute01.decoupled.message.Message;

public interface Receivable {
    void receiveMessage(Message message);
}
