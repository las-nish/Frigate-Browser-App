
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "com.clenontec.webbrowser.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _cc = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.ContentChooser");
public static RemoteObject _main_webview = RemoteObject.declareNull("anywheresoftware.b4a.objects.WebViewWrapper");
public static RemoteObject _main_panel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel_navigation_bar = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btn_drawer = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_home = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_fowrd = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_back = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panel_search_bar = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btn_search = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _textbox_search_bar = RemoteObject.declareNull("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
public static RemoteObject _btn_refresh = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panel_drawer = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btn_appexit = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_shareapp = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_helpguide = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_appsettingsmore = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_readingfullscreenmode = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_darkmode = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_downloader = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_shareweburl = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_imagedisable = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_openweblinkanotherbrowser = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_screenshot = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_intergrton = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_clearalldataapp = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_batterysaver = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_jsdisable = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_zoomenabled = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panel_intergration = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btn_extrasites = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_panel_intergration_hide = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_soundcloud = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_youtube = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_snpcht = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_telgrm = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_rddit = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_pintrst = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_lnkdin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_twttr = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_fb = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_instr = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_ytgames = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_quora = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panel_downloader = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btn_hidedownloadpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_startdownload = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _textbox_download_filename = RemoteObject.declareNull("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
public static RemoteObject _textbox_download_url = RemoteObject.declareNull("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
public static RemoteObject _lbl_paneldownload_head = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _panel_downloader_header_color = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btn_downloadbooster_panel = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _webview_readingfullscreen_mode = RemoteObject.declareNull("anywheresoftware.b4a.objects.WebViewWrapper");
public static RemoteObject _btn_fullscreenreadingmode_exit = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_fullscreen_fowrd = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_fullscreen_back = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button_applock = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button_exportdata = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lbl_searchengine = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _radiobutton_google = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _radiobutton_duck = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _lbl_sitesecurity = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _checkbox_savepass = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _checkbox_dnt = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _lbl_sitesetting = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _checkbox_js = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _checkbox_boostmode = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _checkbox_cookie = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _radiobutton_bing = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _radiobutton_yahoo = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _checkbox_safesearch = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _panel_applock_settings = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _textbox_applock_password_set = RemoteObject.declareNull("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
public static RemoteObject _lbl_passcodelock = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbl_passcode_info = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _checkbox_applock_enable = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _btn_applocksave = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_password_panelhide = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _textbox_retype_passcodepleteedittext1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
public static RemoteObject _button_history = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panel_settings_history = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel_app_lock = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbl_applock_hint = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _imageview_applocker = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _txtbox_applock_text = RemoteObject.declareNull("anywheresoftware.b4a.objects.AutoCompleteEditTextWrapper");
public static RemoteObject _togglebutton_drawer = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
public static RemoteObject _downloadmanager1 = RemoteObject.declareNull("uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager");
public static RemoteObject _panel_hide_buttons = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _rpa = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
public static RemoteObject _togglebutton_imagedisable = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
public static RemoteObject _togglebuttonnightmode = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
public static RemoteObject _webviewextender = RemoteObject.declareNull("thalmy.webviewxtended.xtender");
public static RemoteObject _webviewsettings = RemoteObject.declareNull("uk.co.martinpearman.b4a.webviewsettings.WebViewSettings");
public static RemoteObject _webviewextras = RemoteObject.declareNull("uk.co.martinpearman.b4a.webviewextras.WebViewExtras");
public static RemoteObject _panel_webview_readingfullscreen_mode = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel_main_settings = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btn_pannelsettings_reset = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_settingspanel_okandhide = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _togglebuttonincog = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
public static RemoteObject _btn_refreshclose = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_urlplus = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btn_runappbackground = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _togglebutton_js = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
public static RemoteObject _togglebutton_bttrysave = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
public static RemoteObject _btn_history_hide = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _listview_settings_hostory = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _btn_clearhistory = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lbl_applockpagedata = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _togglebutton_zoomenbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
public static com.clenontec.webbrowser.starter _starter = null;
public static com.clenontec.webbrowser.downloaderservice _downloaderservice = null;
public static com.clenontec.webbrowser.utils _utils = null;
public static com.clenontec.webbrowser.statemanager _statemanager = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"btn_appexit",main.mostCurrent._btn_appexit,"btn_applocksave",main.mostCurrent._btn_applocksave,"btn_appsettingsmore",main.mostCurrent._btn_appsettingsmore,"btn_back",main.mostCurrent._btn_back,"btn_batterysaver",main.mostCurrent._btn_batterysaver,"btn_clearalldataapp",main.mostCurrent._btn_clearalldataapp,"btn_clearHistory",main.mostCurrent._btn_clearhistory,"btn_darkmode",main.mostCurrent._btn_darkmode,"btn_downloadbooster_panel",main.mostCurrent._btn_downloadbooster_panel,"btn_downloader",main.mostCurrent._btn_downloader,"btn_drawer",main.mostCurrent._btn_drawer,"btn_extrasites",main.mostCurrent._btn_extrasites,"btn_fb",main.mostCurrent._btn_fb,"btn_fowrd",main.mostCurrent._btn_fowrd,"btn_fullscreen_back",main.mostCurrent._btn_fullscreen_back,"btn_fullscreen_fowrd",main.mostCurrent._btn_fullscreen_fowrd,"btn_fullscreenreadingmode_exit",main.mostCurrent._btn_fullscreenreadingmode_exit,"btn_helpguide",main.mostCurrent._btn_helpguide,"btn_hidedownloadpanel",main.mostCurrent._btn_hidedownloadpanel,"btn_history_hide",main.mostCurrent._btn_history_hide,"btn_home",main.mostCurrent._btn_home,"btn_imagedisable",main.mostCurrent._btn_imagedisable,"btn_instr",main.mostCurrent._btn_instr,"btn_intergrton",main.mostCurrent._btn_intergrton,"btn_jsdisable",main.mostCurrent._btn_jsdisable,"btn_lnkdin",main.mostCurrent._btn_lnkdin,"btn_openweblinkanotherbrowser",main.mostCurrent._btn_openweblinkanotherbrowser,"btn_panel_intergration_hide",main.mostCurrent._btn_panel_intergration_hide,"btn_pannelsettings_reset",main.mostCurrent._btn_pannelsettings_reset,"btn_password_panelHide",main.mostCurrent._btn_password_panelhide,"btn_pintrst",main.mostCurrent._btn_pintrst,"btn_quora",main.mostCurrent._btn_quora,"btn_rddit",main.mostCurrent._btn_rddit,"btn_readingfullscreenmode",main.mostCurrent._btn_readingfullscreenmode,"btn_refresh",main.mostCurrent._btn_refresh,"btn_refreshclose",main.mostCurrent._btn_refreshclose,"btn_runappbackground",main.mostCurrent._btn_runappbackground,"btn_screenshot",main.mostCurrent._btn_screenshot,"btn_search",main.mostCurrent._btn_search,"btn_settingspanel_okandhide",main.mostCurrent._btn_settingspanel_okandhide,"btn_shareapp",main.mostCurrent._btn_shareapp,"btn_shareweburl",main.mostCurrent._btn_shareweburl,"btn_snpcht",main.mostCurrent._btn_snpcht,"btn_soundcloud",main.mostCurrent._btn_soundcloud,"btn_startdownload",main.mostCurrent._btn_startdownload,"btn_telgrm",main.mostCurrent._btn_telgrm,"btn_twttr",main.mostCurrent._btn_twttr,"btn_urlplus",main.mostCurrent._btn_urlplus,"btn_youtube",main.mostCurrent._btn_youtube,"btn_ytgames",main.mostCurrent._btn_ytgames,"btn_zoomenabled",main.mostCurrent._btn_zoomenabled,"Button_applock",main.mostCurrent._button_applock,"Button_exportdata",main.mostCurrent._button_exportdata,"Button_history",main.mostCurrent._button_history,"cc",main._cc,"CheckBox_applock_enable",main.mostCurrent._checkbox_applock_enable,"CheckBox_boostmode",main.mostCurrent._checkbox_boostmode,"CheckBox_cookie",main.mostCurrent._checkbox_cookie,"CheckBox_dnt",main.mostCurrent._checkbox_dnt,"CheckBox_js",main.mostCurrent._checkbox_js,"CheckBox_safesearch",main.mostCurrent._checkbox_safesearch,"CheckBox_savepass",main.mostCurrent._checkbox_savepass,"DownloaderService",Debug.moduleToString(com.clenontec.webbrowser.downloaderservice.class),"DownloadManager1",main.mostCurrent._downloadmanager1,"ImageView_applocker",main.mostCurrent._imageview_applocker,"lbl_applock_hint",main.mostCurrent._lbl_applock_hint,"lbl_applockpagedata",main.mostCurrent._lbl_applockpagedata,"lbl_paneldownload_head",main.mostCurrent._lbl_paneldownload_head,"lbl_passcode_info",main.mostCurrent._lbl_passcode_info,"lbl_passcodelock",main.mostCurrent._lbl_passcodelock,"LBL_SEARCHENGINE",main.mostCurrent._lbl_searchengine,"lbl_sitesecurity",main.mostCurrent._lbl_sitesecurity,"lbl_sitesetting",main.mostCurrent._lbl_sitesetting,"ListView_Settings_hostory",main.mostCurrent._listview_settings_hostory,"Main_Panel",main.mostCurrent._main_panel,"main_webview",main.mostCurrent._main_webview,"Panel_App_Lock",main.mostCurrent._panel_app_lock,"Panel_applock_settings",main.mostCurrent._panel_applock_settings,"Panel_Downloader",main.mostCurrent._panel_downloader,"Panel_Downloader_Header_Color",main.mostCurrent._panel_downloader_header_color,"Panel_Drawer",main.mostCurrent._panel_drawer,"PANEL_HIDE_BUTTONS",main.mostCurrent._panel_hide_buttons,"Panel_Intergration",main.mostCurrent._panel_intergration,"Panel_Main_Settings",main.mostCurrent._panel_main_settings,"Panel_Navigation_Bar",main.mostCurrent._panel_navigation_bar,"Panel_Search_Bar",main.mostCurrent._panel_search_bar,"Panel_Settings_History",main.mostCurrent._panel_settings_history,"Panel_WebView_ReadingFullScreen_Mode",main.mostCurrent._panel_webview_readingfullscreen_mode,"RadioButton_bing",main.mostCurrent._radiobutton_bing,"RadioButton_duck",main.mostCurrent._radiobutton_duck,"RadioButton_google",main.mostCurrent._radiobutton_google,"RadioButton_yahoo",main.mostCurrent._radiobutton_yahoo,"rpa",main.mostCurrent._rpa,"Starter",Debug.moduleToString(com.clenontec.webbrowser.starter.class),"StateManager",Debug.moduleToString(com.clenontec.webbrowser.statemanager.class),"TextBox_applock_password_set",main.mostCurrent._textbox_applock_password_set,"textbox_download_filename",main.mostCurrent._textbox_download_filename,"textbox_download_url",main.mostCurrent._textbox_download_url,"Textbox_retype_passcodepleteEditText1",main.mostCurrent._textbox_retype_passcodepleteedittext1,"textbox_search_bar",main.mostCurrent._textbox_search_bar,"ToggleButton_bttrysave",main.mostCurrent._togglebutton_bttrysave,"ToggleButton_drawer",main.mostCurrent._togglebutton_drawer,"ToggleButton_imagedisable",main.mostCurrent._togglebutton_imagedisable,"ToggleButton_js",main.mostCurrent._togglebutton_js,"ToggleButton_zoomenbl",main.mostCurrent._togglebutton_zoomenbl,"ToggleButtonIncog",main.mostCurrent._togglebuttonincog,"ToggleButtonNightmode",main.mostCurrent._togglebuttonnightmode,"Txtbox_applock_text",main.mostCurrent._txtbox_applock_text,"Utils",Debug.moduleToString(com.clenontec.webbrowser.utils.class),"WebView_ReadingFullScreen_Mode",main.mostCurrent._webview_readingfullscreen_mode,"WebViewExtender",main.mostCurrent._webviewextender,"webviewextras",main.mostCurrent._webviewextras,"WebViewSettings",main.mostCurrent._webviewsettings};
}
}