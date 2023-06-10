
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

public class starter implements IRemote{
	public static starter mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public starter() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("starter"), "com.clenontec.webbrowser.starter");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("com.clenontec.webbrowser.starter");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, starter.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _provider = RemoteObject.declareNull("com.clenontec.webbrowser.fileprovider");
public static com.clenontec.webbrowser.main _main = null;
public static com.clenontec.webbrowser.downloaderservice _downloaderservice = null;
public static com.clenontec.webbrowser.utils _utils = null;
public static com.clenontec.webbrowser.statemanager _statemanager = null;
  public Object[] GetGlobals() {
		return new Object[] {"DownloaderService",Debug.moduleToString(com.clenontec.webbrowser.downloaderservice.class),"Main",Debug.moduleToString(com.clenontec.webbrowser.main.class),"Provider",starter._provider,"Service",starter.mostCurrent._service,"StateManager",Debug.moduleToString(com.clenontec.webbrowser.statemanager.class),"Utils",Debug.moduleToString(com.clenontec.webbrowser.utils.class)};
}
}