
package com.clenontec.webbrowser;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class utils implements IRemote{
	public static utils mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public utils() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, utils.class);
    static {
		mostCurrent = new utils();
        remoteMe = RemoteObject.declareNull("com.clenontec.webbrowser.utils");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("utils"), "com.clenontec.webbrowser.utils");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("com.clenontec.webbrowser.utils"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _reasontextmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _statustextmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _isinitialized = RemoteObject.createImmutable(false);
public static com.clenontec.webbrowser.main _main = null;
public static com.clenontec.webbrowser.starter _starter = null;
public static com.clenontec.webbrowser.downloaderservice _downloaderservice = null;
public static com.clenontec.webbrowser.statemanager _statemanager = null;
  public Object[] GetGlobals() {
		return new Object[] {"DownloaderService",Debug.moduleToString(com.clenontec.webbrowser.downloaderservice.class),"IsInitialized",utils._isinitialized,"Main",Debug.moduleToString(com.clenontec.webbrowser.main.class),"ReasonTextMap",utils._reasontextmap,"Starter",Debug.moduleToString(com.clenontec.webbrowser.starter.class),"StateManager",Debug.moduleToString(com.clenontec.webbrowser.statemanager.class),"StatusTextMap",utils._statustextmap};
}
}