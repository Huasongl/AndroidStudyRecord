# Android SDK versions 

## The common API
  
- API 21 -> 5.0
- API 28 -> 9.0

## minSdkVersion

- 最低版本指定 Android 系统允许安装应用的最低版本

## targetSdkVersion 

- 目标版本指定 Android 应用为哪一个API级别设计的

## compileSdkVersion

- 编译版本指定引入的库的版本 

## 安全的添加新版本的代码

- 编写API级别的判断代码，如果当前系统版本大于等于应用调用的API版本，则使用API代码，否者使用旧版的代码

## 挑战练习：报告编译版本 

## 挑战练习：限制作弊次数