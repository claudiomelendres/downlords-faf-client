package com.faforever.client.fa.relay;


import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class GpgGameMessage {

  private String command;
  private List<Object> args;

  public GpgGameMessage(GpgClientCommand command, List<Object> args) {
    this(command.getString(), args);
  }

  public GpgGameMessage(String command, List<Object> args) {
    this.command = command;
    this.args = args;
  }

  public List<Object> getArgs() {
    return args;
  }

  public GpgClientCommand getCommand() {
    return GpgClientCommand.fromString(command);
  }

  public Collection<String> getStringsToMask() {
    return Collections.emptyList();
  }

  protected int getInt(int index) {
    return ((Number) args.get(index)).intValue();
  }

  protected String getString(int index) {
    return ((String) args.get(index));
  }
}
