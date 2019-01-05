package com.faforever.client.fa.relay.ice;

import com.faforever.client.remote.ClientMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ICE message sent by the client to the server. Its content is unknown and irrelevant since it's just forwarded to
 * another client.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IceMessage implements ClientMessage {
  private int receiverId;
  private Object content;
}
