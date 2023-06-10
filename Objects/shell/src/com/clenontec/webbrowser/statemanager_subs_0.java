package com.clenontec.webbrowser;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class statemanager_subs_0 {


public static RemoteObject  _getnextitem(RemoteObject _ba,RemoteObject _list1) throws Exception{
try {
		Debug.PushSubsStack("getNextItem (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,117);
if (RapidSub.canDelegate("getnextitem")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","getnextitem", _ba, _list1);}
;
Debug.locals.put("list1", _list1);
 BA.debugLineNum = 117;BA.debugLine="Private Sub getNextItem(list1 As List) As Object()";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="listPosition = listPosition + 1";
Debug.ShouldStop(2097152);
statemanager._listposition = RemoteObject.solve(new RemoteObject[] {statemanager._listposition,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 119;BA.debugLine="Return list1.Get(listPosition)";
Debug.ShouldStop(4194304);
if (true) return (_list1.runMethod(false,"Get",(Object)(statemanager._listposition)));
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getsetting(RemoteObject _ba,RemoteObject _key) throws Exception{
try {
		Debug.PushSubsStack("GetSetting (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,28);
if (RapidSub.canDelegate("getsetting")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","getsetting", _ba, _key);}
;
Debug.locals.put("Key", _key);
 BA.debugLineNum = 28;BA.debugLine="Public Sub GetSetting(Key As String) As String";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 29;BA.debugLine="Return GetSetting2(Key, \"\")";
Debug.ShouldStop(268435456);
if (true) return _getsetting2(_ba,_key,RemoteObject.createImmutable(""));
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getsetting2(RemoteObject _ba,RemoteObject _key,RemoteObject _defaultvalue) throws Exception{
try {
		Debug.PushSubsStack("GetSetting2 (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,13);
if (RapidSub.canDelegate("getsetting2")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","getsetting2", _ba, _key, _defaultvalue);}
RemoteObject _v = RemoteObject.createImmutable("");
;
Debug.locals.put("Key", _key);
Debug.locals.put("DefaultValue", _defaultvalue);
 BA.debugLineNum = 13;BA.debugLine="Public Sub GetSetting2(Key As String, DefaultValue";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="If settings.IsInitialized = False Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",statemanager._settings.runMethod(true,"IsInitialized"),statemanager.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 16;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
Debug.ShouldStop(32768);
if (statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._settingsfilename)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 17;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
Debug.ShouldStop(65536);
statemanager._settings = statemanager.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadMap",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._settingsfilename));
 }else {
 BA.debugLineNum = 19;BA.debugLine="Return DefaultValue";
Debug.ShouldStop(262144);
if (true) return _defaultvalue;
 };
 };
 BA.debugLineNum = 22;BA.debugLine="Dim v As String";
Debug.ShouldStop(2097152);
_v = RemoteObject.createImmutable("");Debug.locals.put("v", _v);
 BA.debugLineNum = 23;BA.debugLine="v = settings.GetDefault(Key.ToLowerCase, DefaultV";
Debug.ShouldStop(4194304);
_v = BA.ObjectToString(statemanager._settings.runMethod(false,"GetDefault",(Object)((_key.runMethod(true,"toLowerCase"))),(Object)((_defaultvalue))));Debug.locals.put("v", _v);
 BA.debugLineNum = 24;BA.debugLine="Return v";
Debug.ShouldStop(8388608);
if (true) return _v;
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _innerrestorestate(RemoteObject _ba,RemoteObject _v,RemoteObject _list1) throws Exception{
try {
		Debug.PushSubsStack("innerRestoreState (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,97);
if (RapidSub.canDelegate("innerrestorestate")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","innerrestorestate", _ba, _v, _list1);}
RemoteObject _data = null;
RemoteObject _check = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _radio = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _toggle = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
;
Debug.locals.put("v", _v);
Debug.locals.put("list1", _list1);
 BA.debugLineNum = 97;BA.debugLine="Private Sub innerRestoreState(v As View, list1 As";
Debug.ShouldStop(1);
 BA.debugLineNum = 98;BA.debugLine="Dim data() As Object";
Debug.ShouldStop(2);
_data = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("data", _data);
 BA.debugLineNum = 99;BA.debugLine="If v Is CheckBox Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.CheckBox"))) { 
 BA.debugLineNum = 100;BA.debugLine="Dim check As CheckBox";
Debug.ShouldStop(8);
_check = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("check", _check);
 BA.debugLineNum = 101;BA.debugLine="check = v";
Debug.ShouldStop(16);
_check.setObject(_v.getObject());
 BA.debugLineNum = 102;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(32);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 103;BA.debugLine="check.Checked = data(0)";
Debug.ShouldStop(64);
_check.runMethodAndSync(true,"setChecked",BA.ObjectToBoolean(_data.getArrayElement(false,BA.numberCast(int.class, 0))));
 }else 
{ BA.debugLineNum = 104;BA.debugLine="Else If v Is RadioButton Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.RadioButton"))) { 
 BA.debugLineNum = 105;BA.debugLine="Dim radio As RadioButton";
Debug.ShouldStop(256);
_radio = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");Debug.locals.put("radio", _radio);
 BA.debugLineNum = 106;BA.debugLine="radio = v";
Debug.ShouldStop(512);
_radio.setObject(_v.getObject());
 BA.debugLineNum = 107;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(1024);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 108;BA.debugLine="radio.Checked = data(0)";
Debug.ShouldStop(2048);
_radio.runMethodAndSync(true,"setChecked",BA.ObjectToBoolean(_data.getArrayElement(false,BA.numberCast(int.class, 0))));
 }else 
{ BA.debugLineNum = 109;BA.debugLine="Else If v Is ToggleButton Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.ToggleButton"))) { 
 BA.debugLineNum = 110;BA.debugLine="Dim toggle As ToggleButton";
Debug.ShouldStop(8192);
_toggle = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");Debug.locals.put("toggle", _toggle);
 BA.debugLineNum = 111;BA.debugLine="toggle = v";
Debug.ShouldStop(16384);
_toggle.setObject(_v.getObject());
 BA.debugLineNum = 112;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(32768);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 113;BA.debugLine="toggle.Checked = data(0)";
Debug.ShouldStop(65536);
_toggle.runMethodAndSync(true,"setChecked",BA.ObjectToBoolean(_data.getArrayElement(false,BA.numberCast(int.class, 0))));
 }}}
;
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _innersavestate(RemoteObject _ba,RemoteObject _v,RemoteObject _list1) throws Exception{
try {
		Debug.PushSubsStack("innerSaveState (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,79);
if (RapidSub.canDelegate("innersavestate")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","innersavestate", _ba, _v, _list1);}
RemoteObject _data = null;
RemoteObject _check = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _radio = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _toggle = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
;
Debug.locals.put("v", _v);
Debug.locals.put("list1", _list1);
 BA.debugLineNum = 79;BA.debugLine="Private Sub innerSaveState(v As View, list1 As Lis";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="Dim data() As Object";
Debug.ShouldStop(32768);
_data = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("data", _data);
 BA.debugLineNum = 81;BA.debugLine="If v Is CheckBox Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.CheckBox"))) { 
 BA.debugLineNum = 82;BA.debugLine="Dim check As CheckBox";
Debug.ShouldStop(131072);
_check = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("check", _check);
 BA.debugLineNum = 83;BA.debugLine="check = v";
Debug.ShouldStop(262144);
_check.setObject(_v.getObject());
 BA.debugLineNum = 84;BA.debugLine="data = Array As Object(check.Checked)";
Debug.ShouldStop(524288);
_data = RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_check.runMethod(true,"getChecked"))});Debug.locals.put("data", _data);
 }else 
{ BA.debugLineNum = 85;BA.debugLine="Else If v Is RadioButton Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.RadioButton"))) { 
 BA.debugLineNum = 86;BA.debugLine="Dim radio As RadioButton";
Debug.ShouldStop(2097152);
_radio = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");Debug.locals.put("radio", _radio);
 BA.debugLineNum = 87;BA.debugLine="radio = v";
Debug.ShouldStop(4194304);
_radio.setObject(_v.getObject());
 BA.debugLineNum = 88;BA.debugLine="data = Array As Object(radio.Checked)";
Debug.ShouldStop(8388608);
_data = RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_radio.runMethod(true,"getChecked"))});Debug.locals.put("data", _data);
 }else 
{ BA.debugLineNum = 89;BA.debugLine="Else If v Is ToggleButton Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.ToggleButton"))) { 
 BA.debugLineNum = 90;BA.debugLine="Dim toggle As ToggleButton";
Debug.ShouldStop(33554432);
_toggle = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");Debug.locals.put("toggle", _toggle);
 BA.debugLineNum = 91;BA.debugLine="toggle = v";
Debug.ShouldStop(67108864);
_toggle.setObject(_v.getObject());
 BA.debugLineNum = 92;BA.debugLine="data = Array As Object(toggle.Checked)";
Debug.ShouldStop(134217728);
_data = RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_toggle.runMethod(true,"getChecked"))});Debug.locals.put("data", _data);
 }}}
;
 BA.debugLineNum = 94;BA.debugLine="If data.Length > 0 Then list1.Add(data)";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean(">",_data.getField(true,"length"),BA.numberCast(double.class, 0))) { 
_list1.runVoidMethod ("Add",(Object)((_data)));};
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadstatefile(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("loadStateFile (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,151);
if (RapidSub.canDelegate("loadstatefile")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","loadstatefile", _ba);}
RemoteObject _raf = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.RandomAccessFile");
;
 BA.debugLineNum = 151;BA.debugLine="Private Sub loadStateFile";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 153;BA.debugLine="If states.IsInitialized Then Return";
Debug.ShouldStop(16777216);
if (statemanager._states.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 154;BA.debugLine="If File.Exists(File.DirInternal, statesFileName)";
Debug.ShouldStop(33554432);
if (statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._statesfilename)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 155;BA.debugLine="Dim raf As RandomAccessFile";
Debug.ShouldStop(67108864);
_raf = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.RandomAccessFile");Debug.locals.put("raf", _raf);
 BA.debugLineNum = 156;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
Debug.ShouldStop(134217728);
_raf.runVoidMethod ("Initialize",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._statesfilename),(Object)(statemanager.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 157;BA.debugLine="states = raf.ReadObject(0)";
Debug.ShouldStop(268435456);
statemanager._states.setObject(_raf.runMethod(false,"ReadObject",(Object)(BA.numberCast(long.class, 0))));
 BA.debugLineNum = 158;BA.debugLine="raf.Close";
Debug.ShouldStop(536870912);
_raf.runVoidMethod ("Close");
 };
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Dim states As Map";
statemanager._states = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 5;BA.debugLine="Dim listPosition As Int";
statemanager._listposition = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 6;BA.debugLine="Dim statesFileName, settingsFileName As String";
statemanager._statesfilename = RemoteObject.createImmutable("");
statemanager._settingsfilename = RemoteObject.createImmutable("");
 //BA.debugLineNum = 7;BA.debugLine="statesFileName = \"state.dat\"";
statemanager._statesfilename = BA.ObjectToString("state.dat");
 //BA.debugLineNum = 8;BA.debugLine="settingsFileName = \"settings.properties\"";
statemanager._settingsfilename = BA.ObjectToString("settings.properties");
 //BA.debugLineNum = 9;BA.debugLine="Dim settings As Map";
statemanager._settings = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _resetstate(RemoteObject _ba,RemoteObject _activityname) throws Exception{
try {
		Debug.PushSubsStack("ResetState (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,52);
if (RapidSub.canDelegate("resetstate")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","resetstate", _ba, _activityname);}
;
Debug.locals.put("ActivityName", _activityname);
 BA.debugLineNum = 52;BA.debugLine="Public Sub ResetState(ActivityName As String)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="loadStateFile";
Debug.ShouldStop(1048576);
_loadstatefile(_ba);
 BA.debugLineNum = 54;BA.debugLine="If states.IsInitialized Then";
Debug.ShouldStop(2097152);
if (statemanager._states.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 55;BA.debugLine="states.Remove(ActivityName.ToLowerCase)";
Debug.ShouldStop(4194304);
statemanager._states.runVoidMethod ("Remove",(Object)((_activityname.runMethod(true,"toLowerCase"))));
 BA.debugLineNum = 56;BA.debugLine="writeStateToFile";
Debug.ShouldStop(8388608);
_writestatetofile(_ba);
 };
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _restorestate(RemoteObject _ba,RemoteObject _activity,RemoteObject _activityname,RemoteObject _validperiodinminutes) throws Exception{
try {
		Debug.PushSubsStack("RestoreState (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,125);
if (RapidSub.canDelegate("restorestate")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","restorestate", _ba, _activity, _activityname, _validperiodinminutes);}
RemoteObject _list1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _time = RemoteObject.createImmutable(0L);
int _i = 0;
;
Debug.locals.put("Activity", _activity);
Debug.locals.put("ActivityName", _activityname);
Debug.locals.put("ValidPeriodInMinutes", _validperiodinminutes);
 BA.debugLineNum = 125;BA.debugLine="Public Sub RestoreState(Activity As Activity, Acti";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 127;BA.debugLine="loadStateFile";
Debug.ShouldStop(1073741824);
_loadstatefile(_ba);
 BA.debugLineNum = 128;BA.debugLine="If states.IsInitialized = False Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",statemanager._states.runMethod(true,"IsInitialized"),statemanager.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 129;BA.debugLine="Return False";
Debug.ShouldStop(1);
Debug.CheckDeviceExceptions();if (true) return statemanager.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 131;BA.debugLine="Dim list1 As List";
Debug.ShouldStop(4);
_list1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list1", _list1);
 BA.debugLineNum = 132;BA.debugLine="list1 = states.Get(ActivityName.ToLowerCase)";
Debug.ShouldStop(8);
_list1.setObject(statemanager._states.runMethod(false,"Get",(Object)((_activityname.runMethod(true,"toLowerCase")))));
 BA.debugLineNum = 133;BA.debugLine="If list1.IsInitialized = False Then Return False";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_list1.runMethod(true,"IsInitialized"),statemanager.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return statemanager.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 134;BA.debugLine="Dim time As Long";
Debug.ShouldStop(32);
_time = RemoteObject.createImmutable(0L);Debug.locals.put("time", _time);
 BA.debugLineNum = 135;BA.debugLine="time = list1.Get(0)";
Debug.ShouldStop(64);
_time = BA.numberCast(long.class, _list1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("time", _time);
 BA.debugLineNum = 136;BA.debugLine="If ValidPeriodInMinutes > 0 And time + ValidPeri";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean(">",_validperiodinminutes,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("<",RemoteObject.solve(new RemoteObject[] {_time,_validperiodinminutes,statemanager.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerMinute")}, "+*",1, 2),BA.numberCast(double.class, statemanager.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))) { 
 BA.debugLineNum = 137;BA.debugLine="Return False";
Debug.ShouldStop(256);
Debug.CheckDeviceExceptions();if (true) return statemanager.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 139;BA.debugLine="listPosition = 0";
Debug.ShouldStop(1024);
statemanager._listposition = BA.numberCast(int.class, 0);
 BA.debugLineNum = 140;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
Debug.ShouldStop(2048);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_activity.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 141;BA.debugLine="innerRestoreState(Activity.GetView(i), list1)";
Debug.ShouldStop(4096);
_innerrestorestate(_ba,_activity.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))),_list1);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 143;BA.debugLine="Return True";
Debug.ShouldStop(16384);
Debug.CheckDeviceExceptions();if (true) return statemanager.mostCurrent.__c.getField(true,"True");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e20) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e20.toString()); BA.debugLineNum = 145;BA.debugLine="Log(\"Error loading state.\")";
Debug.ShouldStop(65536);
statemanager.mostCurrent.__c.runVoidMethod ("LogImpl","86881300",RemoteObject.createImmutable("Error loading state."),0);
 BA.debugLineNum = 146;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(131072);
statemanager.mostCurrent.__c.runVoidMethod ("LogImpl","86881301",statemanager.mostCurrent.__c.runMethod(false,"LastException",_ba).runMethod(true,"getMessage"),0);
 BA.debugLineNum = 147;BA.debugLine="Return False";
Debug.ShouldStop(262144);
if (true) return statemanager.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 149;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savesettings(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("SaveSettings (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,45);
if (RapidSub.canDelegate("savesettings")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","savesettings", _ba);}
;
 BA.debugLineNum = 45;BA.debugLine="Public Sub SaveSettings";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="If settings.IsInitialized Then";
Debug.ShouldStop(8192);
if (statemanager._settings.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 47;BA.debugLine="File.WriteMap(File.DirInternal, settingsFileName";
Debug.ShouldStop(16384);
statemanager.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteMap",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._settingsfilename),(Object)(statemanager._settings));
 };
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savestate(RemoteObject _ba,RemoteObject _activity,RemoteObject _activityname) throws Exception{
try {
		Debug.PushSubsStack("SaveState (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,60);
if (RapidSub.canDelegate("savestate")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","savestate", _ba, _activity, _activityname);}
RemoteObject _list1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
;
Debug.locals.put("Activity", _activity);
Debug.locals.put("ActivityName", _activityname);
 BA.debugLineNum = 60;BA.debugLine="Public Sub SaveState(Activity As Activity, Activit";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="If states.IsInitialized = False Then states.Initi";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",statemanager._states.runMethod(true,"IsInitialized"),statemanager.mostCurrent.__c.getField(true,"False"))) { 
statemanager._states.runVoidMethod ("Initialize");};
 BA.debugLineNum = 62;BA.debugLine="Dim list1 As List";
Debug.ShouldStop(536870912);
_list1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list1", _list1);
 BA.debugLineNum = 63;BA.debugLine="list1.Initialize";
Debug.ShouldStop(1073741824);
_list1.runVoidMethod ("Initialize");
 BA.debugLineNum = 64;BA.debugLine="list1.Add(DateTime.Now)";
Debug.ShouldStop(-2147483648);
_list1.runVoidMethod ("Add",(Object)((statemanager.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 65;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
Debug.ShouldStop(1);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_activity.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 66;BA.debugLine="innerSaveState(Activity.GetView(i), list1)";
Debug.ShouldStop(2);
_innersavestate(_ba,_activity.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))),_list1);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 68;BA.debugLine="states.Put(ActivityName.ToLowerCase, list1)";
Debug.ShouldStop(8);
statemanager._states.runVoidMethod ("Put",(Object)((_activityname.runMethod(true,"toLowerCase"))),(Object)((_list1.getObject())));
 BA.debugLineNum = 69;BA.debugLine="writeStateToFile";
Debug.ShouldStop(16);
_writestatetofile(_ba);
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setsetting(RemoteObject _ba,RemoteObject _key,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SetSetting (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,32);
if (RapidSub.canDelegate("setsetting")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","setsetting", _ba, _key, _value);}
;
Debug.locals.put("Key", _key);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 32;BA.debugLine="Public Sub SetSetting(Key As String, Value As Stri";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="If settings.IsInitialized = False Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",statemanager._settings.runMethod(true,"IsInitialized"),statemanager.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 35;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
Debug.ShouldStop(4);
if (statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._settingsfilename)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 36;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
Debug.ShouldStop(8);
statemanager._settings = statemanager.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadMap",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._settingsfilename));
 }else {
 BA.debugLineNum = 38;BA.debugLine="settings.Initialize";
Debug.ShouldStop(32);
statemanager._settings.runVoidMethod ("Initialize");
 };
 };
 BA.debugLineNum = 41;BA.debugLine="settings.Put(Key.ToLowerCase, Value)";
Debug.ShouldStop(256);
statemanager._settings.runVoidMethod ("Put",(Object)((_key.runMethod(true,"toLowerCase"))),(Object)((_value)));
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _writestatetofile(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("writeStateToFile (statemanager) ","statemanager",5,_ba,statemanager.mostCurrent,72);
if (RapidSub.canDelegate("writestatetofile")) { return com.clenontec.webbrowser.statemanager.remoteMe.runUserSub(false, "statemanager","writestatetofile", _ba);}
RemoteObject _raf = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.RandomAccessFile");
;
 BA.debugLineNum = 72;BA.debugLine="Private Sub writeStateToFile";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="Dim raf As RandomAccessFile";
Debug.ShouldStop(256);
_raf = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.RandomAccessFile");Debug.locals.put("raf", _raf);
 BA.debugLineNum = 74;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
Debug.ShouldStop(512);
_raf.runVoidMethod ("Initialize",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._statesfilename),(Object)(statemanager.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 75;BA.debugLine="raf.WriteObject(states, True, raf.CurrentPosition";
Debug.ShouldStop(1024);
_raf.runVoidMethod ("WriteObject",(Object)((statemanager._states.getObject())),(Object)(statemanager.mostCurrent.__c.getField(true,"True")),(Object)(_raf.getField(true,"CurrentPosition")));
 BA.debugLineNum = 76;BA.debugLine="raf.Close";
Debug.ShouldStop(2048);
_raf.runVoidMethod ("Close");
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}