## はじめに
Ktorで作成したWebアプリケーションをherokuにデプロイするサンプルプロジェクトです。  
公式HPのherokuクイックスタートアップはビルドツールにMavenを使用していますが、こちらではGradleを使用します。

## 事前準備
・Java8、Gradle、herokuCliをinstallしておく  
参考：https://jp.ktor.work/servers/deploy/hosting/heroku.html  

・herokuのアカウントを作成する
https://jp.heroku.com/

## 共通設定
  
・.envファイルを作成  
```
vi .env
```
```
// 環境名。[local || production]
ENV=
// localの場合…[ HOST:localhost , PORT:5432, NAME:[yourDB] , USER:[yourDBUser] , PASSWORD:[youDBPassword]
// productionの場合…作成したherokuアプリが自動設定したDB情報を取得して設定する(後述)
DATABASE_HOST=  
DATABASE_PORT=  
DATABASE_NAME=  
DATABASE_USER=  
DATABASE_PASSWORD=  
```

## ローカル実行
### ローカルDBの準備
・PostgreSQLをinstall  
```
brew install postgresql
initdb /usr/local/var/postgres -E utf8
```
・PostgreSQLを起動
```
brew services start postgresql
```
・ユーザー作成
```
createuser -P [your-new-user]
```
・データベース作成
```
createdb [your-DB-name] -O [your-new-user]
psql -l
```
### Gradleビルド
```
gradle build
```
### 実行
```
heroku local:start
```

## herokuデプロイ
## Fat Jar作成
```
./gradrew shadowJar  
```
### heroku設定
```
// herokuにアプリ作成  
heroku create  
// shadowJarを使用を指定  
heroku config:set GRADLE_TASK="shadowJar"  
// herokuのDB情報を確認し.envを設定  
heroku pg:credentials:url --app [your-app-name] 
// herokuに.envの内容を反映  
heroku config:push  

### herokuデプロイ実行
git push heroku master
