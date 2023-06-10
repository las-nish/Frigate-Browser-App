B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=5.5
@EndOfDesignText@
'StateManager v1.20
'Code module
Sub Process_Globals
	Dim states As Map
	Dim listPosition As Int
	Dim statesFileName, settingsFileName As String
	statesFileName = "state.dat"
	settingsFileName = "settings.properties"
	Dim settings As Map
End Sub
'Gets the setting value associated with the given key.
'Returns the DefaultValue parameter if the key was not found.
Public Sub GetSetting2(Key As String, DefaultValue As String) As String
	If settings.IsInitialized = False Then
		'load the stored settings
		If File.Exists(File.DirInternal, settingsFileName) Then 
			settings = File.ReadMap(File.DirInternal, settingsFileName)
		Else
			Return DefaultValue
		End If
	End If
	Dim v As String
	v = settings.GetDefault(Key.ToLowerCase, DefaultValue)
	Return v
End Sub
'Gets the setting value associated with the given key.
'Returns an empty string if the key was not found.
Public Sub GetSetting(Key As String) As String
	Return GetSetting2(Key, "")
End Sub

Public Sub SetSetting(Key As String, Value As String)
	If settings.IsInitialized = False Then
		'load the stored settings
		If File.Exists(File.DirInternal, settingsFileName) Then 
			settings = File.ReadMap(File.DirInternal, settingsFileName)
		Else
			settings.Initialize
		End If
	End If
	settings.Put(Key.ToLowerCase, Value)
End Sub

'Stored the settings in a File
Public Sub SaveSettings
	If settings.IsInitialized Then
		File.WriteMap(File.DirInternal, settingsFileName, settings)
	End If
End Sub

'Resets the stored state data for this activity.
Public Sub ResetState(ActivityName As String)
	loadStateFile
	If states.IsInitialized Then 
		states.Remove(ActivityName.ToLowerCase)
		writeStateToFile
	End If
End Sub
'Saves the activity state. ActivityName - Used for handling multiple activities.
Public Sub SaveState(Activity As Activity, ActivityName As String)
	If states.IsInitialized = False Then states.Initialize
	Dim list1 As List
	list1.Initialize
	list1.Add(DateTime.Now)
	For i = 0 To Activity.NumberOfViews - 1
		innerSaveState(Activity.GetView(i), list1)
	Next
	states.Put(ActivityName.ToLowerCase, list1)
	writeStateToFile
End Sub

Private Sub writeStateToFile
	Dim raf As RandomAccessFile
	raf.Initialize(File.DirInternal, statesFileName, False)
	raf.WriteObject(states, True, raf.CurrentPosition)
	raf.Close
End Sub

Private Sub innerSaveState(v As View, list1 As List)
	Dim data() As Object
	If v Is CheckBox Then
		Dim check As CheckBox
		check = v
		data = Array As Object(check.Checked)
	Else If v Is RadioButton Then
		Dim radio As RadioButton
		radio = v
		data = Array As Object(radio.Checked)	
	Else If v Is ToggleButton Then
		Dim toggle As ToggleButton
		toggle = v
		data = Array As Object(toggle.Checked)
	End If
	If data.Length > 0 Then list1.Add(data)
End Sub

Private Sub innerRestoreState(v As View, list1 As List)
	Dim data() As Object
	If v Is CheckBox Then
		Dim check As CheckBox
		check = v
		data = getNextItem(list1)
		check.Checked = data(0)
	Else If v Is RadioButton Then
		Dim radio As RadioButton
		radio = v
		data = getNextItem(list1)
		radio.Checked = data(0)
	Else If v Is ToggleButton Then
		Dim toggle As ToggleButton
		toggle = v
		data = getNextItem(list1)
		toggle.Checked = data(0)
	End If
End Sub

Private Sub getNextItem(list1 As List) As Object()
	listPosition = listPosition + 1
	Return list1.Get(listPosition)
End Sub
'Loads the stored state (if such is available)
'ActivityName - Should match the value use in SaveState
'ValidPeriodInMinutes - The validity period of this state measured in minutes. Pass 0 for an unlimited period.
'Returns true if the state was loaded
Public Sub RestoreState(Activity As Activity, ActivityName As String, ValidPeriodInMinutes As Int) As Boolean
	Try
		loadStateFile
		If states.IsInitialized = False Then
			Return False
		End If
		Dim list1 As List
		list1 = states.Get(ActivityName.ToLowerCase)
		If list1.IsInitialized = False Then Return False
		Dim time As Long
		time = list1.Get(0)
		If ValidPeriodInMinutes > 0 And time + ValidPeriodInMinutes * DateTime.TicksPerMinute < DateTime.Now Then
			Return False
		End If
		listPosition = 0
		For i = 0 To Activity.NumberOfViews - 1
			innerRestoreState(Activity.GetView(i), list1)
		Next
		Return True
	Catch
		Log("Error loading state.")
		Log(LastException.Message)
		Return False
	End Try
End Sub

Private Sub loadStateFile
	'only load the state if it is not already available in memory.
	If states.IsInitialized Then Return
	If File.Exists(File.DirInternal, statesFileName) Then
		Dim raf As RandomAccessFile
		raf.Initialize(File.DirInternal, statesFileName, False)
		states = raf.ReadObject(0)
		raf.Close
	End If
End Sub
