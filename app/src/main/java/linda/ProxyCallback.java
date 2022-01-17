package linda;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import linda.server.infrastructure.CallableRemote;
import linda.server.log.LogLevel;
import linda.server.log.Logger;

public class ProxyCallback implements Callback {
  private CallableRemote cb;

  public ProxyCallback(CallableRemote cb) {
    this.cb = cb;
  }

  public void call(Tuple t) {
    try {
      cb.call(t);
    } catch (RemoteException e) {
      Logger.log(e.getMessage().toString(), LogLevel.Error);
      throw new RuntimeException(e);
    }
  }
}