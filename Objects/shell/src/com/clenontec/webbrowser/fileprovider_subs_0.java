package com.clenontec.webbrowser;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class fileprovider_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Public SharedFolder As String";
fileprovider._sharedfolder = RemoteObject.createImmutable("");__ref.setField("_sharedfolder",fileprovider._sharedfolder);
 //BA.debugLineNum = 4;BA.debugLine="Public UseFileProvider As Boolean";
fileprovider._usefileprovider = RemoteObject.createImmutable(false);__ref.setField("_usefileprovider",fileprovider._usefileprovider);
 //BA.debugLineNum = 5;BA.debugLine="Private rp As RuntimePermissions";
fileprovider._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");__ref.setField("_rp",fileprovider._rp);
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _getfileuri(RemoteObject __ref,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("GetFileUri (fileprovider) ","fileprovider",2,__ref.getField(false, "ba"),__ref,22);
if (RapidSub.canDelegate("getfileuri")) { return __ref.runUserSub(false, "fileprovider","getfileuri", __ref, _filename);}
RemoteObject _uri = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _f = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _fp = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _context = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 22;BA.debugLine="Public Sub GetFileUri (FileName As String) As Obje";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 24;BA.debugLine="If UseFileProvider = False Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_usefileprovider" /*RemoteObject*/ ),fileprovider.__c.getField(true,"False"))) { 
 BA.debugLineNum = 25;BA.debugLine="Dim uri As JavaObject";
Debug.ShouldStop(16777216);
_uri = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("uri", _uri);
 BA.debugLineNum = 26;BA.debugLine="Return uri.InitializeStatic(\"android.net.Uri\").R";
Debug.ShouldStop(33554432);
if (true) return _uri.runMethod(false,"InitializeStatic",(Object)(RemoteObject.createImmutable("android.net.Uri"))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("parse")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.concat(RemoteObject.createImmutable("file://"),fileprovider.__c.getField(false,"File").runMethod(true,"Combine",(Object)(__ref.getField(true,"_sharedfolder" /*RemoteObject*/ )),(Object)(_filename))))})));
 }else {
 BA.debugLineNum = 28;BA.debugLine="Dim f As JavaObject";
Debug.ShouldStop(134217728);
_f = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("f", _f);
 BA.debugLineNum = 29;BA.debugLine="f.InitializeNewInstance(\"java.io.File\", Array(Sh";
Debug.ShouldStop(268435456);
_f.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("java.io.File")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(__ref.getField(true,"_sharedfolder" /*RemoteObject*/ )),(_filename)})));
 BA.debugLineNum = 30;BA.debugLine="Dim fp As JavaObject";
Debug.ShouldStop(536870912);
_fp = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("fp", _fp);
 BA.debugLineNum = 31;BA.debugLine="Dim context As JavaObject";
Debug.ShouldStop(1073741824);
_context = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("context", _context);
 BA.debugLineNum = 32;BA.debugLine="context.InitializeContext";
Debug.ShouldStop(-2147483648);
_context.runVoidMethod ("InitializeContext",__ref.getField(false, "ba"));
 BA.debugLineNum = 33;BA.debugLine="fp.InitializeStatic(\"android.support.v4.content.";
Debug.ShouldStop(1);
_fp.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.support.v4.content.FileProvider")));
 BA.debugLineNum = 34;BA.debugLine="Return fp.RunMethod(\"getUriForFile\", Array(conte";
Debug.ShouldStop(2);
if (true) return _fp.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getUriForFile")),(Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_context.getObject()),(RemoteObject.concat(fileprovider.__c.getField(false,"Application").runMethod(true,"getPackageName"),RemoteObject.createImmutable(".provider"))),(_f.getObject())})));
 };
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (fileprovider) ","fileprovider",2,__ref.getField(false, "ba"),__ref,8);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "fileprovider","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(128);
 BA.debugLineNum = 9;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(256);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 10;BA.debugLine="If p.SdkVersion >= 22 Or File.ExternalWritable =";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 22)) || RemoteObject.solveBoolean("=",fileprovider.__c.getField(false,"File").runMethod(true,"getExternalWritable"),fileprovider.__c.getField(true,"False"))) { 
 BA.debugLineNum = 11;BA.debugLine="UseFileProvider = True";
Debug.ShouldStop(1024);
__ref.setField ("_usefileprovider" /*RemoteObject*/ ,fileprovider.__c.getField(true,"True"));
 BA.debugLineNum = 12;BA.debugLine="SharedFolder = File.Combine(File.DirInternal, \"s";
Debug.ShouldStop(2048);
__ref.setField ("_sharedfolder" /*RemoteObject*/ ,fileprovider.__c.getField(false,"File").runMethod(true,"Combine",(Object)(fileprovider.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("shared"))));
 BA.debugLineNum = 13;BA.debugLine="File.MakeDir(\"\", SharedFolder)";
Debug.ShouldStop(4096);
fileprovider.__c.getField(false,"File").runVoidMethod ("MakeDir",(Object)(BA.ObjectToString("")),(Object)(__ref.getField(true,"_sharedfolder" /*RemoteObject*/ )));
 }else {
 BA.debugLineNum = 15;BA.debugLine="UseFileProvider = False";
Debug.ShouldStop(16384);
__ref.setField ("_usefileprovider" /*RemoteObject*/ ,fileprovider.__c.getField(true,"False"));
 BA.debugLineNum = 16;BA.debugLine="SharedFolder = rp.GetSafeDirDefaultExternal(\"sha";
Debug.ShouldStop(32768);
__ref.setField ("_sharedfolder" /*RemoteObject*/ ,__ref.getField(false,"_rp" /*RemoteObject*/ ).runMethod(true,"GetSafeDirDefaultExternal",(Object)(RemoteObject.createImmutable("shared"))));
 };
 BA.debugLineNum = 18;BA.debugLine="Log($\"Using FileProvider? ${UseFileProvider}\"$)";
Debug.ShouldStop(131072);
fileprovider.__c.runVoidMethod ("LogImpl","85308426",(RemoteObject.concat(RemoteObject.createImmutable("Using FileProvider? "),fileprovider.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((__ref.getField(true,"_usefileprovider" /*RemoteObject*/ )))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 19;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setfileuriasintentdata(RemoteObject __ref,RemoteObject _intent,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("SetFileUriAsIntentData (fileprovider) ","fileprovider",2,__ref.getField(false, "ba"),__ref,40);
if (RapidSub.canDelegate("setfileuriasintentdata")) { return __ref.runUserSub(false, "fileprovider","setfileuriasintentdata", __ref, _intent, _filename);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("Intent", _intent);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 40;BA.debugLine="Public Sub SetFileUriAsIntentData (Intent As Inten";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="Dim jo As JavaObject = Intent";
Debug.ShouldStop(256);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(_intent.getObject());Debug.locals.put("jo", _jo);
 BA.debugLineNum = 42;BA.debugLine="jo.RunMethod(\"setData\", Array(GetFileUri(FileName";
Debug.ShouldStop(512);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setData")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {__ref.runClassMethod (com.clenontec.webbrowser.fileprovider.class, "_getfileuri" /*RemoteObject*/ ,(Object)(_filename))})));
 BA.debugLineNum = 43;BA.debugLine="Intent.Flags = Bit.Or(Intent.Flags, 1) 'FLAG_GRAN";
Debug.ShouldStop(1024);
_intent.runMethod(true,"setFlags",fileprovider.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(_intent.runMethod(true,"getFlags")),(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}