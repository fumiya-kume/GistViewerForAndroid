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
  [](https://twitter.com/new_runnable/status/1052932598316466177)
- ViewModel
- LiveData
- Kotlin Coroutine
- Moshi
- JUnit
- glide
- koin
- Fuel
- 

# 図解してみる

![001](https://user-images.githubusercontent.com/16269075/47306462-80761d00-d667-11e8-90c7-ce06d5321c80.png)
![002](https://user-images.githubusercontent.com/16269075/47306463-80761d00-d667-11e8-9ba2-41c03da8574b.png)
![003](https://user-images.githubusercontent.com/16269075/47306464-810eb380-d667-11e8-8204-20c17e6e2046.png)
![004](https://user-images.githubusercontent.com/16269075/47306466-810eb380-d667-11e8-970b-4ba134d13338.png)
![005](https://user-images.githubusercontent.com/16269075/47306467-810eb380-d667-11e8-8c18-8aaf68305aaa.png)
![006](https://user-images.githubusercontent.com/16269075/47306468-810eb380-d667-11e8-9fbb-608f03526e4d.png)
![007](https://user-images.githubusercontent.com/16269075/47306469-81a74a00-d667-11e8-8c19-e952f3634068.png)
![008](https://user-images.githubusercontent.com/16269075/47306470-81a74a00-d667-11e8-946a-020c8fe0bc42.png)

# 詳細なスライドについて

https://www.icloud.com/keynote/0pkcSrb4Xhhbv6e_ntoVHv3Jw
