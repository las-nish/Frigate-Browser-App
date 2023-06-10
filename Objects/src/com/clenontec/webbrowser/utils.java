package com.clenontec.webbrowser;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class utils {
private static utils mostCurrent = new utils();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.collections.Map _reasontextmap = null;
public static anywheresoftware.b4a.objects.collections.Map _statustextmap = null;
public static boolean _isinitialized = false;
public com.clenontec.webbrowser.main _main = null;
public com.clenontec.webbrowser.starter _starter = null;
public com.clenontec.webbrowser.downloaderservice _downloaderservice = null;
public com.clenontec.webbrowser.statemanager _statemanager = null;
public static String  _getstatustext(anywheresoftware.b4a.BA _ba,int _index) throws Exception{
RDebugUtils.currentModule="utils";
if (Debug.shouldDelegate(null, "getstatustext", false))
	 {return ((String) Debug.delegate(null, "getstatustext", new Object[] {_ba,_index}));}
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub GetStatusText(Index As Int) As String";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Return StatusTextMap.Get(Index)";
if (true) return BA.ObjectToString(_statustextmap.Get((Object)(_index)));
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="End Sub";
return "";
}
public static String  _getreasontext(anywheresoftware.b4a.BA _ba,int _index) throws Exception{
RDebugUtils.currentModule="utils";
if (Debug.shouldDelegate(null, "getreasontext", false))
	 {return ((String) Debug.delegate(null, "getreasontext", new Object[] {_ba,_index}));}
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub GetReasonText(Index As Int) As String";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Return ReasonTextMap.Get(Index)";
if (true) return BA.ObjectToString(_reasontextmap.Get((Object)(_index)));
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="End Sub";
return "";
}
public static String  _initialize(anywheresoftware.b4a.BA _ba,uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager _downloadmanager1) throws Exception{
RDebugUtils.currentModule="utils";
if (Debug.shouldDelegate(null, "initialize", false))
	 {return ((String) Debug.delegate(null, "initialize", new Object[] {_ba,_downloadmanager1}));}
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub Initialize(DownloadManager1 As DownloadManager";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="If IsInitialized=False Then";
if (_isinitialized==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="ReasonTextMap.Initialize";
_reasontextmap.Initialize();
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_CANNOT_";
_reasontextmap.Put((Object)(_downloadmanager1.ERROR_CANNOT_RESUME),(Object)("ERROR_CANNOT_RESUME"));
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_DEVICE_";
_reasontextmap.Put((Object)(_downloadmanager1.ERROR_DEVICE_NOT_FOUND),(Object)("ERROR_DEVICE_NOT_FOUND"));
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_FILE_AL";
_reasontextmap.Put((Object)(_downloadmanager1.ERROR_FILE_ALREADY_EXISTS),(Object)("ERROR_FILE_ALREADY_EXISTS"));
RDebugUtils.currentLine=5963782;
 //BA.debugLineNum = 5963782;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_FILE_ER";
_reasontextmap.Put((Object)(_downloadmanager1.ERROR_FILE_ERROR),(Object)("ERROR_FILE_ERROR"));
RDebugUtils.currentLine=5963783;
 //BA.debugLineNum = 5963783;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_HTTP_DA";
_reasontextmap.Put((Object)(_downloadmanager1.ERROR_HTTP_DATA_ERROR),(Object)("ERROR_HTTP_DATA_ERROR"));
RDebugUtils.currentLine=5963784;
 //BA.debugLineNum = 5963784;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_INSUFFI";
_reasontextmap.Put((Object)(_downloadmanager1.ERROR_INSUFFICIENT_SPACE),(Object)("ERROR_INSUFFICIENT_SPACE"));
RDebugUtils.currentLine=5963785;
 //BA.debugLineNum = 5963785;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_TOO_MAN";
_reasontextmap.Put((Object)(_downloadmanager1.ERROR_TOO_MANY_REDIRECTS),(Object)("ERROR_TOO_MANY_REDIRECTS"));
RDebugUtils.currentLine=5963786;
 //BA.debugLineNum = 5963786;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_UNHANDL";
_reasontextmap.Put((Object)(_downloadmanager1.ERROR_UNHANDLED_HTTP_CODE),(Object)("ERROR_UNHANDLED_HTTP_CODE"));
RDebugUtils.currentLine=5963787;
 //BA.debugLineNum = 5963787;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_UNKNOWN";
_reasontextmap.Put((Object)(_downloadmanager1.ERROR_UNKNOWN),(Object)("ERROR_UNKNOWN"));
RDebugUtils.currentLine=5963788;
 //BA.debugLineNum = 5963788;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_QUEUED";
_reasontextmap.Put((Object)(_downloadmanager1.PAUSED_QUEUED_FOR_WIFI),(Object)("PAUSED_QUEUED_FOR_WIFI"));
RDebugUtils.currentLine=5963789;
 //BA.debugLineNum = 5963789;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_UNKNOW";
_reasontextmap.Put((Object)(_downloadmanager1.PAUSED_UNKNOWN),(Object)("PAUSED_UNKNOWN"));
RDebugUtils.currentLine=5963790;
 //BA.debugLineNum = 5963790;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_WAITIN";
_reasontextmap.Put((Object)(_downloadmanager1.PAUSED_WAITING_FOR_NETWORK),(Object)("PAUSED_WAITING_FOR_NETWORK"));
RDebugUtils.currentLine=5963791;
 //BA.debugLineNum = 5963791;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_WAITIN";
_reasontextmap.Put((Object)(_downloadmanager1.PAUSED_WAITING_TO_RETRY),(Object)("PAUSED_WAITING_TO_RETRY"));
RDebugUtils.currentLine=5963793;
 //BA.debugLineNum = 5963793;BA.debugLine="StatusTextMap.Initialize";
_statustextmap.Initialize();
RDebugUtils.currentLine=5963794;
 //BA.debugLineNum = 5963794;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_FAILED";
_statustextmap.Put((Object)(_downloadmanager1.STATUS_FAILED),(Object)("STATUS_FAILED"));
RDebugUtils.currentLine=5963795;
 //BA.debugLineNum = 5963795;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_PAUSED";
_statustextmap.Put((Object)(_downloadmanager1.STATUS_PAUSED),(Object)("STATUS_PAUSED"));
RDebugUtils.currentLine=5963796;
 //BA.debugLineNum = 5963796;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_PENDIN";
_statustextmap.Put((Object)(_downloadmanager1.STATUS_PENDING),(Object)("STATUS_PENDING"));
RDebugUtils.currentLine=5963797;
 //BA.debugLineNum = 5963797;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_RUNNIN";
_statustextmap.Put((Object)(_downloadmanager1.STATUS_RUNNING),(Object)("STATUS_RUNNING"));
RDebugUtils.currentLine=5963798;
 //BA.debugLineNum = 5963798;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_SUCCES";
_statustextmap.Put((Object)(_downloadmanager1.STATUS_SUCCESSFUL),(Object)("STATUS_SUCCESSFUL"));
RDebugUtils.currentLine=5963800;
 //BA.debugLineNum = 5963800;BA.debugLine="IsInitialized=True";
_isinitialized = anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=5963802;
 //BA.debugLineNum = 5963802;BA.debugLine="End Sub";
return "";
}
}