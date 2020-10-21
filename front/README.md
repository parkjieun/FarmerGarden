# front

apk 같은 경우 yarn 명령어로 해야 작동됩니다. npm 오작동 할 수 있습니다. 

## Project setup
```
> yarn install

> vue add cordoda

? Name of folder where cordova should be installed (src-cordova)
> src-cordova

? ID of the app (com.vue.example.app)
> com.vue.nongbunae.app

? Name of the app (VueExampleAppName)
> 농부네텃밭

Select Platforms: (Press <space> to select, <a> to toggle all, <i> to invert selection)
>(●) Android
```

### Compiles and hot-reloads for development
```
vue 프로젝트 컴파일
> yarn serve

apk dev 컴파일
> yarn cordova-serve-android

파일 생성 경로
{vue 프로젝트}/src-cordova/platforms/android/app/build/outputs/apk/debug/app-debug.apk
```

### Compiles and minifies for production
```
vue 프로젝트 배포
> yarn build

apk 배포 컴파일
위에서 생성된 dist 폴더를 src-cordova/www/폴더에 내용을 넣어줍니다.
> cordova build android --release

파일 생성 경로
{vue 프로젝트}/src-cordova/platforms/android/app/build/outputs/apk/release/app-release-unsigned.apk

apk 서명을 위한 키생성(안드로이드 개발환경 필요)
> keytool-genkeypair -v -keystore android.keystore -alias android-app-key -keyalg RSA -keysize 2048 -validity 10000
> keytool -importkeystore -srckeystore android.keystore -destkeystore android.keystore -deststoretype pkcs12

서명을 apk와 합치기(JDK 필요)
> jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore android.keystore app-release-unsigned.apk android-app-key

 - verbose : 로그들을 자세히 출력 옵션
 - sigalg : 서명 알고리즘의 이름을 명시. 가이드가 권장한 SHA1withRSA 사용.
 - digestalg : 다이제스트 알고리즘.
 - keystore : 키 스토어 주소 옵션.
 
apk 파일 최적화(zipalign은 안드로이드 스튜디오 설치 후 직접 찾아서 PATH를 설정하거나 경로로 직접 실행. 저는 복사해서 apk파일에 붙여넣고 경로로 실행했습니다.)
.\zipalign.exe -v 4 app-release-unsigned.apk app-release.apk
```