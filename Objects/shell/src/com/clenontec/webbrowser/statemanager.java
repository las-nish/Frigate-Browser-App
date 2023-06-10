
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

public class statemanager implements IRemote{
	public static statemanager mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public statemanager() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, statemanager.class);
    static {
		mostCurrent = new statemanager();
        remoteMe = RemoteObject.declareNull("com.clenontec.webbrowser.statemanager");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("statemanager"), "com.clenontec.webbrowser.statemanager");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("com.clenontec.webbrowser.statemanager"), new java.lang.ref.WeakReference<PCBA> (pcBA));
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
public static RemoteObject _states = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _listposition = RemoteObject.createImmutable(0);
public static RemoteObject _statesfilename = RemoteObject.createImmutable("");
public static RemoteObject _settingsfilename = RemoteObject.createImmutable("");
public static RemoteObject _settings = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static com.clenontec.webbrowser.main _main = null;
public static com.clenontec.webbrowser.starter _starter = null;
public static com.clenontec.webbrowser.downloaderservice _downloaderservice = null;
public static com.clenontec.webbrowser.utils _utils = null;
  public Object[] GetGlobals() {
		return new Object[] {"DownloaderService",Debug.moduleToString(com.clenontec.webbrowser.downloaderservice.class),"listPosition",statemanager._listposition,"Main",Debug.moduleToString(com.clenontec.webbrowser.main.class),"settings",statemanager._settings,"settingsFileName",statemanager._settingsfilename,"Starter",Debug.moduleToString(com.clenontec.webbrowser.starter.class),"states",statemanager._states,"statesFileName",statemanager._statesfilename,"Utils",Debug.moduleToString(com.clenontec.webbrowser.utils.class)};
}
}