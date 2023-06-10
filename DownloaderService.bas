B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=8
@EndOfDesignText@
#Region Module Attributes
	#StartAtBoot: False
#End Region

'Service module
Sub Process_Globals
	
	Dim DOWNLOAD_ADDRESS As String
	Dim DOWNLOAD_FILENAME As String
	
	'	DownloadId is a unique identifier assigned by the DownloadManager to this download task
	Dim DownloadId As Long
	Dim DownloadManager1 As DownloadManager
End Sub

Sub Service_Create
	'	RegisterReceiver enables DownloadManager to raise events
	DownloadManager1.RegisterReceiver("DownloadManager1")
	
	'	Utils is a helper code module
	If Utils.IsInitialized=False Then
		Utils.Initialize(DownloadManager1)
	End If
End Sub

Sub Service_Start (StartingIntent As Intent)
	Try
		Dim DownloadManagerRequest1 As DownloadManagerRequest
		DownloadManagerRequest1.Initialize(DOWNLOAD_ADDRESS)
		DownloadManagerRequest1.Description= "Frigate Smart Downloader"
		'	save the download to external memory
		Try
			DownloadManagerRequest1.DestinationUri="file://"&File.Combine(File.DirRootExternal & "/Frigate/Download", DOWNLOAD_FILENAME)
		Catch
			Log(LastException)
			If Msgbox2("Directory Unavailable or STORAGE PERMISSION denied !"& CRLF & CRLF & "Get Permission : Open Settings > Apps > Configure Apps > App Permissions > Storage > Frigate Browser","READ CAREFULLY","Open Settings","","No",Null)=DialogResponse.POSITIVE Then
				Dim DoIntent As Intent
				DoIntent.Initialize("android.settings.MANAGE_APPLICATIONS_SETTINGS", "")
				StartActivity(DoIntent)
			Else
			End If
		End Try

		DownloadManagerRequest1.Title=DOWNLOAD_FILENAME
		DownloadManagerRequest1.VisibleInDownloadsUi=True
	
		DownloadId=DownloadManager1.Enqueue(DownloadManagerRequest1)
	Catch
		Log(LastException)
		ToastMessageShow("Download Error !",True)
	End Try
	
End Sub

Sub Service_Destroy
	Try
		'	by unregistering the BroadcastReceiver the DownloadManager will no longer raise events
		DownloadManager1.UnregisterReceiver
	Catch
		Log(LastException)
		ToastMessageShow("Download Error !",True)
	End Try

End Sub

Sub DownloadManager1_DownloadComplete(DownloadId1 As Long)
	Try
		'	this does not guarantee that the download has actually successfully downloaded
		'	it means a DownloadMananger DownloadManagerRequest has completed
		'	we need to find that status of that request but only if that request matches the request we started
	
		If DownloadId=DownloadId1 Then
			'	this is the download request we started
			'	query the DownloadManager for info on this request
			Dim DownloadManagerQuery1 As DownloadManagerQuery
			DownloadManagerQuery1.Initialize
			DownloadManagerQuery1.SetFilterById(DownloadId)
		
			'	you must enable the SQL library to work with the Cursor object
			Dim StatusCursor As Cursor
			'	pass our DownloadManagerQuery to the DownloadManager
			StatusCursor=DownloadManager1.Query(DownloadManagerQuery1)
			If StatusCursor.RowCount>0 Then
				StatusCursor.Position=0
			
				Dim StatusInt As Int
				StatusInt=StatusCursor.getInt(DownloadManager1.COLUMN_STATUS)
				Log("Download Status = "&Utils.GetStatusText(StatusInt))

				If StatusInt=DownloadManager1.STATUS_FAILED Or StatusInt=DownloadManager1.STATUS_PAUSED Then
					Dim ReasonInt As Int
					ReasonInt=StatusCursor.GetInt(DownloadManager1.COLUMN_REASON)
					Log("Status Reason = "&Utils.GetReasonText(ReasonInt))
				End If
			
				If StatusInt=DownloadManager1.STATUS_SUCCESSFUL Then
					'CallSub2(Main, "ShowBitmap", LoadBitmap(File.DirRootExternal, DOWNLOAD_FILENAME))
					ToastMessageShow("Download Successfull !" & CRLF & "Location : " & File.DirRootExternal & "/Frigate/Download"& CRLF &"File : " & DOWNLOAD_FILENAME,True)
				End If
			Else
				'	always check that the Cursor returned from the DownloadManager Query method is not empty
				Log("The DownloadManager has no trace of our request, it could have been cancelled by the user using the Android Downloads app or an unknown error has occurred.")
			End If
		
			StatusCursor.Close
			StopService("")
		End If
	Catch
		Log(LastException)
		ToastMessageShow("Download Error !",True)
	End Try
	
End Sub

Sub DownloadManager1_NotificationClicked(DownloadIds() As Long)
	Try
		ToastMessageShow("Download Length : "&DownloadIds.Length,True)
	
		Log("DownloadManager1_NotificationClicked our download request is: "&DownloadId)
		If DownloadIds<>Null Then
			Log("DownloadIds length is: "&DownloadIds.Length)
		
			Dim i As Int
			For i=0 To DownloadIds.Length-1
				Log("DownloadIds("&i&")="&DownloadIds(i))
			Next
		Else
			Log("DownloadIds is Null")
		End If
	Catch
		Log(LastException)
		ToastMessageShow("Download Error !",True)
	End Try
	
End Sub