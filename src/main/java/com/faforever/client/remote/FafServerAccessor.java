package com.faforever.client.remote;

import com.faforever.client.game.Faction;
import com.faforever.client.game.NewGameInfo;
import com.faforever.client.net.ConnectionState;
import com.faforever.client.relay.GpgClientMessage;
import com.faforever.client.remote.domain.GameLaunchMessage;
import com.faforever.client.remote.domain.LoginMessage;
import com.faforever.client.remote.domain.ServerMessage;
import javafx.beans.property.ReadOnlyObjectProperty;
import org.jetbrains.annotations.Nullable;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Entry class for all communication with the FAF server.
 */
public interface FafServerAccessor {

  @SuppressWarnings("unchecked")
  <T extends ServerMessage> void addOnMessageListener(Class<T> type, Consumer<T> listener);

  @SuppressWarnings("unchecked")
  <T extends ServerMessage> void removeOnMessageListener(Class<T> type, Consumer<T> listener);

  ReadOnlyObjectProperty<ConnectionState> connectionStateProperty();

  CompletableFuture<LoginMessage> connectAndLogIn(String username, String password);

  CompletableFuture<GameLaunchMessage> requestHostGame(NewGameInfo newGameInfo, @Nullable InetSocketAddress relayAddress, int externalPort);

  CompletableFuture<GameLaunchMessage> requestJoinGame(int gameId, String password, @Nullable InetSocketAddress relayAddress, int externalPort);

  void disconnect();

  void reconnect();

  void addFriend(int playerId);

  void addFoe(int playerId);

  CompletableFuture<GameLaunchMessage> startSearchRanked1v1(Faction faction, int gamePort, @Nullable InetSocketAddress relayAddress);

  void stopSearchingRanked();

  void expand1v1Search(float radius);

  @Nullable
  Long getSessionId();

  void sendGpgMessage(GpgClientMessage message);

  void initConnectivityTest(int port);

  CompletableFuture<GameLaunchMessage> expectRehostCommand();

  void removeFriend(int playerId);

  void removeFoe(int playerId);
}