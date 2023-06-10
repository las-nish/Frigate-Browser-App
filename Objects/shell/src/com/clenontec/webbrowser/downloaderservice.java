
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

public class downloaderservice implements IRemote{
	public static downloaderservice mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public downloaderservice() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("downloaderservice"), "com.clenontec.webbrowser.downloaderservice");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("com.clenontec.webbrowser.downloaderservice");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, downloaderservice.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _download_address = RemoteObject.createImmutable("");
public static RemoteObject _download_filename = RemoteObject.createImmutable("");
public static RemoteObject _downloadid = RemoteObject.createImmutable(0L);
public static RemoteObject _downloadmanager1 = RemoteObject.declareNull("uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager");
public static com.clenontec.webbrowser.main _main = null;
public static com.clenontec.webbrowser.starter _starter = null;
public static com.clenontec.webbrowser.utils _utils = null;
public static com.clenontec.webbrowser.statemanager _statemanager = null;
  public Object[] GetGlobals() {
		return new Object[] {"DOWNLOAD_ADDRESS",downloaderservice._download_address,"DOWNLOAD_FILENAME",downloaderservice._download_filename,"DownloadId",downloaderservice._downloadid,"DownloadManager1",downloaderservice._downloadmanager1,"Main",Debug.moduleToString(com.clenontec.webbrowser.main.class),"Service",downloaderservice.mostCurrent._service,"Starter",Debug.moduleToString(com.clenontec.webbrowser.starter.class),"StateManager",Debug.moduleToString(com.clenontec.webbrowser.statemanager.class),"Utils",Debug.moduleToString(com.clenontec.webbrowser.utils.class)};
}
}