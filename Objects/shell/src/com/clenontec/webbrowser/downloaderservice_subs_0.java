package com.clenontec.webbrowser;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class downloaderservice_subs_0 {


public static RemoteObject  _downloadmanager1_downloadcomplete(RemoteObject _downloadid1) throws Exception{
try {
		Debug.PushSubsStack("DownloadManager1_DownloadComplete (downloaderservice) ","downloaderservice",3,downloaderservice.processBA,downloaderservice.mostCurrent,66);
if (RapidSub.canDelegate("downloadmanager1_downloadcomplete")) { return com.clenontec.webbrowser.downloaderservice.remoteMe.runUserSub(false, "downloaderservice","downloadmanager1_downloadcomplete", _downloadid1);}
RemoteObject _downloadmanagerquery1 = RemoteObject.declareNull("uk.co.martinpearman.b4a.downloadmanager.QueryWrapper");
RemoteObject _statuscursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _statusint = RemoteObject.createImmutable(0);
RemoteObject _reasonint = RemoteObject.createImmutable(0);
Debug.locals.put("DownloadId1", _downloadid1);
 BA.debugLineNum = 66;BA.debugLine="Sub DownloadManager1_DownloadComplete(DownloadId1";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="Try";
Debug.ShouldStop(4);
try { BA.debugLineNum = 72;BA.debugLine="If DownloadId=DownloadId1 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",downloaderservice._downloadid,BA.numberCast(double.class, _downloadid1))) { 
 BA.debugLineNum = 75;BA.debugLine="Dim DownloadManagerQuery1 As DownloadManagerQue";
Debug.ShouldStop(1024);
_downloadmanagerquery1 = RemoteObject.createNew ("uk.co.martinpearman.b4a.downloadmanager.QueryWrapper");Debug.locals.put("DownloadManagerQuery1", _downloadmanagerquery1);
 BA.debugLineNum = 76;BA.debugLine="DownloadManagerQuery1.Initialize";
Debug.ShouldStop(2048);
_downloadmanagerquery1.runVoidMethod ("Initialize");
 BA.debugLineNum = 77;BA.debugLine="DownloadManagerQuery1.SetFilterById(DownloadId)";
Debug.ShouldStop(4096);
_downloadmanagerquery1.runVoidMethod ("SetFilterById",(Object)(downloaderservice._downloadid));
 BA.debugLineNum = 80;BA.debugLine="Dim StatusCursor As Cursor";
Debug.ShouldStop(32768);
_statuscursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("StatusCursor", _statuscursor);
 BA.debugLineNum = 82;BA.debugLine="StatusCursor=DownloadManager1.Query(DownloadMan";
Debug.ShouldStop(131072);
_statuscursor = downloaderservice._downloadmanager1.runMethod(false,"Query",downloaderservice.processBA,(Object)((_downloadmanagerquery1.getObject())));Debug.locals.put("StatusCursor", _statuscursor);
 BA.debugLineNum = 83;BA.debugLine="If StatusCursor.RowCount>0 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",_statuscursor.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 84;BA.debugLine="StatusCursor.Position=0";
Debug.ShouldStop(524288);
_statuscursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 86;BA.debugLine="Dim StatusInt As Int";
Debug.ShouldStop(2097152);
_statusint = RemoteObject.createImmutable(0);Debug.locals.put("StatusInt", _statusint);
 BA.debugLineNum = 87;BA.debugLine="StatusInt=StatusCursor.getInt(DownloadManager1";
Debug.ShouldStop(4194304);
_statusint = _statuscursor.runMethod(true,"GetInt",(Object)(downloaderservice._downloadmanager1.getField(true,"COLUMN_STATUS")));Debug.locals.put("StatusInt", _statusint);
 BA.debugLineNum = 88;BA.debugLine="Log(\"Download Status = \"&Utils.GetStatusText(S";
Debug.ShouldStop(8388608);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85767190",RemoteObject.concat(RemoteObject.createImmutable("Download Status = "),downloaderservice.mostCurrent._utils.runMethod(true,"_getstatustext" /*RemoteObject*/ ,downloaderservice.processBA,(Object)(_statusint))),0);
 BA.debugLineNum = 90;BA.debugLine="If StatusInt=DownloadManager1.STATUS_FAILED Or";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_statusint,BA.numberCast(double.class, downloaderservice._downloadmanager1.getField(true,"STATUS_FAILED"))) || RemoteObject.solveBoolean("=",_statusint,BA.numberCast(double.class, downloaderservice._downloadmanager1.getField(true,"STATUS_PAUSED")))) { 
 BA.debugLineNum = 91;BA.debugLine="Dim ReasonInt As Int";
Debug.ShouldStop(67108864);
_reasonint = RemoteObject.createImmutable(0);Debug.locals.put("ReasonInt", _reasonint);
 BA.debugLineNum = 92;BA.debugLine="ReasonInt=StatusCursor.GetInt(DownloadManager";
Debug.ShouldStop(134217728);
_reasonint = _statuscursor.runMethod(true,"GetInt",(Object)(downloaderservice._downloadmanager1.getField(true,"COLUMN_REASON")));Debug.locals.put("ReasonInt", _reasonint);
 BA.debugLineNum = 93;BA.debugLine="Log(\"Status Reason = \"&Utils.GetReasonText(Re";
Debug.ShouldStop(268435456);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85767195",RemoteObject.concat(RemoteObject.createImmutable("Status Reason = "),downloaderservice.mostCurrent._utils.runMethod(true,"_getreasontext" /*RemoteObject*/ ,downloaderservice.processBA,(Object)(_reasonint))),0);
 };
 BA.debugLineNum = 96;BA.debugLine="If StatusInt=DownloadManager1.STATUS_SUCCESSFU";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_statusint,BA.numberCast(double.class, downloaderservice._downloadmanager1.getField(true,"STATUS_SUCCESSFUL")))) { 
 BA.debugLineNum = 98;BA.debugLine="ToastMessageShow(\"Download Successfull !\" & C";
Debug.ShouldStop(2);
downloaderservice.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Download Successfull !"),downloaderservice.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Location : "),downloaderservice.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal"),RemoteObject.createImmutable("/Frigate/Download"),downloaderservice.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("File : "),downloaderservice._download_filename))),(Object)(downloaderservice.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 102;BA.debugLine="Log(\"The DownloadManager has no trace of our r";
Debug.ShouldStop(32);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85767204",RemoteObject.createImmutable("The DownloadManager has no trace of our request, it could have been cancelled by the user using the Android Downloads app or an unknown error has occurred."),0);
 };
 BA.debugLineNum = 105;BA.debugLine="StatusCursor.Close";
Debug.ShouldStop(256);
_statuscursor.runVoidMethod ("Close");
 BA.debugLineNum = 106;BA.debugLine="StopService(\"\")";
Debug.ShouldStop(512);
downloaderservice.mostCurrent.__c.runVoidMethod ("StopService",downloaderservice.processBA,(Object)((RemoteObject.createImmutable(""))));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e28) {
			BA.rdebugUtils.runVoidMethod("setLastException",downloaderservice.processBA, e28.toString()); BA.debugLineNum = 109;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4096);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85767211",BA.ObjectToString(downloaderservice.mostCurrent.__c.runMethod(false,"LastException",downloaderservice.processBA)),0);
 BA.debugLineNum = 110;BA.debugLine="ToastMessageShow(\"Download Error !\",True)";
Debug.ShouldStop(8192);
downloaderservice.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Download Error !")),(Object)(downloaderservice.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _downloadmanager1_notificationclicked(RemoteObject _downloadids) throws Exception{
try {
		Debug.PushSubsStack("DownloadManager1_NotificationClicked (downloaderservice) ","downloaderservice",3,downloaderservice.processBA,downloaderservice.mostCurrent,115);
if (RapidSub.canDelegate("downloadmanager1_notificationclicked")) { return com.clenontec.webbrowser.downloaderservice.remoteMe.runUserSub(false, "downloaderservice","downloadmanager1_notificationclicked", _downloadids);}
RemoteObject _i = RemoteObject.createImmutable(0);
Debug.locals.put("DownloadIds", _downloadids);
 BA.debugLineNum = 115;BA.debugLine="Sub DownloadManager1_NotificationClicked(DownloadI";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 117;BA.debugLine="ToastMessageShow(\"Download Length : \"&DownloadId";
Debug.ShouldStop(1048576);
downloaderservice.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Download Length : "),_downloadids.getField(true,"length")))),(Object)(downloaderservice.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 119;BA.debugLine="Log(\"DownloadManager1_NotificationClicked our do";
Debug.ShouldStop(4194304);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85832708",RemoteObject.concat(RemoteObject.createImmutable("DownloadManager1_NotificationClicked our download request is: "),downloaderservice._downloadid),0);
 BA.debugLineNum = 120;BA.debugLine="If DownloadIds<>Null Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("N",_downloadids)) { 
 BA.debugLineNum = 121;BA.debugLine="Log(\"DownloadIds length is: \"&DownloadIds.Lengt";
Debug.ShouldStop(16777216);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85832710",RemoteObject.concat(RemoteObject.createImmutable("DownloadIds length is: "),_downloadids.getField(true,"length")),0);
 BA.debugLineNum = 123;BA.debugLine="Dim i As Int";
Debug.ShouldStop(67108864);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 124;BA.debugLine="For i=0 To DownloadIds.Length-1";
Debug.ShouldStop(134217728);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {_downloadids.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step7 > 0 && _i.<Integer>get().intValue() <= limit7) || (step7 < 0 && _i.<Integer>get().intValue() >= limit7) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 125;BA.debugLine="Log(\"DownloadIds(\"&i&\")=\"&DownloadIds(i))";
Debug.ShouldStop(268435456);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85832714",RemoteObject.concat(RemoteObject.createImmutable("DownloadIds("),_i,RemoteObject.createImmutable(")="),_downloadids.getArrayElement(true,_i)),0);
 }
}Debug.locals.put("i", _i);
;
 }else {
 BA.debugLineNum = 128;BA.debugLine="Log(\"DownloadIds is Null\")";
Debug.ShouldStop(-2147483648);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85832717",RemoteObject.createImmutable("DownloadIds is Null"),0);
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e14) {
			BA.rdebugUtils.runVoidMethod("setLastException",downloaderservice.processBA, e14.toString()); BA.debugLineNum = 131;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85832720",BA.ObjectToString(downloaderservice.mostCurrent.__c.runMethod(false,"LastException",downloaderservice.processBA)),0);
 BA.debugLineNum = 132;BA.debugLine="ToastMessageShow(\"Download Error !\",True)";
Debug.ShouldStop(8);
downloaderservice.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Download Error !")),(Object)(downloaderservice.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Dim DOWNLOAD_ADDRESS As String";
downloaderservice._download_address = RemoteObject.createImmutable("");
 //BA.debugLineNum = 9;BA.debugLine="Dim DOWNLOAD_FILENAME As String";
downloaderservice._download_filename = RemoteObject.createImmutable("");
 //BA.debugLineNum = 12;BA.debugLine="Dim DownloadId As Long";
downloaderservice._downloadid = RemoteObject.createImmutable(0L);
 //BA.debugLineNum = 13;BA.debugLine="Dim DownloadManager1 As DownloadManager";
downloaderservice._downloadmanager1 = RemoteObject.createNew ("uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (downloaderservice) ","downloaderservice",3,downloaderservice.processBA,downloaderservice.mostCurrent,16);
if (RapidSub.canDelegate("service_create")) { return com.clenontec.webbrowser.downloaderservice.remoteMe.runUserSub(false, "downloaderservice","service_create");}
 BA.debugLineNum = 16;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(32768);
 BA.debugLineNum = 18;BA.debugLine="DownloadManager1.RegisterReceiver(\"DownloadManage";
Debug.ShouldStop(131072);
downloaderservice._downloadmanager1.runVoidMethod ("RegisterReceiver",downloaderservice.processBA,(Object)(RemoteObject.createImmutable("DownloadManager1")));
 BA.debugLineNum = 21;BA.debugLine="If Utils.IsInitialized=False Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",downloaderservice.mostCurrent._utils._isinitialized /*RemoteObject*/ ,downloaderservice.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 22;BA.debugLine="Utils.Initialize(DownloadManager1)";
Debug.ShouldStop(2097152);
downloaderservice.mostCurrent._utils.runVoidMethod ("_initialize" /*RemoteObject*/ ,downloaderservice.processBA,(Object)(downloaderservice._downloadmanager1));
 };
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Service_Destroy (downloaderservice) ","downloaderservice",3,downloaderservice.processBA,downloaderservice.mostCurrent,55);
if (RapidSub.canDelegate("service_destroy")) { return com.clenontec.webbrowser.downloaderservice.remoteMe.runUserSub(false, "downloaderservice","service_destroy");}
 BA.debugLineNum = 55;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 58;BA.debugLine="DownloadManager1.UnregisterReceiver";
Debug.ShouldStop(33554432);
downloaderservice._downloadmanager1.runVoidMethod ("UnregisterReceiver",downloaderservice.processBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e4) {
			BA.rdebugUtils.runVoidMethod("setLastException",downloaderservice.processBA, e4.toString()); BA.debugLineNum = 60;BA.debugLine="Log(LastException)";
Debug.ShouldStop(134217728);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85701637",BA.ObjectToString(downloaderservice.mostCurrent.__c.runMethod(false,"LastException",downloaderservice.processBA)),0);
 BA.debugLineNum = 61;BA.debugLine="ToastMessageShow(\"Download Error !\",True)";
Debug.ShouldStop(268435456);
downloaderservice.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Download Error !")),(Object)(downloaderservice.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Service_Start (downloaderservice) ","downloaderservice",3,downloaderservice.processBA,downloaderservice.mostCurrent,26);
if (RapidSub.canDelegate("service_start")) { return com.clenontec.webbrowser.downloaderservice.remoteMe.runUserSub(false, "downloaderservice","service_start", _startingintent);}
RemoteObject _downloadmanagerrequest1 = RemoteObject.declareNull("uk.co.martinpearman.b4a.downloadmanager.RequestWrapper");
RemoteObject _dointent = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 26;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 28;BA.debugLine="Dim DownloadManagerRequest1 As DownloadManagerRe";
Debug.ShouldStop(134217728);
_downloadmanagerrequest1 = RemoteObject.createNew ("uk.co.martinpearman.b4a.downloadmanager.RequestWrapper");Debug.locals.put("DownloadManagerRequest1", _downloadmanagerrequest1);
 BA.debugLineNum = 29;BA.debugLine="DownloadManagerRequest1.Initialize(DOWNLOAD_ADDR";
Debug.ShouldStop(268435456);
_downloadmanagerrequest1.runVoidMethod ("Initialize",(Object)(downloaderservice._download_address));
 BA.debugLineNum = 30;BA.debugLine="DownloadManagerRequest1.Description= \"Frigate Sm";
Debug.ShouldStop(536870912);
_downloadmanagerrequest1.runVoidMethod ("setDescription",BA.ObjectToString("Frigate Smart Downloader"));
 BA.debugLineNum = 32;BA.debugLine="Try";
Debug.ShouldStop(-2147483648);
try { BA.debugLineNum = 33;BA.debugLine="DownloadManagerRequest1.DestinationUri=\"file://";
Debug.ShouldStop(1);
_downloadmanagerrequest1.runVoidMethod ("setDestinationUri",RemoteObject.concat(RemoteObject.createImmutable("file://"),downloaderservice.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(RemoteObject.concat(downloaderservice.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal"),RemoteObject.createImmutable("/Frigate/Download"))),(Object)(downloaderservice._download_filename))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",downloaderservice.processBA, e8.toString()); BA.debugLineNum = 35;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85636105",BA.ObjectToString(downloaderservice.mostCurrent.__c.runMethod(false,"LastException",downloaderservice.processBA)),0);
 BA.debugLineNum = 36;BA.debugLine="If Msgbox2(\"Directory Unavailable or STORAGE PE";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",downloaderservice.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Directory Unavailable or STORAGE PERMISSION denied !"),downloaderservice.mostCurrent.__c.getField(true,"CRLF"),downloaderservice.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Get Permission : Open Settings > Apps > Configure Apps > App Permissions > Storage > Frigate Browser")))),(Object)(BA.ObjectToCharSequence("READ CAREFULLY")),(Object)(BA.ObjectToString("Open Settings")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((downloaderservice.mostCurrent.__c.getField(false,"Null"))),downloaderservice.processBA),BA.numberCast(double.class, downloaderservice.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 37;BA.debugLine="Dim DoIntent As Intent";
Debug.ShouldStop(16);
_dointent = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("DoIntent", _dointent);
 BA.debugLineNum = 38;BA.debugLine="DoIntent.Initialize(\"android.settings.MANAGE_A";
Debug.ShouldStop(32);
_dointent.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.settings.MANAGE_APPLICATIONS_SETTINGS")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 39;BA.debugLine="StartActivity(DoIntent)";
Debug.ShouldStop(64);
downloaderservice.mostCurrent.__c.runVoidMethod ("StartActivity",downloaderservice.processBA,(Object)((_dointent.getObject())));
 }else {
 };
 };
 BA.debugLineNum = 44;BA.debugLine="DownloadManagerRequest1.Title=DOWNLOAD_FILENAME";
Debug.ShouldStop(2048);
_downloadmanagerrequest1.runVoidMethod ("setTitle",downloaderservice._download_filename);
 BA.debugLineNum = 45;BA.debugLine="DownloadManagerRequest1.VisibleInDownloadsUi=Tru";
Debug.ShouldStop(4096);
_downloadmanagerrequest1.runVoidMethod ("setVisibleInDownloadsUi",downloaderservice.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 47;BA.debugLine="DownloadId=DownloadManager1.Enqueue(DownloadMana";
Debug.ShouldStop(16384);
downloaderservice._downloadid = downloaderservice._downloadmanager1.runMethod(true,"Enqueue",downloaderservice.processBA,(Object)((_downloadmanagerrequest1.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e20) {
			BA.rdebugUtils.runVoidMethod("setLastException",downloaderservice.processBA, e20.toString()); BA.debugLineNum = 49;BA.debugLine="Log(LastException)";
Debug.ShouldStop(65536);
downloaderservice.mostCurrent.__c.runVoidMethod ("LogImpl","85636119",BA.ObjectToString(downloaderservice.mostCurrent.__c.runMethod(false,"LastException",downloaderservice.processBA)),0);
 BA.debugLineNum = 50;BA.debugLine="ToastMessageShow(\"Download Error !\",True)";
Debug.ShouldStop(131072);
downloaderservice.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Download Error !")),(Object)(downloaderservice.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 53;BA.debugLine="End Sub";
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