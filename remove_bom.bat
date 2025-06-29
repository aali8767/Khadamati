@echo off
SETLOCAL EnableDelayedExpansion

:: المسار الذي يحتوي على الملفات المتضررة
set "targetDir=C:\Users\hp\AndroidStudioProjects\finalProject"

echo 🧹 Removing BOM from all text files in: %targetDir%
echo -----------------------------------------

:: البحث داخل الملفات النصية المطلوبة
for /r "%targetDir%" %%f in (*.java *.kt *.xml *.gradle *.dart) do (
    echo 🔄 Processing: %%f
    powershell -Command ^
        "$content = Get-Content -Raw -Encoding Byte '%%f'; ^
        if ($content.Length -gt 3 -and $content[0] -eq 239 -and $content[1] -eq 187 -and $content[2] -eq 191) { ^
            $content = $content[3..($content.Length - 1)]; ^
            [System.IO.File]::WriteAllBytes('%%f', $content) ^
        }"
)

echo ✅ Done! BOM removed where detected.
pause
