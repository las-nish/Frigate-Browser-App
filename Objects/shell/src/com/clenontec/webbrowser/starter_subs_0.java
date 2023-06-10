package com.clenontec.webbrowser;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",1,starter.processBA,starter.mostCurrent,24);
if (RapidSub.canDelegate("application_error")) { return com.clenontec.webbrowser.starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 24;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Return True";
Debug.ShouldStop(16777216);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Public Provider As FileProvider";
starter._provider = RemoteObject.createNew ("com.clenontec.webbrowser.fileprovider");
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",1,starter.processBA,starter.mostCurrent,10);
if (RapidSub.canDelegate("service_create")) { return com.clenontec.webbrowser.starter.remoteMe.runUserSub(false, "starter","service_create");}
 BA.debugLineNum = 10;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(512);
 BA.debugLineNum = 11;BA.debugLine="Provider.Initialize";
Debug.ShouldStop(1024);
starter._provider.runClassMethod (com.clenontec.webbrowser.fileprovider.class, "_initialize" /*RemoteObject*/ ,starter.processBA);
 BA.debugLineNum = 12;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",1,starter.processBA,starter.mostCurrent,28);
if (RapidSub.canDelegate("service_destroy")) { return com.clenontec.webbrowser.starter.remoteMe.runUserSub(false, "starter","service_destroy");}
 BA.debugLineNum = 28;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",1,starter.processBA,starter.mostCurrent,14);
if (RapidSub.canDelegate("service_start")) { return com.clenontec.webbrowser.starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 14;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 17;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (starter) ","starter",1,starter.processBA,starter.mostCurrent,19);
if (RapidSub.canDelegate("service_taskremoved")) { return com.clenontec.webbrowser.starter.remoteMe.runUserSub(false, "starter","service_taskremoved");}
 BA.debugLineNum = 19;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(262144);
 BA.debugLineNum = 21;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}