Public Class Form1

    Private Sub Button1_Click(sender As System.Object, e As System.EventArgs) Handles Button1.Click
        Dim bmp As New Bitmap("pngimage.png")
        For j = 0 To 50
            For i = 0 To bmp.Width - 1
                Dim pixel As Color = bmp.GetPixel(i, j)
                Dim r = pixel.R And 1
                Dim g = pixel.G And 1
                Dim b = pixel.B And 1
                Dim a = pixel.A And 1
                If (r Xor b Xor g Xor a) = 1 Then
                    TextBox1.Text += r.ToString
                End If
            Next
        Next
    End Sub
End Class
