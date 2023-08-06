# 『Javaによるアルゴリズム事典』サポートページ

![book cover](https://oku.edu.mie-u.ac.jp/~okumura/java-algo/java-algo.png)

[奥村晴彦](/~okumura/)， [首藤一幸](http://www.shudo.net/)，
[杉浦方紀](http://www.ceres.dti.ne.jp/~sugiura/)，
[土村展之](http://www.nn.iij4u.or.jp/~tutimura/)，
[津留和生](http://www.vector.co.jp/authors/VA018507/index.html)，
[細田隆之](http://www.finetune.co.jp/~lyuka/)， 松井吉光，
[光成滋生](http://homepage1.nifty.com/herumi/)
『Javaによるアルゴリズム事典』
（[技術評論社](http://www.gihyo.co.jp/)，2003年，ISBN4-7741-1729-3，2580円＋税）
のサポートページです。

-   技術評論社の
    [Javaによるアルゴリズム事典](http://www.gihyo.co.jp/books/syoseki.php/4-7741-1729-3)
    のページ

## ソースコードのダウンロード

-   [00README.txt](https://oku.edu.mie-u.ac.jp/~okumura/java-algo/archive/00README.txt)
-   [java-algo.zip](https://oku.edu.mie-u.ac.jp/~okumura/java-algo/archive/java-algo.zip) (約320K，Shift JIS / CRLF)
-   [java-algo.tar.bz2](https://oku.edu.mie-u.ac.jp/~okumura/java-algo/archive/java-algo.tar.bz2) (約130K，EUC-JP / LF)

### 更新記録

-   \[2003-05-09\] 公開
-   \[2003-05-12\] BDCbrt.java, BDSqrt.java, BDtoE_Form.java,
    BinarySplitE.java, BinarySplitPi1.java, BinarySplitPi2.java
    のコメントを修正しました
-   \[2003-06-07\] NormalRandom.java 修正（→サポート情報の「p.154」）
-   \[2003-08-09\] Lagrange.java 修正（→サポート情報の「p.423」）
-   \[2003-08-09\] CfInt.java 修正 ［本文（p.347）では「*y*
    の値が等しい点があると使えない」と書きながら，ソース集には *y*
    が等しい例が書かれています (Thanks: 丸山さん)。Javaでは 0.0
    で割るとエラーではなく Infinity
    になり，この場合は結果的にうまくいきますが，常にうまくいくわけではありません。］
-   \[2003-08-16\] Newton.java 修正
    (本に載っているリストは正しいものです)
-   \[2003-11-03\] アーカイブ中の CMatrix，GJMatInv，LUMatInv，UTMatInv
    のサンプルコードで配列自身を `System.out.println()`
    しているというバグを修正しました。
-   \[2006-04-04\] アーカイブ中の GJMatInv.java
    の19行目（本文p.45の10行目に相当）が微妙におかしくなっていましたので修正しました。
    本文は問題ありません (Thanks: 田村さん)
-   \[2006-11-21\] アーカイブ中の PinkNoise.java と PinkFilter.java
    を更新しました。

## サポート情報

pp.19-20「円周率」の項目で相加相乗平均を使う方法の解説

:   a~1~ = 1, b~1~ = ...... → a~0~ = 1, b~0~ = ......\
    なお，式の第3辺の和で k = 0 の項だけは第2辺の流儀で計算します。
    あるいは次のように変形してもかまいません。

              \[
              \pi_n = \frac{2a_{n+1}^2}{1 - \sum_{k=0}^{n}2^{k}(a_{k}^{2} - b_{k}^{2})}
                    = \frac{4a_{n+1}^2}{1 - 2\sum_{k=1}^{n}2^{k}(a_{k} - a_{k-1})^{2}}
              \]
              

    (Thanks: 岡本さん)

p.84 GCDandLCM.java 10行目
:   `while ((Math.abs(t) % 2) != 0) t /= 2;` の `!=` は `==`
    の誤植です。 ソース集は正しくなっています (Thanks: 篠田さん)

p.89 PinkNoise.java 15-16行目（とプログラム上の解説）

:   ピンクノイズはパワースペクトルが1/fに比例するのですから，振幅は1/sqrt(f)に比例しなければなりません。
    単純なミスでした。ご指摘いただきました読者のくぼ
    まさお様と著者陣の細田さんに感謝いたします。
    プログラム15-16行目は次のようになります：

        double scale = 1.0 / Math.sqrt(i);
        x[i] *= scale;  x[N-i] *= scale;
        y[i] *= scale;  y[N-i] *= scale;
              

p.154 NormalRandom.javaリスト34行目
:   `s > 1` は `s >= 1` のほうが良い。 ぴったり *s* = 1
    になる場合を通すと，0 が2回続いて現れるので，気持ちが悪い (Thanks:
    工藤さん)

p.191 図
:   右上の *-R* のマイナスが印刷段階で抜けてしまいました
    (どうしてTeXなのに印刷段階で誤植が？
    答えは『pLaTeX2e美文書作成入門』次版にて)

p.267，11-12行目
:   `return imag` は `return Math.abs(imag)`
    であるべきです。`return real` も同様です (Thanks: 小澤さん)

p.298，1行目
:   反値幅→半値幅 (Thanks: 丸山さん)

p.389 下の式
:   c63=192 → c61=192 (Thanks: 中島さん)

p.407 下6
:   復号同順→複号同順

p.423 Lagrange.java 13行目
:   `+=` → `*=` (Thanks: 丸山さん)

## 追記

p.40 騎士巡歴の問題
:   8×8盤面で騎士の道順に沿って1～64の番号を降って魔方陣を作ることはできないことがわかりました。\
    [Computing Magic Knight Tours](http://magictour.free.fr/)\
    [There Are No Magic Knight\'s Tours on the
    Chessboard](http://mathworld.wolfram.com/news/2003-08-06/magictours/)
    (MathWorld)

p.66 組合せの生成
:   山田さんが
    [BitSetを使った実装](http://www.gulf.or.jp/~damayan/algo/permcomb.html)
    を公開されています

p.413 ISBNコード
:   2007年にISBNコードはチェックディジットの計算法も含め改訂されます：
    ＩＳＢＮ規格改定のお知らせ（リンク先がサラ金のサイトになっていたのでリンクを外しました。ご指摘ありがとうございます）

## 著者・編集者への連絡方法


![maito](https://oku.edu.mie-u.ac.jp/~okumura/java-algo/to.gif}


お気づきのことがありましたら右のアドレスまでメールでご連絡いただければ幸いです（ジャンクメール屋にアドレスを自動収集されないように画像にしています）：

ご質問については必ずしもお答えできるとは限りません。
特にプログラミングの相談・個人指導はご容赦ください。

------------------------------------------------------------------------

[奥村晴彦](/~okumura/)

Last modified: 2020-09-15 16:53:47+09:00
