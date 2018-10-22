[![Build Status](https://kuxu.visualstudio.com/GistViewerForAndroid/_apis/build/status/GistViewerForAndroid-Android-CI)](https://kuxu.visualstudio.com/GistViewerForAndroid/_build/latest?definitionId=5)

# 頑張ったところをリストアップしてみる

- マルチモジュールを基本としたアプリ設計
- 内部設計は、 MVVM + Clean Architecture + α
- JetPack(AAC) の積極的導入と活用
- 内部でのメッセージング、非同期処理のつらみ解消のために Rx + Kotlin Coroutine の活用
- 画面遷移は 1Activity, Multi Fragment、jetPack の Navigatiion Component の活用
- (あまり書けなかったけど) JUniit + Mockito + Spek での単体テストの記述

# 利用しているライブラリ一覧

- RxJava
- Navigation Component
- Safe Args
  takahirom さんがツイートしてたこのライブラリですね。
  https://twitter.com/new_runnable/status/1052932598316466177
- ViewModel
- LiveData
- Kotlin Coroutine
- Moshi
- JUnit
- glide
- koin
- Fuel

# 実装したアプリの機能

## ホーム画面

## Gist 投稿画面

## Gist　詳細画面

# 動かす時の注意点

```
Callback を
gist-viewer://login
に指定したアプリの
 clientId,clientSercret を入れてください
 入れる場所等は下記の画像にて解説してあります。
 ```

# 図解してみる
![001](https://user-images.githubusercontent.com/16269075/47307326-bddbaa00-d669-11e8-9ec5-831e6f9446cd.png)
![002](https://user-images.githubusercontent.com/16269075/47307327-bddbaa00-d669-11e8-84b0-30e59d044559.png)
![003](https://user-images.githubusercontent.com/16269075/47307328-be744080-d669-11e8-959f-dd4ebd3c19bd.png)
![004](https://user-images.githubusercontent.com/16269075/47307329-be744080-d669-11e8-9c53-5110ee37ee3f.png)
![005](https://user-images.githubusercontent.com/16269075/47307330-be744080-d669-11e8-9242-1e50d6bcfffc.png)
![006](https://user-images.githubusercontent.com/16269075/47307331-be744080-d669-11e8-93c6-c53af3729f72.png)
![007](https://user-images.githubusercontent.com/16269075/47307333-bf0cd700-d669-11e8-96bf-05e951c63215.png)
![008](https://user-images.githubusercontent.com/16269075/47307334-bf0cd700-d669-11e8-8d55-8b876b50d803.png)


# 詳細なスライドについて

https://www.icloud.com/keynote/0pkcSrb4Xhhbv6e_ntoVHv3Jw
