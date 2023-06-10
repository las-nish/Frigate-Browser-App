package com.clenontec.webbrowser;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,178);
if (RapidSub.canDelegate("activity_create")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _client = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 178;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 179;BA.debugLine="Activity.LoadLayout(\"Main_Layout\")";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main_Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 180;BA.debugLine="Txtbox_applock_text.Color=Colors.Transparent";
Debug.ShouldStop(524288);
main.mostCurrent._txtbox_applock_text.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 182;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/welco";
Debug.ShouldStop(2097152);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/welcome.html")));
 BA.debugLineNum = 185;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 186;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"psco";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("pscodecheck.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 187;BA.debugLine="Panel_App_Lock.BringToFront";
Debug.ShouldStop(67108864);
main.mostCurrent._panel_app_lock.runVoidMethod ("BringToFront");
 BA.debugLineNum = 188;BA.debugLine="Panel_App_Lock.Visible=True";
Debug.ShouldStop(134217728);
main.mostCurrent._panel_app_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 189;BA.debugLine="CheckBox_applock_enable.Checked=True";
Debug.ShouldStop(268435456);
main.mostCurrent._checkbox_applock_enable.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 191;BA.debugLine="Panel_App_Lock.Visible=False";
Debug.ShouldStop(1073741824);
main.mostCurrent._panel_app_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 192;BA.debugLine="CheckBox_applock_enable.Checked=False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._checkbox_applock_enable.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 195;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"goog";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("google.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 196;BA.debugLine="RadioButton_google.Checked=True";
Debug.ShouldStop(8);
main.mostCurrent._radiobutton_google.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 198;BA.debugLine="RadioButton_google.Checked=False";
Debug.ShouldStop(32);
main.mostCurrent._radiobutton_google.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 201;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"duck";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("duck.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 202;BA.debugLine="RadioButton_duck.Checked=True";
Debug.ShouldStop(512);
main.mostCurrent._radiobutton_duck.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 204;BA.debugLine="RadioButton_duck.Checked=False";
Debug.ShouldStop(2048);
main.mostCurrent._radiobutton_duck.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 207;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"bing";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("bing.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 208;BA.debugLine="RadioButton_bing.Checked=True";
Debug.ShouldStop(32768);
main.mostCurrent._radiobutton_bing.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 210;BA.debugLine="RadioButton_bing.Checked=False";
Debug.ShouldStop(131072);
main.mostCurrent._radiobutton_bing.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 213;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"yaho";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("yahoo.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 214;BA.debugLine="RadioButton_yahoo.Checked=True";
Debug.ShouldStop(2097152);
main.mostCurrent._radiobutton_yahoo.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 216;BA.debugLine="RadioButton_yahoo.Checked=False";
Debug.ShouldStop(8388608);
main.mostCurrent._radiobutton_yahoo.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 219;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 221;BA.debugLine="If RadioButton_google.Checked=True Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_google.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 222;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/goo";
Debug.ShouldStop(536870912);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/google.html")));
 };
 BA.debugLineNum = 224;BA.debugLine="If RadioButton_duck.Checked=True Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_duck.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 225;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/duc";
Debug.ShouldStop(1);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/duck.html")));
 };
 BA.debugLineNum = 227;BA.debugLine="If RadioButton_bing.Checked=True Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_bing.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 228;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/bin";
Debug.ShouldStop(8);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/bing.html")));
 };
 BA.debugLineNum = 230;BA.debugLine="If RadioButton_yahoo.Checked=True Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_yahoo.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 231;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/yah";
Debug.ShouldStop(64);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/yahoo.html")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e47) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e47.toString()); BA.debugLineNum = 234;BA.debugLine="Log(LastException)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","8131128",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 BA.debugLineNum = 235;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/goo";
Debug.ShouldStop(1024);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/google.html")));
 };
 BA.debugLineNum = 239;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"save";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("savepass.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 240;BA.debugLine="CheckBox_savepass.Checked=True";
Debug.ShouldStop(32768);
main.mostCurrent._checkbox_savepass.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 241;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Tr";
Debug.ShouldStop(65536);
main.mostCurrent._webviewsettings.runVoidMethod ("setSaveFormData",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 242;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Tr";
Debug.ShouldStop(131072);
main.mostCurrent._webviewsettings.runVoidMethod ("setSavePassword",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 243;BA.debugLine="WebViewSettings.setSaveFormData(WebView_Reading";
Debug.ShouldStop(262144);
main.mostCurrent._webviewsettings.runVoidMethod ("setSaveFormData",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 244;BA.debugLine="WebViewSettings.setSavePassword(WebView_Reading";
Debug.ShouldStop(524288);
main.mostCurrent._webviewsettings.runVoidMethod ("setSavePassword",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 246;BA.debugLine="CheckBox_savepass.Checked=False";
Debug.ShouldStop(2097152);
main.mostCurrent._checkbox_savepass.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 247;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Fa";
Debug.ShouldStop(4194304);
main.mostCurrent._webviewsettings.runVoidMethod ("setSaveFormData",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 248;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Fa";
Debug.ShouldStop(8388608);
main.mostCurrent._webviewsettings.runVoidMethod ("setSavePassword",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 249;BA.debugLine="WebViewSettings.setSaveFormData(WebView_Reading";
Debug.ShouldStop(16777216);
main.mostCurrent._webviewsettings.runVoidMethod ("setSaveFormData",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 250;BA.debugLine="WebViewSettings.setSavePassword(WebView_Reading";
Debug.ShouldStop(33554432);
main.mostCurrent._webviewsettings.runVoidMethod ("setSavePassword",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 253;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"dnt.";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("dnt.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 254;BA.debugLine="CheckBox_dnt.Checked=True";
Debug.ShouldStop(536870912);
main.mostCurrent._checkbox_dnt.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 256;BA.debugLine="CheckBox_dnt.Checked=False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._checkbox_dnt.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 259;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"js.t";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("js.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 260;BA.debugLine="CheckBox_js.Checked=True";
Debug.ShouldStop(8);
main.mostCurrent._checkbox_js.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 261;BA.debugLine="main_webview.JavaScriptEnabled=True";
Debug.ShouldStop(16);
main.mostCurrent._main_webview.runMethod(true,"setJavaScriptEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 262;BA.debugLine="WebView_ReadingFullScreen_Mode.JavaScriptEnable";
Debug.ShouldStop(32);
main.mostCurrent._webview_readingfullscreen_mode.runMethod(true,"setJavaScriptEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 263;BA.debugLine="WebViewSettings.setJavaScriptCanOpenWindowsAuto";
Debug.ShouldStop(64);
main.mostCurrent._webviewsettings.runVoidMethod ("setJavaScriptCanOpenWindowsAutomatically",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 264;BA.debugLine="WebViewSettings.setJavaScriptCanOpenWindowsAuto";
Debug.ShouldStop(128);
main.mostCurrent._webviewsettings.runVoidMethod ("setJavaScriptCanOpenWindowsAutomatically",(Object)((main.mostCurrent._panel_webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 266;BA.debugLine="CheckBox_js.Checked=False";
Debug.ShouldStop(512);
main.mostCurrent._checkbox_js.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 267;BA.debugLine="main_webview.JavaScriptEnabled=False";
Debug.ShouldStop(1024);
main.mostCurrent._main_webview.runMethod(true,"setJavaScriptEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 268;BA.debugLine="WebViewSettings.setJavaScriptCanOpenWindowsAuto";
Debug.ShouldStop(2048);
main.mostCurrent._webviewsettings.runVoidMethod ("setJavaScriptCanOpenWindowsAutomatically",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 269;BA.debugLine="WebViewSettings.setJavaScriptCanOpenWindowsAuto";
Debug.ShouldStop(4096);
main.mostCurrent._webviewsettings.runVoidMethod ("setJavaScriptCanOpenWindowsAutomatically",(Object)((main.mostCurrent._panel_webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 270;BA.debugLine="WebView_ReadingFullScreen_Mode.JavaScriptEnable";
Debug.ShouldStop(8192);
main.mostCurrent._webview_readingfullscreen_mode.runMethod(true,"setJavaScriptEnabled",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 273;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"boos";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("boostr.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 274;BA.debugLine="CheckBox_boostmode.Checked=True";
Debug.ShouldStop(131072);
main.mostCurrent._checkbox_boostmode.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 276;BA.debugLine="CheckBox_boostmode.Checked=False";
Debug.ShouldStop(524288);
main.mostCurrent._checkbox_boostmode.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 279;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"cook";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("cookie.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 280;BA.debugLine="CheckBox_cookie.Checked=True";
Debug.ShouldStop(8388608);
main.mostCurrent._checkbox_cookie.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 281;BA.debugLine="WebViewExtender.getAcceptCookie(main_webview)";
Debug.ShouldStop(16777216);
main.mostCurrent._webviewextender.runVoidMethod ("getAcceptCookie",(Object)((main.mostCurrent._main_webview.getObject())));
 BA.debugLineNum = 282;BA.debugLine="WebViewExtender.getAcceptCookie(WebView_Reading";
Debug.ShouldStop(33554432);
main.mostCurrent._webviewextender.runVoidMethod ("getAcceptCookie",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())));
 }else {
 BA.debugLineNum = 284;BA.debugLine="CheckBox_cookie.Checked=False";
Debug.ShouldStop(134217728);
main.mostCurrent._checkbox_cookie.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 287;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"sfse";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("sfsearch.txt"))),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 288;BA.debugLine="CheckBox_safesearch.Checked=True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._checkbox_safesearch.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 290;BA.debugLine="CheckBox_safesearch.Checked=False";
Debug.ShouldStop(2);
main.mostCurrent._checkbox_safesearch.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e99) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e99.toString()); BA.debugLineNum = 296;BA.debugLine="Log(LastException)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("LogImpl","8131190",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 299;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 300;BA.debugLine="If File.Exists(File.DirDefaultExternal,\"history.";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("history.txt"))),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 301;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"histo";
Debug.ShouldStop(4096);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("history.txt")),(Object)(RemoteObject.createImmutable("")));
 }else {
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e107) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e107.toString()); BA.debugLineNum = 306;BA.debugLine="Log(LastException)";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("LogImpl","8131200",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 310;BA.debugLine="webviewextras.addWebChromeClient(main_webview,Tru";
Debug.ShouldStop(2097152);
main.mostCurrent._webviewextras.runVoidMethod ("addWebChromeClient",main.mostCurrent.activityBA,(Object)((main.mostCurrent._main_webview.getObject())),(Object)(BA.ObjectToString(main.mostCurrent.__c.getField(true,"True"))));
 BA.debugLineNum = 312;BA.debugLine="ListView_Settings_hostory.FastScrollEnabled=True";
Debug.ShouldStop(8388608);
main.mostCurrent._listview_settings_hostory.runMethod(true,"setFastScrollEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 320;BA.debugLine="Dim client As JavaObject";
Debug.ShouldStop(-2147483648);
_client = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("client", _client);
 BA.debugLineNum = 321;BA.debugLine="client.InitializeNewInstance(Application.PackageN";
Debug.ShouldStop(1);
_client.runVoidMethod ("InitializeNewInstance",(Object)(RemoteObject.concat(main.mostCurrent.__c.getField(false,"Application").runMethod(true,"getPackageName"),RemoteObject.createImmutable(".main$MyChromeClient"))),(Object)((main.mostCurrent.__c.getField(false,"Null"))));
 BA.debugLineNum = 322;BA.debugLine="Dim jo As JavaObject = main_webview";
Debug.ShouldStop(2);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(main.mostCurrent._main_webview.getObject());Debug.locals.put("jo", _jo);
 BA.debugLineNum = 323;BA.debugLine="jo.RunMethod(\"setWebChromeClient\", Array(client))";
Debug.ShouldStop(4);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setWebChromeClient")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_client.getObject())})));
 BA.debugLineNum = 326;BA.debugLine="main_webview.Color=Colors.Transparent";
Debug.ShouldStop(32);
main.mostCurrent._main_webview.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 327;BA.debugLine="WebView_ReadingFullScreen_Mode.Color=Colors.Trans";
Debug.ShouldStop(64);
main.mostCurrent._webview_readingfullscreen_mode.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 329;BA.debugLine="btn_batterysaver.Color=Colors.Transparent";
Debug.ShouldStop(256);
main.mostCurrent._btn_batterysaver.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 330;BA.debugLine="btn_jsdisable.Color=Colors.Transparent";
Debug.ShouldStop(512);
main.mostCurrent._btn_jsdisable.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 331;BA.debugLine="btn_ytgames.Color=Colors.Transparent";
Debug.ShouldStop(1024);
main.mostCurrent._btn_ytgames.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 332;BA.debugLine="btn_quora.Color=Colors.Transparent";
Debug.ShouldStop(2048);
main.mostCurrent._btn_quora.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 333;BA.debugLine="btn_zoomenabled.Color=Colors.Transparent";
Debug.ShouldStop(4096);
main.mostCurrent._btn_zoomenabled.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 334;BA.debugLine="btn_fullscreenreadingmode_exit.Color=Colors.Trans";
Debug.ShouldStop(8192);
main.mostCurrent._btn_fullscreenreadingmode_exit.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 335;BA.debugLine="btn_refreshclose.Color=Colors.Transparent";
Debug.ShouldStop(16384);
main.mostCurrent._btn_refreshclose.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 336;BA.debugLine="btn_fullscreen_fowrd.Color=Colors.Transparent";
Debug.ShouldStop(32768);
main.mostCurrent._btn_fullscreen_fowrd.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 337;BA.debugLine="btn_fullscreen_back.Color=Colors.Transparent";
Debug.ShouldStop(65536);
main.mostCurrent._btn_fullscreen_back.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 338;BA.debugLine="btn_appexit.Color=Colors.Transparent";
Debug.ShouldStop(131072);
main.mostCurrent._btn_appexit.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 339;BA.debugLine="btn_runappbackground.Color=Colors.Transparent";
Debug.ShouldStop(262144);
main.mostCurrent._btn_runappbackground.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 340;BA.debugLine="btn_urlplus.Color=Colors.Transparent";
Debug.ShouldStop(524288);
main.mostCurrent._btn_urlplus.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 341;BA.debugLine="btn_appsettingsmore.Color=Colors.Transparent";
Debug.ShouldStop(1048576);
main.mostCurrent._btn_appsettingsmore.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 342;BA.debugLine="btn_back.Color=Colors.Transparent";
Debug.ShouldStop(2097152);
main.mostCurrent._btn_back.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 343;BA.debugLine="btn_darkmode.Color=Colors.Transparent";
Debug.ShouldStop(4194304);
main.mostCurrent._btn_darkmode.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 344;BA.debugLine="btn_downloader.Color=Colors.Transparent";
Debug.ShouldStop(8388608);
main.mostCurrent._btn_downloader.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 345;BA.debugLine="btn_drawer.Color=Colors.Transparent";
Debug.ShouldStop(16777216);
main.mostCurrent._btn_drawer.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 346;BA.debugLine="btn_extrasites.Color=Colors.Transparent";
Debug.ShouldStop(33554432);
main.mostCurrent._btn_extrasites.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 347;BA.debugLine="btn_fb.Color=Colors.Transparent";
Debug.ShouldStop(67108864);
main.mostCurrent._btn_fb.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 348;BA.debugLine="btn_fowrd.Color=Colors.Transparent";
Debug.ShouldStop(134217728);
main.mostCurrent._btn_fowrd.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 349;BA.debugLine="btn_helpguide.Color=Colors.Transparent";
Debug.ShouldStop(268435456);
main.mostCurrent._btn_helpguide.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 350;BA.debugLine="btn_hidedownloadpanel.Color=Colors.Transparent";
Debug.ShouldStop(536870912);
main.mostCurrent._btn_hidedownloadpanel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 351;BA.debugLine="btn_home.Color=Colors.Transparent";
Debug.ShouldStop(1073741824);
main.mostCurrent._btn_home.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 352;BA.debugLine="btn_imagedisable.Color=Colors.Transparent";
Debug.ShouldStop(-2147483648);
main.mostCurrent._btn_imagedisable.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 353;BA.debugLine="btn_instr.Color=Colors.Transparent";
Debug.ShouldStop(1);
main.mostCurrent._btn_instr.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 354;BA.debugLine="btn_intergrton.Color=Colors.Transparent";
Debug.ShouldStop(2);
main.mostCurrent._btn_intergrton.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 355;BA.debugLine="btn_lnkdin.Color=Colors.Transparent";
Debug.ShouldStop(4);
main.mostCurrent._btn_lnkdin.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 356;BA.debugLine="btn_openweblinkanotherbrowser.Color=Colors.Transp";
Debug.ShouldStop(8);
main.mostCurrent._btn_openweblinkanotherbrowser.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 357;BA.debugLine="btn_panel_intergration_hide.Color=Colors.Transpar";
Debug.ShouldStop(16);
main.mostCurrent._btn_panel_intergration_hide.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 358;BA.debugLine="btn_pintrst.Color=Colors.Transparent";
Debug.ShouldStop(32);
main.mostCurrent._btn_pintrst.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 359;BA.debugLine="btn_rddit.Color=Colors.Transparent";
Debug.ShouldStop(64);
main.mostCurrent._btn_rddit.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 360;BA.debugLine="btn_readingfullscreenmode.Color=Colors.Transparen";
Debug.ShouldStop(128);
main.mostCurrent._btn_readingfullscreenmode.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 361;BA.debugLine="btn_refresh.Color=Colors.Transparent";
Debug.ShouldStop(256);
main.mostCurrent._btn_refresh.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 362;BA.debugLine="btn_screenshot.Color=Colors.Transparent";
Debug.ShouldStop(512);
main.mostCurrent._btn_screenshot.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 363;BA.debugLine="btn_search.Color=Colors.Transparent";
Debug.ShouldStop(1024);
main.mostCurrent._btn_search.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 364;BA.debugLine="btn_shareapp.Color=Colors.Transparent";
Debug.ShouldStop(2048);
main.mostCurrent._btn_shareapp.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 365;BA.debugLine="btn_shareweburl.Color=Colors.Transparent";
Debug.ShouldStop(4096);
main.mostCurrent._btn_shareweburl.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 366;BA.debugLine="btn_snpcht.Color=Colors.Transparent";
Debug.ShouldStop(8192);
main.mostCurrent._btn_snpcht.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 367;BA.debugLine="btn_soundcloud.Color=Colors.Transparent";
Debug.ShouldStop(16384);
main.mostCurrent._btn_soundcloud.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 368;BA.debugLine="btn_startdownload.Color=Colors.Transparent";
Debug.ShouldStop(32768);
main.mostCurrent._btn_startdownload.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 369;BA.debugLine="btn_telgrm.Color=Colors.Transparent";
Debug.ShouldStop(65536);
main.mostCurrent._btn_telgrm.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 370;BA.debugLine="btn_twttr.Color=Colors.Transparent";
Debug.ShouldStop(131072);
main.mostCurrent._btn_twttr.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 371;BA.debugLine="btn_youtube.Color=Colors.Transparent";
Debug.ShouldStop(262144);
main.mostCurrent._btn_youtube.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 372;BA.debugLine="btn_clearalldataapp.Color=Colors.Transparent";
Debug.ShouldStop(524288);
main.mostCurrent._btn_clearalldataapp.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 374;BA.debugLine="textbox_download_filename.Color=Colors.Transparen";
Debug.ShouldStop(2097152);
main.mostCurrent._textbox_download_filename.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 375;BA.debugLine="textbox_download_url.Color=Colors.Transparent";
Debug.ShouldStop(4194304);
main.mostCurrent._textbox_download_url.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 376;BA.debugLine="textbox_search_bar.Color=Colors.Transparent";
Debug.ShouldStop(8388608);
main.mostCurrent._textbox_search_bar.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 378;BA.debugLine="lbl_paneldownload_head.Color=Colors.Transparent";
Debug.ShouldStop(33554432);
main.mostCurrent._lbl_paneldownload_head.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 382;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("activity_KeyPress (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,987);
if (RapidSub.canDelegate("activity_keypress")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 987;BA.debugLine="Sub activity_KeyPress(KeyCode As Int) As Boolean";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 988;BA.debugLine="Select KeyCode";
Debug.ShouldStop(134217728);
switch (BA.switchObjectToInt(_keycode,main.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK"))) {
case 0: {
 BA.debugLineNum = 990;BA.debugLine="page_back";
Debug.ShouldStop(536870912);
_page_back();
 BA.debugLineNum = 991;BA.debugLine="Return True";
Debug.ShouldStop(1073741824);
if (true) return main.mostCurrent.__c.getField(true,"True");
 break; }
}
;
 BA.debugLineNum = 993;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,403);
if (RapidSub.canDelegate("activity_pause")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 403;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 415;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,384);
if (RapidSub.canDelegate("activity_resume")) { com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","activity_resume"); return;}
ResumableSub_Activity_Resume rsub = new ResumableSub_Activity_Resume(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Resume extends BA.ResumableSub {
public ResumableSub_Activity_Resume(com.clenontec.webbrowser.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.clenontec.webbrowser.main parent;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject group2;
int index2;
int groupLen2;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,384);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 385;BA.debugLine="Try";
Debug.ShouldStop(1);
if (true) break;

case 1:
//try
this.state = 14;
this.catchState = 13;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 13;
 BA.debugLineNum = 386;BA.debugLine="For Each permission As String In Array(rpa.PERMI";
Debug.ShouldStop(2);
if (true) break;

case 4:
//for
this.state = 11;
group2 = RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(parent.mostCurrent._rpa.getField(true,"PERMISSION_READ_EXTERNAL_STORAGE")),(parent.mostCurrent._rpa.getField(true,"PERMISSION_WRITE_EXTERNAL_STORAGE"))});
index2 = 0;
groupLen2 = group2.getField(true,"length").<Integer>get();
Debug.locals.put("permission", _permission);
this.state = 15;
if (true) break;

case 15:
//C
this.state = 11;
if (index2 < groupLen2) {
this.state = 6;
_permission = BA.ObjectToString(group2.getArrayElement(false,RemoteObject.createImmutable(index2)));Debug.locals.put("permission", _permission);}
if (true) break;

case 16:
//C
this.state = 15;
index2++;
Debug.locals.put("permission", _permission);
if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 387;BA.debugLine="rpa.CheckAndRequest(permission)";
Debug.ShouldStop(4);
parent.mostCurrent._rpa.runVoidMethod ("CheckAndRequest",main.processBA,(Object)(_permission));
 BA.debugLineNum = 388;BA.debugLine="wait for Activity_PermissionResult (permission";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_resume"), null);
this.state = 17;
return;
case 17:
//C
this.state = 7;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("result", _result);
;
 BA.debugLineNum = 389;BA.debugLine="File.MakeDir(File.DirRootExternal,\"/Frigate\")";
Debug.ShouldStop(16);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("MakeDir",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("/Frigate")));
 BA.debugLineNum = 390;BA.debugLine="File.MakeDir(File.DirRootExternal,\"/Frigate/Dow";
Debug.ShouldStop(32);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("MakeDir",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("/Frigate/Download")));
 BA.debugLineNum = 391;BA.debugLine="File.MakeDir(File.DirRootExternal,\"/Frigate/Scr";
Debug.ShouldStop(64);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("MakeDir",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("/Frigate/ScreenShots")));
 BA.debugLineNum = 392;BA.debugLine="File.MakeDir(File.DirRootExternal,\"/Frigate/Log";
Debug.ShouldStop(128);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("MakeDir",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("/Frigate/Log")));
 BA.debugLineNum = 393;BA.debugLine="If result=False Then";
Debug.ShouldStop(256);
if (true) break;

case 7:
//if
this.state = 10;
if (RemoteObject.solveBoolean("=",_result,parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 395;BA.debugLine="Return";
Debug.ShouldStop(1024);
Debug.CheckDeviceExceptions();if (true) return ;
 if (true) break;

case 10:
//C
this.state = 16;
;
 if (true) break;
if (true) break;

case 11:
//C
this.state = 14;
Debug.locals.put("permission", _permission);
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
 BA.debugLineNum = 399;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","8196623",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 401;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
}
public static RemoteObject  _btn_appexit_click() throws Exception{
try {
		Debug.PushSubsStack("btn_appexit_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,729);
if (RapidSub.canDelegate("btn_appexit_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_appexit_click");}
 BA.debugLineNum = 729;BA.debugLine="Sub btn_appexit_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 740;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 742;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_applocksave_click() throws Exception{
try {
		Debug.PushSubsStack("btn_applocksave_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1211);
if (RapidSub.canDelegate("btn_applocksave_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_applocksave_click");}
 BA.debugLineNum = 1211;BA.debugLine="Sub btn_applocksave_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 1212;BA.debugLine="If TextBox_applock_password_set.Text=Textbox_rety";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main.mostCurrent._textbox_applock_password_set.runMethod(true,"getText"),main.mostCurrent._textbox_retype_passcodepleteedittext1.runMethod(true,"getText"))) { 
 BA.debugLineNum = 1213;BA.debugLine="If CheckBox_applock_enable.Checked=True Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main.mostCurrent._checkbox_applock_enable.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1214;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"pscode";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("pscode.txt")),(Object)(main.mostCurrent._textbox_applock_password_set.runMethod(true,"getText")));
 BA.debugLineNum = 1215;BA.debugLine="ToastMessageShow(\"Passcode Enabled\" & CRLF & CR";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Passcode Enabled"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("New Passcode : "),main.mostCurrent._textbox_applock_password_set.runMethod(true,"getText")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 1217;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"pscode";
Debug.ShouldStop(1);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("pscode.txt")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1218;BA.debugLine="ToastMessageShow(\"Passcode Disable\",True)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Passcode Disable")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 1220;BA.debugLine="Panel_applock_settings.Visible=False";
Debug.ShouldStop(8);
main.mostCurrent._panel_applock_settings.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1221;BA.debugLine="Button_applock.Visible=True";
Debug.ShouldStop(16);
main.mostCurrent._button_applock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1222;BA.debugLine="Button_history.Visible=True";
Debug.ShouldStop(32);
main.mostCurrent._button_history.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1223;BA.debugLine="btn_pannelsettings_reset.Visible=True";
Debug.ShouldStop(64);
main.mostCurrent._btn_pannelsettings_reset.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1224;BA.debugLine="btn_settingspanel_okandhide.Visible=True";
Debug.ShouldStop(128);
main.mostCurrent._btn_settingspanel_okandhide.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 1226;BA.debugLine="ToastMessageShow(\"Please check Passcode !\",True)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please check Passcode !")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 1229;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_appsettingsmore_click() throws Exception{
try {
		Debug.PushSubsStack("btn_appsettingsmore_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,763);
if (RapidSub.canDelegate("btn_appsettingsmore_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_appsettingsmore_click");}
 BA.debugLineNum = 763;BA.debugLine="Sub btn_appsettingsmore_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 764;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(134217728);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 765;BA.debugLine="ToggleButton_drawer.Checked=True";
Debug.ShouldStop(268435456);
main.mostCurrent._togglebutton_drawer.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 766;BA.debugLine="Panel_Main_Settings.BringToFront";
Debug.ShouldStop(536870912);
main.mostCurrent._panel_main_settings.runVoidMethod ("BringToFront");
 BA.debugLineNum = 767;BA.debugLine="Panel_Main_Settings.Visible=True";
Debug.ShouldStop(1073741824);
main.mostCurrent._panel_main_settings.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 768;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_back_click() throws Exception{
try {
		Debug.PushSubsStack("btn_back_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,465);
if (RapidSub.canDelegate("btn_back_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_back_click");}
 BA.debugLineNum = 465;BA.debugLine="Sub btn_back_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 466;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(131072);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 467;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(262144);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 468;BA.debugLine="main_webview.Back";
Debug.ShouldStop(524288);
main.mostCurrent._main_webview.runVoidMethod ("Back");
 BA.debugLineNum = 469;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_batterysaver_click() throws Exception{
try {
		Debug.PushSubsStack("btn_batterysaver_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,505);
if (RapidSub.canDelegate("btn_batterysaver_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_batterysaver_click");}
 BA.debugLineNum = 505;BA.debugLine="Sub btn_batterysaver_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 506;BA.debugLine="If ToggleButton_bttrysave.Checked=True Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",main.mostCurrent._togglebutton_bttrysave.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 508;BA.debugLine="ToggleButton_bttrysave.Checked=False";
Debug.ShouldStop(134217728);
main.mostCurrent._togglebutton_bttrysave.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 509;BA.debugLine="btn_readingfullscreenmode.Enabled=False";
Debug.ShouldStop(268435456);
main.mostCurrent._btn_readingfullscreenmode.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 510;BA.debugLine="btn_screenshot.Enabled=False";
Debug.ShouldStop(536870912);
main.mostCurrent._btn_screenshot.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 511;BA.debugLine="btn_downloadbooster_panel.Enabled=False";
Debug.ShouldStop(1073741824);
main.mostCurrent._btn_downloadbooster_panel.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 515;BA.debugLine="btn_batterysaver.TextColor=Colors.RGB(221,74,113";
Debug.ShouldStop(4);
main.mostCurrent._btn_batterysaver.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 221)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 113))));
 BA.debugLineNum = 517;BA.debugLine="ToastMessageShow(\"Disable : Reading Mode | Scree";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Disable : Reading Mode | Screenshot | Download Booster Service "),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Application Animations Disable"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Battry Save TurnON")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 521;BA.debugLine="btn_batterysaver.TextColor=Colors.RGB(85,85,85)";
Debug.ShouldStop(256);
main.mostCurrent._btn_batterysaver.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 522;BA.debugLine="btn_downloadbooster_panel.Enabled=True";
Debug.ShouldStop(512);
main.mostCurrent._btn_downloadbooster_panel.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 523;BA.debugLine="ToggleButton_bttrysave.Checked=True";
Debug.ShouldStop(1024);
main.mostCurrent._togglebutton_bttrysave.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 524;BA.debugLine="btn_readingfullscreenmode.Enabled=True";
Debug.ShouldStop(2048);
main.mostCurrent._btn_readingfullscreenmode.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 525;BA.debugLine="btn_screenshot.Enabled=True";
Debug.ShouldStop(4096);
main.mostCurrent._btn_screenshot.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 526;BA.debugLine="ToastMessageShow(\"All disable services : Enable\"";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("All disable services : Enable"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Battry Save TurnOFF")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 529;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_clearalldataapp_click() throws Exception{
try {
		Debug.PushSubsStack("btn_clearalldataapp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,743);
if (RapidSub.canDelegate("btn_clearalldataapp_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_clearalldataapp_click");}
 BA.debugLineNum = 743;BA.debugLine="Sub btn_clearalldataapp_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 744;BA.debugLine="If ToggleButtonIncog.Checked=True Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",main.mostCurrent._togglebuttonincog.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 745;BA.debugLine="btn_clearalldataapp.TextColor=Colors.RGB(221,74,";
Debug.ShouldStop(256);
main.mostCurrent._btn_clearalldataapp.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 221)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 113))));
 BA.debugLineNum = 746;BA.debugLine="ToggleButtonIncog.Checked=False";
Debug.ShouldStop(512);
main.mostCurrent._togglebuttonincog.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 747;BA.debugLine="WebViewExtender.clearCache(main_webview,True)";
Debug.ShouldStop(1024);
main.mostCurrent._webviewextender.runVoidMethod ("clearCache",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 748;BA.debugLine="WebViewExtender.clearFocus(main_webview)";
Debug.ShouldStop(2048);
main.mostCurrent._webviewextender.runVoidMethod ("clearFocus",(Object)((main.mostCurrent._main_webview.getObject())));
 BA.debugLineNum = 749;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Fals";
Debug.ShouldStop(4096);
main.mostCurrent._webviewsettings.runVoidMethod ("setSaveFormData",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 750;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Fals";
Debug.ShouldStop(8192);
main.mostCurrent._webviewsettings.runVoidMethod ("setSavePassword",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 753;BA.debugLine="btn_clearalldataapp.TextColor=Colors.RGB(85,85,8";
Debug.ShouldStop(65536);
main.mostCurrent._btn_clearalldataapp.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 754;BA.debugLine="ToggleButtonIncog.Checked=True";
Debug.ShouldStop(131072);
main.mostCurrent._togglebuttonincog.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 755;BA.debugLine="WebViewExtender.clearCache(main_webview,False)";
Debug.ShouldStop(262144);
main.mostCurrent._webviewextender.runVoidMethod ("clearCache",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 756;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Tru";
Debug.ShouldStop(524288);
main.mostCurrent._webviewsettings.runVoidMethod ("setSaveFormData",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 757;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Tru";
Debug.ShouldStop(1048576);
main.mostCurrent._webviewsettings.runVoidMethod ("setSavePassword",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 762;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_clearhistory_click() throws Exception{
try {
		Debug.PushSubsStack("btn_clearHistory_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1179);
if (RapidSub.canDelegate("btn_clearhistory_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_clearhistory_click");}
 BA.debugLineNum = 1179;BA.debugLine="Sub btn_clearHistory_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 1180;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 1181;BA.debugLine="If Msgbox2(\"Permanent Delete History\"& CRLF & CR";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Permanent Delete History"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Are you Sure ?")))),(Object)(BA.ObjectToCharSequence("READ CAREFULLY")),(Object)(BA.ObjectToString("Clear Now")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA),BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 1182;BA.debugLine="ListView_Settings_hostory.Clear";
Debug.ShouldStop(536870912);
main.mostCurrent._listview_settings_hostory.runVoidMethod ("Clear");
 BA.debugLineNum = 1183;BA.debugLine="File.WriteList(File.DirDefaultExternal,\"history.";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("history.txt")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), main.mostCurrent._listview_settings_hostory.getObject()));
 }else {
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 1187;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("LogImpl","84456456",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 1190;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_darkmode_click() throws Exception{
try {
		Debug.PushSubsStack("btn_darkmode_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,648);
if (RapidSub.canDelegate("btn_darkmode_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_darkmode_click");}
 BA.debugLineNum = 648;BA.debugLine="Sub btn_darkmode_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 649;BA.debugLine="If ToggleButtonNightmode.Checked=True Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",main.mostCurrent._togglebuttonnightmode.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 650;BA.debugLine="Panel_Downloader.Color=Colors.RGB(18,18,18)";
Debug.ShouldStop(512);
main.mostCurrent._panel_downloader.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18))));
 BA.debugLineNum = 651;BA.debugLine="Panel_Drawer.Color=Colors.RGB(18,18,18)";
Debug.ShouldStop(1024);
main.mostCurrent._panel_drawer.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18))));
 BA.debugLineNum = 652;BA.debugLine="Panel_Intergration.Color=Colors.RGB(18,18,18)";
Debug.ShouldStop(2048);
main.mostCurrent._panel_intergration.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18))));
 BA.debugLineNum = 653;BA.debugLine="Panel_Navigation_Bar.Color=Colors.RGB(18,18,18)";
Debug.ShouldStop(4096);
main.mostCurrent._panel_navigation_bar.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18))));
 BA.debugLineNum = 654;BA.debugLine="Panel_Search_Bar.Color=Colors.RGB(18,18,18)";
Debug.ShouldStop(8192);
main.mostCurrent._panel_search_bar.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18))));
 BA.debugLineNum = 655;BA.debugLine="main_webview.Color=Colors.Black";
Debug.ShouldStop(16384);
main.mostCurrent._main_webview.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 656;BA.debugLine="Panel_WebView_ReadingFullScreen_Mode.Color=Color";
Debug.ShouldStop(32768);
main.mostCurrent._panel_webview_readingfullscreen_mode.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 18))));
 BA.debugLineNum = 657;BA.debugLine="WebView_ReadingFullScreen_Mode.Color=Colors.Blac";
Debug.ShouldStop(65536);
main.mostCurrent._webview_readingfullscreen_mode.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 658;BA.debugLine="ToggleButtonNightmode.Checked=False";
Debug.ShouldStop(131072);
main.mostCurrent._togglebuttonnightmode.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 659;BA.debugLine="btn_back.TextColor=Colors.White";
Debug.ShouldStop(262144);
main.mostCurrent._btn_back.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 660;BA.debugLine="btn_fowrd.TextColor=Colors.White";
Debug.ShouldStop(524288);
main.mostCurrent._btn_fowrd.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 661;BA.debugLine="btn_home.TextColor=Colors.White";
Debug.ShouldStop(1048576);
main.mostCurrent._btn_home.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 662;BA.debugLine="btn_drawer.TextColor=Colors.White";
Debug.ShouldStop(2097152);
main.mostCurrent._btn_drawer.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 663;BA.debugLine="textbox_search_bar.TextColor=Colors.White";
Debug.ShouldStop(4194304);
main.mostCurrent._textbox_search_bar.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 664;BA.debugLine="textbox_search_bar.HintColor=Colors.White";
Debug.ShouldStop(8388608);
main.mostCurrent._textbox_search_bar.runMethod(true,"setHintColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 666;BA.debugLine="btn_darkmode.TextColor=Colors.RGB(221,74,113)";
Debug.ShouldStop(33554432);
main.mostCurrent._btn_darkmode.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 221)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 113))));
 }else {
 BA.debugLineNum = 671;BA.debugLine="ToggleButtonNightmode.Checked=True";
Debug.ShouldStop(1073741824);
main.mostCurrent._togglebuttonnightmode.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 672;BA.debugLine="Panel_Downloader.Color=Colors.White";
Debug.ShouldStop(-2147483648);
main.mostCurrent._panel_downloader.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 673;BA.debugLine="Panel_Drawer.Color=Colors.White";
Debug.ShouldStop(1);
main.mostCurrent._panel_drawer.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 674;BA.debugLine="Panel_Intergration.Color=Colors.White";
Debug.ShouldStop(2);
main.mostCurrent._panel_intergration.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 675;BA.debugLine="Panel_Navigation_Bar.Color=Colors.White";
Debug.ShouldStop(4);
main.mostCurrent._panel_navigation_bar.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 676;BA.debugLine="Panel_Search_Bar.Color=Colors.White";
Debug.ShouldStop(8);
main.mostCurrent._panel_search_bar.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 677;BA.debugLine="main_webview.Color=Colors.White";
Debug.ShouldStop(16);
main.mostCurrent._main_webview.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 678;BA.debugLine="Panel_WebView_ReadingFullScreen_Mode.Color=Color";
Debug.ShouldStop(32);
main.mostCurrent._panel_webview_readingfullscreen_mode.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 679;BA.debugLine="WebView_ReadingFullScreen_Mode.Color=Colors.Whit";
Debug.ShouldStop(64);
main.mostCurrent._webview_readingfullscreen_mode.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 681;BA.debugLine="btn_back.TextColor=Colors.RGB(85,85,85)";
Debug.ShouldStop(256);
main.mostCurrent._btn_back.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 682;BA.debugLine="btn_fowrd.TextColor=Colors.RGB(85,85,85)";
Debug.ShouldStop(512);
main.mostCurrent._btn_fowrd.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 683;BA.debugLine="btn_home.TextColor=Colors.RGB(85,85,85)";
Debug.ShouldStop(1024);
main.mostCurrent._btn_home.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 684;BA.debugLine="btn_drawer.TextColor=Colors.RGB(85,85,85)";
Debug.ShouldStop(2048);
main.mostCurrent._btn_drawer.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 685;BA.debugLine="btn_darkmode.TextColor=Colors.RGB(85,85,85)";
Debug.ShouldStop(4096);
main.mostCurrent._btn_darkmode.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 686;BA.debugLine="textbox_search_bar.TextColor=Colors.RGB(85,85,85";
Debug.ShouldStop(8192);
main.mostCurrent._textbox_search_bar.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 687;BA.debugLine="textbox_search_bar.HintColor=Colors.RGB(85,85,85";
Debug.ShouldStop(16384);
main.mostCurrent._textbox_search_bar.runMethod(true,"setHintColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 };
 BA.debugLineNum = 689;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_downloadbooster_panel_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("btn_downloadbooster_panel_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,885);
if (RapidSub.canDelegate("btn_downloadbooster_panel_checkedchange")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_downloadbooster_panel_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 885;BA.debugLine="Sub btn_downloadbooster_panel_CheckedChange(Checke";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 886;BA.debugLine="If btn_downloadbooster_panel.Checked=True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main.mostCurrent._btn_downloadbooster_panel.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 887;BA.debugLine="ToastMessageShow(\"Download Booster - Network Boo";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Download Booster - Network Booster Enabled")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 889;BA.debugLine="ToastMessageShow(\"Download Booster - Network Boo";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Download Booster - Network Booster Disable")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 891;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_downloader_click() throws Exception{
try {
		Debug.PushSubsStack("btn_downloader_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,641);
if (RapidSub.canDelegate("btn_downloader_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_downloader_click");}
 BA.debugLineNum = 641;BA.debugLine="Sub btn_downloader_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 642;BA.debugLine="Panel_Downloader.BringToFront";
Debug.ShouldStop(2);
main.mostCurrent._panel_downloader.runVoidMethod ("BringToFront");
 BA.debugLineNum = 643;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(4);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 644;BA.debugLine="Panel_Downloader.Visible=True";
Debug.ShouldStop(8);
main.mostCurrent._panel_downloader.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 645;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(16);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 646;BA.debugLine="ToggleButton_drawer.Checked=True";
Debug.ShouldStop(32);
main.mostCurrent._togglebutton_drawer.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 647;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_downloader_longclick() throws Exception{
try {
		Debug.PushSubsStack("btn_downloader_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,895);
if (RapidSub.canDelegate("btn_downloader_longclick")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_downloader_longclick");}
 BA.debugLineNum = 895;BA.debugLine="Sub btn_downloader_LongClick";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 898;BA.debugLine="If main_webview.Url.StartsWith(\"file:///\") Then";
Debug.ShouldStop(2);
if (main.mostCurrent._main_webview.runMethod(true,"getUrl").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("file:///"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 899;BA.debugLine="ToastMessageShow(\"Cant Save / Download this URL!";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Cant Save / Download this URL!")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 901;BA.debugLine="textbox_download_url.Text=main_webview.Url";
Debug.ShouldStop(16);
main.mostCurrent._textbox_download_url.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._main_webview.runMethod(true,"getUrl")));
 BA.debugLineNum = 902;BA.debugLine="textbox_download_filename.Text=WebViewExtender.g";
Debug.ShouldStop(32);
main.mostCurrent._textbox_download_filename.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._webviewextender.runMethod(true,"getTitle",(Object)((main.mostCurrent._main_webview.getObject()))),RemoteObject.createImmutable(".html"))));
 BA.debugLineNum = 903;BA.debugLine="Panel_Downloader.BringToFront";
Debug.ShouldStop(64);
main.mostCurrent._panel_downloader.runVoidMethod ("BringToFront");
 BA.debugLineNum = 904;BA.debugLine="Panel_Downloader.Visible=True";
Debug.ShouldStop(128);
main.mostCurrent._panel_downloader.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 905;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(256);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 908;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_drawer_click() throws Exception{
try {
		Debug.PushSubsStack("btn_drawer_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,453);
if (RapidSub.canDelegate("btn_drawer_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_drawer_click");}
 BA.debugLineNum = 453;BA.debugLine="Sub btn_drawer_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 454;BA.debugLine="If ToggleButton_drawer.Checked=True Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",main.mostCurrent._togglebutton_drawer.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 455;BA.debugLine="ToggleButton_drawer.Checked=False";
Debug.ShouldStop(64);
main.mostCurrent._togglebutton_drawer.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 456;BA.debugLine="Panel_Drawer.BringToFront";
Debug.ShouldStop(128);
main.mostCurrent._panel_drawer.runVoidMethod ("BringToFront");
 BA.debugLineNum = 457;BA.debugLine="Panel_Drawer.Visible=True";
Debug.ShouldStop(256);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 458;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(512);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 459;BA.debugLine="Panel_Downloader.Visible=False";
Debug.ShouldStop(1024);
main.mostCurrent._panel_downloader.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 461;BA.debugLine="ToggleButton_drawer.Checked=True";
Debug.ShouldStop(4096);
main.mostCurrent._togglebutton_drawer.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 462;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(8192);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 464;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_extrasites_click() throws Exception{
try {
		Debug.PushSubsStack("btn_extrasites_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,860);
if (RapidSub.canDelegate("btn_extrasites_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_extrasites_click");}
 BA.debugLineNum = 860;BA.debugLine="Sub btn_extrasites_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 861;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/index";
Debug.ShouldStop(268435456);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/index.html")));
 BA.debugLineNum = 862;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(536870912);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 863;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_fb_click() throws Exception{
try {
		Debug.PushSubsStack("btn_fb_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,803);
if (RapidSub.canDelegate("btn_fb_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_fb_click");}
 BA.debugLineNum = 803;BA.debugLine="Sub btn_fb_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 804;BA.debugLine="main_webview.LoadUrl(\"https://m.facebook.com\")";
Debug.ShouldStop(8);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://m.facebook.com")));
 BA.debugLineNum = 805;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(16);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 806;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 807;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(64);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 808;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_fowrd_click() throws Exception{
try {
		Debug.PushSubsStack("btn_fowrd_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,470);
if (RapidSub.canDelegate("btn_fowrd_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_fowrd_click");}
 BA.debugLineNum = 470;BA.debugLine="Sub btn_fowrd_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 471;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(4194304);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 472;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(8388608);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 473;BA.debugLine="main_webview.Forward";
Debug.ShouldStop(16777216);
main.mostCurrent._main_webview.runVoidMethod ("Forward");
 BA.debugLineNum = 474;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_fullscreen_back_click() throws Exception{
try {
		Debug.PushSubsStack("btn_fullscreen_back_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,975);
if (RapidSub.canDelegate("btn_fullscreen_back_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_fullscreen_back_click");}
 BA.debugLineNum = 975;BA.debugLine="Sub btn_fullscreen_back_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 976;BA.debugLine="WebView_ReadingFullScreen_Mode.Back";
Debug.ShouldStop(32768);
main.mostCurrent._webview_readingfullscreen_mode.runVoidMethod ("Back");
 BA.debugLineNum = 977;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_fullscreen_fowrd_click() throws Exception{
try {
		Debug.PushSubsStack("btn_fullscreen_fowrd_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,978);
if (RapidSub.canDelegate("btn_fullscreen_fowrd_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_fullscreen_fowrd_click");}
 BA.debugLineNum = 978;BA.debugLine="Sub btn_fullscreen_fowrd_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 979;BA.debugLine="WebView_ReadingFullScreen_Mode.Forward";
Debug.ShouldStop(262144);
main.mostCurrent._webview_readingfullscreen_mode.runVoidMethod ("Forward");
 BA.debugLineNum = 980;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_fullscreenreadingmode_exit_click() throws Exception{
try {
		Debug.PushSubsStack("btn_fullscreenreadingmode_exit_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,981);
if (RapidSub.canDelegate("btn_fullscreenreadingmode_exit_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_fullscreenreadingmode_exit_click");}
 BA.debugLineNum = 981;BA.debugLine="Sub btn_fullscreenreadingmode_exit_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 982;BA.debugLine="Panel_WebView_ReadingFullScreen_Mode.Visible=Fals";
Debug.ShouldStop(2097152);
main.mostCurrent._panel_webview_readingfullscreen_mode.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 983;BA.debugLine="main_webview.LoadUrl(WebView_ReadingFullScreen_Mo";
Debug.ShouldStop(4194304);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(main.mostCurrent._webview_readingfullscreen_mode.runMethod(true,"getUrl")));
 BA.debugLineNum = 984;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_helpguide_click() throws Exception{
try {
		Debug.PushSubsStack("btn_helpguide_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,769);
if (RapidSub.canDelegate("btn_helpguide_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_helpguide_click");}
RemoteObject _feedback = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.Email");
 BA.debugLineNum = 769;BA.debugLine="Sub btn_helpguide_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 770;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(2);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 771;BA.debugLine="ToggleButton_drawer.Checked=True";
Debug.ShouldStop(4);
main.mostCurrent._togglebutton_drawer.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 772;BA.debugLine="Try";
Debug.ShouldStop(8);
try { BA.debugLineNum = 773;BA.debugLine="Dim feedback As Email";
Debug.ShouldStop(16);
_feedback = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");Debug.locals.put("feedback", _feedback);
 BA.debugLineNum = 774;BA.debugLine="feedback.To.Add(\"contact.clenontec@gmail.com\")";
Debug.ShouldStop(32);
_feedback.getField(false,"To").runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("contact.clenontec@gmail.com"))));
 BA.debugLineNum = 775;BA.debugLine="feedback.Subject=\"Help and Feedback - Frigate Su";
Debug.ShouldStop(64);
_feedback.setField ("Subject",BA.ObjectToString("Help and Feedback - Frigate Suffering Browser"));
 BA.debugLineNum = 776;BA.debugLine="StartActivity(feedback.GetIntent)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_feedback.runMethod(false,"GetIntent"))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e9.toString()); BA.debugLineNum = 778;BA.debugLine="Log(LastException)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","81900553",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 BA.debugLineNum = 779;BA.debugLine="ToastMessageShow(\"Help and Feedback Fail !\",True";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Help and Feedback Fail !")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 781;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_helpguide_longclick() throws Exception{
try {
		Debug.PushSubsStack("btn_helpguide_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,545);
if (RapidSub.canDelegate("btn_helpguide_longclick")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_helpguide_longclick");}
 BA.debugLineNum = 545;BA.debugLine="Sub btn_helpguide_LongClick";
Debug.ShouldStop(1);
 BA.debugLineNum = 546;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/welco";
Debug.ShouldStop(2);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/welcome.html")));
 BA.debugLineNum = 547;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_hidedownloadpanel_click() throws Exception{
try {
		Debug.PushSubsStack("btn_hidedownloadpanel_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,892);
if (RapidSub.canDelegate("btn_hidedownloadpanel_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_hidedownloadpanel_click");}
 BA.debugLineNum = 892;BA.debugLine="Sub btn_hidedownloadpanel_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 893;BA.debugLine="Panel_Downloader.Visible=False";
Debug.ShouldStop(268435456);
main.mostCurrent._panel_downloader.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 894;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_history_hide_click() throws Exception{
try {
		Debug.PushSubsStack("btn_history_hide_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1157);
if (RapidSub.canDelegate("btn_history_hide_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_history_hide_click");}
 BA.debugLineNum = 1157;BA.debugLine="Sub btn_history_hide_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 1158;BA.debugLine="Panel_Settings_History.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._panel_settings_history.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1159;BA.debugLine="Button_applock.Visible=True";
Debug.ShouldStop(64);
main.mostCurrent._button_applock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1160;BA.debugLine="Button_history.Visible=True";
Debug.ShouldStop(128);
main.mostCurrent._button_history.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1161;BA.debugLine="btn_pannelsettings_reset.Visible=True";
Debug.ShouldStop(256);
main.mostCurrent._btn_pannelsettings_reset.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1162;BA.debugLine="btn_settingspanel_okandhide.Visible=True";
Debug.ShouldStop(512);
main.mostCurrent._btn_settingspanel_okandhide.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1163;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_home_click() throws Exception{
try {
		Debug.PushSubsStack("btn_home_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,475);
if (RapidSub.canDelegate("btn_home_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_home_click");}
 BA.debugLineNum = 475;BA.debugLine="Sub btn_home_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 476;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 477;BA.debugLine="If RadioButton_google.Checked=True Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_google.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 478;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/googl";
Debug.ShouldStop(536870912);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/google.html")));
 };
 BA.debugLineNum = 480;BA.debugLine="If RadioButton_duck.Checked=True Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_duck.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 481;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/duck.";
Debug.ShouldStop(1);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/duck.html")));
 };
 BA.debugLineNum = 483;BA.debugLine="If RadioButton_bing.Checked=True Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_bing.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 484;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/bing.";
Debug.ShouldStop(8);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/bing.html")));
 };
 BA.debugLineNum = 486;BA.debugLine="If RadioButton_yahoo.Checked=True Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_yahoo.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 487;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/yahoo";
Debug.ShouldStop(64);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/yahoo.html")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e15) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e15.toString()); BA.debugLineNum = 490;BA.debugLine="Log(LastException)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","8720911",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 BA.debugLineNum = 491;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/googl";
Debug.ShouldStop(1024);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("file:///android_asset/google.html")));
 };
 BA.debugLineNum = 493;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_imagedisable_click() throws Exception{
try {
		Debug.PushSubsStack("btn_imagedisable_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,590);
if (RapidSub.canDelegate("btn_imagedisable_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_imagedisable_click");}
 BA.debugLineNum = 590;BA.debugLine="Sub btn_imagedisable_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 591;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(16384);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 592;BA.debugLine="ToggleButton_drawer.Checked=True";
Debug.ShouldStop(32768);
main.mostCurrent._togglebutton_drawer.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 594;BA.debugLine="If ToggleButton_imagedisable.Checked = True Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",main.mostCurrent._togglebutton_imagedisable.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 595;BA.debugLine="WebViewExtender.setLoadsImagesAutomatically(main";
Debug.ShouldStop(262144);
main.mostCurrent._webviewextender.runVoidMethod ("setLoadsImagesAutomatically",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 596;BA.debugLine="ToggleButton_imagedisable.Checked = False";
Debug.ShouldStop(524288);
main.mostCurrent._togglebutton_imagedisable.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 597;BA.debugLine="btn_imagedisable.TextColor = Colors.RGB(221,74,1";
Debug.ShouldStop(1048576);
main.mostCurrent._btn_imagedisable.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 221)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 113))));
 BA.debugLineNum = 598;BA.debugLine="ToastMessageShow(\"Block Images : DATA Save Enabl";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Block Images : DATA Save Enable")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 600;BA.debugLine="WebViewExtender.setLoadsImagesAutomatically(main";
Debug.ShouldStop(8388608);
main.mostCurrent._webviewextender.runVoidMethod ("setLoadsImagesAutomatically",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 601;BA.debugLine="ToggleButton_imagedisable.Checked = True";
Debug.ShouldStop(16777216);
main.mostCurrent._togglebutton_imagedisable.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 602;BA.debugLine="btn_imagedisable.TextColor = Colors.RGB(85,85,85";
Debug.ShouldStop(33554432);
main.mostCurrent._btn_imagedisable.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 603;BA.debugLine="ToastMessageShow(\"Show Images : DATA Save Disabl";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Show Images : DATA Save Disable")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 605;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_instr_click() throws Exception{
try {
		Debug.PushSubsStack("btn_instr_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,784);
if (RapidSub.canDelegate("btn_instr_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_instr_click");}
 BA.debugLineNum = 784;BA.debugLine="Sub btn_instr_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 785;BA.debugLine="main_webview.LoadUrl(\"https://www.instagram.com\")";
Debug.ShouldStop(65536);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://www.instagram.com")));
 BA.debugLineNum = 786;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(131072);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 787;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(262144);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 788;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(524288);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 789;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_intergrton_click() throws Exception{
try {
		Debug.PushSubsStack("btn_intergrton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,499);
if (RapidSub.canDelegate("btn_intergrton_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_intergrton_click");}
 BA.debugLineNum = 499;BA.debugLine="Sub btn_intergrton_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 500;BA.debugLine="Panel_Intergration.BringToFront";
Debug.ShouldStop(524288);
main.mostCurrent._panel_intergration.runVoidMethod ("BringToFront");
 BA.debugLineNum = 501;BA.debugLine="Panel_Intergration.Visible=True";
Debug.ShouldStop(1048576);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 502;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(2097152);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 503;BA.debugLine="ToggleButton_drawer.Checked=True";
Debug.ShouldStop(4194304);
main.mostCurrent._togglebutton_drawer.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 504;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_jsdisable_click() throws Exception{
try {
		Debug.PushSubsStack("btn_jsdisable_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,531);
if (RapidSub.canDelegate("btn_jsdisable_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_jsdisable_click");}
 BA.debugLineNum = 531;BA.debugLine="Sub btn_jsdisable_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 532;BA.debugLine="If ToggleButton_js.Checked=True Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",main.mostCurrent._togglebutton_js.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 533;BA.debugLine="main_webview.JavaScriptEnabled=False";
Debug.ShouldStop(1048576);
main.mostCurrent._main_webview.runMethod(true,"setJavaScriptEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 534;BA.debugLine="WebViewExtender.setJavaScriptEnabled(main_webvie";
Debug.ShouldStop(2097152);
main.mostCurrent._webviewextender.runVoidMethod ("setJavaScriptEnabled",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 535;BA.debugLine="ToggleButton_js.Checked=False";
Debug.ShouldStop(4194304);
main.mostCurrent._togglebutton_js.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 536;BA.debugLine="ToastMessageShow(\"Little Ad Blocker  : Enable (";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Little Ad Blocker  : Enable ( Classic Interface Enable )")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 538;BA.debugLine="main_webview.JavaScriptEnabled=True";
Debug.ShouldStop(33554432);
main.mostCurrent._main_webview.runMethod(true,"setJavaScriptEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 539;BA.debugLine="WebViewExtender.setJavaScriptEnabled(main_webvie";
Debug.ShouldStop(67108864);
main.mostCurrent._webviewextender.runVoidMethod ("setJavaScriptEnabled",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 540;BA.debugLine="ToggleButton_js.Checked=True";
Debug.ShouldStop(134217728);
main.mostCurrent._togglebutton_js.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 541;BA.debugLine="ToastMessageShow(\"Little Ad Blocker : Disable (";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Little Ad Blocker : Disable ( Classic Interface Disable )")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 544;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_lnkdin_click() throws Exception{
try {
		Debug.PushSubsStack("btn_lnkdin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,809);
if (RapidSub.canDelegate("btn_lnkdin_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_lnkdin_click");}
 BA.debugLineNum = 809;BA.debugLine="Sub btn_lnkdin_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 810;BA.debugLine="main_webview.LoadUrl(\"https://www.linkedin.com\")";
Debug.ShouldStop(512);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://www.linkedin.com")));
 BA.debugLineNum = 811;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(1024);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 812;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(2048);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 813;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(4096);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 814;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_openweblinkanotherbrowser_click() throws Exception{
try {
		Debug.PushSubsStack("btn_openweblinkanotherbrowser_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,606);
if (RapidSub.canDelegate("btn_openweblinkanotherbrowser_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_openweblinkanotherbrowser_click");}
RemoteObject _openurlsharei = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 606;BA.debugLine="Sub btn_openweblinkanotherbrowser_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 608;BA.debugLine="If main_webview.Url.StartsWith(\"file:///\") Then";
Debug.ShouldStop(-2147483648);
if (main.mostCurrent._main_webview.runMethod(true,"getUrl").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("file:///"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 609;BA.debugLine="ToastMessageShow(\"Can't open URL\",True)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Can't open URL")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 611;BA.debugLine="Try";
Debug.ShouldStop(4);
try { BA.debugLineNum = 612;BA.debugLine="Private openurlsharei As Intent";
Debug.ShouldStop(8);
_openurlsharei = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("openurlsharei", _openurlsharei);
 BA.debugLineNum = 613;BA.debugLine="openurlsharei.Initialize(openurlsharei.ACTION_V";
Debug.ShouldStop(16);
_openurlsharei.runVoidMethod ("Initialize",(Object)(_openurlsharei.getField(true,"ACTION_VIEW")),(Object)(main.mostCurrent._main_webview.runMethod(true,"getUrl")));
 BA.debugLineNum = 614;BA.debugLine="StartActivity(openurlsharei)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_openurlsharei.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e9.toString()); BA.debugLineNum = 616;BA.debugLine="Log(LastException)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("LogImpl","81245194",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 };
 BA.debugLineNum = 620;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_panel_intergration_hide_click() throws Exception{
try {
		Debug.PushSubsStack("btn_panel_intergration_hide_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,857);
if (RapidSub.canDelegate("btn_panel_intergration_hide_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_panel_intergration_hide_click");}
 BA.debugLineNum = 857;BA.debugLine="Sub btn_panel_intergration_hide_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 858;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(33554432);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 859;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_pannelsettings_reset_click() throws Exception{
try {
		Debug.PushSubsStack("btn_pannelsettings_reset_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1041);
if (RapidSub.canDelegate("btn_pannelsettings_reset_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_pannelsettings_reset_click");}
RemoteObject _clcc = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
 BA.debugLineNum = 1041;BA.debugLine="Sub btn_pannelsettings_reset_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 1044;BA.debugLine="If Msgbox2(\"ITEMS : Cache, History\"& CRLF & CRLF";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("ITEMS : Cache, History"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Are you Sure ?")))),(Object)(BA.ObjectToCharSequence("READ CAREFULLY")),(Object)(BA.ObjectToString("Clear Now")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA),BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 1045;BA.debugLine="WebViewExtender.clearCache(main_webview,True)";
Debug.ShouldStop(1048576);
main.mostCurrent._webviewextender.runVoidMethod ("clearCache",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 1046;BA.debugLine="WebViewExtender.clearCache(WebView_ReadingFullSc";
Debug.ShouldStop(2097152);
main.mostCurrent._webviewextender.runVoidMethod ("clearCache",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 1047;BA.debugLine="WebViewExtender.clearFocus(main_webview)";
Debug.ShouldStop(4194304);
main.mostCurrent._webviewextender.runVoidMethod ("clearFocus",(Object)((main.mostCurrent._main_webview.getObject())));
 BA.debugLineNum = 1048;BA.debugLine="WebViewExtender.clearFocus(WebView_ReadingFullSc";
Debug.ShouldStop(8388608);
main.mostCurrent._webviewextender.runVoidMethod ("clearFocus",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())));
 BA.debugLineNum = 1049;BA.debugLine="ListView_Settings_hostory.Clear";
Debug.ShouldStop(16777216);
main.mostCurrent._listview_settings_hostory.runVoidMethod ("Clear");
 BA.debugLineNum = 1050;BA.debugLine="RadioButton_google.Checked=True";
Debug.ShouldStop(33554432);
main.mostCurrent._radiobutton_google.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1051;BA.debugLine="CheckBox_js.Checked=True";
Debug.ShouldStop(67108864);
main.mostCurrent._checkbox_js.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1052;BA.debugLine="CheckBox_cookie.Checked=True";
Debug.ShouldStop(134217728);
main.mostCurrent._checkbox_cookie.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1053;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 1054;BA.debugLine="Dim clcc As Reflector";
Debug.ShouldStop(536870912);
_clcc = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("clcc", _clcc);
 BA.debugLineNum = 1055;BA.debugLine="clcc.Target=main_webview";
Debug.ShouldStop(1073741824);
_clcc.setField ("Target",(main.mostCurrent._main_webview.getObject()));
 BA.debugLineNum = 1056;BA.debugLine="clcc.RunMethod2(\"clearCache\",\"False\",\"java.lang.";
Debug.ShouldStop(-2147483648);
_clcc.runVoidMethod ("RunMethod2",(Object)(BA.ObjectToString("clearCache")),(Object)(BA.ObjectToString("False")),(Object)(RemoteObject.createImmutable("java.lang.boolean")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e15) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e15.toString()); BA.debugLineNum = 1058;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("LogImpl","84063249",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 }else {
 BA.debugLineNum = 1062;BA.debugLine="RadioButton_google.Checked=True";
Debug.ShouldStop(32);
main.mostCurrent._radiobutton_google.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1063;BA.debugLine="CheckBox_js.Checked=True";
Debug.ShouldStop(64);
main.mostCurrent._checkbox_js.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1064;BA.debugLine="CheckBox_cookie.Checked=True";
Debug.ShouldStop(128);
main.mostCurrent._checkbox_cookie.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 1066;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_password_panelhide_click() throws Exception{
try {
		Debug.PushSubsStack("btn_password_panelHide_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1231);
if (RapidSub.canDelegate("btn_password_panelhide_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_password_panelhide_click");}
 BA.debugLineNum = 1231;BA.debugLine="Sub btn_password_panelHide_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 1232;BA.debugLine="Panel_applock_settings.Visible=False";
Debug.ShouldStop(32768);
main.mostCurrent._panel_applock_settings.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1233;BA.debugLine="Button_applock.Visible=True";
Debug.ShouldStop(65536);
main.mostCurrent._button_applock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1234;BA.debugLine="Button_history.Visible=True";
Debug.ShouldStop(131072);
main.mostCurrent._button_history.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1235;BA.debugLine="btn_pannelsettings_reset.Visible=True";
Debug.ShouldStop(262144);
main.mostCurrent._btn_pannelsettings_reset.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1236;BA.debugLine="btn_settingspanel_okandhide.Visible=True";
Debug.ShouldStop(524288);
main.mostCurrent._btn_settingspanel_okandhide.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1237;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_pintrst_click() throws Exception{
try {
		Debug.PushSubsStack("btn_pintrst_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,821);
if (RapidSub.canDelegate("btn_pintrst_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_pintrst_click");}
 BA.debugLineNum = 821;BA.debugLine="Sub btn_pintrst_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 822;BA.debugLine="main_webview.LoadUrl(\"https://www.pinterest.com\")";
Debug.ShouldStop(2097152);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://www.pinterest.com")));
 BA.debugLineNum = 823;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(4194304);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 824;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(8388608);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 825;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(16777216);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 826;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_quora_click() throws Exception{
try {
		Debug.PushSubsStack("btn_quora_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,797);
if (RapidSub.canDelegate("btn_quora_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_quora_click");}
 BA.debugLineNum = 797;BA.debugLine="Sub btn_quora_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 798;BA.debugLine="main_webview.LoadUrl(\"https://quora.com\")";
Debug.ShouldStop(536870912);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://quora.com")));
 BA.debugLineNum = 799;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(1073741824);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 800;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 801;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(1);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 802;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_rddit_click() throws Exception{
try {
		Debug.PushSubsStack("btn_rddit_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,827);
if (RapidSub.canDelegate("btn_rddit_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_rddit_click");}
 BA.debugLineNum = 827;BA.debugLine="Sub btn_rddit_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 828;BA.debugLine="main_webview.LoadUrl(\"https://www.reddit.com\")";
Debug.ShouldStop(134217728);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://www.reddit.com")));
 BA.debugLineNum = 829;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(268435456);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 830;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(536870912);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 831;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(1073741824);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 832;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_readingfullscreenmode_click() throws Exception{
try {
		Debug.PushSubsStack("btn_readingfullscreenmode_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,709);
if (RapidSub.canDelegate("btn_readingfullscreenmode_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_readingfullscreenmode_click");}
 BA.debugLineNum = 709;BA.debugLine="Sub btn_readingfullscreenmode_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 710;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 711;BA.debugLine="ToggleButton_drawer.Checked=True";
Debug.ShouldStop(64);
main.mostCurrent._togglebutton_drawer.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 712;BA.debugLine="Panel_WebView_ReadingFullScreen_Mode.BringToFront";
Debug.ShouldStop(128);
main.mostCurrent._panel_webview_readingfullscreen_mode.runVoidMethod ("BringToFront");
 BA.debugLineNum = 713;BA.debugLine="Panel_WebView_ReadingFullScreen_Mode.Visible=True";
Debug.ShouldStop(256);
main.mostCurrent._panel_webview_readingfullscreen_mode.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 714;BA.debugLine="WebView_ReadingFullScreen_Mode.LoadUrl(main_webvi";
Debug.ShouldStop(512);
main.mostCurrent._webview_readingfullscreen_mode.runVoidMethod ("LoadUrl",(Object)(main.mostCurrent._main_webview.runMethod(true,"getUrl")));
 BA.debugLineNum = 715;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_refresh_click() throws Exception{
try {
		Debug.PushSubsStack("btn_refresh_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,912);
if (RapidSub.canDelegate("btn_refresh_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_refresh_click");}
 BA.debugLineNum = 912;BA.debugLine="Sub btn_refresh_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 913;BA.debugLine="main_webview.LoadUrl(main_webview.Url)";
Debug.ShouldStop(65536);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(main.mostCurrent._main_webview.runMethod(true,"getUrl")));
 BA.debugLineNum = 914;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(131072);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 915;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(262144);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 916;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_refreshclose_click() throws Exception{
try {
		Debug.PushSubsStack("btn_refreshclose_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,956);
if (RapidSub.canDelegate("btn_refreshclose_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_refreshclose_click");}
 BA.debugLineNum = 956;BA.debugLine="Sub btn_refreshclose_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 957;BA.debugLine="main_webview.StopLoading";
Debug.ShouldStop(268435456);
main.mostCurrent._main_webview.runVoidMethod ("StopLoading");
 BA.debugLineNum = 958;BA.debugLine="btn_refreshclose.Visible=False";
Debug.ShouldStop(536870912);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 959;BA.debugLine="btn_refresh.Visible=True";
Debug.ShouldStop(1073741824);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 960;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_runappbackground_click() throws Exception{
try {
		Debug.PushSubsStack("btn_runappbackground_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,494);
if (RapidSub.canDelegate("btn_runappbackground_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_runappbackground_click");}
 BA.debugLineNum = 494;BA.debugLine="Sub btn_runappbackground_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 496;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_screenshot_click() throws Exception{
try {
		Debug.PushSubsStack("btn_screenshot_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,548);
if (RapidSub.canDelegate("btn_screenshot_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_screenshot_click");}
RemoteObject _m = RemoteObject.createImmutable("");
RemoteObject _h = RemoteObject.createImmutable("");
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _obj1 = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _obj2 = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _args = null;
RemoteObject _types = null;
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
RemoteObject _dointent = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 548;BA.debugLine="Sub btn_screenshot_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 549;BA.debugLine="Panel_Downloader.Visible=False";
Debug.ShouldStop(16);
main.mostCurrent._panel_downloader.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 550;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 551;BA.debugLine="Panel_Drawer.Visible=False";
Debug.ShouldStop(64);
main.mostCurrent._panel_drawer.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 552;BA.debugLine="ToggleButton_drawer.Checked=True";
Debug.ShouldStop(128);
main.mostCurrent._togglebutton_drawer.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 553;BA.debugLine="Try";
Debug.ShouldStop(256);
try { BA.debugLineNum = 554;BA.debugLine="Dim M, H, S As String";
Debug.ShouldStop(512);
_m = RemoteObject.createImmutable("");Debug.locals.put("M", _m);
_h = RemoteObject.createImmutable("");Debug.locals.put("H", _h);
_s = RemoteObject.createImmutable("");Debug.locals.put("S", _s);
 BA.debugLineNum = 555;BA.debugLine="DateTime.DateFormat=\"dd mm yyyy\"";
Debug.ShouldStop(1024);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd mm yyyy"));
 BA.debugLineNum = 556;BA.debugLine="H  = DateTime.GetHour(DateTime.Now)";
Debug.ShouldStop(2048);
_h = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));Debug.locals.put("H", _h);
 BA.debugLineNum = 557;BA.debugLine="M  = DateTime.GetMinute(DateTime.Now)";
Debug.ShouldStop(4096);
_m = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));Debug.locals.put("M", _m);
 BA.debugLineNum = 558;BA.debugLine="S = DateTime.GetSecond(DateTime.Now)";
Debug.ShouldStop(8192);
_s = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetSecond",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));Debug.locals.put("S", _s);
 BA.debugLineNum = 560;BA.debugLine="Dim Obj1, Obj2 As Reflector";
Debug.ShouldStop(32768);
_obj1 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("Obj1", _obj1);
_obj2 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("Obj2", _obj2);
 BA.debugLineNum = 561;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(65536);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 562;BA.debugLine="Dim cvs As Canvas";
Debug.ShouldStop(131072);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 563;BA.debugLine="Obj1.Target = Obj1.GetActivityBA";
Debug.ShouldStop(262144);
_obj1.setField ("Target",(_obj1.runMethod(false,"GetActivityBA",main.processBA)));
 BA.debugLineNum = 564;BA.debugLine="Obj1.Target = Obj1.GetField(\"vg\")";
Debug.ShouldStop(524288);
_obj1.setField ("Target",_obj1.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("vg"))));
 BA.debugLineNum = 565;BA.debugLine="bmp.InitializeMutable(Activity.Width, Activity.H";
Debug.ShouldStop(1048576);
_bmp.runVoidMethod ("InitializeMutable",(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(main.mostCurrent._activity.runMethod(true,"getHeight")));
 BA.debugLineNum = 566;BA.debugLine="cvs.Initialize2(bmp)";
Debug.ShouldStop(2097152);
_cvs.runVoidMethod ("Initialize2",(Object)((_bmp.getObject())));
 BA.debugLineNum = 567;BA.debugLine="Dim args(1) As Object";
Debug.ShouldStop(4194304);
_args = RemoteObject.createNewArray ("Object", new int[] {1}, new Object[]{});Debug.locals.put("args", _args);
 BA.debugLineNum = 568;BA.debugLine="Dim types(1) As String";
Debug.ShouldStop(8388608);
_types = RemoteObject.createNewArray ("String", new int[] {1}, new Object[]{});Debug.locals.put("types", _types);
 BA.debugLineNum = 569;BA.debugLine="Obj2.Target = cvs";
Debug.ShouldStop(16777216);
_obj2.setField ("Target",(_cvs));
 BA.debugLineNum = 570;BA.debugLine="Obj2.Target = Obj2.GetField(\"canvas\")";
Debug.ShouldStop(33554432);
_obj2.setField ("Target",_obj2.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("canvas"))));
 BA.debugLineNum = 571;BA.debugLine="args(0) = Obj2.Target";
Debug.ShouldStop(67108864);
_args.setArrayElement (_obj2.getField(false,"Target"),BA.numberCast(int.class, 0));
 BA.debugLineNum = 572;BA.debugLine="types(0) = \"android.graphics.Canvas\"";
Debug.ShouldStop(134217728);
_types.setArrayElement (BA.ObjectToString("android.graphics.Canvas"),BA.numberCast(int.class, 0));
 BA.debugLineNum = 573;BA.debugLine="Obj1.RunMethod4(\"draw\", args, types)";
Debug.ShouldStop(268435456);
_obj1.runVoidMethod ("RunMethod4",(Object)(BA.ObjectToString("draw")),(Object)(_args),(Object)(_types));
 BA.debugLineNum = 574;BA.debugLine="Dim Out As OutputStream";
Debug.ShouldStop(536870912);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("Out", _out);
 BA.debugLineNum = 575;BA.debugLine="Out = File.OpenOutput(File.DirRootExternal & \"/F";
Debug.ShouldStop(1073741824);
_out = main.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(RemoteObject.concat(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal"),RemoteObject.createImmutable("/Frigate/ScreenShots"))),(Object)(RemoteObject.concat(_h,RemoteObject.createImmutable(":"),_m,_s,main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable("-frigate_Screenshot.Png"))),(Object)(main.mostCurrent.__c.getField(true,"False")));Debug.locals.put("Out", _out);
 BA.debugLineNum = 576;BA.debugLine="bmp.WriteToStream(Out, 100, \"PNG\")";
Debug.ShouldStop(-2147483648);
_bmp.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("PNG"))));
 BA.debugLineNum = 577;BA.debugLine="Out.Close";
Debug.ShouldStop(1);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 578;BA.debugLine="ToastMessageShow(\"ScreenShot Capture Successfull";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ScreenShot Capture Successfull ! ")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e31) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e31.toString()); BA.debugLineNum = 580;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("LogImpl","81114144",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 BA.debugLineNum = 582;BA.debugLine="If Msgbox2(\"Directory Unavailable or STORAGE PER";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Directory Unavailable or STORAGE PERMISSION denied !"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Get Permission : Open Settings > Apps > Configure Apps > App Permissions > Storage > Frigate Browser")))),(Object)(BA.ObjectToCharSequence("READ CAREFULLY")),(Object)(BA.ObjectToString("Open Settings")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA),BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 583;BA.debugLine="Dim DoIntent As Intent";
Debug.ShouldStop(64);
_dointent = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("DoIntent", _dointent);
 BA.debugLineNum = 584;BA.debugLine="DoIntent.Initialize(\"android.settings.MANAGE_AP";
Debug.ShouldStop(128);
_dointent.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.settings.MANAGE_APPLICATIONS_SETTINGS")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 585;BA.debugLine="StartActivity(DoIntent)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_dointent.getObject())));
 }else {
 };
 };
 BA.debugLineNum = 589;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_search_click() throws Exception{
try {
		Debug.PushSubsStack("btn_search_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,936);
if (RapidSub.canDelegate("btn_search_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_search_click");}
 BA.debugLineNum = 936;BA.debugLine="Sub btn_search_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 937;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(256);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 938;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(512);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 939;BA.debugLine="main_webview.LoadUrl(textbox_search_bar.Text)";
Debug.ShouldStop(1024);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(main.mostCurrent._textbox_search_bar.runMethod(true,"getText")));
 BA.debugLineNum = 940;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_search_longclick() throws Exception{
try {
		Debug.PushSubsStack("btn_search_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,941);
if (RapidSub.canDelegate("btn_search_longclick")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_search_longclick");}
 BA.debugLineNum = 941;BA.debugLine="Sub btn_search_LongClick";
Debug.ShouldStop(4096);
 BA.debugLineNum = 942;BA.debugLine="Try";
Debug.ShouldStop(8192);
try { BA.debugLineNum = 943;BA.debugLine="If main_webview.Url.StartsWith(\"http://\") Then";
Debug.ShouldStop(16384);
if (main.mostCurrent._main_webview.runMethod(true,"getUrl").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("http://"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 944;BA.debugLine="Msgbox(\"Not Secure [ LEVEL - 50% - NO SSL ]\"& C";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Not Secure [ LEVEL - 50% - NO SSL ]"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent._main_webview.runMethod(true,"getUrl"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent._webviewextender.runMethod(true,"getTitle",(Object)((main.mostCurrent._main_webview.getObject()))),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("HOST : "),main.mostCurrent._webviewextender.runMethod(true,"getHost",(Object)(BA.ObjectToString(main.mostCurrent._main_webview)))))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Security Deatils"))),main.mostCurrent.activityBA);
 };
 BA.debugLineNum = 946;BA.debugLine="If main_webview.Url.StartsWith(\"https://\") Then";
Debug.ShouldStop(131072);
if (main.mostCurrent._main_webview.runMethod(true,"getUrl").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("https://"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 947;BA.debugLine="Msgbox(\"Fully Secure [ LEVEL - 100% - SSL ]\" &";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Fully Secure [ LEVEL - 100% - SSL ]"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent._main_webview.runMethod(true,"getUrl"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent._webviewextender.runMethod(true,"getTitle",(Object)((main.mostCurrent._main_webview.getObject()))),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("HOST : "),main.mostCurrent._webviewextender.runMethod(true,"getHost",(Object)(BA.ObjectToString(main.mostCurrent._main_webview)))))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Security Deatils"))),main.mostCurrent.activityBA);
 };
 BA.debugLineNum = 949;BA.debugLine="If main_webview.Url.StartsWith(\"file:///\") Then";
Debug.ShouldStop(1048576);
if (main.mostCurrent._main_webview.runMethod(true,"getUrl").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("file:///"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 950;BA.debugLine="Msgbox(\"In-App WebView : No details available\",";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("In-App WebView : No details available")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Security Deatils"))),main.mostCurrent.activityBA);
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e12.toString()); BA.debugLineNum = 953;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("LogImpl","83342348",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 955;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_settingspanel_okandhide_click() throws Exception{
try {
		Debug.PushSubsStack("btn_settingspanel_okandhide_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1067);
if (RapidSub.canDelegate("btn_settingspanel_okandhide_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_settingspanel_okandhide_click");}
 BA.debugLineNum = 1067;BA.debugLine="Sub btn_settingspanel_okandhide_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 1068;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 1069;BA.debugLine="If RadioButton_google.Checked=True Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_google.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1070;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"google";
Debug.ShouldStop(8192);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("google.txt")),(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 1071;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.";
Debug.ShouldStop(16384);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("duck.txt")),(Object)(RemoteObject.createImmutable("0")));
 BA.debugLineNum = 1072;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.";
Debug.ShouldStop(32768);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("duck.txt")),(Object)(RemoteObject.createImmutable("0")));
 BA.debugLineNum = 1073;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"yahoo";
Debug.ShouldStop(65536);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("yahoo.txt")),(Object)(RemoteObject.createImmutable("0")));
 }else {
 BA.debugLineNum = 1075;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"google";
Debug.ShouldStop(262144);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("google.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 1077;BA.debugLine="If RadioButton_duck.Checked=True Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_duck.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1078;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.t";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("duck.txt")),(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 1079;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"googl";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("google.txt")),(Object)(RemoteObject.createImmutable("0")));
 BA.debugLineNum = 1080;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"bing.";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("bing.txt")),(Object)(RemoteObject.createImmutable("0")));
 BA.debugLineNum = 1081;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"yahoo";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("yahoo.txt")),(Object)(RemoteObject.createImmutable("0")));
 }else {
 BA.debugLineNum = 1083;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.t";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("duck.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 1085;BA.debugLine="If RadioButton_bing.Checked=True Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_bing.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1086;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"bing.t";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("bing.txt")),(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 1087;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"googl";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("google.txt")),(Object)(RemoteObject.createImmutable("0")));
 BA.debugLineNum = 1088;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("duck.txt")),(Object)(RemoteObject.createImmutable("0")));
 BA.debugLineNum = 1089;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"yahoo";
Debug.ShouldStop(1);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("yahoo.txt")),(Object)(RemoteObject.createImmutable("0")));
 }else {
 BA.debugLineNum = 1091;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"bing.t";
Debug.ShouldStop(4);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("bing.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 1093;BA.debugLine="If RadioButton_yahoo.Checked=True Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",main.mostCurrent._radiobutton_yahoo.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1094;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"yahoo.";
Debug.ShouldStop(32);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("yahoo.txt")),(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 1095;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"bing.";
Debug.ShouldStop(64);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("bing.txt")),(Object)(RemoteObject.createImmutable("0")));
 BA.debugLineNum = 1096;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"googl";
Debug.ShouldStop(128);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("google.txt")),(Object)(RemoteObject.createImmutable("0")));
 BA.debugLineNum = 1097;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.";
Debug.ShouldStop(256);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("duck.txt")),(Object)(RemoteObject.createImmutable("0")));
 }else {
 BA.debugLineNum = 1099;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"yahoo.";
Debug.ShouldStop(1024);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("yahoo.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 1104;BA.debugLine="If CheckBox_savepass.Checked=True Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",main.mostCurrent._checkbox_savepass.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1105;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"savepa";
Debug.ShouldStop(65536);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("savepass.txt")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 1107;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"savepa";
Debug.ShouldStop(262144);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("savepass.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 1109;BA.debugLine="If CheckBox_dnt.Checked=True Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",main.mostCurrent._checkbox_dnt.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1110;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"dnt.tx";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("dnt.txt")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 1112;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"dnt.tx";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("dnt.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 1114;BA.debugLine="If CheckBox_js.Checked=True Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",main.mostCurrent._checkbox_js.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1115;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"js.txt";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("js.txt")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 1117;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"js.txt";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("js.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 1119;BA.debugLine="If CheckBox_boostmode.Checked=True Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",main.mostCurrent._checkbox_boostmode.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1120;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"boostr";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("boostr.txt")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 1122;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"boostr";
Debug.ShouldStop(2);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("boostr.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 1124;BA.debugLine="If CheckBox_cookie.Checked=True Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",main.mostCurrent._checkbox_cookie.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1125;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"cookie";
Debug.ShouldStop(16);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("cookie.txt")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 1127;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"cookie";
Debug.ShouldStop(64);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("cookie.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 1129;BA.debugLine="If CheckBox_safesearch.Checked=True Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",main.mostCurrent._checkbox_safesearch.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1130;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"sfsear";
Debug.ShouldStop(512);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("sfsearch.txt")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 1132;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"sfsear";
Debug.ShouldStop(2048);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("sfsearch.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 BA.debugLineNum = 1135;BA.debugLine="If CheckBox_applock_enable.Checked=True Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",main.mostCurrent._checkbox_applock_enable.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1136;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"pscode";
Debug.ShouldStop(32768);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("pscodecheck.txt")),(Object)(RemoteObject.createImmutable("1")));
 }else {
 BA.debugLineNum = 1138;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"pscod";
Debug.ShouldStop(131072);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("pscodecheck.txt")),(Object)(RemoteObject.createImmutable("0")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e70) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e70.toString()); BA.debugLineNum = 1141;BA.debugLine="ToastMessageShow(\"Settings Save Error !\",True)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Settings Save Error !")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 1142;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","84128843",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 1145;BA.debugLine="Panel_Main_Settings.Visible=False";
Debug.ShouldStop(16777216);
main.mostCurrent._panel_main_settings.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1146;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_shareapp_click() throws Exception{
try {
		Debug.PushSubsStack("btn_shareapp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,716);
if (RapidSub.canDelegate("btn_shareapp_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_shareapp_click");}
RemoteObject _shareapk = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 716;BA.debugLine="Sub btn_shareapp_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 717;BA.debugLine="Try";
Debug.ShouldStop(4096);
try { BA.debugLineNum = 718;BA.debugLine="Dim shareapk As Intent";
Debug.ShouldStop(8192);
_shareapk = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("shareapk", _shareapk);
 BA.debugLineNum = 719;BA.debugLine="shareapk.Initialize(shareapk.ACTION_SEND,\"\")";
Debug.ShouldStop(16384);
_shareapk.runVoidMethod ("Initialize",(Object)(_shareapk.getField(true,"ACTION_SEND")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 720;BA.debugLine="shareapk.SetType(\"text/plain\")";
Debug.ShouldStop(32768);
_shareapk.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("text/plain")));
 BA.debugLineNum = 721;BA.debugLine="shareapk.PutExtra(\"android.intent.extra.TEXT\",\"M";
Debug.ShouldStop(65536);
_shareapk.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("android.intent.extra.TEXT")),(Object)((RemoteObject.concat(RemoteObject.createImmutable("Make hard things simple. Lite Browser with Lightning Speed and Mini Usage."),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Data Save / Battery Save / Smart Search / Smart and High-Speed and Unlimited Downloader / Media Integration / Night Mode / 100% Security / Social Media Integration....."),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Get it on Google Play Now. http://play.google.com/store/apps/details?id=com.clenontec.webbrowser")))));
 BA.debugLineNum = 722;BA.debugLine="shareapk.WrapAsIntentChooser(\"Share Frigate Brows";
Debug.ShouldStop(131072);
_shareapk.runVoidMethod ("WrapAsIntentChooser",(Object)(RemoteObject.createImmutable("Share Frigate Browser")));
 BA.debugLineNum = 723;BA.debugLine="StartActivity(shareapk)";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_shareapk.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e9.toString()); BA.debugLineNum = 725;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("LogImpl","81638409",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 728;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_shareweburl_click() throws Exception{
try {
		Debug.PushSubsStack("btn_shareweburl_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,621);
if (RapidSub.canDelegate("btn_shareweburl_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_shareweburl_click");}
RemoteObject _shareweburlpk = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 621;BA.debugLine="Sub btn_shareweburl_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 623;BA.debugLine="If main_webview.Url.StartsWith(\"file:///\") Then";
Debug.ShouldStop(16384);
if (main.mostCurrent._main_webview.runMethod(true,"getUrl").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("file:///"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 624;BA.debugLine="ToastMessageShow(\"Sharing Faild !\",True)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Sharing Faild !")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 626;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 627;BA.debugLine="Dim shareweburlpk As Intent";
Debug.ShouldStop(262144);
_shareweburlpk = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("shareweburlpk", _shareweburlpk);
 BA.debugLineNum = 628;BA.debugLine="shareweburlpk.Initialize(shareweburlpk.ACTION_SE";
Debug.ShouldStop(524288);
_shareweburlpk.runVoidMethod ("Initialize",(Object)(_shareweburlpk.getField(true,"ACTION_SEND")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 629;BA.debugLine="shareweburlpk.SetType(\"text/plain\")";
Debug.ShouldStop(1048576);
_shareweburlpk.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("text/plain")));
 BA.debugLineNum = 630;BA.debugLine="shareweburlpk.PutExtra(\"android.intent.extra.TE";
Debug.ShouldStop(2097152);
_shareweburlpk.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("android.intent.extra.TEXT")),(Object)((RemoteObject.concat(RemoteObject.createImmutable("URL ( Share ) : "),main.mostCurrent._main_webview.runMethod(true,"getUrl"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Make hard things simple. Lite Browser with Lightning Speed and Mini Usage. Get it on Google Play Now. http://play.google.com/store/apps/details?id=com.clenontec.webbrowser")))));
 BA.debugLineNum = 631;BA.debugLine="shareweburlpk.WrapAsIntentChooser(\"URL Sharing S";
Debug.ShouldStop(4194304);
_shareweburlpk.runVoidMethod ("WrapAsIntentChooser",(Object)(RemoteObject.createImmutable("URL Sharing Service")));
 BA.debugLineNum = 632;BA.debugLine="StartActivity(shareweburlpk)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_shareweburlpk.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e12.toString()); BA.debugLineNum = 634;BA.debugLine="Log(LastException)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","81310733",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 };
 BA.debugLineNum = 640;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_snpcht_click() throws Exception{
try {
		Debug.PushSubsStack("btn_snpcht_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,839);
if (RapidSub.canDelegate("btn_snpcht_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_snpcht_click");}
 BA.debugLineNum = 839;BA.debugLine="Sub btn_snpcht_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 840;BA.debugLine="main_webview.LoadUrl(\"https://accounts.snapchat.c";
Debug.ShouldStop(128);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://accounts.snapchat.com")));
 BA.debugLineNum = 841;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(256);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 842;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(512);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 843;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(1024);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 844;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_soundcloud_click() throws Exception{
try {
		Debug.PushSubsStack("btn_soundcloud_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,845);
if (RapidSub.canDelegate("btn_soundcloud_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_soundcloud_click");}
 BA.debugLineNum = 845;BA.debugLine="Sub btn_soundcloud_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 846;BA.debugLine="main_webview.LoadUrl(\"https://m.soundcloud.com\")";
Debug.ShouldStop(8192);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://m.soundcloud.com")));
 BA.debugLineNum = 847;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(16384);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 848;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(32768);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 849;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(65536);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 850;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_startdownload_click() throws Exception{
try {
		Debug.PushSubsStack("btn_startdownload_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,866);
if (RapidSub.canDelegate("btn_startdownload_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_startdownload_click");}
 BA.debugLineNum = 866;BA.debugLine="Sub btn_startdownload_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 867;BA.debugLine="Try";
Debug.ShouldStop(4);
try { BA.debugLineNum = 868;BA.debugLine="If textbox_download_url.Text=\"\" Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",main.mostCurrent._textbox_download_url.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 869;BA.debugLine="ToastMessageShow(\"Please enter Site or Download";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please enter Site or Download URL")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 871;BA.debugLine="If Msgbox2(\"Are you sure that you have internet";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Are you sure that you have internet connection?"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("If you do not currently, as soon as you get a connection it will start downloading."),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Once you start, you can't cancel downloading."),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Download Location : "),main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal"),RemoteObject.createImmutable("/Frigate/Download"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Save File Name : "),main.mostCurrent._textbox_download_url.runMethod(true,"getText"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Link : "),main.mostCurrent._textbox_download_url.runMethod(true,"getText")))),(Object)(BA.ObjectToCharSequence("INFO - Frigate Downloader")),(Object)(BA.ObjectToString("Start Download")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA),BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 872;BA.debugLine="DownloaderService.DOWNLOAD_ADDRESS=textbox_dow";
Debug.ShouldStop(128);
main.mostCurrent._downloaderservice._download_address /*RemoteObject*/  = main.mostCurrent._textbox_download_url.runMethod(true,"getText");
 BA.debugLineNum = 873;BA.debugLine="DownloaderService.DOWNLOAD_FILENAME=textbox_do";
Debug.ShouldStop(256);
main.mostCurrent._downloaderservice._download_filename /*RemoteObject*/  = main.mostCurrent._textbox_download_filename.runMethod(true,"getText");
 BA.debugLineNum = 874;BA.debugLine="StartService(DownloaderService)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("StartService",main.processBA,(Object)((main.mostCurrent._downloaderservice.getObject())));
 }else {
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e13.toString()); BA.debugLineNum = 881;BA.debugLine="Log(LastException)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("LogImpl","82883599",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 BA.debugLineNum = 882;BA.debugLine="ToastMessageShow(\"Download Error !\",True)";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Download Error !")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 884;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_telgrm_click() throws Exception{
try {
		Debug.PushSubsStack("btn_telgrm_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,833);
if (RapidSub.canDelegate("btn_telgrm_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_telgrm_click");}
 BA.debugLineNum = 833;BA.debugLine="Sub btn_telgrm_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 834;BA.debugLine="main_webview.LoadUrl(\"https://web.telegram.org/#/";
Debug.ShouldStop(2);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://web.telegram.org/#/login")));
 BA.debugLineNum = 835;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(4);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 836;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(8);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 837;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(16);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 838;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_twttr_click() throws Exception{
try {
		Debug.PushSubsStack("btn_twttr_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,815);
if (RapidSub.canDelegate("btn_twttr_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_twttr_click");}
 BA.debugLineNum = 815;BA.debugLine="Sub btn_twttr_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 816;BA.debugLine="main_webview.LoadUrl(\"https://twitter.com\")";
Debug.ShouldStop(32768);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://twitter.com")));
 BA.debugLineNum = 817;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(65536);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 818;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(131072);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 819;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(262144);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 820;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_urlplus_click() throws Exception{
try {
		Debug.PushSubsStack("btn_urlplus_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,961);
if (RapidSub.canDelegate("btn_urlplus_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_urlplus_click");}
 BA.debugLineNum = 961;BA.debugLine="Sub btn_urlplus_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 962;BA.debugLine="textbox_search_bar.Text=\"http://\"";
Debug.ShouldStop(2);
main.mostCurrent._textbox_search_bar.runMethodAndSync(true,"setText",BA.ObjectToCharSequence("http://"));
 BA.debugLineNum = 963;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_urlplus_longclick() throws Exception{
try {
		Debug.PushSubsStack("btn_urlplus_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,964);
if (RapidSub.canDelegate("btn_urlplus_longclick")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_urlplus_longclick");}
RemoteObject _urlpluscopy = RemoteObject.declareNull("b4a.util.BClipboard");
 BA.debugLineNum = 964;BA.debugLine="Sub btn_urlplus_LongClick";
Debug.ShouldStop(8);
 BA.debugLineNum = 965;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 966;BA.debugLine="Dim urlpluscopy As BClipboard";
Debug.ShouldStop(32);
_urlpluscopy = RemoteObject.createNew ("b4a.util.BClipboard");Debug.locals.put("urlpluscopy", _urlpluscopy);
 BA.debugLineNum = 967;BA.debugLine="textbox_search_bar.Text=urlpluscopy.getText";
Debug.ShouldStop(64);
main.mostCurrent._textbox_search_bar.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_urlpluscopy.runMethod(true,"getText",main.mostCurrent.activityBA)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e5) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e5.toString()); BA.debugLineNum = 969;BA.debugLine="Log(LastException)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","83538949",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 972;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_youtube_click() throws Exception{
try {
		Debug.PushSubsStack("btn_youtube_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,851);
if (RapidSub.canDelegate("btn_youtube_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_youtube_click");}
 BA.debugLineNum = 851;BA.debugLine="Sub btn_youtube_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 852;BA.debugLine="main_webview.LoadUrl(\"https://m.youtube.com\")";
Debug.ShouldStop(524288);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://m.youtube.com")));
 BA.debugLineNum = 853;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(1048576);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 854;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(2097152);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 855;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(4194304);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 856;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_ytgames_click() throws Exception{
try {
		Debug.PushSubsStack("btn_ytgames_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,790);
if (RapidSub.canDelegate("btn_ytgames_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_ytgames_click");}
 BA.debugLineNum = 790;BA.debugLine="Sub btn_ytgames_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 791;BA.debugLine="main_webview.LoadUrl(\"https://m.youtube.com/gamin";
Debug.ShouldStop(4194304);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://m.youtube.com/gaming/")));
 BA.debugLineNum = 792;BA.debugLine="Panel_Intergration.Visible=False";
Debug.ShouldStop(8388608);
main.mostCurrent._panel_intergration.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 793;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(16777216);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 794;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(33554432);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 795;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_zoomenabled_click() throws Exception{
try {
		Debug.PushSubsStack("btn_zoomenabled_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,690);
if (RapidSub.canDelegate("btn_zoomenabled_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","btn_zoomenabled_click");}
 BA.debugLineNum = 690;BA.debugLine="Sub btn_zoomenabled_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 691;BA.debugLine="If ToggleButton_zoomenbl.Checked=True Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",main.mostCurrent._togglebutton_zoomenbl.runMethod(true,"getChecked"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 692;BA.debugLine="btn_zoomenabled.TextColor=Colors.RGB(221,74,113)";
Debug.ShouldStop(524288);
main.mostCurrent._btn_zoomenabled.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 221)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 113))));
 BA.debugLineNum = 693;BA.debugLine="main_webview.ZoomEnabled=True";
Debug.ShouldStop(1048576);
main.mostCurrent._main_webview.runMethod(true,"setZoomEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 694;BA.debugLine="WebViewSettings.setDisplayZoomControls(main_webv";
Debug.ShouldStop(2097152);
main.mostCurrent._webviewsettings.runVoidMethod ("setDisplayZoomControls",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 695;BA.debugLine="WebView_ReadingFullScreen_Mode.ZoomEnabled=True";
Debug.ShouldStop(4194304);
main.mostCurrent._webview_readingfullscreen_mode.runMethod(true,"setZoomEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 696;BA.debugLine="WebViewSettings.setDisplayZoomControls(WebView_R";
Debug.ShouldStop(8388608);
main.mostCurrent._webviewsettings.runVoidMethod ("setDisplayZoomControls",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 697;BA.debugLine="ToggleButton_zoomenbl.Checked=False";
Debug.ShouldStop(16777216);
main.mostCurrent._togglebutton_zoomenbl.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 698;BA.debugLine="ToastMessageShow(\"Zoom Enabled !\",True)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Zoom Enabled !")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 700;BA.debugLine="ToastMessageShow(\"Zoom Disable !\",True)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Zoom Disable !")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 701;BA.debugLine="WebViewSettings.setDisplayZoomControls(main_webv";
Debug.ShouldStop(268435456);
main.mostCurrent._webviewsettings.runVoidMethod ("setDisplayZoomControls",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 702;BA.debugLine="btn_zoomenabled.TextColor=Colors.RGB(85,85,85)";
Debug.ShouldStop(536870912);
main.mostCurrent._btn_zoomenabled.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85)),(Object)(BA.numberCast(int.class, 85))));
 BA.debugLineNum = 703;BA.debugLine="main_webview.ZoomEnabled=False";
Debug.ShouldStop(1073741824);
main.mostCurrent._main_webview.runMethod(true,"setZoomEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 704;BA.debugLine="WebView_ReadingFullScreen_Mode.ZoomEnabled=False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._webview_readingfullscreen_mode.runMethod(true,"setZoomEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 705;BA.debugLine="WebViewSettings.setDisplayZoomControls(WebView_R";
Debug.ShouldStop(1);
main.mostCurrent._webviewsettings.runVoidMethod ("setDisplayZoomControls",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 706;BA.debugLine="ToggleButton_zoomenbl.Checked=True";
Debug.ShouldStop(2);
main.mostCurrent._togglebutton_zoomenbl.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 708;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button_applock_click() throws Exception{
try {
		Debug.PushSubsStack("Button_applock_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1193);
if (RapidSub.canDelegate("button_applock_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","button_applock_click");}
 BA.debugLineNum = 1193;BA.debugLine="Sub Button_applock_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 1194;BA.debugLine="Panel_applock_settings.BringToFront";
Debug.ShouldStop(512);
main.mostCurrent._panel_applock_settings.runVoidMethod ("BringToFront");
 BA.debugLineNum = 1195;BA.debugLine="Panel_applock_settings.Visible=True";
Debug.ShouldStop(1024);
main.mostCurrent._panel_applock_settings.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1196;BA.debugLine="Button_applock.Visible=False";
Debug.ShouldStop(2048);
main.mostCurrent._button_applock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1197;BA.debugLine="Button_history.Visible=False";
Debug.ShouldStop(4096);
main.mostCurrent._button_history.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1198;BA.debugLine="btn_pannelsettings_reset.Visible=False";
Debug.ShouldStop(8192);
main.mostCurrent._btn_pannelsettings_reset.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1199;BA.debugLine="btn_settingspanel_okandhide.Visible=False";
Debug.ShouldStop(16384);
main.mostCurrent._btn_settingspanel_okandhide.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1200;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button_history_click() throws Exception{
try {
		Debug.PushSubsStack("Button_history_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1149);
if (RapidSub.canDelegate("button_history_click")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","button_history_click");}
 BA.debugLineNum = 1149;BA.debugLine="Sub Button_history_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 1150;BA.debugLine="Panel_Settings_History.BringToFront";
Debug.ShouldStop(536870912);
main.mostCurrent._panel_settings_history.runVoidMethod ("BringToFront");
 BA.debugLineNum = 1151;BA.debugLine="Panel_Settings_History.Visible=True";
Debug.ShouldStop(1073741824);
main.mostCurrent._panel_settings_history.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1152;BA.debugLine="Button_applock.Visible=False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._button_applock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1153;BA.debugLine="Button_history.Visible=False";
Debug.ShouldStop(1);
main.mostCurrent._button_history.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1154;BA.debugLine="btn_pannelsettings_reset.Visible=False";
Debug.ShouldStop(2);
main.mostCurrent._btn_pannelsettings_reset.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1155;BA.debugLine="btn_settingspanel_okandhide.Visible=False";
Debug.ShouldStop(4);
main.mostCurrent._btn_settingspanel_okandhide.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1156;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Private main_webview As WebView";
main.mostCurrent._main_webview = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Main_Panel As Panel";
main.mostCurrent._main_panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private Panel_Navigation_Bar As Panel";
main.mostCurrent._panel_navigation_bar = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private btn_drawer As Button";
main.mostCurrent._btn_drawer = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private btn_home As Button";
main.mostCurrent._btn_home = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private btn_fowrd As Button";
main.mostCurrent._btn_fowrd = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private btn_back As Button";
main.mostCurrent._btn_back = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private Panel_Search_Bar As Panel";
main.mostCurrent._panel_search_bar = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private btn_search As Button";
main.mostCurrent._btn_search = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private textbox_search_bar As AutoCompleteEditTex";
main.mostCurrent._textbox_search_bar = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private btn_refresh As Button";
main.mostCurrent._btn_refresh = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private Panel_Drawer As Panel";
main.mostCurrent._panel_drawer = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private btn_appexit As Button";
main.mostCurrent._btn_appexit = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private btn_shareapp As Button";
main.mostCurrent._btn_shareapp = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private btn_helpguide As Button";
main.mostCurrent._btn_helpguide = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private btn_appsettingsmore As Button";
main.mostCurrent._btn_appsettingsmore = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private btn_readingfullscreenmode As Button";
main.mostCurrent._btn_readingfullscreenmode = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private btn_darkmode As Button";
main.mostCurrent._btn_darkmode = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private btn_downloader As Button";
main.mostCurrent._btn_downloader = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private btn_shareweburl As Button";
main.mostCurrent._btn_shareweburl = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private btn_imagedisable As Button";
main.mostCurrent._btn_imagedisable = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private btn_openweblinkanotherbrowser As Button";
main.mostCurrent._btn_openweblinkanotherbrowser = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private btn_screenshot As Button";
main.mostCurrent._btn_screenshot = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private btn_intergrton As Button";
main.mostCurrent._btn_intergrton = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private btn_clearalldataapp As Button";
main.mostCurrent._btn_clearalldataapp = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private btn_batterysaver As Button";
main.mostCurrent._btn_batterysaver = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private btn_jsdisable As Button";
main.mostCurrent._btn_jsdisable = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private btn_zoomenabled As Button";
main.mostCurrent._btn_zoomenabled = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private Panel_Intergration As Panel";
main.mostCurrent._panel_intergration = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private btn_extrasites As Button";
main.mostCurrent._btn_extrasites = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private btn_panel_intergration_hide As Button";
main.mostCurrent._btn_panel_intergration_hide = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private btn_soundcloud As Button";
main.mostCurrent._btn_soundcloud = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Private btn_youtube As Button";
main.mostCurrent._btn_youtube = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Private btn_snpcht As Button";
main.mostCurrent._btn_snpcht = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private btn_telgrm As Button";
main.mostCurrent._btn_telgrm = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 68;BA.debugLine="Private btn_rddit As Button";
main.mostCurrent._btn_rddit = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 69;BA.debugLine="Private btn_pintrst As Button";
main.mostCurrent._btn_pintrst = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 70;BA.debugLine="Private btn_lnkdin As Button";
main.mostCurrent._btn_lnkdin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 71;BA.debugLine="Private btn_twttr As Button";
main.mostCurrent._btn_twttr = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 72;BA.debugLine="Private btn_fb As Button";
main.mostCurrent._btn_fb = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 73;BA.debugLine="Private btn_instr As Button";
main.mostCurrent._btn_instr = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Private btn_ytgames As Button";
main.mostCurrent._btn_ytgames = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 75;BA.debugLine="Private btn_quora As Button";
main.mostCurrent._btn_quora = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 78;BA.debugLine="Private Panel_Downloader As Panel";
main.mostCurrent._panel_downloader = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 79;BA.debugLine="Private btn_hidedownloadpanel As Button";
main.mostCurrent._btn_hidedownloadpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 80;BA.debugLine="Private btn_startdownload As Button";
main.mostCurrent._btn_startdownload = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 81;BA.debugLine="Private textbox_download_filename As AutoComplete";
main.mostCurrent._textbox_download_filename = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 82;BA.debugLine="Private textbox_download_url As AutoCompleteEditT";
main.mostCurrent._textbox_download_url = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 83;BA.debugLine="Private lbl_paneldownload_head As Label";
main.mostCurrent._lbl_paneldownload_head = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 84;BA.debugLine="Private Panel_Downloader_Header_Color As Panel";
main.mostCurrent._panel_downloader_header_color = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 85;BA.debugLine="Private btn_downloadbooster_panel As CheckBox";
main.mostCurrent._btn_downloadbooster_panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 88;BA.debugLine="Private WebView_ReadingFullScreen_Mode As WebView";
main.mostCurrent._webview_readingfullscreen_mode = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 89;BA.debugLine="Private btn_fullscreenreadingmode_exit As Button";
main.mostCurrent._btn_fullscreenreadingmode_exit = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 90;BA.debugLine="Private btn_fullscreen_fowrd As Button";
main.mostCurrent._btn_fullscreen_fowrd = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 91;BA.debugLine="Private btn_fullscreen_back As Button";
main.mostCurrent._btn_fullscreen_back = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 94;BA.debugLine="Private Button_applock As Button";
main.mostCurrent._button_applock = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 95;BA.debugLine="Private Button_exportdata As Button";
main.mostCurrent._button_exportdata = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 96;BA.debugLine="Private LBL_SEARCHENGINE As Label";
main.mostCurrent._lbl_searchengine = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 97;BA.debugLine="Private RadioButton_google As RadioButton";
main.mostCurrent._radiobutton_google = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 98;BA.debugLine="Private RadioButton_duck As RadioButton";
main.mostCurrent._radiobutton_duck = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 99;BA.debugLine="Private lbl_sitesecurity As Label";
main.mostCurrent._lbl_sitesecurity = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 100;BA.debugLine="Private CheckBox_savepass As CheckBox";
main.mostCurrent._checkbox_savepass = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 101;BA.debugLine="Private CheckBox_dnt As CheckBox";
main.mostCurrent._checkbox_dnt = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 102;BA.debugLine="Private lbl_sitesetting As Label";
main.mostCurrent._lbl_sitesetting = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 103;BA.debugLine="Private CheckBox_js As CheckBox";
main.mostCurrent._checkbox_js = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 104;BA.debugLine="Private CheckBox_boostmode As CheckBox";
main.mostCurrent._checkbox_boostmode = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 105;BA.debugLine="Private CheckBox_cookie As CheckBox";
main.mostCurrent._checkbox_cookie = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 106;BA.debugLine="Private RadioButton_bing As RadioButton";
main.mostCurrent._radiobutton_bing = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 107;BA.debugLine="Private RadioButton_yahoo As RadioButton";
main.mostCurrent._radiobutton_yahoo = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 108;BA.debugLine="Private CheckBox_safesearch As CheckBox";
main.mostCurrent._checkbox_safesearch = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 110;BA.debugLine="Private Panel_applock_settings As Panel";
main.mostCurrent._panel_applock_settings = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 111;BA.debugLine="Private TextBox_applock_password_set As AutoCompl";
main.mostCurrent._textbox_applock_password_set = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 112;BA.debugLine="Private lbl_passcodelock As Label";
main.mostCurrent._lbl_passcodelock = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 113;BA.debugLine="Private lbl_passcode_info As Label";
main.mostCurrent._lbl_passcode_info = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 114;BA.debugLine="Private CheckBox_applock_enable As CheckBox";
main.mostCurrent._checkbox_applock_enable = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 115;BA.debugLine="Private btn_applocksave As Button";
main.mostCurrent._btn_applocksave = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 116;BA.debugLine="Private btn_password_panelHide As Button";
main.mostCurrent._btn_password_panelhide = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 117;BA.debugLine="Private Textbox_retype_passcodepleteEditText1 As";
main.mostCurrent._textbox_retype_passcodepleteedittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 119;BA.debugLine="Private Button_history As Button";
main.mostCurrent._button_history = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 120;BA.debugLine="Private Panel_Settings_History As Panel";
main.mostCurrent._panel_settings_history = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 123;BA.debugLine="Private Panel_App_Lock As Panel";
main.mostCurrent._panel_app_lock = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 124;BA.debugLine="Private lbl_applock_hint As Label";
main.mostCurrent._lbl_applock_hint = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 125;BA.debugLine="Private ImageView_applocker As ImageView";
main.mostCurrent._imageview_applocker = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 126;BA.debugLine="Private Txtbox_applock_text As AutoCompleteEditTe";
main.mostCurrent._txtbox_applock_text = RemoteObject.createNew ("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
 //BA.debugLineNum = 129;BA.debugLine="Private ToggleButton_drawer As ToggleButton";
main.mostCurrent._togglebutton_drawer = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 133;BA.debugLine="Dim DownloadManager1 As DownloadManager";
main.mostCurrent._downloadmanager1 = RemoteObject.createNew ("uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager");
 //BA.debugLineNum = 134;BA.debugLine="Private PANEL_HIDE_BUTTONS As Panel";
main.mostCurrent._panel_hide_buttons = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 135;BA.debugLine="Private rpa As RuntimePermissions";
main.mostCurrent._rpa = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 136;BA.debugLine="Private ToggleButton_imagedisable As ToggleButton";
main.mostCurrent._togglebutton_imagedisable = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 137;BA.debugLine="Private ToggleButtonNightmode As ToggleButton";
main.mostCurrent._togglebuttonnightmode = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 138;BA.debugLine="Dim WebViewExtender As WebViewXtender";
main.mostCurrent._webviewextender = RemoteObject.createNew ("thalmy.webviewxtended.xtender");
 //BA.debugLineNum = 139;BA.debugLine="Dim WebViewSettings As WebViewSettings";
main.mostCurrent._webviewsettings = RemoteObject.createNew ("uk.co.martinpearman.b4a.webviewsettings.WebViewSettings");
 //BA.debugLineNum = 140;BA.debugLine="Dim webviewextras As WebViewExtras";
main.mostCurrent._webviewextras = RemoteObject.createNew ("uk.co.martinpearman.b4a.webviewextras.WebViewExtras");
 //BA.debugLineNum = 141;BA.debugLine="Private Panel_WebView_ReadingFullScreen_Mode As P";
main.mostCurrent._panel_webview_readingfullscreen_mode = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 142;BA.debugLine="Private Panel_Main_Settings As Panel";
main.mostCurrent._panel_main_settings = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 143;BA.debugLine="Private btn_pannelsettings_reset As Button";
main.mostCurrent._btn_pannelsettings_reset = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 144;BA.debugLine="Private btn_settingspanel_okandhide As Button";
main.mostCurrent._btn_settingspanel_okandhide = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 145;BA.debugLine="Private ToggleButtonIncog As ToggleButton";
main.mostCurrent._togglebuttonincog = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 147;BA.debugLine="Private btn_refreshclose As Button";
main.mostCurrent._btn_refreshclose = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 148;BA.debugLine="Private btn_urlplus As Button";
main.mostCurrent._btn_urlplus = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 149;BA.debugLine="Private btn_runappbackground As Button";
main.mostCurrent._btn_runappbackground = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 151;BA.debugLine="Private ToggleButton_js As ToggleButton";
main.mostCurrent._togglebutton_js = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 152;BA.debugLine="Private ToggleButton_bttrysave As ToggleButton";
main.mostCurrent._togglebutton_bttrysave = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 154;BA.debugLine="Private btn_history_hide As Button";
main.mostCurrent._btn_history_hide = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 155;BA.debugLine="Private ListView_Settings_hostory As ListView";
main.mostCurrent._listview_settings_hostory = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 156;BA.debugLine="Private btn_clearHistory As Button";
main.mostCurrent._btn_clearhistory = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 157;BA.debugLine="Private lbl_applockpagedata As Label";
main.mostCurrent._lbl_applockpagedata = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 159;BA.debugLine="Private ToggleButton_zoomenbl As ToggleButton";
main.mostCurrent._togglebutton_zoomenbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _incog_timer_tick() throws Exception{
try {
		Debug.PushSubsStack("incog_timer_tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,164);
if (RapidSub.canDelegate("incog_timer_tick")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","incog_timer_tick");}
 BA.debugLineNum = 164;BA.debugLine="Sub incog_timer_tick";
Debug.ShouldStop(8);
 BA.debugLineNum = 165;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Fals";
Debug.ShouldStop(16);
main.mostCurrent._webviewsettings.runVoidMethod ("setSaveFormData",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 166;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Fals";
Debug.ShouldStop(32);
main.mostCurrent._webviewsettings.runVoidMethod ("setSavePassword",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 167;BA.debugLine="WebViewSettings.setSaveFormData(WebView_ReadingFu";
Debug.ShouldStop(64);
main.mostCurrent._webviewsettings.runVoidMethod ("setSaveFormData",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 168;BA.debugLine="WebViewSettings.setSavePassword(WebView_ReadingFu";
Debug.ShouldStop(128);
main.mostCurrent._webviewsettings.runVoidMethod ("setSavePassword",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 169;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _listview_settings_hostory_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListView_Settings_hostory_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1164);
if (RapidSub.canDelegate("listview_settings_hostory_itemclick")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","listview_settings_hostory_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 1164;BA.debugLine="Sub ListView_Settings_hostory_ItemClick (Position";
Debug.ShouldStop(2048);
 BA.debugLineNum = 1165;BA.debugLine="ToastMessageShow(\"Long tap to open URL\",True)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Long tap to open URL")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 1166;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _listview_settings_hostory_itemlongclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListView_Settings_hostory_ItemLongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1167);
if (RapidSub.canDelegate("listview_settings_hostory_itemlongclick")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","listview_settings_hostory_itemlongclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 1167;BA.debugLine="Sub ListView_Settings_hostory_ItemLongClick (Posit";
Debug.ShouldStop(16384);
 BA.debugLineNum = 1168;BA.debugLine="main_webview.LoadUrl(Value)";
Debug.ShouldStop(32768);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(BA.ObjectToString(_value)));
 BA.debugLineNum = 1169;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(65536);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1170;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(131072);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1171;BA.debugLine="Panel_Settings_History.Visible=False";
Debug.ShouldStop(262144);
main.mostCurrent._panel_settings_history.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1172;BA.debugLine="Panel_applock_settings.Visible=False";
Debug.ShouldStop(524288);
main.mostCurrent._panel_applock_settings.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1173;BA.debugLine="Panel_Main_Settings.Visible=False";
Debug.ShouldStop(1048576);
main.mostCurrent._panel_main_settings.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1174;BA.debugLine="Button_applock.Visible=True";
Debug.ShouldStop(2097152);
main.mostCurrent._button_applock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1175;BA.debugLine="Button_history.Visible=True";
Debug.ShouldStop(4194304);
main.mostCurrent._button_history.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1176;BA.debugLine="btn_pannelsettings_reset.Visible=True";
Debug.ShouldStop(8388608);
main.mostCurrent._btn_pannelsettings_reset.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1177;BA.debugLine="btn_settingspanel_okandhide.Visible=True";
Debug.ShouldStop(16777216);
main.mostCurrent._btn_settingspanel_okandhide.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1178;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _main_webview_overrideurl(RemoteObject _url) throws Exception{
try {
		Debug.PushSubsStack("main_webview_OverrideUrl (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,997);
if (RapidSub.canDelegate("main_webview_overrideurl")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","main_webview_overrideurl", _url);}
Debug.locals.put("Url", _url);
 BA.debugLineNum = 997;BA.debugLine="Sub main_webview_OverrideUrl (Url As String) As Bo";
Debug.ShouldStop(16);
 BA.debugLineNum = 998;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(32);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 999;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(64);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1010;BA.debugLine="If Url.StartsWith(\"http://\") Or Url.StartsWith(\"h";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(".",_url.runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("http://")))) || RemoteObject.solveBoolean(".",_url.runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("https://"))))) { 
 BA.debugLineNum = 1011;BA.debugLine="textbox_download_url.Text=Url";
Debug.ShouldStop(262144);
main.mostCurrent._textbox_download_url.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_url));
 };
 BA.debugLineNum = 1016;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _main_webview_pagefinished(RemoteObject _url) throws Exception{
try {
		Debug.PushSubsStack("main_webview_PageFinished (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1017);
if (RapidSub.canDelegate("main_webview_pagefinished")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","main_webview_pagefinished", _url);}
Debug.locals.put("Url", _url);
 BA.debugLineNum = 1017;BA.debugLine="Sub main_webview_PageFinished (Url As String)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 1018;BA.debugLine="Try";
Debug.ShouldStop(33554432);
try { BA.debugLineNum = 1019;BA.debugLine="textbox_search_bar.Text=main_webview.Url";
Debug.ShouldStop(67108864);
main.mostCurrent._textbox_search_bar.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._main_webview.runMethod(true,"getUrl")));
 BA.debugLineNum = 1020;BA.debugLine="textbox_search_bar.Hint=WebViewExtender.getTitle(";
Debug.ShouldStop(134217728);
main.mostCurrent._textbox_search_bar.runMethod(true,"setHint",main.mostCurrent._webviewextender.runMethod(true,"getTitle",(Object)((main.mostCurrent._main_webview.getObject()))));
 BA.debugLineNum = 1021;BA.debugLine="btn_refreshclose.Visible=False";
Debug.ShouldStop(268435456);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1022;BA.debugLine="btn_refresh.Visible=True";
Debug.ShouldStop(536870912);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1023;BA.debugLine="If main_webview.Url.StartsWith(\"file:///\") Then";
Debug.ShouldStop(1073741824);
if (main.mostCurrent._main_webview.runMethod(true,"getUrl").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("file:///"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1024;BA.debugLine="textbox_search_bar.Hint=\"Welcome to Frigate Brow";
Debug.ShouldStop(-2147483648);
main.mostCurrent._textbox_search_bar.runMethod(true,"setHint",BA.ObjectToString("Welcome to Frigate Browser Premium"));
 BA.debugLineNum = 1025;BA.debugLine="textbox_search_bar.Text=\"\"";
Debug.ShouldStop(1);
main.mostCurrent._textbox_search_bar.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e11.toString()); BA.debugLineNum = 1028;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("LogImpl","83997707",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 1031;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 1032;BA.debugLine="ListView_Settings_hostory.AddSingleLine( main_we";
Debug.ShouldStop(128);
main.mostCurrent._listview_settings_hostory.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(main.mostCurrent._main_webview.runMethod(true,"getUrl"))));
 BA.debugLineNum = 1033;BA.debugLine="File.WriteList(File.DirDefaultExternal,\"history.";
Debug.ShouldStop(256);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("history.txt")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), main.mostCurrent._listview_settings_hostory.getObject()));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e17) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e17.toString()); BA.debugLineNum = 1035;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("LogImpl","83997714",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 1038;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_back() throws Exception{
try {
		Debug.PushSubsStack("page_back (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,994);
if (RapidSub.canDelegate("page_back")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","page_back");}
 BA.debugLineNum = 994;BA.debugLine="Sub page_back";
Debug.ShouldStop(2);
 BA.debugLineNum = 995;BA.debugLine="main_webview.Back";
Debug.ShouldStop(4);
main.mostCurrent._main_webview.runVoidMethod ("Back");
 BA.debugLineNum = 996;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
downloaderservice_subs_0._process_globals();
utils_subs_0._process_globals();
statemanager_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("com.clenontec.webbrowser.main");
starter.myClass = BA.getDeviceClass ("com.clenontec.webbrowser.starter");
fileprovider.myClass = BA.getDeviceClass ("com.clenontec.webbrowser.fileprovider");
downloaderservice.myClass = BA.getDeviceClass ("com.clenontec.webbrowser.downloaderservice");
utils.myClass = BA.getDeviceClass ("com.clenontec.webbrowser.utils");
statemanager.myClass = BA.getDeviceClass ("com.clenontec.webbrowser.statemanager");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private cc As ContentChooser";
main._cc = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _run_incog_timer_tick() throws Exception{
try {
		Debug.PushSubsStack("run_incog_timer_tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,170);
if (RapidSub.canDelegate("run_incog_timer_tick")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","run_incog_timer_tick");}
 BA.debugLineNum = 170;BA.debugLine="Sub run_incog_timer_tick";
Debug.ShouldStop(512);
 BA.debugLineNum = 171;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Fals";
Debug.ShouldStop(1024);
main.mostCurrent._webviewsettings.runVoidMethod ("setSaveFormData",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 172;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Fals";
Debug.ShouldStop(2048);
main.mostCurrent._webviewsettings.runVoidMethod ("setSavePassword",(Object)((main.mostCurrent._main_webview.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 173;BA.debugLine="WebViewSettings.setSaveFormData(WebView_ReadingFu";
Debug.ShouldStop(4096);
main.mostCurrent._webviewsettings.runVoidMethod ("setSaveFormData",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 174;BA.debugLine="WebViewSettings.setSavePassword(WebView_ReadingFu";
Debug.ShouldStop(8192);
main.mostCurrent._webviewsettings.runVoidMethod ("setSavePassword",(Object)((main.mostCurrent._webview_readingfullscreen_mode.getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _showfile_chooser(RemoteObject _filepathcallback,RemoteObject _filechooserparams) throws Exception{
try {
		Debug.PushSubsStack("ShowFile_Chooser (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,418);
if (RapidSub.canDelegate("showfile_chooser")) { com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","showfile_chooser", _filepathcallback, _filechooserparams); return;}
ResumableSub_ShowFile_Chooser rsub = new ResumableSub_ShowFile_Chooser(null,_filepathcallback,_filechooserparams);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ShowFile_Chooser extends BA.ResumableSub {
public ResumableSub_ShowFile_Chooser(com.clenontec.webbrowser.main parent,RemoteObject _filepathcallback,RemoteObject _filechooserparams) {
this.parent = parent;
this._filepathcallback = _filepathcallback;
this._filechooserparams = _filechooserparams;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.clenontec.webbrowser.main parent;
RemoteObject _filepathcallback;
RemoteObject _filechooserparams;
RemoteObject _success = RemoteObject.createImmutable(false);
RemoteObject _dir = RemoteObject.createImmutable("");
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ShowFile_Chooser (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,418);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("FilePathCallback", _filepathcallback);
Debug.locals.put("FileChooserParams", _filechooserparams);
 BA.debugLineNum = 419;BA.debugLine="cc.Initialize(\"CC\")";
Debug.ShouldStop(4);
parent._cc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CC")));
 BA.debugLineNum = 420;BA.debugLine="cc.Show(\"*/*\", \"Choose File\")";
Debug.ShouldStop(8);
parent._cc.runVoidMethod ("Show",main.processBA,(Object)(BA.ObjectToString("*/*")),(Object)(RemoteObject.createImmutable("Choose File")));
 BA.debugLineNum = 421;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","cc_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "showfile_chooser"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
_dir = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Dir", _dir);
_filename = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(2));Debug.locals.put("FileName", _filename);
;
 BA.debugLineNum = 422;BA.debugLine="Dim jo As JavaObject = Me";
Debug.ShouldStop(32);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(main.getObject());Debug.locals.put("jo", _jo);
 BA.debugLineNum = 423;BA.debugLine="If Success Then";
Debug.ShouldStop(64);
if (true) break;

case 1:
//if
this.state = 6;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 424;BA.debugLine="Log(FileName)";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","8458758",_filename,0);
 BA.debugLineNum = 425;BA.debugLine="File.Copy(Dir, FileName, Starter.Provider.SharedF";
Debug.ShouldStop(256);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_dir),(Object)(_filename),(Object)(parent.mostCurrent._starter._provider /*RemoteObject*/ .getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(RemoteObject.createImmutable("TempFile")));
 BA.debugLineNum = 426;BA.debugLine="jo.RunMethod(\"SendResult\", Array(Starter.Provide";
Debug.ShouldStop(512);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("SendResult")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {parent.mostCurrent._starter._provider /*RemoteObject*/ .runClassMethod (com.clenontec.webbrowser.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("TempFile"))),_filepathcallback})));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 428;BA.debugLine="jo.RunMethod(\"SendResult\", Array(Null, FilePathC";
Debug.ShouldStop(2048);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("SendResult")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {parent.mostCurrent.__c.getField(false,"Null"),_filepathcallback})));
 if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 430;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _cc_result(RemoteObject _success,RemoteObject _dir,RemoteObject _filename) throws Exception{
}
public static RemoteObject  _textbox_search_bar_enterpressed() throws Exception{
try {
		Debug.PushSubsStack("textbox_search_bar_EnterPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,917);
if (RapidSub.canDelegate("textbox_search_bar_enterpressed")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","textbox_search_bar_enterpressed");}
 BA.debugLineNum = 917;BA.debugLine="Sub textbox_search_bar_EnterPressed";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 918;BA.debugLine="btn_refreshclose.Visible=True";
Debug.ShouldStop(2097152);
main.mostCurrent._btn_refreshclose.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 919;BA.debugLine="btn_refresh.Visible=False";
Debug.ShouldStop(4194304);
main.mostCurrent._btn_refresh.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 923;BA.debugLine="If main_webview.Url.StartsWith(\"http://\")  Then";
Debug.ShouldStop(67108864);
if (main.mostCurrent._main_webview.runMethod(true,"getUrl").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("http://"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 924;BA.debugLine="main_webview.LoadURL(textbox_search_bar.Text)";
Debug.ShouldStop(134217728);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(main.mostCurrent._textbox_search_bar.runMethod(true,"getText")));
 }else {
 BA.debugLineNum = 926;BA.debugLine="If main_webview.Url.StartsWith(\"https://\")  Then";
Debug.ShouldStop(536870912);
if (main.mostCurrent._main_webview.runMethod(true,"getUrl").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("https://"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 927;BA.debugLine="main_webview.LoadURL(textbox_search_bar.Text)";
Debug.ShouldStop(1073741824);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(main.mostCurrent._textbox_search_bar.runMethod(true,"getText")));
 }else {
 BA.debugLineNum = 929;BA.debugLine="main_webview.LoadUrl(\"http://www.google.com/#q=";
Debug.ShouldStop(1);
main.mostCurrent._main_webview.runVoidMethod ("LoadUrl",(Object)(RemoteObject.concat(RemoteObject.createImmutable("http://www.google.com/#q="),main.mostCurrent._textbox_search_bar.runMethod(true,"getText"))));
 };
 };
 BA.debugLineNum = 935;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtbox_applock_text_enterpressed() throws Exception{
try {
		Debug.PushSubsStack("Txtbox_applock_text_EnterPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1201);
if (RapidSub.canDelegate("txtbox_applock_text_enterpressed")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","txtbox_applock_text_enterpressed");}
 BA.debugLineNum = 1201;BA.debugLine="Sub Txtbox_applock_text_EnterPressed";
Debug.ShouldStop(65536);
 BA.debugLineNum = 1202;BA.debugLine="If Txtbox_applock_text.Text=File.ReadString(File.";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",main.mostCurrent._txtbox_applock_text.runMethod(true,"getText"),main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("pscode.txt"))))) { 
 BA.debugLineNum = 1203;BA.debugLine="Panel_App_Lock.Visible=False";
Debug.ShouldStop(262144);
main.mostCurrent._panel_app_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 1205;BA.debugLine="Txtbox_applock_text.Text=\"\"";
Debug.ShouldStop(1048576);
main.mostCurrent._txtbox_applock_text.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 1206;BA.debugLine="Txtbox_applock_text.Hint=\"Please try again !\"";
Debug.ShouldStop(2097152);
main.mostCurrent._txtbox_applock_text.runMethod(true,"setHint",BA.ObjectToString("Please try again !"));
 };
 BA.debugLineNum = 1208;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtbox_applock_text_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("Txtbox_applock_text_TextChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1239);
if (RapidSub.canDelegate("txtbox_applock_text_textchanged")) { return com.clenontec.webbrowser.main.remoteMe.runUserSub(false, "main","txtbox_applock_text_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 1239;BA.debugLine="Sub Txtbox_applock_text_TextChanged (Old As String";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 1240;BA.debugLine="If Txtbox_applock_text.Text=File.ReadString(File.";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",main.mostCurrent._txtbox_applock_text.runMethod(true,"getText"),main.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("pscode.txt"))))) { 
 BA.debugLineNum = 1241;BA.debugLine="Panel_App_Lock.Visible=False";
Debug.ShouldStop(16777216);
main.mostCurrent._panel_app_lock.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 1243;BA.debugLine="Txtbox_applock_text.Text=\"\"";
Debug.ShouldStop(67108864);
main.mostCurrent._txtbox_applock_text.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 1244;BA.debugLine="Txtbox_applock_text.Hint=\"Please try again !\"";
Debug.ShouldStop(134217728);
main.mostCurrent._txtbox_applock_text.runMethod(true,"setHint",BA.ObjectToString("Please try again !"));
 };
 BA.debugLineNum = 1246;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}