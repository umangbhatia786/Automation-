Function WorksheetExists(WSName As String) As Boolean
    On Error Resume Next
    WorksheetExists = Worksheets(WSName).Name = WSName
    On Error GoTo 0
End Function

Private Sub InsertSheets_Click()
     Application.ScreenUpdating = False
     Application.DisplayAlerts = False
     Dim wS As Worksheet, sh As Worksheet
     Dim Rws As Long, rng As range, c As range
     Set sh = Sheets("Codes")
     Set wS = Sheets("Default_Test")

    With sh
        Rws = .Cells(Rows.Count, "A").End(xlUp).Row
        Set rng = .range(.Cells(2, 1), .Cells(Rws, 1))
    End With
    For Each c In rng.Cells
        If WorksheetExists(c.Value) Then
            MsgBox "Sheet " & c & " exists"
        Else:
            wS.Copy After:=Worksheets(Worksheets.Count)
            Worksheets(Worksheets.Count).Name = "Price_Plan_" & c.Value

        End If
    Next c
    
    Application.ScreenUpdating = True
    Application.DisplayAlerts = True
End Sub

Private Sub Reset_Click_Click()
    Application.DisplayAlerts = False
    Dim wS As Worksheet
    For Each wS In ThisWorkbook.Sheets
        If wS.Name Like "*Price_Plan_*" Then wS.Delete
    Next wS
    Application.DisplayAlerts = True
End Sub

Private Sub Start_Click_Click()
    Dim wS As Worksheet, LastRow As Long
    Dim codeArray As Variant
    Dim lastCell As String
    Dim curSheet As Worksheet
    Dim ArraySheets() As String
    Dim x As Variant

    
    Set wS = ThisWorkbook.Worksheets("Codes")
    
    'Here we look in Column A
    LastRow = wS.Cells(wS.Rows.Count, "A").End(xlUp).Row
    
    'Here we create array of our row values
    ThisWorkbook.Sheets("Codes").Activate
    codeArray = wS.range("A2:A" & LastRow).Value
    
    'Getting Array of Price Plan Sheets
    For Each curSheet In ActiveWorkbook.Worksheets
        If curSheet.Name Like "Price_Plan*" Then
            ReDim Preserve ArraySheets(x)
            ArraySheets(x) = curSheet.Name
            x = x + 1
        End If
    Next curSheet
    
End Sub
