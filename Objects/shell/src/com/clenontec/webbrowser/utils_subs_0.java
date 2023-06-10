package com.clenontec.webbrowser;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class utils_subs_0 {


public static RemoteObject  _getreasontext(RemoteObject _ba,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("GetReasonText (utils) ","utils",4,_ba,utils.mostCurrent,37);
if (RapidSub.canDelegate("getreasontext")) { return com.clenontec.webbrowser.utils.remoteMe.runUserSub(false, "utils","getreasontext", _ba, _index);}
;
Debug.locals.put("Index", _index);
 BA.debugLineNum = 37;BA.debugLine="Sub GetReasonText(Index As Int) As String";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Return ReasonTextMap.Get(Index)";
Debug.ShouldStop(32);
if (true) return BA.ObjectToString(utils._reasontextmap.runMethod(false,"Get",(Object)((_index))));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getstatustext(RemoteObject _ba,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("GetStatusText (utils) ","utils",4,_ba,utils.mostCurrent,41);
if (RapidSub.canDelegate("getstatustext")) { return com.clenontec.webbrowser.utils.remoteMe.runUserSub(false, "utils","getstatustext", _ba, _index);}
;
Debug.locals.put("Index", _index);
 BA.debugLineNum = 41;BA.debugLine="Sub GetStatusText(Index As Int) As String";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="Return StatusTextMap.Get(Index)";
Debug.ShouldStop(512);
if (true) return BA.ObjectToString(utils._statustextmap.runMethod(false,"Get",(Object)((_index))));
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject _ba,RemoteObject _downloadmanager1) throws Exception{
try {
		Debug.PushSubsStack("Initialize (utils) ","utils",4,_ba,utils.mostCurrent,9);
if (RapidSub.canDelegate("initialize")) { return com.clenontec.webbrowser.utils.remoteMe.runUserSub(false, "utils","initialize", _ba, _downloadmanager1);}
;
Debug.locals.put("DownloadManager1", _downloadmanager1);
 BA.debugLineNum = 9;BA.debugLine="Sub Initialize(DownloadManager1 As DownloadManager";
Debug.ShouldStop(256);
 BA.debugLineNum = 10;BA.debugLine="If IsInitialized=False Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",utils._isinitialized,utils.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 11;BA.debugLine="ReasonTextMap.Initialize";
Debug.ShouldStop(1024);
utils._reasontextmap.runVoidMethod ("Initialize");
 BA.debugLineNum = 12;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_CANNOT_";
Debug.ShouldStop(2048);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"ERROR_CANNOT_RESUME"))),(Object)((RemoteObject.createImmutable("ERROR_CANNOT_RESUME"))));
 BA.debugLineNum = 13;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_DEVICE_";
Debug.ShouldStop(4096);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"ERROR_DEVICE_NOT_FOUND"))),(Object)((RemoteObject.createImmutable("ERROR_DEVICE_NOT_FOUND"))));
 BA.debugLineNum = 14;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_FILE_AL";
Debug.ShouldStop(8192);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"ERROR_FILE_ALREADY_EXISTS"))),(Object)((RemoteObject.createImmutable("ERROR_FILE_ALREADY_EXISTS"))));
 BA.debugLineNum = 15;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_FILE_ER";
Debug.ShouldStop(16384);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"ERROR_FILE_ERROR"))),(Object)((RemoteObject.createImmutable("ERROR_FILE_ERROR"))));
 BA.debugLineNum = 16;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_HTTP_DA";
Debug.ShouldStop(32768);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"ERROR_HTTP_DATA_ERROR"))),(Object)((RemoteObject.createImmutable("ERROR_HTTP_DATA_ERROR"))));
 BA.debugLineNum = 17;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_INSUFFI";
Debug.ShouldStop(65536);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"ERROR_INSUFFICIENT_SPACE"))),(Object)((RemoteObject.createImmutable("ERROR_INSUFFICIENT_SPACE"))));
 BA.debugLineNum = 18;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_TOO_MAN";
Debug.ShouldStop(131072);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"ERROR_TOO_MANY_REDIRECTS"))),(Object)((RemoteObject.createImmutable("ERROR_TOO_MANY_REDIRECTS"))));
 BA.debugLineNum = 19;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_UNHANDL";
Debug.ShouldStop(262144);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"ERROR_UNHANDLED_HTTP_CODE"))),(Object)((RemoteObject.createImmutable("ERROR_UNHANDLED_HTTP_CODE"))));
 BA.debugLineNum = 20;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_UNKNOWN";
Debug.ShouldStop(524288);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"ERROR_UNKNOWN"))),(Object)((RemoteObject.createImmutable("ERROR_UNKNOWN"))));
 BA.debugLineNum = 21;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_QUEUED";
Debug.ShouldStop(1048576);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"PAUSED_QUEUED_FOR_WIFI"))),(Object)((RemoteObject.createImmutable("PAUSED_QUEUED_FOR_WIFI"))));
 BA.debugLineNum = 22;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_UNKNOW";
Debug.ShouldStop(2097152);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"PAUSED_UNKNOWN"))),(Object)((RemoteObject.createImmutable("PAUSED_UNKNOWN"))));
 BA.debugLineNum = 23;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_WAITIN";
Debug.ShouldStop(4194304);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"PAUSED_WAITING_FOR_NETWORK"))),(Object)((RemoteObject.createImmutable("PAUSED_WAITING_FOR_NETWORK"))));
 BA.debugLineNum = 24;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_WAITIN";
Debug.ShouldStop(8388608);
utils._reasontextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"PAUSED_WAITING_TO_RETRY"))),(Object)((RemoteObject.createImmutable("PAUSED_WAITING_TO_RETRY"))));
 BA.debugLineNum = 26;BA.debugLine="StatusTextMap.Initialize";
Debug.ShouldStop(33554432);
utils._statustextmap.runVoidMethod ("Initialize");
 BA.debugLineNum = 27;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_FAILED";
Debug.ShouldStop(67108864);
utils._statustextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"STATUS_FAILED"))),(Object)((RemoteObject.createImmutable("STATUS_FAILED"))));
 BA.debugLineNum = 28;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_PAUSED";
Debug.ShouldStop(134217728);
utils._statustextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"STATUS_PAUSED"))),(Object)((RemoteObject.createImmutable("STATUS_PAUSED"))));
 BA.debugLineNum = 29;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_PENDIN";
Debug.ShouldStop(268435456);
utils._statustextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"STATUS_PENDING"))),(Object)((RemoteObject.createImmutable("STATUS_PENDING"))));
 BA.debugLineNum = 30;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_RUNNIN";
Debug.ShouldStop(536870912);
utils._statustextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"STATUS_RUNNING"))),(Object)((RemoteObject.createImmutable("STATUS_RUNNING"))));
 BA.debugLineNum = 31;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_SUCCES";
Debug.ShouldStop(1073741824);
utils._statustextmap.runVoidMethod ("Put",(Object)((_downloadmanager1.getField(true,"STATUS_SUCCESSFUL"))),(Object)((RemoteObject.createImmutable("STATUS_SUCCESSFUL"))));
 BA.debugLineNum = 33;BA.debugLine="IsInitialized=True";
Debug.ShouldStop(1);
utils._isinitialized = utils.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim ReasonTextMap As Map";
utils._reasontextmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 4;BA.debugLine="Dim StatusTextMap As Map";
utils._statustextmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 6;BA.debugLine="Dim IsInitialized As Boolean=False";
utils._isinitialized = utils.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}