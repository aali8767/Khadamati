@echo off
SETLOCAL EnableDelayedExpansion

set "targetDir=C:\Users\hp\AndroidStudioProjects\finalProject\app\src\main\java\dev\final_group\khadamati"

set "oldPackage=com.example.finalproject"
set "newPackage=dev.final_group.khadamati"

echo 🔍 Searching in: %targetDir%
echo 🛠 Replacing %oldPackage% --> %newPackage%
echo ------------------------------------------

for /r "%targetDir%" %%f in (*.java *.kt) do (
    echo 🔄 Processing: %%f
    powershell -Command "(Get-Content -Raw -Encoding UTF8 '%%f') -replace '%oldPackage%', '%newPackage%' | Set-Content -Encoding UTF8 '%%f'"
)

echo ✅ Replacement complete!
pause
