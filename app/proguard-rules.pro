# Release protection baseline. R8 is enabled in release builds.
-renamesourcefileattribute SourceFile
-keepattributes LineNumberTable

# Keep only classes required by reflection if such libraries are added later.
# Do not put secrets/API keys in the APK; keep sensitive validation server-side.
