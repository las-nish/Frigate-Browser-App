package com.clenontec.webbrowser;

import android.webkit.*;
import android.webkit.WebChromeClient.*;
import android.net.*;

import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "com.clenontec.webbrowser", "com.clenontec.webbrowser.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "com.clenontec.webbrowser", "com.clenontec.webbrowser.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.clenontec.webbrowser.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, downloaderservice.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
public anywheresoftware.b4a.objects.WebViewWrapper _main_webview = null;
public anywheresoftware.b4a.objects.PanelWrapper _main_panel = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_navigation_bar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_drawer = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_home = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_fowrd = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_back = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_search_bar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_search = null;
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _textbox_search_bar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_refresh = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_drawer = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_appexit = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_shareapp = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_helpguide = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_appsettingsmore = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_readingfullscreenmode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_darkmode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_downloader = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_shareweburl = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_imagedisable = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_openweblinkanotherbrowser = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_screenshot = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_intergrton = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_clearalldataapp = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_batterysaver = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_jsdisable = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_zoomenabled = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_intergration = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_extrasites = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_panel_intergration_hide = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_soundcloud = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_youtube = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_snpcht = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_telgrm = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_rddit = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_pintrst = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_lnkdin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_twttr = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_fb = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_instr = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_ytgames = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_quora = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_downloader = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_hidedownloadpanel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_startdownload = null;
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _textbox_download_filename = null;
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _textbox_download_url = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_paneldownload_head = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_downloader_header_color = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _btn_downloadbooster_panel = null;
public anywheresoftware.b4a.objects.WebViewWrapper _webview_readingfullscreen_mode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_fullscreenreadingmode_exit = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_fullscreen_fowrd = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_fullscreen_back = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button_applock = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button_exportdata = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_searchengine = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radiobutton_google = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radiobutton_duck = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_sitesecurity = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _checkbox_savepass = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _checkbox_dnt = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_sitesetting = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _checkbox_js = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _checkbox_boostmode = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _checkbox_cookie = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radiobutton_bing = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radiobutton_yahoo = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _checkbox_safesearch = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_applock_settings = null;
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _textbox_applock_password_set = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_passcodelock = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_passcode_info = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _checkbox_applock_enable = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_applocksave = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_password_panelhide = null;
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _textbox_retype_passcodepleteedittext1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button_history = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_settings_history = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_app_lock = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_applock_hint = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview_applocker = null;
public anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper _txtbox_applock_text = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebutton_drawer = null;
public uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager _downloadmanager1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_hide_buttons = null;
public anywheresoftware.b4a.objects.RuntimePermissions _rpa = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebutton_imagedisable = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebuttonnightmode = null;
public thalmy.webviewxtended.xtender _webviewextender = null;
public uk.co.martinpearman.b4a.webviewsettings.WebViewSettings _webviewsettings = null;
public uk.co.martinpearman.b4a.webviewextras.WebViewExtras _webviewextras = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_webview_readingfullscreen_mode = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_main_settings = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_pannelsettings_reset = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_settingspanel_okandhide = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebuttonincog = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_refreshclose = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_urlplus = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_runappbackground = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebutton_js = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebutton_bttrysave = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_history_hide = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listview_settings_hostory = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btn_clearhistory = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_applockpagedata = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebutton_zoomenbl = null;
public com.clenontec.webbrowser.starter _starter = null;
public com.clenontec.webbrowser.downloaderservice _downloaderservice = null;
public com.clenontec.webbrowser.utils _utils = null;
public com.clenontec.webbrowser.statemanager _statemanager = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4j.object.JavaObject _client = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Main_Layout\")";
mostCurrent._activity.LoadLayout("Main_Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Txtbox_applock_text.Color=Colors.Transparent";
mostCurrent._txtbox_applock_text.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/welco";
mostCurrent._main_webview.LoadUrl("file:///android_asset/welcome.html");
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Try";
try {RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"psco";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"pscodecheck.txt")).equals("1")) { 
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="Panel_App_Lock.BringToFront";
mostCurrent._panel_app_lock.BringToFront();
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Panel_App_Lock.Visible=True";
mostCurrent._panel_app_lock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="CheckBox_applock_enable.Checked=True";
mostCurrent._checkbox_applock_enable.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="Panel_App_Lock.Visible=False";
mostCurrent._panel_app_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="CheckBox_applock_enable.Checked=False";
mostCurrent._checkbox_applock_enable.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"goog";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"google.txt")).equals("1")) { 
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="RadioButton_google.Checked=True";
mostCurrent._radiobutton_google.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="RadioButton_google.Checked=False";
mostCurrent._radiobutton_google.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"duck";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"duck.txt")).equals("1")) { 
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="RadioButton_duck.Checked=True";
mostCurrent._radiobutton_duck.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="RadioButton_duck.Checked=False";
mostCurrent._radiobutton_duck.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"bing";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"bing.txt")).equals("1")) { 
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="RadioButton_bing.Checked=True";
mostCurrent._radiobutton_bing.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="RadioButton_bing.Checked=False";
mostCurrent._radiobutton_bing.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131107;
 //BA.debugLineNum = 131107;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"yaho";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"yahoo.txt")).equals("1")) { 
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="RadioButton_yahoo.Checked=True";
mostCurrent._radiobutton_yahoo.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131110;
 //BA.debugLineNum = 131110;BA.debugLine="RadioButton_yahoo.Checked=False";
mostCurrent._radiobutton_yahoo.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131113;
 //BA.debugLineNum = 131113;BA.debugLine="Try";
try {RDebugUtils.currentLine=131115;
 //BA.debugLineNum = 131115;BA.debugLine="If RadioButton_google.Checked=True Then";
if (mostCurrent._radiobutton_google.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=131116;
 //BA.debugLineNum = 131116;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/goo";
mostCurrent._main_webview.LoadUrl("file:///android_asset/google.html");
 };
RDebugUtils.currentLine=131118;
 //BA.debugLineNum = 131118;BA.debugLine="If RadioButton_duck.Checked=True Then";
if (mostCurrent._radiobutton_duck.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=131119;
 //BA.debugLineNum = 131119;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/duc";
mostCurrent._main_webview.LoadUrl("file:///android_asset/duck.html");
 };
RDebugUtils.currentLine=131121;
 //BA.debugLineNum = 131121;BA.debugLine="If RadioButton_bing.Checked=True Then";
if (mostCurrent._radiobutton_bing.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=131122;
 //BA.debugLineNum = 131122;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/bin";
mostCurrent._main_webview.LoadUrl("file:///android_asset/bing.html");
 };
RDebugUtils.currentLine=131124;
 //BA.debugLineNum = 131124;BA.debugLine="If RadioButton_yahoo.Checked=True Then";
if (mostCurrent._radiobutton_yahoo.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=131125;
 //BA.debugLineNum = 131125;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/yah";
mostCurrent._main_webview.LoadUrl("file:///android_asset/yahoo.html");
 };
 } 
       catch (Exception e47) {
			processBA.setLastException(e47);RDebugUtils.currentLine=131128;
 //BA.debugLineNum = 131128;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("8131128",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=131129;
 //BA.debugLineNum = 131129;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/goo";
mostCurrent._main_webview.LoadUrl("file:///android_asset/google.html");
 };
RDebugUtils.currentLine=131133;
 //BA.debugLineNum = 131133;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"save";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"savepass.txt")).equals("1")) { 
RDebugUtils.currentLine=131134;
 //BA.debugLineNum = 131134;BA.debugLine="CheckBox_savepass.Checked=True";
mostCurrent._checkbox_savepass.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131135;
 //BA.debugLineNum = 131135;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Tr";
mostCurrent._webviewsettings.setSaveFormData((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131136;
 //BA.debugLineNum = 131136;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Tr";
mostCurrent._webviewsettings.setSavePassword((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131137;
 //BA.debugLineNum = 131137;BA.debugLine="WebViewSettings.setSaveFormData(WebView_Reading";
mostCurrent._webviewsettings.setSaveFormData((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131138;
 //BA.debugLineNum = 131138;BA.debugLine="WebViewSettings.setSavePassword(WebView_Reading";
mostCurrent._webviewsettings.setSavePassword((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131140;
 //BA.debugLineNum = 131140;BA.debugLine="CheckBox_savepass.Checked=False";
mostCurrent._checkbox_savepass.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131141;
 //BA.debugLineNum = 131141;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Fa";
mostCurrent._webviewsettings.setSaveFormData((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131142;
 //BA.debugLineNum = 131142;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Fa";
mostCurrent._webviewsettings.setSavePassword((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131143;
 //BA.debugLineNum = 131143;BA.debugLine="WebViewSettings.setSaveFormData(WebView_Reading";
mostCurrent._webviewsettings.setSaveFormData((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131144;
 //BA.debugLineNum = 131144;BA.debugLine="WebViewSettings.setSavePassword(WebView_Reading";
mostCurrent._webviewsettings.setSavePassword((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131147;
 //BA.debugLineNum = 131147;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"dnt.";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"dnt.txt")).equals("1")) { 
RDebugUtils.currentLine=131148;
 //BA.debugLineNum = 131148;BA.debugLine="CheckBox_dnt.Checked=True";
mostCurrent._checkbox_dnt.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131150;
 //BA.debugLineNum = 131150;BA.debugLine="CheckBox_dnt.Checked=False";
mostCurrent._checkbox_dnt.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131153;
 //BA.debugLineNum = 131153;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"js.t";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"js.txt")).equals("1")) { 
RDebugUtils.currentLine=131154;
 //BA.debugLineNum = 131154;BA.debugLine="CheckBox_js.Checked=True";
mostCurrent._checkbox_js.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131155;
 //BA.debugLineNum = 131155;BA.debugLine="main_webview.JavaScriptEnabled=True";
mostCurrent._main_webview.setJavaScriptEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131156;
 //BA.debugLineNum = 131156;BA.debugLine="WebView_ReadingFullScreen_Mode.JavaScriptEnable";
mostCurrent._webview_readingfullscreen_mode.setJavaScriptEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131157;
 //BA.debugLineNum = 131157;BA.debugLine="WebViewSettings.setJavaScriptCanOpenWindowsAuto";
mostCurrent._webviewsettings.setJavaScriptCanOpenWindowsAutomatically((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131158;
 //BA.debugLineNum = 131158;BA.debugLine="WebViewSettings.setJavaScriptCanOpenWindowsAuto";
mostCurrent._webviewsettings.setJavaScriptCanOpenWindowsAutomatically((android.webkit.WebView)(mostCurrent._panel_webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131160;
 //BA.debugLineNum = 131160;BA.debugLine="CheckBox_js.Checked=False";
mostCurrent._checkbox_js.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131161;
 //BA.debugLineNum = 131161;BA.debugLine="main_webview.JavaScriptEnabled=False";
mostCurrent._main_webview.setJavaScriptEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131162;
 //BA.debugLineNum = 131162;BA.debugLine="WebViewSettings.setJavaScriptCanOpenWindowsAuto";
mostCurrent._webviewsettings.setJavaScriptCanOpenWindowsAutomatically((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131163;
 //BA.debugLineNum = 131163;BA.debugLine="WebViewSettings.setJavaScriptCanOpenWindowsAuto";
mostCurrent._webviewsettings.setJavaScriptCanOpenWindowsAutomatically((android.webkit.WebView)(mostCurrent._panel_webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131164;
 //BA.debugLineNum = 131164;BA.debugLine="WebView_ReadingFullScreen_Mode.JavaScriptEnable";
mostCurrent._webview_readingfullscreen_mode.setJavaScriptEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131167;
 //BA.debugLineNum = 131167;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"boos";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"boostr.txt")).equals("1")) { 
RDebugUtils.currentLine=131168;
 //BA.debugLineNum = 131168;BA.debugLine="CheckBox_boostmode.Checked=True";
mostCurrent._checkbox_boostmode.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131170;
 //BA.debugLineNum = 131170;BA.debugLine="CheckBox_boostmode.Checked=False";
mostCurrent._checkbox_boostmode.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131173;
 //BA.debugLineNum = 131173;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"cook";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"cookie.txt")).equals("1")) { 
RDebugUtils.currentLine=131174;
 //BA.debugLineNum = 131174;BA.debugLine="CheckBox_cookie.Checked=True";
mostCurrent._checkbox_cookie.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131175;
 //BA.debugLineNum = 131175;BA.debugLine="WebViewExtender.getAcceptCookie(main_webview)";
mostCurrent._webviewextender.getAcceptCookie((android.webkit.WebView)(mostCurrent._main_webview.getObject()));
RDebugUtils.currentLine=131176;
 //BA.debugLineNum = 131176;BA.debugLine="WebViewExtender.getAcceptCookie(WebView_Reading";
mostCurrent._webviewextender.getAcceptCookie((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()));
 }else {
RDebugUtils.currentLine=131178;
 //BA.debugLineNum = 131178;BA.debugLine="CheckBox_cookie.Checked=False";
mostCurrent._checkbox_cookie.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131181;
 //BA.debugLineNum = 131181;BA.debugLine="If File.ReadString(File.DirDefaultExternal,\"sfse";
if ((anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"sfsearch.txt")).equals("1")) { 
RDebugUtils.currentLine=131182;
 //BA.debugLineNum = 131182;BA.debugLine="CheckBox_safesearch.Checked=True";
mostCurrent._checkbox_safesearch.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=131184;
 //BA.debugLineNum = 131184;BA.debugLine="CheckBox_safesearch.Checked=False";
mostCurrent._checkbox_safesearch.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 } 
       catch (Exception e99) {
			processBA.setLastException(e99);RDebugUtils.currentLine=131190;
 //BA.debugLineNum = 131190;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("8131190",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=131193;
 //BA.debugLineNum = 131193;BA.debugLine="Try";
try {RDebugUtils.currentLine=131194;
 //BA.debugLineNum = 131194;BA.debugLine="If File.Exists(File.DirDefaultExternal,\"history.";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"history.txt")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=131195;
 //BA.debugLineNum = 131195;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"histo";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"history.txt","");
 }else {
 };
 } 
       catch (Exception e107) {
			processBA.setLastException(e107);RDebugUtils.currentLine=131200;
 //BA.debugLineNum = 131200;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("8131200",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=131204;
 //BA.debugLineNum = 131204;BA.debugLine="webviewextras.addWebChromeClient(main_webview,Tru";
mostCurrent._webviewextras.addWebChromeClient(mostCurrent.activityBA,(android.webkit.WebView)(mostCurrent._main_webview.getObject()),BA.ObjectToString(anywheresoftware.b4a.keywords.Common.True));
RDebugUtils.currentLine=131206;
 //BA.debugLineNum = 131206;BA.debugLine="ListView_Settings_hostory.FastScrollEnabled=True";
mostCurrent._listview_settings_hostory.setFastScrollEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131214;
 //BA.debugLineNum = 131214;BA.debugLine="Dim client As JavaObject";
_client = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=131215;
 //BA.debugLineNum = 131215;BA.debugLine="client.InitializeNewInstance(Application.PackageN";
_client.InitializeNewInstance(anywheresoftware.b4a.keywords.Common.Application.getPackageName()+".main$MyChromeClient",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=131216;
 //BA.debugLineNum = 131216;BA.debugLine="Dim jo As JavaObject = main_webview";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(mostCurrent._main_webview.getObject()));
RDebugUtils.currentLine=131217;
 //BA.debugLineNum = 131217;BA.debugLine="jo.RunMethod(\"setWebChromeClient\", Array(client))";
_jo.RunMethod("setWebChromeClient",new Object[]{(Object)(_client.getObject())});
RDebugUtils.currentLine=131220;
 //BA.debugLineNum = 131220;BA.debugLine="main_webview.Color=Colors.Transparent";
mostCurrent._main_webview.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131221;
 //BA.debugLineNum = 131221;BA.debugLine="WebView_ReadingFullScreen_Mode.Color=Colors.Trans";
mostCurrent._webview_readingfullscreen_mode.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131223;
 //BA.debugLineNum = 131223;BA.debugLine="btn_batterysaver.Color=Colors.Transparent";
mostCurrent._btn_batterysaver.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131224;
 //BA.debugLineNum = 131224;BA.debugLine="btn_jsdisable.Color=Colors.Transparent";
mostCurrent._btn_jsdisable.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131225;
 //BA.debugLineNum = 131225;BA.debugLine="btn_ytgames.Color=Colors.Transparent";
mostCurrent._btn_ytgames.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131226;
 //BA.debugLineNum = 131226;BA.debugLine="btn_quora.Color=Colors.Transparent";
mostCurrent._btn_quora.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131227;
 //BA.debugLineNum = 131227;BA.debugLine="btn_zoomenabled.Color=Colors.Transparent";
mostCurrent._btn_zoomenabled.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131228;
 //BA.debugLineNum = 131228;BA.debugLine="btn_fullscreenreadingmode_exit.Color=Colors.Trans";
mostCurrent._btn_fullscreenreadingmode_exit.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131229;
 //BA.debugLineNum = 131229;BA.debugLine="btn_refreshclose.Color=Colors.Transparent";
mostCurrent._btn_refreshclose.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131230;
 //BA.debugLineNum = 131230;BA.debugLine="btn_fullscreen_fowrd.Color=Colors.Transparent";
mostCurrent._btn_fullscreen_fowrd.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131231;
 //BA.debugLineNum = 131231;BA.debugLine="btn_fullscreen_back.Color=Colors.Transparent";
mostCurrent._btn_fullscreen_back.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131232;
 //BA.debugLineNum = 131232;BA.debugLine="btn_appexit.Color=Colors.Transparent";
mostCurrent._btn_appexit.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131233;
 //BA.debugLineNum = 131233;BA.debugLine="btn_runappbackground.Color=Colors.Transparent";
mostCurrent._btn_runappbackground.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131234;
 //BA.debugLineNum = 131234;BA.debugLine="btn_urlplus.Color=Colors.Transparent";
mostCurrent._btn_urlplus.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131235;
 //BA.debugLineNum = 131235;BA.debugLine="btn_appsettingsmore.Color=Colors.Transparent";
mostCurrent._btn_appsettingsmore.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131236;
 //BA.debugLineNum = 131236;BA.debugLine="btn_back.Color=Colors.Transparent";
mostCurrent._btn_back.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131237;
 //BA.debugLineNum = 131237;BA.debugLine="btn_darkmode.Color=Colors.Transparent";
mostCurrent._btn_darkmode.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131238;
 //BA.debugLineNum = 131238;BA.debugLine="btn_downloader.Color=Colors.Transparent";
mostCurrent._btn_downloader.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131239;
 //BA.debugLineNum = 131239;BA.debugLine="btn_drawer.Color=Colors.Transparent";
mostCurrent._btn_drawer.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131240;
 //BA.debugLineNum = 131240;BA.debugLine="btn_extrasites.Color=Colors.Transparent";
mostCurrent._btn_extrasites.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131241;
 //BA.debugLineNum = 131241;BA.debugLine="btn_fb.Color=Colors.Transparent";
mostCurrent._btn_fb.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131242;
 //BA.debugLineNum = 131242;BA.debugLine="btn_fowrd.Color=Colors.Transparent";
mostCurrent._btn_fowrd.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131243;
 //BA.debugLineNum = 131243;BA.debugLine="btn_helpguide.Color=Colors.Transparent";
mostCurrent._btn_helpguide.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131244;
 //BA.debugLineNum = 131244;BA.debugLine="btn_hidedownloadpanel.Color=Colors.Transparent";
mostCurrent._btn_hidedownloadpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131245;
 //BA.debugLineNum = 131245;BA.debugLine="btn_home.Color=Colors.Transparent";
mostCurrent._btn_home.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131246;
 //BA.debugLineNum = 131246;BA.debugLine="btn_imagedisable.Color=Colors.Transparent";
mostCurrent._btn_imagedisable.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131247;
 //BA.debugLineNum = 131247;BA.debugLine="btn_instr.Color=Colors.Transparent";
mostCurrent._btn_instr.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131248;
 //BA.debugLineNum = 131248;BA.debugLine="btn_intergrton.Color=Colors.Transparent";
mostCurrent._btn_intergrton.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131249;
 //BA.debugLineNum = 131249;BA.debugLine="btn_lnkdin.Color=Colors.Transparent";
mostCurrent._btn_lnkdin.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131250;
 //BA.debugLineNum = 131250;BA.debugLine="btn_openweblinkanotherbrowser.Color=Colors.Transp";
mostCurrent._btn_openweblinkanotherbrowser.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131251;
 //BA.debugLineNum = 131251;BA.debugLine="btn_panel_intergration_hide.Color=Colors.Transpar";
mostCurrent._btn_panel_intergration_hide.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131252;
 //BA.debugLineNum = 131252;BA.debugLine="btn_pintrst.Color=Colors.Transparent";
mostCurrent._btn_pintrst.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131253;
 //BA.debugLineNum = 131253;BA.debugLine="btn_rddit.Color=Colors.Transparent";
mostCurrent._btn_rddit.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131254;
 //BA.debugLineNum = 131254;BA.debugLine="btn_readingfullscreenmode.Color=Colors.Transparen";
mostCurrent._btn_readingfullscreenmode.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131255;
 //BA.debugLineNum = 131255;BA.debugLine="btn_refresh.Color=Colors.Transparent";
mostCurrent._btn_refresh.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131256;
 //BA.debugLineNum = 131256;BA.debugLine="btn_screenshot.Color=Colors.Transparent";
mostCurrent._btn_screenshot.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131257;
 //BA.debugLineNum = 131257;BA.debugLine="btn_search.Color=Colors.Transparent";
mostCurrent._btn_search.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131258;
 //BA.debugLineNum = 131258;BA.debugLine="btn_shareapp.Color=Colors.Transparent";
mostCurrent._btn_shareapp.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131259;
 //BA.debugLineNum = 131259;BA.debugLine="btn_shareweburl.Color=Colors.Transparent";
mostCurrent._btn_shareweburl.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131260;
 //BA.debugLineNum = 131260;BA.debugLine="btn_snpcht.Color=Colors.Transparent";
mostCurrent._btn_snpcht.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131261;
 //BA.debugLineNum = 131261;BA.debugLine="btn_soundcloud.Color=Colors.Transparent";
mostCurrent._btn_soundcloud.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131262;
 //BA.debugLineNum = 131262;BA.debugLine="btn_startdownload.Color=Colors.Transparent";
mostCurrent._btn_startdownload.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131263;
 //BA.debugLineNum = 131263;BA.debugLine="btn_telgrm.Color=Colors.Transparent";
mostCurrent._btn_telgrm.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131264;
 //BA.debugLineNum = 131264;BA.debugLine="btn_twttr.Color=Colors.Transparent";
mostCurrent._btn_twttr.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131265;
 //BA.debugLineNum = 131265;BA.debugLine="btn_youtube.Color=Colors.Transparent";
mostCurrent._btn_youtube.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131266;
 //BA.debugLineNum = 131266;BA.debugLine="btn_clearalldataapp.Color=Colors.Transparent";
mostCurrent._btn_clearalldataapp.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131268;
 //BA.debugLineNum = 131268;BA.debugLine="textbox_download_filename.Color=Colors.Transparen";
mostCurrent._textbox_download_filename.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131269;
 //BA.debugLineNum = 131269;BA.debugLine="textbox_download_url.Color=Colors.Transparent";
mostCurrent._textbox_download_url.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131270;
 //BA.debugLineNum = 131270;BA.debugLine="textbox_search_bar.Color=Colors.Transparent";
mostCurrent._textbox_search_bar.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131272;
 //BA.debugLineNum = 131272;BA.debugLine="lbl_paneldownload_head.Color=Colors.Transparent";
mostCurrent._lbl_paneldownload_head.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=131276;
 //BA.debugLineNum = 131276;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub activity_KeyPress(KeyCode As Int) As Boolean";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Select KeyCode";
switch (BA.switchObjectToInt(_keycode,anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK)) {
case 0: {
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="page_back";
_page_back();
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 break; }
}
;
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="End Sub";
return false;
}
public static String  _page_back() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "page_back", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "page_back", null));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub page_back";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="main_webview.Back";
mostCurrent._main_webview.Back();
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262156;
 //BA.debugLineNum = 262156;BA.debugLine="End Sub";
return "";
}
public static void  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {Debug.delegate(mostCurrent.activityBA, "activity_resume", null); return;}
ResumableSub_Activity_Resume rsub = new ResumableSub_Activity_Resume(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Resume extends BA.ResumableSub {
public ResumableSub_Activity_Resume(com.clenontec.webbrowser.main parent) {
this.parent = parent;
}
com.clenontec.webbrowser.main parent;
String _permission = "";
boolean _result = false;
Object[] group2;
int index2;
int groupLen2;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Try";
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
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="For Each permission As String In Array(rpa.PERMI";
if (true) break;

case 4:
//for
this.state = 11;
group2 = new Object[]{(Object)(parent.mostCurrent._rpa.PERMISSION_READ_EXTERNAL_STORAGE),(Object)(parent.mostCurrent._rpa.PERMISSION_WRITE_EXTERNAL_STORAGE)};
index2 = 0;
groupLen2 = group2.length;
this.state = 15;
if (true) break;

case 15:
//C
this.state = 11;
if (index2 < groupLen2) {
this.state = 6;
_permission = BA.ObjectToString(group2[index2]);}
if (true) break;

case 16:
//C
this.state = 15;
index2++;
if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="rpa.CheckAndRequest(permission)";
parent.mostCurrent._rpa.CheckAndRequest(processBA,_permission);
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="wait for Activity_PermissionResult (permission";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "activity_resume"), null);
this.state = 17;
return;
case 17:
//C
this.state = 7;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="File.MakeDir(File.DirRootExternal,\"/Frigate\")";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"/Frigate");
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="File.MakeDir(File.DirRootExternal,\"/Frigate/Dow";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"/Frigate/Download");
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="File.MakeDir(File.DirRootExternal,\"/Frigate/Scr";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"/Frigate/ScreenShots");
RDebugUtils.currentLine=196616;
 //BA.debugLineNum = 196616;BA.debugLine="File.MakeDir(File.DirRootExternal,\"/Frigate/Log";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"/Frigate/Log");
RDebugUtils.currentLine=196617;
 //BA.debugLineNum = 196617;BA.debugLine="If result=False Then";
if (true) break;

case 7:
//if
this.state = 10;
if (_result==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=196619;
 //BA.debugLineNum = 196619;BA.debugLine="Return";
if (true) return ;
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
;
 if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
RDebugUtils.currentLine=196623;
 //BA.debugLineNum = 196623;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("8196623",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=196625;
 //BA.debugLineNum = 196625;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _btn_appexit_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_appexit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_appexit_click", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub btn_appexit_Click";
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1703949;
 //BA.debugLineNum = 1703949;BA.debugLine="End Sub";
return "";
}
public static String  _btn_applocksave_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_applocksave_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_applocksave_click", null));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub btn_applocksave_Click";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="If TextBox_applock_password_set.Text=Textbox_rety";
if ((mostCurrent._textbox_applock_password_set.getText()).equals(mostCurrent._textbox_retype_passcodepleteedittext1.getText())) { 
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="If CheckBox_applock_enable.Checked=True Then";
if (mostCurrent._checkbox_applock_enable.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"pscode";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"pscode.txt",mostCurrent._textbox_applock_password_set.getText());
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="ToastMessageShow(\"Passcode Enabled\" & CRLF & CR";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Passcode Enabled"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"New Passcode : "+mostCurrent._textbox_applock_password_set.getText()),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4653062;
 //BA.debugLineNum = 4653062;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"pscode";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"pscode.txt","");
RDebugUtils.currentLine=4653063;
 //BA.debugLineNum = 4653063;BA.debugLine="ToastMessageShow(\"Passcode Disable\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Passcode Disable"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4653065;
 //BA.debugLineNum = 4653065;BA.debugLine="Panel_applock_settings.Visible=False";
mostCurrent._panel_applock_settings.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653066;
 //BA.debugLineNum = 4653066;BA.debugLine="Button_applock.Visible=True";
mostCurrent._button_applock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653067;
 //BA.debugLineNum = 4653067;BA.debugLine="Button_history.Visible=True";
mostCurrent._button_history.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653068;
 //BA.debugLineNum = 4653068;BA.debugLine="btn_pannelsettings_reset.Visible=True";
mostCurrent._btn_pannelsettings_reset.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653069;
 //BA.debugLineNum = 4653069;BA.debugLine="btn_settingspanel_okandhide.Visible=True";
mostCurrent._btn_settingspanel_okandhide.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4653071;
 //BA.debugLineNum = 4653071;BA.debugLine="ToastMessageShow(\"Please check Passcode !\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please check Passcode !"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4653074;
 //BA.debugLineNum = 4653074;BA.debugLine="End Sub";
return "";
}
public static String  _btn_appsettingsmore_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_appsettingsmore_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_appsettingsmore_click", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub btn_appsettingsmore_Click";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="ToggleButton_drawer.Checked=True";
mostCurrent._togglebutton_drawer.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="Panel_Main_Settings.BringToFront";
mostCurrent._panel_main_settings.BringToFront();
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="Panel_Main_Settings.Visible=True";
mostCurrent._panel_main_settings.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="End Sub";
return "";
}
public static String  _btn_back_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_back_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub btn_back_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="main_webview.Back";
mostCurrent._main_webview.Back();
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="End Sub";
return "";
}
public static String  _btn_batterysaver_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_batterysaver_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_batterysaver_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub btn_batterysaver_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="If ToggleButton_bttrysave.Checked=True Then";
if (mostCurrent._togglebutton_bttrysave.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="ToggleButton_bttrysave.Checked=False";
mostCurrent._togglebutton_bttrysave.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="btn_readingfullscreenmode.Enabled=False";
mostCurrent._btn_readingfullscreenmode.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="btn_screenshot.Enabled=False";
mostCurrent._btn_screenshot.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="btn_downloadbooster_panel.Enabled=False";
mostCurrent._btn_downloadbooster_panel.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="btn_batterysaver.TextColor=Colors.RGB(221,74,113";
mostCurrent._btn_batterysaver.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (221),(int) (74),(int) (113)));
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="ToastMessageShow(\"Disable : Reading Mode | Scree";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Disable : Reading Mode | Screenshot | Download Booster Service "+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Application Animations Disable"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Battry Save TurnON"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=917520;
 //BA.debugLineNum = 917520;BA.debugLine="btn_batterysaver.TextColor=Colors.RGB(85,85,85)";
mostCurrent._btn_batterysaver.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
RDebugUtils.currentLine=917521;
 //BA.debugLineNum = 917521;BA.debugLine="btn_downloadbooster_panel.Enabled=True";
mostCurrent._btn_downloadbooster_panel.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917522;
 //BA.debugLineNum = 917522;BA.debugLine="ToggleButton_bttrysave.Checked=True";
mostCurrent._togglebutton_bttrysave.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917523;
 //BA.debugLineNum = 917523;BA.debugLine="btn_readingfullscreenmode.Enabled=True";
mostCurrent._btn_readingfullscreenmode.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917524;
 //BA.debugLineNum = 917524;BA.debugLine="btn_screenshot.Enabled=True";
mostCurrent._btn_screenshot.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917525;
 //BA.debugLineNum = 917525;BA.debugLine="ToastMessageShow(\"All disable services : Enable\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("All disable services : Enable"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Battry Save TurnOFF"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=917528;
 //BA.debugLineNum = 917528;BA.debugLine="End Sub";
return "";
}
public static String  _btn_clearalldataapp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_clearalldataapp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_clearalldataapp_click", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub btn_clearalldataapp_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="If ToggleButtonIncog.Checked=True Then";
if (mostCurrent._togglebuttonincog.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="btn_clearalldataapp.TextColor=Colors.RGB(221,74,";
mostCurrent._btn_clearalldataapp.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (221),(int) (74),(int) (113)));
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="ToggleButtonIncog.Checked=False";
mostCurrent._togglebuttonincog.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="WebViewExtender.clearCache(main_webview,True)";
mostCurrent._webviewextender.clearCache((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="WebViewExtender.clearFocus(main_webview)";
mostCurrent._webviewextender.clearFocus((android.view.View)(mostCurrent._main_webview.getObject()));
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Fals";
mostCurrent._webviewsettings.setSaveFormData((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769479;
 //BA.debugLineNum = 1769479;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Fals";
mostCurrent._webviewsettings.setSavePassword((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=1769482;
 //BA.debugLineNum = 1769482;BA.debugLine="btn_clearalldataapp.TextColor=Colors.RGB(85,85,8";
mostCurrent._btn_clearalldataapp.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
RDebugUtils.currentLine=1769483;
 //BA.debugLineNum = 1769483;BA.debugLine="ToggleButtonIncog.Checked=True";
mostCurrent._togglebuttonincog.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769484;
 //BA.debugLineNum = 1769484;BA.debugLine="WebViewExtender.clearCache(main_webview,False)";
mostCurrent._webviewextender.clearCache((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769485;
 //BA.debugLineNum = 1769485;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Tru";
mostCurrent._webviewsettings.setSaveFormData((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769486;
 //BA.debugLineNum = 1769486;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Tru";
mostCurrent._webviewsettings.setSavePassword((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1769491;
 //BA.debugLineNum = 1769491;BA.debugLine="End Sub";
return "";
}
public static String  _btn_clearhistory_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_clearhistory_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_clearhistory_click", null));}
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub btn_clearHistory_Click";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="Try";
try {RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="If Msgbox2(\"Permanent Delete History\"& CRLF & CR";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Permanent Delete History"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Are you Sure ?"),BA.ObjectToCharSequence("READ CAREFULLY"),"Clear Now","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="ListView_Settings_hostory.Clear";
mostCurrent._listview_settings_hostory.Clear();
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="File.WriteList(File.DirDefaultExternal,\"history.";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"history.txt",(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(mostCurrent._listview_settings_hostory.getObject())));
 }else {
 };
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=4456456;
 //BA.debugLineNum = 4456456;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("84456456",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=4456459;
 //BA.debugLineNum = 4456459;BA.debugLine="End Sub";
return "";
}
public static String  _btn_darkmode_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_darkmode_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_darkmode_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub btn_darkmode_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="If ToggleButtonNightmode.Checked=True Then";
if (mostCurrent._togglebuttonnightmode.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Panel_Downloader.Color=Colors.RGB(18,18,18)";
mostCurrent._panel_downloader.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (18),(int) (18),(int) (18)));
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="Panel_Drawer.Color=Colors.RGB(18,18,18)";
mostCurrent._panel_drawer.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (18),(int) (18),(int) (18)));
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="Panel_Intergration.Color=Colors.RGB(18,18,18)";
mostCurrent._panel_intergration.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (18),(int) (18),(int) (18)));
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="Panel_Navigation_Bar.Color=Colors.RGB(18,18,18)";
mostCurrent._panel_navigation_bar.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (18),(int) (18),(int) (18)));
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="Panel_Search_Bar.Color=Colors.RGB(18,18,18)";
mostCurrent._panel_search_bar.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (18),(int) (18),(int) (18)));
RDebugUtils.currentLine=1441799;
 //BA.debugLineNum = 1441799;BA.debugLine="main_webview.Color=Colors.Black";
mostCurrent._main_webview.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="Panel_WebView_ReadingFullScreen_Mode.Color=Color";
mostCurrent._panel_webview_readingfullscreen_mode.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (18),(int) (18),(int) (18)));
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="WebView_ReadingFullScreen_Mode.Color=Colors.Blac";
mostCurrent._webview_readingfullscreen_mode.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1441802;
 //BA.debugLineNum = 1441802;BA.debugLine="ToggleButtonNightmode.Checked=False";
mostCurrent._togglebuttonnightmode.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="btn_back.TextColor=Colors.White";
mostCurrent._btn_back.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441804;
 //BA.debugLineNum = 1441804;BA.debugLine="btn_fowrd.TextColor=Colors.White";
mostCurrent._btn_fowrd.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441805;
 //BA.debugLineNum = 1441805;BA.debugLine="btn_home.TextColor=Colors.White";
mostCurrent._btn_home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441806;
 //BA.debugLineNum = 1441806;BA.debugLine="btn_drawer.TextColor=Colors.White";
mostCurrent._btn_drawer.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441807;
 //BA.debugLineNum = 1441807;BA.debugLine="textbox_search_bar.TextColor=Colors.White";
mostCurrent._textbox_search_bar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441808;
 //BA.debugLineNum = 1441808;BA.debugLine="textbox_search_bar.HintColor=Colors.White";
mostCurrent._textbox_search_bar.setHintColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441810;
 //BA.debugLineNum = 1441810;BA.debugLine="btn_darkmode.TextColor=Colors.RGB(221,74,113)";
mostCurrent._btn_darkmode.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (221),(int) (74),(int) (113)));
 }else {
RDebugUtils.currentLine=1441815;
 //BA.debugLineNum = 1441815;BA.debugLine="ToggleButtonNightmode.Checked=True";
mostCurrent._togglebuttonnightmode.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1441816;
 //BA.debugLineNum = 1441816;BA.debugLine="Panel_Downloader.Color=Colors.White";
mostCurrent._panel_downloader.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441817;
 //BA.debugLineNum = 1441817;BA.debugLine="Panel_Drawer.Color=Colors.White";
mostCurrent._panel_drawer.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441818;
 //BA.debugLineNum = 1441818;BA.debugLine="Panel_Intergration.Color=Colors.White";
mostCurrent._panel_intergration.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441819;
 //BA.debugLineNum = 1441819;BA.debugLine="Panel_Navigation_Bar.Color=Colors.White";
mostCurrent._panel_navigation_bar.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441820;
 //BA.debugLineNum = 1441820;BA.debugLine="Panel_Search_Bar.Color=Colors.White";
mostCurrent._panel_search_bar.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441821;
 //BA.debugLineNum = 1441821;BA.debugLine="main_webview.Color=Colors.White";
mostCurrent._main_webview.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441822;
 //BA.debugLineNum = 1441822;BA.debugLine="Panel_WebView_ReadingFullScreen_Mode.Color=Color";
mostCurrent._panel_webview_readingfullscreen_mode.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441823;
 //BA.debugLineNum = 1441823;BA.debugLine="WebView_ReadingFullScreen_Mode.Color=Colors.Whit";
mostCurrent._webview_readingfullscreen_mode.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1441825;
 //BA.debugLineNum = 1441825;BA.debugLine="btn_back.TextColor=Colors.RGB(85,85,85)";
mostCurrent._btn_back.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
RDebugUtils.currentLine=1441826;
 //BA.debugLineNum = 1441826;BA.debugLine="btn_fowrd.TextColor=Colors.RGB(85,85,85)";
mostCurrent._btn_fowrd.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
RDebugUtils.currentLine=1441827;
 //BA.debugLineNum = 1441827;BA.debugLine="btn_home.TextColor=Colors.RGB(85,85,85)";
mostCurrent._btn_home.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
RDebugUtils.currentLine=1441828;
 //BA.debugLineNum = 1441828;BA.debugLine="btn_drawer.TextColor=Colors.RGB(85,85,85)";
mostCurrent._btn_drawer.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
RDebugUtils.currentLine=1441829;
 //BA.debugLineNum = 1441829;BA.debugLine="btn_darkmode.TextColor=Colors.RGB(85,85,85)";
mostCurrent._btn_darkmode.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
RDebugUtils.currentLine=1441830;
 //BA.debugLineNum = 1441830;BA.debugLine="textbox_search_bar.TextColor=Colors.RGB(85,85,85";
mostCurrent._textbox_search_bar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
RDebugUtils.currentLine=1441831;
 //BA.debugLineNum = 1441831;BA.debugLine="textbox_search_bar.HintColor=Colors.RGB(85,85,85";
mostCurrent._textbox_search_bar.setHintColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
 };
RDebugUtils.currentLine=1441833;
 //BA.debugLineNum = 1441833;BA.debugLine="End Sub";
return "";
}
public static String  _btn_downloadbooster_panel_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_downloadbooster_panel_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_downloadbooster_panel_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub btn_downloadbooster_panel_CheckedChange(Checke";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="If btn_downloadbooster_panel.Checked=True Then";
if (mostCurrent._btn_downloadbooster_panel.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="ToastMessageShow(\"Download Booster - Network Boo";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Download Booster - Network Booster Enabled"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="ToastMessageShow(\"Download Booster - Network Boo";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Download Booster - Network Booster Disable"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="End Sub";
return "";
}
public static String  _btn_downloader_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_downloader_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_downloader_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub btn_downloader_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Panel_Downloader.BringToFront";
mostCurrent._panel_downloader.BringToFront();
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Panel_Downloader.Visible=True";
mostCurrent._panel_downloader.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="ToggleButton_drawer.Checked=True";
mostCurrent._togglebutton_drawer.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="End Sub";
return "";
}
public static String  _btn_downloader_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_downloader_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_downloader_longclick", null));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub btn_downloader_LongClick";
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="If main_webview.Url.StartsWith(\"file:///\") Then";
if (mostCurrent._main_webview.getUrl().startsWith("file:///")) { 
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="ToastMessageShow(\"Cant Save / Download this URL!";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Cant Save / Download this URL!"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="textbox_download_url.Text=main_webview.Url";
mostCurrent._textbox_download_url.setText(BA.ObjectToCharSequence(mostCurrent._main_webview.getUrl()));
RDebugUtils.currentLine=3080199;
 //BA.debugLineNum = 3080199;BA.debugLine="textbox_download_filename.Text=WebViewExtender.g";
mostCurrent._textbox_download_filename.setText(BA.ObjectToCharSequence(mostCurrent._webviewextender.getTitle((android.webkit.WebView)(mostCurrent._main_webview.getObject()))+".html"));
RDebugUtils.currentLine=3080200;
 //BA.debugLineNum = 3080200;BA.debugLine="Panel_Downloader.BringToFront";
mostCurrent._panel_downloader.BringToFront();
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="Panel_Downloader.Visible=True";
mostCurrent._panel_downloader.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3080202;
 //BA.debugLineNum = 3080202;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3080205;
 //BA.debugLineNum = 3080205;BA.debugLine="End Sub";
return "";
}
public static String  _btn_drawer_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_drawer_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_drawer_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub btn_drawer_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="If ToggleButton_drawer.Checked=True Then";
if (mostCurrent._togglebutton_drawer.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="ToggleButton_drawer.Checked=False";
mostCurrent._togglebutton_drawer.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="Panel_Drawer.BringToFront";
mostCurrent._panel_drawer.BringToFront();
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="Panel_Drawer.Visible=True";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="Panel_Downloader.Visible=False";
mostCurrent._panel_downloader.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="ToggleButton_drawer.Checked=True";
mostCurrent._togglebutton_drawer.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="End Sub";
return "";
}
public static String  _btn_extrasites_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_extrasites_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_extrasites_click", null));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub btn_extrasites_Click";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/index";
mostCurrent._main_webview.LoadUrl("file:///android_asset/index.html");
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="End Sub";
return "";
}
public static String  _btn_fb_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_fb_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_fb_click", null));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub btn_fb_Click";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="main_webview.LoadUrl(\"https://m.facebook.com\")";
mostCurrent._main_webview.LoadUrl("https://m.facebook.com");
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="End Sub";
return "";
}
public static String  _btn_fowrd_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_fowrd_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_fowrd_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub btn_fowrd_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="main_webview.Forward";
mostCurrent._main_webview.Forward();
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="End Sub";
return "";
}
public static String  _btn_fullscreen_back_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_fullscreen_back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_fullscreen_back_click", null));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub btn_fullscreen_back_Click";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="WebView_ReadingFullScreen_Mode.Back";
mostCurrent._webview_readingfullscreen_mode.Back();
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="End Sub";
return "";
}
public static String  _btn_fullscreen_fowrd_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_fullscreen_fowrd_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_fullscreen_fowrd_click", null));}
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub btn_fullscreen_fowrd_Click";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="WebView_ReadingFullScreen_Mode.Forward";
mostCurrent._webview_readingfullscreen_mode.Forward();
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="End Sub";
return "";
}
public static String  _btn_fullscreenreadingmode_exit_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_fullscreenreadingmode_exit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_fullscreenreadingmode_exit_click", null));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub btn_fullscreenreadingmode_exit_Click";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Panel_WebView_ReadingFullScreen_Mode.Visible=Fals";
mostCurrent._panel_webview_readingfullscreen_mode.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="main_webview.LoadUrl(WebView_ReadingFullScreen_Mo";
mostCurrent._main_webview.LoadUrl(mostCurrent._webview_readingfullscreen_mode.getUrl());
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="End Sub";
return "";
}
public static String  _btn_helpguide_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_helpguide_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_helpguide_click", null));}
anywheresoftware.b4a.phone.Phone.Email _feedback = null;
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub btn_helpguide_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="ToggleButton_drawer.Checked=True";
mostCurrent._togglebutton_drawer.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Dim feedback As Email";
_feedback = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="feedback.To.Add(\"contact.clenontec@gmail.com\")";
_feedback.To.Add((Object)("contact.clenontec@gmail.com"));
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="feedback.Subject=\"Help and Feedback - Frigate Su";
_feedback.Subject = "Help and Feedback - Frigate Suffering Browser";
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="StartActivity(feedback.GetIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_feedback.GetIntent()));
 } 
       catch (Exception e9) {
			processBA.setLastException(e9);RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("81900553",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=1900554;
 //BA.debugLineNum = 1900554;BA.debugLine="ToastMessageShow(\"Help and Feedback Fail !\",True";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Help and Feedback Fail !"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1900556;
 //BA.debugLineNum = 1900556;BA.debugLine="End Sub";
return "";
}
public static String  _btn_helpguide_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_helpguide_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_helpguide_longclick", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub btn_helpguide_LongClick";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/welco";
mostCurrent._main_webview.LoadUrl("file:///android_asset/welcome.html");
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return "";
}
public static String  _btn_hidedownloadpanel_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_hidedownloadpanel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_hidedownloadpanel_click", null));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub btn_hidedownloadpanel_Click";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Panel_Downloader.Visible=False";
mostCurrent._panel_downloader.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="End Sub";
return "";
}
public static String  _btn_history_hide_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_history_hide_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_history_hide_click", null));}
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub btn_history_hide_Click";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Panel_Settings_History.Visible=False";
mostCurrent._panel_settings_history.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="Button_applock.Visible=True";
mostCurrent._button_applock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="Button_history.Visible=True";
mostCurrent._button_history.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="btn_pannelsettings_reset.Visible=True";
mostCurrent._btn_pannelsettings_reset.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="btn_settingspanel_okandhide.Visible=True";
mostCurrent._btn_settingspanel_okandhide.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4259846;
 //BA.debugLineNum = 4259846;BA.debugLine="End Sub";
return "";
}
public static String  _btn_home_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_home_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_home_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub btn_home_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Try";
try {RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="If RadioButton_google.Checked=True Then";
if (mostCurrent._radiobutton_google.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/googl";
mostCurrent._main_webview.LoadUrl("file:///android_asset/google.html");
 };
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="If RadioButton_duck.Checked=True Then";
if (mostCurrent._radiobutton_duck.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/duck.";
mostCurrent._main_webview.LoadUrl("file:///android_asset/duck.html");
 };
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="If RadioButton_bing.Checked=True Then";
if (mostCurrent._radiobutton_bing.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/bing.";
mostCurrent._main_webview.LoadUrl("file:///android_asset/bing.html");
 };
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="If RadioButton_yahoo.Checked=True Then";
if (mostCurrent._radiobutton_yahoo.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/yahoo";
mostCurrent._main_webview.LoadUrl("file:///android_asset/yahoo.html");
 };
 } 
       catch (Exception e15) {
			processBA.setLastException(e15);RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("8720911",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="main_webview.LoadUrl(\"file:///android_asset/googl";
mostCurrent._main_webview.LoadUrl("file:///android_asset/google.html");
 };
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="End Sub";
return "";
}
public static String  _btn_imagedisable_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_imagedisable_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_imagedisable_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub btn_imagedisable_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="ToggleButton_drawer.Checked=True";
mostCurrent._togglebutton_drawer.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="If ToggleButton_imagedisable.Checked = True Then";
if (mostCurrent._togglebutton_imagedisable.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="WebViewExtender.setLoadsImagesAutomatically(main";
mostCurrent._webviewextender.setLoadsImagesAutomatically((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="ToggleButton_imagedisable.Checked = False";
mostCurrent._togglebutton_imagedisable.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="btn_imagedisable.TextColor = Colors.RGB(221,74,1";
mostCurrent._btn_imagedisable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (221),(int) (74),(int) (113)));
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="ToastMessageShow(\"Block Images : DATA Save Enabl";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Block Images : DATA Save Enable"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="WebViewExtender.setLoadsImagesAutomatically(main";
mostCurrent._webviewextender.setLoadsImagesAutomatically((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179659;
 //BA.debugLineNum = 1179659;BA.debugLine="ToggleButton_imagedisable.Checked = True";
mostCurrent._togglebutton_imagedisable.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179660;
 //BA.debugLineNum = 1179660;BA.debugLine="btn_imagedisable.TextColor = Colors.RGB(85,85,85";
mostCurrent._btn_imagedisable.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="ToastMessageShow(\"Show Images : DATA Save Disabl";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Show Images : DATA Save Disable"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1179663;
 //BA.debugLineNum = 1179663;BA.debugLine="End Sub";
return "";
}
public static String  _btn_instr_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_instr_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_instr_click", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub btn_instr_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="main_webview.LoadUrl(\"https://www.instagram.com\")";
mostCurrent._main_webview.LoadUrl("https://www.instagram.com");
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="End Sub";
return "";
}
public static String  _btn_intergrton_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_intergrton_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_intergrton_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub btn_intergrton_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Panel_Intergration.BringToFront";
mostCurrent._panel_intergration.BringToFront();
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Panel_Intergration.Visible=True";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="ToggleButton_drawer.Checked=True";
mostCurrent._togglebutton_drawer.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="End Sub";
return "";
}
public static String  _btn_jsdisable_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_jsdisable_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_jsdisable_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub btn_jsdisable_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="If ToggleButton_js.Checked=True Then";
if (mostCurrent._togglebutton_js.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="main_webview.JavaScriptEnabled=False";
mostCurrent._main_webview.setJavaScriptEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="WebViewExtender.setJavaScriptEnabled(main_webvie";
mostCurrent._webviewextender.setJavaScriptEnabled((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="ToggleButton_js.Checked=False";
mostCurrent._togglebutton_js.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="ToastMessageShow(\"Little Ad Blocker  : Enable (";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Little Ad Blocker  : Enable ( Classic Interface Enable )"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="main_webview.JavaScriptEnabled=True";
mostCurrent._main_webview.setJavaScriptEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="WebViewExtender.setJavaScriptEnabled(main_webvie";
mostCurrent._webviewextender.setJavaScriptEnabled((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="ToggleButton_js.Checked=True";
mostCurrent._togglebutton_js.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="ToastMessageShow(\"Little Ad Blocker : Disable (";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Little Ad Blocker : Disable ( Classic Interface Disable )"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="End Sub";
return "";
}
public static String  _btn_lnkdin_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_lnkdin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_lnkdin_click", null));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub btn_lnkdin_Click";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="main_webview.LoadUrl(\"https://www.linkedin.com\")";
mostCurrent._main_webview.LoadUrl("https://www.linkedin.com");
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="End Sub";
return "";
}
public static String  _btn_openweblinkanotherbrowser_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_openweblinkanotherbrowser_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_openweblinkanotherbrowser_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _openurlsharei = null;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub btn_openweblinkanotherbrowser_Click";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="If main_webview.Url.StartsWith(\"file:///\") Then";
if (mostCurrent._main_webview.getUrl().startsWith("file:///")) { 
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="ToastMessageShow(\"Can't open URL\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Can't open URL"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="Try";
try {RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="Private openurlsharei As Intent";
_openurlsharei = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="openurlsharei.Initialize(openurlsharei.ACTION_V";
_openurlsharei.Initialize(_openurlsharei.ACTION_VIEW,mostCurrent._main_webview.getUrl());
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="StartActivity(openurlsharei)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_openurlsharei.getObject()));
 } 
       catch (Exception e9) {
			processBA.setLastException(e9);RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("81245194",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="End Sub";
return "";
}
public static String  _btn_panel_intergration_hide_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_panel_intergration_hide_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_panel_intergration_hide_click", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub btn_panel_intergration_hide_Click";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="End Sub";
return "";
}
public static String  _btn_pannelsettings_reset_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_pannelsettings_reset_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_pannelsettings_reset_click", null));}
anywheresoftware.b4a.agraham.reflection.Reflection _clcc = null;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub btn_pannelsettings_reset_Click";
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="If Msgbox2(\"ITEMS : Cache, History\"& CRLF & CRLF";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("ITEMS : Cache, History"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Are you Sure ?"),BA.ObjectToCharSequence("READ CAREFULLY"),"Clear Now","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="WebViewExtender.clearCache(main_webview,True)";
mostCurrent._webviewextender.clearCache((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="WebViewExtender.clearCache(WebView_ReadingFullSc";
mostCurrent._webviewextender.clearCache((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="WebViewExtender.clearFocus(main_webview)";
mostCurrent._webviewextender.clearFocus((android.view.View)(mostCurrent._main_webview.getObject()));
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="WebViewExtender.clearFocus(WebView_ReadingFullSc";
mostCurrent._webviewextender.clearFocus((android.view.View)(mostCurrent._webview_readingfullscreen_mode.getObject()));
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="ListView_Settings_hostory.Clear";
mostCurrent._listview_settings_hostory.Clear();
RDebugUtils.currentLine=4063241;
 //BA.debugLineNum = 4063241;BA.debugLine="RadioButton_google.Checked=True";
mostCurrent._radiobutton_google.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063242;
 //BA.debugLineNum = 4063242;BA.debugLine="CheckBox_js.Checked=True";
mostCurrent._checkbox_js.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="CheckBox_cookie.Checked=True";
mostCurrent._checkbox_cookie.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063244;
 //BA.debugLineNum = 4063244;BA.debugLine="Try";
try {RDebugUtils.currentLine=4063245;
 //BA.debugLineNum = 4063245;BA.debugLine="Dim clcc As Reflector";
_clcc = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=4063246;
 //BA.debugLineNum = 4063246;BA.debugLine="clcc.Target=main_webview";
_clcc.Target = (Object)(mostCurrent._main_webview.getObject());
RDebugUtils.currentLine=4063247;
 //BA.debugLineNum = 4063247;BA.debugLine="clcc.RunMethod2(\"clearCache\",\"False\",\"java.lang.";
_clcc.RunMethod2("clearCache","False","java.lang.boolean");
 } 
       catch (Exception e15) {
			processBA.setLastException(e15);RDebugUtils.currentLine=4063249;
 //BA.debugLineNum = 4063249;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("84063249",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 }else {
RDebugUtils.currentLine=4063253;
 //BA.debugLineNum = 4063253;BA.debugLine="RadioButton_google.Checked=True";
mostCurrent._radiobutton_google.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063254;
 //BA.debugLineNum = 4063254;BA.debugLine="CheckBox_js.Checked=True";
mostCurrent._checkbox_js.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063255;
 //BA.debugLineNum = 4063255;BA.debugLine="CheckBox_cookie.Checked=True";
mostCurrent._checkbox_cookie.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4063257;
 //BA.debugLineNum = 4063257;BA.debugLine="End Sub";
return "";
}
public static String  _btn_password_panelhide_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_password_panelhide_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_password_panelhide_click", null));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub btn_password_panelHide_Click";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="Panel_applock_settings.Visible=False";
mostCurrent._panel_applock_settings.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="Button_applock.Visible=True";
mostCurrent._button_applock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="Button_history.Visible=True";
mostCurrent._button_history.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="btn_pannelsettings_reset.Visible=True";
mostCurrent._btn_pannelsettings_reset.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="btn_settingspanel_okandhide.Visible=True";
mostCurrent._btn_settingspanel_okandhide.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718598;
 //BA.debugLineNum = 4718598;BA.debugLine="End Sub";
return "";
}
public static String  _btn_pintrst_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_pintrst_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_pintrst_click", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub btn_pintrst_Click";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="main_webview.LoadUrl(\"https://www.pinterest.com\")";
mostCurrent._main_webview.LoadUrl("https://www.pinterest.com");
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="End Sub";
return "";
}
public static String  _btn_quora_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_quora_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_quora_click", null));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub btn_quora_Click";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="main_webview.LoadUrl(\"https://quora.com\")";
mostCurrent._main_webview.LoadUrl("https://quora.com");
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="End Sub";
return "";
}
public static String  _btn_rddit_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_rddit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_rddit_click", null));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub btn_rddit_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="main_webview.LoadUrl(\"https://www.reddit.com\")";
mostCurrent._main_webview.LoadUrl("https://www.reddit.com");
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="End Sub";
return "";
}
public static String  _btn_readingfullscreenmode_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_readingfullscreenmode_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_readingfullscreenmode_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub btn_readingfullscreenmode_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="ToggleButton_drawer.Checked=True";
mostCurrent._togglebutton_drawer.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Panel_WebView_ReadingFullScreen_Mode.BringToFront";
mostCurrent._panel_webview_readingfullscreen_mode.BringToFront();
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="Panel_WebView_ReadingFullScreen_Mode.Visible=True";
mostCurrent._panel_webview_readingfullscreen_mode.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="WebView_ReadingFullScreen_Mode.LoadUrl(main_webvi";
mostCurrent._webview_readingfullscreen_mode.LoadUrl(mostCurrent._main_webview.getUrl());
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="End Sub";
return "";
}
public static String  _btn_refresh_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_refresh_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_refresh_click", null));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub btn_refresh_Click";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="main_webview.LoadUrl(main_webview.Url)";
mostCurrent._main_webview.LoadUrl(mostCurrent._main_webview.getUrl());
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="End Sub";
return "";
}
public static String  _btn_refreshclose_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_refreshclose_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_refreshclose_click", null));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub btn_refreshclose_Click";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="main_webview.StopLoading";
mostCurrent._main_webview.StopLoading();
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="btn_refreshclose.Visible=False";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="btn_refresh.Visible=True";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="End Sub";
return "";
}
public static String  _btn_runappbackground_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_runappbackground_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_runappbackground_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub btn_runappbackground_Click";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="End Sub";
return "";
}
public static String  _btn_screenshot_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_screenshot_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_screenshot_click", null));}
String _m = "";
String _h = "";
String _s = "";
anywheresoftware.b4a.agraham.reflection.Reflection _obj1 = null;
anywheresoftware.b4a.agraham.reflection.Reflection _obj2 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
Object[] _args = null;
String[] _types = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
anywheresoftware.b4a.objects.IntentWrapper _dointent = null;
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub btn_screenshot_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Panel_Downloader.Visible=False";
mostCurrent._panel_downloader.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="Panel_Drawer.Visible=False";
mostCurrent._panel_drawer.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="ToggleButton_drawer.Checked=True";
mostCurrent._togglebutton_drawer.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="Try";
try {RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="Dim M, H, S As String";
_m = "";
_h = "";
_s = "";
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="DateTime.DateFormat=\"dd mm yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd mm yyyy");
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="H  = DateTime.GetHour(DateTime.Now)";
_h = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="M  = DateTime.GetMinute(DateTime.Now)";
_m = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="S = DateTime.GetSecond(DateTime.Now)";
_s = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetSecond(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=1114124;
 //BA.debugLineNum = 1114124;BA.debugLine="Dim Obj1, Obj2 As Reflector";
_obj1 = new anywheresoftware.b4a.agraham.reflection.Reflection();
_obj2 = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=1114125;
 //BA.debugLineNum = 1114125;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=1114126;
 //BA.debugLineNum = 1114126;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=1114127;
 //BA.debugLineNum = 1114127;BA.debugLine="Obj1.Target = Obj1.GetActivityBA";
_obj1.Target = (Object)(_obj1.GetActivityBA(processBA));
RDebugUtils.currentLine=1114128;
 //BA.debugLineNum = 1114128;BA.debugLine="Obj1.Target = Obj1.GetField(\"vg\")";
_obj1.Target = _obj1.GetField("vg");
RDebugUtils.currentLine=1114129;
 //BA.debugLineNum = 1114129;BA.debugLine="bmp.InitializeMutable(Activity.Width, Activity.H";
_bmp.InitializeMutable(mostCurrent._activity.getWidth(),mostCurrent._activity.getHeight());
RDebugUtils.currentLine=1114130;
 //BA.debugLineNum = 1114130;BA.debugLine="cvs.Initialize2(bmp)";
_cvs.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=1114131;
 //BA.debugLineNum = 1114131;BA.debugLine="Dim args(1) As Object";
_args = new Object[(int) (1)];
{
int d0 = _args.length;
for (int i0 = 0;i0 < d0;i0++) {
_args[i0] = new Object();
}
}
;
RDebugUtils.currentLine=1114132;
 //BA.debugLineNum = 1114132;BA.debugLine="Dim types(1) As String";
_types = new String[(int) (1)];
java.util.Arrays.fill(_types,"");
RDebugUtils.currentLine=1114133;
 //BA.debugLineNum = 1114133;BA.debugLine="Obj2.Target = cvs";
_obj2.Target = (Object)(_cvs);
RDebugUtils.currentLine=1114134;
 //BA.debugLineNum = 1114134;BA.debugLine="Obj2.Target = Obj2.GetField(\"canvas\")";
_obj2.Target = _obj2.GetField("canvas");
RDebugUtils.currentLine=1114135;
 //BA.debugLineNum = 1114135;BA.debugLine="args(0) = Obj2.Target";
_args[(int) (0)] = _obj2.Target;
RDebugUtils.currentLine=1114136;
 //BA.debugLineNum = 1114136;BA.debugLine="types(0) = \"android.graphics.Canvas\"";
_types[(int) (0)] = "android.graphics.Canvas";
RDebugUtils.currentLine=1114137;
 //BA.debugLineNum = 1114137;BA.debugLine="Obj1.RunMethod4(\"draw\", args, types)";
_obj1.RunMethod4("draw",_args,_types);
RDebugUtils.currentLine=1114138;
 //BA.debugLineNum = 1114138;BA.debugLine="Dim Out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=1114139;
 //BA.debugLineNum = 1114139;BA.debugLine="Out = File.OpenOutput(File.DirRootExternal & \"/F";
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal()+"/Frigate/ScreenShots",_h+":"+_m+_s+anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())+"-frigate_Screenshot.Png",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114140;
 //BA.debugLineNum = 1114140;BA.debugLine="bmp.WriteToStream(Out, 100, \"PNG\")";
_bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
RDebugUtils.currentLine=1114141;
 //BA.debugLineNum = 1114141;BA.debugLine="Out.Close";
_out.Close();
RDebugUtils.currentLine=1114142;
 //BA.debugLineNum = 1114142;BA.debugLine="ToastMessageShow(\"ScreenShot Capture Successfull";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ScreenShot Capture Successfull ! "),anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e31) {
			processBA.setLastException(e31);RDebugUtils.currentLine=1114144;
 //BA.debugLineNum = 1114144;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("81114144",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=1114146;
 //BA.debugLineNum = 1114146;BA.debugLine="If Msgbox2(\"Directory Unavailable or STORAGE PER";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Directory Unavailable or STORAGE PERMISSION denied !"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Get Permission : Open Settings > Apps > Configure Apps > App Permissions > Storage > Frigate Browser"),BA.ObjectToCharSequence("READ CAREFULLY"),"Open Settings","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=1114147;
 //BA.debugLineNum = 1114147;BA.debugLine="Dim DoIntent As Intent";
_dointent = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1114148;
 //BA.debugLineNum = 1114148;BA.debugLine="DoIntent.Initialize(\"android.settings.MANAGE_AP";
_dointent.Initialize("android.settings.MANAGE_APPLICATIONS_SETTINGS","");
RDebugUtils.currentLine=1114149;
 //BA.debugLineNum = 1114149;BA.debugLine="StartActivity(DoIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_dointent.getObject()));
 }else {
 };
 };
RDebugUtils.currentLine=1114153;
 //BA.debugLineNum = 1114153;BA.debugLine="End Sub";
return "";
}
public static String  _btn_search_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_search_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_search_click", null));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub btn_search_Click";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3276803;
 //BA.debugLineNum = 3276803;BA.debugLine="main_webview.LoadUrl(textbox_search_bar.Text)";
mostCurrent._main_webview.LoadUrl(mostCurrent._textbox_search_bar.getText());
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="End Sub";
return "";
}
public static String  _btn_search_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_search_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_search_longclick", null));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub btn_search_LongClick";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Try";
try {RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="If main_webview.Url.StartsWith(\"http://\") Then";
if (mostCurrent._main_webview.getUrl().startsWith("http://")) { 
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="Msgbox(\"Not Secure [ LEVEL - 50% - NO SSL ]\"& C";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Not Secure [ LEVEL - 50% - NO SSL ]"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._main_webview.getUrl()+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._webviewextender.getTitle((android.webkit.WebView)(mostCurrent._main_webview.getObject()))+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"HOST : "+mostCurrent._webviewextender.getHost(BA.ObjectToString(mostCurrent._main_webview))),BA.ObjectToCharSequence("Security Deatils"),mostCurrent.activityBA);
 };
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="If main_webview.Url.StartsWith(\"https://\") Then";
if (mostCurrent._main_webview.getUrl().startsWith("https://")) { 
RDebugUtils.currentLine=3342342;
 //BA.debugLineNum = 3342342;BA.debugLine="Msgbox(\"Fully Secure [ LEVEL - 100% - SSL ]\" &";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Fully Secure [ LEVEL - 100% - SSL ]"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._main_webview.getUrl()+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._webviewextender.getTitle((android.webkit.WebView)(mostCurrent._main_webview.getObject()))+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"HOST : "+mostCurrent._webviewextender.getHost(BA.ObjectToString(mostCurrent._main_webview))),BA.ObjectToCharSequence("Security Deatils"),mostCurrent.activityBA);
 };
RDebugUtils.currentLine=3342344;
 //BA.debugLineNum = 3342344;BA.debugLine="If main_webview.Url.StartsWith(\"file:///\") Then";
if (mostCurrent._main_webview.getUrl().startsWith("file:///")) { 
RDebugUtils.currentLine=3342345;
 //BA.debugLineNum = 3342345;BA.debugLine="Msgbox(\"In-App WebView : No details available\",";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("In-App WebView : No details available"),BA.ObjectToCharSequence("Security Deatils"),mostCurrent.activityBA);
 };
 } 
       catch (Exception e12) {
			processBA.setLastException(e12);RDebugUtils.currentLine=3342348;
 //BA.debugLineNum = 3342348;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("83342348",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=3342350;
 //BA.debugLineNum = 3342350;BA.debugLine="End Sub";
return "";
}
public static String  _btn_settingspanel_okandhide_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_settingspanel_okandhide_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_settingspanel_okandhide_click", null));}
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub btn_settingspanel_okandhide_Click";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Try";
try {RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="If RadioButton_google.Checked=True Then";
if (mostCurrent._radiobutton_google.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"google";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"google.txt","1");
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"duck.txt","0");
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"duck.txt","0");
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"yahoo";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"yahoo.txt","0");
 }else {
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"google";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"google.txt","0");
 };
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="If RadioButton_duck.Checked=True Then";
if (mostCurrent._radiobutton_duck.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"duck.txt","1");
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"googl";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"google.txt","0");
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"bing.";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"bing.txt","0");
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"yahoo";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"yahoo.txt","0");
 }else {
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"duck.txt","0");
 };
RDebugUtils.currentLine=4128786;
 //BA.debugLineNum = 4128786;BA.debugLine="If RadioButton_bing.Checked=True Then";
if (mostCurrent._radiobutton_bing.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128787;
 //BA.debugLineNum = 4128787;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"bing.t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"bing.txt","1");
RDebugUtils.currentLine=4128788;
 //BA.debugLineNum = 4128788;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"googl";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"google.txt","0");
RDebugUtils.currentLine=4128789;
 //BA.debugLineNum = 4128789;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"duck.txt","0");
RDebugUtils.currentLine=4128790;
 //BA.debugLineNum = 4128790;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"yahoo";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"yahoo.txt","0");
 }else {
RDebugUtils.currentLine=4128792;
 //BA.debugLineNum = 4128792;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"bing.t";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"bing.txt","0");
 };
RDebugUtils.currentLine=4128794;
 //BA.debugLineNum = 4128794;BA.debugLine="If RadioButton_yahoo.Checked=True Then";
if (mostCurrent._radiobutton_yahoo.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128795;
 //BA.debugLineNum = 4128795;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"yahoo.";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"yahoo.txt","1");
RDebugUtils.currentLine=4128796;
 //BA.debugLineNum = 4128796;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"bing.";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"bing.txt","0");
RDebugUtils.currentLine=4128797;
 //BA.debugLineNum = 4128797;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"googl";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"google.txt","0");
RDebugUtils.currentLine=4128798;
 //BA.debugLineNum = 4128798;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"duck.";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"duck.txt","0");
 }else {
RDebugUtils.currentLine=4128800;
 //BA.debugLineNum = 4128800;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"yahoo.";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"yahoo.txt","0");
 };
RDebugUtils.currentLine=4128805;
 //BA.debugLineNum = 4128805;BA.debugLine="If CheckBox_savepass.Checked=True Then";
if (mostCurrent._checkbox_savepass.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128806;
 //BA.debugLineNum = 4128806;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"savepa";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"savepass.txt","1");
 }else {
RDebugUtils.currentLine=4128808;
 //BA.debugLineNum = 4128808;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"savepa";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"savepass.txt","0");
 };
RDebugUtils.currentLine=4128810;
 //BA.debugLineNum = 4128810;BA.debugLine="If CheckBox_dnt.Checked=True Then";
if (mostCurrent._checkbox_dnt.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128811;
 //BA.debugLineNum = 4128811;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"dnt.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"dnt.txt","1");
 }else {
RDebugUtils.currentLine=4128813;
 //BA.debugLineNum = 4128813;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"dnt.tx";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"dnt.txt","0");
 };
RDebugUtils.currentLine=4128815;
 //BA.debugLineNum = 4128815;BA.debugLine="If CheckBox_js.Checked=True Then";
if (mostCurrent._checkbox_js.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128816;
 //BA.debugLineNum = 4128816;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"js.txt";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"js.txt","1");
 }else {
RDebugUtils.currentLine=4128818;
 //BA.debugLineNum = 4128818;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"js.txt";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"js.txt","0");
 };
RDebugUtils.currentLine=4128820;
 //BA.debugLineNum = 4128820;BA.debugLine="If CheckBox_boostmode.Checked=True Then";
if (mostCurrent._checkbox_boostmode.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128821;
 //BA.debugLineNum = 4128821;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"boostr";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"boostr.txt","1");
 }else {
RDebugUtils.currentLine=4128823;
 //BA.debugLineNum = 4128823;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"boostr";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"boostr.txt","0");
 };
RDebugUtils.currentLine=4128825;
 //BA.debugLineNum = 4128825;BA.debugLine="If CheckBox_cookie.Checked=True Then";
if (mostCurrent._checkbox_cookie.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128826;
 //BA.debugLineNum = 4128826;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"cookie";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"cookie.txt","1");
 }else {
RDebugUtils.currentLine=4128828;
 //BA.debugLineNum = 4128828;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"cookie";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"cookie.txt","0");
 };
RDebugUtils.currentLine=4128830;
 //BA.debugLineNum = 4128830;BA.debugLine="If CheckBox_safesearch.Checked=True Then";
if (mostCurrent._checkbox_safesearch.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128831;
 //BA.debugLineNum = 4128831;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"sfsear";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"sfsearch.txt","1");
 }else {
RDebugUtils.currentLine=4128833;
 //BA.debugLineNum = 4128833;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"sfsear";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"sfsearch.txt","0");
 };
RDebugUtils.currentLine=4128836;
 //BA.debugLineNum = 4128836;BA.debugLine="If CheckBox_applock_enable.Checked=True Then";
if (mostCurrent._checkbox_applock_enable.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4128837;
 //BA.debugLineNum = 4128837;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"pscode";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"pscodecheck.txt","1");
 }else {
RDebugUtils.currentLine=4128839;
 //BA.debugLineNum = 4128839;BA.debugLine="File.WriteString(File.DirDefaultExternal,\"pscod";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"pscodecheck.txt","0");
 };
 } 
       catch (Exception e70) {
			processBA.setLastException(e70);RDebugUtils.currentLine=4128842;
 //BA.debugLineNum = 4128842;BA.debugLine="ToastMessageShow(\"Settings Save Error !\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Settings Save Error !"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128843;
 //BA.debugLineNum = 4128843;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("84128843",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=4128846;
 //BA.debugLineNum = 4128846;BA.debugLine="Panel_Main_Settings.Visible=False";
mostCurrent._panel_main_settings.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128847;
 //BA.debugLineNum = 4128847;BA.debugLine="End Sub";
return "";
}
public static String  _btn_shareapp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_shareapp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_shareapp_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _shareapk = null;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub btn_shareapp_Click";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Try";
try {RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="Dim shareapk As Intent";
_shareapk = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="shareapk.Initialize(shareapk.ACTION_SEND,\"\")";
_shareapk.Initialize(_shareapk.ACTION_SEND,"");
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="shareapk.SetType(\"text/plain\")";
_shareapk.SetType("text/plain");
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="shareapk.PutExtra(\"android.intent.extra.TEXT\",\"M";
_shareapk.PutExtra("android.intent.extra.TEXT",(Object)("Make hard things simple. Lite Browser with Lightning Speed and Mini Usage."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Data Save / Battery Save / Smart Search / Smart and High-Speed and Unlimited Downloader / Media Integration / Night Mode / 100% Security / Social Media Integration....."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Get it on Google Play Now. http://play.google.com/store/apps/details?id=com.clenontec.webbrowser"));
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="shareapk.WrapAsIntentChooser(\"Share Frigate Brows";
_shareapk.WrapAsIntentChooser("Share Frigate Browser");
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="StartActivity(shareapk)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_shareapk.getObject()));
 } 
       catch (Exception e9) {
			processBA.setLastException(e9);RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("81638409",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=1638412;
 //BA.debugLineNum = 1638412;BA.debugLine="End Sub";
return "";
}
public static String  _btn_shareweburl_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_shareweburl_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_shareweburl_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _shareweburlpk = null;
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub btn_shareweburl_Click";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="If main_webview.Url.StartsWith(\"file:///\") Then";
if (mostCurrent._main_webview.getUrl().startsWith("file:///")) { 
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="ToastMessageShow(\"Sharing Faild !\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Sharing Faild !"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="Try";
try {RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="Dim shareweburlpk As Intent";
_shareweburlpk = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="shareweburlpk.Initialize(shareweburlpk.ACTION_SE";
_shareweburlpk.Initialize(_shareweburlpk.ACTION_SEND,"");
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="shareweburlpk.SetType(\"text/plain\")";
_shareweburlpk.SetType("text/plain");
RDebugUtils.currentLine=1310729;
 //BA.debugLineNum = 1310729;BA.debugLine="shareweburlpk.PutExtra(\"android.intent.extra.TE";
_shareweburlpk.PutExtra("android.intent.extra.TEXT",(Object)("URL ( Share ) : "+mostCurrent._main_webview.getUrl()+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Make hard things simple. Lite Browser with Lightning Speed and Mini Usage. Get it on Google Play Now. http://play.google.com/store/apps/details?id=com.clenontec.webbrowser"));
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="shareweburlpk.WrapAsIntentChooser(\"URL Sharing S";
_shareweburlpk.WrapAsIntentChooser("URL Sharing Service");
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="StartActivity(shareweburlpk)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_shareweburlpk.getObject()));
 } 
       catch (Exception e12) {
			processBA.setLastException(e12);RDebugUtils.currentLine=1310733;
 //BA.debugLineNum = 1310733;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("81310733",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 };
RDebugUtils.currentLine=1310739;
 //BA.debugLineNum = 1310739;BA.debugLine="End Sub";
return "";
}
public static String  _btn_snpcht_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_snpcht_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_snpcht_click", null));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub btn_snpcht_Click";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="main_webview.LoadUrl(\"https://accounts.snapchat.c";
mostCurrent._main_webview.LoadUrl("https://accounts.snapchat.com");
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="End Sub";
return "";
}
public static String  _btn_soundcloud_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_soundcloud_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_soundcloud_click", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub btn_soundcloud_Click";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="main_webview.LoadUrl(\"https://m.soundcloud.com\")";
mostCurrent._main_webview.LoadUrl("https://m.soundcloud.com");
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="End Sub";
return "";
}
public static String  _btn_startdownload_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_startdownload_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_startdownload_click", null));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub btn_startdownload_Click";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Try";
try {RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="If textbox_download_url.Text=\"\" Then";
if ((mostCurrent._textbox_download_url.getText()).equals("")) { 
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="ToastMessageShow(\"Please enter Site or Download";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter Site or Download URL"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="If Msgbox2(\"Are you sure that you have internet";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Are you sure that you have internet connection?"+anywheresoftware.b4a.keywords.Common.CRLF+"If you do not currently, as soon as you get a connection it will start downloading."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Once you start, you can't cancel downloading."+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Download Location : "+anywheresoftware.b4a.keywords.Common.File.getDirRootExternal()+"/Frigate/Download"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Save File Name : "+mostCurrent._textbox_download_url.getText()+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Link : "+mostCurrent._textbox_download_url.getText()),BA.ObjectToCharSequence("INFO - Frigate Downloader"),"Start Download","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="DownloaderService.DOWNLOAD_ADDRESS=textbox_dow";
mostCurrent._downloaderservice._download_address /*String*/  = mostCurrent._textbox_download_url.getText();
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="DownloaderService.DOWNLOAD_FILENAME=textbox_do";
mostCurrent._downloaderservice._download_filename /*String*/  = mostCurrent._textbox_download_filename.getText();
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="StartService(DownloaderService)";
anywheresoftware.b4a.keywords.Common.StartService(processBA,(Object)(mostCurrent._downloaderservice.getObject()));
 }else {
 };
 };
 } 
       catch (Exception e13) {
			processBA.setLastException(e13);RDebugUtils.currentLine=2883599;
 //BA.debugLineNum = 2883599;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("82883599",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=2883600;
 //BA.debugLineNum = 2883600;BA.debugLine="ToastMessageShow(\"Download Error !\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Download Error !"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2883602;
 //BA.debugLineNum = 2883602;BA.debugLine="End Sub";
return "";
}
public static String  _btn_telgrm_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_telgrm_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_telgrm_click", null));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub btn_telgrm_Click";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="main_webview.LoadUrl(\"https://web.telegram.org/#/";
mostCurrent._main_webview.LoadUrl("https://web.telegram.org/#/login");
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="End Sub";
return "";
}
public static String  _btn_twttr_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_twttr_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_twttr_click", null));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub btn_twttr_Click";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="main_webview.LoadUrl(\"https://twitter.com\")";
mostCurrent._main_webview.LoadUrl("https://twitter.com");
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="End Sub";
return "";
}
public static String  _btn_urlplus_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_urlplus_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_urlplus_click", null));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub btn_urlplus_Click";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="textbox_search_bar.Text=\"http://\"";
mostCurrent._textbox_search_bar.setText(BA.ObjectToCharSequence("http://"));
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="End Sub";
return "";
}
public static String  _btn_urlplus_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_urlplus_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_urlplus_longclick", null));}
b4a.util.BClipboard _urlpluscopy = null;
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub btn_urlplus_LongClick";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Try";
try {RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="Dim urlpluscopy As BClipboard";
_urlpluscopy = new b4a.util.BClipboard();
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="textbox_search_bar.Text=urlpluscopy.getText";
mostCurrent._textbox_search_bar.setText(BA.ObjectToCharSequence(_urlpluscopy.getText(mostCurrent.activityBA)));
 } 
       catch (Exception e5) {
			processBA.setLastException(e5);RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("83538949",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="End Sub";
return "";
}
public static String  _btn_youtube_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_youtube_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_youtube_click", null));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub btn_youtube_Click";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="main_webview.LoadUrl(\"https://m.youtube.com\")";
mostCurrent._main_webview.LoadUrl("https://m.youtube.com");
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="End Sub";
return "";
}
public static String  _btn_ytgames_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_ytgames_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_ytgames_click", null));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub btn_ytgames_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="main_webview.LoadUrl(\"https://m.youtube.com/gamin";
mostCurrent._main_webview.LoadUrl("https://m.youtube.com/gaming/");
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="Panel_Intergration.Visible=False";
mostCurrent._panel_intergration.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="End Sub";
return "";
}
public static String  _btn_zoomenabled_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_zoomenabled_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_zoomenabled_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub btn_zoomenabled_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="If ToggleButton_zoomenbl.Checked=True Then";
if (mostCurrent._togglebutton_zoomenbl.getChecked()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="btn_zoomenabled.TextColor=Colors.RGB(221,74,113)";
mostCurrent._btn_zoomenabled.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (221),(int) (74),(int) (113)));
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="main_webview.ZoomEnabled=True";
mostCurrent._main_webview.setZoomEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="WebViewSettings.setDisplayZoomControls(main_webv";
mostCurrent._webviewsettings.setDisplayZoomControls((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="WebView_ReadingFullScreen_Mode.ZoomEnabled=True";
mostCurrent._webview_readingfullscreen_mode.setZoomEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="WebViewSettings.setDisplayZoomControls(WebView_R";
mostCurrent._webviewsettings.setDisplayZoomControls((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="ToggleButton_zoomenbl.Checked=False";
mostCurrent._togglebutton_zoomenbl.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="ToastMessageShow(\"Zoom Enabled !\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Zoom Enabled !"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="ToastMessageShow(\"Zoom Disable !\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Zoom Disable !"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="WebViewSettings.setDisplayZoomControls(main_webv";
mostCurrent._webviewsettings.setDisplayZoomControls((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507340;
 //BA.debugLineNum = 1507340;BA.debugLine="btn_zoomenabled.TextColor=Colors.RGB(85,85,85)";
mostCurrent._btn_zoomenabled.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (85),(int) (85),(int) (85)));
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="main_webview.ZoomEnabled=False";
mostCurrent._main_webview.setZoomEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507342;
 //BA.debugLineNum = 1507342;BA.debugLine="WebView_ReadingFullScreen_Mode.ZoomEnabled=False";
mostCurrent._webview_readingfullscreen_mode.setZoomEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507343;
 //BA.debugLineNum = 1507343;BA.debugLine="WebViewSettings.setDisplayZoomControls(WebView_R";
mostCurrent._webviewsettings.setDisplayZoomControls((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507344;
 //BA.debugLineNum = 1507344;BA.debugLine="ToggleButton_zoomenbl.Checked=True";
mostCurrent._togglebutton_zoomenbl.setChecked(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="End Sub";
return "";
}
public static String  _button_applock_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button_applock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button_applock_click", null));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub Button_applock_Click";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="Panel_applock_settings.BringToFront";
mostCurrent._panel_applock_settings.BringToFront();
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="Panel_applock_settings.Visible=True";
mostCurrent._panel_applock_settings.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="Button_applock.Visible=False";
mostCurrent._button_applock.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521988;
 //BA.debugLineNum = 4521988;BA.debugLine="Button_history.Visible=False";
mostCurrent._button_history.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521989;
 //BA.debugLineNum = 4521989;BA.debugLine="btn_pannelsettings_reset.Visible=False";
mostCurrent._btn_pannelsettings_reset.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521990;
 //BA.debugLineNum = 4521990;BA.debugLine="btn_settingspanel_okandhide.Visible=False";
mostCurrent._btn_settingspanel_okandhide.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521991;
 //BA.debugLineNum = 4521991;BA.debugLine="End Sub";
return "";
}
public static String  _button_history_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button_history_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button_history_click", null));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub Button_history_Click";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="Panel_Settings_History.BringToFront";
mostCurrent._panel_settings_history.BringToFront();
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="Panel_Settings_History.Visible=True";
mostCurrent._panel_settings_history.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="Button_applock.Visible=False";
mostCurrent._button_applock.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="Button_history.Visible=False";
mostCurrent._button_history.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="btn_pannelsettings_reset.Visible=False";
mostCurrent._btn_pannelsettings_reset.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="btn_settingspanel_okandhide.Visible=False";
mostCurrent._btn_settingspanel_okandhide.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194311;
 //BA.debugLineNum = 4194311;BA.debugLine="End Sub";
return "";
}
public static String  _incog_timer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "incog_timer_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "incog_timer_tick", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub incog_timer_tick";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Fals";
mostCurrent._webviewsettings.setSaveFormData((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Fals";
mostCurrent._webviewsettings.setSavePassword((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="WebViewSettings.setSaveFormData(WebView_ReadingFu";
mostCurrent._webviewsettings.setSaveFormData((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="WebViewSettings.setSavePassword(WebView_ReadingFu";
mostCurrent._webviewsettings.setSavePassword((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="End Sub";
return "";
}
public static String  _listview_settings_hostory_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listview_settings_hostory_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "listview_settings_hostory_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub ListView_Settings_hostory_ItemClick (Position";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="ToastMessageShow(\"Long tap to open URL\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Long tap to open URL"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="End Sub";
return "";
}
public static String  _listview_settings_hostory_itemlongclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listview_settings_hostory_itemlongclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "listview_settings_hostory_itemlongclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub ListView_Settings_hostory_ItemLongClick (Posit";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="main_webview.LoadUrl(Value)";
mostCurrent._main_webview.LoadUrl(BA.ObjectToString(_value));
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="Panel_Settings_History.Visible=False";
mostCurrent._panel_settings_history.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="Panel_applock_settings.Visible=False";
mostCurrent._panel_applock_settings.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="Panel_Main_Settings.Visible=False";
mostCurrent._panel_main_settings.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="Button_applock.Visible=True";
mostCurrent._button_applock.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="Button_history.Visible=True";
mostCurrent._button_history.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="btn_pannelsettings_reset.Visible=True";
mostCurrent._btn_pannelsettings_reset.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="btn_settingspanel_okandhide.Visible=True";
mostCurrent._btn_settingspanel_okandhide.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="End Sub";
return "";
}
public static boolean  _main_webview_overrideurl(String _url) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "main_webview_overrideurl", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "main_webview_overrideurl", new Object[] {_url}));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub main_webview_OverrideUrl (Url As String) As Bo";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3932173;
 //BA.debugLineNum = 3932173;BA.debugLine="If Url.StartsWith(\"http://\") Or Url.StartsWith(\"h";
if (_url.startsWith("http://") || _url.startsWith("https://")) { 
RDebugUtils.currentLine=3932174;
 //BA.debugLineNum = 3932174;BA.debugLine="textbox_download_url.Text=Url";
mostCurrent._textbox_download_url.setText(BA.ObjectToCharSequence(_url));
 };
RDebugUtils.currentLine=3932179;
 //BA.debugLineNum = 3932179;BA.debugLine="End Sub";
return false;
}
public static String  _main_webview_pagefinished(String _url) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "main_webview_pagefinished", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "main_webview_pagefinished", new Object[] {_url}));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub main_webview_PageFinished (Url As String)";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="Try";
try {RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="textbox_search_bar.Text=main_webview.Url";
mostCurrent._textbox_search_bar.setText(BA.ObjectToCharSequence(mostCurrent._main_webview.getUrl()));
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="textbox_search_bar.Hint=WebViewExtender.getTitle(";
mostCurrent._textbox_search_bar.setHint(mostCurrent._webviewextender.getTitle((android.webkit.WebView)(mostCurrent._main_webview.getObject())));
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="btn_refreshclose.Visible=False";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="btn_refresh.Visible=True";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="If main_webview.Url.StartsWith(\"file:///\") Then";
if (mostCurrent._main_webview.getUrl().startsWith("file:///")) { 
RDebugUtils.currentLine=3997703;
 //BA.debugLineNum = 3997703;BA.debugLine="textbox_search_bar.Hint=\"Welcome to Frigate Brow";
mostCurrent._textbox_search_bar.setHint("Welcome to Frigate Browser Premium");
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="textbox_search_bar.Text=\"\"";
mostCurrent._textbox_search_bar.setText(BA.ObjectToCharSequence(""));
 };
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("83997707",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=3997710;
 //BA.debugLineNum = 3997710;BA.debugLine="Try";
try {RDebugUtils.currentLine=3997711;
 //BA.debugLineNum = 3997711;BA.debugLine="ListView_Settings_hostory.AddSingleLine( main_we";
mostCurrent._listview_settings_hostory.AddSingleLine(BA.ObjectToCharSequence(mostCurrent._main_webview.getUrl()));
RDebugUtils.currentLine=3997712;
 //BA.debugLineNum = 3997712;BA.debugLine="File.WriteList(File.DirDefaultExternal,\"history.";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"history.txt",(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(mostCurrent._listview_settings_hostory.getObject())));
 } 
       catch (Exception e17) {
			processBA.setLastException(e17);RDebugUtils.currentLine=3997714;
 //BA.debugLineNum = 3997714;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("83997714",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=3997717;
 //BA.debugLineNum = 3997717;BA.debugLine="End Sub";
return "";
}
public static String  _run_incog_timer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "run_incog_timer_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "run_incog_timer_tick", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub run_incog_timer_tick";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="WebViewSettings.setSaveFormData(main_webview,Fals";
mostCurrent._webviewsettings.setSaveFormData((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="WebViewSettings.setSavePassword(main_webview,Fals";
mostCurrent._webviewsettings.setSavePassword((android.webkit.WebView)(mostCurrent._main_webview.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="WebViewSettings.setSaveFormData(WebView_ReadingFu";
mostCurrent._webviewsettings.setSaveFormData((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="WebViewSettings.setSavePassword(WebView_ReadingFu";
mostCurrent._webviewsettings.setSavePassword((android.webkit.WebView)(mostCurrent._webview_readingfullscreen_mode.getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="End Sub";
return "";
}
public static void  _showfile_chooser(Object _filepathcallback,Object _filechooserparams) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showfile_chooser", false))
	 {Debug.delegate(mostCurrent.activityBA, "showfile_chooser", new Object[] {_filepathcallback,_filechooserparams}); return;}
ResumableSub_ShowFile_Chooser rsub = new ResumableSub_ShowFile_Chooser(null,_filepathcallback,_filechooserparams);
rsub.resume(processBA, null);
}
public static class ResumableSub_ShowFile_Chooser extends BA.ResumableSub {
public ResumableSub_ShowFile_Chooser(com.clenontec.webbrowser.main parent,Object _filepathcallback,Object _filechooserparams) {
this.parent = parent;
this._filepathcallback = _filepathcallback;
this._filechooserparams = _filechooserparams;
}
com.clenontec.webbrowser.main parent;
Object _filepathcallback;
Object _filechooserparams;
boolean _success = false;
String _dir = "";
String _filename = "";
anywheresoftware.b4j.object.JavaObject _jo = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="cc.Initialize(\"CC\")";
parent._cc.Initialize("CC");
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="cc.Show(\"*/*\", \"Choose File\")";
parent._cc.Show(processBA,"*/*","Choose File");
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Wait For CC_Result (Success As Boolean, Dir As St";
anywheresoftware.b4a.keywords.Common.WaitFor("cc_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "showfile_chooser"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (Boolean) result[0];
_dir = (String) result[1];
_filename = (String) result[2];
;
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="Dim jo As JavaObject = Me";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(main.getObject()));
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="If Success Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_success) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="Log(FileName)";
anywheresoftware.b4a.keywords.Common.LogImpl("8458758",_filename,0);
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="File.Copy(Dir, FileName, Starter.Provider.SharedF";
anywheresoftware.b4a.keywords.Common.File.Copy(_dir,_filename,parent.mostCurrent._starter._provider /*com.clenontec.webbrowser.fileprovider*/ ._sharedfolder /*String*/ ,"TempFile");
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="jo.RunMethod(\"SendResult\", Array(Starter.Provide";
_jo.RunMethod("SendResult",new Object[]{parent.mostCurrent._starter._provider /*com.clenontec.webbrowser.fileprovider*/ ._getfileuri /*Object*/ (null,"TempFile"),_filepathcallback});
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="jo.RunMethod(\"SendResult\", Array(Null, FilePathC";
_jo.RunMethod("SendResult",new Object[]{anywheresoftware.b4a.keywords.Common.Null,_filepathcallback});
 if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _textbox_search_bar_enterpressed() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "textbox_search_bar_enterpressed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "textbox_search_bar_enterpressed", null));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub textbox_search_bar_EnterPressed";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="btn_refreshclose.Visible=True";
mostCurrent._btn_refreshclose.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="btn_refresh.Visible=False";
mostCurrent._btn_refresh.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="If main_webview.Url.StartsWith(\"http://\")  Then";
if (mostCurrent._main_webview.getUrl().startsWith("http://")) { 
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="main_webview.LoadURL(textbox_search_bar.Text)";
mostCurrent._main_webview.LoadUrl(mostCurrent._textbox_search_bar.getText());
 }else {
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="If main_webview.Url.StartsWith(\"https://\")  Then";
if (mostCurrent._main_webview.getUrl().startsWith("https://")) { 
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="main_webview.LoadURL(textbox_search_bar.Text)";
mostCurrent._main_webview.LoadUrl(mostCurrent._textbox_search_bar.getText());
 }else {
RDebugUtils.currentLine=3211276;
 //BA.debugLineNum = 3211276;BA.debugLine="main_webview.LoadUrl(\"http://www.google.com/#q=";
mostCurrent._main_webview.LoadUrl("http://www.google.com/#q="+mostCurrent._textbox_search_bar.getText());
 };
 };
RDebugUtils.currentLine=3211282;
 //BA.debugLineNum = 3211282;BA.debugLine="End Sub";
return "";
}
public static String  _txtbox_applock_text_enterpressed() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtbox_applock_text_enterpressed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtbox_applock_text_enterpressed", null));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub Txtbox_applock_text_EnterPressed";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="If Txtbox_applock_text.Text=File.ReadString(File.";
if ((mostCurrent._txtbox_applock_text.getText()).equals(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"pscode.txt"))) { 
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="Panel_App_Lock.Visible=False";
mostCurrent._panel_app_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="Txtbox_applock_text.Text=\"\"";
mostCurrent._txtbox_applock_text.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="Txtbox_applock_text.Hint=\"Please try again !\"";
mostCurrent._txtbox_applock_text.setHint("Please try again !");
 };
RDebugUtils.currentLine=4587527;
 //BA.debugLineNum = 4587527;BA.debugLine="End Sub";
return "";
}
public static String  _txtbox_applock_text_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtbox_applock_text_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtbox_applock_text_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub Txtbox_applock_text_TextChanged (Old As String";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="If Txtbox_applock_text.Text=File.ReadString(File.";
if ((mostCurrent._txtbox_applock_text.getText()).equals(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"pscode.txt"))) { 
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="Panel_App_Lock.Visible=False";
mostCurrent._panel_app_lock.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4784132;
 //BA.debugLineNum = 4784132;BA.debugLine="Txtbox_applock_text.Text=\"\"";
mostCurrent._txtbox_applock_text.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4784133;
 //BA.debugLineNum = 4784133;BA.debugLine="Txtbox_applock_text.Hint=\"Please try again !\"";
mostCurrent._txtbox_applock_text.setHint("Please try again !");
 };
RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="End Sub";
return "";
}
public static void SendResult(Uri uri, ValueCallback<Uri[]> filePathCallback) {
	if (uri != null)
		filePathCallback.onReceiveValue(new Uri[] {uri});
	else
		filePathCallback.onReceiveValue(null);
		
}
public static class MyChromeClient extends WebChromeClient {
@Override
 public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback,
            FileChooserParams fileChooserParams) {
		processBA.raiseEventFromUI(this, "showfile_chooser", filePathCallback, fileChooserParams);
        return true;
    }
	}
}