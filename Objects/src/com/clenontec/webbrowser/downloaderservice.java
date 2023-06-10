package com.clenontec.webbrowser;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class downloaderservice extends  android.app.Service{
	public static class downloaderservice_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (downloaderservice) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, downloaderservice.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static downloaderservice mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return downloaderservice.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "com.clenontec.webbrowser", "com.clenontec.webbrowser.downloaderservice");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "com.clenontec.webbrowser.downloaderservice", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (downloaderservice) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (downloaderservice) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (downloaderservice) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (false) {
            BA.LogInfo("** Service (downloaderservice) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (downloaderservice) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _download_address = "";
public static String _download_filename = "";
public static long _downloadid = 0L;
public static uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager _downloadmanager1 = null;
public com.clenontec.webbrowser.main _main = null;
public com.clenontec.webbrowser.starter _starter = null;
public com.clenontec.webbrowser.utils _utils = null;
public com.clenontec.webbrowser.statemanager _statemanager = null;
public static String  _downloadmanager1_downloadcomplete(long _downloadid1) throws Exception{
RDebugUtils.currentModule="downloaderservice";
if (Debug.shouldDelegate(processBA, "downloadmanager1_downloadcomplete", false))
	 {return ((String) Debug.delegate(processBA, "downloadmanager1_downloadcomplete", new Object[] {_downloadid1}));}
uk.co.martinpearman.b4a.downloadmanager.QueryWrapper _downloadmanagerquery1 = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _statuscursor = null;
int _statusint = 0;
int _reasonint = 0;
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub DownloadManager1_DownloadComplete(DownloadId1";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Try";
try {RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="If DownloadId=DownloadId1 Then";
if (_downloadid==_downloadid1) { 
RDebugUtils.currentLine=5767177;
 //BA.debugLineNum = 5767177;BA.debugLine="Dim DownloadManagerQuery1 As DownloadManagerQue";
_downloadmanagerquery1 = new uk.co.martinpearman.b4a.downloadmanager.QueryWrapper();
RDebugUtils.currentLine=5767178;
 //BA.debugLineNum = 5767178;BA.debugLine="DownloadManagerQuery1.Initialize";
_downloadmanagerquery1.Initialize();
RDebugUtils.currentLine=5767179;
 //BA.debugLineNum = 5767179;BA.debugLine="DownloadManagerQuery1.SetFilterById(DownloadId)";
_downloadmanagerquery1.SetFilterById(_downloadid);
RDebugUtils.currentLine=5767182;
 //BA.debugLineNum = 5767182;BA.debugLine="Dim StatusCursor As Cursor";
_statuscursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=5767184;
 //BA.debugLineNum = 5767184;BA.debugLine="StatusCursor=DownloadManager1.Query(DownloadMan";
_statuscursor = _downloadmanager1.Query(processBA,(android.app.DownloadManager.Query)(_downloadmanagerquery1.getObject()));
RDebugUtils.currentLine=5767185;
 //BA.debugLineNum = 5767185;BA.debugLine="If StatusCursor.RowCount>0 Then";
if (_statuscursor.getRowCount()>0) { 
RDebugUtils.currentLine=5767186;
 //BA.debugLineNum = 5767186;BA.debugLine="StatusCursor.Position=0";
_statuscursor.setPosition((int) (0));
RDebugUtils.currentLine=5767188;
 //BA.debugLineNum = 5767188;BA.debugLine="Dim StatusInt As Int";
_statusint = 0;
RDebugUtils.currentLine=5767189;
 //BA.debugLineNum = 5767189;BA.debugLine="StatusInt=StatusCursor.getInt(DownloadManager1";
_statusint = _statuscursor.GetInt(_downloadmanager1.COLUMN_STATUS);
RDebugUtils.currentLine=5767190;
 //BA.debugLineNum = 5767190;BA.debugLine="Log(\"Download Status = \"&Utils.GetStatusText(S";
anywheresoftware.b4a.keywords.Common.LogImpl("85767190","Download Status = "+mostCurrent._utils._getstatustext /*String*/ (processBA,_statusint),0);
RDebugUtils.currentLine=5767192;
 //BA.debugLineNum = 5767192;BA.debugLine="If StatusInt=DownloadManager1.STATUS_FAILED Or";
if (_statusint==_downloadmanager1.STATUS_FAILED || _statusint==_downloadmanager1.STATUS_PAUSED) { 
RDebugUtils.currentLine=5767193;
 //BA.debugLineNum = 5767193;BA.debugLine="Dim ReasonInt As Int";
_reasonint = 0;
RDebugUtils.currentLine=5767194;
 //BA.debugLineNum = 5767194;BA.debugLine="ReasonInt=StatusCursor.GetInt(DownloadManager";
_reasonint = _statuscursor.GetInt(_downloadmanager1.COLUMN_REASON);
RDebugUtils.currentLine=5767195;
 //BA.debugLineNum = 5767195;BA.debugLine="Log(\"Status Reason = \"&Utils.GetReasonText(Re";
anywheresoftware.b4a.keywords.Common.LogImpl("85767195","Status Reason = "+mostCurrent._utils._getreasontext /*String*/ (processBA,_reasonint),0);
 };
RDebugUtils.currentLine=5767198;
 //BA.debugLineNum = 5767198;BA.debugLine="If StatusInt=DownloadManager1.STATUS_SUCCESSFU";
if (_statusint==_downloadmanager1.STATUS_SUCCESSFUL) { 
RDebugUtils.currentLine=5767200;
 //BA.debugLineNum = 5767200;BA.debugLine="ToastMessageShow(\"Download Successfull !\" & C";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Download Successfull !"+anywheresoftware.b4a.keywords.Common.CRLF+"Location : "+anywheresoftware.b4a.keywords.Common.File.getDirRootExternal()+"/Frigate/Download"+anywheresoftware.b4a.keywords.Common.CRLF+"File : "+_download_filename),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=5767204;
 //BA.debugLineNum = 5767204;BA.debugLine="Log(\"The DownloadManager has no trace of our r";
anywheresoftware.b4a.keywords.Common.LogImpl("85767204","The DownloadManager has no trace of our request, it could have been cancelled by the user using the Android Downloads app or an unknown error has occurred.",0);
 };
RDebugUtils.currentLine=5767207;
 //BA.debugLineNum = 5767207;BA.debugLine="StatusCursor.Close";
_statuscursor.Close();
RDebugUtils.currentLine=5767208;
 //BA.debugLineNum = 5767208;BA.debugLine="StopService(\"\")";
anywheresoftware.b4a.keywords.Common.StopService(processBA,(Object)(""));
 };
 } 
       catch (Exception e28) {
			processBA.setLastException(e28);RDebugUtils.currentLine=5767211;
 //BA.debugLineNum = 5767211;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("85767211",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
RDebugUtils.currentLine=5767212;
 //BA.debugLineNum = 5767212;BA.debugLine="ToastMessageShow(\"Download Error !\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Download Error !"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=5767215;
 //BA.debugLineNum = 5767215;BA.debugLine="End Sub";
return "";
}
public static String  _downloadmanager1_notificationclicked(long[] _downloadids) throws Exception{
RDebugUtils.currentModule="downloaderservice";
if (Debug.shouldDelegate(processBA, "downloadmanager1_notificationclicked", false))
	 {return ((String) Debug.delegate(processBA, "downloadmanager1_notificationclicked", new Object[] {_downloadids}));}
int _i = 0;
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub DownloadManager1_NotificationClicked(DownloadI";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="Try";
try {RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="ToastMessageShow(\"Download Length : \"&DownloadId";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Download Length : "+BA.NumberToString(_downloadids.length)),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="Log(\"DownloadManager1_NotificationClicked our do";
anywheresoftware.b4a.keywords.Common.LogImpl("85832708","DownloadManager1_NotificationClicked our download request is: "+BA.NumberToString(_downloadid),0);
RDebugUtils.currentLine=5832709;
 //BA.debugLineNum = 5832709;BA.debugLine="If DownloadIds<>Null Then";
if (_downloadids!= null) { 
RDebugUtils.currentLine=5832710;
 //BA.debugLineNum = 5832710;BA.debugLine="Log(\"DownloadIds length is: \"&DownloadIds.Lengt";
anywheresoftware.b4a.keywords.Common.LogImpl("85832710","DownloadIds length is: "+BA.NumberToString(_downloadids.length),0);
RDebugUtils.currentLine=5832712;
 //BA.debugLineNum = 5832712;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=5832713;
 //BA.debugLineNum = 5832713;BA.debugLine="For i=0 To DownloadIds.Length-1";
{
final int step7 = 1;
final int limit7 = (int) (_downloadids.length-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=5832714;
 //BA.debugLineNum = 5832714;BA.debugLine="Log(\"DownloadIds(\"&i&\")=\"&DownloadIds(i))";
anywheresoftware.b4a.keywords.Common.LogImpl("85832714","DownloadIds("+BA.NumberToString(_i)+")="+BA.NumberToString(_downloadids[_i]),0);
 }
};
 }else {
RDebugUtils.currentLine=5832717;
 //BA.debugLineNum = 5832717;BA.debugLine="Log(\"DownloadIds is Null\")";
anywheresoftware.b4a.keywords.Common.LogImpl("85832717","DownloadIds is Null",0);
 };
 } 
       catch (Exception e14) {
			processBA.setLastException(e14);RDebugUtils.currentLine=5832720;
 //BA.debugLineNum = 5832720;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("85832720",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
RDebugUtils.currentLine=5832721;
 //BA.debugLineNum = 5832721;BA.debugLine="ToastMessageShow(\"Download Error !\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Download Error !"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=5832724;
 //BA.debugLineNum = 5832724;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="downloaderservice";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="DownloadManager1.RegisterReceiver(\"DownloadManage";
_downloadmanager1.RegisterReceiver(processBA,"DownloadManager1");
RDebugUtils.currentLine=5570565;
 //BA.debugLineNum = 5570565;BA.debugLine="If Utils.IsInitialized=False Then";
if (mostCurrent._utils._isinitialized /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=5570566;
 //BA.debugLineNum = 5570566;BA.debugLine="Utils.Initialize(DownloadManager1)";
mostCurrent._utils._initialize /*String*/ (processBA,_downloadmanager1);
 };
RDebugUtils.currentLine=5570568;
 //BA.debugLineNum = 5570568;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="downloaderservice";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Try";
try {RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="DownloadManager1.UnregisterReceiver";
_downloadmanager1.UnregisterReceiver(processBA);
 } 
       catch (Exception e4) {
			processBA.setLastException(e4);RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("85701637",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
RDebugUtils.currentLine=5701638;
 //BA.debugLineNum = 5701638;BA.debugLine="ToastMessageShow(\"Download Error !\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Download Error !"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=5701641;
 //BA.debugLineNum = 5701641;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="downloaderservice";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
uk.co.martinpearman.b4a.downloadmanager.RequestWrapper _downloadmanagerrequest1 = null;
anywheresoftware.b4a.objects.IntentWrapper _dointent = null;
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="Try";
try {RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="Dim DownloadManagerRequest1 As DownloadManagerRe";
_downloadmanagerrequest1 = new uk.co.martinpearman.b4a.downloadmanager.RequestWrapper();
RDebugUtils.currentLine=5636099;
 //BA.debugLineNum = 5636099;BA.debugLine="DownloadManagerRequest1.Initialize(DOWNLOAD_ADDR";
_downloadmanagerrequest1.Initialize(_download_address);
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="DownloadManagerRequest1.Description= \"Frigate Sm";
_downloadmanagerrequest1.setDescription("Frigate Smart Downloader");
RDebugUtils.currentLine=5636102;
 //BA.debugLineNum = 5636102;BA.debugLine="Try";
try {RDebugUtils.currentLine=5636103;
 //BA.debugLineNum = 5636103;BA.debugLine="DownloadManagerRequest1.DestinationUri=\"file://";
_downloadmanagerrequest1.setDestinationUri("file://"+anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal()+"/Frigate/Download",_download_filename));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=5636105;
 //BA.debugLineNum = 5636105;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("85636105",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
RDebugUtils.currentLine=5636106;
 //BA.debugLineNum = 5636106;BA.debugLine="If Msgbox2(\"Directory Unavailable or STORAGE PE";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Directory Unavailable or STORAGE PERMISSION denied !"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Get Permission : Open Settings > Apps > Configure Apps > App Permissions > Storage > Frigate Browser"),BA.ObjectToCharSequence("READ CAREFULLY"),"Open Settings","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),processBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=5636107;
 //BA.debugLineNum = 5636107;BA.debugLine="Dim DoIntent As Intent";
_dointent = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=5636108;
 //BA.debugLineNum = 5636108;BA.debugLine="DoIntent.Initialize(\"android.settings.MANAGE_A";
_dointent.Initialize("android.settings.MANAGE_APPLICATIONS_SETTINGS","");
RDebugUtils.currentLine=5636109;
 //BA.debugLineNum = 5636109;BA.debugLine="StartActivity(DoIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_dointent.getObject()));
 }else {
 };
 };
RDebugUtils.currentLine=5636114;
 //BA.debugLineNum = 5636114;BA.debugLine="DownloadManagerRequest1.Title=DOWNLOAD_FILENAME";
_downloadmanagerrequest1.setTitle(_download_filename);
RDebugUtils.currentLine=5636115;
 //BA.debugLineNum = 5636115;BA.debugLine="DownloadManagerRequest1.VisibleInDownloadsUi=Tru";
_downloadmanagerrequest1.setVisibleInDownloadsUi(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636117;
 //BA.debugLineNum = 5636117;BA.debugLine="DownloadId=DownloadManager1.Enqueue(DownloadMana";
_downloadid = _downloadmanager1.Enqueue(processBA,(android.app.DownloadManager.Request)(_downloadmanagerrequest1.getObject()));
 } 
       catch (Exception e20) {
			processBA.setLastException(e20);RDebugUtils.currentLine=5636119;
 //BA.debugLineNum = 5636119;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("85636119",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
RDebugUtils.currentLine=5636120;
 //BA.debugLineNum = 5636120;BA.debugLine="ToastMessageShow(\"Download Error !\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Download Error !"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=5636123;
 //BA.debugLineNum = 5636123;BA.debugLine="End Sub";
return "";
}
}