package com.clenontec.webbrowser;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class statemanager {
private static statemanager mostCurrent = new statemanager();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.collections.Map _states = null;
public static int _listposition = 0;
public static String _statesfilename = "";
public static String _settingsfilename = "";
public static anywheresoftware.b4a.objects.collections.Map _settings = null;
public com.clenontec.webbrowser.main _main = null;
public com.clenontec.webbrowser.starter _starter = null;
public com.clenontec.webbrowser.downloaderservice _downloaderservice = null;
public com.clenontec.webbrowser.utils _utils = null;
public static Object[]  _getnextitem(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "getnextitem", false))
	 {return ((Object[]) Debug.delegate(null, "getnextitem", new Object[] {_ba,_list1}));}
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Private Sub getNextItem(list1 As List) As Object()";
RDebugUtils.currentLine=6815745;
 //BA.debugLineNum = 6815745;BA.debugLine="listPosition = listPosition + 1";
_listposition = (int) (_listposition+1);
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="Return list1.Get(listPosition)";
if (true) return (Object[])(_list1.Get(_listposition));
RDebugUtils.currentLine=6815747;
 //BA.debugLineNum = 6815747;BA.debugLine="End Sub";
return null;
}
public static String  _getsetting(anywheresoftware.b4a.BA _ba,String _key) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "getsetting", false))
	 {return ((String) Debug.delegate(null, "getsetting", new Object[] {_ba,_key}));}
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Public Sub GetSetting(Key As String) As String";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="Return GetSetting2(Key, \"\")";
if (true) return _getsetting2(_ba,_key,"");
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="End Sub";
return "";
}
public static String  _getsetting2(anywheresoftware.b4a.BA _ba,String _key,String _defaultvalue) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "getsetting2", false))
	 {return ((String) Debug.delegate(null, "getsetting2", new Object[] {_ba,_key,_defaultvalue}));}
String _v = "";
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Public Sub GetSetting2(Key As String, DefaultValue";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=6225926;
 //BA.debugLineNum = 6225926;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
 };
RDebugUtils.currentLine=6225929;
 //BA.debugLineNum = 6225929;BA.debugLine="Dim v As String";
_v = "";
RDebugUtils.currentLine=6225930;
 //BA.debugLineNum = 6225930;BA.debugLine="v = settings.GetDefault(Key.ToLowerCase, DefaultV";
_v = BA.ObjectToString(_settings.GetDefault((Object)(_key.toLowerCase()),(Object)(_defaultvalue)));
RDebugUtils.currentLine=6225931;
 //BA.debugLineNum = 6225931;BA.debugLine="Return v";
if (true) return _v;
RDebugUtils.currentLine=6225932;
 //BA.debugLineNum = 6225932;BA.debugLine="End Sub";
return "";
}
public static String  _innerrestorestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "innerrestorestate", false))
	 {return ((String) Debug.delegate(null, "innerrestorestate", new Object[] {_ba,_v,_list1}));}
Object[] _data = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _check = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _toggle = null;
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Private Sub innerRestoreState(v As View, list1 As";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=6750212;
 //BA.debugLineNum = 6750212;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=6750213;
 //BA.debugLineNum = 6750213;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=6750214;
 //BA.debugLineNum = 6750214;BA.debugLine="check.Checked = data(0)";
_check.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=6750215;
 //BA.debugLineNum = 6750215;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=6750216;
 //BA.debugLineNum = 6750216;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=6750217;
 //BA.debugLineNum = 6750217;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=6750218;
 //BA.debugLineNum = 6750218;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=6750219;
 //BA.debugLineNum = 6750219;BA.debugLine="radio.Checked = data(0)";
_radio.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=6750220;
 //BA.debugLineNum = 6750220;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=6750221;
 //BA.debugLineNum = 6750221;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=6750222;
 //BA.debugLineNum = 6750222;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=6750223;
 //BA.debugLineNum = 6750223;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=6750224;
 //BA.debugLineNum = 6750224;BA.debugLine="toggle.Checked = data(0)";
_toggle.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }}}
;
RDebugUtils.currentLine=6750226;
 //BA.debugLineNum = 6750226;BA.debugLine="End Sub";
return "";
}
public static String  _innersavestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "innersavestate", false))
	 {return ((String) Debug.delegate(null, "innersavestate", new Object[] {_ba,_v,_list1}));}
Object[] _data = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _check = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _toggle = null;
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Private Sub innerSaveState(v As View, list1 As Lis";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=6684677;
 //BA.debugLineNum = 6684677;BA.debugLine="data = Array As Object(check.Checked)";
_data = new Object[]{(Object)(_check.getChecked())};
 }else 
{RDebugUtils.currentLine=6684678;
 //BA.debugLineNum = 6684678;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=6684679;
 //BA.debugLineNum = 6684679;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=6684680;
 //BA.debugLineNum = 6684680;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=6684681;
 //BA.debugLineNum = 6684681;BA.debugLine="data = Array As Object(radio.Checked)";
_data = new Object[]{(Object)(_radio.getChecked())};
 }else 
{RDebugUtils.currentLine=6684682;
 //BA.debugLineNum = 6684682;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=6684683;
 //BA.debugLineNum = 6684683;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=6684684;
 //BA.debugLineNum = 6684684;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=6684685;
 //BA.debugLineNum = 6684685;BA.debugLine="data = Array As Object(toggle.Checked)";
_data = new Object[]{(Object)(_toggle.getChecked())};
 }}}
;
RDebugUtils.currentLine=6684687;
 //BA.debugLineNum = 6684687;BA.debugLine="If data.Length > 0 Then list1.Add(data)";
if (_data.length>0) { 
_list1.Add((Object)(_data));};
RDebugUtils.currentLine=6684688;
 //BA.debugLineNum = 6684688;BA.debugLine="End Sub";
return "";
}
public static String  _loadstatefile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "loadstatefile", false))
	 {return ((String) Debug.delegate(null, "loadstatefile", new Object[] {_ba}));}
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Private Sub loadStateFile";
RDebugUtils.currentLine=6946818;
 //BA.debugLineNum = 6946818;BA.debugLine="If states.IsInitialized Then Return";
if (_states.IsInitialized()) { 
if (true) return "";};
RDebugUtils.currentLine=6946819;
 //BA.debugLineNum = 6946819;BA.debugLine="If File.Exists(File.DirInternal, statesFileName)";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename)) { 
RDebugUtils.currentLine=6946820;
 //BA.debugLineNum = 6946820;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=6946821;
 //BA.debugLineNum = 6946821;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6946822;
 //BA.debugLineNum = 6946822;BA.debugLine="states = raf.ReadObject(0)";
_states.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_raf.ReadObject((long) (0))));
RDebugUtils.currentLine=6946823;
 //BA.debugLineNum = 6946823;BA.debugLine="raf.Close";
_raf.Close();
 };
RDebugUtils.currentLine=6946825;
 //BA.debugLineNum = 6946825;BA.debugLine="End Sub";
return "";
}
public static String  _resetstate(anywheresoftware.b4a.BA _ba,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "resetstate", false))
	 {return ((String) Debug.delegate(null, "resetstate", new Object[] {_ba,_activityname}));}
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Public Sub ResetState(ActivityName As String)";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="If states.IsInitialized Then";
if (_states.IsInitialized()) { 
RDebugUtils.currentLine=6488067;
 //BA.debugLineNum = 6488067;BA.debugLine="states.Remove(ActivityName.ToLowerCase)";
_states.Remove((Object)(_activityname.toLowerCase()));
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
 };
RDebugUtils.currentLine=6488070;
 //BA.debugLineNum = 6488070;BA.debugLine="End Sub";
return "";
}
public static String  _writestatetofile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "writestatetofile", false))
	 {return ((String) Debug.delegate(null, "writestatetofile", new Object[] {_ba}));}
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Private Sub writeStateToFile";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="raf.WriteObject(states, True, raf.CurrentPosition";
_raf.WriteObject((Object)(_states.getObject()),anywheresoftware.b4a.keywords.Common.True,_raf.CurrentPosition);
RDebugUtils.currentLine=6619140;
 //BA.debugLineNum = 6619140;BA.debugLine="raf.Close";
_raf.Close();
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="End Sub";
return "";
}
public static boolean  _restorestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname,int _validperiodinminutes) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "restorestate", false))
	 {return ((Boolean) Debug.delegate(null, "restorestate", new Object[] {_ba,_activity,_activityname,_validperiodinminutes}));}
anywheresoftware.b4a.objects.collections.List _list1 = null;
long _time = 0L;
int _i = 0;
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Public Sub RestoreState(Activity As Activity, Acti";
RDebugUtils.currentLine=6881281;
 //BA.debugLineNum = 6881281;BA.debugLine="Try";
try {RDebugUtils.currentLine=6881282;
 //BA.debugLineNum = 6881282;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=6881283;
 //BA.debugLineNum = 6881283;BA.debugLine="If states.IsInitialized = False Then";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=6881284;
 //BA.debugLineNum = 6881284;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6881286;
 //BA.debugLineNum = 6881286;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6881287;
 //BA.debugLineNum = 6881287;BA.debugLine="list1 = states.Get(ActivityName.ToLowerCase)";
_list1.setObject((java.util.List)(_states.Get((Object)(_activityname.toLowerCase()))));
RDebugUtils.currentLine=6881288;
 //BA.debugLineNum = 6881288;BA.debugLine="If list1.IsInitialized = False Then Return False";
if (_list1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6881289;
 //BA.debugLineNum = 6881289;BA.debugLine="Dim time As Long";
_time = 0L;
RDebugUtils.currentLine=6881290;
 //BA.debugLineNum = 6881290;BA.debugLine="time = list1.Get(0)";
_time = BA.ObjectToLongNumber(_list1.Get((int) (0)));
RDebugUtils.currentLine=6881291;
 //BA.debugLineNum = 6881291;BA.debugLine="If ValidPeriodInMinutes > 0 And time + ValidPeri";
if (_validperiodinminutes>0 && _time+_validperiodinminutes*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute<anywheresoftware.b4a.keywords.Common.DateTime.getNow()) { 
RDebugUtils.currentLine=6881292;
 //BA.debugLineNum = 6881292;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6881294;
 //BA.debugLineNum = 6881294;BA.debugLine="listPosition = 0";
_listposition = (int) (0);
RDebugUtils.currentLine=6881295;
 //BA.debugLineNum = 6881295;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step15 = 1;
final int limit15 = (int) (_activity.getNumberOfViews()-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=6881296;
 //BA.debugLineNum = 6881296;BA.debugLine="innerRestoreState(Activity.GetView(i), list1)";
_innerrestorestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=6881298;
 //BA.debugLineNum = 6881298;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e20) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e20);RDebugUtils.currentLine=6881300;
 //BA.debugLineNum = 6881300;BA.debugLine="Log(\"Error loading state.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("86881300","Error loading state.",0);
RDebugUtils.currentLine=6881301;
 //BA.debugLineNum = 6881301;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("86881301",anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage(),0);
RDebugUtils.currentLine=6881302;
 //BA.debugLineNum = 6881302;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=6881304;
 //BA.debugLineNum = 6881304;BA.debugLine="End Sub";
return false;
}
public static String  _savesettings(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "savesettings", false))
	 {return ((String) Debug.delegate(null, "savesettings", new Object[] {_ba}));}
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Public Sub SaveSettings";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="If settings.IsInitialized Then";
if (_settings.IsInitialized()) { 
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="File.WriteMap(File.DirInternal, settingsFileName";
anywheresoftware.b4a.keywords.Common.File.WriteMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename,_settings);
 };
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="End Sub";
return "";
}
public static String  _savestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "savestate", false))
	 {return ((String) Debug.delegate(null, "savestate", new Object[] {_ba,_activity,_activityname}));}
anywheresoftware.b4a.objects.collections.List _list1 = null;
int _i = 0;
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Public Sub SaveState(Activity As Activity, Activit";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="If states.IsInitialized = False Then states.Initi";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_states.Initialize();};
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="list1.Initialize";
_list1.Initialize();
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="list1.Add(DateTime.Now)";
_list1.Add((Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=6553605;
 //BA.debugLineNum = 6553605;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step5 = 1;
final int limit5 = (int) (_activity.getNumberOfViews()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=6553606;
 //BA.debugLineNum = 6553606;BA.debugLine="innerSaveState(Activity.GetView(i), list1)";
_innersavestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=6553608;
 //BA.debugLineNum = 6553608;BA.debugLine="states.Put(ActivityName.ToLowerCase, list1)";
_states.Put((Object)(_activityname.toLowerCase()),(Object)(_list1.getObject()));
RDebugUtils.currentLine=6553609;
 //BA.debugLineNum = 6553609;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
RDebugUtils.currentLine=6553610;
 //BA.debugLineNum = 6553610;BA.debugLine="End Sub";
return "";
}
public static String  _setsetting(anywheresoftware.b4a.BA _ba,String _key,String _value) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "setsetting", false))
	 {return ((String) Debug.delegate(null, "setsetting", new Object[] {_ba,_key,_value}));}
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Public Sub SetSetting(Key As String, Value As Stri";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=6356998;
 //BA.debugLineNum = 6356998;BA.debugLine="settings.Initialize";
_settings.Initialize();
 };
 };
RDebugUtils.currentLine=6357001;
 //BA.debugLineNum = 6357001;BA.debugLine="settings.Put(Key.ToLowerCase, Value)";
_settings.Put((Object)(_key.toLowerCase()),(Object)(_value));
RDebugUtils.currentLine=6357002;
 //BA.debugLineNum = 6357002;BA.debugLine="End Sub";
return "";
}
}