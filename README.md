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
- Gist の名前を確認できる
- Gist に含まれるファイル名を確認できる
- Gist がお気に入り登録されているか確認できる
- Gist をタップをするとGist 詳細画面へ遷移することができる
- 右下のFAB からGist 投稿画面へ遷移できる

## Gist 投稿画面
- Gist のタイトルをつけることができる
- Gist のファイルをタイトルとコンテンツをつけて追加することができる
- 投稿することができる
- 投稿する時・ファイル追加時に空欄だったりすると警告表示をすることができる

## Gist　詳細画面
- 読み込み中はProgressRing を表示することができる
- お気に入り状態を確認することができる
- お気に入り状態を編集することができる
- 投稿者の名前を確認することができる
- 投稿日時を確認することができる
- Gist のファイルサイズを確認することができる

# 動かす時の注意点

```
Callback を
gist-viewer://login
に指定したアプリの
 clientId,clientSercret を入れてください
 入れる場所等は下記の画像にて解説してあります。
 ```

# 図解してみる
![001](https://user-images.githubusercontent.com/16269075/47329748-db803200-d6b0-11e8-8276-ad3db00fe705.jpeg)
![002](https://user-images.githubusercontent.com/16269075/47329751-db803200-d6b0-11e8-8ef3-f2d4abd24bad.jpeg)
![003](https://user-images.githubusercontent.com/16269075/47329752-dc18c880-d6b0-11e8-861e-bc45dcfd4061.jpeg)
![004](https://user-images.githubusercontent.com/16269075/47329754-dc18c880-d6b0-11e8-836d-2f9f20757541.jpeg)
![005](https://user-images.githubusercontent.com/16269075/47329755-dc18c880-d6b0-11e8-8df2-4afd5d5b1dd1.jpeg)
![006](https://user-images.githubusercontent.com/16269075/47329756-dc18c880-d6b0-11e8-8261-35a8c426aaf1.jpeg)
![007](https://user-images.githubusercontent.com/16269075/47329758-dcb15f00-d6b0-11e8-9449-17506d2f08ab.jpeg)
![008](https://user-images.githubusercontent.com/16269075/47329759-dcb15f00-d6b0-11e8-94fc-fcc5e8d6decc.jpeg)
![009](https://user-images.githubusercontent.com/16269075/47329760-dcb15f00-d6b0-11e8-8958-788b5480583c.jpeg)



# 詳細なスライドについて

https://www.icloud.com/keynote/0pkcSrb4Xhhbv6e_ntoVHv3Jw
