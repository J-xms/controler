adb 发送广播  
发给动态注册的广播  
adb shell am broadcast -a system.control --es keyCode cancelMute com.example.controler  
adb shell am broadcast -a system.control --es keyCode mute com.example.controler  

发给静态注册的广播  
adb shell am broadcast -a test.system.control --es keyCode cancelMute com.example.controler  
adb shell am broadcast -a test.system.control --es keyCode mute com.example.controler  

adb 启动service
(这个命令需要先启动app)
adb shell am startservice -n com.example.controler/com.example.controler.MyService  
(这个命令不需要先启动app，但是广播有bug,会接收不到，原因未知)  
adb shell am start-foreground-service -n com.example.controler/com.example.controler.MyService  

额外知识点：  
1、调节音量需要勿扰模式权限 android.permission.ACCESS_NOTIFICATION_POLICY  
2、要先申请且同意勿扰模式权限，才能控制音量  
